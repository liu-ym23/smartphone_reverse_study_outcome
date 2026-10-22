package com.larus.bot.impl.feature.edit.feature.autofill;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final wu8.a a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AutoFillUIState(autoFillBtnUIState=" + this.a + ')';
    }

    public c(wu8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "autoFillBtnUIState");
        this.a = r2;
    }
}
