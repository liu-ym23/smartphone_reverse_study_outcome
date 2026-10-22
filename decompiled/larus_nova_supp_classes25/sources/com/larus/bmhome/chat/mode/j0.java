package com.larus.bmhome.chat.mode;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j0 implements View.OnClickListener {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ int b;

    public /* synthetic */ j0(l0 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.f(this.b, true);
    }
}
