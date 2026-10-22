package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ TuningMusicControlContainer a;

    public b(TuningMusicControlContainer r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewGroup, com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view.TuningMusicControlContainer] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ?? r3 = this.a;
        ec0.a r0 = r3.a;
        if (r0 == null) goto L6;
        r0.s(r3.getContext());
        return;
    }
}
