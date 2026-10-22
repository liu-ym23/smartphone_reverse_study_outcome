package com.larus.dora.impl.dynamic.quicknote;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public final List<f59.a> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((k) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "QuickNoteUiState(itemUiStates=" + this.a + ')';
    }

    public k(List<f59.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemUiStates");
        this.a = r2;
    }
}
