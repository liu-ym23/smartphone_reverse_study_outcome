package com.bytedance.android.livesdk.feed;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerGridLayoutManager extends GridLayoutManager {
    public LiveDrawerGridLayoutManager(Context r2) {
        super(r2, 2);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        super.onLayoutChildren(r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(null, e, "LiveDrawerGridLayoutManager onLayoutChildren error");
    }
}
