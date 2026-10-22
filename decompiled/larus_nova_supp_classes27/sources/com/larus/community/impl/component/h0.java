package com.larus.community.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationFeedComponentLayoutBinding;
import com.larus.community.impl.databinding.LarusCommunityCreationFeedComponentLayoutNoRefreshBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 {
    public LarusCommunityCreationFeedComponentLayoutBinding a;
    public LarusCommunityCreationFeedComponentLayoutNoRefreshBinding b;

    public h0() {
    }

    public final RecyclerView a() {
        LarusCommunityCreationFeedComponentLayoutBinding r0 = this.a;
        if (r0 == null) goto L6;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L6;
        return r1;
    L6:
        LarusCommunityCreationFeedComponentLayoutNoRefreshBinding r2 = this.b;
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.b;
    }

    public final SwipeRefreshLayout b() {
        LarusCommunityCreationFeedComponentLayoutBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }
}
