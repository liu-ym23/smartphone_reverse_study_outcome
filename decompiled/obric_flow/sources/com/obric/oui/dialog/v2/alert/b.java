package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R$id;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.oui.dialog.base.d implements nr.f {
    public static final /* synthetic */ int B = 0;
    public final ViewGroup A;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f13147r;
    public final FrameLayout s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FrameLayout f13148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.lynx.animax.player.b f13149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f13150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f13151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FrameLayout f13152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public nr.e f13153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final FrameLayout f13154z;

    public b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f13147r = "OAlertDialog";
        this.s = (FrameLayout) findViewById(R$id.bannerPanel);
        this.f13148t = (FrameLayout) findViewById(R$id.iconPanel);
        this.A = (ViewGroup) findViewById(R$id.header_container);
        TextView r10 = (TextView) findViewById(R$id.textTitle);
        this.f13150v = r10;
        if (r10 == null) goto L6;
        r10.setIncludeFontPadding(true);
    L6:
        TextView r11 = (TextView) findViewById(R$id.textSubTitle);
        this.f13151w = r11;
        if (r11 == null) goto L10;
        r11.setIncludeFontPadding(true);
    L10:
        this.f13152x = (FrameLayout) findViewById(R$id.button_container);
        this.f13154z = (FrameLayout) findViewById(R$id.body_container);
    }

    @Override // com.obric.oui.dialog.base.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        com.obric.oui.animation.easy.d r5 = com.obric.oui.dialog.anim.d.c(b(), getWindow(), true, true);
        com.obric.oui.animation.easy.d.d(r5, new OAlertDialog$performExitAnimation$1$1(this), new OAlertDialog$performExitAnimation$1$2(this));
        r5.e();
    }

    public final void f() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    @Override // nr.f
    public final FrameLayout getButtonSlot() {
        return this.f13152x;
    }

    @Override // nr.f
    public final FrameLayout getIconSlot() {
        return this.f13148t;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        com.lynx.animax.player.b r10 = this.f13149u;
        if (r10 == null) goto L6;
        r10.b(this);
    L6:
        nr.e r11 = this.f13153y;
        if (r11 == null) goto L11;
        r11.b(this);
        return;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        b().post(new a(this, 0));
        TextView r5 = this.f13151w;
        if (r5 == null) goto L7;
        r5.postDelayed(new a(this, 1), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.d, android.app.Dialog
    public final void show() {
        super.show();
        Context r5 = getContext();
        String r10 = this.f13147r;
        FrameLayout r11 = this.f13154z;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getVisibility() != 0) goto L117;
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r5.getResources().getConfiguration().orientation != 2) goto L114;
        int r12 = r5.getResources().getIdentifier("navigation_bar_height", "dimen", "android");     // Catch: Exception -> L102
        if (r12 <= 0) goto L107;
        int r13 = r5.getResources().getDimensionPixelSize(r12);     // Catch: Exception -> L102
    L18:
        FrameLayout r14 = this.f13148t;     // Catch: Exception -> L102
        if (r14 != null) goto L21;
        int r15 = 0;
    L35:
        TextView r16 = this.f13150v;     // Catch: Exception -> L102
        if (r16 != null) goto L38;
        int r17 = 0;
    L52:
        TextView r18 = this.f13151w;     // Catch: Exception -> L102
        if (r18 != null) goto L55;
        int r19 = 0;
    L69:
        FrameLayout r20 = this.f13152x;     // Catch: Exception -> L102
        if (r20 != null) goto L72;
        int r21 = 0;
    L86:
        ViewGroup.LayoutParams r22 = r11.getLayoutParams();     // Catch: Exception -> L102
        if (r22 != null) goto L90;
    L88:
        r22 = null;
    L91:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;     // Catch: Exception -> L102
        if (r23 != null) goto L94;
        int r24 = 0;
    L95:
        int r110 = com.lynx.tasm.utils.a.w(r5);     // Catch: Exception -> L102
        int r111 = com.lynx.tasm.utils.a.p(300, r5);     // Catch: Exception -> L102
        int r112 = com.lynx.tasm.utils.a.p(440, r5);     // Catch: Exception -> L102
        int r25 = com.lynx.tasm.utils.a.p(156, r5);     // Catch: Exception -> L102
        if (r110 <= r111) goto L98;
        r111 = r110 - r25;     // Catch: Exception -> L102
    L98:
        int r26 = (((((r111 - r13) - r15) - r17) - r19) - r21) - r24;     // Catch: Exception -> L102
        int r27 = RangesKt.coerceIn(r26, 0, r111 - com.lynx.tasm.utils.a.p(52, r5));     // Catch: Exception -> L102
        r11.measure(View.MeasureSpec.makeMeasureSpec(r112, Integer.MIN_VALUE), 0);     // Catch: Exception -> L102
        int r28 = r11.getMeasuredHeight();     // Catch: Exception -> L102
        ps.a.a(r10, "adjustContentHeight, maxHeight: " + r111 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r26 + ", measured BodyHeight: " + r28 + ", maxBodyHeight: " + r27 + ", iconPanelVerticalSpace: " + r15 + ", titleVerticalSpace: " + r17 + ", messageVerticalSpace: " + r19 + ", buttonVerticalSpace: " + r21 + ", bodyMarginSpace: " + r24);     // Catch: Exception -> L102
        if (r28 <= r27) goto L115;
        String r29 = "adjustContentHeight, from: " + r28 + " to: " + r27;     // Catch: Exception -> L102
        Intrinsics.checkNotNullParameter(r10, "tag");     // Catch: Exception -> L102
        Intrinsics.checkNotNullParameter(r29, "msg");     // Catch: Exception -> L102
        ps.a.e(r10, 4, r29, null, 24);     // Catch: Exception -> L102
        ViewGroup.LayoutParams r30 = r11.getLayoutParams();     // Catch: Exception -> L102
        r30.height = r27;     // Catch: Exception -> L102
        r11.setLayoutParams(r30);     // Catch: Exception -> L102
        return;
    L115:
        return;
    L94:
        r24 = r23.topMargin;     // Catch: Exception -> L102
        goto L95
    L90:
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L88;
    L72:
        r20.measure(0, 0);     // Catch: Exception -> L102
        if (r20.getVisibility() != 0) goto L75;
        int r31 = r20.getMeasuredHeight();     // Catch: Exception -> L102
    L76:
        ViewGroup.LayoutParams r32 = r20.getLayoutParams();     // Catch: Exception -> L102
        if (r32 != null) goto L80;
    L78:
        r32 = null;
    L81:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;     // Catch: Exception -> L102
        if (r33 != null) goto L84;
        int r34 = 0;
    L85:
        r21 = r31 + r34;     // Catch: Exception -> L102
        goto L86
    L84:
        r34 = r33.topMargin;     // Catch: Exception -> L102
        goto L85
    L80:
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == false) goto L78;
    L75:
        r31 = 0;
        goto L76
    L55:
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L102
        r18.measure(0, 0);     // Catch: Exception -> L102
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L102
        if (r18.getVisibility() != 0) goto L58;
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L102
        int r113 = r18.getMeasuredHeight();     // Catch: Exception -> L102
    L59:
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L102
        ViewGroup.LayoutParams r35 = r18.getLayoutParams();     // Catch: Exception -> L102
        if (r35 != null) goto L63;
    L61:
        r35 = null;
    L64:
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;     // Catch: Exception -> L102
        if (r36 != null) goto L67;
        int r37 = 0;
    L68:
        r19 = r113 + r37;     // Catch: Exception -> L102
        goto L69
    L67:
        r37 = r36.topMargin;     // Catch: Exception -> L102
        goto L68
    L63:
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == false) goto L61;
    L58:
        r113 = 0;
        goto L59
    L38:
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L102
        r16.measure(0, 0);     // Catch: Exception -> L102
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L102
        if (r16.getVisibility() != 0) goto L41;
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L102
        int r114 = r16.getMeasuredHeight();     // Catch: Exception -> L102
    L42:
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L102
        ViewGroup.LayoutParams r38 = r16.getLayoutParams();     // Catch: Exception -> L102
        if (r38 != null) goto L46;
    L44:
        r38 = null;
    L47:
        ViewGroup.MarginLayoutParams r39 = (ViewGroup.MarginLayoutParams) r38;     // Catch: Exception -> L102
        if (r39 != null) goto L50;
        int r40 = 0;
    L51:
        r17 = r114 + r40;     // Catch: Exception -> L102
        goto L52
    L50:
        r40 = r39.topMargin;     // Catch: Exception -> L102
        goto L51
    L46:
        if ((r38 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
    L41:
        r114 = 0;
        goto L42
    L21:
        r14.measure(0, 0);     // Catch: Exception -> L102
        if (r14.getVisibility() != 0) goto L24;
        int r115 = r14.getMeasuredHeight();     // Catch: Exception -> L102
    L25:
        ViewGroup.LayoutParams r41 = r14.getLayoutParams();     // Catch: Exception -> L102
        if (r41 != null) goto L29;
    L27:
        r41 = null;
    L30:
        ViewGroup.MarginLayoutParams r42 = (ViewGroup.MarginLayoutParams) r41;     // Catch: Exception -> L102
        if (r42 != null) goto L33;
        int r43 = 0;
    L34:
        r15 = r115 + r43;     // Catch: Exception -> L102
        goto L35
    L33:
        r43 = r42.topMargin;     // Catch: Exception -> L102
        goto L34
    L29:
        if ((r41 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
    L24:
        r115 = 0;
        goto L25
    L107:
        Class<?> r44 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L17
        r13 = r5.getResources().getDimensionPixelSize(Integer.parseInt(r44.getField("navigation_bar_height").get(r44.newInstance()).toString()));     // Catch: Exception -> L17
    L17:
        r13 = 0;
    L102:
        e = move-exception;
        ps.a.b(e, r10, "adjustContentHeight error");
        return;
    L114:
        return;
    L104:
        e = move-exception;
        ps.a.b(e, "ResourceUtils", "isLandscape error");
        return;
    }
}
