package com.obric.oui.panel;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OBasePanelDialog f13999a;

    public g(OBasePanelDialog r5) {
        this.f13999a = r5;
    }

    public final void a(View r5, float r10) {
        Iterator r11 = this.f13999a.f13978h.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((g) r11.next()).a(r5, r10);
        goto L4
    }

    public final void b(View r5, int r10) {
        OBasePanelDialog r11 = this.f13999a;
        Iterator r12 = r11.f13978h.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        ((g) r12.next()).b(r5, r10);
        goto L4
    L7:
        if (r10 != 5) goto L11;
        r11.cancel();
        return;
    }
}
