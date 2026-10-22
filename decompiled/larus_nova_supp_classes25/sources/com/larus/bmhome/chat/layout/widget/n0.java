package com.larus.bmhome.chat.layout.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 {
    public final Boolean a;
    public final Boolean b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r6 = (n0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageCoverEditViewData(isShowAiVideo=" + this.a + ", isShowAiImageBeautify=" + this.b + ')';
    }

    public n0() {
        Boolean r0 = Boolean.FALSE;
        this(r0, r0);
    }

    public n0(Boolean r1, Boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
