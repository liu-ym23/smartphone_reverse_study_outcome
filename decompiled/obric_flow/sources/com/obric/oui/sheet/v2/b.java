package com.obric.oui.sheet.v2;

import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.salamander.anniex.b0;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oui.R$id;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Dialog implements e {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f14484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f14485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadiusLayout f14486c;
    public FrameLayout d;
    public FrameLayout e;
    public FrameLayout f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f14489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OSheet$HeightMode f14490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14493n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14494o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14495p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Size f14496q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public jp.d f14497r;
    public b0 s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14498t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14499u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14502x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bytedance.ies.bullet.service.preload.a f14503y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14504z;

    @Override // com.obric.oui.sheet.v2.e
    public final void a() {
        d.h(this);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean b() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getBgColor() != 0) goto L6;
        return a.a.v(getRootContainer());
    L6:
        return ym.h.j(getBgColor());
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean d() {
        return !this.f14492m;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.obric.oui.sheet.v2.SheetAnimStyle$sheetHide$animBuilder$2, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.oui.sheet.v2.OSheetBase$performExitAnimation$2, java.lang.Object, kotlin.jvm.internal.Lambda] */
    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        int r5 = 2;
        Intrinsics.checkNotNullParameter(this, "this");
        getScaffoldController().f14511b.setOnApplyWindowInsetsListener(null);
        Intrinsics.checkNotNullParameter(this, "this");
        jp.d r10 = getRunningAnim();
        if (r10 == null) goto L6;
        int r11 = jp.d.d;
        r10.a(false);
    L6:
        final RadiusLayout r12 = getRootContainer();
        final Window r13 = h();
        final View r15 = getDimView();
        final boolean r14 = e();
        final boolean r16 = d();
        final c r17 = new c(this, r5);
        Intrinsics.checkNotNullParameter(r12, "<this>");
        int r18 = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (r14 == false) goto L14;
        if (r16 == false) goto L14;
        if (r13 == null) goto L14;
        r13.addFlags(2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L14:
        int r19 = com.lynx.tasm.utils.a.B(32, r12) + r12.getHeight();
        Pair r20 = o.c(r12.getHeight() / r18, false);
        float r21 = ((Number) r20.component1()).floatValue();
        float r22 = ((Number) r20.component2()).floatValue();
        final float r110 = r12.getTranslationY();
        final float r111 = r19;
        if (r16 == false) goto L23;
        if (r13 != null) goto L18;
    L17:
        float r112 = 0.0f;
    L26:
        int r113 = R$id.o_dialog_anim_out;
        Object r23 = r12.getTag(r113);
        if (r23 != null) goto L30;
    L28:
        r23 = null;
    L31:
        com.obric.common.oea.foundation.animation.builder.a r24 = (com.obric.common.oea.foundation.animation.builder.a) r23;
        if (r24 != null) goto L34;
        r24 = new com.obric.common.oea.foundation.animation.builder.a(r12);
        r12.setTag(r113, r24);
    L34:
        AnimationProperty$FloatProperty r114 = AnimationProperty$FloatProperty.TRANSLATION_Y;
        float r25 = r12.getTranslationY();
        com.obric.common.oea.foundation.animation.spec.spring.b r26 = ug.a.l(r21, r22);
        r26.f11323b = 1.0f;
        r24.c(r114, Float.valueOf(r25), r111, r26, Float.valueOf(0.0f));
        final float r27 = 0.0f;
        final float r115 = r112;
        ?? r28 = new SheetAnimStyle$sheetHide$animBuilder$2(r14, r16, r13, r110, r111, r115, r27, r15, r12, r17);
        Intrinsics.checkNotNullParameter(r28, "callback");
        r24.d = r28;
        xq.b.p(r12);
        ?? r29 = new OSheetBase$performExitAnimation$2(this);
        Intrinsics.checkNotNullParameter(r29, "callback");
        r24.e = r29;
        setRunningAnim(com.obric.common.oea.foundation.animation.builder.b.a(r24.b()));
        this.A = false;
        return;
    L30:
        if ((r23 instanceof com.obric.common.oea.foundation.animation.builder.a) == false) goto L28;
    L18:
        WindowManager.LayoutParams r116 = r13.getAttributes();
        if (r116 == null) goto L17;
        float r117 = r116.dimAmount;
    L22:
        r112 = r117;
        goto L26
    L23:
        if (r15 == null) goto L17;
        r117 = r15.getAlpha();
        goto L22
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean e() {
        if (this.f14487h == true) goto L5;
    L7:
        return false;
    L5:
        if (this.g == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final View f(int r5) {
        return findViewById(r5);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void g() {
        d.a(this, true);
        RadiusLayout r5 = getRootContainer();
        View r10 = getDimView();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.obric.oui.material.n.r(r10, r5);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.f14500v;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final int getBgColor() {
        return this.f14504z;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final FrameLayout getBodyContainer() {
        FrameLayout r5 = this.f;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final int getBodyContentPaddingBottom() {
        return this.f14499u;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final int getBodyContentPaddingTop() {
        return this.f14498t;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final ComponentCallbacks getConfigurationCallback() {
        return this.f14503y;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean getConfigurationCallbackRegistered() {
        return this.f14502x;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final View getDimView() {
        View r5 = this.f14485b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean getEnableMaterial() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final FrameLayout getFooterContainer() {
        FrameLayout r5 = this.e;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final Size getFullWindowSize() {
        return this.f14496q;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final FrameLayout getHeaderContainer() {
        FrameLayout r5 = this.d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final OSheet$HeightMode getHeightStyle() {
        return this.f14490k;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean getIgnoreInsetBottom() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final RadiusLayout getRootContainer() {
        RadiusLayout r5 = this.f14486c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final jp.d getRunningAnim() {
        return this.f14497r;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final ViewGroup getScaffoldContainer() {
        ViewGroup r5 = this.f14484a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final m getScaffoldController() {
        m r5 = this.f14489j;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final Context getSheetContext() {
        return getContext();
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean getShowing() {
        return this.f14501w;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final int getUserWindowHeight() {
        return this.f14495p;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final int getUserWindowWidth() {
        return 0;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final Window h() {
        return getWindow();
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void i() {
    L6:
        e = move-exception;
        Log.e("OSheet", "origin Dismiss exception!", e);
        return;
    L3:
        if (isShowing() == false) goto L11;
        super.dismiss();     // Catch: Exception -> L6
        return;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void j() {
        d.b(this);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void k() {
        Intrinsics.checkNotNullParameter(this, "this");
        getScaffoldController().a();
    }

    public final void l() {
        this.f14497r = null;     // Catch: Exception -> L7
        setOnDismissListener(null);     // Catch: Exception -> L7
        if (isShowing() == false) goto L12;
        super.dismiss();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.e("OSheet", "dismissImmediately exception!", e);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (r5 == null) goto L5;
        return;
    L5:
        if (this.f14488i == false) goto L9;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == true) goto L6;
        getSheetContext().registerComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(true);
    L6:
        Intrinsics.checkNotNullParameter(this, "this");
        getScaffoldController().a();
        getRootContainer().post(new c(this, 1));
    }

    @Override // android.app.Dialog
    public final void onStop() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == false) goto L6;
        getSheetContext().unregisterComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(false);
    L6:
        super.onStop();
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setAutoAddBodyPaddingTopWhenOverlay(boolean r5) {
        throw null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setBgColor(int r5) {
        this.f14504z = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setBodyContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setBodyContentPaddingBottom(int r5) {
        this.f14499u = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setBodyContentPaddingTop(int r5) {
        this.f14498t = r5;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r5) {
        super.setCanceledOnTouchOutside(r5);
        this.f14494o = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setConfigurationCallbackRegistered(boolean r5) {
        this.f14502x = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setFooterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.e = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setFullWindowSize(Size r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14496q = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setHeaderContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.d = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setHeightStyle(OSheet$HeightMode r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14490k = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setMCancelable(boolean r5) {
        throw null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setRootContainer(RadiusLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14486c = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setRunningAnim(jp.d r5) {
        this.f14497r = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setScaffoldContainer(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14484a = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setScaffoldController(m r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14489j = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void setupDimView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        View r10 = new View(r5);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f14485b = r10;
        if ((getRootContainer().getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r11 = getRootContainer().getParent();
        if (r11 == null) goto L8;
        ((ViewGroup) r11).addView(getDimView(), 0, new ViewGroup.LayoutParams(-1, -1));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // android.app.Dialog
    public final void show() {
        if (this.f14501w == false) goto L5;
        d.h(this);
        getScaffoldController().b(this.f14496q);
    L9:
        super.show();
        Intrinsics.checkNotNullParameter(this, "this");
        final m r5 = getScaffoldController();
        r5.getClass();
        r5.f14511b.setOnApplyWindowInsetsListener(new k(r5));
        Window r10 = getWindow();
        if (r10 == null) goto L71;
        r10.setBackgroundDrawableResource(R.color.transparent);
        r10.setNavigationBarContrastEnforced(false);
        r10.clearFlags(134217728);
        r10.addFlags(Integer.MIN_VALUE);
        r10.setNavigationBarColor(0);
        r10.setDecorFitsSystemWindows(false);
        r10.setNavigationBarDividerColor(0);
        if ((getContext().getResources().getConfiguration().uiMode & 48) == 32) goto L15;
        boolean r11 = true;
    L16:
        WindowInsetsController r12 = r10.getInsetsController();
        if (r12 == null) goto L23;
        if (r11 == false) goto L21;
        int r13 = 8;
    L22:
        r12.setSystemBarsAppearance(r13, 8);
        goto L23
    L21:
        r13 = 0;
    L23:
        WindowInsetsController r14 = r10.getInsetsController();
        if (r14 == null) goto L32;
        if (r11 == false) goto L29;
        int r15 = 16;
    L30:
        r14.setSystemBarsAppearance(r15, 16);
        goto L32
    L29:
        r15 = 0;
    L32:
        if (this.g == false) goto L34;
        r10.clearFlags(2);
    L35:
        Context r16 = r10.getContext();
        Intrinsics.checkNotNullParameter(r16, "context");
        if ((r16.getResources().getConfiguration().uiMode & 48) != 32) goto L38;
        float r17 = 0.5f;
    L39:
        WindowManager.LayoutParams r18 = r10.getAttributes();
        OSheet$HeightMode r19 = this.f14490k;
        OSheet$HeightMode r20 = OSheet$HeightMode.FULL_HEIGHT;
        boolean r21 = this.f14492m;
        if (r19 == r20) goto L44;
        if (r21 == true) goto L44;
        boolean r22 = false;
    L45:
        this.f14493n = r22;
        if (r21 == true) goto L48;
    L51:
        com.lynx.tasm.utils.d.s(getDimView());
    L53:
        if (this.f14501w == true) goto L56;
        r18.dimAmount = 0.0f;
        getDimView().setAlpha(0.0f);
    L56:
        if (e() == true) goto L58;
    L59:
        if (r21 == true) goto L61;
        r18.dimAmount = r17;
    L63:
        if (this.f14493n == false) goto L65;
        int r23 = -1;
    L66:
        r10.setLayout(-1, r23);
        if (this.f14493n == false) goto L69;
        r18.setFitInsetsSides(0);
    L70:
        r18.layoutInDisplayCutoutMode = 3;
        r18.gravity = 80;
        r18.windowAnimations = 0;
        r10.setAttributes(r18);
        goto L71
    L69:
        r18.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        goto L70
    L65:
        r23 = -2;
        goto L66
    L61:
        r18.dimAmount = 0.0f;
        getDimView().setAlpha(r17);
        goto L63
    L58:
        if (this.f14488i == true) goto L63;
    L48:
        if (this.g == true) goto L51;
        com.lynx.tasm.utils.d.t(getDimView());
    L44:
        r22 = true;
        goto L45
    L38:
        r17 = 0.16f;
        goto L39
    L34:
        r10.addFlags(2);
        goto L35
    L15:
        r11 = false;
    L71:
        this.f14501w = true;
        return;
    L5:
        if (this.f14494o == false) goto L7;
        getDimView().setOnClickListener(new a(this));
        goto L9
    L7:
        getDimView().setOnClickListener(null);
        goto L9
    }
}
