package com.larus.dora.obric.utils;

import android.view.View;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ OFloatingTitleBar a;
    public final /* synthetic */ View b;

    public /* synthetic */ b(OFloatingTitleBar r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OFloatingTitleBar r0 = this.a;
        OUIFrameLayout r1 = this.b;
        OButtonGroup r2 = r0.getStartButtonGroup();
        q r3 = q.h;
        r2.c(r3, r3, true);
        if ((r1 instanceof OUIFrameLayout) == false) goto L5;
        OUIFrameLayout r4 = r1;
    L6:
        if (r4 == null) goto L9;
        r4.c(r3, r3, true);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
