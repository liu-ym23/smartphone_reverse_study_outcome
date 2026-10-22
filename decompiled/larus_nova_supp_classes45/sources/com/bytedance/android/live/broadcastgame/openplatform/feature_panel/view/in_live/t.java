package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements TextView.OnEditorActionListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragment a;

    public t(LiveOpenFeatureSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L5;
    L16:
        LiveOpenFeatureSearchFragment r4 = this.a;
        int r5 = LiveOpenFeatureSearchFragment.l;
        r4.V90();
        return true;
    L5:
        if (r2 == 4) goto L16;
        if (r2 == 6) goto L16;
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r3.getAction() == 0) goto L12;
        return false;
    L12:
        if (r3.getKeyCode() == 66) goto L16;
        return false;
    }
}
