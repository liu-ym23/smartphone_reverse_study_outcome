package com.bytedance.android.livesdk.feed;

import android.view.View;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p0 implements View.OnClickListener {
    public final /* synthetic */ LiveDrawerFeedPageFragment a;

    public p0(LiveDrawerFeedPageFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        IDrawerFeedAction r4 = this.a.x;
        if (r4 == null) goto L5;
        r4.enterHistory();
    L5:
        LiveDrawerFeedPageFragment r5 = this.a;
        r5.A.storeBoolean(r5.z, true);
        View r6 = this.a.m;
        if (r6 == null) goto L8;
        r6.setVisibility(8);
    L8:
        this.a.dismissPopView();
    }
}
