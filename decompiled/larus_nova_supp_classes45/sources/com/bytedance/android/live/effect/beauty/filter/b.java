package com.bytedance.android.live.effect.beauty.filter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LiveComposerFilterFragment a;

    public b(LiveComposerFilterFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        LiveComposerFilterFragment r4 = this.a;
        int r0 = LiveComposerFilterFragment.q;
        LiveComposerFilterHelper r5 = r4.U90();
        LiveComposerFilterFragment r1 = this.a;
        r5.d(r1.l, r1.o);
    }
}
