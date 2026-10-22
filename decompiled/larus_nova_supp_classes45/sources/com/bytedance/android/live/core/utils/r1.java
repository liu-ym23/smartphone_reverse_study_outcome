package com.bytedance.android.live.core.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r1 {
    public static void a(RecyclerView r2, int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        LinearLayoutManager r4 = r2.getLayoutManager();
        if ((r4 instanceof LinearLayoutManager) == false) goto L8;
        r4.scrollToPositionWithOffset(r3, 0);
        return;
    L8:
        if ((r4 instanceof StaggeredGridLayoutManager) == false) goto L12;
        ((StaggeredGridLayoutManager) r4).scrollToPositionWithOffset(r3, 0);
        return;
    }
}
