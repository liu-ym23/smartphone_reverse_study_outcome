package com.bytedance.android.livesdk.feed.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedItemDecoration2 extends RecyclerView.ItemDecoration {
    public static float a = 2.0f;

    public FeedItemDecoration2() {
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        if (r3.getVisibility() != 0) goto L5;
        int r6 = s1.f(a);
    L6:
        StaggeredGridLayoutManager.LayoutParams r7 = (RecyclerView.LayoutParams) r3.getLayoutParams();
        if ((r7 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L9;
        boolean r8 = r7.isFullSpan();
    L10:
        if (r8 == false) goto L12;
        r6 = s1.f(2.0f);
    L12:
        int r9 = s1.f(1.0f);
        r2.set(r9, r6, r9, 0);
        return;
    L9:
        r8 = false;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }
}
