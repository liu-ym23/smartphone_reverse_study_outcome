package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCreationFeedComponentLayoutKmpBinding;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 {
    public LarusCommunityCreationFeedComponentLayoutKmpBinding a;
    public LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding b;

    public c0() {
    }

    public final RecyclerView a() {
        LarusCommunityCreationFeedComponentLayoutKmpBinding r0 = this.a;
        if (r0 == null) goto L6;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L6;
        return r1;
    L6:
        LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding r2 = this.b;
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.b;
    }

    public final SwipeRefreshLayout b() {
        LarusCommunityCreationFeedComponentLayoutKmpBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }
}
