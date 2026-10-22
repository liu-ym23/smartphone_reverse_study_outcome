package com.larus.bmhome.view.actionbar.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000fJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/RightLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "RightSmoothScroller", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RightLayoutManager extends LinearLayoutManager {

    public static final class a extends LinearSmoothScroller {
        public final int calculateTimeForScrolling(int r1) {
            return 100;
        }

        public a(Context r1) {
            super(r1);
        }

        public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
            return ((r4 - (r2 - r1)) - r1) - i5.r0();
        }
    }

    public RightLayoutManager(Context r2) {
        super(r2, 0, false);
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        a r4 = new a(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }

    public RightLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
