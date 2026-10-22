package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.anya.BaseMVIComposableView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.tray.DialogStatus;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview.GiftMVIGroupView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickDialogTopContainer;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDSNoticeState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDynamicPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftMinorsNoticeState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabChangeEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopExchangeViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopPanelViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ModifyDialogHeightEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.NewReceiverPanelStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGroupView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowOperation;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowTopicView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.GiftListEdgeTransparentView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.PublicScreenEdgeTransparentView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIPanelView extends BaseMVIComposableView<GiftPanelState, GiftAction> {
    public static final int U = 0;
    public static final int V = 0;
    public final View A;
    public Animator B;
    public Animator C;
    public Animator D;
    public boolean E;
    public boolean F;
    public Animator G;
    public Animator H;
    public Animator I;
    public Animator J;
    public final ViewGroup K;
    public final ViewGroup L;
    public final ViewGroup M;
    public final Lazy N;
    public final Lazy O;
    public ViewGroup P;
    public final Collection<com.bytedance.android.anya.z<GiftPanelState, ?, ?>> Q;
    public final Context R;
    public final ViewGroup S;
    public final DataCenter T;
    public boolean k;
    public boolean l;
    public final ViewGroup m;
    public final FrameLayout n;
    public final FrameLayout o;
    public final Lazy p;
    public final FrameLayout q;
    public final Lazy r;
    public final ViewGroup s;
    public final FrameLayout t;
    public final View u;
    public final View v;
    public final FrameLayout w;
    public final ViewGroup x;
    public final FrameLayout y;
    public final FrameLayout z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GiftMVIPanelView a;

        public b(GiftMVIPanelView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.o(new ClickDialogTopContainer());
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ GiftMVIPanelView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r0 = this.a.u.getHeight();
            GiftMVIPanelView r1 = this.a;
            if (r1.k == true) goto L5;
            int r2 = r1.m.getHeight();
        L9:
            int r3 = r0 + r2;
            this.a.T.put("cmd_gift_dialog_switch", new zg1.f0(r3, true));
            this.a.u.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L5:
            if (r1.l == false) goto L7;
            r2 = s1.f(28.0f);
            goto L9
        L7:
            r2 = 0;
            goto L9
        }

        public c(GiftMVIPanelView r1) {
            this.a = r1;
        }
    }

    public static final class d implements a02.a {
        public final /* synthetic */ GiftListEdgeTransparentView a;

        public d(GiftListEdgeTransparentView r1) {
            this.a = r1;
        }

        @Override // a02.a
        public final boolean a(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "ev");
            if (r2.getAction() == 0) goto L6;
            return false;
        L6:
            if (r2.getY() >= this.a.getTopDrawSize()) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public final ViewGroup s() {
        return (ViewGroup) this.O.getValue();
    }

    public final ViewGroup t() {
        return (ViewGroup) this.r.getValue();
    }

    public final ViewGroup u() {
        return (ViewGroup) this.p.getValue();
    }

    static {
        U = s1.f(490.0f);
        V = 2131248907;
    }

    public final void g() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.preview.view.s.a(this.m, s1.f(48.0f));
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L15;
        this.x.setVisibility(8);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L11;
        this.n.setVisibility(8);
    L11:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L13;
        this.K.setVisibility(0);
    L14:
        this.P = (ViewGroup) this.S.findViewById(2131371903);
        goto L15
    L13:
        ((ViewGroup) this.N.getValue()).setVisibility(0);
        s().setVisibility(0);
    L15:
        boolean r1 = ((Boolean) this.T.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        int r3 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r1) == false) goto L23;
        this.v.setVisibility(0);
        this.u.setBackgroundColor(s1.h(2131108453));
        ViewParent r2 = this.v.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L23;
        ViewGroup r4 = (ViewGroup) r2;
        r4.setBackground(s1.m(V));
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L22;
        r5.width = U;
    L22:
        r4.setLayoutParams(r5);
    L23:
        this.n.setOnClickListener(new b(this));
        FrameLayout r6 = this.n;
        Resources r7 = this.R.getResources();
        ViewGroup r8 = null;
        if (r7 == null) goto L26;
        String r9 = r7.getString(2131917159);
    L27:
        r3.c(r6, r9, true);
        this.u.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L45;
        ViewGroup r10 = t();
        if ((r10 instanceof GiftListEdgeTransparentView) == true) goto L32;
        r10 = null;
    L32:
        GiftListEdgeTransparentView r11 = (GiftListEdgeTransparentView) r10;
        if (r11 == null) goto L38;
        int[] r13 = {-1, -1, 0};
        float[] r14 = {0.0f, 0.2f, 1.0f};
        Intrinsics.checkNotNullParameter(r13, "gradientColors");
        Intrinsics.checkNotNullParameter(r14, "gradientPosition");
        r11.j = r13;
        r11.k = r14;
        r11.l = s1.f(60.0f);
        r11.invalidate();
        Paint r15 = r11.i;
        if (r15 == null) goto L37;
        r15.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r11.l, r11.j, r11.k, Shader.TileMode.CLAMP));
    L37:
        r11.invalidate();
    L38:
        ViewGroup r16 = t();
        if ((r16 instanceof GiftListEdgeTransparentView) == false) goto L42;
        r8 = r16;
    L42:
        GiftListEdgeTransparentView r17 = (GiftListEdgeTransparentView) r8;
        if (r17 == null) goto L53;
        r17.setTouchInterceptor(new d(r17));
        int[] r18 = {-1, 0};
        float[] r19 = {1.0f, 1.0f};
        Intrinsics.checkNotNullParameter(r18, "gradientColors");
        Intrinsics.checkNotNullParameter(r19, "gradientPosition");
        r17.e = r18;
        r17.f = r19;
        float r20 = s1.f(58.0f);
        r17.g = 0.0f;
        r17.h = r20;
        r17.invalidate();
        r17.a();
        r17.invalidate();
        return;
    L53:
        return;
    L45:
        ViewGroup r21 = t();
        if ((r21 instanceof PublicScreenEdgeTransparentView) == false) goto L49;
        r8 = r21;
    L49:
        PublicScreenEdgeTransparentView r23 = (PublicScreenEdgeTransparentView) r8;
        if (r23 == null) goto L55;
        r23.i = new int[]{-1, -1, 0};
        r23.j = new float[]{0.0f, 0.2f, 1.0f};
        r23.c(2, s1.f(60.0f), 0.0f);
        r23.d();
        r23.invalidate();
        return;
    L55:
        return;
    L26:
        r9 = null;
        goto L27
    }

    public final void i() {
        Animator r0 = this.B;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.C;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        Animator r2 = this.D;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        Animator r3 = this.G;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        Animator r4 = this.H;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        Animator r5 = this.I;
        if (r5 == null) goto L20;
        r5.cancel();
    L20:
        Animator r6 = this.J;
        if (r6 == null) goto L23;
        r6.cancel();
    L23:
        Animator r7 = this.G;
        Animator r8 = null;
        if ((r7 instanceof AnimatorSet) == true) goto L26;
        r7 = null;
    L26:
        AnimatorSet r9 = (AnimatorSet) r7;
        if (r9 == null) goto L29;
        v(r9);
    L29:
        Animator r10 = this.H;
        if ((r10 instanceof AnimatorSet) == true) goto L32;
        r10 = null;
    L32:
        AnimatorSet r11 = (AnimatorSet) r10;
        if (r11 == null) goto L35;
        v(r11);
    L35:
        Animator r13 = this.I;
        if ((r13 instanceof AnimatorSet) == true) goto L38;
        r13 = null;
    L38:
        AnimatorSet r14 = (AnimatorSet) r13;
        if (r14 == null) goto L41;
        v(r14);
    L41:
        Animator r15 = this.J;
        if ((r15 instanceof AnimatorSet) == false) goto L45;
        r8 = r15;
    L45:
        AnimatorSet r16 = (AnimatorSet) r8;
        if (r16 == null) goto L49;
        v(r16);
        return;
    }

    public final Context getContext() {
        return this.R;
    }

    public final Collection<com.bytedance.android.anya.z<GiftPanelState, ?, ?>> p() {
        return this.Q;
    }

    public static void v(AnimatorSet r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$removeChildrenListener");
        ArrayList<Animator> r3 = r2.getChildAnimations();
        if (r3 == null) goto L13;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L19;
        Animator r0 = (Animator) r4.next();
        if (r0 == null) goto L11;
        r0.removeAllListeners();
    L11:
        if ((r0 instanceof ValueAnimator) == false) goto L6;
        ((ValueAnimator) r0).removeAllUpdateListeners();
        goto L6
    L19:
        return;
    }

    public final void w(boolean r15) {
        AnimatorSet r0 = new AnimatorSet();
        this.B = r0;
        if (r15 == false) goto L5;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(t(), "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(36)});
        r11.setDuration(250);
    L7:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L12;
        if (r15 == false) goto L10;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.M, "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(36)});
        r16.setDuration(250);
    L11:
        r0.play(r16);
        goto L12
    L10:
        r16 = ObjectAnimator.ofFloat(this.M, "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(36), 0.0f});
        r16.setDuration(350);
    L12:
        r0.play(r11);
        r0.start();
        return;
    L5:
        r11 = ObjectAnimator.ofFloat(t(), "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(36), 0.0f});
        r11.setDuration(350);
        goto L7
    }

    public final boolean r(com.bytedance.android.anya.a0 r14, Function1<? super com.bytedance.android.anya.a0, Boolean> r15) {
        Intrinsics.checkNotNullParameter(r14, "e");
        Intrinsics.checkNotNullParameter(r15, "dispatchEffect");
        if ((r14 instanceof ShowTopicView) == false) goto L29;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == false) goto L122;
        ShowTopicView r0 = (ShowTopicView) r14;
        if (r0.getVisible() == false) goto L18;
        if (this.y.getVisibility() == 0) goto L18;
        this.y.setAlpha(0.0f);
        this.y.setVisibility(0);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L13;
        w(true);
        goto L122
    L13:
        AnimatorSet r1 = new AnimatorSet();
        this.B = r1;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L16;
        ObjectAnimator r6 = ObjectAnimator.ofFloat(u(), "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(36)});
        r6.setDuration(250);
        r1.play(r6);
    L16:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(t(), "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(36)});
        r2.setDuration(250);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.y, "alpha", new float[]{0.0f, 1.0f});
        r3.setDuration(250);
        r1.play(r2);
        r1.play(r3);
        r1.start();
    L18:
        if (r0.getVisible() == true) goto L122;
        if (this.y.getVisibility() != 0) goto L122;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L24;
        this.y.setVisibility(8);
        w(false);
        goto L122
    L24:
        AnimatorSet r4 = new AnimatorSet();
        this.B = r4;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L27;
        ObjectAnimator r7 = ObjectAnimator.ofFloat(u(), "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(36), 0.0f});
        r7.setDuration(250);
        r4.play(r7);
    L27:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(t(), "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(36), 0.0f});
        r5.setDuration(300);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.y, "alpha", new float[]{1.0f, 0.0f});
        r8.setDuration(300);
        r8.addListener(new k0(this));
        r4.play(r5);
        r4.play(r8);
        r4.start();
    L122:
        return super.r(r14, r15);
    L29:
        if ((r14 instanceof GiftTopVisibleChanged) == false) goto L72;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L33;
    L34:
        GiftTopVisibleChanged r9 = (GiftTopVisibleChanged) r14;
        if (r9.getVisible() == false) goto L57;
        if (this.E == true) goto L57;
        boolean r10 = r9.isSearch();
        this.E = true;
        Animator r11 = this.D;
        if (r11 != null) goto L41;
    L45:
        if (r10 == false) goto L52;
        ViewGroup r13 = u();
        if (r13 == null) goto L49;
        r13.setVisibility(0);
    L49:
        FrameLayout r16 = this.o;
        if (r16 == null) goto L52;
        r16.setTranslationY(com.bytedance.android.live.revenue.common.i.a(-58));
    L52:
        AnimatorSet r17 = new AnimatorSet();
        this.C = r17;
        ObjectAnimator r18 = ObjectAnimator.ofFloat(this.o, "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(-58), 0.0f});
        r18.setDuration(350);
        r18.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r18.addUpdateListener(new j0(this));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L55;
        this.M.setVisibility(0);
        ObjectAnimator r19 = ObjectAnimator.ofFloat(this.L, "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(-59), 0.0f});
        r19.setDuration(350);
        r17.play(r19);
    L55:
        r17.playTogether(new Animator[]{r18});
        r17.start();
        goto L122
    L41:
        if (r11.isRunning() != true) goto L45;
        Animator r20 = this.D;
        if (r20 == null) goto L45;
        r20.cancel();
    L57:
        if (r9.getVisible() == true) goto L122;
        if (this.E == false) goto L122;
        this.E = false;
        Animator r21 = this.C;
        if (r21 != null) goto L63;
    L67:
        AnimatorSet r23 = new AnimatorSet();
        this.D = r23;
        ObjectAnimator r24 = ObjectAnimator.ofFloat(this.o, "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(-58)});
        r24.setDuration(350);
        r24.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r24.addUpdateListener(new h0(this));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L70;
        ObjectAnimator r25 = ObjectAnimator.ofFloat(this.L, "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(-59)});
        r25.setDuration(350);
        r25.addListener(new i0(this));
        r23.play(r25);
    L70:
        r23.playTogether(new Animator[]{r24});
        r23.start();
        goto L122
    L63:
        if (r21.isRunning() != true) goto L67;
        Animator r26 = this.C;
        if (r26 == null) goto L67;
        r26.cancel();
        goto L67
    L33:
        if (((GiftTopVisibleChanged) r14).isSearch() == false) goto L122;
    L72:
        if ((r14 instanceof ShowGroupView) == false) goto L96;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L122;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L122;
        ShowGroupView r27 = (ShowGroupView) r14;
        if (r27.isSearch() == false) goto L122;
        if (r27.getVisible() == false) goto L91;
        if (this.F == true) goto L91;
        this.F = true;
        ViewGroup r28 = this.M;
        if (r28 == null) goto L86;
        r28.setVisibility(0);
    L86:
        ViewGroup r29 = this.L;
        if (r29 == null) goto L89;
        r29.setTranslationY(com.bytedance.android.live.revenue.common.i.a(-49));
    L89:
        AnimatorSet r30 = new AnimatorSet();
        this.I = r30;
        r30.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.L, "translationY", new float[]{com.bytedance.android.live.revenue.common.i.a(-49), 0.0f})});
        r30.setDuration(350);
        r30.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r30.start();
    L91:
        if (r27.getVisible() == true) goto L122;
        if (this.F == false) goto L122;
        this.F = false;
        AnimatorSet r31 = new AnimatorSet();
        this.J = r31;
        r31.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.L, "translationY", new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(-49)})});
        r31.setDuration(350);
        r31.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r31.start();
        goto L122
    L96:
        if ((r14 instanceof ShowOperation) == false) goto L106;
        if (((ShowOperation) r14).getVisible() == false) goto L102;
        ViewGroup r33 = this.P;
        if (r33 == null) goto L122;
        UtilityKotlinExtentionsKt.w(r33);
        goto L122
    L102:
        ViewGroup r34 = this.P;
        if (r34 == null) goto L122;
        UtilityKotlinExtentionsKt.t(r34);
        goto L122
    L106:
        if ((r14 instanceof GiftTabChangeEffect) == false) goto L119;
        View r35 = this.u;
        if ((r35 instanceof HSImageView) == true) goto L110;
        r35 = null;
    L110:
        HSImageView r36 = (HSImageView) r35;
        if (r36 == null) goto L122;
        w1 r37 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).U(((GiftTabChangeEffect) r14).getTabType());
        if (r37 == null) goto L122;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.i(r37) == false) goto L117;
        ImageLoader.bindGifImage(r36, r37.getBackgroundImage());
        goto L122
    L117:
        ImageLoader.bindDrawableResource(r36, 2131108453);
        goto L122
    L119:
        if ((r14 instanceof ModifyDialogHeightEffect) == false) goto L122;
        this.u.getLayoutParams().height += UtilityKotlinExtentionsKt.i(((ModifyDialogHeightEffect) r14).getHeightChange());
        this.u.requestLayout();
        goto L122
    }

    public GiftMVIPanelView(Context r24, ViewGroup r25, DataCenter r26) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "parentView");
        Intrinsics.checkNotNullParameter(r26, "dataCenter");
        this.R = r24;
        this.S = r25;
        this.T = r26;
        this.k = true;
        ViewGroup r5 = (ViewGroup) r25.findViewById(2131385810);
        this.m = r5;
        FrameLayout r6 = (FrameLayout) r25.findViewById(2131389241);
        this.n = r6;
        FrameLayout r7 = (FrameLayout) r25.findViewById(2131389192);
        this.o = r7;
        this.p = LazyKt.lazy(new GiftMVIPanelView$topViewContainerParent$2(this));
        FrameLayout r8 = (FrameLayout) r25.findViewById(2131373160);
        this.q = r8;
        this.r = LazyKt.lazy(new GiftMVIPanelView$listViewContainer$2(this));
        ViewGroup r9 = (ViewGroup) r25.findViewById(2131388008);
        this.s = r9;
        FrameLayout r10 = (FrameLayout) r25.findViewById(2131383880);
        this.t = r10;
        this.u = r25.findViewById(2131373770);
        this.v = r25.findViewById(2131373698);
        FrameLayout r11 = (FrameLayout) r25.findViewById(2131389148);
        this.w = r11;
        ViewGroup r13 = (ViewGroup) r25.findViewById(2131392032);
        this.x = r13;
        FrameLayout r14 = (FrameLayout) r25.findViewById(2131389249);
        this.y = r14;
        FrameLayout r15 = (FrameLayout) r25.findViewById(2131385355);
        this.z = r15;
        this.A = r25.findViewById(2131385491);
        this.E = true;
        ViewGroup r16 = (ViewGroup) r25.findViewById(2131370479);
        this.K = r16;
        ViewGroup r4 = (ViewGroup) r25.findViewById(2131373939);
        this.L = r4;
        this.M = (ViewGroup) r25.findViewById(2131373940);
        Lazy r17 = LazyKt.lazy(new GiftMVIPanelView$dynamicPanelOldContainer$2(this));
        this.N = r17;
        this.O = LazyKt.lazy(new GiftMVIPanelView$detailTopViewContainer$2(this));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L33;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == true) goto L7;
        List r3 = CollectionsKt.mutableListOf(new Object[]{new GiftMVIReceiverView(r24, r5), new GiftMVIListView(r24, t(), r25, new GiftMVIPanelView$getPanelView$5(this)), new GiftMVITabView(r24, r9, r26), new GiftMVITopView(r24, r7, u(), r26), new GiftMVIUserInfoView(r24, r13), new GiftMVITopPanel(r24, r6), new GiftMVITopicView(r24, r14)});
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L31;
        r3.add(new GiftMVISearchView(r24, r15, r25));
    L31:
        List r18 = r3;
    L45:
        this.Q = r18;
        return;
    L7:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == false) goto L21;
        List r19 = CollectionsKt.mutableListOf(new Object[]{new GiftMVIListView(r24, t(), r25, new GiftMVIPanelView$getPanelView$1(this)), new GiftMVIDynamicPanel(r24, r16)});
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L12;
        r19.add(new GiftMVIGroupView(r24, r4, r26));
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L15;
        r19.add(new GiftMVISearchView(r24, r15, r25));
    L15:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L18;
        r19.add(new GiftMVITabView(r24, r9, r26));
    L18:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L20;
        r19.add(new GiftMVIReceiverView(r24, r5));
    L20:
        r18 = r19;
        goto L45
    L21:
        List r2 = CollectionsKt.mutableListOf(new Object[]{new GiftMVIReceiverView(r24, r5), new GiftMVIListView(r24, t(), r25, new GiftMVIPanelView$getPanelView$3(this)), new GiftMVIDynamicPanel(r24, r16), new GiftMVITopPanel(r24, r6)});
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L25;
        r2.add(new GiftMVIGroupView(r24, r4, r26));
    L25:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L27;
        r2.add(new GiftMVITabView(r24, r9, r26));
    L27:
        r18 = r2;
        goto L45
    L33:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L41;
        List r20 = CollectionsKt.mutableListOf(new Object[]{new GiftMVIReceiverView(r24, r5), new GiftMVIListView(r24, t(), r25, new GiftMVIPanelView$getPanelView$7(this)), new GiftMVIRechargeView(r24, r10, r26), new GiftMVITabView(r24, r9, r26), new GiftMVIDynamicPanel(r24, (ViewGroup) r17.getValue()), new GiftMVIDetailView(r24, s(), r26), new GiftMVIGroupView(r24, r4, r26)});
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == true) goto L38;
        r20.add(new GiftMVITopExchangeView(r24, r11, r26));
    L38:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L40;
        r20.add(new GiftMVISearchView(r24, r15, r25));
    L40:
        r18 = r20;
        goto L45
    L41:
        List r21 = CollectionsKt.mutableListOf(new Object[]{new GiftMVIReceiverView(r24, r5), new GiftMVIListView(r24, t(), r25, new GiftMVIPanelView$getPanelView$9(this)), new GiftMVITabView(r24, r9, r26), new GiftMVIRechargeView(r24, r10, r26), new GiftMVITopView(r24, r7, u(), r26), new GiftMVIMinorsNoticeView(r24, r8, r26), new GiftMVIDSNoticeView(r24, r6), new GiftMVITopExchangeView(r24, r11, r26), new GiftMVITopicView(r24, r14)});
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L44;
        r21.add(new GiftMVISearchView(r24, r15, r25));
    L44:
        r18 = r21;
        goto L45
    }

    public final void q(com.bytedance.android.anya.k r23, MVIState r24, Function1 r25) {
        GiftPanelState r3 = (GiftPanelState) r24;
        Intrinsics.checkNotNullParameter(r23, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r25, "dispatchDiff");
        com.bytedance.android.anya.u0<GiftPanelState, GiftReceiverViewState> r4 = r3.getReceiverState();
        com.bytedance.android.anya.k r5 = r23.a(r4);
        if (r5 == null) goto L53;
        r23.b.a.invoke(r4);
        GiftReceiverViewState r6 = (GiftReceiverViewState) r5.a;
        com.bytedance.android.anya.internal.c r10 = r6.getMode();
        com.bytedance.android.anya.internal.c r7 = r6.getShowNewReceiverPanel();
        Object r11 = r5.c.a(r10);
        if (r11 == null) goto L7;
        r5.b.a.invoke(r10);
    L8:
        Object r13 = r5.c.a(r7);
        if (r13 == null) goto L11;
        r5.b.a.invoke(r7);
    L12:
        if (r11 != null) goto L14;
        if (r13 == null) goto L53;
    L14:
        if (r11 != null) goto L16;
        r11 = r10.c();
    L16:
        if (r13 != null) goto L18;
        r13 = r7.c();
    L18:
        NewReceiverPanelStatus r14 = (NewReceiverPanelStatus) r13;
        GiftReceiverViewState.Mode r15 = (GiftReceiverViewState.Mode) r11;
        if (((Boolean) this.T.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L53;
        if (r15 != GiftReceiverViewState.Mode.IDLE) goto L31;
        this.T.put("cmd_gift_dialog_switch", new zg1.f0(this.u.getHeight(), true));
        View r8 = this.u;
        if ((r8 instanceof HSImageView) == true) goto L25;
        r8 = null;
    L25:
        HSImageView r9 = (HSImageView) r8;
        if (r9 == null) goto L30;
        GenericDraweeHierarchy r16 = r9.getHierarchy();
        if (r16 == null) goto L30;
        r16.setRoundingParams(RoundingParams.fromCornersRadii(s1.f(8.0f), s1.f(8.0f), 0.0f, 0.0f));
    L30:
        this.u.setBackgroundResource(2131249171);
        this.k = true;
        goto L53
    L31:
        this.T.put("cmd_gift_dialog_switch", new zg1.f0(this.u.getHeight() + this.m.getHeight(), true));
        this.k = false;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.b() == true) goto L34;
    L44:
        View r17 = this.u;
        if ((r17 instanceof HSImageView) == true) goto L47;
        r17 = null;
    L47:
        HSImageView r18 = (HSImageView) r17;
        if (r18 == null) goto L52;
        GenericDraweeHierarchy r19 = r18.getHierarchy();
        if (r19 == null) goto L52;
        r19.setRoundingParams(RoundingParams.fromCornersRadii(0.0f, s1.f(8.0f), 0.0f, 0.0f));
    L52:
        this.u.setBackgroundResource(2131249174);
        goto L53
    L34:
        if (r14 != NewReceiverPanelStatus.Show) goto L44;
        View r20 = this.u;
        if ((r20 instanceof HSImageView) == true) goto L38;
        r20 = null;
    L38:
        HSImageView r21 = (HSImageView) r20;
        if (r21 == null) goto L43;
        GenericDraweeHierarchy r26 = r21.getHierarchy();
        if (r26 == null) goto L43;
        r26.setRoundingParams(RoundingParams.fromCornersRadii(0.0f, s1.f(0.0f), 0.0f, 0.0f));
    L43:
        this.u.setBackgroundResource(2131249173);
        goto L53
    L11:
        r13 = null;
        goto L12
    L7:
        r11 = null;
    L53:
        com.bytedance.android.anya.u0<GiftPanelState, GiftTabViewState> r27 = r3.getTabState();
        com.bytedance.android.anya.k r28 = r23.a(r27);
        if (r28 == null) goto L73;
        r23.b.a.invoke(r27);
        com.bytedance.android.anya.r0<GiftTabViewState, Integer> r29 = ((GiftTabViewState) r28.a).getTabType();
        Object r110 = r28.c.a(r29);
        if (r110 == null) goto L73;
        r28.b.a.invoke(r29);
        int r30 = ((Number) r110).intValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L73;
        View r31 = this.u;
        if ((r31 instanceof HSImageView) == true) goto L63;
        r31 = null;
    L63:
        HSImageView r33 = (HSImageView) r31;
        if (r33 == null) goto L73;
        w1 r34 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).U(r30);
        if (r34 != null) goto L68;
    L72:
        Unit r35 = Unit.INSTANCE;
        goto L73
    L68:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.i(r34) == false) goto L70;
        ImageLoader.bindGifImage(r33, r34.getBackgroundImage());
    L71:
        Unit r36 = Unit.INSTANCE;
        goto L72
    L70:
        ImageLoader.bindDrawableResource(r33, 2131108453);
    L73:
        com.bytedance.android.anya.u0<GiftPanelState, GiftTopExchangeViewState> r37 = r3.getTopExchangeState();
        com.bytedance.android.anya.k r38 = r23.a(r37);
        if (r38 == null) goto L82;
        r23.b.a.invoke(r37);
        com.bytedance.android.anya.r0<GiftTopExchangeViewState, Integer> r39 = ((GiftTopExchangeViewState) r38.a).getGiftPanelType();
        Object r111 = r38.c.a(r39);
        if (r111 == null) goto L82;
        r38.b.a.invoke(r39);
        ((Number) r111).intValue();
        int r40 = com.bytedance.android.live.recharge.util.d.a;
        if (com.bytedance.android.live.recharge.util.d.b(this.R) == false) goto L82;
        if (this.u.getHeight() == 0) goto L82;
        this.T.put("cmd_gift_dialog_switch", new zg1.f0(this.u.getHeight() + s1.f(50.0f), true));
    L82:
        com.bytedance.android.anya.u0<GiftPanelState, GiftMinorsNoticeState> r41 = r3.getNoticeState();
        com.bytedance.android.anya.k r43 = r23.a(r41);
        if (r43 == null) goto L99;
        r23.b.a.invoke(r41);
        com.bytedance.android.anya.r0<GiftMinorsNoticeState, Boolean> r44 = ((GiftMinorsNoticeState) r43.a).getShouldShow();
        Object r112 = r43.c.a(r44);
        if (r112 == null) goto L99;
        r43.b.a.invoke(r44);
        boolean r45 = ((Boolean) r112).booleanValue();
        if (this.k == false) goto L99;
        this.l = r45;
        if (this.u.getHeight() == 0) goto L99;
        int r46 = this.u.getHeight();
        if (this.q.getVisibility() != 0) goto L94;
        if (r45 == false) goto L94;
        int r47 = s1.f(28.0f);
    L95:
        int r48 = r46 + r47;
        int r49 = com.bytedance.android.live.recharge.util.d.a;
        if (com.bytedance.android.live.recharge.util.d.b(this.R) == false) goto L98;
        r48 = r48 + s1.f(48.0f);
    L98:
        this.T.put("cmd_gift_dialog_switch", new zg1.f0(r48, true));
    L94:
        r47 = 0;
    L99:
        com.bytedance.android.anya.u0<GiftPanelState, GiftDSNoticeState> r50 = r3.getDsNoticeState();
        com.bytedance.android.anya.k r51 = r23.a(r50);
        if (r51 == null) goto L113;
        r23.b.a.invoke(r50);
        com.bytedance.android.anya.r0<GiftDSNoticeState, Integer> r53 = ((GiftDSNoticeState) r51.a).getDsHeight();
        Object r113 = r51.c.a(r53);
        if (r113 == null) goto L113;
        r51.b.a.invoke(r53);
        int r54 = ((Number) r113).intValue();
        if (this.k == false) goto L113;
        if (r54 == 0) goto L107;
        boolean r55 = true;
    L108:
        this.l = r55;
        int r56 = this.u.getHeight() + s1.f(r54);
        if (this.u.getHeight() == 0) goto L113;
        ia0.b r57 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ia0.b.class);
        if (r57 == null) goto L113;
        r57.Gh(DialogStatus.DIALOG_OPEN, r56);
        Unit r58 = Unit.INSTANCE;
        goto L113
    L107:
        r55 = false;
    L113:
        com.bytedance.android.anya.u0<GiftPanelState, GiftTopPanelViewState> r59 = r3.getGiftTopPanelState();
        com.bytedance.android.anya.k r60 = r23.a(r59);
        if (r60 == null) goto L129;
        r23.b.a.invoke(r59);
        com.bytedance.android.anya.r0<GiftTopPanelViewState, Integer> r61 = ((GiftTopPanelViewState) r60.a).getComponentHeight();
        Object r114 = r60.c.a(r61);
        if (r114 == null) goto L129;
        r60.b.a.invoke(r61);
        int r63 = ((Number) r114).intValue();
        if (this.k == false) goto L129;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L129;
        if (r63 == 0) goto L123;
        boolean r64 = true;
    L124:
        this.l = r64;
        int r65 = this.u.getHeight() + s1.f(r63);
        if (this.u.getHeight() == 0) goto L129;
        ia0.b r66 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ia0.b.class);
        if (r66 == null) goto L129;
        r66.Gh(DialogStatus.DIALOG_OPEN, r65);
        Unit r67 = Unit.INSTANCE;
        goto L129
    L123:
        r64 = false;
    L129:
        com.bytedance.android.anya.u0<GiftPanelState, GiftDynamicPanelState> r68 = r3.getGiftDynamicPanelState();
        com.bytedance.android.anya.k r69 = r23.a(r68);
        if (r69 == null) goto L141;
        r23.b.a.invoke(r68);
        com.bytedance.android.anya.r0<GiftDynamicPanelState, Boolean> r70 = ((GiftDynamicPanelState) r69.a).getNeedHideOperation();
        Object r115 = r69.c.a(r70);
        if (r115 == null) goto L141;
        r69.b.a.invoke(r70);
        if (((Boolean) r115).booleanValue() == false) goto L138;
        ViewGroup r71 = this.P;
        if (r71 == null) goto L141;
        UtilityKotlinExtentionsKt.t(r71);
        Unit r73 = Unit.INSTANCE;
        goto L141
    L138:
        ViewGroup r74 = this.P;
        if (r74 == null) goto L141;
        UtilityKotlinExtentionsKt.w(r74);
        Unit r75 = Unit.INSTANCE;
    L141:
        com.bytedance.android.anya.u0<GiftPanelState, GiftSearchViewState> r76 = r3.getSearchViewState();
        com.bytedance.android.anya.k r77 = r23.a(r76);
        if (r77 == null) goto L262;
        r23.b.a.invoke(r76);
        com.bytedance.android.anya.r0<GiftSearchViewState, Boolean> r78 = ((GiftSearchViewState) r77.a).getShow();
        Object r79 = r77.c.a(r78);
        if (r79 == null) goto L262;
        r77.b.a.invoke(r78);
        boolean r80 = ((Boolean) r79).booleanValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L262;
        zg1.f0 r81 = (zg1.f0) this.T.get("cmd_gift_dialog_switch");
        if (r81 == null) goto L150;
        int r83 = r81.a;
    L151:
        if (r83 > 0) goto L154;
        r83 = this.u.getHeight();
    L154:
        if (r80 == false) goto L161;
        FrameLayout r84 = this.z;
        if (r84 == null) goto L158;
        Integer r85 = Integer.valueOf(r84.getVisibility());
    L160:
        if (r85.intValue() == 0) goto L161;
    L168:
        boolean r86 = true;
    L171:
        if (r80 == false) goto L217;
        int r87 = r83 + ((int) com.bytedance.android.live.revenue.common.i.a(97));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L190;
        FrameLayout r88 = this.z;
        if (r88 == null) goto L177;
        Integer r89 = Integer.valueOf(r88.getVisibility());
    L179:
        if (r89.intValue() == 0) goto L190;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L184;
        int r210 = r87;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L211;
        AnimatorSet r1 = new AnimatorSet();
        this.G = r1;
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(383), com.bytedance.android.live.revenue.common.i.a(480)});
        if (r2 == null) goto L201;
        r2.addUpdateListener(new f0(this));
    L202:
        ObjectAnimator r90 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r91 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r93 = ObjectAnimator.ofFloat(this.t, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r94 = ObjectAnimator.ofFloat(s(), "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r95 = ObjectAnimator.ofFloat(this.M, "alpha", new float[]{1.0f, 0.0f});
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == true) goto L205;
        ObjectAnimator r116 = ObjectAnimator.ofFloat(this.w, "alpha", new float[]{1.0f, 0.0f});
    L206:
        ObjectAnimator r117 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{0.0f, 1.0f});
        r1.setDuration(300);
        r1.setInterpolator(new com.bytedance.android.live.core.widget.h());
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == true) goto L209;
        r1.playTogether(new Animator[]{r2, r90, r91, r93, r94, r95, r116, r117});
    L210:
        r1.addListener(new g0(this));
        r1.start();
    L216:
        int r96 = r210;
    L260:
        if (r86 == false) goto L262;
        this.T.put("cmd_gift_dialog_switch", new zg1.f0(r96, true));
        goto L262
    L209:
        r1.playTogether(new Animator[]{r2, r90, r91, r93, r94, r95, r117});
        goto L210
    L205:
        r116 = null;
        goto L206
    L201:
        r2 = null;
        goto L202
    L211:
        AnimatorSet r97 = new AnimatorSet();
        this.G = r97;
        ValueAnimator r98 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(383), com.bytedance.android.live.revenue.common.i.a(480)});
        if (r98 == null) goto L214;
        r98.addUpdateListener(new d0(this));
        ValueAnimator r99 = r98;
    L215:
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.y, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r101 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.t, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(u(), "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r118 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{0.0f, 1.0f});
        r97.setDuration(300);
        r97.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r97.playTogether(new Animator[]{r99, r100, r101, r102, r103, r104, r118});
        r97.addListener(new e0(this));
        r97.start();
        goto L216
    L214:
        r99 = null;
        goto L215
    L184:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L191;
        AnimatorSet r105 = new AnimatorSet();
        this.G = r105;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(383), com.bytedance.android.live.revenue.common.i.a(480)});
        if (r106 == null) goto L188;
        r106.addUpdateListener(new b0(this));
    L189:
        ObjectAnimator r119 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this.M, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r120 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{0.0f, 1.0f});
        r105.setDuration(300);
        r105.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r105.playTogether(new Animator[]{r106, r119, r107, r108, r120});
        r105.addListener(new c0(this));
        r105.start();
        goto L190
    L188:
        r106 = null;
        goto L189
    L191:
        AnimatorSet r109 = new AnimatorSet();
        this.G = r109;
        ValueAnimator r121 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(383), com.bytedance.android.live.revenue.common.i.a(480)});
        if (r121 == null) goto L194;
        r121.addUpdateListener(new z(this));
    L195:
        ObjectAnimator r122 = ObjectAnimator.ofFloat(this.y, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r123 = ObjectAnimator.ofFloat(u(), "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r124 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r125 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r126 = ObjectAnimator.ofFloat(this.x, "alpha", new float[]{1.0f, 0.0f});
        r210 = r87;
        ObjectAnimator r127 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{0.0f, 1.0f});
        r109.setDuration(300);
        r109.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r109.playTogether(new Animator[]{r121, r122, r123, r124, r125, r126, r127});
        r109.addListener(new a0(this));
        r109.start();
        goto L216
    L194:
        r121 = null;
        goto L195
    L177:
        r89 = null;
    L190:
        r210 = r87;
        goto L216
    L217:
        r96 = r83 - ((int) com.bytedance.android.live.revenue.common.i.a(97));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L260;
        FrameLayout r128 = this.z;
        if (r128 == null) goto L222;
        Integer r129 = Integer.valueOf(r128.getVisibility());
    L224:
        if (r129.intValue() != 0) goto L260;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L241;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L235;
        AnimatorSet r130 = new AnimatorSet();
        this.H = r130;
        ValueAnimator r131 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(480), com.bytedance.android.live.revenue.common.i.a(383)});
        if (r131 == null) goto L233;
        r131.addUpdateListener(new t(this));
        ValueAnimator r132 = r131;
    L234:
        ObjectAnimator r133 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r134 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r135 = ObjectAnimator.ofFloat(this.M, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r136 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{1.0f, 0.0f});
        r130.setDuration(300);
        r130.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r130.playTogether(new Animator[]{r132, r133, r134, r135, r136});
        r130.addListener(new u(this));
        r130.start();
        goto L260
    L233:
        r132 = null;
        goto L234
    L235:
        AnimatorSet r137 = new AnimatorSet();
        this.H = r137;
        ValueAnimator r138 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(480), com.bytedance.android.live.revenue.common.i.a(383)});
        if (r138 == null) goto L238;
        r138.addUpdateListener(new r(this));
        ValueAnimator r139 = r138;
    L239:
        ObjectAnimator r140 = ObjectAnimator.ofFloat(this.y, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r141 = ObjectAnimator.ofFloat(u(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r142 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r143 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r144 = ObjectAnimator.ofFloat(this.x, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r145 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{1.0f, 0.0f});
        r137.setDuration(300);
        r137.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r137.playTogether(new Animator[]{r139, r140, r141, r142, r143, r144, r145});
        r137.addListener(new s(this));
        r137.start();
        goto L260
    L238:
        r139 = null;
        goto L239
    L241:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L255;
        AnimatorSet r146 = new AnimatorSet();
        this.G = r146;
        ValueAnimator r147 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(480), com.bytedance.android.live.revenue.common.i.a(383)});
        if (r147 == null) goto L245;
        r147.addUpdateListener(new x(this));
    L246:
        ObjectAnimator r148 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r149 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r150 = ObjectAnimator.ofFloat(this.t, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r151 = ObjectAnimator.ofFloat(s(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r152 = ObjectAnimator.ofFloat(this.M, "alpha", new float[]{0.0f, 1.0f});
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == true) goto L249;
        ObjectAnimator r153 = ObjectAnimator.ofFloat(this.w, "alpha", new float[]{0.0f, 1.0f});
    L250:
        ObjectAnimator r154 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{1.0f, 0.0f});
        r146.setDuration(300);
        r146.setInterpolator(new com.bytedance.android.live.core.widget.h());
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == true) goto L253;
        r146.playTogether(new Animator[]{r147, r148, r149, r150, r151, r152, r153, r154});
    L254:
        r146.addListener(new y(this));
        r146.start();
        goto L260
    L253:
        r146.playTogether(new Animator[]{r147, r148, r149, r150, r151, r152, r154});
        goto L254
    L249:
        r153 = null;
        goto L250
    L245:
        r147 = null;
        goto L246
    L255:
        AnimatorSet r155 = new AnimatorSet();
        this.H = r155;
        ValueAnimator r156 = ValueAnimator.ofFloat(new float[]{com.bytedance.android.live.revenue.common.i.a(480), com.bytedance.android.live.revenue.common.i.a(383)});
        if (r156 == null) goto L258;
        r156.addUpdateListener(new v(this));
        ValueAnimator r157 = r156;
    L259:
        ObjectAnimator r158 = ObjectAnimator.ofFloat(this.y, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r159 = ObjectAnimator.ofFloat(t(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r160 = ObjectAnimator.ofFloat(this.s, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r161 = ObjectAnimator.ofFloat(this.t, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r162 = ObjectAnimator.ofFloat(u(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r163 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{1.0f, 0.0f});
        r155.setDuration(300);
        r155.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r155.playTogether(new Animator[]{r157, r158, r159, r160, r161, r162, r163});
        r155.addListener(new w(this));
        r155.start();
        goto L260
    L258:
        r157 = null;
        goto L259
    L222:
        r129 = null;
        goto L224
    L158:
        r85 = null;
    L161:
        if (r80 == true) goto L169;
        FrameLayout r164 = this.z;
        if (r164 == null) goto L165;
        Integer r165 = Integer.valueOf(r164.getVisibility());
    L167:
        if (r165.intValue() != 0) goto L169;
    L165:
        r165 = null;
    L169:
        r86 = false;
        goto L171
    L150:
        r83 = 0;
    L262:
        r25.invoke(r23);
    }
}
