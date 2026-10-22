package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class h extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12579m;

    public h(s r5) {
        super(r5);
        if ((r5 instanceof m) == false) goto L5;
        this.e = DependencyNode$Type.HORIZONTAL_DIMENSION;
        return;
    L5:
        this.e = DependencyNode$Type.VERTICAL_DIMENSION;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.g
    public final void d(int r5) {
        if (this.f12576j == false) goto L5;
        return;
    L5:
        this.f12576j = true;
        this.g = r5;
        Iterator r10 = this.f12577k.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        e r11 = (e) r10.next();
        r11.a(r11);
        goto L7
    }
}
