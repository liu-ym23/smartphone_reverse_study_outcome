package com.bytedance.android.live.liveinteract.awemeplay.view;

import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ LiveVideoCommentSelectPanelAwemeListFragment a;

    public g(LiveVideoCommentSelectPanelAwemeListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        VideoTab r4 = (VideoTab) r3;
        LiveVideoCommentSelectPanelAwemeListFragment r0 = this.a;
        if (r0.p == false) goto L5;
        r0.T90(r4);
        return;
    L5:
        r0.q = r4;
    }
}
