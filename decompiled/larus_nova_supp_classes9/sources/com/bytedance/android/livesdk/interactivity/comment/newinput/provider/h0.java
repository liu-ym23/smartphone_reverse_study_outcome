package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 implements View.OnClickListener {
    public final /* synthetic */ InterestSectionProvider.InterestPanelController a;

    public h0(InterestSectionProvider.InterestPanelController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.i();
        com.bytedance.android.livesdk.interactivity.comment.utils.i.a(null, false, false);
    }
}
