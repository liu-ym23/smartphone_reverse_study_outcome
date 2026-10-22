package com.obric.oui.button;

import a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.m;
import com.obric.oui.common.style.n;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.c;
import com.obric.oui.material.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\"\u0010\u0017\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0010R\"\u0010\u001b\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0010R\"\u0010\"\u001a\u00020\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0010R\"\u0010,\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\bR$\u00104\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00108\u001a\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R*\u0010A\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001098\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bB\u0010(\u001a\u0004\bC\u0010*\"\u0004\bD\u0010\bR*\u0010I\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001098\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R\"\u0010M\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0013\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010\u0010R\"\u0010O\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bN\u0010(\u001a\u0004\bO\u0010*\"\u0004\bP\u0010\bR\"\u0010Q\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bQ\u0010(\u001a\u0004\bQ\u0010*\"\u0004\bR\u0010\b¨\u0006S"}, d2 = {"Lcom/obric/oui/button/OShadowFrame;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/d;", "", "", "enabled", "", "setEnabled", "(Z)V", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "", "color", "setBgColor", "(I)V", "setPressColor", "k", "I", "getBgColorNormal", "()I", "setBgColorNormal", "bgColorNormal", "l", "getBgColorDisabled", "setBgColorDisabled", "bgColorDisabled", "o", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentView", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentView", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentView", "r", "getCurrentTheme", "setCurrentTheme", "currentTheme", "s", "Z", "getEnableMaterial", "()Z", "setEnableMaterial", "enableMaterial", "", "t", "Ljava/lang/String;", "getMaterialTokenString", "()Ljava/lang/String;", "setMaterialTokenString", "(Ljava/lang/String;)V", "materialTokenString", "u", "getMaterialDisabledTokenString", "setMaterialDisabledTokenString", "materialDisabledTokenString", "", "Lcom/obric/oui/material/c;", "v", "[Lcom/obric/oui/material/c;", "getMaterials", "()[Lcom/obric/oui/material/c;", "setMaterials", "([Lcom/obric/oui/material/c;)V", "materials", "w", "getMaterialApplied", "setMaterialApplied", "materialApplied", "x", "getMaterialsDisabled", "setMaterialsDisabled", "materialsDisabled", "y", "getMaterialSrcType", "setMaterialSrcType", "materialSrcType", "z", "isMaterialFromDrawable", "setMaterialFromDrawable", "isBackdropView", "setBackdropView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OShadowFrame extends OUIFrameLayout implements d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jp.d f12147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public jp.d f12148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12149j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12150k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12151l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f12152m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f12153n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OUIFrameLayout f12154o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f12155p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f12156q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12157r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f12158t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f12159u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c[] f12160v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12161w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c[] f12162x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12163y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12164z;

    @JvmOverloads
    public OShadowFrame(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r5 = null;
        int r11 = 14;
        this(r10, r5, 0, r11, 0);
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.f12163y = r5;
        a.F(getContentView(), r5);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r10 = super.dispatchTouchEvent(r5);
        int r11 = r5.getAction();
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
    L8:
        o(false);
    L10:
        return r10;
    L6:
        if (r11 == 3) goto L8;
    L9:
        o(true);
        goto L10
    }

    public final int getBgColorDisabled() {
        return this.f12151l;
    }

    public final int getBgColorNormal() {
        return this.f12150k;
    }

    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r5 = this.f12154o;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    public final int getCurrentTheme() {
        return this.f12157r;
    }

    public final boolean getEnableMaterial() {
        return this.s;
    }

    public final boolean getMaterialApplied() {
        return this.f12161w;
    }

    public final String getMaterialDisabledTokenString() {
        return this.f12159u;
    }

    public final int getMaterialSrcType() {
        return this.f12163y;
    }

    public final String getMaterialTokenString() {
        return this.f12158t;
    }

    public final c[] getMaterials() {
        return this.f12160v;
    }

    public final c[] getMaterialsDisabled() {
        return this.f12162x;
    }

    public void n(int r5) {
        if (this.f12157r == r5) goto L14;
        this.f12157r = r5;
        String r10 = this.f12158t;
        if (r10 == null) goto L8;
        setMaterials(MaterialToken.parseSet(r10, !r()));
    L8:
        String r11 = this.f12159u;
        if (r11 == null) goto L12;
        setMaterialsDisabled(MaterialToken.parseSet(r11, !r()));
    L12:
        u(isEnabled());
        return;
    }

    public final void o(boolean r5) {
        float r10 = this.f12153n;
        if (isEnabled() == true) goto L6;
        ps.a.a("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L6:
        ps.a.a("OShadowFrame", Intrinsics.stringPlus("doPressAnim: ", Boolean.valueOf(r5)));
        jp.d r11 = this.f12147h;
        if (r11 == null) goto L10;
        int r12 = jp.d.d;
        r11.a(false);
    L10:
        jp.d r13 = this.f12148i;
        if (r13 == null) goto L14;
        int r14 = jp.d.d;
        r13.a(false);
    L14:
        float r15 = this.f12152m;
        if (r5 == false) goto L17;
        this.f12147h = n.c(this, r15, r10, getCurrentShadows(), this.f12156q);
        return;
    L17:
        this.f12148i = n.c(this, r10, r15, getCurrentShadows(), this.f12155p);
    }

    public abstract void p(Context r5, OUIFrameLayout r10, TypedArray r11);

    public final void q(Context r5, TypedArray r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "typedArray");
        this.f12163y = r10.getInt(R$styleable.OShadowFrame_oui_widgetMaterialSrcType, 2);
        String r11 = r10.getString(R$styleable.OShadowFrame_oui_widgetMaterial);
        boolean r12 = h.i(this.f12150k);
        if (r11 != null) goto L6;
        if (r12 == true) goto L6;
        r11 = getResources().getString(R$string.oui_material_bg_floating);
    L6:
        this.f12158t = r11;
        boolean r13 = r();
        if (r12 == false) goto L12;
        Function1<Boolean, c[]> r14 = MaterialToken.OUI_Bg_Floating_Tinted;
        boolean r15 = !r13;
        this.f12160v = z5.a.j(r14.invoke(Boolean.valueOf(r15)), this.f12150k);
        if (this.f12151l == 0) goto L17;
        this.f12162x = z5.a.j(r14.invoke(Boolean.valueOf(r15)), this.f12151l);
    L17:
        if (this.f12160v != null) goto L20;
        this.s = false;
        this.f12161w = false;
        return;
    L20:
        return;
    L12:
        if (this.f12158t == null) goto L17;
        boolean r16 = !r13;
        this.f12160v = MaterialToken.parseSet(r11, r16);
        String r17 = r10.getString(R$styleable.OShadowFrame_oui_widgetMaterialDisabled);
        this.f12159u = r17;
        if (r17 == null) goto L17;
        this.f12162x = MaterialToken.parseSet(r17, r16);
        goto L17
    }

    public final boolean r() {
        int r5 = this.f12150k;
        if (r5 != 0) goto L7;
        return a.v(this);
    L7:
        if (this.f12157r != 2) goto L9;
    L12:
        return true;
    L9:
        if (h.j(r5) == true) goto L12;
        return false;
    }

    public final void s(int r5, int r10, String r11, String r12) {
        this.f12150k = r5;
        this.f12151l = r10;
        int r13 = 1;
        if (r11 == null) goto L15;
        if (Intrinsics.areEqual(this.f12158t, r11) == true) goto L8;
        this.f12158t = r11;
        this.f12160v = MaterialToken.parseSet(r11, !r());
    L8:
        String r14 = this.f12159u;
        if (r14 != null) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == true) goto L15;
        this.f12159u = r12;
        this.f12162x = MaterialToken.parseSet(r12, !r());
        goto L15
    L11:
        r15 = StringsKt.h(r14, r12);
    L15:
        if (h.j(r5) == false) goto L18;
        r13 = 2;
    L18:
        if (r13 == this.f12157r) goto L21;
        n(r13);
        return;
    L21:
        u(isEnabled());
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        OUIFrameLayout r10 = getContentView();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        com.obric.oui.material.n.r(r5, r10);
    }

    public final void setBackdropView(boolean r5) {
    }

    public void setBgColor(@ColorInt int r5) {
        if (this.f12150k == r5) goto L27;
        this.f12150k = r5;
        this.f12151l = r5;
        boolean r10 = h.j(r5);
        ColorUtils.setAlphaComponent(this.f12150k, 48);
        if (h.i(this.f12150k) == false) goto L11;
        Function1<Boolean, c[]> r11 = MaterialToken.OUI_Bg_Floating_Tinted;
        boolean r12 = !r10;
        c[] r13 = z5.a.j(r11.invoke(Boolean.valueOf(r12)), this.f12150k);
        if (this.f12151l == 0) goto L9;
        c[] r14 = z5.a.j(r11.invoke(Boolean.valueOf(r12)), this.f12151l);
    L10:
        t(r13, r14);
    L18:
        if (r10 == false) goto L20;
        int r15 = 2;
    L22:
        if (r15 == this.f12157r) goto L25;
        n(r15);
        return;
    L25:
        u(isEnabled());
        return;
    L20:
        r15 = 1;
        goto L22
    L9:
        r14 = null;
        goto L10
    L11:
        String r16 = this.f12158t;
        if (r16 == null) goto L17;
        boolean r17 = !r10;
        c[] r18 = MaterialToken.parseSet(r16, r17);
        this.f12160v = r18;
        String r19 = this.f12159u;
        if (r19 == null) goto L16;
        this.f12162x = MaterialToken.parseSet(r19, r17);
        goto L18
    L16:
        this.f12162x = r18;
        goto L18
    L17:
        Function1<Boolean, c[]> r20 = MaterialToken.OUI_Bg_Floating;
        boolean r21 = !r10;
        t(r20.invoke(Boolean.valueOf(r21)), r20.invoke(Boolean.valueOf(r21)));
        goto L18
    }

    public final void setBgColorDisabled(int r5) {
        this.f12151l = r5;
    }

    public final void setBgColorNormal(int r5) {
        this.f12150k = r5;
    }

    public final void setContentView(OUIFrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f12154o = r5;
    }

    public final void setCurrentTheme(int r5) {
        this.f12157r = r5;
    }

    public final void setEnableMaterial(boolean r5) {
        this.s = r5;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        getContentView().setEnabled(r5);
        u(r5);
    }

    public final void setMaterialApplied(boolean r5) {
        this.f12161w = r5;
    }

    public final void setMaterialDisabledTokenString(String r5) {
        this.f12159u = r5;
    }

    public final void setMaterialFromDrawable(boolean r5) {
        this.f12164z = r5;
    }

    public final void setMaterialSrcType(int r5) {
        this.f12163y = r5;
    }

    public final void setMaterialTokenString(String r5) {
        this.f12158t = r5;
    }

    public final void setMaterials(c[] r5) {
        this.f12160v = r5;
    }

    public final void setMaterialsDisabled(c[] r5) {
        this.f12162x = r5;
    }

    public void setPressColor(@ColorInt int r5) {
        this.f12149j = r5;
        getContentView().setOverridePressColor(this.f12149j);
        getContentView().i("OShadowFrame");
    }

    public final void t(c[] r5, c[] r10) {
        this.f12160v = r5;
        this.f12162x = r10;
        this.f12158t = null;
        this.f12159u = null;
    }

    public void u(boolean r5) {
        if (this.f12161w == true) goto L9;
        getContentView().setBorderWidth(0);
        getContentView().setBorderColor(0);
        if (r5 == false) goto L7;
        getContentView().setBackgroundColor(this.f12150k);
        return;
    L7:
        getContentView().setBackgroundColor(this.f12151l);
        return;
    L9:
        if (this.f12164z == false) goto L11;
        return;
    L11:
        getContentView().setBackgroundColor(0);
        if (r5 == false) goto L17;
        c[] r10 = this.f12160v;
        if (r10 == null) goto L25;
        a.y(getContentView(), r10, false, getMaterialSrcType(), 10);
        return;
    L25:
        return;
    L17:
        c[] r11 = this.f12162x;
        if (r11 == null) goto L26;
        a.y(getContentView(), r11, false, getMaterialSrcType(), 10);
        return;
    }

    @JvmOverloads
    public OShadowFrame(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r5 = 12;
        this(r10, r11, 0, r5, 0);
    }

    @JvmOverloads
    public OShadowFrame(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, 8, 0);
    }

    public /* synthetic */ OShadowFrame(Context r5, AttributeSet r10, int r11, int r12, int r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        this(r5, r10, r11, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OShadowFrame(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 8);
        this.f12152m = 1.0f;
        this.f12153n = 1.0f;
        this.f12163y = 2;
        int r5 = 0;
        if (a.w(this) == true) goto L5;
    L7:
        boolean r14 = false;
    L8:
        this.s = r14;
        this.f12161w = r14;
        TypedArray r15 = r10.obtainStyledAttributes(r11, R$styleable.OShadowFrame);
        if (this.s == false) goto L11;
        boolean r16 = r15.getBoolean(R$styleable.OShadowFrame_oui_widgetEnableMaterial, true);
        this.s = r16;
        this.f12161w = r16;
    L11:
        OUIFrameLayout r17 = null;
        setContentView(new OUIFrameLayout(r10, 0 == true ? 1 : 0, r5, 14));
        getContentView().setDuplicateParentStateEnabled(true);
        this.f12150k = r15.getColor(R$styleable.OShadowFrame_oui_widgetBgColor, getResources().getColor(R$color.oui_floating_button_bg_color_1, null));
        this.f12151l = r15.getColor(R$styleable.OShadowFrame_oui_widgetBgColorDisabled, getResources().getColor(R$color.oui_floating_button_bg_color_1, null));
        if (this.f12150k == 0) goto L14;
        getContentView().setBackgroundColor(this.f12150k);
    L14:
        this.f12153n = r15.getFloat(R$styleable.OShadowFrame_oui_widgetPressScale, 1.0f);
        setChangeAlphaWhenPress(false);
        int r18 = r15.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingL, 0);
        int r19 = r15.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingR, 0);
        int r20 = r15.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingT, 0);
        int r21 = r15.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetPaddingB, 0);
        int r22 = r15.getDimensionPixelSize(R$styleable.OShadowFrame_oui_widgetRadius, 0);
        Drawable r23 = r15.getDrawable(R$styleable.OShadowFrame_oui_widgetMaterialBackground);
        getContentView().setPadding(r18, r20, r19, r21);
        getContentView().setRadius(r22);
        this.f12149j = r15.getColor(R$styleable.OShadowFrame_oui_widgetPressColor, 0);
        getContentView().setOverridePressColor(this.f12149j);
        getContentView().i("OShadowFrame");
        addView(getContentView(), new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r22);
        p(r10, getContentView(), r15);
        if (r23 == null) goto L17;
        boolean r110 = true;
    L18:
        this.f12164z = r110;
        if (r110 == false) goto L21;
        getContentView().setBackground(r23);
        getContentView().setChangeAlphaWhenPress(false);
        getContentView().setChangeAlphaWhenDisable(false);
    L21:
        OUIFrameLayout r111 = getContentView();
        if (r111 == null) goto L25;
        r17 = r111;
    L25:
        if (r17 == null) goto L28;
        r17.setChangeAlphaWhenDisable(false);
    L28:
        setChangeAlphaWhenDisable(false);
        int r112 = r15.getResourceId(R$styleable.OShadowFrame_oui_widgetShadowNormal, 0);
        int r113 = r15.getResourceId(R$styleable.OShadowFrame_oui_widgetShadowPressed, 0);
        if (r112 == 0) goto L31;
        ArrayList r114 = i.o(r112, r10);
        List r115 = CollectionsKt.listOf(new m[]{(m) r114.get(0), (m) r114.get(1)});
        this.f12155p = r115;
        Intrinsics.checkNotNull(r115);
        m r116 = (m) CollectionsKt.getOrNull(r115, 0);
        List r24 = this.f12155p;
        Intrinsics.checkNotNull(r24);
        l(r116, (m) CollectionsKt.getOrNull(r24, 1), false);
    L31:
        if (r113 == 0) goto L33;
        ArrayList r25 = i.o(r113, r10);
        this.f12156q = CollectionsKt.listOf(new m[]{(m) r25.get(0), (m) r25.get(1)});
    L33:
        r15.recycle();
        setClipChildren(false);
        setClickable(true);
        u(isEnabled());
        return;
    L17:
        r110 = false;
        goto L18
    L5:
        if (com.obric.oui.material.n.k() == false) goto L7;
        r14 = true;
        goto L8
    }
}
