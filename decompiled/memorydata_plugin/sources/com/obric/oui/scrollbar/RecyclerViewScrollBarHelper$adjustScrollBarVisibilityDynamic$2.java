package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ Ref.IntRef $maxContentHeight;
    final /* synthetic */ float $maxScreens;
    final /* synthetic */ RecyclerView $this_adjustScrollBarVisibilityDynamic;

    RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2(RecyclerView r1, Ref.IntRef r2, float r3) {
        this.$this_adjustScrollBarVisibilityDynamic = r1;
        this.$maxContentHeight = r2;
        this.$maxScreens = r3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        if (r3 != 0) goto L9;
        int r4 = this.$this_adjustScrollBarVisibilityDynamic.computeVerticalScrollRange();
        if (r4 <= this.$maxContentHeight.element) goto L7;
        this.$maxContentHeight.element = r4;
    L7:
        a.a(a.f14413a, this.$this_adjustScrollBarVisibilityDynamic, this.$maxScreens, this.$maxContentHeight.element);
        return;
    }
}
