package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public final String a;
    public final View b;
    public final PanelItem c;

    public g() {
        this(null, null, null);
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof g) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.a, ((g) r2).a);
    }

    public g(String r1, View r2, PanelItem r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
