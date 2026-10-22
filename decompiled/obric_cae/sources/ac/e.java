package ac;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.obric.cae.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements ac.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f259b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f260m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f261n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f262o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f263p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f264q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f265r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Context f266s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AttributeSet f267t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f268u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f269v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ColorDrawable f270w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorDrawable f271x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ObjectAnimator f272y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ObjectAnimator f273z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f274a;

        public a(e r8) {
            this.f274a = r8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r8) {
            this.f274a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            this.f274a.a();
        }
    }

    public e(Context r8, AttributeSet r10, int r11, int r12) {
        this.f259b = true;
        this.f260m = false;
        this.f261n = true;
        this.f262o = false;
        this.f263p = 0;
        this.f264q = -1;
        this.f265r = 0.3f;
        this.f266s = r8;
        this.f267t = r10;
        this.f268u = r11;
        this.f269v = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        View r8 = this.f258a.get();
        if (r8 != 0) goto L6;
        return;
    L6:
        if (this.f259b == false) goto L12;
        if (r8.isPressed() == false) goto L12;
    L9:
        ColorDrawable r10 = this.f270w;
    L10:
        r8.setForeground(r10);
        return;
    L12:
        if (this.f259b == false) goto L19;
        if ((r8 instanceof b) == false) goto L19;
        if (((b) r8).c() == true) goto L9;
    L19:
        if (this.f262o == true) goto L21;
    L23:
        r10 = null;
        goto L10
    L21:
        if (r8.isSelected() == false) goto L23;
        r10 = this.f271x;
        goto L10
    }

    public final void b(View r10) {
        int r8 = this.f264q;
        if (r8 != (-1)) goto L5;
        Context r11 = r10.getContext();
        Object r12 = androidx.core.content.a.f1674a;
        r8 = androidx.core.content.a.c.a(r11, R.color.oui_fill_element_3);
    L5:
        Context r13 = r10.getContext();
        Object r14 = androidx.core.content.a.f1674a;
        int[] r15 = {androidx.core.content.a.c.a(r13, R.color.oui_accent_bg), androidx.core.content.a.c.a(r10.getContext(), R.color.oui_functional_red_6)};
        this.f263p = r8;
        int[] r16 = nb.a.f9508v;
        Context r17 = this.f266s;
        AttributeSet r18 = this.f267t;
        int r19 = this.f268u;
        int r20 = this.f269v;
        TypedArray r21 = r17.obtainStyledAttributes(r18, r16, r19, r20);
        boolean r22 = true;
        if (r18 != null) goto L9;
        if (r19 != 0) goto L9;
        if (r20 != 0) goto L9;
    L17:
        int r23 = 2;
        if (this.f263p != r8) goto L27;
        Drawable r24 = r10.getBackground();
        if ((r24 instanceof ColorDrawable) == false) goto L27;
        int r25 = 0;
    L22:
        if (r25 >= 2) goto L27;
        if (((ColorDrawable) r24).getColor() != r15[r25]) goto L26;
        this.f263p = androidx.core.content.a.c.a(r10.getContext(), R.color.oui_pressed_on_color);
    L26:
        r25 = r25 + 1;
    L27:
        this.f270w = new ColorDrawable(this.f263p);
        this.f271x = new ColorDrawable(this.f263p);
        if (this.f263p <= 0) goto L30;
        boolean r26 = true;
    L31:
        this.f259b = r26;
        if (this.f265r > 0.0f) goto L35;
        r22 = false;
    L35:
        this.f261n = r22;
        c(r10, r10.isEnabled());
        ObjectAnimator r110 = ObjectAnimator.ofInt(this.f270w, "alpha", new int[]{0, 255});
        this.f272y = r110;
        r110.setDuration(10);
        this.f272y.setInterpolator(new DecelerateInterpolator());
        this.f272y.addUpdateListener(new com.google.android.material.textfield.b(this, r23));
        ObjectAnimator r111 = ObjectAnimator.ofInt(this.f270w, "alpha", new int[]{255, 0});
        this.f273z = r111;
        r111.setDuration(300);
        this.f273z.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.f273z.addListener(new a(this));
        this.f273z.addUpdateListener(new c(this));
        return;
    L30:
        r26 = false;
    L9:
        int r27 = r21.getIndexCount();
        int r28 = 0;
    L10:
        if (r28 >= r27) goto L17;
        int r29 = r21.getIndex(r28);
        if (r29 != 1) goto L14;
        this.f263p = r21.getColor(r29, r8);
    L16:
        r28 = r28 + 1;
        goto L10
    L14:
        if (r29 != 0) goto L16;
        this.f265r = r21.getFloat(r29, -1.0f);
        goto L16
    }

    public final void c(View r8, boolean r10) {
        View r11 = this.f258a.get();
        if (r11 != null) goto L5;
        return;
    L5:
        float r12 = 1.0f;
        if (this.f261n == false) goto L10;
        if (r10 == true) goto L10;
        r12 = this.f265r;
    L10:
        if (r8 != r11) goto L12;
    L14:
        r11.setAlpha(r12);
        return;
    L12:
        if (r11.isEnabled() == r10) goto L14;
        r11.setEnabled(r10);
        goto L14
    }

    @Override // ac.a
    public final void d(View r8, boolean r10) {
        if (this.f262o == false) goto L6;
        a();
        return;
    }

    public final void e(boolean r8) {
        if (this.f258a.get() != null) goto L5;
        return;
    L5:
        this.f272y.cancel();
        this.f273z.cancel();
        if (this.f259b == true) goto L8;
        return;
    L8:
        if (this.f260m == true) goto L15;
        if (r8 == false) goto L11;
        a();
        ObjectAnimator r10 = this.f272y;
    L12:
        r10.start();
        return;
    L11:
        r10 = this.f273z;
        goto L12
    }

    public final void f(ValueAnimator r8, String r10) {
        KeyEvent.Callback r11 = (View) this.f258a.get();
        if ((r11 instanceof b) == true) goto L5;
        return;
    L5:
        b r12 = (b) r11;
        Object r13 = r8.getAnimatedValue("alpha");
        if (r12.f() == false) goto L16;
        if ((r13 instanceof Integer) == false) goto L16;
        int r14 = ((Integer) r13).intValue();
        if (r14 >= 0) goto L12;
    L14:
        zc.b.b("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r14 + ", scene: " + r10);
        goto L16
    L12:
        if (r14 > 255) goto L14;
        r12.g((255 - r14) / 255.0f);
    L16:
        if ((r13 instanceof Integer) == false) goto L19;
        r12.e(((Integer) r13).intValue());
        return;
    }

    public final void g() {
        View r8 = this.f258a.get();
        if (r8 != null) goto L6;
        zc.b.b("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        b(r8);
    }

    @Override // ac.a
    public final void setChangeAlphaWhenDisable(boolean r8) {
        this.f261n = r8;
        View r10 = this.f258a.get();
        if (r10 == null) goto L6;
        c(r10, r10.isEnabled());
        return;
    }

    @Override // ac.a
    public final void setChangeAlphaWhenPress(boolean r8) {
        this.f259b = r8;
        View r10 = this.f258a.get();
    }

    @Override // ac.a
    public final void setKeepPressAlpha(final boolean r8) {
        StringBuilder r10 = android.aimedia.a.l("setKeepPressAlpha, ", r8, ", target: ");
        r10.append(this.f258a.get());
        zc.b.g("OUIAlphaHelper", r10.toString());
        int r11 = 0;
        if (this.f260m == r8) goto L7;
        this.f260m = r8;
        if (r8 == true) goto L7;
        View r12 = this.f258a.get();
        e(false);
    L7:
        View r13 = this.f258a.get();
        ge.l r14 = new d(r8);
        if (r13 != null) goto L11;
        return;
    L11:
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r15 = (ViewGroup) r13;
        int r16 = r15.getChildCount();
    L13:
        if (r11 >= r16) goto L23;
        View r17 = r15.getChildAt(r11);
        if (r17 == null) goto L17;
        r14.invoke(r17);
    L17:
        r11 = r11 + 1;
        goto L13
    L23:
        return;
    }
}
