package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t5 {
    public final boolean a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t5) == true) goto L8;
        return false;
    L8:
        t5 r6 = (t5) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "SubmitAnnotationResult(accepted=" + this.a + ", message=" + this.b + ')';
    }

    public t5(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a = r2;
        this.b = r3;
    }
}
