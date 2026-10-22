package com.obric.assistant.special_input.instruction;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final boolean a;
    public final List<PanelInstructionItem> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        return "RefreshedPanelItems(hasUpdate=" + this.a + ", items=" + this.b + ')';
    }

    public d(boolean r2, List<PanelInstructionItem> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        this.a = r2;
        this.b = r3;
    }
}
