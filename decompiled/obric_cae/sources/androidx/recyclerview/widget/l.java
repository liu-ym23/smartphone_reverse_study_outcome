package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import j0.h0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l extends RecyclerView.n implements RecyclerView.s {
    public static final int[] C = null;
    public static final int[] D = null;
    public int A;
    public final a B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f2492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f2493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f2496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f2497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f2499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2503n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2504o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2505p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2506q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2507r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f2508s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2509t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2510u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2511v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2512w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f2513x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f2514y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f2515z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f2516a;

        public a(l r8) {
            this.f2516a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l r8 = this.f2516a;
            int r10 = r8.A;
            ValueAnimator r11 = r8.f2515z;
            if (r10 == 1) goto L6;
            if (r10 != 2) goto L9;
        L7:
            r8.A = 3;
            r11.setFloatValues(new float[]{((Float) r11.getAnimatedValue()).floatValue(), 0.0f});
            r11.setDuration(500);
            r11.start();
            return;
        L9:
            return;
        L6:
            r11.cancel();
            goto L7
        }
    }

    public class b extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f2517a;

        public b(l r8) {
            this.f2517a = r8;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public final void b(RecyclerView r8, int r10, int r11) {
            int r12 = r8.computeHorizontalScrollOffset();
            int r13 = r8.computeVerticalScrollOffset();
            l r14 = this.f2517a;
            int r15 = r14.f2508s.computeVerticalScrollRange();
            int r16 = r14.f2507r;
            int r17 = r15 - r16;
            int r18 = r14.f2490a;
            if (r17 <= 0) goto L6;
            if (r16 < r18) goto L6;
            boolean r19 = true;
        L7:
            r14.f2509t = r19;
            int r20 = r14.f2508s.computeHorizontalScrollRange();
            int r21 = r14.f2506q;
            if ((r20 - r21) <= 0) goto L11;
            if (r21 < r18) goto L11;
            boolean r22 = true;
        L12:
            r14.f2510u = r22;
            boolean r23 = r14.f2509t;
            if (r23 == true) goto L19;
            if (r22 == true) goto L19;
            if (r14.f2511v == 0) goto L29;
            r14.i(0);
            return;
        L29:
            return;
        L19:
            if (r23 == false) goto L22;
            float r24 = r16;
            r14.f2501l = (int) ((((r24 / 2.0f) + r13) * r24) / r15);
            r14.f2500k = Math.min(r16, (r16 * r16) / r15);
        L22:
            if (r14.f2510u == false) goto L24;
            float r25 = r12;
            float r26 = r21;
            r14.f2504o = (int) ((((r26 / 2.0f) + r25) * r26) / r20);
            r14.f2503n = Math.min(r21, (r21 * r21) / r20);
        L24:
            int r27 = r14.f2511v;
            if (r27 == 0) goto L27;
            if (r27 == 1) goto L27;
            return;
        L27:
            r14.i(1);
            return;
        L11:
            r22 = false;
        L6:
            r19 = false;
            goto L7
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f2519b;

        public c(l r8) {
            this.f2519b = r8;
            this.f2518a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r8) {
            this.f2518a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            if (this.f2518a == false) goto L6;
            this.f2518a = false;
            return;
        L6:
            l r10 = this.f2519b;
            if (((Float) r10.f2515z.getAnimatedValue()).floatValue() != 0.0f) goto L9;
            r10.A = 0;
            r10.i(0);
            return;
        L9:
            r10.A = 2;
            r10.f2508s.invalidate();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f2520a;

        public d(l r8) {
            this.f2520a = r8;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r8) {
            int r10 = (int) (((Float) r8.getAnimatedValue()).floatValue() * 255.0f);
            l r11 = this.f2520a;
            r11.f2492c.setAlpha(r10);
            r11.f2493d.setAlpha(r10);
            r11.f2508s.invalidate();
        }
    }

    static {
        C = new int[]{R.attr.state_pressed};
        D = new int[0];
    }

    public l(RecyclerView r8, StateListDrawable r10, Drawable r11, StateListDrawable r12, Drawable r13, int r14, int r15, int r16) {
        this.f2506q = 0;
        this.f2507r = 0;
        this.f2509t = false;
        this.f2510u = false;
        this.f2511v = 0;
        this.f2512w = 0;
        this.f2513x = new int[2];
        this.f2514y = new int[2];
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f2515z = r17;
        this.A = 0;
        a r18 = new a(this);
        this.B = r18;
        b r19 = new b(this);
        this.f2492c = r10;
        this.f2493d = r11;
        this.f2496g = r12;
        this.f2497h = r13;
        this.f2494e = Math.max(r14, r10.getIntrinsicWidth());
        this.f2495f = Math.max(r14, r11.getIntrinsicWidth());
        this.f2498i = Math.max(r14, r12.getIntrinsicWidth());
        this.f2499j = Math.max(r14, r13.getIntrinsicWidth());
        this.f2490a = r15;
        this.f2491b = r16;
        r10.setAlpha(255);
        r11.setAlpha(255);
        r17.addListener(new c(this));
        r17.addUpdateListener(new d(this));
        RecyclerView r20 = this.f2508s;
        if (r20 == r8) goto L12;
        if (r20 == null) goto L7;
        r20.removeItemDecoration(this);
        this.f2508s.removeOnItemTouchListener(this);
        this.f2508s.removeOnScrollListener(r19);
        this.f2508s.removeCallbacks(r18);
    L7:
        this.f2508s = r8;
        if (r8 == null) goto L11;
        r8.addItemDecoration(this);
        this.f2508s.addOnItemTouchListener(this);
        this.f2508s.addOnScrollListener(r19);
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public final void a(MotionEvent r13) {
        if (this.f2511v != 0) goto L6;
        return;
    L6:
        if (r13.getAction() != 0) goto L16;
        boolean r8 = g(r13.getX(), r13.getY());
        boolean r10 = f(r13.getX(), r13.getY());
        if (r8 == true) goto L10;
        if (r10 == true) goto L10;
        return;
    L10:
        if (r10 == false) goto L12;
        this.f2512w = 1;
        this.f2505p = (int) r13.getX();
    L14:
        i(2);
        return;
    L12:
        if (r8 == false) goto L14;
        this.f2512w = 2;
        this.f2502m = (int) r13.getY();
        goto L14
    L16:
        if (r13.getAction() != 1) goto L21;
        if (this.f2511v != 2) goto L21;
        this.f2502m = 0.0f;
        this.f2505p = 0.0f;
        i(1);
        this.f2512w = 0;
        return;
    L21:
        if (r13.getAction() == 2) goto L23;
        return;
    L23:
        if (this.f2511v != 2) goto L57;
        j();
        int r11 = this.f2512w;
        int r12 = this.f2491b;
        if (r11 != 1) goto L39;
        float r14 = r13.getX();
        int[] r15 = this.f2514y;
        r15[0] = r12;
        int r16 = this.f2506q - r12;
        r15[1] = r16;
        float r17 = Math.max(r12, Math.min(r16, r14));
        if (Math.abs(this.f2504o - r17) < 2.0f) goto L39;
        float r18 = this.f2505p;
        int r19 = this.f2508s.computeHorizontalScrollRange();
        int r20 = this.f2508s.computeHorizontalScrollOffset();
        int r110 = this.f2506q;
        int r111 = r15[1] - r15[0];
        if (r111 != 0) goto L32;
    L31:
        int r21 = 0;
    L35:
        if (r21 == 0) goto L37;
        this.f2508s.scrollBy(r21, 0);
    L37:
        this.f2505p = r17;
        goto L39
    L32:
        int r22 = r19 - r110;
        r21 = (int) (((r17 - r18) / r111) * r22);
        int r23 = r20 + r21;
        if (r23 >= r22) goto L31;
        if (r23 < 0) goto L31;
    L39:
        if (this.f2512w != 2) goto L58;
        float r112 = r13.getY();
        int[] r24 = this.f2513x;
        r24[0] = r12;
        int r25 = this.f2507r - r12;
        r24[1] = r25;
        float r113 = Math.max(r12, Math.min(r25, r112));
        if (Math.abs(this.f2501l - r113) < 2.0f) goto L59;
        float r26 = this.f2502m;
        int r27 = this.f2508s.computeVerticalScrollRange();
        int r28 = this.f2508s.computeVerticalScrollOffset();
        int r29 = this.f2507r;
        int r30 = r24[1] - r24[0];
        if (r30 != 0) goto L46;
    L45:
        int r31 = 0;
    L49:
        if (r31 == 0) goto L51;
        this.f2508s.scrollBy(0, r31);
    L51:
        this.f2502m = r113;
        return;
    L46:
        int r32 = r27 - r29;
        r31 = (int) (((r113 - r26) / r30) * r32);
        int r33 = r28 + r31;
        if (r33 >= r32) goto L45;
        if (r33 < 0) goto L45;
    L59:
        return;
    L58:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public final void b() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public final boolean c(MotionEvent r8) {
        int r10 = this.f2511v;
        if (r10 != 1) goto L13;
        boolean r11 = g(r8.getX(), r8.getY());
        boolean r12 = f(r8.getX(), r8.getY());
        if (r8.getAction() != 0) goto L15;
        if (r11 == true) goto L8;
        if (r12 == false) goto L15;
    L8:
        if (r12 == false) goto L10;
        this.f2512w = 1;
        this.f2505p = (int) r8.getX();
    L12:
        i(2);
        return true;
    L10:
        if (r11 == false) goto L12;
        this.f2512w = 2;
        this.f2502m = (int) r8.getY();
    L15:
        return false;
    L13:
        if (r10 != 2) goto L15;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final void e(Canvas r10, RecyclerView r11) {
        if (this.f2506q == this.f2508s.getWidth()) goto L5;
    L23:
        this.f2506q = this.f2508s.getWidth();
        this.f2507r = this.f2508s.getHeight();
        i(0);
        return;
    L5:
        if (this.f2507r != this.f2508s.getHeight()) goto L23;
        if (this.A != 0) goto L10;
        return;
    L10:
        if (this.f2509t == false) goto L20;
        int r12 = this.f2506q;
        int r8 = this.f2494e;
        int r13 = r12 - r8;
        int r14 = this.f2501l;
        int r15 = this.f2500k;
        int r16 = r14 - (r15 / 2);
        StateListDrawable r17 = this.f2492c;
        r17.setBounds(0, 0, r8, r15);
        int r18 = this.f2507r;
        int r19 = this.f2495f;
        Drawable r20 = this.f2493d;
        r20.setBounds(0, 0, r19, r18);
        RecyclerView r21 = this.f2508s;
        WeakHashMap<View, h0> r22 = j0.w.f8437a;
        boolean r23 = true;
        if (j0.w.e.d(r21) == 1) goto L15;
        r23 = false;
    L15:
        if (r23 == false) goto L17;
        r20.draw(r10);
        r10.translate(r8, r16);
        r10.scale(-1.0f, 1.0f);
        r17.draw(r10);
        r10.scale(1.0f, 1.0f);
        int r110 = -r8;
    L18:
        r10.translate(r110, -r16);
        goto L20
    L17:
        r10.translate(r13, 0.0f);
        r20.draw(r10);
        r10.translate(0.0f, r16);
        r17.draw(r10);
        r110 = -r13;
    L20:
        if (this.f2510u == false) goto L26;
        int r111 = this.f2507r;
        int r24 = this.f2498i;
        int r112 = r111 - r24;
        int r25 = this.f2504o;
        int r26 = this.f2503n;
        int r27 = r25 - (r26 / 2);
        StateListDrawable r28 = this.f2496g;
        r28.setBounds(0, 0, r26, r24);
        int r29 = this.f2506q;
        int r30 = this.f2499j;
        Drawable r31 = this.f2497h;
        r31.setBounds(0, 0, r29, r30);
        r10.translate(0.0f, r112);
        r31.draw(r10);
        r10.translate(r27, 0.0f);
        r28.draw(r10);
        r10.translate(-r27, -r112);
        return;
    }

    public final boolean f(float r8, float r10) {
        if (r10 < (this.f2507r - this.f2498i)) goto L9;
        int r11 = this.f2504o;
        int r12 = this.f2503n;
        if (r8 < (r11 - (r12 / 2))) goto L9;
        if (r8 > ((r12 / 2) + r11)) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean g(float r8, float r10) {
        RecyclerView r11 = this.f2508s;
        WeakHashMap<View, h0> r12 = j0.w.f8437a;
        if (j0.w.e.d(r11) != 1) goto L5;
        boolean r13 = true;
    L6:
        int r14 = this.f2494e;
        if (r13 == false) goto L12;
        if (r8 > (r14 / 2)) goto L19;
    L13:
        int r15 = this.f2501l;
        int r16 = this.f2500k / 2;
        if (r10 >= (r15 - r16)) goto L16;
        return false;
    L16:
        if (r10 <= (r16 + r15)) goto L18;
        return false;
    L18:
        return true;
    L19:
        return false;
    L12:
        if (r8 >= (this.f2506q - r14)) goto L13;
        return false;
    L5:
        r13 = false;
        goto L6
    }

    public final void h(int r8) {
        RecyclerView r10 = this.f2508s;
        a r11 = this.B;
        r10.removeCallbacks(r11);
        this.f2508s.postDelayed(r11, r8);
    }

    public final void i(int r8) {
        StateListDrawable r10 = this.f2492c;
        if (r8 == 2) goto L5;
    L7:
        if (r8 != 0) goto L9;
        this.f2508s.invalidate();
    L11:
        if (this.f2511v != 2) goto L15;
        if (r8 == 2) goto L15;
        r10.setState(D);
        int r11 = 1200;
    L17:
        h(r11);
    L18:
        this.f2511v = r8;
        return;
    L15:
        if (r8 != 1) goto L18;
        r11 = 1500;
        goto L17
    L9:
        j();
        goto L11
    L5:
        if (this.f2511v == 2) goto L7;
        r10.setState(C);
        this.f2508s.removeCallbacks(this.B);
        goto L7
    }

    public final void j() {
        int r8 = this.A;
        ValueAnimator r10 = this.f2515z;
        if (r8 != 0) goto L5;
    L8:
        this.A = 1;
        r10.setFloatValues(new float[]{((Float) r10.getAnimatedValue()).floatValue(), 1.0f});
        r10.setDuration(500);
        r10.setStartDelay(0);
        r10.start();
        return;
    L5:
        if (r8 != 3) goto L10;
        r10.cancel();
        goto L8
    }
}
