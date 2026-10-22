package com.obric.aikernel.model.cloud.common;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("code")
    private final int f4649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c(NotificationCompat.CATEGORY_MESSAGE)
    private final String f4650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d6.c(WsConstants.KEY_PAYLOAD)
    private final String f4651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c("data")
    private final T f4652d;

    public a() {
        this(0, null, null, null, 15, null);
    }

    public a(int r10, String r11, String r12, T r13) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r12, WsConstants.KEY_PAYLOAD);
        this.f4649a = r10;
        this.f4650b = r11;
        this.f4651c = r12;
        this.f4652d = r13;
    }

    public /* synthetic */ a(int r10, String r11, String r12, Object r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = "";
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }

    public final int a() {
        return this.f4649a;
    }

    public final T b() {
        return this.f4652d;
    }

    public final String c() {
        return this.f4650b;
    }

    public final boolean d() {
        if (this.f4649a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f4649a == r11.f4649a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4650b, r11.f4650b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4651c, r11.f4651c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f4652d, r11.f4652d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r10 = ((((Integer.hashCode(this.f4649a) * 31) + this.f4650b.hashCode()) * 31) + this.f4651c.hashCode()) * 31;
        T r11 = this.f4652d;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "CommonHttpResponse(code=" + this.f4649a + ", msg=" + this.f4650b + ", payload=" + this.f4651c + ", data=" + this.f4652d + ')';
    }
}
