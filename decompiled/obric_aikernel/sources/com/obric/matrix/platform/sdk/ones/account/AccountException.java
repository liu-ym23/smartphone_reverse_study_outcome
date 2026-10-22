package com.obric.matrix.platform.sdk.ones.account;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountException extends Exception {
    private final int code;
    private final String msg;

    @JvmOverloads
    public AccountException(int r10) {
        this(r10, null, null, 6, null);
    }

    @JvmOverloads
    public AccountException(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        this(r10, r11, null, 4, null);
    }

    @JvmOverloads
    public AccountException(int r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        super(r12);
        this.code = r10;
        this.msg = r11;
    }

    public /* synthetic */ AccountException(int r10, String r11, Throwable r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = "";
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "code: " + this.code + ", msg: " + this.msg + ", cause: " + getCause();
    }
}
