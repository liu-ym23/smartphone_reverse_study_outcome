package com.obric.oui.indicator;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager2$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/obric/oui/indicator/m;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBaseIndicator$setViewPager2$2 extends RecyclerView.AdapterDataObserver implements m {
    @Override // com.obric.oui.indicator.m
    public final Function1 a() {
        final ViewPager2 r5 = null;
        return new OBaseIndicator$setViewPager2$2$releaseAction$1(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        super.onChanged();
        throw null;
    }
}
