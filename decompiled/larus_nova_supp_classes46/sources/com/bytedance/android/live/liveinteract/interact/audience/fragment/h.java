package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.view.View;
import com.bytedance.android.livesdk.widget.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ InteractAudienceContainerFragment a;

    public h(InteractAudienceContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        InteractAudienceContainerFragment r6 = this.a;
        int r0 = InteractAudienceContainerFragment.s;
        r6.getClass();
        x0.b r1 = new x0.b(r6.getContext(), 0);
        r1.a.a = 5;
        r1.m(2131923159);
        r1.l(2131923160);
        r1.setCornerRadius(2.0f);
        r1.i(0, 2131923155, new j(r6));
        r1.i(1, 2131915442, new i());
        r1.a.k = false;
        r1.n();
        this.a.d.dismiss();
    }
}
