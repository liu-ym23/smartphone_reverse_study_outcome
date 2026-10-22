package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final int a;
    public final py.k b;
    public int c;
    public final String d;
    public final long e;
    public final String f;
    public final long g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L20;
        d r7 = (d) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        py.k r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + this.c) * 31;
        String r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        long r7 = this.e;
        int r8 = (((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.f;
        if (r9 == null) goto L13;
        r2 = r9.hashCode();
    L13:
        int r10 = (r8 + r2) * 31;
        long r11 = this.g;
        return r10 + ((int) (r11 ^ (r11 >>> 32)));
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "CrossRoomTrayData(price=" + this.a + ", icon=" + this.b + ", comboCount=" + this.c + ", toUserId=" + this.d + ", giftId=" + this.e + ", toRoomId=" + this.f + ", duration=" + this.g + ")";
    }

    public d(int r2, py.k r3, int r4, String r5, long r6, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r3, "icon");
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        Intrinsics.checkNotNullParameter(r8, "toRoomId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
    }
}
