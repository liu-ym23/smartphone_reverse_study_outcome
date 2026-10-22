package com.bytedance.android.livesdk.feed;

import android.view.View;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n0 implements View.OnClickListener {
    public final /* synthetic */ LiveDrawerFeedPageFragment a;

    public n0(LiveDrawerFeedPageFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        IDrawerFeedAction r2 = this.a.x;
        if (r2 == null) goto L6;
        r2.closeDrawerDialog();
        return;
    }
}
