package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ Ref.IntRef $maxContentHeight;
    final /* synthetic */ float $maxScreens;
    final /* synthetic */ RecyclerView $this_adjustScrollBarVisibilityDynamic;

    RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3(RecyclerView r1, Ref.IntRef r2, float r3) {
        this.$this_adjustScrollBarVisibilityDynamic = r1;
        this.$maxContentHeight = r2;
        this.$maxScreens = r3;
    }

    /* JADX INFO: renamed from: lambda$TEaG71vGjDO9w-_H5l4WHgblJTs, reason: not valid java name */
    public static /* synthetic */ void m1350lambda$TEaG71vGjDO9w_H5l4WHgblJTs(RecyclerView r0, Ref.IntRef r1, float r2) {
        m1353onItemRangeInserted$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$XflT6eY4E7FHfQKK2ZRQEywTiS4(Ref.IntRef r0, RecyclerView r1, float r2) {
        m1354onItemRangeRemoved$lambda2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$scXfCaplnlu1ekug1rPYx8-f6LU, reason: not valid java name */
    public static /* synthetic */ void m1351lambda$scXfCaplnlu1ekug1rPYx8f6LU(Ref.IntRef r0, RecyclerView r1, float r2) {
        m1352onChanged$lambda0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: onChanged$lambda-0, reason: not valid java name */
    private static final void m1352onChanged$lambda0(Ref.IntRef r1, RecyclerView r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "$maxContentHeight");
        Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
        r1.element = 0;
        a.a(a.f14413a, r2, r3, r2.computeVerticalScrollRange());
    }

    /* JADX INFO: renamed from: onItemRangeInserted$lambda-1, reason: not valid java name */
    private static final void m1353onItemRangeInserted$lambda1(RecyclerView r2, Ref.IntRef r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
        Intrinsics.checkNotNullParameter(r3, "$maxContentHeight");
        int r0 = r2.computeVerticalScrollRange();
        if (r0 <= r3.element) goto L5;
        r3.element = r0;
    L5:
        a.a(a.f14413a, r2, r4, r3.element);
    }

    /* JADX INFO: renamed from: onItemRangeRemoved$lambda-2, reason: not valid java name */
    private static final void m1354onItemRangeRemoved$lambda2(Ref.IntRef r1, RecyclerView r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "$maxContentHeight");
        Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
        r1.element = 0;
        a.a(a.f14413a, r2, r3, r2.computeVerticalScrollRange());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        final RecyclerView r0 = this.$this_adjustScrollBarVisibilityDynamic;
        final Ref.IntRef r1 = this.$maxContentHeight;
        final float r3 = this.$maxScreens;
        r0.post(new $$Lambda$RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3$scXfCaplnlu1ekug1rPYx8f6LU(r1, r0, r3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int r2, int r3) {
        final RecyclerView r4 = this.$this_adjustScrollBarVisibilityDynamic;
        final Ref.IntRef r5 = this.$maxContentHeight;
        final float r1 = this.$maxScreens;
        r4.post(new $$Lambda$RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3$TEaG71vGjDO9w_H5l4WHgblJTs(r4, r5, r1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int r2, int r3) {
        final RecyclerView r4 = this.$this_adjustScrollBarVisibilityDynamic;
        final Ref.IntRef r5 = this.$maxContentHeight;
        final float r1 = this.$maxScreens;
        r4.post(new $$Lambda$RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3$XflT6eY4E7FHfQKK2ZRQEywTiS4(r5, r4, r1));
    }
}
