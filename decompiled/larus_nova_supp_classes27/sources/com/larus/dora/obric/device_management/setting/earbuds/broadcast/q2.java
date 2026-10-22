package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.sheet.v2.OSheetTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q2 {
    public final OSheetTitleBar a;
    public final OIconButtonFloating b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q2) == true) goto L8;
        return false;
    L8:
        q2 r6 = (q2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DoraObricEarbudsSheetTitleBar(view=" + this.a + ", confirmButton=" + this.b + ')';
    }

    public q2(OSheetTitleBar r2, OIconButtonFloating r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "confirmButton");
        this.a = r2;
        this.b = r3;
    }
}
