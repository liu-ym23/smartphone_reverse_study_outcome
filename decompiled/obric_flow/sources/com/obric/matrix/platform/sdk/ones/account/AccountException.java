package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/AccountException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "msg", "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "toString", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountException extends Exception {
    private final int code;
    private final String msg;

    @JvmOverloads
    public AccountException(int r10) {
        String r5 = null;
        Throwable r11 = null;
        this(r10, r5, r11, 6, null);
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

    @JvmOverloads
    public AccountException(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        Throwable r5 = null;
        this(r10, r11, r5, 4, null);
    }

    public /* synthetic */ AccountException(int r5, String r10, Throwable r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = "";
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = null;
    L8:
        this(r5, r10, r11);
    }

    @JvmOverloads
    public AccountException(int r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        super(r11);
        this.code = r5;
        this.msg = r10;
    }
}
