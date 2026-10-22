package com.bytedance.android.live.lynx.ui.replay;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ReplayVideoViewForLynx a;

    public c(ReplayVideoViewForLynx r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ReplayVideoViewForLynx r3 = this.a;
        if (r3.w == false) goto L6;
        r3.d();
        return;
    }
}
