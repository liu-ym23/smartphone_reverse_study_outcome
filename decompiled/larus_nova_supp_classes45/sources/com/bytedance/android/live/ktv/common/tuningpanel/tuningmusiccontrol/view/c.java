package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ TuningMusicControlContainer a;

    public c(TuningMusicControlContainer r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        ec0.a r2 = this.a.a;
        if (r2 == null) goto L6;
        r2.i();
        return;
    }
}
