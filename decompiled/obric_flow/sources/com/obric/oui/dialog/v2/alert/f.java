package com.obric.oui.dialog.v2.alert;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.dialog.base.h;
import com.obric.oui.dialog.base.i;
import com.obric.oui.dialog.base.j;
import kotlin.jvm.internal.Intrinsics;
import nr.g;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends j implements nr.f {
    public g A;
    public final TextView B;
    public final TextView C;
    public final FrameLayout D;
    public nr.b E;
    public final FrameLayout F;
    public final ViewGroup G;
    public g H;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f13169x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final FrameLayout f13170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final FrameLayout f13171z;

    public f(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f13169x = "OAlertDialogModal";
        this.f13170y = (FrameLayout) findViewById(R$id.bannerPanel);
        this.f13171z = (FrameLayout) findViewById(R$id.iconPanel);
        this.G = (ViewGroup) findViewById(R$id.header_container);
        TextView r10 = (TextView) findViewById(R$id.textTitle);
        this.B = r10;
        if (r10 == null) goto L6;
        r10.setIncludeFontPadding(true);
    L6:
        TextView r11 = (TextView) findViewById(R$id.textSubTitle);
        this.C = r11;
        if (r11 == null) goto L10;
        r11.setIncludeFontPadding(true);
    L10:
        this.D = (FrameLayout) findViewById(R$id.button_container);
        this.F = (FrameLayout) findViewById(R$id.body_container);
    }

    private final int getButtonVerticalSpace() {
        FrameLayout r5 = this.D;
        if (r5.getVisibility() == 0) goto L7;
        return 0;
    L7:
        return r5.getMeasuredHeight();
    }

    private final int getIconPanelVerticalSpace() {
        FrameLayout r5 = this.f13170y;
        if (r5.getVisibility() != 0) goto L6;
        return r5.getMeasuredHeight();
    L6:
        return this.f13171z.getMeasuredHeight();
    }

    private final int getMessageVerticalSpace() {
        TextView r5 = this.C;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.getVisibility() != 0) goto L11;
        if (r5 != null) goto L10;
        return 0;
    L10:
        return r5.getMeasuredHeight();
    L11:
        return 0;
    }

    private final int getTitleVerticalSpace() {
        TextView r5 = this.B;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.getVisibility() != 0) goto L11;
        if (r5 != null) goto L10;
        return 0;
    L10:
        return r5.getMeasuredHeight();
    L11:
        return 0;
    }

    public final void e(ViewGroup r10) {
        int r5 = 2;
        int r11 = 1;
        int r12 = 0;
        if (this.f13136o == false) goto L5;
        getDialogRootView().post(new com.obric.oui.dialog.base.g(this, r11));
        int r13 = qs.d.f21569a;
        requestApplyInsets();
    L62:
        Context r14 = getContext();
        FrameLayout r15 = this.F;
        if (r15.getVisibility() != 0) goto L85;
        Intrinsics.checkNotNullParameter(r14, "context");
        if (r14.getResources().getConfiguration().orientation != 2) goto L85;
        int r16 = r14.getResources().getIdentifier("navigation_bar_height", "dimen", "android");     // Catch: Exception -> L76
        if (r16 <= 0) goto L107;
        r12 = r14.getResources().getDimensionPixelSize(r16);     // Catch: Exception -> L76
    L74:
        if (getWidthMatch() == false) goto L78;
        r12 = r12 - com.lynx.tasm.utils.a.p(16, r14);     // Catch: Exception -> L76
    L78:
        int r17 = getIconPanelVerticalSpace();     // Catch: Exception -> L76
        int r18 = getTitleVerticalSpace();     // Catch: Exception -> L76
        int r19 = getMessageVerticalSpace();     // Catch: Exception -> L76
        int r110 = ((((Math.min(com.lynx.tasm.utils.a.w(r14) - com.lynx.tasm.utils.a.p(32, r14), com.lynx.tasm.utils.a.p(300, r14)) - r17) - r18) - r19) - getButtonVerticalSpace()) - r12;     // Catch: Exception -> L76
        if (r110 <= 0) goto L85;
        ViewGroup.LayoutParams r20 = r15.getLayoutParams();     // Catch: Exception -> L76
        r20.height = r110;     // Catch: Exception -> L76
        r15.setLayoutParams(r20);     // Catch: Exception -> L76
        goto L85
    L107:
        Class<?> r21 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L102
        r12 = r14.getResources().getDimensionPixelSize(Integer.parseInt(r21.getField("navigation_bar_height").get(r21.newInstance()).toString()));     // Catch: Exception -> L102
    L76:
        e = move-exception;
        ps.a.b(e, this.f13169x, "adjustContentHeight failed");
    L83:
        e = move-exception;
        ps.a.b(e, "ResourceUtils", "isLandscape error");
    L85:
        g r111 = this.A;
        if (r111 == null) goto L89;
        r111.b(this);
    L89:
        g r112 = this.H;
        if (r112 == null) goto L93;
        r112.b(this);
    L93:
        nr.b r113 = this.E;
        if (r113 == null) goto L97;
        ((nr.e) r113).b(this);
    L97:
        TextView r114 = this.C;
        if (r114 == null) goto L111;
        r114.postDelayed(new a(this, 2), 1000);
        return;
    L111:
        return;
    L5:
        if (getParent() != null) goto L39;
        if (r10 != null) goto L35;
        Context r115 = getContext();
    L10:
        if ((r115 instanceof ContextWrapper) == false) goto L22;
        if ((r115 instanceof Activity) == true) goto L13;
        r115 = ((ContextWrapper) r115).getBaseContext();
        goto L10
    L13:
        Window r116 = ((Activity) r115).getWindow();
        if (r116 != null) goto L16;
        View r117 = null;
    L18:
        if ((r117 instanceof ViewGroup) == false) goto L20;
        r10 = (ViewGroup) r117;
    L20:
        r10 = null;
        goto L35
    L16:
        r117 = r116.getDecorView();
        goto L18
    L22:
        Context r118 = getContext();
        if ((r118 instanceof Activity) == false) goto L25;
        Activity r119 = (Activity) r118;
    L26:
        if (r119 != null) goto L28;
    L27:
        View r120 = null;
    L33:
        if ((r120 instanceof ViewGroup) == false) goto L20;
        r10 = (ViewGroup) r120;
        goto L35
    L28:
        Window r121 = r119.getWindow();
        if (r121 == null) goto L27;
        r120 = r121.getDecorView();
        goto L33
    L25:
        r119 = null;
    L35:
        if (r10 == null) goto L39;
        r10.addView(this, new ViewGroup.LayoutParams(-1, -1));
    L39:
        if (this.d == false) goto L41;
        getDimView().setOnClickListener(new h(this));
    L42:
        getDialogRootView().post(new com.obric.oui.dialog.base.g(this, r11));
        int r122 = qs.d.f21569a;
        requestApplyInsets();
        setVisibility(0);
        DialogInterface.OnShowListener r123 = this.g;
        if (r123 == null) goto L46;
        r123.onShow(this);
    L46:
        this.f13136o = true;
        this.f13134m = true;
        com.lynx.tasm.utils.d.t(getDimView());
        getDimView().setAlpha(0.0f);
        ViewPropertyAnimator r124 = getDimView().animate();
        Context r22 = getContext();
        Intrinsics.checkNotNullParameter(r22, "context");
        if ((r22.getResources().getConfiguration().uiMode & 48) != 32) goto L49;
        float r23 = 0.8f;
    L50:
        r124.alpha(r23).setDuration(220).start();
        getDialogRootView().post(new com.obric.oui.dialog.base.g(this, r5));
        Activity r125 = com.lynx.tasm.utils.j.m(getContext());
        if (r125 == null) goto L58;
        Window.Callback r24 = r125.getWindow().getCallback();
        if (r24 == null) goto L58;
        this.f13139r = r24;
        this.s = new i(this, r24);
        r125.getWindow().setCallback(this.s);
    L58:
        if (this.f13138q == true) goto L62;
        getContext().registerComponentCallbacks(this.f13143w);
        this.f13138q = true;
        goto L62
    L49:
        r23 = 0.32f;
        goto L50
    L41:
        getDimView().setOnClickListener(null);
        goto L42
    }

    public FrameLayout getBannerSlot() {
        return this.f13170y;
    }

    public FrameLayout getBodySlot() {
        return this.F;
    }

    @Override // nr.f
    public FrameLayout getButtonSlot() {
        return this.D;
    }

    @Override // nr.f
    public FrameLayout getIconSlot() {
        return this.f13171z;
    }

    @Override // com.obric.oui.dialog.base.j
    public int getLayout() {
        return R$layout.o_alert_dialog_v2;
    }

    public final CharSequence getMessageStr() {
        TextView r5 = this.C;
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getText();
    }

    public final TextView getMessageView() {
        return this.C;
    }

    public final View getNegativeButton() {
        nr.b r5 = this.E;
        if (r5 != null) goto L5;
        r5 = null;
    L5:
        if (r5 != null) goto L8;
        return null;
    L8:
        return ((nr.e) r5).f20306c;
    }

    public final View getNeutralButton() {
        nr.b r5 = this.E;
        if (r5 != null) goto L5;
        r5 = null;
    L5:
        if (r5 != null) goto L8;
        return null;
    L8:
        return ((nr.e) r5).d;
    }

    public final View getPositiveButton() {
        nr.b r5 = this.E;
        if (r5 != null) goto L5;
        r5 = null;
    L5:
        if (r5 != null) goto L8;
        return null;
    L8:
        return ((nr.e) r5).f20305b;
    }

    public final CharSequence getTitleStr() {
        TextView r5 = this.B;
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getText();
    }

    public final TextView getTitleView() {
        return this.B;
    }

    public final void setBodyStyleController(g r5) {
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.H = r5;
        boolean r10 = getMatchParentHeight();
        FrameLayout r11 = this.F;
        if (r10 == false) goto L5;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = 0;
        r11.setLayoutParams(r12);
    L5:
        r11.setVisibility(0);
        r5.a(getContext(), this);
    }

    public final void setButtonStyleController(nr.b r5) {
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.E = r5;
        nr.e r10 = (nr.e) r5;
        r10.a(getContext(), this);
        r10.b(this);
    }

    public final void setMessage(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        TextView r10 = this.C;
        if (r10 == null) goto L6;
        r10.setVisibility(0);
        r10.setText(r5);
    L6:
        if (r10 == null) goto L10;
        r10.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void setOnlyTitleText(CharSequence r5) {
        if (r5 == null) goto L9;
        TextView r10 = this.B;
        if (r10 == null) goto L10;
        r10.setVisibility(0);
        r10.setText(r5);
        r10.setPadding(0, com.lynx.tasm.utils.a.p(19, r10.getContext()), 0, com.lynx.tasm.utils.a.p(19, r10.getContext()));
        return;
    L10:
        return;
    }

    public final void setTitleText(CharSequence r10) {
        boolean r5 = TextUtils.isEmpty(r10);
        int r11 = 0;
        TextView r12 = this.B;
        if (r12 == null) goto L9;
        if (r5 == false) goto L7;
        int r13 = 8;
    L8:
        r12.setVisibility(r13);
        r12.setText(r10);
        r12.setPadding(0, 0, 0, 0);
        goto L9
    L7:
        r13 = 0;
    L9:
        TextView r14 = this.C;
        if (r14 == null) goto L22;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L21;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r5 == true) goto L18;
        r11 = com.lynx.tasm.utils.a.p(8, r14.getContext());
    L18:
        r16.topMargin = r11;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setTopImageStyleController(g r5) {
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.A = r5;
        r5.a(getContext(), this);
    }
}
