package com.bytedance.android.livesdk.feed.ui;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FixEmptyItemInStaggeredLayoutScrollListener extends RecyclerView.OnScrollListener {
    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        super.onScrollStateChanged(r1, r2);
        StaggeredGridLayoutManager r3 = r1.getLayoutManager();     // Catch: Exception -> L8
        if ((r3 instanceof StaggeredGridLayoutManager) == true) goto L6;
        return;
    L6:
        r3.findFirstVisibleItemPositions(null);     // Catch: Exception -> L8
        throw null;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
