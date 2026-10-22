package com.bytedance.android.livesdk.feed;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FixEmptyItemInStaggeredLayoutScrollListener extends RecyclerView.OnScrollListener {
    public final int[] a;
    public final int[] b;
    public final int c;

    public FixEmptyItemInStaggeredLayoutScrollListener(int r2) {
        this.a = new int[r2];
        this.b = new int[r2];
        this.c = r2;
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        super.onScrollStateChanged(r3, r4);
        StaggeredGridLayoutManager r5 = r3.getLayoutManager();     // Catch: Exception -> L13
        if ((r5 instanceof StaggeredGridLayoutManager) == true) goto L6;
        return;
    L6:
        StaggeredGridLayoutManager r6 = r5;     // Catch: Exception -> L13
        r6.findFirstVisibleItemPositions(this.a);     // Catch: Exception -> L13
        if (this.a[0] >= this.c) goto L9;
        r6.invalidateSpanAssignments();     // Catch: Exception -> L13
    L9:
        r6.findLastVisibleItemPositions(this.b);     // Catch: Exception -> L13
        if (this.b[0] < (r6.getItemCount() - this.c)) goto L18;
        r6.invalidateSpanAssignments();     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }
}
