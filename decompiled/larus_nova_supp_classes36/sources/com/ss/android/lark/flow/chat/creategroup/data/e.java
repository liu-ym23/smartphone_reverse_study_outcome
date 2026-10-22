package com.ss.android.lark.flow.chat.creategroup.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final /* synthetic */ int f = 0;
    public final boolean a;
    public final boolean b;
    public final long c;
    public final String d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        long r5 = this.c;
        int r6 = (((r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + this.d.hashCode()) * 31;
        if (this.e == true) goto L15;
        r1 = 1237;
    L15:
        return r6 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowGroupCreateUserRelation(isFriend=" + this.a + ", requestUserApply=" + this.b + ", requestUserApplyId=" + this.c + ", requestUserApplyReason=" + this.d + ", targetUserApply=" + this.e + ')';
    }

    public e(boolean r2, boolean r3, long r4, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "requestUserApplyReason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
