package com.bytedance.android.live.liveinteract.awemeplay.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ LiveVideoCommentSelectPanelAwemeListFragment a;

    public f(LiveVideoCommentSelectPanelAwemeListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        sd0.a r2 = (sd0.a) r1;
        MultiTypeAdapter r3 = this.a.n;
        if (r3 == null) goto L6;
        r3.notifyDataSetChanged();
        return;
    }
}
