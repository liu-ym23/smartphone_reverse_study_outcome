package o9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class g implements o9.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<View> f11506c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f11512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11514n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f11515o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Context f11516p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AttributeSet f11517q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f11518r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11519s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorDrawable f11520t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ColorDrawable f11521u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ObjectAnimator f11522v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ObjectAnimator f11523w;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f11524c;

        a(g r10) {
            this.f11524c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            g.e(this.f11524c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            g.e(this.f11524c);
        }
    }

    public g(Context r10, AttributeSet r11, int r12, int r13) {
        this.f11507g = true;
        this.f11508h = false;
        this.f11509i = true;
        this.f11510j = false;
        this.f11511k = false;
        this.f11512l = 1.0f;
        this.f11513m = 0;
        this.f11514n = -1;
        this.f11515o = 0.3f;
        this.f11516p = r10;
        this.f11517q = r11;
        this.f11518r = r12;
        this.f11519s = r13;
    }

    public static /* synthetic */ void a(g r10, ValueAnimator r11) {
        r10.j(r11);
    }

    public static /* synthetic */ void b(g r10, ValueAnimator r11) {
        r10.k(r11);
    }

    public static /* synthetic */ Unit c(View r10) {
        return l(r10);
    }

    public static /* synthetic */ Unit d(boolean r10, View r11) {
        return m(r10, r11);
    }

    static /* synthetic */ void e(g r10) {
        r10.g();
    }

    private int f(View r10) {
        int r11 = this.f11514n;
        if (r11 == (-1)) goto L5;
        return r11;
    L5:
        return ContextCompat.getColor(r10.getContext(), u8.c.oui_fill_element_3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g() {
        View r10 = this.f11506c.get();
        if (r10 != 0) goto L6;
        return;
    L6:
        if (this.f11507g == false) goto L12;
        if (r10.isPressed() == false) goto L12;
    L9:
        ColorDrawable r11 = this.f11520t;
    L10:
        r10.setForeground(r11);
        return;
    L12:
        if (this.f11507g == false) goto L19;
        if ((r10 instanceof b) == false) goto L19;
        if (((b) r10).decideIsNeedUpdatePressedForegroundBySelf() == true) goto L9;
    L19:
        if (this.f11510j == true) goto L21;
    L23:
        r11 = null;
        goto L10
    L21:
        if (r10.isSelected() == false) goto L23;
        r11 = this.f11521u;
        goto L10
    }

    private void h(View r11) {
        int r10 = f(r11);
        boolean r12 = false;
        int[] r13 = {ContextCompat.getColor(r11.getContext(), u8.c.oui_accent_bg), ContextCompat.getColor(r11.getContext(), u8.c.oui_functional_red_6)};
        this.f11513m = r10;
        TypedArray r14 = this.f11516p.obtainStyledAttributes(this.f11517q, u8.l.OUIAlpha, this.f11518r, this.f11519s);
        if (this.f11517q == null) goto L5;
    L8:
        int r15 = r14.getIndexCount();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L18;
        int r17 = r14.getIndex(r16);
        if (r17 != u8.l.OUIAlpha_OUI_alpha_pressed) goto L14;
        this.f11513m = r14.getColor(r17, r10);
    L16:
        r16 = r16 + 1;
        goto L9
    L14:
        if (r17 != u8.l.OUIAlpha_OUI_alpha_disabled) goto L16;
        this.f11515o = r14.getFloat(r17, -1.0f);
    L18:
        if (this.f11513m != r10) goto L27;
        Drawable r18 = r11.getBackground();
        if ((r18 instanceof ColorDrawable) == false) goto L27;
        int r19 = 0;
    L22:
        if (r19 >= 2) goto L27;
        if (((ColorDrawable) r18).getColor() != r13[r19]) goto L26;
        this.f11513m = ContextCompat.getColor(r11.getContext(), u8.c.oui_pressed_on_color);
    L26:
        r19 = r19 + 1;
    L27:
        this.f11520t = new ColorDrawable(this.f11513m);
        this.f11521u = new ColorDrawable(this.f11513m);
        if (this.f11513m <= 0) goto L30;
        boolean r20 = true;
    L31:
        this.f11507g = r20;
        if (this.f11515o <= 0.0f) goto L34;
        r12 = true;
    L34:
        this.f11509i = r12;
        n(r11, r11.isEnabled());
        if (Build.VERSION.SDK_INT < 23) goto L45;
        ObjectAnimator r110 = ObjectAnimator.ofInt(this.f11520t, "alpha", new int[]{0, 255});
        this.f11522v = r110;
        r110.setDuration(10);
        this.f11522v.setInterpolator(new DecelerateInterpolator());
        this.f11522v.addUpdateListener(new c(this));
        ObjectAnimator r111 = ObjectAnimator.ofInt(this.f11520t, "alpha", new int[]{255, 0});
        this.f11523w = r111;
        r111.setDuration(300);
        this.f11523w.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.f11523w.addListener(new a(this));
        this.f11523w.addUpdateListener(new d(this));
        return;
    L45:
        return;
    L30:
        r20 = false;
        goto L31
    L5:
        if (this.f11518r != 0) goto L8;
        if (this.f11519s == 0) goto L18;
        goto L8
    }

    private /* synthetic */ void j(ValueAnimator r10) {
        o(r10, "press anim");
    }

    private /* synthetic */ void k(ValueAnimator r10) {
        o(r10, "release anim");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ Unit l(View r10) {
        if ((r10 instanceof o9.a) == false) goto L7;
        ((o9.a) r10).resetAlphaAnim();
        return null;
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ Unit m(boolean r10, View r11) {
        if ((r11 instanceof o9.a) == false) goto L7;
        ((o9.a) r11).setKeepPressAlpha(r10);
        return null;
    L7:
        return null;
    }

    private void o(ValueAnimator r10, String r11) {
        KeyEvent.Callback r12 = (View) this.f11506c.get();
        if ((r12 instanceof b) == true) goto L5;
        return;
    L5:
        b r13 = (b) r12;
        Object r14 = r10.getAnimatedValue("alpha");
        if (r13.shouldUpdateDividerColorOnPress() == false) goto L16;
        if ((r14 instanceof Integer) == false) goto L16;
        int r15 = ((Integer) r14).intValue();
        if (r15 >= 0) goto L12;
    L14:
        ea.b.b("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r15 + ", scene: " + r11);
        goto L16
    L12:
        if (r15 > 255) goto L14;
        r13.updateDividerColorStrength((255 - r15) / 255.0f);
    L16:
        if ((r14 instanceof Integer) == false) goto L19;
        r13.onPressAlphaChange(((Integer) r14).intValue());
        return;
    }

    private void q() {
        this.f11522v.cancel();
        this.f11523w.cancel();
        this.f11520t.setAlpha(0);
        View r10 = this.f11506c.get();
        if (r10 == null) goto L6;
        r10.setForeground(null);
        return;
    }

    @Override // o9.a
    public void disablePressReleaseAnim(boolean r10) {
        this.f11511k = r10;
    }

    @Override // o9.a
    public void handleTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.getAction();
        if (r11 == 1) goto L10;
        if (r11 == 3) goto L10;
        return;
    L10:
        if (this.f11511k == false) goto L13;
        q();
        return;
    }

    public void i(View r10) {
        this.f11506c = new WeakReference(r10);
        h(r10);
    }

    public void n(View r10, boolean r11) {
        View r12 = this.f11506c.get();
        if (r12 != null) goto L6;
        return;
    L6:
        if (this.f11509i == false) goto L10;
        if (r11 == true) goto L10;
        float r13 = this.f11515o;
    L11:
        if (r10 != r12) goto L13;
    L15:
        r12.setAlpha(r13);
        return;
    L13:
        if (r12.isEnabled() == r11) goto L15;
        r12.setEnabled(r11);
    L10:
        r13 = this.f11512l;
        goto L11
    }

    @Override // o9.a
    public void onPressedChanged(View r10, boolean r11) {
        if (this.f11506c.get() != null) goto L5;
        return;
    L5:
        this.f11522v.cancel();
        this.f11523w.cancel();
        if (this.f11507g == true) goto L8;
        return;
    L8:
        if (this.f11508h == true) goto L17;
        if (r11 == false) goto L13;
        g();
        ObjectAnimator r12 = this.f11522v;
    L11:
        r12.start();
        return;
    L13:
        if (this.f11511k == false) goto L15;
        q();
        return;
    L15:
        r12 = this.f11523w;
        goto L11
    }

    @Override // o9.a
    public void onSelectedChanged(View r10, boolean r11) {
        if (this.f11510j == false) goto L6;
        g();
        return;
    }

    public void p(boolean r10, boolean r11) {
        this.f11507g = r10;
        View r12 = this.f11506c.get();
        if (r12 == null) goto L7;
        if (r11 == false) goto L8;
        onPressedChanged(r12, r12.isPressed());
        return;
    L8:
        return;
    }

    @Override // o9.a
    public void refreshColors(String r10) {
        View r11 = this.f11506c.get();
        if (r11 != null) goto L6;
        ea.b.b("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        h(r11);
    }

    @Override // o9.a
    public void resetAlphaAnim() {
        this.f11508h = false;
        if (this.f11507g == false) goto L5;
        q();
    L5:
        da.f.g(this.f11506c.get(), f.f11505c);
    }

    @Override // o9.a
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f11509i = r10;
        View r11 = this.f11506c.get();
        if (r11 == null) goto L6;
        n(r11, r11.isEnabled());
        return;
    }

    @Override // o9.a
    public void setChangeAlphaWhenPress(boolean r10) {
        p(r10, false);
    }

    @Override // o9.a
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f11510j = r10;
    }

    @Override // o9.a
    public void setKeepPressAlpha(final boolean r10) {
        ea.b.i("OUIAlphaHelper", "setKeepPressAlpha, " + r10 + ", target: " + this.f11506c.get());
        if (this.f11508h == r10) goto L7;
        this.f11508h = r10;
        if (r10 == true) goto L7;
        onPressedChanged(this.f11506c.get(), false);
    L7:
        da.f.g(this.f11506c.get(), new e(r10));
    }

    @Override // o9.a
    public void setOverridePressColor(int r10) {
        this.f11514n = r10;
    }
}
