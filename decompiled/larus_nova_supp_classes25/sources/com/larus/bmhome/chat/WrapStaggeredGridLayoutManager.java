package com.larus.bmhome.chat;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0018\u00010\nR\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/WrapStaggeredGridLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "<init>", "(II)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "smoothScrollToPosition", "recyclerView", "position", "CenterSmoothScroller", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class WrapStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    public static final class a extends LinearSmoothScroller {
        public a(Context r1) {
            super(r1);
        }

        public final int calculateDtToFit(int r7, int r8, int r9, int r10, int r11) {
            int r12 = (((r10 - r9) / 2) + r9) - (((r8 - r7) / 2) + r7);
            if (r9 != 0) goto L5;
            if (r10 != 0) goto L5;
        L7:
            return super.calculateDtToFit(r7, r8, r9, r10, -1);
        L5:
            if (r12 < 0) goto L7;
            return r12;
        }
    }

    public WrapStaggeredGridLayoutManager(int r1, int r2) {
        super(r1, r2);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r3, RecyclerView.State r4) {
        super.onLayoutChildren(r3, r4);     // Catch: IndexOutOfBoundsException -> L4
        return;
    L4:
        e = move-exception;
        FLogger.a.w("WrapStaggeredGridLayoutManager", "exception: " + e);
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        a r4 = new a(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
