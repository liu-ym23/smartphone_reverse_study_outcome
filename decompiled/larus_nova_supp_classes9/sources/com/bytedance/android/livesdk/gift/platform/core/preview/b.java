package com.bytedance.android.livesdk.gift.platform.core.preview;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final long a;
    public final long b;
    public final String c;
    public final int d;
    public final k e;
    public boolean f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L18;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (((r2 + r6) * 31) + this.d) * 31;
        k r8 = this.e;
        if (r8 == null) goto L9;
        r5 = r8.hashCode();
    L9:
        int r9 = (r7 + r5) * 31;
        boolean r10 = this.f;
        ?? r11 = r10;
        if (r10 == false) goto L13;
        r11 = 1;
    L13:
        return r9 + r11;
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftStruct(id=" + this.a + ", primaryEffectId=" + this.b + ", name=" + this.c + ", diamondCount=" + this.d + ", image=" + this.e + ", selected=" + this.f + ")";
    }

    public b(long r2, long r4, String r6, int r7, k r8) {
        Intrinsics.checkNotNullParameter(r6, "name");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = false;
    }
}
