package com.bytedance.android.livesdk.feed;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class PerformanceMonitorScrollListener extends RecyclerView.OnScrollListener {
    public final String a;

    public PerformanceMonitorScrollListener() {
        this.a = "feed_drawer_slide";
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        if (jc1.k.f(IPerformanceManager.class) == null) goto L8;
        jc1.k.f(IPerformanceManager.class).monitorPerformance(this.a);
        return;
    }
}
