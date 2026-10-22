package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ Ref.IntRef $maxContentHeight;
    final /* synthetic */ float $maxScreens;
    final /* synthetic */ RecyclerView $this_adjustScrollBarVisibilityDynamic;

    RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$2(RecyclerView r10, Ref.IntRef r11, float r12) {
        this.$this_adjustScrollBarVisibilityDynamic = r10;
        this.$maxContentHeight = r11;
        this.$maxScreens = r12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        super.onScrollStateChanged(r10, r11);
        if (r11 != 0) goto L9;
        int r12 = this.$this_adjustScrollBarVisibilityDynamic.computeVerticalScrollRange();
        Ref.IntRef r13 = this.$maxContentHeight;
        int r14 = r13.element;
        if (r12 <= r14) goto L7;
        r13.element = r12;
        a.b(a.f7221a, this.$this_adjustScrollBarVisibilityDynamic, this.$maxScreens, r12);
        return;
    L7:
        a.b(a.f7221a, this.$this_adjustScrollBarVisibilityDynamic, this.$maxScreens, r14);
        return;
    }
}
