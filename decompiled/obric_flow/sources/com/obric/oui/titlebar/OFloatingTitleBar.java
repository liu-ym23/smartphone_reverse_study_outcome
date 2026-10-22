package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.n;
import com.obric.oui.text.OTextView;
import fn.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ym.h;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u000fJ\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u000fJ\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u000fJ\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u000fJ\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010!\u001a\u00020\r2\u0006\u0010#\u001a\u00020\b¢\u0006\u0004\b!\u0010\u000fJ\u0015\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\b¢\u0006\u0004\b%\u0010\u000fJ\u0017\u0010&\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b&\u0010\"J\u0015\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\b¢\u0006\u0004\b&\u0010\u000fJ\u0015\u0010'\u001a\u00020\r2\u0006\u0010$\u001a\u00020\b¢\u0006\u0004\b'\u0010\u000fJ\u0017\u0010(\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b(\u0010\"J\u0015\u0010(\u001a\u00020\r2\u0006\u0010#\u001a\u00020\b¢\u0006\u0004\b(\u0010\u000fJ\u0015\u0010)\u001a\u00020\r2\u0006\u0010$\u001a\u00020\b¢\u0006\u0004\b)\u0010\u000fJ\u0017\u0010*\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b*\u0010\"J\u0015\u0010+\u001a\u00020\r2\u0006\u0010#\u001a\u00020\b¢\u0006\u0004\b+\u0010\u000fJ\u0015\u0010,\u001a\u00020\r2\u0006\u0010$\u001a\u00020\b¢\u0006\u0004\b,\u0010\u000fJ\u0017\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b/\u00100J\u0015\u00103\u001a\u00020\r2\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b5\u0010\u0013J\u000f\u00106\u001a\u00020\u0010H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u00109R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020:8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\"\u0010I\u001a\u00020:8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R\"\u0010M\u001a\u00020:8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@¨\u0006N"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/d;", "Lcom/obric/oui/material/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setTitleType", "(I)V", "Landroid/view/View;", "view", "setCenterCustomView", "(Landroid/view/View;)V", "styleRes", "setStartButtonGroupStyle", "setCenterButtonGroupStyle", "setSubEndButtonGroupStyle", "setEndButtonGroupStyle", "Lcom/obric/oui/text/OTextView;", "getStartTitleView", "()Lcom/obric/oui/text/OTextView;", "getStartSubtitleView", "getCenterTitleView", "getCenterSubtitleView", "", MessageIndication.CONTENT_TYPE_TEXT, "setStartTitle", "(Ljava/lang/String;)V", "resId", "color", "setStartTitleColor", "setStartSubtitle", "setStartSubTitleColor", "setCenterTitle", "setCenterTitleColor", "setCenterSubtitle", "setCenterSubTitle", "setCenterSubTitleColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "(Landroid/graphics/drawable/Drawable;)V", "", "radius", "setMaskBlurRadius", "(F)V", "setBackdropTarget", "getDefaultTargetView", "()Landroid/view/View;", "getCenterTitleGap", "()I", "Lcom/obric/oui/button/OButtonGroup;", "b", "Lcom/obric/oui/button/OButtonGroup;", "getStartButtonGroup", "()Lcom/obric/oui/button/OButtonGroup;", "setStartButtonGroup", "(Lcom/obric/oui/button/OButtonGroup;)V", "startButtonGroup", "f", "getCenterButtonGroup", "setCenterButtonGroup", "centerButtonGroup", "k", "getEndSubButtonGroup", "setEndSubButtonGroup", "endSubButtonGroup", "l", "getEndButtonGroup", "setEndButtonGroup", "endButtonGroup", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFloatingTitleBar extends FrameLayout implements com.obric.oui.material.d, com.obric.oui.material.b {
    public static final /* synthetic */ int C = 0;
    public int A;
    public int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f14793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButtonGroup f14794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f14795c;
    public final OTextView d;
    public final FrameLayout e;
    public OButtonGroup f;
    public final FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OTextView f14796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTextView f14797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinearLayout f14798j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OButtonGroup f14799k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OButtonGroup f14800l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f14801m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f14802n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14803o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14804p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f14805q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f14806r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function1 f14807t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.obric.oui.material.c f14808u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14809v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f14810w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14811x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14812y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14813z;

    @JvmOverloads
    public OFloatingTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static final void b(OFloatingTitleBar r5, OButtonGroup r10, int r11) {
        r5.getClass();
        int r12 = r10.getItemCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        int r14 = r13 + 1;
        LinearLayout r15 = r10.A;
        if (r15 != null) goto L7;
        View r16 = null;
    L8:
        m(r11, r16);
        r13 = r14;
        goto L3
    L7:
        r16 = r15.getChildAt(r13);
        goto L8
    }

    private final int getCenterTitleGap() {
        if (this.f14811x == false) goto L6;
        return this.B;
    L6:
        return this.A;
    }

    private final View getDefaultTargetView() {
        Integer r5 = n.f13677a;
        return this;
    }

    public static void m(int r5, View r10) {
        if ((r10 instanceof ViewGroup) == false) goto L8;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L17;
        int r14 = r13 + 1;
        m(r5, r11.getChildAt(r13));
        r13 = r14;
        goto L5
    L17:
        return;
    L8:
        if ((r10 instanceof ImageView) == false) goto L11;
        ((ImageView) r10).setColorFilter(r5);
        return;
    L11:
        if ((r10 instanceof TextView) == false) goto L16;
        ((TextView) r10).setTextColor(r5);
        return;
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.s = r5;
        p.q(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), r5);
    }

    public final OUIFrameLayout c(int r5, int r10, View.OnClickListener r11) {
        OUIFrameLayout r12 = g(r5, this.f14804p);
        if (r11 == null) goto L5;
        r12.setOnClickListener(r11);
    L5:
        Intrinsics.checkNotNullParameter(r12, "view");
        getEndButtonGroup().v(r12, new ViewGroup.MarginLayoutParams(-2, -2), r10);
        getEndButtonGroup().setVisibility(0);
        return r12;
    }

    public final OUIFrameLayout d(int r5, int r10, View.OnClickListener r11) {
        OUIFrameLayout r12 = g(r5, this.f14803o);
        if (r11 == null) goto L5;
        r12.setOnClickListener(r11);
    L5:
        Intrinsics.checkNotNullParameter(r12, "view");
        getStartButtonGroup().v(r12, new ViewGroup.MarginLayoutParams(-2, -2), r10);
        getStartButtonGroup().setVisibility(0);
        return r12;
    }

    @Override // com.obric.oui.material.b
    public final void e() {
        int r5 = this.s;
        if (r5 == (-1)) goto L6;
        p.l(this, r5);
        return;
    L6:
        p.m(this, this.f14806r);
    }

    public final void f(OButtonGroup r10, int r11, Function1 r12) {
        if (r11 != 0) goto L4;
        return;
    L4:
        TypedArray r13 = getContext().obtainStyledAttributes(r11, R$styleable.OShadowFrame);
        int r5 = r13.getColor(R$styleable.OShadowFrame_oui_widgetBgColor, 0);
        int r14 = r13.getColor(R$styleable.OShadowFrame_oui_widgetPressColor, 0);
        int r15 = r13.getColor(R$styleable.OShadowFrame_oui_widgetBgColorDisabled, 0);
        int r16 = r13.getColor(R$styleable.OShadowFrame_oui_widgetTintColor, 0);
        String r17 = r13.getString(R$styleable.OShadowFrame_oui_widgetMaterial);
        String r18 = r13.getString(R$styleable.OShadowFrame_oui_widgetMaterialDisabled);
        r13.recycle();
        if (StringsKt.h(getContext().getString(R$string.oui_material_bg_floating), r17) == true) goto L7;
    L9:
        if (r5 == 0) goto L32;
        if (r17 == null) goto L16;
        if (r15 != 0) goto L14;
        r15 = r5;
    L14:
        r10.s(r5, r15, r17, r18);
        goto L32
    L16:
        if (h.i(r5) == false) goto L28;
        if (r15 == 0) goto L19;
        int r19 = r15;
    L20:
        com.obric.oui.material.c[] r20 = MaterialToken.OUI_Bg_Floating_Tinted_Light;
        com.obric.oui.material.c[] r21 = z5.a.j(r20, r5);
        com.obric.oui.material.c[] r22 = z5.a.j(r20, r15);
        r10.f12150k = r5;
        r10.f12151l = r19;
        r10.t(r21, r22);
        if (h.j(r5) == false) goto L23;
        int r23 = 2;
    L25:
        if (r23 == r10.f12157r) goto L27;
        r10.n(r23);
        goto L32
    L27:
        r10.u(r10.isEnabled());
        goto L32
    L23:
        r23 = 1;
        goto L25
    L19:
        r19 = r5;
        goto L20
    L28:
        if (r15 != 0) goto L31;
        r15 = r5;
    L31:
        r10.s(r5, r15, null, null);
    L32:
        if (r14 == 0) goto L34;
        r10.setPressColor(r14);
    L34:
        if (r16 == 0) goto L37;
        r12.invoke(Integer.valueOf(r16));
        return;
    L37:
        return;
    L7:
        if (h.i(r5) == false) goto L9;
        r17 = null;
        goto L9
    }

    public final OUIFrameLayout g(int r5, int r10) {
        OUIFrameLayout r11 = new OUIFrameLayout(getContext(), null, 0, 14);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r11.setPadding(com.lynx.tasm.utils.a.B(7, r11), com.lynx.tasm.utils.a.B(7, r11), com.lynx.tasm.utils.a.B(7, r11), com.lynx.tasm.utils.a.B(7, r11));
        r11.setClickable(true);
        r11.setRadius(com.lynx.tasm.utils.a.B(99, r11));
        ImageView r12 = new ImageView(r11.getContext());
        r12.setImageResource(r5);
        if (r10 == 0) goto L5;
        r12.setColorFilter(r10);
    L5:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(com.lynx.tasm.utils.a.B(22, r11), com.lynx.tasm.utils.a.B(22, r11));
        r13.gravity = 17;
        Unit r14 = Unit.INSTANCE;
        r11.addView(r12, r13);
        return r11;
    }

    public final OButtonGroup getCenterButtonGroup() {
        OButtonGroup r5 = this.f;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("centerButtonGroup");
        return null;
    }

    public final OTextView getCenterSubtitleView() {
        OTextView r5 = this.f14797i;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        return null;
    L6:
        return r5;
    }

    public final OTextView getCenterTitleView() {
        OTextView r5 = this.f14796h;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        return null;
    L6:
        return r5;
    }

    public final OButtonGroup getEndButtonGroup() {
        OButtonGroup r5 = this.f14800l;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endButtonGroup");
        return null;
    }

    public final OButtonGroup getEndSubButtonGroup() {
        OButtonGroup r5 = this.f14799k;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endSubButtonGroup");
        return null;
    }

    public final OButtonGroup getStartButtonGroup() {
        OButtonGroup r5 = this.f14794b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("startButtonGroup");
        return null;
    }

    public final OTextView getStartSubtitleView() {
        OTextView r5 = this.d;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        return null;
    L6:
        return r5;
    }

    public final OTextView getStartTitleView() {
        OTextView r5 = this.f14795c;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        return null;
    L6:
        return r5;
    }

    public final boolean h() {
        if (getCenterButtonGroup().getVisibility() == 0) goto L23;
        OTextView r5 = this.f14796h;
        FrameLayout r10 = null;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r5 = null;
    L9:
        if (r5.getVisibility() == 0) goto L23;
        OTextView r11 = this.f14797i;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r11 = null;
    L15:
        if (r11.getVisibility() == 0) goto L23;
        FrameLayout r12 = this.g;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L22:
        if (r10.getVisibility() == 0) goto L23;
        return false;
    L20:
        r10 = r12;
    L23:
        return true;
    }

    public final boolean i() {
        OTextView r5 = this.f14795c;
        OTextView r10 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r5 = null;
    L6:
        if (r5.getVisibility() != 0) goto L12;
        OTextView r11 = this.f14795c;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L11:
        int r12 = r10.getTextColors().getDefaultColor();
    L23:
        return !h.j(r12);
    L10:
        r10 = r11;
        goto L11
    L12:
        OTextView r13 = this.f14796h;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r13 = null;
    L16:
        if (r13.getVisibility() != 0) goto L25;
        OTextView r14 = this.f14796h;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L21:
        r12 = r10.getTextColors().getDefaultColor();
        goto L23
    L20:
        r10 = r14;
        goto L21
    L25:
        return a.a.v(this);
    }

    public final boolean j() {
        if (getStartButtonGroup().getVisibility() == 0) goto L17;
        OTextView r5 = this.f14795c;
        OTextView r10 = null;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r5 = null;
    L9:
        if (r5.getVisibility() == 0) goto L17;
        OTextView r11 = this.d;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L16:
        if (r10.getVisibility() == 0) goto L17;
        return false;
    L14:
        r10 = r11;
    L17:
        return true;
    }

    public final void k(OTextView r5) {
        CharSequence r10 = r5.getText();
        if (r10 != null) goto L5;
    L8:
        int r11 = 8;
    L9:
        r5.setVisibility(r11);
        requestLayout();
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = 0;
        goto L9
    }

    public final void l(boolean r5) {
        View r10 = this.f14801m;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r10 = null;
    L5:
        if (r5 == false) goto L7;
        int r11 = 0;
    L8:
        r10.setVisibility(r11);
        return;
    L7:
        r11 = 8;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof ViewGroup) == true) goto L5;
    L10:
        this.f14810w.c();
        return;
    L5:
        if ((getParent() instanceof com.obric.oui.material.b) == false) goto L8;
    L9:
        l(false);
        goto L10
    L8:
        if ((getParent().getParent() instanceof com.obric.oui.material.b) == false) goto L10;
        goto L9
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        this.f14811x = p.t(r5.fontScale);
    L6:
        this.f14813z = com.lynx.tasm.utils.a.B(8, this);
        this.A = com.lynx.tasm.utils.a.B(12, this);
        this.B = com.lynx.tasm.utils.a.B(4, this);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (this.s == (-1)) goto L6;
        p.q(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), this.s);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (h() == true) goto L5;
        return;
    L5:
        int r15 = getMeasuredWidth();
        View r16 = this.f14802n;
        FrameLayout r17 = null;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r16 = null;
    L8:
        int r18 = r16.getPaddingLeft();
        View r19 = this.f14802n;
        if (r19 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r19 = null;
    L11:
        int r110 = r19.getPaddingRight();
        int r5 = getCenterTitleGap();
        if (j() == false) goto L18;
        FrameLayout r20 = this.f14793a;
        if (r20 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r20 = null;
    L16:
        r18 = (r20.getMeasuredWidth() + r18) + r5;
    L18:
        if (getEndButtonGroup().getVisibility() != 0) goto L21;
    L22:
        int r111 = r15 - r110;
        LinearLayout r21 = this.f14798j;
        if (r21 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r21 = null;
    L25:
        int r112 = (r111 - r21.getMeasuredWidth()) - r5;
    L27:
        FrameLayout r22 = this.e;
        if (r22 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r22 = null;
    L30:
        int r23 = r22.getMeasuredWidth();
        FrameLayout r24 = this.e;
        if (r24 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r24 = null;
    L33:
        int r25 = r24.getMeasuredHeight();
        int r26 = (r15 - r23) / 2;
        int r27 = r26 + r23;
        int r28 = r112 - r18;
        if (r23 <= r28) goto L37;
        r26 = r18;
    L36:
        r27 = r112;
    L42:
        if (this.f14812y == false) goto L44;
        int r29 = (r28 - r23) / 2;
        r26 = r18 + r29;
        r27 = r112 - r29;
    L44:
        View r30 = this.f14802n;
        if (r30 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r30 = null;
    L47:
        int r31 = r30.getPaddingTop();
        View r113 = this.f14802n;
        if (r113 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r113 = null;
    L50:
        int r114 = r113.getMeasuredHeight();
        View r32 = this.f14802n;
        if (r32 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r32 = null;
    L53:
        int r115 = ((((r114 - r32.getPaddingBottom()) - r31) - r25) / 2) + r31;
        int r33 = r25 + r115;
        FrameLayout r34 = this.e;
        if (r34 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L57:
        r17.layout(r26, r115, r27, r33);
        return;
    L56:
        r17 = r34;
        goto L57
    L37:
        if (r26 >= r18) goto L39;
        r27 = r18 + r23;
        r26 = r18;
        goto L42
    L39:
        if (r27 <= r112) goto L42;
        r26 = r112 - r23;
        goto L36
    L21:
        if (getEndSubButtonGroup().getVisibility() == 0) goto L22;
        r112 = r15 - r110;
        goto L27
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r20, int r21) {
        this.f14812y = false;
        OTextView r5 = this.f14796h;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r5 = null;
    L5:
        r5.setMaxWidth(Integer.MAX_VALUE);
        OTextView r10 = this.f14797i;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r10 = null;
    L8:
        r10.setMaxWidth(Integer.MAX_VALUE);
        OTextView r11 = this.f14795c;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r11 = null;
    L11:
        r11.setMaxWidth(Integer.MAX_VALUE);
        OTextView r12 = this.d;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r12 = null;
    L14:
        r12.setMaxWidth(Integer.MAX_VALUE);
        super.onMeasure(r20, r21);
        boolean r13 = j();
        boolean r14 = h();
        if (getEndButtonGroup().getVisibility() != 0) goto L18;
    L19:
        boolean r15 = true;
    L21:
        int r16 = getMeasuredWidth();
        View r17 = this.f14802n;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r17 = null;
    L24:
        int r18 = r17.getPaddingLeft();
        View r19 = this.f14802n;
        if (r19 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r19 = null;
    L27:
        int r110 = r19.getPaddingRight();
        int r111 = getCenterTitleGap();
        if (r14 == false) goto L33;
        int r112 = r16 / 2;
        FrameLayout r22 = this.e;
        if (r22 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r22 = null;
    L32:
        int r23 = (r112 - (r22.getMeasuredWidth() / 2)) - r111;
    L40:
        if (r13 == false) goto L45;
        int r113 = (r16 / 2) - r18;
        FrameLayout r24 = this.f14793a;
        if (r24 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r24 = null;
    L44:
        int r25 = (r113 - r24.getMeasuredWidth()) - r111;
    L46:
        if (r15 == false) goto L51;
        int r114 = (r16 / 2) - r110;
        LinearLayout r26 = this.f14798j;
        if (r26 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r26 = null;
    L50:
        int r115 = (r114 - r26.getMeasuredWidth()) - r111;
    L52:
        if (r13 == false) goto L65;
        int r27 = Math.max(0, r23 - r18);
        FrameLayout r28 = this.f14793a;
        if (r28 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r28 = null;
    L57:
        if (r28.getMeasuredWidth() <= r27) goto L65;
        OTextView r29 = this.f14795c;
        if (r29 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r29 = null;
    L61:
        r29.setMaxWidth(r27);
        OTextView r30 = this.d;
        if (r30 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r30 = null;
    L64:
        r30.setMaxWidth(r27);
        boolean r31 = true;
    L66:
        if (r14 == false) goto L107;
        int r32 = Math.max(0, Math.min(r25 * 2, r115 * 2));
        FrameLayout r33 = this.e;
        if (r33 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r33 = null;
    L71:
        if (r33.getMeasuredWidth() <= r32) goto L107;
        this.f14812y = true;
        int r34 = r25 + r115;
        OTextView r35 = this.f14796h;
        if (r35 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r35 = null;
    L75:
        r35.setMaxWidth(r34);
        OTextView r36 = this.f14796h;
        if (r36 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r36 = null;
    L79:
        if (r36.getMeasuredWidth() <= r32) goto L84;
        OTextView r37 = this.f14797i;
        if (r37 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r37 = null;
    L83:
        r37.setMaxWidth(r34);
    L88:
        FrameLayout r38 = this.g;
        if (r38 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r38 = null;
    L92:
        if (r38.getVisibility() != 0) goto L106;
        FrameLayout r39 = this.g;
        if (r39 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r39 = null;
    L96:
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        FrameLayout r41 = this.g;
        if (r41 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r41 = null;
    L100:
        if (r41.getMeasuredWidth() <= r34) goto L106;
        r40.width = r34;
        FrameLayout r42 = this.g;
        if (r42 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        FrameLayout r43 = null;
    L105:
        r43.setLayoutParams(r40);
        goto L106
    L104:
        r43 = r42;
    L106:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        super.onMeasure(r20, r21);
        return;
    L111:
        return;
    L84:
        OTextView r44 = this.f14797i;
        if (r44 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException(r6);
        r44 = null;
    L87:
        r44.setMaxWidth(r32);
    L107:
        r116 = r31;
    L65:
        r31 = false;
        goto L66
    L51:
        r115 = ((r16 / 2) - r110) - this.f14813z;
        goto L52
    L45:
        r25 = ((r16 / 2) - r18) - this.f14813z;
        goto L46
    L33:
        if (r15 == false) goto L38;
        int r45 = r16 - r110;
        LinearLayout r117 = this.f14798j;
        if (r117 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r117 = null;
    L37:
        r23 = (r45 - r117.getMeasuredWidth()) - r111;
        goto L40
    L38:
        r23 = r16 - r110;
        goto L40
    L18:
        if (getEndSubButtonGroup().getVisibility() == 0) goto L19;
        r15 = false;
        goto L21
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        this.f14805q = r5;
        if (r5 != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(this, this);
        View r10 = getDefaultTargetView();
        getStartButtonGroup().setBackdropTarget(r10);
        getCenterButtonGroup().setBackdropTarget(r10);
        getEndButtonGroup().setBackdropTarget(r10);
        getEndSubButtonGroup().setBackdropTarget(r10);
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(r5, this);
        List r11 = CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()});
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((com.obric.oui.material.d) r12.next()).setBackdropTarget(r5);
        goto L8
    }

    public final void setCenterButtonGroup(OButtonGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f = r5;
    }

    public final void setCenterButtonGroupStyle(int r5) {
        f(getCenterButtonGroup(), r5, new AnonymousClass1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCenterCustomView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FrameLayout r10 = this.g;
        FrameLayout r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r10 = null;
    L5:
        r10.removeAllViews();
        FrameLayout r12 = this.g;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r12 = null;
    L8:
        r12.addView(r5);
        FrameLayout r13 = this.g;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L12:
        r11.setVisibility(0);
        if ((r5 instanceof com.obric.oui.material.d) == false) goto L16;
        ((com.obric.oui.material.d) r5).setBackdropTarget(getDefaultTargetView());
        return;
    L16:
        return;
    L11:
        r11 = r13;
        goto L12
    }

    public final void setCenterSubTitle(int r5) {
        setCenterSubtitle(getResources().getString(r5));
    }

    public final void setCenterSubTitleColor(int r5) {
        OTextView r10 = this.f14797i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r10 = null;
    L5:
        r10.setTextColor(r5);
    }

    public final void setCenterSubtitle(String r5) {
        OTextView r10 = this.f14797i;
        OTextView r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r10 = null;
    L5:
        r10.setText(r5);
        OTextView r12 = this.f14797i;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L9:
        k(r11);
        return;
    L8:
        r11 = r12;
        goto L9
    }

    public final void setCenterTitle(String r5) {
        OTextView r10 = this.f14796h;
        OTextView r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r10 = null;
    L5:
        r10.setText(r5);
        OTextView r12 = this.f14796h;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L9:
        k(r11);
        return;
    L8:
        r11 = r12;
        goto L9
    }

    public final void setCenterTitleColor(int r5) {
        OTextView r10 = this.f14796h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r10 = null;
    L5:
        r10.setTextColor(r5);
        this.f14808u = (com.obric.oui.material.c) this.f14807t.invoke(Boolean.valueOf(i()));
    }

    public final void setEndButtonGroup(OButtonGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14800l = r5;
    }

    public final void setEndButtonGroupStyle(int r5) {
        f(getEndButtonGroup(), r5, new C01851(this));
    }

    public final void setEndSubButtonGroup(OButtonGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14799k = r5;
    }

    @Deprecated(message = "not support set mask background")
    public final void setMaskBackground(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        l(true);
    }

    public final void setMaskBlurRadius(float r5) {
        com.obric.oui.material.c r10 = this.f14808u;
        com.obric.oui.material.c r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r10 = null;
    L5:
        xq.a r12 = r10.g;
        if (r12 == null) goto L9;
        r12.f23207a = r5;
    L9:
        com.obric.oui.material.c r13 = this.f14808u;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L13:
        this.f14810w.b(this, r11, this.s);
        if (r5 != 0.0f) goto L16;
        boolean r14 = true;
    L17:
        l(!r14);
        return;
    L16:
        r14 = false;
        goto L17
    L12:
        r11 = r13;
        goto L13
    }

    public final void setStartButtonGroup(OButtonGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14794b = r5;
    }

    public final void setStartButtonGroupStyle(int r5) {
        f(getStartButtonGroup(), r5, new C01861(this));
    }

    public final void setStartSubTitleColor(int r5) {
        OTextView r10 = this.d;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r10 = null;
    L5:
        r10.setTextColor(r5);
    }

    public final void setStartSubtitle(String r5) {
        OTextView r10 = this.d;
        OTextView r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r10 = null;
    L5:
        r10.setText(r5);
        OTextView r12 = this.d;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L9:
        k(r11);
        return;
    L8:
        r11 = r12;
        goto L9
    }

    public final void setStartTitle(String r5) {
        OTextView r10 = this.f14795c;
        OTextView r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r10 = null;
    L5:
        r10.setText(r5);
        OTextView r12 = this.f14795c;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L9:
        k(r11);
        return;
    L8:
        r11 = r12;
        goto L9
    }

    public final void setStartTitleColor(int r5) {
        OTextView r10 = this.f14795c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r10 = null;
    L5:
        r10.setTextColor(r5);
        this.f14808u = (com.obric.oui.material.c) this.f14807t.invoke(Boolean.valueOf(i()));
    }

    public final void setSubEndButtonGroupStyle(int r5) {
        f(getEndSubButtonGroup(), r5, new C01871(this));
    }

    public final void setTitleType(int r10) {
        this.f14809v = r10;
        if (r10 != 2) goto L5;
        boolean r5 = true;
    L6:
        this.f14810w.f16958a = r5;
        View r11 = null;
        com.obric.oui.material.c r12 = null;
        View r13 = null;
        if (r10 == 0) goto L33;
        if (r10 == 1) goto L25;
        if (r10 != 2) goto L44;
        View r14 = this.f14802n;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r14 = null;
    L14:
        r14.setMinimumHeight(com.lynx.tasm.utils.a.B(56, this));
        View r15 = this.f14802n;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r15 = null;
    L17:
        r15.setPadding(com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(8, this), com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(8, this));
        com.obric.oui.material.c r16 = this.f14808u;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L21:
        xq.a r17 = r12.g;
        if (r17 == null) goto L45;
        setMaskBlurRadius(r17.f23207a);
        return;
    L45:
        return;
    L20:
        r12 = r16;
        goto L21
    L44:
        return;
    L25:
        View r18 = this.f14802n;
        if (r18 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r18 = null;
    L28:
        r18.setMinimumHeight(com.lynx.tasm.utils.a.B(64, this));
        View r19 = this.f14802n;
        if (r19 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L32:
        r13.setPadding(com.lynx.tasm.utils.a.B(16, this), com.lynx.tasm.utils.a.B(16, this), com.lynx.tasm.utils.a.B(16, this), com.lynx.tasm.utils.a.B(8, this));
        return;
    L31:
        r13 = r19;
        goto L32
    L33:
        View r20 = this.f14802n;
        if (r20 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r20 = null;
    L36:
        r20.setMinimumHeight(com.lynx.tasm.utils.a.B(56, this));
        View r21 = this.f14802n;
        if (r21 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L40:
        r11.setPadding(com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(8, this), com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(8, this));
        return;
    L39:
        r11 = r21;
        goto L40
    L5:
        r5 = false;
        goto L6
    }

    @JvmOverloads
    public OFloatingTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OFloatingTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    public final void setCenterTitle(int r5) {
        setCenterTitle(getResources().getString(r5));
    }

    public final void setStartSubtitle(int r5) {
        setStartSubtitle(getResources().getString(r5));
    }

    public final void setStartTitle(int r5) {
        setStartTitle(getResources().getString(r5));
    }

    @JvmOverloads
    public OFloatingTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        boolean r13 = true;
        this.f14806r = true;
        int r5 = 2;
        this.s = 2;
        Function1<Boolean, com.obric.oui.material.c> r14 = new OFloatingTitleBar$maskMaterial$1(this);
        this.f14807t = r14;
        i r15 = new i(this);
        this.f14810w = r15;
        this.f14811x = p.t(r10.getResources().getConfiguration().fontScale);
        this.f14813z = com.lynx.tasm.utils.a.B(8, this);
        this.A = com.lynx.tasm.utils.a.B(12, this);
        this.B = com.lynx.tasm.utils.a.B(4, this);
        LayoutInflater.from(r10).inflate(R$layout.o_floating_title_bar_layout, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        this.f14793a = (FrameLayout) findViewById(R$id.start_container);
        setStartButtonGroup((OButtonGroup) findViewById(R$id.start_button_group));
        LinearLayout r16 = (LinearLayout) findViewById(R$id.start_title_container);
        this.f14795c = (OTextView) findViewById(R$id.start_title);
        this.d = (OTextView) findViewById(R$id.start_sub_title);
        this.e = (FrameLayout) findViewById(R$id.center_container);
        setCenterButtonGroup((OButtonGroup) findViewById(R$id.center_button_group));
        this.g = (FrameLayout) findViewById(R$id.center_custom_container);
        LinearLayout r17 = (LinearLayout) findViewById(R$id.center_title_container);
        this.f14796h = (OTextView) findViewById(R$id.center_title);
        this.f14797i = (OTextView) findViewById(R$id.center_sub_title);
        OTextView r18 = this.f14795c;
        com.obric.oui.material.c r19 = null;
        if (r18 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r18 = null;
    L5:
        r18.setFallbackLineSpacing(false);
        OTextView r20 = this.d;
        if (r20 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r20 = null;
    L8:
        r20.setFallbackLineSpacing(false);
        OTextView r21 = this.f14796h;
        if (r21 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r21 = null;
    L11:
        r21.setFallbackLineSpacing(false);
        OTextView r22 = this.f14797i;
        if (r22 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r22 = null;
    L14:
        r22.setFallbackLineSpacing(false);
        this.f14798j = (LinearLayout) findViewById(R$id.end_container);
        setEndSubButtonGroup((OButtonGroup) findViewById(R$id.end_sub_button_group));
        setEndButtonGroup((OButtonGroup) findViewById(R$id.end_button_group));
        this.f14801m = findViewById(R$id.material_mask);
        View r23 = findViewById(R$id.title_bar_container);
        this.f14802n = r23;
        if (r23 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r23 = null;
    L17:
        r23.setClickable(true);
        this.f14808u = r14.invoke(Boolean.valueOf(!i()));
        View r24 = getDefaultTargetView();
        getStartButtonGroup().setBackdropTarget(r24);
        getCenterButtonGroup().setBackdropTarget(r24);
        getEndButtonGroup().setBackdropTarget(r24);
        getEndSubButtonGroup().setBackdropTarget(r24);
        if (r11 == null) goto L85;
        TypedArray r110 = getContext().obtainStyledAttributes(r11, R$styleable.OFloatingTitleBar, 0, 0);
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_type) == false) goto L23;
        setTitleType(r110.getInt(R$styleable.OFloatingTitleBar_oFloatingTitleBar_type, 0));
    L23:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle) == false) goto L26;
        setStartTitle(r110.getString(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle));
    L26:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor) == false) goto L29;
        setStartTitleColor(r110.getColor(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor, R$color.oui_basic_text_1));
    L29:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle) == false) goto L32;
        setStartSubtitle(r110.getString(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle));
    L32:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor) == false) goto L35;
        setStartSubTitleColor(r110.getColor(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor, R$color.oui_basic_text_3));
    L35:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle) == false) goto L38;
        setCenterTitle(r110.getString(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle));
    L38:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor) == false) goto L41;
        setCenterTitleColor(r110.getColor(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor, R$color.oui_basic_text_1));
    L41:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle) == false) goto L44;
        setCenterSubtitle(r110.getString(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle));
    L44:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor) == false) goto L46;
        setCenterSubTitleColor(r110.getColor(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor, R$color.oui_basic_text_3));
    L46:
        setStartButtonGroupStyle(r110.getResourceId(R$styleable.OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle, R$style.OFloatingTitleBar_Action_Standard));
        setCenterButtonGroupStyle(r110.getResourceId(R$styleable.OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle, R$style.OFloatingTitleBar_Action_Standard));
        setSubEndButtonGroupStyle(r110.getResourceId(R$styleable.OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle, R$style.OFloatingTitleBar_Action_Standard));
        setEndButtonGroupStyle(r110.getResourceId(R$styleable.OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle, R$style.OFloatingTitleBar_Action_Standard));
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground) == false) goto L53;
        Drawable r25 = r110.getDrawable(R$styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground);
        if (r25 == null) goto L51;
        setMaskBackground(r25);
        goto L53
    L51:
        setMaskBackground(new ColorDrawable(r110.getColor(R$styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, 0)));
    L53:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground) == false) goto L56;
        r110.getBoolean(R$styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground, false);
    L56:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oui_widgetBlurColors) == false) goto L70;
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oui_widgetBlurBlendModes) == false) goto L70;
        int r26 = r110.getResourceId(R$styleable.OFloatingTitleBar_oui_widgetBlurColors, R$array.oui_titlebar_blur_colors);
        int r27 = r110.getResourceId(R$styleable.OFloatingTitleBar_oui_widgetBlurBlendModes, R$array.oui_titlebar_blur_blend_modes);
        com.obric.oui.material.c r28 = this.f14808u;
        if (r28 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r28 = null;
    L62:
        r28.f13611c = n.c(r110.getResources(), r26, r27);
        com.obric.oui.material.c r29 = this.f14808u;
        if (r29 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L67:
        if (r19.f13611c != null) goto L70;
        ps.a.c("OFloatingTitleBar", "init get widget blur colors or modes error");
        goto L70
    L65:
        r19 = r29;
    L70:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oui_widgetMaterialSrcType) == false) goto L76;
        int r30 = R$styleable.OFloatingTitleBar_oui_widgetMaterialSrcType;
        if (this.f14809v != 2) goto L74;
        r5 = 4;
    L74:
        this.s = r110.getInt(r30, r5);
    L76:
        if (r110.hasValue(R$styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius) == false) goto L79;
        setMaskBlurRadius(r110.getFloat(R$styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius, BlurToken.Blur_Progress_Thin));
    L79:
        if (r110.getBoolean(R$styleable.OFloatingTitleBar_oui_widgetFitInsetTop, r110.getBoolean(R$styleable.OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion, false)) == true) goto L81;
    L83:
        r13 = false;
    L84:
        r15.d(r13, new OFloatingTitleBar$initAttrs$1$1(this));
        r110.recycle();
        goto L85
    L81:
        if (this.f14809v == 1) goto L83;
    L85:
        r15.f16959b = 49;
    }
}
