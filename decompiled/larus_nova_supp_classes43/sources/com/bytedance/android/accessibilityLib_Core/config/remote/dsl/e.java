package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final h c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L12;
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        boolean r12 = this.b;
        ?? r13 = r12;
        if (r12 == false) goto L9;
        r13 = 1;
    L9:
        int r14 = (r11 + r13) * 31;
        h r15 = this.c;
        if (r15 == null) goto L13;
        r1 = r15.hashCode();
    L13:
        return r14 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "LabelDsl(label='" + this.a + "', direct=" + this.b + ", viewIdentifyDsl=" + this.c + ')';
    }

    public e(String r1, boolean r10, h r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
