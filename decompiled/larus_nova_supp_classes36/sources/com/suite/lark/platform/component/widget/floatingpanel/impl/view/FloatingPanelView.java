package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeTransform;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.suite.lark.platform.component.widget.floatingpanel.impl.FloatPanelHitPoint;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import z5c.k;
import z5c.w3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatingPanelView extends FrameLayout {
    public static final /* synthetic */ int o = 0;
    public final g a;
    public final FloatingCardContainer b;
    public final FloatingPanelActionView c;
    public final FloatingPanelActionView d;
    public final FloatingBannerContainer e;
    public final FloatingPanelScrollView f;
    public final PathInterpolator g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;
    public final int n;

    public static final class a implements FloatingCardContainer.b {
        public final /* synthetic */ FloatingPanelView a;

        /* JADX INFO: renamed from: com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelView$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0241a implements View.OnClickListener {
            public final /* synthetic */ FloatingPanelView a;

            public ViewOnClickListenerC0241a(FloatingPanelView r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.c();
            }
        }

        public a(FloatingPanelView r1) {
            this.a = r1;
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingCardContainer.b
        public final void O9(boolean r3) {
            if (r3 == false) goto L5;
            this.a.c.setVisibility(0);
            this.a.a.c();
            FloatingPanelView r4 = this.a;
            r4.setOnClickListener(new ViewOnClickListenerC0241a(r4));
            return;
        L5:
            this.a.e();
            this.a.a.e();
            FloatingPanelView r5 = this.a;
            r5.setOnClickListener(null);
            r5.setClickable(false);
        }
    }

    public static final class b implements com.suite.lark.platform.component.widget.floatingpanel.impl.view.e {
        public final /* synthetic */ FloatingPanelView a;

        public b(FloatingPanelView r1) {
            this.a = r1;
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.e
        public final void a(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "cardId");
            this.a.a.d(r3);
        }
    }

    public static final class c implements FloatingBannerContainer.a {
        public final /* synthetic */ FloatingPanelView a;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingBannerContainer.a
        public final void a() {
            FloatingBannerContainer r0 = this.a.e;
            int r1 = r0.getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            r0.getChildAt(r2).setVisibility(4);
            r2 = r2 + 1;
            goto L3
        L5:
            this.a.a.a();
        }

        public c(FloatingPanelView r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.suite.lark.platform.component.widget.floatingpanel.impl.view.e {
        public final /* synthetic */ FloatingPanelView a;

        public d(FloatingPanelView r1) {
            this.a = r1;
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.e
        public final void a(View r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "cardId");
            FloatingCardContainer r5 = this.a.b;
            if (r5.g == false) goto L5;
        L12:
            this.a.a.d(r4);
            return;
        L5:
            if (r5.getChildCount() <= 1) goto L12;
            Long r6 = FloatPanelHitPoint.a;
            int r7 = this.a.b.getChildCount();
            Statistics.sendEvent("im_floating_panel_expand_list_click", s5c.d.b.c(w3.c.a(String.valueOf(r7))));
            final FloatingPanelView r8 = this.a;
            FloatingCardContainer r9 = r8.b;
            if (r9.g == false) goto L9;
            return;
        L9:
            if (r9.getChildCount() <= 1) goto L16;
            TransitionManager.beginDelayedTransition(r8.f, r8.d(true, new FloatingPanelView$expandCardList$1(r8)));
            r8.b.f();
            return;
        }
    }

    public static final class e implements FloatingPanelActionView.d {
        public final int a;
        public final FloatingCardContainer b;
        public final FloatingPanelActionView.d c;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void a() {
            Long r0 = FloatPanelHitPoint.a;
            FloatPanelHitPoint.a(this.b.getChildCount(), this.a);
            this.c.a();
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void b() {
            Long r0 = FloatPanelHitPoint.a;
            int r1 = this.b.getChildCount();
            int r2 = this.a;
            if (r2 != 2) goto L5;
            Log.e("FloatingPanelHitPoint", "sendClearListEvent. invalid button position value");
        L6:
            this.c.b();
            return;
        L5:
            Statistics.sendEvent("im_floating_panel_one_key_clear_click", s5c.d.b.b(w3.c.a(String.valueOf(r1)), k.c.a(String.valueOf(r2))).toJson());
            goto L6
        }

        public e(int r2, FloatingCardContainer r3, h r4) {
            Intrinsics.checkNotNullParameter(r3, "cardContainer");
            Intrinsics.checkNotNullParameter(r4, "impl");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class f {
    }

    public interface g {
        void a();

        void b(String r1);

        void c();

        void d(String r1);

        void e();

        void f();
    }

    public static final class h implements FloatingPanelActionView.d {
        public final /* synthetic */ FloatingPanelView a;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void a() {
            this.a.c();
        }

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelActionView.d
        public final void b() {
            this.a.a.f();
            this.a.e();
        }

        public h(FloatingPanelView r1) {
            this.a = r1;
        }
    }

    static {
    }

    private final TransitionSet getCardListTransition() {
        return (TransitionSet) this.h.getValue();
    }

    private final TransitionSet getRemoveBannerTransition() {
        return (TransitionSet) this.i.getValue();
    }

    private final TransitionSet getShowBannerCompanionTransition() {
        return (TransitionSet) this.k.getValue();
    }

    private final TransitionSet getShowBannerTransition() {
        return (TransitionSet) this.j.getValue();
    }

    private final TransitionSet getShowCardTransition() {
        return (TransitionSet) this.l.getValue();
    }

    public final void c() {
        if (this.b.g == true) goto L5;
        return;
    L5:
        FloatingPanelScrollView r0 = this.f;
        r0.b = false;
        r0.smoothScrollTo(0, 0);
        TransitionManager.beginDelayedTransition(this.f, d(false, new FloatingPanelView$collapseCardList$1(this)));
        this.b.a();
    }

    public final void e() {
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    public final void f() {
        if (this.e.getChildCount() != 0) goto L5;
        return;
    L5:
        FloatingBannerContainer r0 = this.e;
        final View r1 = r0.getChildAt(r0.getChildCount() - 1);
        Iterator r2 = SequencesKt.filter(ViewGroupKt.getChildren(this.e), new FloatingPanelView$onBannerAdded$1(r1)).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        this.e.removeView((View) r2.next());
        goto L7
    }

    public final void h() {
        TransitionManager.beginDelayedTransition(this.f, d(false, new FloatingPanelView$removeAllCards$1(this)));
        FloatingCardContainer r0 = this.b;
        r0.i(null);
        r0.a();
    }

    public final boolean i() {
        if (this.e.getChildCount() != 0) goto L6;
        return false;
    L6:
        TransitionManager.beginDelayedTransition(this.f, getRemoveBannerTransition());
        this.e.removeAllViews();
        return true;
    }

    public final void l() {
        Log.i("FloatingPanelView", "reset");
        TransitionManager.endTransitions(this.f);
        TransitionManager.endTransitions(this.e);
        this.e.removeAllViews();
        FloatingCardContainer r0 = this.b;
        r0.i(null);
        r0.a();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (this.m == false) goto L6;
        this.m = false;
        this.e.requestLayout();
        return;
    }

    public final void g(List<? extends Pair<String, ? extends Function0<? extends View>>> r3) {
        Intrinsics.checkNotNullParameter(r3, "viewItems");
        TransitionManager.beginDelayedTransition(this.f, getShowCardTransition());
        this.b.h(r3);
    }

    public final void j(String r8) {
        Intrinsics.checkNotNullParameter(r8, "id");
        TransitionManager.beginDelayedTransition(this.f, getCardListTransition());
        FloatingCardContainer r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "id");
        int r0 = r1.getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L11;
        View r4 = r1.getChildAt(r3);
        if ((r4 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L9;
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r5 = (com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r4;
        if (Intrinsics.areEqual(r5.getCardId(), r8) == false) goto L9;
        r5.removeAllViews();
        r1.removeView(r4);
    L9:
        r3 = r3 + 1;
    L11:
        if (r1.getChildCount() != 0) goto L13;
        r1.a();
        return;
    L13:
        int r9 = r1.getChildCount();
        int r2 = 0;
    L14:
        if (r2 >= r9) goto L21;
        View r6 = r1.getChildAt(r2);
        if ((r6 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L20;
        if (((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r6).b() == true) goto L21;
    L20:
        r2 = r2 + 1;
    L21:
        r1.c(false);
    }

    public final void k(final List<String> r7) {
        Intrinsics.checkNotNullParameter(r7, "ids");
        TransitionManager.beginDelayedTransition(this.f, d(false, new FloatingPanelView$removeCards$1(this)));
        FloatingCardContainer r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "ids");
        r1.i(new FloatingCardContainer$removeCards$1(r7));
        if (r1.getChildCount() != 0) goto L5;
        r1.a();
        return;
    L5:
        int r8 = r1.getChildCount();
        int r0 = 0;
        int r2 = 0;
    L6:
        if (r0 >= r8) goto L16;
        View r4 = r1.getChildAt(r0);
        if ((r4 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L15;
        if (((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r4).b() == false) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 > 15) goto L16;
    L15:
        r0 = r0 + 1;
    L16:
        r1.c(false);
    }

    public FloatingPanelView(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "delegate");
        super(r8, null, 0);
        this.a = r9;
        this.g = new PathInterpolator(0.4f, 0.8f, 0.73f, 1.0f);
        this.h = LazyKt.lazy(new FloatingPanelView$cardListTransition$2(this));
        this.i = LazyKt.lazy(new FloatingPanelView$removeBannerTransition$2(this));
        this.j = LazyKt.lazy(new FloatingPanelView$showBannerTransition$2(this));
        this.k = LazyKt.lazy(new FloatingPanelView$showBannerCompanionTransition$2(this));
        this.l = LazyKt.lazy(new FloatingPanelView$showCardTransition$2(this));
        LayoutInflater.from(r8).inflate(2131563318, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FloatingPanelScrollView r10 = (FloatingPanelScrollView) findViewById(2131373012);
        this.f = r10;
        FloatingBannerContainer r0 = (FloatingBannerContainer) findViewById(2131373007);
        this.e = r0;
        FloatingCardContainer r3 = (FloatingCardContainer) findViewById(2131373010);
        this.b = r3;
        FloatingPanelActionView r4 = (FloatingPanelActionView) findViewById(2131373009);
        this.c = r4;
        FloatingPanelActionView r5 = (FloatingPanelActionView) findViewById(2131373008);
        this.d = r5;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r10, "scrollView");
        r10.setOnScrollChangedListener(new com.suite.lark.platform.component.widget.floatingpanel.impl.view.c(r3));
        r3.setOnExpandStatusChangedListener(new a(this));
        r0.setOnBannerClickListener(new b(this));
        r0.setOnBannerMovedOutListener(new c(this));
        r3.setOnFloatingCardClickListener(new d(this));
        h r11 = new h(this);
        r4.setOnActionButtonClickedListener(new e(0, r3, r11));
        r5.setOnActionButtonClickedListener(new e(1, r3, r11));
        if (DevEnvUtil.isDevelopPackage(r8) == false) goto L5;
        findViewById(2131373011).setVisibility(0);
    L5:
        this.n = UIUtils.dp2px(r8, 360.0f);
    }

    public final void a(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "id");
        TransitionManager.beginDelayedTransition(this.f, getShowBannerCompanionTransition());
        TransitionManager.beginDelayedTransition(this.e, getShowBannerTransition());
        this.e.a(r3, r4);
    }

    public final TransitionSet d(final boolean r4, final Function0<? extends List<Integer>> r5) {
        if (this.b.g() == true) goto L6;
        return getCardListTransition();
    L6:
        return m("card_list_transition", new Transition[]{new Fade(3), new ChangeBounds(), new ChangeTransform()}, new AnonymousClass1(r5, r4, this));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        int r1 = View.MeasureSpec.getSize(r6);
        int r2 = j08.b.d(getContext(), r0);
        int r3 = j08.b.d(getContext(), r1);
        ViewGroup.LayoutParams r4 = this.f.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r4;
        if (r3 >= 480) goto L6;
        r7.width = this.n;
        r7.gravity = 1;
    L9:
        super.onMeasure(r5, r6);
        return;
    L6:
        if (r2 < 600) goto L8;
        r7.width = this.n;
        r7.gravity = 5;
        goto L9
    L8:
        r7.width = -1;
        r7.gravity = 8388659;
        goto L9
    }

    public final void b(View r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "cardView");
        Intrinsics.checkNotNullParameter(r12, "id");
        if (r10.getParent() == null) goto L6;
        return;
    L6:
        if (this.b.g == true) goto L12;
        FloatingPanelScrollView r2 = this.f;
        final Function0<List<? extends Integer>> r4 = new FloatingPanelView$addCard$1(this);
        if (this.b.g() == true) goto L10;
        TransitionSet r5 = getShowCardTransition();
    L11:
        TransitionManager.beginDelayedTransition(r2, r5);
    L13:
        FloatingCardContainer r3 = this.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r10, "cardView");
        Intrinsics.checkNotNullParameter(r12, "id");
        int r0 = r3.getChildCount();
        int r1 = 0;
    L14:
        if (r1 >= r0) goto L21;
        View r6 = r3.getChildAt(r1);
        if ((r6 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L20;
        if (Intrinsics.areEqual(((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r6).getCardId(), r12) == false) goto L20;
        Log.e("FloatingCardContainer", "addCard: " + r12 + " is already added");
        return;
    L20:
        r1 = r1 + 1;
        goto L14
    L21:
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r13 = r3.b(r10, null, r11, r12);
        if (r13.isLaidOut() == true) goto L24;
    L26:
        r13.addOnLayoutChangeListener(new com.suite.lark.platform.component.widget.floatingpanel.impl.view.b(r3));
        return;
    L24:
        if (r13.isLayoutRequested() == true) goto L26;
        r3.c(false);
        return;
    L10:
        Slide r7 = new Slide(48);
        r7.setMode(1);
        Unit r8 = Unit.INSTANCE;
        r5 = m("show_card_transition", new Transition[]{r7, new Fade(2), new ChangeTransform(), new ChangeBounds()}, new FloatingPanelView$getAddCardTransition$2(r4));
        goto L11
    L12:
        TransitionManager.beginDelayedTransition(this.f, getShowCardTransition());
        goto L13
    }

    public final TransitionSet m(final String r4, Transition[] r5, Function1<? super TransitionSet, Unit> r6) {
        TransitionSet r7 = new TransitionSet().setInterpolator(this.g).setDuration(300).addListener(new FloatingPanelView$transitionSet$1(this, r4));
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r7.addTransition(r5[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        if (r6 == null) goto L7;
        r6.invoke(r7);
    L7:
        return r7;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.b.getHeight() <= this.f.getHeight()) goto L5;
        this.d.setVisibility(0);
        return;
    L5:
        this.d.setVisibility(8);
    }
}
