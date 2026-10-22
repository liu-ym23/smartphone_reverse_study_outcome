package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ DrawerFollowViewHolder a;
    public final /* synthetic */ FeedItem b;

    public n(DrawerFollowViewHolder r1, FeedItem r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        DrawerFollowViewHolder r3 = this.a;
        FeedItem r0 = this.b;
        if (r0 == null) goto L5;
        ScheduledLiveItem r1 = r0.scheduledLive;
    L6:
        DrawerFollowViewHolder.T3(r3, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
