package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import cn.nubia.neopush.commons.Constant;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.oui.graphic.BlendMode;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends com.obric.flow.cardlistpage.mvi.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f11687w = null;
    public final com.bytedance.sdk.xbridge.cn.auth.g d;
    public final WeakReference e;
    public Function1 f;
    public Function1 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PathInterpolator f11689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnimatorSet f11691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f11692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.obric.oui.orecyclerview.base.e f11693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ControllerState f11694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f11695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f11696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f11697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11698r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f11699t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f11700u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function0 f11701v;

    static {
        f11687w = new h();
    }

    public p(CardFeedLayout r5, com.obric.flow.cardlistpage.ui.component.feedlist.w r10, CoroutineScope r11, CardFeedLayout r12) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "store");
        Intrinsics.checkNotNullParameter(r11, "coroutineScope");
        Intrinsics.checkNotNullParameter(r12, "parent");
        super(r10, r11, r12);
        this.d = new com.bytedance.sdk.xbridge.cn.auth.g(9);
        this.e = new WeakReference(r5);
        this.f11688h = r5.getResources().getDisplayMetrics().widthPixels;
        this.f11689i = new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f);
        this.f11693m = new com.obric.oui.orecyclerview.base.e();
        this.f11694n = ControllerState.HIDDEN;
        this.f11697q = Float.NaN;
        this.f11698r = -1;
        this.s = -1.0f;
        this.f11699t = -1;
        this.f11700u = Float.NaN;
        i();
    }

    public static void k(p r5, boolean r10, Function0 r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        r5.f11701v = r11;
        v r13 = new v(r10, "");
        Intrinsics.checkNotNullParameter(r13, "intent");
        r5.d(r13);
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void g(com.obric.flow.cardlistpage.mvi.e r10) {
        g r11 = (g) r10;
        Intrinsics.checkNotNullParameter(r11, Constant.COMMAND);
        boolean r5 = r11 instanceof d;
        h0 r12 = e0.f11657a;
        boolean r13 = true;
        float r14 = 0.0f;
        com.bytedance.sdk.xbridge.cn.auth.g r15 = this.d;
        if (r5 == false) goto L21;
        j0 r16 = o();
        d r17 = (d) r11;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "current");
        if (r16.f11672b == ControllerState.HIDDEN) goto L7;
    L9:
        r13 = false;
    L10:
        boolean r18 = r17.f11652a;
        if (r18 == true) goto L15;
        if (r13 == false) goto L15;
    L19:
        p(r12);
        return;
    L15:
        if (r17.f11653b == false) goto L18;
        h0 r19 = new d0(r18);
    L17:
        r12 = r19;
        goto L19
    L18:
        r19 = new g0(r18);
        goto L17
    L7:
        if (r16.f11673c != 0.0f) goto L9;
    L21:
        if ((r11 instanceof b) == false) goto L42;
        j0 r20 = o();
        b r21 = (b) r11;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r20, "current");
        Intrinsics.checkNotNullParameter(r20, "current");
        float r22 = r21.f11648a;
        if (r22 > 200.0f) goto L31;
        if (r22 >= (-200.0f)) goto L29;
    L27:
        r13 = false;
        goto L31
    L29:
        if (r20.f11673c <= 0.6f) goto L27;
    L31:
        if (r20.f == false) goto L34;
    L40:
        p(r12);
        return;
    L34:
        if (r13 == r20.f11671a) goto L37;
        r12 = new d0(r13);
        goto L40
    L37:
        if (r21.f11649b == false) goto L39;
        r12 = new f0(r22);
        goto L40
    L39:
        r12 = new d0(r13);
        goto L40
    L42:
        if ((r11 instanceof f) == false) goto L45;
        f r23 = (f) r11;
        a0 r24 = new a0(r23.f11658a, r23.f11659b, r23.f11660c);
        Intrinsics.checkNotNullParameter(r24, "intent");
        d(r24);
        return;
    L45:
        if ((r11 instanceof e) == false) goto L80;
        e r25 = (e) r11;
        ValueAnimator r26 = this.f11692l;
        if (r26 == null) goto L49;
        r26.cancel();
    L49:
        this.f11692l = null;
        CardFeedLayout r27 = (CardFeedLayout) this.e.get();
        if (r27 != null) goto L53;
        return;
    L53:
        if (this.f11696p != null) goto L55;
        this.f11696p = r27.findViewById(R$id.widget_layer);
    L55:
        float r28 = this.f11688h;
        float r29 = r27.getX();
        float r30 = r27.getX() + r25.f11655a;
        if (r29 != r30) goto L58;
    L74:
        r14 = r29;
    L75:
        View r31 = this.f11696p;
        if (r31 == null) goto L93;
        r31.setX(r14);
        return;
    L93:
        return;
    L58:
        if (r29 == r28) goto L74;
        if (0.0f >= r28) goto L66;
        if (r30 >= 0.0f) goto L66;
    L64:
        r14 = r30;
    L66:
        if (0.0f > r28) goto L68;
    L70:
        float r32 = r28 - 0.0f;
        float r33 = (((r30 - 0.0f) * 0.55f) / r32) + 1.0f;
        if (r33 == 0.0f) goto L75;
        r14 = 0.0f + ((1.0f - (1.0f / r33)) * r32);
        goto L75
    L68:
        if (r30 <= 0.0f) goto L70;
    L80:
        if (Intrinsics.areEqual(r11, c.f11651a) == false) goto L83;
        m();
        p(new g0(false));
        return;
    L83:
        if (Intrinsics.areEqual(r11, a.f11644a) == false) goto L91;
        m();
        return;
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void h() {
        CardFeedLayout r5 = (CardFeedLayout) this.e.get();
        if (r5 == null) goto L6;
        r5.postDelayed(new androidx.fragment.app.d(this, 25), 1000);
        return;
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void j() {
        OverlayAnimatorComponent$observeState$$inlined$collectState$1 r5 = new OverlayAnimatorComponent$observeState$$inlined$collectState$1(null, this, this);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r5, 3, null);
        OverlayAnimatorComponent$observeState$$inlined$collectState$2 r10 = new OverlayAnimatorComponent$observeState$$inlined$collectState$2(null, this, this);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r10, 3, null);
    }

    public final void l(float r10, float r11, boolean r12) {
        CardFeedLayout r5 = (CardFeedLayout) this.e.get();
        if (r5 != null) goto L5;
        return;
    L5:
        float r13 = RangesKt.coerceIn(r10, 0.0f, 1.0f);
        this.f11690j = r13;
        if (this.f11700u == r13) goto L12;
        this.f11700u = r13;
        Function1 r14 = this.g;
        if (r14 == null) goto L12;
        r14.invoke(new s(r13));
    L12:
        if (this.f11695o != null) goto L15;
        this.f11695o = r5.findViewById(R$id.container_view);
    L15:
        if (this.f11696p != null) goto L17;
        this.f11696p = r5.findViewById(R$id.widget_layer);
    L17:
        float r15 = MathKt.roundToInt((r13 - 1) * this.f11688h);
        if (r12 == false) goto L21;
        r15 = -r15;
    L21:
        if (this.f11697q == r15) goto L28;
        View r16 = this.f11695o;
        if (r16 == null) goto L27;
        r16.setTranslationX(r15);
    L27:
        this.f11697q = r15;
    L28:
        View r17 = this.f11696p;
        if (r17 == null) goto L31;
        Float r18 = Float.valueOf(r17.getTranslationX());
    L33:
        if (Intrinsics.areEqual(r18, 0.0f) == true) goto L39;
        View r19 = this.f11696p;
        if (r19 == null) goto L39;
        r19.setTranslationX(0.0f);
    L39:
        if (r5.getAlpha() == r11) goto L42;
        r5.setAlpha(r11);
    L42:
        t(r13, true);
        return;
    L31:
        r18 = null;
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m() {
        if (q() == true) goto L5;
        return;
    L5:
        this.f11701v = null;
        n();
        float r5 = this.f11690j;
        CardFeedLayout r10 = (CardFeedLayout) this.e.get();
        com.obric.flow.cardlistpage.mvi.a r11 = (com.obric.flow.cardlistpage.mvi.a) this.f11531a;
        if (r10 == null) goto L8;
        float r12 = r10.getAlpha();
    L9:
        l(r5, r12, ((Boolean) ((u) r11.b()).f.getValue()).booleanValue());
        return;
    L8:
        r12 = ((u) r11.b()).b();
        goto L9
    }

    public final void n() {
        AnimatorSet r5 = this.f11691k;
        if (r5 == null) goto L5;
        r5.cancel();
    L5:
        this.f11691k = null;
        ValueAnimator r10 = this.f11692l;
        if (r10 == null) goto L8;
        r10.cancel();
    L8:
        this.f11692l = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j0 o() {
        com.obric.flow.cardlistpage.mvi.a r5 = (com.obric.flow.cardlistpage.mvi.a) this.f11531a;
        boolean r10 = ((Boolean) ((u) r5.b()).f11705a.getValue()).booleanValue();
        ControllerState r11 = this.f11694n;
        float r12 = this.f11690j;
        CardFeedLayout r13 = (CardFeedLayout) this.e.get();
        if (r13 == null) goto L6;
        float r14 = r13.getAlpha();
    L5:
        float r15 = r14;
        if (((OverlayTransitionMode) ((u) r5.b()).g.getValue()) != OverlayTransitionMode.DRAG) goto L11;
        boolean r16 = true;
    L10:
        boolean r17 = r16;
        boolean r18 = q();
        this.d.getClass();
        Intrinsics.checkNotNullParameter(r11, "controllerState");
        return new j0(r10, r11, RangesKt.coerceIn(r12, 0.0f, 1.0f), r15, r17, r18);
    L11:
        r16 = false;
        goto L10
    L6:
        r14 = ((u) r5.b()).b();
        goto L5
    }

    public final void p(h0 r5) {
        if ((r5 instanceof g0) == false) goto L6;
        z r10 = new z(((g0) r5).f11662a);
        Intrinsics.checkNotNullParameter(r10, "intent");
        d(r10);
        return;
    L6:
        if ((r5 instanceof d0) == false) goto L9;
        k(this, ((d0) r5).f11654a, null, 6);
        return;
    L9:
        if ((r5 instanceof f0) == false) goto L17;
        j0 r11 = o();
        if (r11.f11671a == true) goto L13;
        k(this, false, null, 6);
        return;
    L13:
        if (r11.f11673c != 1.0f) goto L15;
        r();
        return;
    L15:
        k(this, true, new OverlayAnimatorComponent$performOverscrollSpringBack$1(this), 4);
        return;
    L17:
        Intrinsics.areEqual(r5, e0.f11657a);
    }

    public final boolean q() {
        AnimatorSet r5 = this.f11691k;
        if (r5 != null) goto L5;
    L7:
        ValueAnimator r10 = this.f11692l;
        if (r10 != null) goto L10;
    L12:
        return false;
    L10:
        if (r10.isRunning() != true) goto L12;
        return true;
    L5:
        if (r5.isRunning() != true) goto L7;
        return true;
    }

    public final void r() {
        View r5 = this.f11696p;
        if (r5 != null) goto L8;
        CardFeedLayout r10 = (CardFeedLayout) this.e.get();
        if (r10 == null) goto L7;
        r5 = r10.findViewById(R$id.widget_layer);
        goto L8
    L7:
        r5 = null;
    L8:
        this.f11696p = r5;
        if (r5 != null) goto L11;
        return;
    L11:
        ValueAnimator r11 = this.f11692l;
        if (r11 == null) goto L14;
        r11.cancel();
    L14:
        this.f11692l = null;
        float r12 = r5.getX();
        if (r12 > 0.0f) goto L18;
        r5.setX(0.0f);
        return;
    L18:
        com.obric.oui.orecyclerview.base.e r13 = this.f11693m;
        r13.f13714c = 15.707964f;
        r13.f13712a = r12;
        r13.f13713b = (15.707964f * r12) + 400.0f;
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r14.setRepeatCount(-1);
        r14.addUpdateListener(new i(this, r5, r14, 0));
        r14.addListener(new o(this, r5));
        r14.start();
        this.f11692l = r14;
    }

    public final void s(int r10, int r11, float r12, boolean r13) {
        CardFeedLayout r5 = (CardFeedLayout) this.e.get();
        if (r5 != null) goto L5;
        return;
    L5:
        float r14 = r10;
        if (com.obric.oui.material.n.j() == false) goto L16;
        Object r15 = com.obric.oui.material.n.d(r5);
        HashMap r16 = com.obric.oui.material.n.f13678b;
        Method r17 = (Method) r16.get("setObricBlurEffect_1");
        if (r17 == null) goto L31;
    L13:
        r17.invoke(r15, new Object[]{Float.valueOf(r14)});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "setBlurEffect 1 param error: ", "OMaterialHelper");
        goto L16
    L31:
        r17 = Class.forName("android.view.IExtEffect").getDeclaredMethod("setObricBlurEffect", new Class[]{Float.TYPE});     // Catch: Exception -> L11
        r17.setAccessible(true);     // Catch: Exception -> L11
        r16.put("setObricBlurEffect_1", r17);     // Catch: Exception -> L11
    L16:
        if (r13 == true) goto L18;
    L29:
        com.obric.oui.material.n.l(new int[]{r11, BlendMode.LUMINOSITY.porterDuffMode}, r5);
        return;
    L18:
        if (r12 == this.s) goto L29;
        int r18 = (int) r12;
        Object r19 = com.obric.oui.material.n.e(r5);
        HashMap r20 = com.obric.oui.material.n.f13678b;
        Method r21 = (Method) r20.get("setWindowBackgroundBlurUvOffset");
        if (r21 == null) goto L33;
    L25:
        r21.invoke(r19, new Object[]{Integer.valueOf(r18), Integer.valueOf(r18)});     // Catch: Exception -> L23
    L28:
        this.s = r12;
    L23:
        e = move-exception;
        Log.e("OMaterialHelper", "setWindowBackgroundBlurUvOffset error: ", e);
        goto L28
    L33:
        Class<?> r22 = Class.forName("android.view.IExtView");     // Catch: Exception -> L23
        Class r23 = Integer.TYPE;     // Catch: Exception -> L23
        r21 = r22.getDeclaredMethod("setWindowBackgroundBlurUvOffset", new Class[]{r23, r23});     // Catch: Exception -> L23
        r21.setAccessible(true);     // Catch: Exception -> L23
        r20.put("setWindowBackgroundBlurUvOffset", r21);     // Catch: Exception -> L23
        goto L25
    }

    public final void t(float r5, boolean r10) {
        int r11 = MathKt.roundToInt(60.0f * r5);     // Catch: Exception -> L8
        int r12 = ((int) (128 * r5)) << 24;     // Catch: Exception -> L8
        if (r11 == this.f11699t) goto L6;
    L10:
        if (r11 <= 0) goto L12;
        float r13 = r5 * 50.0f;     // Catch: Exception -> L8
    L13:
        s(r11, r12, r13, r10);     // Catch: Exception -> L8
        this.f11699t = r11;     // Catch: Exception -> L8
        this.f11698r = r12;     // Catch: Exception -> L8
        return;
    L12:
        r13 = 0.0f;
        goto L13
    L6:
        if (r12 != this.f11698r) goto L10;
        return;
    L8:
        e = move-exception;
        Intrinsics.checkNotNullParameter("OverlayAnimatorComponent", "tag");
        Intrinsics.checkNotNullParameter("updateWindowBlur error", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r14 = su.a.f22013b;
        if (r14 == null) goto L20;
        ((ju.b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("OverlayAnimatorComponent", "updateWindowBlur error", e);
        return;
    L20:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
