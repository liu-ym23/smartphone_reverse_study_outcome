package o0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import j0.h0;
import j0.w;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f9587v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f9591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f9592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f9593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f9594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f9595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f9596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f9597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f9599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f9600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f9601n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f9602o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OverScroller f9603p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AbstractC0128c f9604q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f9605r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9606s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f9607t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f9608u;

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r8) {
            float r10 = r8 - 1.0f;
            return ((((r10 * r10) * r10) * r10) * r10) + 1.0f;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f9609a;

        public b(c r8) {
            this.f9609a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f9609a.p(0);
        }
    }

    /* JADX INFO: renamed from: o0.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0128c {
        public AbstractC0128c() {
        }

        public abstract int a(View r8, int r10);

        public abstract int b(View r8, int r10, int r11);

        public int c(View r8) {
            return 0;
        }

        public int d() {
            return 0;
        }

        public void e(View r8, int r10) {
        }

        public void f(int r8) {
        }

        public void g(View r8, int r10, int r11, int r12, int r13) {
        }

        public abstract void h(View r8, float r10, float r11);

        public abstract boolean i(View r8, int r10);
    }

    static {
        f9587v = new a();
    }

    public c(Context r8, ViewGroup r10, AbstractC0128c r11) {
        this.f9590c = -1;
        this.f9608u = new b(this);
        if (r10 == null) goto L10;
        if (r11 == null) goto L8;
        this.f9607t = r10;
        this.f9604q = r11;
        ViewConfiguration r12 = ViewConfiguration.get(r8);
        this.f9602o = (int) ((r8.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f9589b = r12.getScaledTouchSlop();
        this.f9600m = r12.getScaledMaximumFlingVelocity();
        this.f9601n = r12.getScaledMinimumFlingVelocity();
        this.f9603p = new OverScroller(r8, f9587v);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final void a() {
        this.f9590c = -1;
        float[] r8 = this.f9591d;
        if (r8 == null) goto L6;
        Arrays.fill(r8, 0.0f);
        Arrays.fill(this.f9592e, 0.0f);
        Arrays.fill(this.f9593f, 0.0f);
        Arrays.fill(this.f9594g, 0.0f);
        Arrays.fill(this.f9595h, 0);
        Arrays.fill(this.f9596i, 0);
        Arrays.fill(this.f9597j, 0);
        this.f9598k = 0;
    L6:
        VelocityTracker r10 = this.f9599l;
        if (r10 == null) goto L10;
        r10.recycle();
        this.f9599l = null;
        return;
    }

    public final void b(View r8, int r10) {
        ViewParent r11 = r8.getParent();
        ViewGroup r12 = this.f9607t;
        if (r11 != r12) goto L7;
        this.f9605r = r8;
        this.f9590c = r10;
        this.f9604q.e(r8, r10);
        p(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + r12 + ")");
    }

    public final boolean c(float r8, float r10, int r11, int r12) {
        float r13 = Math.abs(r8);
        float r14 = Math.abs(r10);
        if ((this.f9595h[r11] & r12) == r12) goto L5;
        return false;
    L5:
        if ((0 & r12) != 0) goto L7;
        return false;
    L7:
        if ((this.f9597j[r11] & r12) != r12) goto L9;
        return false;
    L9:
        if ((this.f9596i[r11] & r12) == r12) goto L27;
        int r15 = this.f9589b;
        if (r13 > r15) goto L16;
        if (r14 > r15) goto L16;
        return false;
    L16:
        if (r13 >= (r14 * 0.5f)) goto L19;
        this.f9604q.getClass();
    L19:
        if ((this.f9596i[r11] & r12) == 0) goto L21;
        return false;
    L21:
        if (r13 <= this.f9589b) goto L29;
        return true;
    L29:
        return false;
    L27:
        return false;
    }

    public final boolean d(View r8, float r10, float r11) {
        if (r8 != null) goto L5;
        return false;
    L5:
        AbstractC0128c r12 = this.f9604q;
        if (r12.c(r8) <= 0) goto L8;
        boolean r13 = true;
    L10:
        if (r12.d() <= 0) goto L12;
        boolean r14 = true;
    L13:
        if (r13 == false) goto L19;
        if (r14 == false) goto L19;
        float r15 = (r11 * r11) + (r10 * r10);
        int r16 = this.f9589b;
        if (r15 > (r16 * r16)) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (r13 == true) goto L21;
        if (r14 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r11) > this.f9589b) goto L28;
        return false;
    L28:
        return true;
    L21:
        if (Math.abs(r10) > this.f9589b) goto L23;
        return false;
    L23:
        return true;
    L12:
        r14 = false;
        goto L13
    L8:
        r13 = false;
        goto L10
    }

    public final void e(int r8) {
        float[] r10 = this.f9591d;
        if (r10 == null) goto L12;
        int r11 = this.f9598k;
        boolean r12 = true;
        int r13 = 1 << r8;
        if ((r11 & r13) != 0) goto L8;
        r12 = false;
    L8:
        if (r12 == false) goto L13;
        r10[r8] = 0.0f;
        this.f9592e[r8] = 0.0f;
        this.f9593f[r8] = 0.0f;
        this.f9594g[r8] = 0.0f;
        this.f9595h[r8] = 0;
        this.f9596i[r8] = 0;
        this.f9597j[r8] = 0;
        this.f9598k = (~r13) & r11;
        return;
    L13:
        return;
    }

    public final int f(int r8, int r10, int r11) {
        if (r8 != 0) goto L5;
        return 0;
    L5:
        int r12 = this.f9607t.getWidth();
        float r13 = r12 / 2;
        float r14 = (((float) Math.sin((Math.min(1.0f, Math.abs(r8) / r12) - 0.5f) * 0.47123894f)) * r13) + r13;
        int r15 = Math.abs(r10);
        if (r15 <= 0) goto L8;
        int r16 = Math.round(Math.abs(r14 / r15) * 1000.0f) * 4;
    L10:
        return Math.min(r16, 600);
    L8:
        r16 = (int) (((Math.abs(r8) / r11) + 1.0f) * 256.0f);
        goto L10
    }

    public final boolean g() {
        if (this.f9588a != 2) goto L21;
        OverScroller r8 = this.f9603p;
        boolean r10 = r8.computeScrollOffset();
        int r11 = r8.getCurrX();
        int r12 = r8.getCurrY();
        int r13 = r11 - this.f9605r.getLeft();
        int r14 = r12 - this.f9605r.getTop();
        if (r13 == 0) goto L7;
        View r15 = this.f9605r;
        WeakHashMap<View, h0> r16 = w.f8437a;
        r15.offsetLeftAndRight(r13);
    L7:
        if (r14 == 0) goto L9;
        View r17 = this.f9605r;
        WeakHashMap<View, h0> r18 = w.f8437a;
        r17.offsetTopAndBottom(r14);
    L9:
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
    L12:
        if (r10 == true) goto L14;
    L18:
        if (r10 == true) goto L21;
        this.f9607t.post(this.f9608u);
        goto L21
    L14:
        if (r11 != r8.getFinalX()) goto L18;
        if (r12 != r8.getFinalY()) goto L18;
        r8.abortAnimation();
        r10 = false;
    L11:
        this.f9604q.g(this.f9605r, r11, r12, r13, r14);
    L21:
        if (this.f9588a != 2) goto L24;
        return true;
    L24:
        return false;
    }

    public final View h(int r8, int r10) {
        ViewGroup r11 = this.f9607t;
        int r12 = r11.getChildCount() - 1;
    L3:
        if (r12 < 0) goto L14;
        this.f9604q.getClass();
        View r13 = r11.getChildAt(r12);
        if (r8 < r13.getLeft()) goto L13;
        if (r8 >= r13.getRight()) goto L13;
        if (r10 < r13.getTop()) goto L13;
        if (r10 >= r13.getBottom()) goto L13;
        return r13;
    L13:
        r12 = r12 - 1;
        goto L3
    L14:
        return null;
    }

    public final boolean i(int r11, int r12, int r13, int r14) {
        int r8 = this.f9605r.getLeft();
        int r10 = this.f9605r.getTop();
        int r15 = r11 - r8;
        int r16 = r12 - r10;
        OverScroller r17 = this.f9603p;
        int r18 = 0;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        r17.abortAnimation();
        p(0);
        return false;
    L7:
        View r19 = this.f9605r;
        int r20 = (int) this.f9601n;
        int r21 = (int) this.f9600m;
        int r22 = Math.abs(r13);
        if (r22 >= r20) goto L10;
        r13 = 0;
    L14:
        int r23 = Math.abs(r14);
        if (r23 < r20) goto L21;
        if (r23 <= r21) goto L22;
        if (r14 <= 0) goto L20;
        r14 = r21;
        goto L22
    L20:
        r18 = -r21;
    L22:
        int r110 = Math.abs(r15);
        int r24 = Math.abs(r16);
        int r25 = Math.abs(r13);
        int r26 = Math.abs(r14);
        int r27 = r25 + r26;
        int r28 = r110 + r24;
        if (r13 == 0) goto L25;
        float r111 = r25;
        float r29 = r27;
    L26:
        float r112 = r111 / r29;
        if (r14 == 0) goto L29;
        float r30 = r26;
        float r31 = r27;
    L30:
        float r32 = r30 / r31;
        AbstractC0128c r33 = this.f9604q;
        r17.startScroll(r8, r10, r15, r16, (int) ((f(r16, r14, r33.d()) * r32) + (f(r15, r13, r33.c(r19)) * r112)));
        p(2);
        return true;
    L29:
        r30 = r24;
        r31 = r28;
        goto L30
    L25:
        r111 = r110;
        r29 = r28;
    L21:
        r14 = r18;
        goto L22
    L10:
        if (r22 <= r21) goto L14;
        if (r13 <= 0) goto L13;
        r13 = r21;
        goto L14
    L13:
        r13 = -r21;
        goto L14
    }

    public final boolean j(int r8) {
        if ((this.f9598k & (1 << r8)) == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L9;
        Log.e("ViewDragHelper", "Ignoring pointerId=" + r8 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    L9:
        return true;
    L5:
        r10 = false;
        goto L6
    }

    public final void k(MotionEvent r19) {
        int r8 = r19.getActionMasked();
        int r10 = r19.getActionIndex();
        if (r8 != 0) goto L6;
        a();
    L6:
        if (this.f9599l != null) goto L8;
        this.f9599l = VelocityTracker.obtain();
    L8:
        this.f9599l.addMovement(r19);
        int r11 = 0;
        AbstractC0128c r12 = this.f9604q;
        if (r8 != 0) goto L11;
        float r13 = r19.getX();
        float r14 = r19.getY();
        int r15 = r19.getPointerId(0);
        View r16 = h((int) r13, (int) r14);
        n(r13, r14, r15);
        t(r16, r15);
        if ((this.f9595h[r15] & 0) == 0) goto L120;
    L101:
        r12.getClass();
        return;
    L120:
        return;
    L11:
        if (r8 == 1) goto L96;
        if (r8 == 2) goto L66;
        if (r8 == 3) goto L61;
        if (r8 != 5) goto L19;
        int r17 = r19.getPointerId(r10);
        float r18 = r19.getX(r10);
        float r20 = r19.getY(r10);
        n(r18, r20, r17);
        if (this.f9588a != 0) goto L46;
        t(h((int) r18, (int) r20), r17);
        if ((this.f9595h[r17] & 0) != 0) goto L101;
        return;
    L46:
        int r21 = (int) r18;
        int r22 = (int) r20;
        View r23 = this.f9605r;
        if (r23 != null) goto L50;
    L58:
        if (r11 == 0) goto L116;
        t(this.f9605r, r17);
        return;
    L116:
        return;
    L50:
        if (r21 < r23.getLeft()) goto L58;
        if (r21 >= r23.getRight()) goto L58;
        if (r22 < r23.getTop()) goto L58;
        if (r22 >= r23.getBottom()) goto L58;
        r11 = 1;
        goto L58
    L19:
        if (r8 != 6) goto L121;
        int r24 = r19.getPointerId(r10);
        if (this.f9588a == 1) goto L24;
    L40:
        e(r24);
        return;
    L24:
        if (r24 != this.f9590c) goto L40;
        int r25 = r19.getPointerCount();
    L27:
        if (r11 >= r25) goto L37;
        int r26 = r19.getPointerId(r11);
        if (r26 == this.f9590c) goto L36;
        View r27 = h((int) r19.getX(r11), (int) r19.getY(r11));
        View r28 = this.f9605r;
        if (r27 != r28) goto L36;
        if (t(r28, r26) == false) goto L36;
        int r29 = this.f9590c;
    L38:
        if (r29 != (-1)) goto L40;
        l();
    L36:
        r11 = r11 + 1;
        goto L27
    L37:
        r29 = -1;
        goto L38
    L121:
        return;
    L61:
        if (this.f9588a != 1) goto L98;
        this.f9606s = true;
        r12.h(this.f9605r, 0.0f, 0.0f);
        this.f9606s = false;
        if (this.f9588a != 1) goto L98;
        p(0);
    L98:
        a();
        return;
    L66:
        if (this.f9588a == 1) goto L68;
        int r30 = r19.getPointerCount();
    L81:
        if (r11 >= r30) goto L94;
        int r31 = r19.getPointerId(r11);
        if (j(r31) == false) goto L93;
        float r32 = r19.getX(r11);
        float r33 = r19.getY(r11);
        float r34 = r32 - this.f9591d[r31];
        float r35 = r33 - this.f9592e[r31];
        m(r34, r35, r31);
        if (this.f9588a == 1) goto L94;
        View r36 = h((int) r32, (int) r33);
        if (d(r36, r34, r35) == false) goto L93;
        if (t(r36, r31) == true) goto L94;
    L93:
        r11 = r11 + 1;
    L94:
        o(r19);
        return;
    L68:
        if (j(this.f9590c) == false) goto L122;
        int r37 = r19.findPointerIndex(this.f9590c);
        float r38 = r19.getX(r37);
        float r39 = r19.getY(r37);
        float[] r40 = this.f9593f;
        int r41 = this.f9590c;
        int r42 = (int) (r38 - r40[r41]);
        int r43 = (int) (r39 - this.f9594g[r41]);
        int r44 = this.f9605r.getLeft() + r42;
        int r45 = this.f9605r.getTop() + r43;
        int r46 = this.f9605r.getLeft();
        int r47 = this.f9605r.getTop();
        if (r42 == 0) goto L73;
        r44 = r12.a(this.f9605r, r44);
        WeakHashMap<View, h0> r110 = w.f8437a;
        this.f9605r.offsetLeftAndRight(r44 - r46);
    L73:
        int r111 = r44;
        if (r43 == 0) goto L76;
        r45 = r12.b(this.f9605r, r45, r43);
        WeakHashMap<View, h0> r48 = w.f8437a;
        this.f9605r.offsetTopAndBottom(r45 - r47);
    L76:
        int r112 = r45;
        if (r42 != 0) goto L79;
        if (r43 == 0) goto L94;
    L79:
        this.f9604q.g(this.f9605r, r111, r112, r111 - r46, r112 - r47);
        goto L94
    L122:
        return;
    L96:
        if (this.f9588a != 1) goto L98;
        l();
        goto L98
    }

    public final void l() {
        VelocityTracker r8 = this.f9599l;
        float r10 = this.f9600m;
        r8.computeCurrentVelocity(1000, r10);
        float r11 = this.f9599l.getXVelocity(this.f9590c);
        float r12 = Math.abs(r11);
        float r13 = this.f9601n;
        float r14 = 0.0f;
        if (r12 >= r13) goto L6;
        r11 = 0.0f;
    L11:
        float r15 = this.f9599l.getYVelocity(this.f9590c);
        float r16 = Math.abs(r15);
        if (r16 >= r13) goto L15;
    L22:
        this.f9606s = true;
        this.f9604q.h(this.f9605r, r11, r14);
        this.f9606s = false;
        if (this.f9588a != 1) goto L26;
        p(0);
        return;
    L26:
        return;
    L15:
        if (r16 > r10) goto L17;
        r14 = r15;
        goto L22
    L17:
        if (r15 > 0.0f) goto L20;
        r10 = -r10;
    L20:
        r14 = r10;
        goto L22
    L6:
        if (r12 <= r10) goto L11;
        if (r11 <= 0.0f) goto L10;
        r11 = r10;
        goto L11
    L10:
        r11 = -r10;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final void m(float r8, float r10, int r11) {
        boolean r12 = c(r8, r10, r11, 1);
        ?? r13 = r12;
        if (c(r10, r8, r11, 4) == false) goto L5;
        r13 = (r12 ? 1 : 0) | 4;
    L5:
        ?? r14 = r13;
        if (c(r8, r10, r11, 2) == false) goto L8;
        r14 = (r13 == true ? 1 : 0) | 2;
    L8:
        ?? r15 = r14;
        if (c(r10, r8, r11, 8) == false) goto L11;
        r15 = (r14 == true ? 1 : 0) | 8;
    L11:
        if (r15 == 0) goto L14;
        int[] r16 = this.f9596i;
        r16[r11] = (r16[r11] | r15) == true ? 1 : 0;
        this.f9604q.getClass();
        return;
    }

    public final void n(float r11, float r12, int r13) {
        float[] r8 = this.f9591d;
        int r10 = 0;
        if (r8 != null) goto L5;
    L6:
        int r14 = r13 + 1;
        float[] r15 = new float[r14];
        float[] r16 = new float[r14];
        float[] r17 = new float[r14];
        float[] r18 = new float[r14];
        int[] r19 = new int[r14];
        int[] r20 = new int[r14];
        int[] r21 = new int[r14];
        if (r8 == null) goto L9;
        System.arraycopy(r8, 0, r15, 0, r8.length);
        float[] r22 = this.f9592e;
        System.arraycopy(r22, 0, r16, 0, r22.length);
        float[] r23 = this.f9593f;
        System.arraycopy(r23, 0, r17, 0, r23.length);
        float[] r24 = this.f9594g;
        System.arraycopy(r24, 0, r18, 0, r24.length);
        int[] r25 = this.f9595h;
        System.arraycopy(r25, 0, r19, 0, r25.length);
        int[] r26 = this.f9596i;
        System.arraycopy(r26, 0, r20, 0, r26.length);
        int[] r27 = this.f9597j;
        System.arraycopy(r27, 0, r21, 0, r27.length);
    L9:
        this.f9591d = r15;
        this.f9592e = r16;
        this.f9593f = r17;
        this.f9594g = r18;
        this.f9595h = r19;
        this.f9596i = r20;
        this.f9597j = r21;
    L10:
        float[] r28 = this.f9591d;
        this.f9593f[r13] = r11;
        r28[r13] = r11;
        float[] r29 = this.f9592e;
        this.f9594g[r13] = r12;
        r29[r13] = r12;
        int[] r30 = this.f9595h;
        int r110 = (int) r11;
        int r111 = (int) r12;
        ViewGroup r31 = this.f9607t;
        int r32 = r31.getLeft();
        int r33 = this.f9602o;
        if (r110 >= (r32 + r33)) goto L14;
        r10 = 1;
    L14:
        if (r111 >= (r31.getTop() + r33)) goto L17;
        r10 = r10 | 4;
    L17:
        if (r110 <= (r31.getRight() - r33)) goto L20;
        r10 = r10 | 2;
    L20:
        if (r111 <= (r31.getBottom() - r33)) goto L22;
        r10 = r10 | 8;
    L22:
        r30[r13] = r10;
        this.f9598k |= 1 << r13;
        return;
    L5:
        if (r8.length > r13) goto L10;
        goto L6
    }

    public final void o(MotionEvent r8) {
        int r10 = r8.getPointerCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        int r12 = r8.getPointerId(r11);
        if (j(r12) == false) goto L8;
        float r13 = r8.getX(r11);
        float r14 = r8.getY(r11);
        this.f9593f[r12] = r13;
        this.f9594g[r12] = r14;
    L8:
        r11 = r11 + 1;
        goto L3
    }

    public final void p(int r8) {
        b r10 = this.f9608u;
        this.f9607t.removeCallbacks(r10);
        if (this.f9588a == r8) goto L8;
        this.f9588a = r8;
        this.f9604q.f(r8);
        if (this.f9588a != 0) goto L9;
        this.f9605r = null;
        return;
    L9:
        return;
    }

    public final boolean q(int r8, int r10) {
        if (this.f9606s == false) goto L7;
        return i(r8, r10, (int) this.f9599l.getXVelocity(this.f9590c), (int) this.f9599l.getYVelocity(this.f9590c));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public final boolean r(MotionEvent r18) {
        int r8 = r18.getActionMasked();
        int r10 = r18.getActionIndex();
        if (r8 != 0) goto L6;
        a();
    L6:
        if (this.f9599l != null) goto L8;
        this.f9599l = VelocityTracker.obtain();
    L8:
        this.f9599l.addMovement(r18);
        boolean r11 = false;
        AbstractC0128c r12 = this.f9604q;
        if (r8 == 0) goto L65;
        if (r8 == 1) goto L63;
        if (r8 == 2) goto L30;
        if (r8 == 3) goto L63;
        if (r8 != 5) goto L17;
        int r13 = r18.getPointerId(r10);
        float r14 = r18.getX(r10);
        float r15 = r18.getY(r10);
        n(r14, r15, r13);
        int r16 = this.f9588a;
        if (r16 == 0) goto L23;
        if (r16 != 2) goto L64;
        View r17 = h((int) r14, (int) r15);
        if (r17 != this.f9605r) goto L64;
        t(r17, r13);
    L64:
        boolean r19 = false;
    L74:
        if (this.f9588a != 1) goto L77;
        return true;
    L77:
        return r19;
    L23:
        if ((this.f9595h[r13] & 0) == 0) goto L64;
        r12.getClass();
        goto L64
    L17:
        if (r8 != 6) goto L64;
        e(r18.getPointerId(r10));
        goto L64
    L30:
        if (this.f9591d == null) goto L64;
        if (this.f9592e == null) goto L64;
        int r20 = r18.getPointerCount();
        int r21 = 0;
    L35:
        if (r21 >= r20) goto L62;
        int r22 = r18.getPointerId(r21);
        if (j(r22) == false) goto L61;
        float r23 = r18.getX(r21);
        float r24 = r18.getY(r21);
        float r110 = r23 - this.f9591d[r22];
        float r111 = r24 - this.f9592e[r22];
        View r25 = h((int) r23, (int) r24);
        if (r25 != null) goto L42;
    L44:
        boolean r26 = r11;
    L45:
        if (r26 == false) goto L54;
        int r112 = r25.getLeft();
        int r113 = r12.a(r25, ((int) r110) + r112);
        int r114 = r25.getTop();
        int r115 = (int) r111;
        int r27 = r12.b(r25, r114 + r115, r115);
        int r116 = r12.c(r25);
        int r117 = r12.d();
        if (r116 == 0) goto L50;
        if (r116 <= 0) goto L54;
        if (r113 != r112) goto L54;
    L50:
        if (r117 == 0) goto L62;
        if (r117 <= 0) goto L54;
        if (r27 == r114) goto L62;
    L54:
        m(r110, r111, r22);
        if (this.f9588a == 1) goto L62;
        if (r26 == false) goto L61;
        if (t(r25, r22) == false) goto L61;
    L42:
        if (d(r25, r110, r111) == false) goto L44;
        r26 = true;
    L61:
        r21 = r21 + 1;
        r11 = false;
    L62:
        o(r18);
    L63:
        a();
        goto L64
    L65:
        float r28 = r18.getX();
        float r29 = r18.getY();
        int r30 = r18.getPointerId(0);
        n(r28, r29, r30);
        View r31 = h((int) r28, (int) r29);
        if (r31 == this.f9605r) goto L68;
    L70:
        r19 = false;
        if ((this.f9595h[r30] & 0) == 0) goto L74;
        r12.getClass();
        goto L74
    L68:
        if (this.f9588a != 2) goto L70;
        t(r31, r30);
        goto L70
    }

    public final boolean s(View r8, int r10, int r11) {
        this.f9605r = r8;
        this.f9590c = -1;
        boolean r12 = i(r10, r11, 0, 0);
        if (r12 == false) goto L5;
    L9:
        return r12;
    L5:
        if (this.f9588a != 0) goto L9;
        if (this.f9605r == null) goto L9;
        this.f9605r = null;
        goto L9
    }

    public final boolean t(View r8, int r10) {
        if (r8 == this.f9605r) goto L5;
    L7:
        if (r8 != null) goto L9;
        return false;
    L9:
        if (this.f9604q.i(r8, r10) == false) goto L14;
        this.f9590c = r10;
        b(r8, r10);
        return true;
    L14:
        return false;
    L5:
        if (this.f9590c != r10) goto L7;
        return true;
    }
}
