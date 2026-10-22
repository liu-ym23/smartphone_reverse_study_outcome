package com.obric.oui.common.style;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements com.obric.oui.common.style.a {
    public WeakReference<View> a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Boolean h;
    public Boolean i;
    public int j;
    public int k;
    public float l;
    public final Context m;
    public final AttributeSet n;
    public final int o;
    public final int p;
    public Drawable q;
    public Drawable r;
    public ObjectAnimator s;
    public ObjectAnimator t;
    public final long u;
    public int v;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
            this.a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            this.a.a();
        }
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenEnabledChanged(boolean r1) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        View r0 = this.a.get();
        if (r0 != 0) goto L6;
        return;
    L6:
        if (this.b == false) goto L15;
        if (r0.isPressed() == false) goto L10;
    L13:
        r0.setForeground(this.q);
        return;
    L10:
        if ((r0 instanceof b) == false) goto L15;
        if (((b) r0).Z2() == true) goto L13;
    L15:
        if (this.b == false) goto L22;
        if ((r0 instanceof b) == false) goto L22;
        if (((b) r0).R4() == false) goto L22;
        r0.setForeground(this.q);
        return;
    L22:
        if (this.f == true) goto L24;
    L26:
        r0.setForeground(null);
        return;
    L24:
        if (r0.isSelected() == false) goto L26;
        r0.setForeground(this.r);
    }

    public final void i() {
        this.s.cancel();
        this.t.cancel();
        this.q.setAlpha(0);
        View r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.setForeground(null);
        return;
    }

    public final void b(MotionEvent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r3 = r2.getAction();
        if (r3 == 1) goto L10;
        if (r3 == 3) goto L10;
        return;
    L10:
        if (this.g == false) goto L13;
        i();
        return;
    }

    public final void c(View r11) {
        int r0 = this.k;
        if (r0 != (-1)) goto L5;
        r0 = ContextCompat.getColor(r11.getContext(), 2131104781);
    L5:
        int r4 = 0;
        int[] r2 = {ContextCompat.getColor(r11.getContext(), 2131104015), ContextCompat.getColor(r11.getContext(), 2131104979)};
        this.j = r0;
        TypedArray r3 = this.m.obtainStyledAttributes(this.n, new int[]{2130968660, 2130968661, 2130973028, 2130973029}, this.o, this.p);
        if (this.n == null) goto L8;
    L11:
        int r6 = r3.getIndexCount();
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L20;
        int r8 = r3.getIndex(r7);
        if (r8 != 1) goto L16;
        this.j = r3.getColor(r8, r0);
    L18:
        r7 = r7 + 1;
        goto L12
    L16:
        if (r8 != 0) goto L18;
        this.l = r3.getFloat(r8, -1.0f);
    L20:
        if (this.j != r0) goto L28;
        Drawable r1 = r11.getBackground();
        if ((r1 instanceof ColorDrawable) == false) goto L28;
    L23:
        if (r4 >= 2) goto L28;
        if (((ColorDrawable) r1).getColor() != r2[r4]) goto L27;
        this.j = ContextCompat.getColor(r11.getContext(), 2131105358);
    L27:
        r4 = r4 + 1;
    L28:
        d(r11);
        return;
    L8:
        if (this.o != 0) goto L11;
        if (this.p == 0) goto L20;
        goto L11
    }

    public final void d(View r6) {
        if (this.v <= 0) goto L5;
        GradientDrawable r0 = new GradientDrawable();
        this.q = r0;
        r0.setCornerRadius(this.v);
        ((GradientDrawable) this.q).setColor(this.j);
        GradientDrawable r1 = new GradientDrawable();
        this.r = r1;
        r1.setCornerRadius(this.v);
        ((GradientDrawable) this.r).setColor(this.j);
    L6:
        boolean r2 = true;
        if (this.h != null) goto L14;
        if (this.j <= 0) goto L11;
        boolean r3 = true;
    L12:
        this.b = r3;
        goto L14
    L11:
        r3 = false;
    L14:
        if (this.i == null) goto L16;
    L20:
        e(r6, r6.isEnabled());
        if (Build.VERSION.SDK_INT < 23) goto L24;
        ObjectAnimator r7 = ObjectAnimator.ofInt(this.q, "alpha", new int[]{255, 255});
        this.s = r7;
        r7.setDuration(1);
        this.s.setInterpolator(null);
        this.s.addUpdateListener(new f(this));
        ObjectAnimator r8 = ObjectAnimator.ofInt(this.q, "alpha", new int[]{255, 0});
        this.t = r8;
        r8.setDuration(this.u);
        this.t.setInterpolator(null);
        this.t.addListener(new a(this));
        this.t.addUpdateListener(new g(this));
        return;
    L24:
        return;
    L16:
        if (this.l > 0.0f) goto L19;
        r2 = false;
    L19:
        this.d = r2;
        goto L20
    L5:
        this.q = new ColorDrawable(this.j);
        this.r = new ColorDrawable(this.j);
        goto L6
    }

    public final void f(boolean r3) {
        View r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        this.s.cancel();
        this.t.cancel();
        if (r0.isEnabled() == true) goto L9;
        return;
    L9:
        if (this.b == true) goto L11;
        return;
    L11:
        if (this.c == true) goto L20;
        if (r3 == false) goto L15;
        a();
        this.s.start();
        return;
    L15:
        if (this.g == false) goto L17;
        i();
        return;
    L17:
        this.t.start();
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r1) {
        this.g = r1;
    }

    public final void h(int r2) {
        if (this.v == r2) goto L10;
        this.v = r2;
        View r3 = this.a.get();
        if (r3 != null) goto L8;
        wma.b.b("OUIAlphaHelper", "setRadius: owner is null");
        return;
    L8:
        d(r3);
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r2) {
        View r3 = this.a.get();
        if (r3 != null) goto L6;
        wma.b.b("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        c(r3);
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenDisable(boolean r2) {
        this.i = Boolean.valueOf(r2);
        this.d = r2;
        View r3 = this.a.get();
        if (r3 == null) goto L6;
        e(r3, r3.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void setChangeAlphaWhenPress(boolean r2) {
        this.h = Boolean.valueOf(r2);
        this.b = r2;
        View r3 = this.a.get();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.oui.common.style.e, java.lang.Object] */
    @Override // com.obric.oui.common.style.a
    public final void setKeepPressAlpha(final boolean r5) {
        wma.b.g("OUIAlphaHelper", "setKeepPressAlpha, " + r5 + ", target: " + this.a.get());
        int r1 = 0;
        if (this.c == r5) goto L7;
        this.c = r5;
        if (r5 == true) goto L7;
        View r0 = this.a.get();
        f(false);
    L7:
        View r2 = this.a.get();
        ?? r3 = new e(r5);
        int r6 = vma.h.a;
        Intrinsics.checkNotNullParameter(r3, "visitor");
        if (r2 != null) goto L11;
        return;
    L11:
        if ((r2 instanceof ViewGroup) == false) goto L19;
        ViewGroup r4 = (ViewGroup) r2;
        int r7 = r4.getChildCount();
    L13:
        if (r1 >= r7) goto L24;
        int r8 = r1 + 1;
        View r9 = r4.getChildAt(r1);
        if (r9 == null) goto L18;
        r3.invoke(r9);
    L18:
        r1 = r8;
        goto L13
    L24:
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void setOverridePressColor(int r2) {
        if (this.k == r2) goto L6;
        this.k = r2;
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r1, boolean r2) {
        if (this.f == false) goto L6;
        a();
        return;
    }

    public final void e(View r4, boolean r5) {
        View r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        float r2 = 1.0f;
        if (this.d == false) goto L10;
        if (r5 == true) goto L10;
        r2 = this.l;
    L10:
        if (r4 == r0) goto L15;
        if (r0.isEnabled() == r5) goto L15;
        r0.setEnabled(r5);
    L15:
        if (this.e == true) goto L17;
        return;
    L17:
        r0.setAlpha(r2);
    }

    public final void g(ValueAnimator r5, String r6) {
        KeyEvent.Callback r0 = (View) this.a.get();
        if ((r0 instanceof b) == true) goto L5;
        return;
    L5:
        b r1 = (b) r0;
        Object r7 = r5.getAnimatedValue("alpha");
        if (r1.S() == false) goto L16;
        if ((r7 instanceof Integer) == false) goto L16;
        int r2 = ((Integer) r7).intValue();
        if (r2 >= 0) goto L12;
    L14:
        wma.b.b("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r2 + ", scene: " + r6);
        goto L16
    L12:
        if (r2 > 255) goto L14;
        r1.T0((255 - r2) / 255.0f);
    L16:
        if ((r7 instanceof Integer) == false) goto L19;
        r1.Q5(((Integer) r7).intValue());
        return;
    }

    public h(Context r5, AttributeSet r6, int r7, int r8) {
        this.b = true;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = -1;
        this.l = 0.3f;
        this.u = Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        this.v = 0;
        this.m = r5;
        this.n = r6;
        this.o = r7;
        this.p = r8;
    }
}
