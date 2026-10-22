package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 a;

    public u(LiveOpenFeatureSearchFragmentV3 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.r.a.clear();
        this.a.r.notifyDataSetChanged();
        TextView r3 = this.a.d;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }
}
