package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SmoothLinearLayoutManager extends LinearLayoutManager {
    public float a;

    public class a extends LinearSmoothScroller {
        public final /* synthetic */ SmoothLinearLayoutManager a;

        public final float calculateSpeedPerPixel(DisplayMetrics r2) {
            return this.a.a / r2.densityDpi;
        }

        public final PointF computeScrollVectorForPosition(int r2) {
            return this.a.computeScrollVectorForPosition(r2);
        }

        public a(SmoothLinearLayoutManager r1, Context r2) {
            this.a = r1;
            super(r2);
        }
    }

    public final boolean canScrollHorizontally() {
        return super.canScrollHorizontally();
    }

    public SmoothLinearLayoutManager(Context r3) {
        super(r3, 1, false);
        this.a = 25.0f;
    }

    public final void p(float r2) {
        if (r2 <= 0.0f) goto L6;
        this.a = r2;
        return;
    }

    public void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        super.onLayoutChildren(r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(null, e, "SmoothLinearLayoutManager onLayoutChildren error");
    }

    public void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        if (r3 >= 0) goto L4;
        r3 = 0;
    L4:
        a r4 = new a(this, r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }

    public SmoothLinearLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.a = 25.0f;
    }
}
