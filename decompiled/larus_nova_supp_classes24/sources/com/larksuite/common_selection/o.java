package com.larksuite.common_selection;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o {
    public final View a;
    public final int b;

    public o() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        View r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectionPoint(view=" + this.a + ", index=" + this.b + ')';
    }

    public /* synthetic */ o(int r2) {
        this(null, 0);
    }

    public o(View r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
