package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragment a;

    public w(LiveOpenFeatureSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ((EditText) this.a.S90(2131385411)).setText("");
    }
}
