package com.obric.oui.panel;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/panel/OBasePanelDialog;", "Lcom/obric/oui/panel/BottomSheetDialog;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasePanelDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.oui.panel.header.b f13982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13984n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13985o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ConstraintLayout f13986p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RadiusLayout f13987q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RadiusLayout f13988r;

    public OBasePanelDialog(Context r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f13980j = -1;
        this.f13981k = true;
        this.f13984n = true;
        this.f13985o = true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        return super.dispatchTouchEvent(r5);
    }

    public final ConstraintLayout f(int r5, View r10, ViewGroup.LayoutParams r11) {
        ViewParent r12 = null;
        if (this.f13986p != null) goto L5;
    L8:
        ConstraintLayout r13 = (ConstraintLayout) View.inflate(getContext(), R$layout.o_basic_panel, null);
        this.f13986p = r13;
        if (r13 != null) goto L11;
        RadiusLayout r14 = null;
    L12:
        this.f13987q = r14;
        ConstraintLayout r15 = this.f13986p;
        if (r15 != null) goto L15;
        RadiusLayout r16 = null;
    L16:
        this.f13988r = r16;
    L17:
        if (r5 == 0) goto L20;
        if (r10 != null) goto L20;
        r10 = getLayoutInflater().inflate(r5, this.f13988r, false);
    L20:
        RadiusLayout r17 = this.f13988r;
        if (r17 == null) goto L24;
        r17.removeAllViews();
    L24:
        if (r11 != null) goto L29;
        RadiusLayout r18 = this.f13988r;
        if (r18 == null) goto L34;
        r18.addView(r10);
    L34:
        if (this.f13982l != null) goto L37;
        this.f13982l = new com.obric.oui.panel.header.b(getContext());
    L37:
        if (this.f13985o == true) goto L39;
        float r19 = 0.0f;
    L43:
        RadiusLayout r20 = this.f13987q;
        if (r20 == null) goto L47;
        r20.a(r19, r19, 0.0f, 0.0f);
    L47:
        com.obric.oui.panel.header.b r21 = this.f13982l;
        if (r21 != null) goto L50;
    L49:
        ViewParent r22 = null;
    L55:
        if ((r22 instanceof ViewGroup) == false) goto L74;
        com.obric.oui.panel.header.b r23 = this.f13982l;
        if (r23 != null) goto L59;
    L58:
        ViewParent r24 = null;
    L64:
        if ((r24 instanceof ViewGroup) == false) goto L66;
        ViewGroup r25 = (ViewGroup) r24;
    L67:
        if (r25 == null) goto L74;
        com.obric.oui.panel.header.b r26 = this.f13982l;
        if (r26 != null) goto L72;
        View r27 = null;
    L73:
        r25.removeView(r27);
        goto L74
    L72:
        r27 = r26.f14008h;
        goto L73
    L66:
        r25 = null;
        goto L67
    L59:
        View r28 = r23.f14008h;
        if (r28 == null) goto L58;
        r24 = r28.getParent();
    L74:
        RadiusLayout r29 = this.f13987q;
        if (r29 == null) goto L91;
        com.obric.oui.panel.header.b r30 = this.f13982l;
        if (r30 != null) goto L80;
        View r31 = null;
    L81:
        Intrinsics.checkNotNullParameter(r29, "<this>");
        if (r31 == null) goto L85;
        r12 = r31.getParent();
    L85:
        if (r12 != null) goto L87;
    L89:
        r29.addView(r31);
        goto L91
    L87:
        if ((r31.getParent() instanceof ViewGroup) == false) goto L89;
        com.lynx.tasm.utils.d.w(r31);
        goto L89
    L80:
        r31 = r30.f14008h;
    L91:
        if (this.f13981k == true) goto L96;
        Window r32 = getWindow();
        if (r32 == null) goto L96;
        r32.setDimAmount(0.0f);
    L96:
        ConstraintLayout r33 = this.f13986p;
        Intrinsics.checkNotNull(r33);
        return r33;
    L50:
        View r34 = r21.f14008h;
        if (r34 == null) goto L49;
        r22 = r34.getParent();
        goto L55
    L39:
        if (this.f13977c != null) goto L41;
        b();
    L41:
        r19 = com.lynx.tasm.utils.a.E(20, this.f13977c);
        goto L43
    L29:
        RadiusLayout r35 = this.f13988r;
        if (r35 == null) goto L34;
        r35.addView(r10, r11);
        goto L34
    L15:
        r16 = (RadiusLayout) r15.findViewById(R$id.content_container);
        goto L16
    L11:
        r14 = (RadiusLayout) r13.findViewById(R$id.header_container);
        goto L12
    L5:
        if (this.f13987q == null) goto L8;
        if (this.f13988r != null) goto L17;
        goto L8
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        boolean r10 = true;
        d().f13959k = true;
        BottomSheetBehavior r11 = d();
        r11.C = this.f13984n;
        d().D = true;
        BottomSheetBehavior r12 = d();
        if (this.f13982l != null) goto L5;
        r10 = false;
    L5:
        r12.f13960l = r10;
        if (this.f13980j <= 0) goto L9;
        BottomSheetBehavior r13 = d();
        r13.f13954b = this.f13980j;
        return;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (this.f13983m == false) goto L8;
        FrameLayout r5 = (FrameLayout) findViewById(R$id.design_bottom_sheet);
        if (r5 == null) goto L8;
        r5.setMinimumHeight(0);
    L8:
        if (this.f13985o == true) goto L10;
        float r10 = 0.0f;
    L14:
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        r11.setCornerRadii(new float[]{r10, r10, r10, r10, 0.0f, 0.0f, 0.0f, 0.0f});
        r11.setColor(ContextCompat.getColor(getContext(), R$color.ConstTextInverse));
        if (this.f13977c != null) goto L17;
        b();
    L17:
        FrameLayout r12 = this.f13977c;
        if (r12 == null) goto L21;
        r12.setBackground(r11);
    L21:
        boolean r13 = this.f13984n;
        FrameLayout r14 = (FrameLayout) findViewById(R$id.container);
        if (r14 == null) goto L25;
        r14.setFitsSystemWindows(r13);
    L25:
        d().getClass();
        d().getClass();
        return;
    L10:
        if (this.f13977c != null) goto L12;
        b();
    L12:
        r10 = com.lynx.tasm.utils.a.E(20, this.f13977c);
        goto L14
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.setContentView(f(0, r5, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(int r5) {
        super.setContentView(f(r5, null, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5, ViewGroup.LayoutParams r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.setContentView(f(0, r5, r10));
    }
}
