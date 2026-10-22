package com.obric.oui.panel;

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
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f6403w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f6407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f6408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f6409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f6410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f6411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f6412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f6413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f6415l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f6416m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f6417n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f6418o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OverScroller f6419p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f6420q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f6421r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6422s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f6423t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6424u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RunnableC0056b f6425v;

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r8) {
            float r10 = r8 - 1.0f;
            return ((((r10 * r10) * r10) * r10) * r10) + 1.0f;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.b$b, reason: collision with other inner class name */
    public class RunnableC0056b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f6426a;

        public RunnableC0056b(b r8) {
            this.f6426a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6426a.n(0);
        }
    }

    public static abstract class c {
        public abstract int a(View r8, int r10, int r11);

        public abstract int b(View r8, int r10, int r11);

        public abstract int c(View r8);

        public abstract void d(int r8);

        public abstract void e(View r8, int r10, int r11, int r12, int r13);

        public abstract void f(View r8, float r10, float r11);

        public abstract boolean g(View r8, int r10);
    }

    static {
        f6403w = new a();
    }

    public b(Context r8, ViewGroup r10, c r11) {
        this.f6406c = -1;
        this.f6424u = 600;
        this.f6425v = new RunnableC0056b(this);
        if (r10 == null) goto L10;
        if (r11 == null) goto L8;
        this.f6423t = r10;
        this.f6420q = r11;
        ViewConfiguration r12 = ViewConfiguration.get(r8);
        this.f6418o = (int) ((r8.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f6405b = r12.getScaledTouchSlop();
        this.f6416m = r12.getScaledMaximumFlingVelocity();
        this.f6417n = r12.getScaledMinimumFlingVelocity();
        this.f6419p = new OverScroller(r8, f6403w);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final void a() {
        this.f6406c = -1;
        float[] r8 = this.f6407d;
        if (r8 == null) goto L6;
        Arrays.fill(r8, 0.0f);
        Arrays.fill(this.f6408e, 0.0f);
        Arrays.fill(this.f6409f, 0.0f);
        Arrays.fill(this.f6410g, 0.0f);
        Arrays.fill(this.f6411h, 0);
        Arrays.fill(this.f6412i, 0);
        Arrays.fill(this.f6413j, 0);
        this.f6414k = 0;
    L6:
        VelocityTracker r10 = this.f6415l;
        if (r10 == null) goto L10;
        r10.recycle();
        this.f6415l = null;
        return;
    }

    public final void b(View r8, int r10) {
        ViewParent r11 = r8.getParent();
        ViewGroup r12 = this.f6423t;
        if (r11 != r12) goto L7;
        this.f6421r = r8;
        this.f6406c = r10;
        this.f6420q.getClass();
        n(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + r12 + ")");
    }

    public final boolean c(float r8, float r10, int r11, int r12) {
        float r13 = Math.abs(r8);
        float r14 = Math.abs(r10);
        if ((this.f6411h[r11] & r12) == r12) goto L5;
        return false;
    L5:
        if ((0 & r12) != 0) goto L7;
        return false;
    L7:
        if ((this.f6413j[r11] & r12) != r12) goto L9;
        return false;
    L9:
        if ((this.f6412i[r11] & r12) == r12) goto L27;
        int r15 = this.f6405b;
        if (r13 > r15) goto L16;
        if (r14 > r15) goto L16;
        return false;
    L16:
        if (r13 >= (r14 * 0.5f)) goto L19;
        this.f6420q.getClass();
    L19:
        if ((this.f6412i[r11] & r12) == 0) goto L21;
        return false;
    L21:
        if (r13 <= r15) goto L29;
        return true;
    L29:
        return false;
    L27:
        return false;
    }

    public final boolean d(View r8, float r10) {
        if (r8 != null) goto L5;
        return false;
    L5:
        c r11 = this.f6420q;
        r11.getClass();
        if (r11.c(r8) <= 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
        return false;
    L11:
        if (Math.abs(r10) > this.f6405b) goto L13;
        return false;
    L13:
        return true;
    L8:
        r12 = false;
        goto L9
    }

    public final void e(int r8) {
        float[] r10 = this.f6407d;
        if (r10 == null) goto L12;
        int r11 = this.f6414k;
        boolean r12 = true;
        int r13 = 1 << r8;
        if ((r11 & r13) != 0) goto L8;
        r12 = false;
    L8:
        if (r12 == false) goto L13;
        r10[r8] = 0.0f;
        this.f6408e[r8] = 0.0f;
        this.f6409f[r8] = 0.0f;
        this.f6410g[r8] = 0.0f;
        this.f6411h[r8] = 0;
        this.f6412i[r8] = 0;
        this.f6413j[r8] = 0;
        this.f6414k = (~r13) & r11;
        return;
    L13:
        return;
    }

    public final int f(int r8, int r10, int r11) {
        if (r8 != 0) goto L5;
        return 0;
    L5:
        int r12 = this.f6423t.getWidth();
        float r13 = r12 / 2;
        float r14 = (((float) Math.sin((Math.min(1.0f, Math.abs(r8) / r12) - 0.5f) * 0.47123894f)) * r13) + r13;
        int r15 = Math.abs(r10);
        if (r15 <= 0) goto L8;
        int r16 = Math.round(Math.abs(r14 / r15) * 1000.0f) * 4;
    L10:
        return Math.min(r16, this.f6424u);
    L8:
        r16 = (int) (((Math.abs(r8) / r11) + 1.0f) * 256.0f);
        goto L10
    }

    public final View g(int r8, int r10) {
        ViewGroup r11 = this.f6423t;
        int r12 = r11.getChildCount() - 1;
    L3:
        if (r12 < 0) goto L14;
        this.f6420q.getClass();
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

    public final boolean h(int r12, int r13, int r14, int r15) {
        int r8 = this.f6421r.getLeft();
        int r10 = this.f6421r.getTop();
        int r11 = r12 - r8;
        int r16 = r13 - r10;
        OverScroller r17 = this.f6419p;
        if (r11 != 0) goto L7;
        if (r16 != 0) goto L7;
        r17.abortAnimation();
        n(0);
        return false;
    L7:
        View r18 = this.f6421r;
        int r19 = (int) this.f6417n;
        int r20 = (int) this.f6416m;
        int r21 = Math.abs(r14);
        if (r21 >= r19) goto L10;
        r14 = 0;
    L14:
        int r22 = Math.abs(r15);
        if (r22 >= r19) goto L17;
        r15 = 0;
    L21:
        int r23 = Math.abs(r11);
        int r24 = Math.abs(r16);
        int r25 = Math.abs(r14);
        int r26 = Math.abs(r15);
        int r27 = r25 + r26;
        int r110 = r23 + r24;
        if (r14 == 0) goto L24;
        float r28 = r25;
        float r29 = r27;
    L25:
        float r30 = r28 / r29;
        if (r15 == 0) goto L28;
        float r31 = r26;
        float r32 = r27;
    L29:
        float r33 = r31 / r32;
        c r34 = this.f6420q;
        r34.getClass();
        int r111 = f(r11, r14, 0);
        r17.startScroll(r8, r10, r11, r16, (int) ((f(r16, r15, r34.c(r18)) * r33) + (r111 * r30)));
        n(2);
        return true;
    L28:
        r31 = r24;
        r32 = r110;
        goto L29
    L24:
        r28 = r23;
        r29 = r110;
        goto L25
    L17:
        if (r22 <= r20) goto L21;
        if (r15 <= 0) goto L20;
        r15 = r20;
        goto L21
    L20:
        r15 = -r20;
        goto L21
    L10:
        if (r21 <= r20) goto L14;
        if (r14 <= 0) goto L13;
        r14 = r20;
        goto L14
    L13:
        r14 = -r20;
        goto L14
    }

    public final boolean i(int r8) {
        if ((this.f6414k & (1 << r8)) == 0) goto L5;
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

    public final void j() {
        VelocityTracker r8 = this.f6415l;
        float r10 = this.f6416m;
        r8.computeCurrentVelocity(1000, r10);
        float r11 = this.f6415l.getXVelocity(this.f6406c);
        float r12 = Math.abs(r11);
        float r13 = this.f6417n;
        float r14 = 0.0f;
        if (r12 >= r13) goto L6;
        r11 = 0.0f;
    L11:
        float r15 = this.f6415l.getYVelocity(this.f6406c);
        float r16 = Math.abs(r15);
        if (r16 >= r13) goto L15;
    L22:
        this.f6422s = true;
        this.f6420q.f(this.f6421r, r11, r14);
        this.f6422s = false;
        if (this.f6404a != 1) goto L26;
        n(0);
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
    public final void k(float r8, float r10, int r11) {
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
        int[] r16 = this.f6412i;
        r16[r11] = (r16[r11] | r15) == true ? 1 : 0;
        this.f6420q.getClass();
        return;
    }

    public final void l(float r11, float r12, int r13) {
        float[] r8 = this.f6407d;
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
        float[] r22 = this.f6408e;
        System.arraycopy(r22, 0, r16, 0, r22.length);
        float[] r23 = this.f6409f;
        System.arraycopy(r23, 0, r17, 0, r23.length);
        float[] r24 = this.f6410g;
        System.arraycopy(r24, 0, r18, 0, r24.length);
        int[] r25 = this.f6411h;
        System.arraycopy(r25, 0, r19, 0, r25.length);
        int[] r26 = this.f6412i;
        System.arraycopy(r26, 0, r20, 0, r26.length);
        int[] r27 = this.f6413j;
        System.arraycopy(r27, 0, r21, 0, r27.length);
    L9:
        this.f6407d = r15;
        this.f6408e = r16;
        this.f6409f = r17;
        this.f6410g = r18;
        this.f6411h = r19;
        this.f6412i = r20;
        this.f6413j = r21;
    L10:
        float[] r28 = this.f6407d;
        this.f6409f[r13] = r11;
        r28[r13] = r11;
        float[] r29 = this.f6408e;
        this.f6410g[r13] = r12;
        r29[r13] = r12;
        int[] r30 = this.f6411h;
        int r110 = (int) r11;
        int r111 = (int) r12;
        ViewGroup r31 = this.f6423t;
        int r32 = r31.getLeft();
        int r33 = this.f6418o;
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
        this.f6414k |= 1 << r13;
        return;
    L5:
        if (r8.length > r13) goto L10;
        goto L6
    }

    public final void m(MotionEvent r8) {
        int r10 = r8.getPointerCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        int r12 = r8.getPointerId(r11);
        if (i(r12) == false) goto L8;
        float r13 = r8.getX(r11);
        float r14 = r8.getY(r11);
        this.f6409f[r12] = r13;
        this.f6410g[r12] = r14;
    L8:
        r11 = r11 + 1;
        goto L3
    }

    public final void n(int r8) {
        RunnableC0056b r10 = this.f6425v;
        this.f6423t.removeCallbacks(r10);
        if (this.f6404a == r8) goto L8;
        this.f6404a = r8;
        this.f6420q.d(r8);
        if (this.f6404a != 0) goto L9;
        this.f6421r = null;
        return;
    L9:
        return;
    }

    public final boolean o(View r8, int r10) {
        if (r8 == this.f6421r) goto L5;
    L7:
        if (r8 != null) goto L9;
        return false;
    L9:
        if (this.f6420q.g(r8, r10) == false) goto L14;
        this.f6406c = r10;
        b(r8, r10);
        return true;
    L14:
        return false;
    L5:
        if (this.f6406c != r10) goto L7;
        return true;
    }
}
