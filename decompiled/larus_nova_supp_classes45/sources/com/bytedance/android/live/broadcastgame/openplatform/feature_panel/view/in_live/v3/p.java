package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 a;

    public p(LiveOpenFeatureSearchFragmentV3 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        int r3 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(this.a.getContext(), this.a.l);
        if (((k81) ft0.a.getValue()).f() == false) goto L9;
        FragmentManager r4 = this.a.getFragmentManager();
        if (r4 == null) goto L13;
        FragmentTransaction r5 = r4.beginTransaction();
        if (r5 == null) goto L14;
        r5.remove(this.a);
        r5.commitAllowingStateLoss();
        return;
    L14:
        return;
    L13:
        return;
    L9:
        FragmentManager r6 = this.a.getFragmentManager();
        if (r6 == null) goto L16;
        r6.popBackStack();
        return;
    }
}
