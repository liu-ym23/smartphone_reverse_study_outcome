package com.larus.bmhome.double_post.fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/bmhome/double_post/fragment/AwemeDoublePostFragment$initViews$1$1$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeDoublePostFragment$initViews$1$1$5 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ AwemeDoublePostFragment b;

    public AwemeDoublePostFragment$initViews$1$1$5(RecyclerView r1, AwemeDoublePostFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onScrollStateChanged(RecyclerView r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        super.onScrollStateChanged(r6, r7);
        StaggeredGridLayoutManager r0 = this.a.getLayoutManager();
        if ((r0 instanceof StaggeredGridLayoutManager) == false) goto L5;
        StaggeredGridLayoutManager r1 = r0;
    L7:
        if (r1 == null) goto L13;
        int[] r4 = r1.findFirstCompletelyVisibleItemPositions(null);
        Intrinsics.checkNotNull(r4);
        if (ArraysKt.contains(r4, 0) == false) goto L13;
        if (r7 != 0) goto L13;
        r1.invalidateSpanAssignments();
        FLogger.a.i("AwemeDoublePostFragment", "awemePostList onScrollStateChanged: invalidateSpanAssignments");
    L13:
        if (r7 == 2) goto L15;
    L21:
        if (r7 != 1) goto L26;
        Function0 r8 = this.b.y;
        if (r8 == null) goto L27;
        r8.invoke();
        return;
    L27:
        return;
    L26:
        return;
    L15:
        if (r6.canScrollVertically(1) == true) goto L21;
        if (this.b.i.L2() == false) goto L19;
    L20:
        FLogger.a.i("AwemeDoublePostFragment", "awemePostList onScrollStateChanged: load more error retry");
        AwemeDoublePostViewModel.loadMoreData$default(this.b.Z90(), null, false, 3, null);
        goto L21
    L19:
        if (this.b.i.K2() == false) goto L21;
    L5:
        r1 = null;
        goto L7
    }
}
