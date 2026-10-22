package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragment a;

    public x(LiveOpenFeatureSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.k.a.clear();
        this.a.k.notifyDataSetChanged();
        ((TextView) this.a.S90(2131366935)).setVisibility(8);
    }
}
