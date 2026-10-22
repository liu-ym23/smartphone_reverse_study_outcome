package com.obric.oui.dialog.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends FrameLayout implements nr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f13126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f13127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13128c;
    public boolean d;
    public DialogInterface.OnDismissListener e;
    public DialogInterface.OnCancelListener f;
    public DialogInterface.OnShowListener g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DialogInterface.OnShowListener f13129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13131j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13132k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13133l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13134m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13135n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13136o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f13137p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13138q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Window.Callback f13139r;
    public i s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f13140t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f13141u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f13142v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.ies.bullet.service.preload.a f13143w;

    public j(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.f13128c = true;
        this.d = true;
        this.f13133l = -1;
        this.f13135n = true;
        this.f13143w = new com.bytedance.ies.bullet.service.preload.a(this, 1);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setVisibility(8);
        View r5 = new View(r10);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r5.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        r5.setAlpha(0.0f);
        r5.setVisibility(8);
        setDimView(r5);
        addView(getDimView());
        setDialogRootView(LayoutInflater.from(r10).inflate(getBaseLayoutRes(), this, false));
        addView(getDialogRootView());
        if ((getDialogRootView().getBackground() instanceof ColorDrawable) == false) goto L10;
        Drawable r11 = getDialogRootView().getBackground();
        if (r11 == null) goto L8;
        this.f13132k = ((ColorDrawable) r11).getColor();
    L20:
        getDialogRootView().setAlpha(0.0f);
        this.f13127b = (ImageView) findViewById(R$id.btn_close);
        this.f13126a = findViewById(R$id.close_container);
        d(null);
        ViewStub r12 = (ViewStub) findViewById(R$id.contentView);
        r12.setLayoutResource(getLayout());
        setContentRootView(r12.inflate());
        View r13 = getDialogRootView();
        Intrinsics.checkNotNullParameter(r13, "container");
        int r14 = com.lynx.tasm.utils.a.B(10, r13);
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r16.topMargin >= r14) goto L25;
        r16.topMargin = r14;
    L25:
        r13.setLayoutParams(r15);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (n.i(r10) == true) goto L28;
    L30:
        boolean r17 = false;
    L31:
        this.f13131j = r17;
        if (r17 == false) goto L43;
        getDialogRootView().setBackgroundColor(0);
        com.obric.oui.material.c[] r18 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!a.a.v(getDialogRootView())));
        a.a.y(getDialogRootView(), r18, false, 0, 14);
        if (Settings.Global.getInt(r10.getContentResolver(), "obric_current_effect_id", 2) != 1) goto L36;
    L37:
        com.obric.oui.color.d r19 = r18[0].e;
        if (r19 == null) goto L43;
        if ((getDialogRootView() instanceof DialogRootView) == false) goto L43;
        ((DialogRootView) getDialogRootView()).b(r19.f12424b, com.lynx.tasm.utils.a.q(r10, r19.f12423a));
        goto L43
    L36:
        if (r18.length == 1) goto L37;
    L43:
        f r20 = new f(this);
        int r21 = qs.d.f21569a;
        setOnApplyWindowInsetsListener(new qs.c(this, r20));
        return;
    L28:
        if (n.k() == false) goto L30;
        r17 = true;
        goto L31
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L10:
        if ((getDialogRootView().getBackground() instanceof GradientDrawable) == false) goto L20;
        Drawable r22 = getDialogRootView().getBackground();
        if (r22 == null) goto L19;
        ColorStateList r23 = ((GradientDrawable) r22).getColor();
        if (r23 != null) goto L16;
        int r24 = 0;
    L17:
        this.f13132k = r24;
        goto L20
    L16:
        r24 = r23.getDefaultColor();
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    public void a() {
        if (this.f13136o == true) goto L5;
        return;
    L5:
        this.f13136o = false;
        this.f13134m = false;
        b();
        if (this.f13138q == false) goto L9;
        getContext().unregisterComponentCallbacks(this.f13143w);
        this.f13138q = false;
    L9:
        DialogInterface.OnDismissListener r5 = this.e;
        if (r5 == null) goto L13;
        r5.onDismiss(this);
    L13:
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewGroup) == false) goto L16;
        ViewGroup r11 = (ViewGroup) r10;
    L17:
        if (r11 == null) goto L20;
        r11.removeView(this);
    L20:
        setVisibility(8);
        getDimView().setAlpha(0.0f);
        getDialogRootView().setAlpha(1.0f);
        getDialogRootView().setTranslationX(0.0f);
        getDialogRootView().setTranslationY(0.0f);
        return;
    L16:
        r11 = null;
        goto L17
    }

    public final void b() {
        Activity r5 = com.lynx.tasm.utils.j.m(getContext());
        if (r5 != null) goto L5;
        return;
    L5:
        Window.Callback r10 = this.f13139r;
        if (r10 != null) goto L9;
        return;
    L9:
        if (r5.getWindow().getCallback() != this.s) goto L11;
        r5.getWindow().setCallback(r10);
    L11:
        this.s = null;
        this.f13139r = null;
    }

    @Override // nr.a
    public final boolean c() {
        return this.f13128c;
    }

    @Override // android.content.DialogInterface
    public final void cancel() {
        if (this.d == true) goto L5;
        return;
    L5:
        DialogInterface.OnCancelListener r5 = this.f;
        if (r5 == null) goto L9;
        r5.onCancel(this);
    L9:
        dismiss();
    }

    public final void d(View.OnClickListener r5) {
        ImageView r10 = this.f13127b;
        if (r10 == null) goto L10;
        com.lynx.tasm.utils.d.n(com.lynx.tasm.utils.a.p(44, getContext()), r10);
        View r11 = this.f13126a;
        if (r11 == null) goto L11;
        com.lynx.tasm.utils.d.s(r11);
        return;
    L11:
        return;
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        if (this.f13136o == true) goto L5;
        return;
    L5:
        b();
        getDimView().animate().alpha(0.0f).setDuration(180).withEndAction(new g(this, 0)).start();
        com.obric.oui.animation.easy.d r5 = com.obric.oui.dialog.anim.d.c(getDialogRootView(), null, false, getUseNewDialogAnim());
        com.obric.oui.animation.easy.d.d(r5, new AbstractDialogModal$performExitAnimation$2$1(this), new AbstractDialogModal$performExitAnimation$2$2(this));
        r5.e();
    }

    public int getBaseLayoutRes() {
        return R$layout.o_base_dialog;
    }

    public final int getBgColor() {
        return this.f13132k;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.f13129h;
    }

    public final View getContentRootView() {
        View r5 = this.f13141u;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentRootView");
        return null;
    }

    public final View getDialogRootView() {
        View r5 = this.f13140t;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dialogRootView");
        return null;
    }

    public final View getDimView() {
        View r5 = this.f13142v;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    public final boolean getEnableMaterial() {
        return this.f13131j;
    }

    public final boolean getHideFirstFrame() {
        return this.f13130i;
    }

    public abstract int getLayout();

    public int getLayoutMarginBottom() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_layout_margin);
    }

    public int getLayoutMarginHorizontal() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_layout_margin);
    }

    public final boolean getMCancelable() {
        return this.d;
    }

    public final boolean getMatchParentHeight() {
        return false;
    }

    public final int getMaxRootViewHeightGap() {
        return this.f13133l;
    }

    public final boolean getShowAnimRunning() {
        return this.f13134m;
    }

    public boolean getUseNewDialogAnim() {
        return this.f13135n;
    }

    public final boolean getWidthMatch() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        if (this.f13138q == false) goto L7;
        getContext().unregisterComponentCallbacks(this.f13143w);
        this.f13138q = false;
        return;
    }

    public final void setAutoDismiss(boolean r5) {
        this.f13128c = r5;
    }

    public final void setBgColor(int r5) {
        this.f13132k = r5;
    }

    public void setCancelable(boolean r5) {
        this.d = r5;
    }

    public final void setCanceledOnTouchOutside(boolean r5) {
        setCancelable(r5);
    }

    public final void setCompleteShowListener(DialogInterface.OnShowListener r5) {
        this.f13129h = r5;
    }

    public final void setContentRootView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13141u = r5;
    }

    public final void setDialogRootView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13140t = r5;
    }

    public final void setDimView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13142v = r5;
    }

    public final void setEnableMaterial(boolean r5) {
        this.f13131j = r5;
    }

    public final void setHideFirstFrame(boolean r5) {
        this.f13130i = r5;
    }

    public final void setIncludeCutoutInLandscape(Boolean r5) {
    }

    public final void setMCancelable(boolean r5) {
        this.d = r5;
    }

    public final void setMaxRootViewHeightGap(int r5) {
        this.f13133l = r5;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r5) {
        this.f = r5;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r5) {
        this.e = r5;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener r5) {
        this.g = r5;
    }

    public final void setRootFixedHeight(Integer r5) {
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        this.f13137p = r5;
        return;
    L6:
        if (r5.intValue() <= 0) goto L4;
        goto L4
    }

    public final void setShowAnimRunning(boolean r5) {
        this.f13134m = r5;
    }

    public final void setShowingModal(boolean r5) {
        this.f13136o = r5;
    }

    public void setUseNewDialogAnim(boolean r5) {
        this.f13135n = r5;
    }
}
