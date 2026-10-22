package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ PanelBottomDialog a;
    public final /* synthetic */ g b;

    public c(PanelBottomDialog r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.i.contains(this.b) == false) goto L5;
        this.a.i.remove(this.b);
        PanelBottomDialog r0 = this.a;
        Intrinsics.checkNotNull(r4);
        r0.aa0(r4, false, this.b.c);
        return;
    L5:
        this.a.i.add(this.b);
        PanelBottomDialog r1 = this.a;
        Intrinsics.checkNotNull(r4);
        r1.aa0(r4, true, this.b.c);
    }
}
