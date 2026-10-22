package com.obric.oui.common.style;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f12455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12457c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f12459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AttributeSet f12460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f12463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f12464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ObjectAnimator f12465o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ObjectAnimator f12466p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f12467q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12468r;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        View r5 = (View) this.f12455a.get();
        if (r5 != 0) goto L6;
        return;
    L6:
        if (this.f12456b == false) goto L15;
        if (r5.isPressed() == false) goto L10;
    L13:
        r5.setForeground(this.f12463m);
        return;
    L10:
        if ((r5 instanceof b) == false) goto L15;
        if (((b) r5).b() == true) goto L13;
    L15:
        if (this.f12456b == false) goto L22;
        if ((r5 instanceof b) == false) goto L22;
        if (((b) r5).g() == false) goto L22;
        r5.setForeground(this.f12463m);
        return;
    L22:
        if (this.e == true) goto L24;
    L26:
        r5.setForeground(null);
        return;
    L24:
        if (r5.isSelected() == false) goto L26;
        r5.setForeground(this.f12464n);
    }

    public final void b(View r10) {
        int r5 = this.g;
        if (r5 != (-1)) goto L5;
        r5 = ContextCompat.getColor(r10.getContext(), R$color.oui_fill_element_2);
    L5:
        int[] r11 = {ContextCompat.getColor(r10.getContext(), R$color.oui_accent_bg), ContextCompat.getColor(r10.getContext(), R$color.oui_functional_red_6)};
        this.f = r5;
        Context r12 = this.f12459i;
        int[] r13 = R$styleable.OUIAlpha;
        AttributeSet r14 = this.f12460j;
        int r15 = this.f12461k;
        int r16 = this.f12462l;
        TypedArray r17 = r12.obtainStyledAttributes(r14, r13, r15, r16);
        int r18 = 0;
        if (r14 != null) goto L9;
        if (r15 != 0) goto L9;
        if (r16 != 0) goto L9;
    L19:
        if (this.f != r5) goto L28;
        Drawable r19 = r10.getBackground();
        if ((r19 instanceof ColorDrawable) == false) goto L28;
    L23:
        if (r18 >= 2) goto L28;
        if (((ColorDrawable) r19).getColor() != r11[r18]) goto L27;
        this.f = ContextCompat.getColor(r10.getContext(), R$color.oui_pressed_on_color);
    L27:
        r18 = r18 + 1;
    L28:
        c(r10);
        return;
    L9:
        int r20 = r17.getIndexCount();
        int r21 = 0;
    L10:
        if (r21 >= r20) goto L19;
        int r22 = r17.getIndex(r21);
        if (r22 != R$styleable.OUIAlpha_OUI_alpha_pressed) goto L15;
        this.f = r17.getColor(r22, r5);
    L17:
        r21 = r21 + 1;
        goto L10
    L15:
        if (r22 != R$styleable.OUIAlpha_OUI_alpha_disabled) goto L17;
        this.f12458h = r17.getFloat(r22, -1.0f);
        goto L17
    }

    public final void c(View r10) {
        if (this.f12468r <= 0) goto L5;
        GradientDrawable r5 = new GradientDrawable();
        this.f12463m = r5;
        r5.setCornerRadius(this.f12468r);
        ((GradientDrawable) this.f12463m).setColor(this.f);
        GradientDrawable r11 = new GradientDrawable();
        this.f12464n = r11;
        r11.setCornerRadius(this.f12468r);
        ((GradientDrawable) this.f12464n).setColor(this.f);
    L6:
        boolean r12 = true;
        if (this.f <= 0) goto L9;
        boolean r13 = true;
    L10:
        this.f12456b = r13;
        if (this.f12458h > 0.0f) goto L14;
        r12 = false;
    L14:
        this.d = r12;
        d(r10, r10.isEnabled());
        ObjectAnimator r14 = ObjectAnimator.ofInt(this.f12463m, "alpha", new int[]{255, 255});
        this.f12465o = r14;
        r14.setDuration(1);
        this.f12465o.setInterpolator(null);
        final int r15 = 0;
        this.f12465o.addUpdateListener(new f(this, r15));
        ObjectAnimator r16 = ObjectAnimator.ofInt(this.f12463m, "alpha", new int[]{255, 0});
        this.f12466p = r16;
        r16.setDuration(this.f12467q);
        this.f12466p.setInterpolator(null);
        final int r17 = 1;
        this.f12466p.addListener(new bq.a(this, r17));
        this.f12466p.addUpdateListener(new f(this, r17));
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        this.f12463m = new ColorDrawable(this.f);
        this.f12464n = new ColorDrawable(this.f);
        goto L6
    }

    public final void d(View r5, boolean r10) {
        View r11 = (View) this.f12455a.get();
        if (r11 != null) goto L5;
        return;
    L5:
        float r12 = 1.0f;
        if (this.d == false) goto L10;
        if (r10 == true) goto L10;
        r12 = this.f12458h;
    L10:
        if (r5 != r11) goto L12;
    L14:
        r11.setAlpha(r12);
        return;
    L12:
        if (r11.isEnabled() == r10) goto L14;
        r11.setEnabled(r10);
        goto L14
    }

    public final void e(boolean r5) {
        if (((View) this.f12455a.get()) != null) goto L5;
        return;
    L5:
        this.f12465o.cancel();
        this.f12466p.cancel();
        if (this.f12456b == true) goto L8;
        return;
    L8:
        if (this.f12457c == true) goto L14;
        if (r5 == false) goto L11;
        a();
        this.f12465o.start();
        return;
    L11:
        this.f12466p.start();
        return;
    }

    public final void f(ValueAnimator r5, String r10) {
        KeyEvent.Callback r11 = (View) this.f12455a.get();
        if ((r11 instanceof b) == true) goto L5;
        return;
    L5:
        b r12 = (b) r11;
        Object r13 = r5.getAnimatedValue("alpha");
        if (r12.k() == false) goto L16;
        if ((r13 instanceof Integer) == false) goto L16;
        int r14 = ((Integer) r13).intValue();
        if (r14 >= 0) goto L12;
    L14:
        ps.a.c("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r14 + ", scene: " + r10);
        goto L16
    L12:
        if (r14 > 255) goto L14;
        r12.m((255 - r14) / 255.0f);
    L16:
        if ((r13 instanceof Integer) == false) goto L19;
        r12.j(((Integer) r13).intValue());
        return;
    }

    public final void g(int r5) {
        if (this.g == r5) goto L6;
        this.g = r5;
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        if (this.e == false) goto L6;
        a();
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
        View r10 = (View) this.f12455a.get();
        if (r10 != null) goto L6;
        ps.a.c("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        b(r10);
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenDisable(boolean r5) {
        this.d = r5;
        View r10 = (View) this.f12455a.get();
        if (r10 == null) goto L6;
        d(r10, r10.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenPress(boolean r5) {
        this.f12456b = r5;
        View r10 = (View) this.f12455a.get();
    }

    @Override // com.obric.oui.common.style.a
    public final void setKeepPressAlpha(final boolean r5) {
        ps.a.f("OUIAlphaHelper", "setKeepPressAlpha, " + r5 + ", target: " + this.f12455a.get());
        int r10 = 0;
        if (this.f12457c == r5) goto L7;
        this.f12457c = r5;
        if (r5 == true) goto L7;
        View r11 = (View) this.f12455a.get();
        e(false);
    L7:
        View r12 = (View) this.f12455a.get();
        Function1 r13 = new e(r5);
        Intrinsics.checkNotNullParameter(r13, "visitor");
        if (r12 != null) goto L11;
        return;
    L11:
        if ((r12 instanceof ViewGroup) == false) goto L19;
        ViewGroup r14 = (ViewGroup) r12;
        int r15 = r14.getChildCount();
    L13:
        if (r10 >= r15) goto L24;
        int r16 = r10 + 1;
        View r17 = r14.getChildAt(r10);
        if (r17 == null) goto L18;
        r13.invoke(r17);
    L18:
        r10 = r16;
        goto L13
    L24:
        return;
    }
}
