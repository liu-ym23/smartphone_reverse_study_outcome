package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.material.c;
import com.obric.oui.material.d;
import com.obric.oui.material.n;
import fn.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/d;", "Lcom/obric/oui/material/b;", "", "radius", "", "setBackgroundBlurRadius", "(F)V", "Landroid/view/View;", "getDefaultTargetView", "()Landroid/view/View;", "Landroid/view/ViewGroup;", "getActionGroup", "()Landroid/view/ViewGroup;", "", "buttons", "setButtons", "(Ljava/util/List;)V", "view", "setBackdropTarget", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarFloating extends FrameLayout implements d, com.obric.oui.material.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f11917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f11918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f11919c;
    public final LinearLayout d;
    public final float e;
    public final int f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference f11921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f11922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f11923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f11924l;

    @JvmOverloads
    public OBottomActionBarFloating(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 30);
    }

    private final View getDefaultTargetView() {
        WeakReference r5 = this.f11921i;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        return (View) r5.get();
    L6:
        Integer r10 = n.f13677a;
        return this;
    }

    private final void setBackgroundBlurRadius(float r5) {
        setOutlineProvider(new a(0));
        int r10 = this.f11920h;
        if (r10 != (-1)) goto L6;
        r10 = 2;
    L6:
        c r11 = this.f11924l;
        xq.a r12 = r11.g;
        if (r12 == null) goto L11;
        r12.f23207a = r5;
        this.f11923k.b(this, r11, r10);
        return;
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.f11920h = r5;
        a.a.F(this, r5);
        LinearLayout r10 = this.f11919c;
        LinearLayout r11 = this.d;
        p.r(new LinearLayout[]{this.f11918b, r10, r11}, this.f11920h);
    }

    @Override // com.obric.oui.material.b
    public final void e() {
        int r5 = this.f11920h;
        if (r5 == (-1)) goto L6;
        p.l(this, r5);
        return;
    L6:
        p.m(this, this.g);
    }

    public final ViewGroup getActionGroup() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11923k.c();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r5 = this.f11920h;
        if (r5 == (-1)) goto L6;
        a.a.F(this, r5);
        LinearLayout r10 = this.f11919c;
        LinearLayout r11 = this.d;
        p.r(new LinearLayout[]{this.f11918b, r10, r11}, this.f11920h);
        return;
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        if (this.f11922j == true) goto L5;
        return;
    L5:
        this.f11921i = new WeakReference(r5);
        LinearLayout r10 = this.f11919c;
        LinearLayout r11 = this.d;
        p.s(new LinearLayout[]{this.f11918b, r10, r11}, r5);
    }

    public final void setButtons(List<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "buttons");
        LinearLayout r5 = this.f11918b;
        r5.removeAllViews();
        LinearLayout r11 = this.f11919c;
        r11.removeAllViews();
        LinearLayout r12 = this.d;
        r12.removeAllViews();
        r5.setVisibility(8);
        r11.setVisibility(8);
        r12.setVisibility(8);
        if (r10.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() != 1) goto L9;
        r11.addView(r10.get(0));
        r11.setVisibility(0);
    L11:
        Iterator<T> r13 = r10.iterator();
    L13:
        if (r13.hasNext() == false) goto L22;
        KeyEvent.Callback r14 = (View) r13.next();
        if ((r14 instanceof d) == false) goto L13;
        if (this.f11922j == false) goto L19;
        ((d) r14).setBackdropTarget(getDefaultTargetView());
    L19:
        int r15 = this.f11920h;
        if (r15 == (-1)) goto L13;
        ((d) r14).a(r15);
        goto L13
    L22:
        return;
    L9:
        if (r10.size() < 2) goto L11;
        r5.addView(r10.get(0));
        r5.setVisibility(0);
        r12.addView(r10.get(1));
        r12.setVisibility(0);
        goto L11
    }

    @JvmOverloads
    public OBottomActionBarFloating(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 28);
    }

    @JvmOverloads
    public OBottomActionBarFloating(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 24);
    }

    public OBottomActionBarFloating(Context r18, AttributeSet r19, int r20, int r21) {
        if ((r21 & 2) == 0) goto L5;
        AttributeSet r5 = null;
    L6:
        boolean r10 = false;
        if ((r21 & 4) == 0) goto L9;
        int r11 = 0;
    L10:
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r5, r11, 0);
        this.g = true;
        this.f11920h = 2;
        this.f11922j = true;
        i r12 = new i(this);
        this.f11923k = r12;
        com.obric.oui.color.a[] r13 = n.c(getResources(), R$array.oui_bottom_actionbar_blur_colors, R$array.oui_bottom_actionbar_blur_blend_modes);
        float r14 = BlurToken.Blur_Progress_Thin;
        c r15 = new c(null, null, r13, new xq.a(r14, 2, 6), null, null, 955);
        this.f11924l = r15;
        this.e = r14;
        setClipChildren(false);
        setClipToPadding(false);
        this.f = getPaddingBottom();
        View.inflate(r18, R$layout.o_widget_bottom_action_bar_v2_floating, this);
        this.f11917a = (ViewGroup) findViewById(R$id.bottom_action_bar_root);
        LinearLayout r16 = (LinearLayout) findViewById(R$id.action_bar_left_container);
        this.f11918b = r16;
        LinearLayout r17 = (LinearLayout) findViewById(R$id.action_bar_center_container);
        this.f11919c = r17;
        LinearLayout r22 = (LinearLayout) findViewById(R$id.action_bar_right_container);
        this.d = r22;
        TypedArray r23 = r18.obtainStyledAttributes(r5, R$styleable.OBottomActionBar, 0, 0);
        this.f11920h = r23.getInt(R$styleable.OBottomActionBar_oui_widgetMaterialSrcType, 2);
        if (r23.hasValue(R$styleable.OBottomActionBar_oui_widgetBlurColors) == false) goto L18;
        if (r23.hasValue(R$styleable.OBottomActionBar_oui_widgetBlurBlendModes) == false) goto L18;
        com.obric.oui.color.a[] r24 = n.c(r23.getResources(), r23.getResourceId(R$styleable.OBottomActionBar_oui_widgetBlurColors, R$array.oui_bottom_actionbar_blur_colors), r23.getResourceId(R$styleable.OBottomActionBar_oui_widgetBlurBlendModes, R$array.oui_bottom_actionbar_blur_blend_modes));
        r15.f13611c = r24;
        if (r24 != null) goto L18;
        ps.a.c("OBottomActionBarFloating", "init get widget blur colors or modes error");
    L18:
        if (r23.hasValue(R$styleable.OBottomActionBar_oui_widgetBlurRadius) == false) goto L21;
        this.e = r23.getFloat(R$styleable.OBottomActionBar_oui_widgetBlurRadius, r14);
    L21:
        if (r23.hasValue(R$styleable.OBottomActionBar_oui_bottomActionBarType) == false) goto L26;
        boolean r25 = true;
        if (r23.getInt(R$styleable.OBottomActionBar_oui_bottomActionBarType, 0) != 1) goto L25;
        r10 = true;
    L25:
        r12.f16958a = r10;
    L27:
        r12.d(r23.getBoolean(R$styleable.OBottomActionBar_oui_widgetFitInsetBottom, r25), new OBottomActionBarFloating$1$1(this));
        r23.recycle();
        setBackgroundBlurRadius(this.e);
        p.s(new LinearLayout[]{r16, r17, r22}, getDefaultTargetView());
        r12.f16959b = 81;
        return;
    L26:
        r25 = true;
        goto L27
    L9:
        r11 = r20;
        goto L10
    L5:
        r5 = r19;
        goto L6
    }
}
