package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0 {
    public final boolean a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;

    public f0() {
        this(false, 0, "", null, "");
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f0) == false) goto L16;
        f0 r4 = (f0) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.b) * 31;
        String r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L17;
        r4 = r10.hashCode();
    L17:
        return r9 + r4;
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "InnerDrawData(isDraw=" + this.a + ", drawType=" + this.b + ", url=" + this.c + ", reqFromSetting=" + this.d + ", sourceKey=" + this.e + ")";
    }

    public f0(boolean r2, int r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r6, "sourceKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
