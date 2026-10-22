package com.bytedance.android.livesdk.gift.platform.format.service;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final long a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final Map<String, String> i;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L24;
        a r7 = (a) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31;
        String r2 = this.d;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.e;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.f;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (((r8 + r10) * 31) + this.g) * 31;
        String r13 = this.h;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r11 + r14) * 31;
        Map<String, String> r16 = this.i;
        if (r16 == null) goto L22;
        r3 = r16.hashCode();
    L22:
        return r15 + r3;
    L17:
        r14 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "FormatGiftInfo(giftId=" + this.a + ", diamond=" + this.b + ", sendCount=" + this.c + ", toUserId=" + this.d + ", requestPage=" + this.e + ", giftSourceLog=" + this.f + ", buffLevel=" + this.g + ", giftShowFrom=" + this.h + ", sendGiftLog=" + this.i + ")";
    }

    public a(long r2, int r4, int r5, String r6, String r7, String r8, int r9, String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        Intrinsics.checkNotNullParameter(r8, "giftSourceLog");
        Intrinsics.checkNotNullParameter(r10, "giftShowFrom");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
