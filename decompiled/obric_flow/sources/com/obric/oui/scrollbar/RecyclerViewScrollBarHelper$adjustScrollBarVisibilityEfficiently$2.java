package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityEfficiently$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityEfficiently$2 extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        super.onScrollStateChanged(r5, r10);
        if (r10 == 0) goto L6;
        return;
    L6:
        throw null;
    }
}
