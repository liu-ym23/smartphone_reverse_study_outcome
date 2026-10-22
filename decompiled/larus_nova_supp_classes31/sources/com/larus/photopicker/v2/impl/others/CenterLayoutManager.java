package com.larus.photopicker.v2.impl.others;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/photopicker/v2/impl/others/CenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "", "CenterSmoothScroller", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CenterLayoutManager extends LinearLayoutManager {

    public final class a extends LinearSmoothScroller {
        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        public final float calculateSpeedPerPixel(DisplayMetrics r2) {
            Intrinsics.checkNotNullParameter(r2, "displayMetrics");
            return 200.0f / r2.densityDpi;
        }

        public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
            return (r3 + ((r4 - r3) / 2)) - (r1 + ((r2 - r1) / 2));
        }
    }

    public CenterLayoutManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setOrientation(0);
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        a r4 = new a(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
