package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CleanTabShowRange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchConfigData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnTabItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowProbExpireToastEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowProbTipsEffect;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITabView extends BaseGiftMVIViewChildNode<GiftPanelState, GiftTabViewState, GiftAction> {
    public static final /* synthetic */ int A = 0;
    public final Lazy m;
    public View n;
    public ImageView o;
    public View p;
    public Disposable q;
    public IntRange r;
    public boolean s;
    public boolean t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final ViewGroup y;
    public final DataCenter z;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ GiftMVITabView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            GiftMVITabView r0 = this.a;
            r0.t = true;
            r0.r().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GiftMVITabView.u(this.a);
        }

        public b(GiftMVITabView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void g() {
        p(0);
        r().setOnClickListener(u0.a);
        this.p = r().findViewById(2131364417);
        this.n = r().findViewById(2131373782);
        this.o = (ImageView) r().findViewById(2131373783);
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L10;
        View r1 = this.n;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        View r0 = this.n;
        if (r0 == null) goto L13;
        r0.setOnClickListener(new v0(this));
    L13:
        v().setHorizontalFadingEdgeEnabled(true);
        v().setFadingEdgeLength(s1.f(40.0f));
        View r2 = r().findViewById(2131387207);
        if (r2 == null) goto L16;
        r2.setVisibility(8);
    L16:
        View r3 = r().findViewById(2131371622);
        if (r3 == null) goto L20;
        r3.setVisibility(8);
    L20:
        if (w() == true) goto L22;
    L23:
        View r4 = this.p;
        if (r4 == null) goto L26;
        r4.setVisibility(8);
    L26:
        boolean r5 = w();
        int r6 = com.bytedance.android.livesdk.utils.landscape.d.a;
        Disposable r7 = null;
        if ((!r5) == false) goto L30;
        UIUtils.setViewVisibility(null, 8);
        UIUtils.setViewVisibility(null, 8);
    L30:
        if (((Boolean) this.u.getValue()).booleanValue() == false) goto L38;
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r8 == null) goto L38;
        com.bytedance.live.datacontext.m<Integer> r9 = r8.getGiftTabMarginWidth();
        if (r9 == null) goto L38;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L38;
        r().post(new t0(r10.intValue(), this));
    L38:
        GiftContext r11 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r11 == null) goto L47;
        com.bytedance.live.datacontext.m<Integer> r13 = r11.getGiftTabMarginWidth();
        if (r13 == null) goto L47;
        Observable r14 = r13.a();
        if (r14 == null) goto L47;
        Observable r15 = r14.observeOn(AndroidSchedulers.mainThread());
        if (r15 == null) goto L47;
        r7 = r15.subscribe(new w0(this));
    L47:
        this.q = r7;
        return;
    L22:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == false) goto L26;
    L10:
        View r16 = this.n;
        if (r16 == null) goto L13;
        r16.setVisibility(8);
        goto L13
    }

    public final RecyclerView v() {
        return (RecyclerView) this.m.getValue();
    }

    public final void i() {
        Disposable r0 = this.q;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.q = null;
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (PadConfigUtils.c() == false) goto L6;
        return 2131565252;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L8;
        return 2131565251;
    L8:
        return 2131565250;
    }

    public final boolean w() {
        if (PadConfigUtils.c() == false) goto L6;
        return true;
    L6:
        Boolean r0 = (Boolean) this.z.get("data_is_portrait", Boolean.TRUE);
        if (r0 != null) goto L11;
        return false;
    L11:
        return r0.booleanValue();
    }

    public static final boolean t(GiftMVITabView r1) {
        if (((Boolean) r1.x.getValue()).booleanValue() == false) goto L6;
        return ((Boolean) r1.w.getValue()).booleanValue();
    L6:
        return com.bytedance.android.livesdk.gift.platform.core.utils.u.l(r1.w(), null);
    }

    public static final void u(GiftMVITabView r3) {
        if (r3.t == false) goto L17;
        RecyclerView.LayoutManager r0 = r3.v().getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L8;
        r0 = null;
    L8:
        LinearLayoutManager r1 = (LinearLayoutManager) r0;
        if (r1 == null) goto L11;
        IntRange r2 = new IntRange(r1.findFirstVisibleItemPosition(), r1.findLastVisibleItemPosition());
    L13:
        if ((!Intrinsics.areEqual(r2, r3.r)) == false) goto L16;
        r3.r = r2;
        r3.o(new OnTabItemVisibleChanged(r2));
        return;
    L16:
        return;
    L11:
        r2 = new IntRange(-1, -1);
        goto L13
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITabView$bindToParent$1 r0 = GiftMVITabView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if ((r5 instanceof ShowProbTipsEffect) == false) goto L7;
        ToastUtil.a(2131919970, 0);
        return true;
    L7:
        if ((r5 instanceof ShowProbExpireToastEffect) == false) goto L11;
        String r6 = rm3.c.a;
        rm3.c.f(getContext(), 2131919790, false, 16);
        mz0.n r7 = new mz0.n();
        mz0.m r0 = new mz0.m();
        r0.b(LogCommon.ROOM);
        r0.b(LogCommon.PAGE_SOURCE_LOG);
        List r1 = r7.b;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r0.a);
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r4 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r4);
        ((f80.a) r4).w3("livesdk_property_overdue_remind_toast_show", r7.a, r7.b);
        return true;
    L11:
        if ((r5 instanceof CleanTabShowRange) == false) goto L14;
        this.r = new IntRange(-1, -1);
        return true;
    L14:
        return false;
    }

    public final void k(com.bytedance.android.anya.dsl.a<GiftTabViewState, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$registerListAdapters");
        r5.a(GiftMVITabView$registerListAdapters$1.INSTANCE, new GiftMVITabView$registerListAdapters$2(this), v(), new GiftMVITabView$registerListAdapters$3(this));
    }

    public final void x(int r3) {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L6;
        return;
    L6:
        if (this.y.getWidth() <= 0) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.i.a(r(), this.y.getWidth() - s1.f(r3));
        if (this.s == true) goto L12;
        this.s = true;
        r().getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        return;
    L12:
        return;
    }

    public final void b(com.bytedance.android.anya.k r7, MVIState r8) {
        GiftTabViewState r9 = (GiftTabViewState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r9, "state");
        com.bytedance.android.anya.t0<GiftTabViewState, GiftTabItem> r0 = r9.getGiftTabItemList();
        Object r1 = r7.c.a(r0);
        if (r1 == null) goto L8;
        r7.b.a.invoke(r0);
        if ((!((com.bytedance.android.anya.s0) r1).isEmpty()) == false) goto L7;
        v().setVisibility(0);
        goto L8
    L7:
        v().setVisibility(8);
    L8:
        com.bytedance.android.anya.r0<GiftTabViewState, Integer> r2 = r9.getTabType();
        Object r3 = r7.c.a(r2);
        if (r3 == null) goto L25;
        r7.b.a.invoke(r2);
        w1 r4 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).U(((Number) r3).intValue());
        if (r4 == null) goto L25;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.i(r4) == false) goto L15;
    L22:
        View r5 = this.p;
        if (r5 == null) goto L25;
        r5.setVisibility(8);
        goto L25
    L15:
        if (w() == false) goto L22;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == true) goto L22;
        View r6 = this.p;
        if (r6 == null) goto L25;
        r6.setVisibility(0);
    L25:
        com.bytedance.android.anya.r0<GiftTabViewState, Integer> r10 = r9.getSelectPosition();
        Object r11 = r7.c.a(r10);
        if (r11 == null) goto L32;
        r7.b.a.invoke(r10);
        int r13 = ((Number) r11).intValue();
        if (r13 < 0) goto L32;
        RecyclerView.LayoutManager r14 = v().getLayoutManager();
        if ((r14 instanceof LinearLayoutManager) == false) goto L32;
        r14.smoothScrollToPosition(v(), new RecyclerView.State(), r13);
    L32:
        com.bytedance.android.anya.r0<GiftTabViewState, Integer> r15 = r9.getMarginEdgeWidth();
        Object r16 = r7.c.a(r15);
        if (r16 == null) goto L37;
        r7.b.a.invoke(r15);
        int r17 = ((Number) r16).intValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L37;
        x(r17);
    L37:
        com.bytedance.android.anya.r0<GiftTabViewState, GiftSearchConfigData> r18 = r9.getGiftSearchConfig();
        Object r19 = r7.c.a(r18);
        if (r19 == null) goto L59;
        r7.b.a.invoke(r18);
        GiftSearchConfigData r20 = (GiftSearchConfigData) r19;
        if (((Boolean) this.v.getValue()).booleanValue() == true) goto L42;
        return;
    L42:
        if (r20.isNormalSearch() == true) goto L51;
        if (TextUtils.isEmpty(r20.getSchema()) == true) goto L51;
        if (r20.getIcon() == null) goto L51;
        ImageUtil.loadImage(this.o, r20.getIcon(), 0);
        View r21 = this.n;
        if (r21 == null) goto L61;
        r21.setOnClickListener(new s0(r20, this));
        return;
    L61:
        return;
    L51:
        if (r20.isNormalSearch() == true) goto L53;
    L55:
        View r23 = this.n;
        if (r23 == null) goto L64;
        r23.setVisibility(8);
        return;
    L64:
        return;
    L53:
        if (r20.getIcon() == null) goto L55;
        ImageUtil.loadImage(this.o, r20.getIcon(), 0);
        return;
    }

    public GiftMVITabView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
        this.y = r3;
        this.z = r4;
        this.m = LazyKt.lazy(new GiftMVITabView$recyclerView$2(this, r2));
        this.r = new IntRange(-1, -1);
        this.u = LazyKt.lazy(GiftMVITabView$tabWidthFix$2.INSTANCE);
        this.v = LazyKt.lazy(new GiftMVITabView$giftSearchNewEntrance$2(this));
        this.w = LazyKt.lazy(new GiftMVITabView$enableInComeToCoins$2(this));
        this.x = LazyKt.lazy(GiftMVITabView$reqFrequencyOptSwitch$2.INSTANCE);
    }
}
