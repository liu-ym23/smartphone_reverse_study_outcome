package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.MVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.GiftViewPager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.LazyMVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeViewPagerPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ViewPagerPositionChanged;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIVerticalListView extends com.bytedance.android.anya.e<GiftListViewState, GiftVerticalState, GiftAction> {
    public static final /* synthetic */ int w = 0;
    public final Lazy k;
    public final GiftViewPager l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public LazyMVIViewPagerAdapter<PagerListData, GiftAction> p;
    public boolean q;
    public final View r;
    public final View s;
    public final Collection<com.bytedance.android.anya.z<GiftVerticalState, ?, ?>> t;
    public final Context u;
    public final Function0<Boolean> v;

    public static final class a {
    }

    static {
    }

    public final View t() {
        return (View) this.k.getValue();
    }

    public final boolean u() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final void g() {
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        if (u() == true) goto L5;
        return;
    L5:
        if (this.q == true) goto L15;
        ViewTreeObserver r0 = t().getViewTreeObserver();
        if (r0 != null) goto L10;
    L12:
        this.q = true;
        r0.addOnGlobalLayoutListener(new g1(this));
        return;
    L10:
        if (r0.isAlive() == true) goto L12;
        return;
    }

    public final void i() {
        if (u() == false) goto L16;
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r0 = this.p;
        if (r0 == null) goto L17;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.b0 r2 = r0.k;     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        r0.l.removeCallbacks(r2);     // Catch: Throwable -> L11
    L9:
        r0.k = null;     // Catch: Throwable -> L11
        ((LinkedHashMap) r0.g).clear();     // Catch: Throwable -> L11
        ((LinkedHashMap) r0.h).clear();     // Catch: Throwable -> L11
        r0.j.clear();     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L17:
        return;
    }

    public final Context getContext() {
        return this.u;
    }

    public final Collection<com.bytedance.android.anya.z<GiftVerticalState, ?, ?>> p() {
        return this.t;
    }

    public static final /* synthetic */ LazyMVIViewPagerAdapter s(GiftMVIVerticalListView r1) {
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r2 = r1.p;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lazyPagerAdapter");
    L5:
        return r2;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftListViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIVerticalListView$bindToParent$1 r0 = GiftMVIVerticalListView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void l(com.bytedance.android.anya.dsl.c<GiftVerticalState, GiftAction> r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$registerPagerAdapters");
        GiftMVIVerticalListView$registerPagerAdapters$1 r0 = GiftMVIVerticalListView$registerPagerAdapters$1.INSTANCE;
        Function3<ViewGroup, Integer, Integer, com.bytedance.android.anya.c<PagerListData, GiftAction>> r1 = new GiftMVIVerticalListView$registerPagerAdapters$2(this);
        GiftViewPager r2 = this.l;
        Function1<Function3<? super ViewGroup, ? super Integer, ? super Integer, ? extends com.bytedance.android.anya.c<PagerListData, GiftAction>>, MVIViewPagerAdapter<PagerListData, GiftAction>> r3 = new GiftMVIVerticalListView$registerPagerAdapters$3(this);
        List r7 = r6.a;
        ArrayList r8 = (ArrayList) r7;
        r8.add(new com.bytedance.android.anya.dsl.d(r0, r1, r2, r3));
    }

    public final boolean r(com.bytedance.android.anya.a0 r2, Function1<? super com.bytedance.android.anya.a0, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Intrinsics.checkNotNullParameter(r3, "dispatchEffect");
        if ((r2 instanceof ChangeViewPagerPositionEffect) == false) goto L6;
        ChangeViewPagerPositionEffect r4 = (ChangeViewPagerPositionEffect) r2;
        this.l.setCurrentItem(r4.getPagerPosition());
        o(new ViewPagerPositionChanged(r4.getPagerPosition()));
        return true;
    L6:
        r3.invoke(r2);
        return false;
    }

    public final void q(com.bytedance.android.anya.k r3, MVIState r4, Function1 r5) {
        GiftVerticalState r6 = (GiftVerticalState) r4;
        Intrinsics.checkNotNullParameter(r3, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r6, "state");
        Intrinsics.checkNotNullParameter(r5, "dispatchDiff");
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r7 = r6.getCurrentPagePosition();
        Object r0 = r3.c.a(r7);
        if (r0 == null) goto L5;
        r3.b.a.invoke(r7);
        int r8 = ((Number) r0).intValue();
        this.l.setCurrentItem(r8);
    L5:
        r5.invoke(r3);
    }

    public GiftMVIVerticalListView(Context r2, final ViewGroup r3, ViewGroup r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "parentView");
        Intrinsics.checkNotNullParameter(r5, "animationFun");
        this.u = r2;
        this.v = r5;
        this.k = LazyKt.lazy(new GiftMVIVerticalListView$contentView$2(this, r3));
        final GiftViewPager r6 = (GiftViewPager) t().findViewById(2131373792);
        r6.addOnPageChangeListener(new GiftMVIVerticalListView$addManualOnPageChangeListener$1(this, r6));
        Unit r7 = Unit.INSTANCE;
        this.l = r6;
        this.m = LazyKt.lazy(GiftMVIVerticalListView$lazyViewPagerOpt$2.INSTANCE);
        this.n = LazyKt.lazy(GiftMVIVerticalListView$checkUpdateCorrect$2.INSTANCE);
        this.o = LazyKt.lazy(GiftMVIVerticalListView$checkUpdateDelay$2.INSTANCE);
        this.r = t().findViewById(2131379672);
        this.s = t().findViewById(2131379673);
        this.t = CollectionsKt.listOf(new GiftMVIComboView(r2, r4));
    }
}
