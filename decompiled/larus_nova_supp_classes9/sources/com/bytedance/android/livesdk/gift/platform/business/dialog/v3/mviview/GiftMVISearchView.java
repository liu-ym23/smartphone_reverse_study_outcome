package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.GiftGridLayoutManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftSearchItemVisibleChanged;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVISearchView extends com.bytedance.android.anya.e<GiftPanelState, GiftSearchViewState, GiftAction> {
    public zy0.b k;
    public Disposable l;
    public final Lazy m;
    public final Lazy n;
    public RecyclerView o;
    public final com.bytedance.android.livesdk.gift.configmodel.j1 p;
    public final int q;
    public final int r;
    public boolean s;
    public IntRange t;
    public final Collection<com.bytedance.android.anya.z<GiftSearchViewState, ?, ?>> u;
    public final Context v;
    public final ViewGroup w;
    public final ViewGroup x;

    public final void g() {
        RecyclerView r0 = ((View) this.m.getValue()).findViewById(2131384076);
        this.o = r0;
        if (r0 == null) goto L9;
        int r1 = this.q;
        if (r1 <= 0) goto L7;
        r0.setItemViewCacheSize(r1);
    L7:
        r0.setLayoutManager(new GiftGridLayoutManager(r0.getContext(), GiftMVISearchView$onAttach$1$1.INSTANCE));
        r0.setItemAnimator(null);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.addItemDecoration(new BottomDecoration());
        r0.addOnScrollListener(new GiftMVISearchView$onAttach$$inlined$apply$lambda$1(r0, this));
        return;
    }

    public final void i() {
        Disposable r0 = this.l;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.l = null;
        s();
    }

    public final void s() {
        zy0.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        FrameLayout r1 = (FrameLayout) this.n.getValue();
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        this.k = null;
    }

    public final void t() {
        RecyclerView r0 = this.o;
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof LinearLayoutManager) == false) goto L10;
        r1 = r2;
    L10:
        LinearLayoutManager r3 = (LinearLayoutManager) r1;
        if (r3 == null) goto L15;
        RecyclerView r4 = this.o;
        if (r4 == null) goto L15;
        IntRange r5 = new IntRange(m02.e.a(r3, r4, 50, true), m02.e.c(r3, r4, 50, true));
    L17:
        if ((true ^ Intrinsics.areEqual(r5, this.t)) == false) goto L20;
        this.t = r5;
        o(new OnGiftSearchItemVisibleChanged(r5));
        return;
    L20:
        return;
    L15:
        r5 = new IntRange(-1, -1);
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    public final Collection<com.bytedance.android.anya.z<GiftSearchViewState, ?, ?>> p() {
        return this.u;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVISearchView$bindToParent$1 r0 = GiftMVISearchView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void k(com.bytedance.android.anya.dsl.a<GiftSearchViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$registerListAdapters");
        RecyclerView r0 = this.o;
        if (r0 == null) goto L6;
        com.bytedance.android.anya.dsl.a.b(r4, this, GiftMVISearchView$registerListAdapters$1$1.INSTANCE, GiftMVISearchView$registerListAdapters$1$2.INSTANCE, r0);
        return;
    }

    public final boolean r(com.bytedance.android.anya.a0 r11, Function1<? super com.bytedance.android.anya.a0, Boolean> r13) {
        Intrinsics.checkNotNullParameter(r11, "e");
        Intrinsics.checkNotNullParameter(r13, "dispatchEffect");
        if ((r11 instanceof GiftTopVisibleChanged) == false) goto L17;
        GiftTopVisibleChanged r0 = (GiftTopVisibleChanged) r11;
        if (r0.isSearch() == false) goto L17;
        if (r0.getVisible() == false) goto L12;
        if (this.s == true) goto L12;
        this.s = true;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.o, "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(58)});
        r1.setDuration(350);
        r1.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r1.start();
    L12:
        if (r0.getVisible() == true) goto L17;
        if (this.s == false) goto L17;
        this.s = false;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.o, "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(58), 0.0f});
        r2.setDuration(350);
        r2.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r2.start();
    L17:
        return super/*com.bytedance.android.anya.BaseMVIComposableView*/.r(r11, r13);
    }

    public GiftMVISearchView(Context r2, ViewGroup r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "currentContext");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "parentView");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.m = LazyKt.lazy(new GiftMVISearchView$contentView$2(this));
        this.n = LazyKt.lazy(new GiftMVISearchView$searchContainerView$2(this));
        com.bytedance.android.livesdk.gift.configmodel.j1 r5 = com.bytedance.android.livesdk.gift.platform.core.a0.e();
        this.p = r5;
        this.q = r5.C4();
        this.r = r5.y8();
        this.t = new IntRange(-1, -1);
        this.u = CollectionsKt.listOf(new GiftMVISearchComboView(r2, r4));
    }

    public final void q(com.bytedance.android.anya.k r7, MVIState r8, Function1 r9) {
        GiftSearchViewState r10 = (GiftSearchViewState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r9, "dispatchDiff");
        com.bytedance.android.anya.r0<GiftSearchViewState, Boolean> r0 = r10.getShow();
        Object r1 = r7.c.a(r0);
        RecyclerView.LayoutManager r2 = null;
        if (r1 == null) goto L34;
        r7.b.a.invoke(r0);
        if (((Boolean) r1).booleanValue() == false) goto L27;
        RecyclerView r3 = this.o;
        if (r3 == null) goto L9;
        r3.setTranslationY(0.0f);
    L9:
        Disposable r4 = this.l;
        if (r4 == null) goto L12;
        r4.dispose();
    L12:
        this.l = null;
        if (this.k == null) goto L15;
        s();
    L15:
        String r5 = nz1.a.i().d();
        if (nz1.a.i().b() == false) goto L18;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r6 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(this.v, UriProtector.parse(r5), null);
    L19:
        this.k = r6;
        if (r6 == null) goto L34;
        FrameLayout r11 = (FrameLayout) this.n.getValue();
        if (r11 == null) goto L24;
        r11.addView(r6.c());
    L24:
        LinkedHashMap r13 = new LinkedHashMap();
        xy0.a r14 = r6.g();
        if (r14 == null) goto L34;
        r14.load(null, r13);
        goto L34
    L18:
        r6 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(this.v, UriProtector.parse(r5), null);
        goto L19
    L27:
        Disposable r15 = this.l;
        if (r15 == null) goto L30;
        r15.dispose();
    L30:
        this.l = Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r0(this));
        RecyclerView r16 = this.o;
        if (r16 == null) goto L33;
        r16.setTranslationY(0.0f);
    L33:
        this.s = false;
    L34:
        com.bytedance.android.anya.t0<GiftSearchViewState, ItemListData> r17 = r10.getSearchItemDataList();
        Object r18 = r7.c.a(r17);
        if (r18 == null) goto L54;
        r7.b.a.invoke(r17);
        this.t = new IntRange(-1, -1);
        if (((com.bytedance.android.anya.s0) r18).isEmpty() == false) goto L47;
        RecyclerView r19 = this.o;
        if (r19 == null) goto L42;
        r2 = r19.getLayoutManager();
    L42:
        if ((r2 instanceof LinearLayoutManager) == false) goto L44;
        r2.scrollToPosition(0);
    L44:
        RecyclerView r20 = this.o;
        if (r20 == null) goto L54;
        r20.setVisibility(8);
        goto L54
    L47:
        RecyclerView r21 = this.o;
        if (r21 != null) goto L50;
    L51:
        t();
        RecyclerView r23 = this.o;
        if (r23 == null) goto L54;
        r23.setVisibility(0);
        goto L54
    L50:
        if (r21.getVisibility() != 0) goto L51;
    L54:
        r9.invoke(r7);
    }
}
