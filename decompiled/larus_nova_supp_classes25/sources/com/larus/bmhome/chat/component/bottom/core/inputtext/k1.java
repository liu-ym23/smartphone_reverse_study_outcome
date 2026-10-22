package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k1 {
    public final int a;
    public final int b;
    public final String c;
    public final MultiTypePanelTrigger d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k1) == true) goto L8;
        return false;
    L8:
        k1 r6 = (k1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "MultiTypePanelQueryRange(start=" + this.a + ", end=" + this.b + ", query=" + this.c + ", trigger=" + this.d + ')';
    }

    public k1(int r2, int r3, String r4, MultiTypePanelTrigger r5) {
        Intrinsics.checkNotNullParameter(r4, "query");
        Intrinsics.checkNotNullParameter(r5, "trigger");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
