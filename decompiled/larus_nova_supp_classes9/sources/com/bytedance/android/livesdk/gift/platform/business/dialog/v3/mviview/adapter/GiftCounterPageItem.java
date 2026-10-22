package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.configmodel.j1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CounterData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollToPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SmoothScrollEffect;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftCounterPageItem extends com.bytedance.android.anya.c<PagerListData, GiftAction> {
    public IntRange l;
    public final j1 m;
    public final int n;
    public final Lazy o;
    public boolean p;
    public final RecyclerView q;

    public final boolean s() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public GiftCounterPageItem(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L9;
        GiftPanelNitaViewInfo r0 = GiftPanelNitaViewInfo.TTLIVE_MVI_COUNTER_PAGE;
        int r2 = r0.getResId();
        String r1 = r0.getTag();
        Context r3 = r5.getContext();
        if (r3 == null) goto L8;
        View r6 = NitaInflateUtil.a(r2, r1, (Activity) r3, r5, false);
    L10:
        super(r6);
        this.l = new IntRange(-1, -1);
        j1 r7 = com.bytedance.android.livesdk.gift.platform.core.a0.e();
        this.m = r7;
        this.n = r7.y8();
        this.o = LazyKt.lazy(GiftCounterPageItem$enableScrollAnimationOpt$2.INSTANCE);
        RecyclerView r8 = ((com.bytedance.android.anya.c) this).k.findViewById(2131384076);
        r8.setLayoutManager(new LinearLayoutManager(r8.getContext(), 1, false));
        r8.setItemAnimator(null);
        r8.setClipChildren(false);
        if (s() == false) goto L13;
        r8.addItemDecoration(new k(), 0);
    L13:
        r8.addItemDecoration(new a0(s1.k(2131168743), s1.k(2131168745), s1.k(2131168744)));
        r8.addOnScrollListener(new GiftCounterPageItem$$special$$inlined$apply$lambda$1(r8, this));
        Unit r4 = Unit.INSTANCE;
        this.q = r8;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L9:
        r6 = LayoutInflater.from(r5.getContext()).inflate(2131567028, r5, false);
        goto L10
    }

    public final boolean d(com.bytedance.android.anya.a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof ScrollToPositionEffect) == false) goto L13;
        ScrollToPositionEffect r4 = (ScrollToPositionEffect) r3;
        if (r4.getPagerPosition() == ((com.bytedance.android.anya.c) this).i) goto L7;
        return false;
    L7:
        if (r4.getCounterPosition() == (-1)) goto L18;
        LinearLayoutManager r0 = this.q.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L16;
        r0.scrollToPositionWithOffset(r4.getCounterPosition(), com.bytedance.android.live.revenue.common.i.b(2));
        return true;
    L16:
        return true;
    L18:
        return false;
    L13:
        boolean r5 = r3 instanceof SmoothScrollEffect;
        return false;
    }

    public final void k(com.bytedance.android.anya.dsl.a<PagerListData, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$registerListAdapters");
        com.bytedance.android.anya.dsl.a.b(r4, this, GiftCounterPageItem$registerListAdapters$1.INSTANCE, new GiftCounterPageItem$registerListAdapters$2(this), this.q);
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        PagerListData r4 = (PagerListData) r3;
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r4, "state");
        t0<PagerListData, CounterData> r5 = r4.getCounterDataList();
        Object r0 = r2.c.a(r5);
        if (r0 == null) goto L8;
        r2.b.a.invoke(r5);
        if ((!((s0) r0).isEmpty()) == false) goto L9;
        this.q.setVisibility(0);
        return;
    L9:
        return;
    }
}
