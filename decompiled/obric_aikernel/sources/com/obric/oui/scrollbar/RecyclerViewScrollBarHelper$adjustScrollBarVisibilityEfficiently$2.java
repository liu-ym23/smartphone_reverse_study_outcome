package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityEfficiently$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityEfficiently$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ float $maxScreens;
    final /* synthetic */ RecyclerView $this_adjustScrollBarVisibilityEfficiently;

    RecyclerViewScrollBarHelper$adjustScrollBarVisibilityEfficiently$2(RecyclerView r10, float r11) {
        this.$this_adjustScrollBarVisibilityEfficiently = r10;
        this.$maxScreens = r11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        super.onScrollStateChanged(r10, r11);
        if (r11 != 0) goto L6;
        a.a(a.f7221a, this.$this_adjustScrollBarVisibilityEfficiently, this.$maxScreens, "onScrollStateChanged");
        return;
    }
}
