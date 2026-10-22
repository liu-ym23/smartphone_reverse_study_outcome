package f1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import j0.h0;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f1.h {
    public static final String[] H = null;
    public static final C0070b I = null;
    public static final c J = null;
    public static final d K = null;
    public static final e L = null;
    public static final f M = null;

    public static class a extends Property<Drawable, PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f7240a;

        public a() {
            super(PointF.class, "boundsOrigin");
            this.f7240a = new Rect();
        }

        @Override // android.util.Property
        public final PointF get(Drawable r8) {
            Rect r10 = this.f7240a;
            r8.copyBounds(r10);
            return new PointF(r10.left, r10.top);
        }

        @Override // android.util.Property
        public final void set(Drawable r8, PointF r10) {
            Drawable r11 = r8;
            PointF r12 = r10;
            Rect r13 = this.f7240a;
            r11.copyBounds(r13);
            r13.offsetTo(Math.round(r12.x), Math.round(r12.y));
            r11.setBounds(r13);
        }
    }

    /* JADX INFO: renamed from: f1.b$b, reason: collision with other inner class name */
    public static class C0070b extends Property<i, PointF> {
        public C0070b() {
            super(PointF.class, "topLeft");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(i r8) {
            return null;
        }

        @Override // android.util.Property
        public final void set(i r8, PointF r10) {
            i r11 = r8;
            PointF r12 = r10;
            r11.getClass();
            r11.f7243a = Math.round(r12.x);
            int r13 = Math.round(r12.y);
            r11.f7244b = r13;
            int r14 = r11.f7248f + 1;
            r11.f7248f = r14;
            if (r14 != r11.f7249g) goto L6;
            int r15 = r11.f7243a;
            int r16 = r11.f7245c;
            int r17 = r11.f7246d;
            o.a r18 = o.f7298a;
            r11.f7247e.setLeftTopRightBottom(r15, r13, r16, r17);
            r11.f7248f = 0;
            r11.f7249g = 0;
            return;
        }
    }

    public static class c extends Property<i, PointF> {
        public c() {
            super(PointF.class, "bottomRight");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(i r8) {
            return null;
        }

        @Override // android.util.Property
        public final void set(i r8, PointF r10) {
            i r11 = r8;
            PointF r12 = r10;
            r11.getClass();
            r11.f7245c = Math.round(r12.x);
            int r13 = Math.round(r12.y);
            r11.f7246d = r13;
            int r14 = r11.f7249g + 1;
            r11.f7249g = r14;
            if (r11.f7248f != r14) goto L6;
            int r15 = r11.f7243a;
            int r16 = r11.f7244b;
            int r17 = r11.f7245c;
            o.a r18 = o.f7298a;
            r11.f7247e.setLeftTopRightBottom(r15, r16, r17, r13);
            r11.f7248f = 0;
            r11.f7249g = 0;
            return;
        }
    }

    public static class d extends Property<View, PointF> {
        public d() {
            super(PointF.class, "bottomRight");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View r8) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View r8, PointF r10) {
            View r11 = r8;
            PointF r12 = r10;
            int r13 = r11.getLeft();
            int r14 = r11.getTop();
            int r15 = Math.round(r12.x);
            int r16 = Math.round(r12.y);
            o.a r17 = o.f7298a;
            r11.setLeftTopRightBottom(r13, r14, r15, r16);
        }
    }

    public static class e extends Property<View, PointF> {
        public e() {
            super(PointF.class, "topLeft");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View r8) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View r8, PointF r10) {
            View r11 = r8;
            PointF r12 = r10;
            int r13 = Math.round(r12.x);
            int r14 = Math.round(r12.y);
            int r15 = r11.getRight();
            int r16 = r11.getBottom();
            o.a r17 = o.f7298a;
            r11.setLeftTopRightBottom(r13, r14, r15, r16);
        }
    }

    public static class f extends Property<View, PointF> {
        public f() {
            super(PointF.class, "position");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View r8) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View r8, PointF r10) {
            View r11 = r8;
            PointF r12 = r10;
            int r13 = Math.round(r12.x);
            int r14 = Math.round(r12.y);
            int r15 = r11.getWidth() + r13;
            int r16 = r11.getHeight() + r14;
            o.a r17 = o.f7298a;
            r11.setLeftTopRightBottom(r13, r14, r15, r16);
        }
    }

    public class g extends AnimatorListenerAdapter {
        private i mViewBounds;

        public g(i r8) {
            this.mViewBounds = r8;
        }
    }

    public class h extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f7242b;

        public h(ViewGroup r8) {
            this.f7242b = r8;
            this.f7241a = false;
        }

        @Override // f1.k, f1.h.d
        public final void a() {
            this.f7242b.suppressLayout(false);
        }

        @Override // f1.k, f1.h.d
        public final void b() {
            this.f7242b.suppressLayout(false);
            this.f7241a = true;
        }

        @Override // f1.k, f1.h.d
        public final void c() {
            this.f7242b.suppressLayout(true);
        }

        @Override // f1.h.d
        public final void d(f1.h r8) {
            if (this.f7241a == true) goto L5;
            this.f7242b.suppressLayout(false);
        L5:
            r8.v(this);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f7247e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7248f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7249g;

        public i(View r8) {
            this.f7247e = r8;
        }
    }

    static {
        H = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
        new a();
        I = new C0070b();
        J = new c();
        K = new d();
        L = new e();
        M = new f();
    }

    public final void H(n r8) {
        WeakHashMap<View, h0> r10 = j0.w.f8437a;
        View r11 = r8.f7296b;
        if (j0.w.g.c(r11) == false) goto L5;
    L8:
        HashMap r12 = r8.f7295a;
        r12.put("android:changeBounds:bounds", new Rect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom()));
        r12.put("android:changeBounds:parent", r11.getParent());
        return;
    L5:
        if (r11.getWidth() != 0) goto L8;
        if (r11.getHeight() != 0) goto L8;
    }

    @Override // f1.h
    public final void d(n r8) {
        H(r8);
    }

    @Override // f1.h
    public final void g(n r8) {
        H(r8);
    }

    @Override // f1.h
    public final Animator k(ViewGroup r19, n r20, n r21) {
        if (r20 == null) goto L50;
        if (r21 == null) goto L53;
        HashMap r8 = r20.f7295a;
        HashMap r10 = r21.f7295a;
        ViewGroup r11 = (ViewGroup) r8.get("android:changeBounds:parent");
        ViewGroup r12 = (ViewGroup) r10.get("android:changeBounds:parent");
        if (r11 == null) goto L48;
        if (r12 == null) goto L52;
        Rect r13 = (Rect) r8.get("android:changeBounds:bounds");
        Rect r14 = (Rect) r10.get("android:changeBounds:bounds");
        int r15 = r13.left;
        int r16 = r14.left;
        int r17 = r13.top;
        int r18 = r14.top;
        int r110 = r13.right;
        int r111 = r14.right;
        int r22 = r13.bottom;
        int r23 = r14.bottom;
        int r112 = r110 - r15;
        int r113 = r22 - r17;
        int r114 = r111 - r16;
        int r24 = r23 - r18;
        Rect r25 = (Rect) r8.get("android:changeBounds:clip");
        Rect r26 = (Rect) r10.get("android:changeBounds:clip");
        int r115 = 0;
        if (r112 == 0) goto L13;
        if (r113 == 0) goto L13;
    L15:
        if (r15 != r16) goto L17;
        if (r17 != r18) goto L17;
    L18:
        if (r110 != r111) goto L20;
        if (r22 != r23) goto L20;
    L21:
        if (r25 != null) goto L23;
    L24:
        if (r25 != null) goto L27;
        if (r26 == null) goto L27;
    L26:
        r115 = r115 + 1;
    L27:
        int r27 = r115;
        if (r27 <= 0) goto L46;
        o.a r28 = o.f7298a;
        View r29 = r21.f7296b;
        r29.setLeftTopRightBottom(r15, r17, r110, r22);
        if (r27 != 2) goto L35;
        if (r112 != r114) goto L34;
        if (r113 != r24) goto L34;
        b r30 = this;
        Path r31 = r30.D.j(r15, r17, r16, r18);
        Property r32 = M;
    L41:
        Animator r33 = ObjectAnimator.ofObject(r29, r32, null, r31);
    L43:
        if ((r29.getParent() instanceof ViewGroup) == false) goto L45;
        ViewGroup r34 = (ViewGroup) r29.getParent();
        r34.suppressLayout(true);
        r30.a(new h(r34));
    L45:
        return r33;
    L34:
        r30 = this;
        i r35 = new i(r29);
        ObjectAnimator r36 = ObjectAnimator.ofObject(r35, I, null, r30.D.j(r15, r17, r16, r18));
        ObjectAnimator r37 = ObjectAnimator.ofObject(r35, J, null, r30.D.j(r110, r22, r111, r23));
        AnimatorSet r38 = new AnimatorSet();
        r38.playTogether(new Animator[]{r36, r37});
        r38.addListener(new g(r35));
        r33 = r38;
        goto L43
    L35:
        r30 = this;
        if (r15 != r16) goto L40;
        if (r17 != r18) goto L40;
        r31 = r30.D.j(r110, r22, r111, r23);
        r32 = K;
    L40:
        r31 = r30.D.j(r15, r17, r16, r18);
        r32 = L;
        goto L41
    L46:
        return null;
    L23:
        if (r25.equals(r26) == false) goto L26;
    L20:
        r115 = r115 + 1;
    L17:
        r115 = 1;
    L13:
        if (r114 == 0) goto L21;
        if (r24 == 0) goto L21;
    L52:
        return null;
    L48:
        return null;
    L53:
        return null;
    L50:
        return null;
    }

    @Override // f1.h
    public final String[] p() {
        return H;
    }
}
