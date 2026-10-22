package com.obric.oui.dialog.base;

import android.R;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.provider.Settings;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.n;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends Dialog implements nr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f13104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f13105c;
    public final View d;
    public boolean e;
    public boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13108j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13109k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f13110l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f13111m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f13112n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f13113o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f13114p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final bb.b f13115q;
    public View rootView;

    /* JADX WARN: Type inference failed for: r7v2, types: [com.obric.oui.dialog.base.a] */
    public d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.f13103a = "AbstractDialog";
        this.e = true;
        this.g = true;
        this.f13107i = 81;
        Window r5 = getWindow();
        if (r5 == null) goto L6;
        r5.requestFeature(1);
    L6:
        Window r11 = getWindow();
        if (r11 == null) goto L10;
        r11.addFlags(512);
    L10:
        setContentView(R$layout.o_base_dialog);
        View r12 = findViewById(R$id.root_view);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.rootView = r12;
        if ((b().getBackground() instanceof ColorDrawable) == false) goto L18;
        Drawable r13 = b().getBackground();
        if (r13 == null) goto L16;
        ((ColorDrawable) r13).getColor();
    L27:
        b().setAlpha(0.0f);
        this.f13105c = (ImageView) findViewById(R$id.btn_close);
        this.f13104b = findViewById(R$id.close_container);
        d(null);
        ViewStub r14 = (ViewStub) findViewById(R$id.contentView);
        r14.setLayoutResource(R$layout.o_alert_dialog_v2);
        View r15 = r14.inflate();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        this.d = r15;
        View r16 = b();
        Intrinsics.checkNotNullParameter(r16, "container");
        int r17 = com.lynx.tasm.utils.a.B(10, r16);
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19.topMargin >= r17) goto L32;
        r19.topMargin = r17;
    L32:
        r16.setLayoutParams(r18);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (n.i(r10) == true) goto L35;
    L46:
        final com.obric.oui.dialog.v2.alert.b r20 = (com.obric.oui.dialog.v2.alert.b) this;
        this.f13114p = new a(r20);
        this.f13115q = new bb.b(r20, Looper.getMainLooper(), 3);
        return;
    L35:
        if (n.k() == false) goto L46;
        b().setBackgroundColor(0);
        com.obric.oui.material.c[] r21 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!a.a.v(b())));
        a.a.A(b(), r21);
        if (Settings.Global.getInt(r10.getContentResolver(), "obric_current_effect_id", 2) != 1) goto L39;
    L40:
        com.obric.oui.color.d r22 = r21[0].e;
        if (r22 == null) goto L46;
        if ((b() instanceof DialogRootView) == false) goto L46;
        ((DialogRootView) b()).b(r22.f12424b, com.lynx.tasm.utils.a.q(r10, r22.f12423a));
        goto L46
    L39:
        if (r21.length != 1) goto L46;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L18:
        if ((b().getBackground() instanceof GradientDrawable) == false) goto L27;
        Drawable r23 = b().getBackground();
        if (r23 == null) goto L26;
        ColorStateList r24 = ((GradientDrawable) r23).getColor();
        if (r24 == null) goto L27;
        r24.getDefaultColor();
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    public static void e(View r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        ViewGroup r11 = null;
        if ((r5 instanceof RadiusLayout) == false) goto L5;
        RadiusLayout r12 = (RadiusLayout) r5;
    L6:
        if (r12 != null) goto L8;
        Unit r13 = null;
    L9:
        if (r13 == null) goto L11;
        return;
    L11:
        if ((r5 instanceof ViewGroup) == false) goto L13;
        r11 = (ViewGroup) r5;
    L13:
        if (r11 == null) goto L18;
        r11.suppressLayout(r10);
        return;
    L18:
        return;
    L8:
        r12.setSuppressChildMeasureAndLayout(r10);
        r13 = Unit.INSTANCE;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public final void a(View r5, boolean r10) {
        this.f = false;
        if (r10 == false) goto L5;
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        r11.height = -2;
        r5.setLayoutParams(r11);
        r5.requestLayout();
    L5:
        e(r5, false);
    }

    public final View b() {
        View r5 = this.rootView;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    @Override // nr.a
    public final boolean c() {
        return this.e;
    }

    public final void d(View.OnClickListener r5) {
        ImageView r10 = this.f13105c;
        if (r10 == null) goto L10;
        com.lynx.tasm.utils.d.n(com.lynx.tasm.utils.a.p(44, getContext()), r10);
        View r11 = this.f13104b;
        if (r11 == null) goto L11;
        com.lynx.tasm.utils.d.s(r11);
        return;
    L11:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        b().setOnApplyWindowInsetsListener(null);
        ValueAnimator r5 = this.f13110l;
        if (r5 == null) goto L6;
        r5.cancel();
    L6:
        this.f13106h = false;
        super.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ps.a.b(e, this.f13103a, "origin Dismiss exception!");
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        this.f13115q.removeCallbacksAndMessages(null);
        ViewGroup r5 = ((com.obric.oui.dialog.v2.alert.b) this).A;
        if (r5 != null) goto L5;
    L7:
        if (r5 == null) goto L9;
        e(r5, false);
    L9:
        ViewGroup r10 = ((com.obric.oui.dialog.v2.alert.b) this).A;
        if (r10 == null) goto L13;
        r10.getViewTreeObserver();
    L13:
        if (r10 == null) goto L17;
        r10.removeOnLayoutChangeListener(this.f13114p);
        return;
    L17:
        return;
    L5:
        if (this.f == false) goto L7;
        a(r5, true);
        goto L9
    }

    @Override // android.app.Dialog
    public void show() {
        b().setOnApplyWindowInsetsListener(new b(this));
        super.show();
        ViewGroup r5 = ((com.obric.oui.dialog.v2.alert.b) this).A;
        if (r5 == null) goto L7;
        a r10 = this.f13114p;
        r5.removeOnLayoutChangeListener(r10);
        r5.addOnLayoutChangeListener(r10);
    L7:
        if (isShowing() == false) goto L13;
        Window r11 = getWindow();
        if (r11 == null) goto L13;
        r11.getAttributes();
    L13:
        Window r12 = getWindow();
        if (r12 == null) goto L30;
        if (this.f13106h == false) goto L19;
        return;
    L19:
        r12.setBackgroundDrawableResource(R.color.transparent);
        Window r13 = getWindow();
        if (r13 == null) goto L23;
        r13.setWindowAnimations(0);
    L23:
        r12.addFlags(2);
        r12.setNavigationBarContrastEnforced(false);
        r12.clearFlags(134217728);
        r12.addFlags(Integer.MIN_VALUE);
        r12.setNavigationBarColor(0);
        r12.setDecorFitsSystemWindows(false);
        r12.setNavigationBarDividerColor(0);
        WindowManager.LayoutParams r14 = r12.getAttributes();
        r14.gravity = this.f13107i;
        r14.x = 0;
        r14.y = this.f13108j;
        r14.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r14.height = -2;
        Size r15 = com.lynx.tasm.utils.j.n(r12.getContext());
        int r16 = Math.min(r15.getWidth(), r15.getHeight());
        Intrinsics.checkNotNullParameter(r12, "<this>");
        int r17 = r16 - (r12.getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_layout_margin) * 2);
        View r18 = b();
        ViewGroup.LayoutParams r19 = b().getLayoutParams();
        r19.width = r17;
        r18.setLayoutParams(r19);
        int r20 = View.MeasureSpec.makeMeasureSpec(r17, Integer.MIN_VALUE);
        b().measure(r20, 0);
        if (r15.getWidth() >= r15.getHeight()) goto L28;
        int r21 = r15.getHeight() - com.lynx.tasm.utils.a.p(232, r12.getContext());
        if (b().getMeasuredHeight() <= r21) goto L28;
        b().getMeasuredHeight();
    L28:
        r14.dimAmount = 0.0f;
        com.lynx.tasm.utils.j.i(com.lynx.tasm.utils.j.m(r12.getContext()), r14, null);
        r12.setAttributes(r14);
    L30:
        if (this.f13109k == false) goto L35;
        final Window r22 = getWindow();
        if (r22 == null) goto L35;
        new AbstractDialog$applyWindowPositionIfNeeded$apply$1(r22, this).invoke();
    L35:
        this.f13106h = true;
    }
}
