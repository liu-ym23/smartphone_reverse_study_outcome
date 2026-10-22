package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 a;

    public t(LiveOpenFeatureSearchFragmentV3 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        EditText r3 = this.a.l;
        if (r3 == null) goto L6;
        r3.setText("");
        return;
    }
}
