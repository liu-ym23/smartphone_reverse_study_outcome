package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v implements View.OnFocusChangeListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragment a;

    public v(LiveOpenFeatureSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r3, boolean r4) {
        if (r4 == true) goto L5;
        ((ImageView) this.a.S90(2131366949)).setVisibility(4);
        return;
    L5:
        if (((EditText) this.a.S90(2131385411)).getText().length() != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        ((ImageView) this.a.S90(2131366949)).setVisibility(4);
        return;
    L10:
        ((ImageView) this.a.S90(2131366949)).setVisibility(0);
        return;
    L7:
        r5 = false;
        goto L8
    }
}
