package com.bytedance.android.livesdk.feed;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ LiveDrawerFeedPageFragment a;

    public s0(LiveDrawerFeedPageFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LiveDrawerFeedPageFragment.H.getClass();
        LiveDrawerFeedPageFragment.a.a(1);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_page_inspire_live_button_click", null, new Object[]{Room.class, am2.x.class});
        LiveDrawerFeedPageFragment.S90(this.a);
    }
}
