package f1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import com.obric.cae.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends h {
    public static final String[] I = null;
    public int H;

    public static class a extends AnimatorListenerAdapter implements h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f7303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7304b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final ViewGroup f7305m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f7306n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7307o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f7308p;

        public a(View r8, int r10) {
            this.f7308p = false;
            this.f7303a = r8;
            this.f7304b = r10;
            this.f7305m = (ViewGroup) r8.getParent();
            this.f7306n = true;
            f(true);
        }

        @Override // f1.h.d
        public final void a() {
            f(false);
        }

        @Override // f1.h.d
        public final void b() {
        }

        @Override // f1.h.d
        public final void c() {
            f(true);
        }

        @Override // f1.h.d
        public final void d(h r8) {
            if (this.f7308p == true) goto L7;
            o.a r10 = o.f7298a;
            this.f7303a.setTransitionVisibility(this.f7304b);
            ViewGroup r11 = this.f7305m;
            if (r11 == null) goto L7;
            r11.invalidate();
        L7:
            f(false);
            r8.v(this);
        }

        @Override // f1.h.d
        public final void e() {
        }

        public final void f(boolean r8) {
            if (this.f7306n == true) goto L5;
            return;
        L5:
            if (this.f7307o == r8) goto L11;
            ViewGroup r10 = this.f7305m;
            if (r10 == null) goto L12;
            this.f7307o = r8;
            r10.suppressLayout(r8);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r8) {
            this.f7308p = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            if (this.f7308p == true) goto L7;
            o.a r10 = o.f7298a;
            this.f7303a.setTransitionVisibility(this.f7304b);
            ViewGroup r11 = this.f7305m;
            if (r11 == null) goto L7;
            r11.invalidate();
        L7:
            f(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator r8) {
            if (this.f7308p == true) goto L6;
            o.a r10 = o.f7298a;
            this.f7303a.setTransitionVisibility(this.f7304b);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r8) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator r8) {
            if (this.f7308p == true) goto L6;
            o.a r10 = o.f7298a;
            this.f7303a.setTransitionVisibility(0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r8) {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f7313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f7314f;
    }

    static {
        I = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    }

    public v() {
        this.H = 3;
    }

    public static b I(n r8, n r10) {
        b r11 = new b();
        r11.f7309a = false;
        r11.f7310b = false;
        if (r8 == null) goto L7;
        HashMap r12 = r8.f7295a;
        if (r12.containsKey("android:visibility:visibility") == false) goto L7;
        r11.f7311c = ((Integer) r12.get("android:visibility:visibility")).intValue();
        r11.f7313e = (ViewGroup) r12.get("android:visibility:parent");
    L8:
        if (r10 == null) goto L12;
        HashMap r13 = r10.f7295a;
        if (r13.containsKey("android:visibility:visibility") == false) goto L12;
        r11.f7312d = ((Integer) r13.get("android:visibility:visibility")).intValue();
        r11.f7314f = (ViewGroup) r13.get("android:visibility:parent");
    L14:
        if (r8 == null) goto L32;
        if (r10 == null) goto L32;
        int r14 = r11.f7311c;
        int r15 = r11.f7312d;
        if (r14 == r15) goto L19;
    L21:
        if (r14 == r15) goto L27;
        if (r14 == 0) goto L39;
        if (r15 == 0) goto L35;
    L41:
        return r11;
    L35:
        r11.f7310b = true;
    L40:
        r11.f7309a = true;
    L39:
        r11.f7310b = false;
        goto L40
    L27:
        if (r11.f7314f == null) goto L39;
        if (r11.f7313e != null) goto L41;
    L19:
        if (r11.f7313e != r11.f7314f) goto L21;
        return r11;
    L32:
        if (r8 == null) goto L34;
    L36:
        if (r10 != null) goto L41;
        if (r11.f7311c != 0) goto L41;
    L34:
        if (r11.f7312d != 0) goto L36;
    L12:
        r11.f7312d = -1;
        r11.f7314f = null;
    L7:
        r11.f7311c = -1;
        r11.f7313e = null;
        goto L8
    }

    public final void H(n r8) {
        View r10 = r8.f7296b;
        int r11 = r10.getVisibility();
        HashMap r12 = r8.f7295a;
        r12.put("android:visibility:visibility", Integer.valueOf(r11));
        r12.put("android:visibility:parent", r10.getParent());
        int[] r13 = new int[2];
        r10.getLocationOnScreen(r13);
        r12.put("android:visibility:screenLocation", r13);
    }

    @Override // f1.h
    public final void d(n r8) {
        H(r8);
    }

    @Override // f1.h
    public final Animator k(ViewGroup r21, n r22, n r23) {
        b r8 = I(r22, r23);
        if (r8.f7309a == true) goto L5;
        return null;
    L5:
        if (r8.f7313e == null) goto L7;
    L8:
        boolean r10 = true;
        float r11 = 0.0f;
        if (r8.f7310b == true) goto L11;
        int r12 = r8.f7312d;
        if ((this.H & 2) != 2) goto L111;
        if (r22 == null) goto L111;
        if (r23 == null) goto L39;
        View r13 = r23.f7296b;
    L40:
        View r14 = r22.f7296b;
        View r15 = (View) r14.getTag(R.id.save_overlay_view);
        if (r15 == null) goto L43;
        n r16 = r22;
        int r18 = r12;
        Object r19 = "android:fade:transitionAlpha";
        float r17 = 1.0f;
        r13 = null;
    L87:
        HashMap r20 = r16.f7295a;
        if (r15 == null) goto L100;
        if (r10 == true) goto L91;
        int[] r24 = (int[]) r20.get("android:visibility:screenLocation");
        int r25 = r24[0];
        int r26 = r24[1];
        int[] r27 = new int[2];
        r21.getLocationOnScreen(r27);
        r15.offsetLeftAndRight((r25 - r27[0]) - r15.getLeft());
        r15.offsetTopAndBottom((r26 - r27[1]) - r15.getTop());
        ((ViewGroupOverlay) new androidx.lifecycle.s(r21).f2194b).add(r15);
    L91:
        v r28 = this;
        d r29 = (d) r28;
        o.a r30 = o.f7298a;
        Float r31 = (Float) r20.get(r19);
        if (r31 == null) goto L94;
        float r110 = r31.floatValue();
    L95:
        ObjectAnimator r32 = r29.J(r15, r110, 0.0f);
        if (r10 == true) goto L116;
        if (r32 != null) goto L99;
        ((ViewGroupOverlay) new androidx.lifecycle.s(r21).f2194b).remove(r15);
        return r32;
    L99:
        r14.setTag(R.id.save_overlay_view, r15);
        h.d r33 = new u(r28, r21, r15, r14);
        h r34 = r28;
        ObjectAnimator r35 = r32;
    L109:
        r34.a(r33);
        return r35;
    L116:
        return r32;
    L94:
        r110 = r17;
        goto L95
    L100:
        v r36 = this;
        Object r37 = r19;
        if (r13 == null) goto L111;
        int r38 = r13.getVisibility();
        o.a r39 = o.f7298a;
        r13.setTransitionVisibility(0);
        d r40 = (d) r36;
        Float r41 = (Float) r20.get(r37);
        if (r41 == null) goto L105;
        float r111 = r41.floatValue();
    L106:
        ObjectAnimator r42 = r40.J(r13, r111, 0.0f);
        if (r42 == null) goto L110;
        a r43 = new a(r13, r18);
        r42.addListener(r43);
        r42.addPauseListener(r43);
        r33 = r43;
        r34 = r36;
        r35 = r42;
        goto L109
    L110:
        r13.setTransitionVisibility(r38);
        return r42;
    L105:
        r111 = r17;
        goto L106
    L43:
        if (r13 != null) goto L45;
    L52:
        if (r13 == null) goto L55;
        r15 = r13;
        r13 = null;
    L54:
        boolean r112 = false;
    L56:
        if (r112 == true) goto L58;
    L85:
        r13 = r13;
        r18 = r12;
        r19 = "android:fade:transitionAlpha";
    L86:
        r16 = r22;
        r13 = r13;
        r17 = 1.0f;
        r10 = false;
        goto L87
    L58:
        if (r14.getParent() != null) goto L61;
        r16 = r22;
        r18 = r12;
        r15 = r14;
        r19 = "android:fade:transitionAlpha";
        r17 = 1.0f;
        r10 = false;
        goto L87
    L61:
        if ((r14.getParent() instanceof View) == false) goto L85;
        View r113 = (View) r14.getParent();
        if (I(q(r113, true), n(r113, true)).f7309a == true) goto L80;
        Matrix r44 = new Matrix();
        r44.setTranslate(-r113.getScrollX(), -r113.getScrollY());
        o.a r114 = o.f7298a;
        r14.transformMatrixToGlobal(r44);
        r21.transformMatrixToLocal(r44);
        RectF r115 = new RectF(0.0f, 0.0f, r14.getWidth(), r14.getHeight());
        r44.mapRect(r115);
        int r116 = Math.round(r115.left);
        int r117 = Math.round(r115.top);
        int r45 = Math.round(r115.right);
        int r118 = Math.round(r115.bottom);
        ImageView r119 = new ImageView(r14.getContext());
        r119.setScaleType(ImageView.ScaleType.CENTER_CROP);
        boolean r120 = !r14.isAttachedToWindow();
        boolean r121 = r21.isAttachedToWindow();
        if (r120 == false) goto L69;
        if (r121 == true) goto L68;
        r13 = r13;
        r18 = r12;
        r19 = "android:fade:transitionAlpha";
        Bitmap r46 = null;
    L77:
        if (r46 == null) goto L79;
        r119.setImageBitmap(r46);
    L79:
        r119.measure(View.MeasureSpec.makeMeasureSpec(r45 - r116, 1073741824), View.MeasureSpec.makeMeasureSpec(r118 - r117, 1073741824));
        r119.layout(r116, r117, r45, r118);
        r15 = r119;
        goto L86
    L68:
        ViewGroup r47 = (ViewGroup) r14.getParent();
        int r122 = r47.indexOfChild(r14);
        r21.getOverlay().add(r14);
        int r48 = r122;
    L70:
        r18 = r12;
        int r49 = Math.round(r115.width());
        r19 = "android:fade:transitionAlpha";
        int r50 = Math.round(r115.height());
        if (r49 <= 0) goto L74;
        if (r50 <= 0) goto L74;
        float r51 = Math.min(1.0f, 1048576.0f / (r49 * r50));
        int r52 = Math.round(r49 * r51);
        int r53 = Math.round(r50 * r51);
        r44.postTranslate(-r115.left, -r115.top);
        r44.postScale(r51, r51);
        Picture r54 = new Picture();
        Canvas r55 = r54.beginRecording(r52, r53);
        r55.concat(r44);
        r14.draw(r55);
        r54.endRecording();
        r46 = Bitmap.createBitmap(r54);
    L75:
        if (r120 == false) goto L77;
        r21.getOverlay().remove(r14);
        r47.addView(r14, r48);
    L74:
        r46 = null;
        goto L75
    L69:
        r48 = 0;
        r47 = null;
        goto L70
    L80:
        r13 = r13;
        r18 = r12;
        r19 = "android:fade:transitionAlpha";
        int r56 = r113.getId();
        if (r113.getParent() != null) goto L86;
        if (r56 == (-1)) goto L86;
        r21.findViewById(r56);
    L55:
        r112 = true;
        r13 = null;
        r15 = null;
        goto L56
    L45:
        if (r13.getParent() == null) goto L52;
        if (r12 == 4) goto L51;
        if (r14 != r13) goto L55;
    L51:
        r15 = null;
        goto L54
    L39:
        r13 = null;
    L111:
        return null;
    L11:
        if ((this.H & 1) != 1) goto L30;
        if (r23 == null) goto L30;
        View r57 = r23.f7296b;
        if (r22 != null) goto L19;
        View r58 = (View) r57.getParent();
        if (I(n(r58, false), q(r58, false)).f7309a == true) goto L30;
    L19:
        d r59 = (d) this;
        if (r22 == null) goto L24;
        Float r60 = (Float) r22.f7295a.get("android:fade:transitionAlpha");
        if (r60 == null) goto L24;
        float r61 = r60.floatValue();
    L26:
        if (r61 == 1.0f) goto L115;
        r11 = r61;
    L115:
        return r59.J(r57, r11, 1.0f);
    L24:
        r61 = 0.0f;
    L30:
        return null;
    L7:
        if (r8.f7314f != null) goto L8;
        return null;
    }

    @Override // f1.h
    public final String[] p() {
        return I;
    }

    @Override // f1.h
    public final boolean r(n r8, n r10) {
        if (r8 != null) goto L6;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r8 == null) goto L11;
        if (r10 == null) goto L11;
        if (r10.f7295a.containsKey("android:visibility:visibility") == r8.f7295a.containsKey("android:visibility:visibility")) goto L11;
        return false;
    L11:
        b r11 = I(r8, r10);
        if (r11.f7309a == true) goto L14;
        return false;
    L14:
        if (r11.f7311c != 0) goto L16;
    L17:
        return true;
    L16:
        if (r11.f7312d == 0) goto L17;
        return false;
    }
}
