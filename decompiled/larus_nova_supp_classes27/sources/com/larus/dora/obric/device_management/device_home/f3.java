package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f3 {
    public final DoraObricGlassesMode a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f3) == true) goto L9;
        return false;
    L9:
        if (this.a == ((f3) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DoraObricGlassesModeSheetState(selectedMode=" + this.a + ')';
    }

    public f3(DoraObricGlassesMode r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedMode");
        this.a = r2;
    }
}
