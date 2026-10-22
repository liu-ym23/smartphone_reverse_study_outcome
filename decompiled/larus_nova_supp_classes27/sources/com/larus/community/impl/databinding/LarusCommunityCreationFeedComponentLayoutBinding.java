package com.larus.community.impl.databinding;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCommunityCreationFeedComponentLayoutBinding implements ViewBinding {
    public final SwipeRefreshLayout a;
    public final RecyclerView b;
    public final SwipeRefreshLayout c;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommunityCreationFeedComponentLayoutBinding(SwipeRefreshLayout r1, RecyclerView r2, SwipeRefreshLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
