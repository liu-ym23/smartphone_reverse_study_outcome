package com.obric.oui.indicator;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager2$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "", "onChanged", "Lkotlin/Function1;", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "releaseAction", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBaseIndicator$setViewPager2$2 extends RecyclerView.AdapterDataObserver implements OBaseIndicator.c {
    final /* synthetic */ ViewPager2 $viewPager;
    final /* synthetic */ OBaseIndicator this$0;

    OBaseIndicator$setViewPager2$2(OBaseIndicator r10, ViewPager2 r11) {
        this.this$0 = r10;
        this.$viewPager = r11;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public Function1<OBaseIndicator.c, Unit> getReleaseAction() {
        return new OBaseIndicator$setViewPager2$2$releaseAction$1(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        super.onChanged();
        this.this$0.o();
    }
}
