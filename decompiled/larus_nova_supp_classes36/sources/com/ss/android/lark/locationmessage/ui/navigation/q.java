package com.ss.android.lark.locationmessage.ui.navigation;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ NavigateView a;

    public q(NavigateView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        NavigateView r4 = this.a;
        String[] r0 = NavigateView.p;
        r4.getClass();
        com.larksuite.component.ui.dialog.i r1 = new com.larksuite.component.ui.dialog.i(r4.b);
        r1.n(r4.n);
        r1.m(2131563582);
        ((com.larksuite.component.ui.dialog.b) r1).f = new v(r4);
        r1.i();
    }
}
