package com.ss.android.lark.inline.ai.creationai;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ CreationAIPanelController a;

    public s(CreationAIPanelController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.m();
        CreationAIPanelController.e r3 = this.a.B;
        r3.c.e.removeCallbacks(r3.b);
        CreationAIPanelController r4 = this.a;
        r4.b.h(String.valueOf(r4.r.getText()));
        this.a.r.setText(null);
    }
}
