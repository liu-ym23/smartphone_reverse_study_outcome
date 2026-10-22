package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SSLinearLayoutManager extends LinearLayoutManager {
    public SSLinearLayoutManager(Context r1) {
        super(r1);
    }

    public SSLinearLayoutManager(Context r2, int r3) {
        super(r2, r3, false);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        super.onLayoutChildren(r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(null, e, "SSLinearLayoutManager onLayoutChildren error");
    }

    public final int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return super.scrollHorizontallyBy(r1, r2, r3);
    L4:
        e = move-exception;
        ALogService.eSafely("SSLinearLayoutManager", e);
        return 0;
    }

    public final int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return super.scrollVerticallyBy(r1, r2, r3);
    L4:
        e = move-exception;
        ALogService.eSafely("SSLinearLayoutManager", e);
        return 0;
    }

    public SSLinearLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
