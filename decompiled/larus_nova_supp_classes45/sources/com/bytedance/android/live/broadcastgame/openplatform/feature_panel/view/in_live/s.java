package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragment a;

    public s(LiveOpenFeatureSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(this.a.getContext(), this.a.S90(2131385411));
        if (((k81) ft0.a.getValue()).f() == false) goto L9;
        FragmentManager r5 = this.a.getFragmentManager();
        if (r5 == null) goto L13;
        FragmentTransaction r6 = r5.beginTransaction();
        if (r6 == null) goto L14;
        r6.remove(this.a);
        r6.commitAllowingStateLoss();
        return;
    L14:
        return;
    L13:
        return;
    L9:
        FragmentManager r7 = this.a.getFragmentManager();
        if (r7 == null) goto L16;
        r7.popBackStack();
        return;
    }
}
