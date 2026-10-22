package com.obric.oui.indicator;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager2$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "releaseAction", "Lkotlin/Function1;", "", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "onChanged", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBaseIndicator$setViewPager2$2 extends RecyclerView.AdapterDataObserver implements OBaseIndicator.f {
    final /* synthetic */ ViewPager2 $viewPager;
    final /* synthetic */ OBaseIndicator this$0;

    OBaseIndicator$setViewPager2$2(OBaseIndicator r1, ViewPager2 r2) {
        this.this$0 = r1;
        this.$viewPager = r2;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.f
    public Function1<OBaseIndicator.f, Unit> getReleaseAction() {
        final ViewPager2 r2 = this.$viewPager;
        return (Function1) ZeusTransformUtils.preCheckCast(new OBaseIndicator$setViewPager2$2$releaseAction$1(r2), Function1.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        super.onChanged();
        this.this$0.h();
    }
}
