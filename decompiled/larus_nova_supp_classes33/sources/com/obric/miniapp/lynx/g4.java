package com.obric.miniapp.lynx;

import com.obric.oui.tab.OTabLayoutBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g4 implements OTabLayoutBase.e {
    public final /* synthetic */ LynxOUITabLayoutUI a;

    public final void b(OTabLayoutBase.i r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    public g4(LynxOUITabLayoutUI r1) {
        this.a = r1;
    }

    public final void a(OTabLayoutBase.i r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        LynxOUITabLayoutUI r0 = this.a;
        if (r0.c == false) goto L5;
        return;
    L5:
        LynxOUITabLayoutUI.N(r0, "reselect", r3);
    }

    public final void c(OTabLayoutBase.i r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        LynxOUITabLayoutUI r0 = this.a;
        if (r0.c == false) goto L5;
        return;
    L5:
        LynxOUITabLayoutUI.N(r0, "change", r3);
    }
}
