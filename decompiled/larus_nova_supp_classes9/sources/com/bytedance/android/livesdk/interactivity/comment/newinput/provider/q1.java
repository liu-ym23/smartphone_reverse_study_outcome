package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q1 implements View.OnClickListener {
    public final /* synthetic */ TruthSectionProvider.TruthPanelController a;

    public q1(TruthSectionProvider.TruthPanelController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.h();
        com.bytedance.android.livesdk.interactivity.comment.utils.i.b(null, false, false);
    }
}
