package com.zte.miboard.cards.express.more;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExpressMoreActivty f16338b;

    public /* synthetic */ a(ExpressMoreActivty r5, int r10) {
        this.f16337a = r10;
        this.f16338b = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        int r10 = this.f16337a;
        ExpressMoreActivty r11 = this.f16338b;
        switch(r10) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ExpressMoreActivty.j(r11, r5);
        return;
    L6:
        ExpressMoreActivty.k(r11, r5);
        return;
    L8:
        ExpressMoreActivty.i(r11, r5);
    }
}
