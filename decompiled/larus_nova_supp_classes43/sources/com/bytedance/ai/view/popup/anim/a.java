package com.bytedance.ai.view.popup.anim;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final InterpolatorC0054a v = null;
    public int a;
    public final int b;
    public int c;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public final float m;
    public final float n;
    public final int o;
    public final OverScroller p;
    public final c q;
    public View r;
    public boolean s;
    public final ViewGroup t;
    public final b u;

    /* JADX INFO: renamed from: com.bytedance.ai.view.popup.anim.a$a, reason: collision with other inner class name */
    public class InterpolatorC0054a implements Interpolator {
        public InterpolatorC0054a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ a a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r1) {
            this.a = r1;
        }
    }

    public static abstract class c {
        public c() {
        }
    }

    public final void b() {
        this.c = -1;
        float[] r0 = this.d;
        if (r0 == null) goto L6;
        Arrays.fill(r0, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    L6:
        VelocityTracker r1 = this.l;
        if (r1 == null) goto L10;
        r1.recycle();
        this.l = null;
        return;
    }

    static {
        v = new InterpolatorC0054a();
    }

    public final void l() {
        this.l.computeCurrentVelocity(IServerListener.WHAT_BYTELINK_SINK_ERROR, this.m);
        float r0 = this.l.getXVelocity(this.c);
        float r1 = this.n;
        float r10 = this.m;
        float r11 = Math.abs(r0);
        float r12 = 0.0f;
        if (r11 >= r1) goto L6;
        r0 = 0.0f;
    L11:
        float r13 = this.l.getYVelocity(this.c);
        float r14 = this.n;
        float r15 = this.m;
        float r16 = Math.abs(r13);
        if (r16 >= r14) goto L15;
    L21:
        h(r0, r12);
        return;
    L15:
        if (r16 > r15) goto L17;
    L20:
        r12 = r13;
        goto L21
    L17:
        if (r13 <= 0.0f) goto L19;
        r12 = r15;
        goto L21
    L19:
        r13 = -r15;
        goto L20
    L6:
        if (r11 <= r10) goto L11;
        if (r0 <= 0.0f) goto L10;
        r0 = r10;
        goto L11
    L10:
        r0 = -r10;
        goto L11
    }

    public final void f(int r10) {
        float[] r0 = this.d;
        if (r0 == null) goto L12;
        int r1 = this.k;
        boolean r11 = true;
        int r12 = 1 << r10;
        if ((r12 & r1) != 0) goto L8;
        r11 = false;
    L8:
        if (r11 == false) goto L13;
        r0[r10] = 0.0f;
        this.e[r10] = 0.0f;
        this.f[r10] = 0.0f;
        this.g[r10] = 0.0f;
        this.h[r10] = 0;
        this.i[r10] = 0;
        this.j[r10] = 0;
        this.k = (~r12) & r1;
        return;
    L13:
        return;
    }

    public final void o(MotionEvent r10) {
        int r0 = r10.getPointerCount();
        int r11 = 0;
    L3:
        if (r11 >= r0) goto L14;
        int r12 = r10.getPointerId(r11);
        boolean r13 = true;
        if ((this.k & (1 << r12)) == 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L10;
        r13 = false;
    L10:
        if (r13 == false) goto L13;
        float r15 = r10.getX(r11);
        float r16 = r10.getY(r11);
        this.f[r12] = r15;
        this.g[r12] = r16;
    L13:
        r11 = r11 + 1;
        goto L3
    L7:
        r14 = false;
        goto L8
    }

    public final void p(int r10) {
        this.t.removeCallbacks(this.u);
        if (this.a == r10) goto L14;
        this.a = r10;
        BottomSheetBehavior.a r0 = (BottomSheetBehavior.a) this.q;
        if (r10 != 1) goto L9;
        BottomSheetBehavior r11 = r0.a;
        if (r11.s == false) goto L11;
        r11.setStateInternal(1);
    L11:
        if (this.a != 0) goto L15;
        this.r = null;
        return;
    L15:
        return;
    L9:
        r0.getClass();
        goto L11
    }

    public final void c(View r10, int r11) {
        if (r10.getParent() != this.t) goto L7;
        this.r = r10;
        this.c = r11;
        this.q.getClass();
        p(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.t + ")");
    }

    public final boolean e(View r10, float r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        this.q.getClass();
        BottomSheetBehavior r12 = ((BottomSheetBehavior.a) this.q).a;
        if (r12.q == false) goto L8;
        int r13 = r12.J;
    L10:
        if (r13 <= 0) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == true) goto L15;
        return false;
    L15:
        if (Math.abs(r11) <= this.b) goto L19;
        return true;
    L19:
        return false;
    L12:
        r14 = false;
        goto L13
    L8:
        r13 = r12.p;
        goto L10
    }

    public final void h(float r11, float r12) {
        this.s = true;
        c r1 = this.q;
        View r10 = this.r;
        BottomSheetBehavior.a r13 = (BottomSheetBehavior.a) r1;
        r13.getClass();
        int r14 = r10.getTop();
        int r15 = 3;
        if (r12 >= 0.0f) goto L23;
        BottomSheetBehavior r16 = r13.a;
        if (r16.b == false) goto L14;
        int r17 = r16.p;
        if (r14 > r17) goto L9;
    L13:
        int r18 = r16.m;
    L22:
        r17 = r18;
    L106:
        r13.a.startSettlingAnimation(r10, r15, r17, true);
        this.s = false;
        if (this.a != 1) goto L110;
        p(0);
        return;
    L110:
        return;
    L9:
        if (r16.r == true) goto L11;
    L20:
        r15 = 4;
        goto L106
    L11:
        if (r16.B != 4) goto L13;
    L14:
        r17 = r16.p;
        if (r14 > r17) goto L17;
    L21:
        r18 = r16.j;
        goto L22
    L17:
        if (r16.r == false) goto L20;
        if (r16.B != 4) goto L21;
    L23:
        BottomSheetBehavior r19 = r13.a;
        if (r19.q == false) goto L68;
        if (r19.shouldHide(r10, r12) == false) goto L68;
        if (Math.abs(r11) >= Math.abs(r12)) goto L32;
        if (r12 <= 500.0f) goto L32;
    L42:
        r17 = r13.a.J;
        r15 = 5;
    L32:
        if (r13.a.B != 3) goto L36;
        int r110 = r10.getTop();
        BottomSheetBehavior r111 = r13.a;
        if ((r110 - r111.j) < r111.A) goto L36;
    L39:
        boolean r112 = true;
    L41:
        if (r112 == true) goto L42;
        BottomSheetBehavior r113 = r13.a;
        if (r113.b == false) goto L57;
        if (r113.B == 3) goto L48;
        r17 = r113.p;
        if ((r17 - r14) < r113.x) goto L20;
        r18 = r113.m;
        goto L22
    L48:
        if (r113.r == true) goto L52;
        int r114 = Math.abs(r14 - r113.m);
        BottomSheetBehavior r115 = r13.a;
        if (r114 < r115.y) goto L52;
        r17 = r115.p;
    L52:
        r18 = r13.a.m;
        goto L22
    L57:
        if (r113.B == 3) goto L59;
        r17 = r113.p;
        if ((r17 - r14) < r113.x) goto L20;
        r18 = r113.j;
        goto L22
    L59:
        if (r113.r == true) goto L63;
        int r116 = Math.abs(r14 - r113.j);
        BottomSheetBehavior r117 = r13.a;
        if (r116 < r117.y) goto L63;
        r17 = r117.p;
    L63:
        r18 = r13.a.j;
    L36:
        if (r13.a.B != 4) goto L40;
        int r118 = r10.getTop();
        BottomSheetBehavior r119 = r13.a;
        if ((r118 - r119.p) >= r119.z) goto L39;
    L40:
        r112 = false;
    L68:
        if (r12 != 0.0f) goto L70;
    L82:
        BottomSheetBehavior r120 = r13.a;
        if (r120.b == false) goto L96;
        if (r120.B == 3) goto L87;
        r17 = r120.p;
        if ((r17 - r14) < r120.x) goto L20;
        r18 = r120.m;
        goto L22
    L87:
        if (r120.r == true) goto L91;
        int r121 = Math.abs(r14 - r120.m);
        BottomSheetBehavior r122 = r13.a;
        if (r121 < r122.y) goto L91;
        r17 = r122.p;
    L91:
        r18 = r13.a.m;
        goto L22
    L96:
        if (r120.B == 3) goto L98;
        r17 = r120.p;
        if ((r17 - r14) < r120.x) goto L20;
        r18 = r120.j;
        goto L22
    L98:
        if (r120.r == true) goto L102;
        int r123 = Math.abs(r14 - r120.j);
        BottomSheetBehavior r124 = r13.a;
        if (r123 < r124.y) goto L102;
        r17 = r124.p;
    L102:
        r18 = r13.a.j;
        goto L22
    L70:
        if (Math.abs(r11) > Math.abs(r12)) goto L82;
        BottomSheetBehavior r125 = r13.a;
        if (r125.b == false) goto L79;
        if (r125.r == false) goto L77;
        r18 = r125.m;
        goto L22
    L77:
        r17 = r125.p;
        goto L20
    L79:
        if (r125.r == false) goto L81;
        r18 = r125.j;
        goto L22
    L81:
        r17 = r125.p;
        goto L20
    }

    public final View j(int r10, int r11) {
        int r0 = this.t.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L14;
        ViewGroup r1 = this.t;
        this.q.getClass();
        View r12 = r1.getChildAt(r0);
        if (r10 < r12.getLeft()) goto L13;
        if (r10 >= r12.getRight()) goto L13;
        if (r11 < r12.getTop()) goto L13;
        if (r11 >= r12.getBottom()) goto L13;
        return r12;
    L13:
        r0 = r0 - 1;
        goto L3
    L14:
        return null;
    }

    public final boolean q(View r10, int r11) {
        if (r10 != this.r) goto L8;
        if (this.c != r11) goto L8;
        return true;
    L8:
        if (r10 == null) goto L36;
        BottomSheetBehavior.a r12 = (BottomSheetBehavior.a) this.q;
        BottomSheetBehavior r13 = r12.a;
        int r14 = r13.D;
        if (r14 != 1) goto L13;
    L32:
        boolean r15 = false;
    L33:
        if (r15 == false) goto L36;
        this.c = r11;
        c(r10, r11);
        return true;
    L13:
        if (r13.R == true) goto L32;
        if (r14 == 3) goto L18;
    L27:
        WeakReference<V> r16 = r12.a.K;
        if (r16 == 0) goto L32;
        if (r16.get() != r10) goto L32;
        r15 = true;
        goto L33
    L18:
        if (r13.O != r11) goto L27;
        WeakReference<View> r17 = r13.L;
        if (r17 == null) goto L22;
        View r18 = r17.get();
    L23:
        if (r18 == null) goto L27;
        if (r18.canScrollVertically(-1) == false) goto L27;
    L22:
        r18 = null;
    L36:
        return false;
    }

    public a(Context r10, ViewGroup r11, c r12) {
        this.c = -1;
        this.u = new b(this);
        if (r11 == null) goto L10;
        if (r12 == null) goto L8;
        this.t = r11;
        this.q = r12;
        ViewConfiguration r13 = ViewConfiguration.get(r10);
        Resources r14 = r10.getResources();
        this.o = (int) ((WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).density * 20.0f) + 0.5f);
        this.b = r13.getScaledTouchSlop();
        this.m = r13.getScaledMaximumFlingVelocity();
        this.n = r13.getScaledMinimumFlingVelocity();
        this.p = new OverScroller(r10, v);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final int g(int r10, int r11, int r12) {
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.t.getWidth();
        float r1 = r0 / 2;
        float r13 = r1 + (((float) Math.sin((Math.min(1.0f, Math.abs(r10) / r0) - 0.5f) * 0.47123894f)) * r1);
        int r14 = Math.abs(r11);
        if (r14 <= 0) goto L8;
        int r15 = Math.round(Math.abs(r13 / r14) * 1000.0f) * 4;
    L10:
        return Math.min(r15, FontWeight.WEIGHT_600);
    L8:
        r15 = (int) (((Math.abs(r10) / r12) + 1.0f) * 256.0f);
        goto L10
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
    public final void m(float r10, float r11, int r12) {
        boolean r0 = d(r10, r11, r12, 1);
        ?? r1 = r0;
        if (d(r11, r10, r12, 4) == false) goto L5;
        r1 = (r0 ? 1 : 0) | 4;
    L5:
        ?? r13 = r1;
        if (d(r10, r11, r12, 2) == false) goto L8;
        r13 = (r1 == true ? 1 : 0) | 2;
    L8:
        ?? r14 = r13;
        if (d(r11, r10, r12, 8) == false) goto L11;
        r14 = (r13 == true ? 1 : 0) | 8;
    L11:
        if (r14 == 0) goto L14;
        int[] r15 = this.i;
        r15[r12] = (r15[r12] | r14) == true ? 1 : 0;
        this.q.getClass();
        return;
    }

    public final void n(float r11, float r12, int r13) {
        float[] r0 = this.d;
        int r1 = 0;
        if (r0 != null) goto L5;
    L6:
        int r10 = r13 + 1;
        float[] r14 = new float[r10];
        float[] r15 = new float[r10];
        float[] r16 = new float[r10];
        float[] r17 = new float[r10];
        int[] r18 = new int[r10];
        int[] r19 = new int[r10];
        int[] r20 = new int[r10];
        if (r0 == null) goto L9;
        System.arraycopy(r0, 0, r14, 0, r0.length);
        float[] r21 = this.e;
        System.arraycopy(r21, 0, r15, 0, r21.length);
        float[] r22 = this.f;
        System.arraycopy(r22, 0, r16, 0, r22.length);
        float[] r23 = this.g;
        System.arraycopy(r23, 0, r17, 0, r23.length);
        int[] r24 = this.h;
        System.arraycopy(r24, 0, r18, 0, r24.length);
        int[] r25 = this.i;
        System.arraycopy(r25, 0, r19, 0, r25.length);
        int[] r26 = this.j;
        System.arraycopy(r26, 0, r20, 0, r26.length);
    L9:
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
    L10:
        float[] r27 = this.d;
        this.f[r13] = r11;
        r27[r13] = r11;
        float[] r28 = this.e;
        this.g[r13] = r12;
        r28[r13] = r12;
        int[] r29 = this.h;
        int r110 = (int) r11;
        int r111 = (int) r12;
        if (r110 >= (this.t.getLeft() + this.o)) goto L14;
        r1 = 1;
    L14:
        if (r111 >= (this.t.getTop() + this.o)) goto L17;
        r1 = r1 | 4;
    L17:
        if (r110 <= (this.t.getRight() - this.o)) goto L20;
        r1 = r1 | 2;
    L20:
        if (r111 <= (this.t.getBottom() - this.o)) goto L22;
        r1 = r1 | 8;
    L22:
        r29[r13] = r1;
        this.k |= 1 << r13;
        return;
    L5:
        if (r0.length > r13) goto L10;
        goto L6
    }

    public static boolean a(View r10, int r11, int r12, int r13) {
        if ((r10 instanceof ViewGroup) == false) goto L18;
        ViewGroup r0 = (ViewGroup) r10;
        int r14 = r10.getScrollX();
        int r15 = r10.getScrollY();
        int r16 = r0.getChildCount() - 1;
    L5:
        if (r16 < 0) goto L18;
        View r17 = r0.getChildAt(r16);
        int r18 = r12 + r14;
        if (r18 < r17.getLeft()) goto L17;
        if (r18 >= r17.getRight()) goto L17;
        int r19 = r13 + r15;
        if (r19 < r17.getTop()) goto L17;
        if (r19 >= r17.getBottom()) goto L17;
        if (a(r17, r11, r18 - r17.getLeft(), r19 - r17.getTop()) == false) goto L17;
        return true;
    L17:
        r16 = r16 - 1;
    L18:
        if (r11 == 0) goto L22;
        if (r10.canScrollHorizontally(-r11) == false) goto L22;
        return true;
    L22:
        if (r10.canScrollVertically(-1) == true) goto L34;
        return false;
    L34:
        return true;
    }

    public final boolean d(float r10, float r11, int r12, int r13) {
        float r14 = Math.abs(r10);
        float r15 = Math.abs(r11);
        if ((this.h[r12] & r13) == r13) goto L5;
        return false;
    L5:
        if ((0 & r13) != 0) goto L7;
        return false;
    L7:
        if ((this.j[r12] & r13) != r13) goto L9;
        return false;
    L9:
        if ((this.i[r12] & r13) == r13) goto L27;
        int r0 = this.b;
        if (r14 > r0) goto L16;
        if (r15 > r0) goto L16;
        return false;
    L16:
        if (r14 >= (r15 * 0.5f)) goto L19;
        this.q.getClass();
    L19:
        if ((this.i[r12] & r13) == 0) goto L21;
        return false;
    L21:
        if (r14 <= this.b) goto L29;
        return true;
    L29:
        return false;
    L27:
        return false;
    }

    public final void i(int r10, int r11, int r12, int r13) {
        int r14 = this.r.getLeft();
        int r0 = this.r.getTop();
        if (r12 == 0) goto L5;
        c r1 = this.q;
        View r15 = this.r;
        ((BottomSheetBehavior.a) r1).getClass();
        int r16 = r15.getLeft();
        ViewCompat.offsetLeftAndRight(this.r, r16 - r14);
    L5:
        if (r13 == 0) goto L11;
        BottomSheetBehavior.a r17 = (BottomSheetBehavior.a) this.q;
        int r18 = r17.a.getExpandedOffset();
        BottomSheetBehavior r19 = r17.a;
        if (r19.q == false) goto L9;
        int r20 = r19.J;
    L10:
        r11 = MathUtils.clamp(r11, r18, r20);
        ViewCompat.offsetTopAndBottom(this.r, r11 - r0);
        goto L11
    L9:
        r20 = r19.p;
    L11:
        if (r12 != 0) goto L13;
        if (r13 != 0) goto L13;
        return;
    L13:
        ((BottomSheetBehavior.a) this.q).a.dispatchOnSlide(r11);
    }

    public final boolean k(int r10, int r11, int r12, int r13) {
        int r14 = this.r.getLeft();
        int r15 = this.r.getTop();
        int r16 = r10 - r14;
        int r17 = r11 - r15;
        if (r16 != 0) goto L7;
        if (r17 != 0) goto L7;
        this.p.abortAnimation();
        p(0);
        return false;
    L7:
        int r18 = (int) this.n;
        int r0 = (int) this.m;
        int r1 = Math.abs(r12);
        if (r1 >= r18) goto L10;
        r12 = 0;
    L14:
        int r19 = (int) this.n;
        int r20 = (int) this.m;
        int r21 = Math.abs(r13);
        if (r21 >= r19) goto L17;
        r13 = 0;
    L21:
        int r110 = Math.abs(r16);
        int r22 = Math.abs(r17);
        int r23 = Math.abs(r12);
        int r24 = Math.abs(r13);
        int r25 = r23 + r24;
        int r26 = r110 + r22;
        if (r12 == 0) goto L24;
        float r111 = r23;
        float r27 = r25;
    L25:
        float r112 = r111 / r27;
        if (r13 == 0) goto L28;
        float r28 = r24;
        float r29 = r25;
    L29:
        float r30 = r28 / r29;
        this.q.getClass();
        int r113 = g(r16, r12, 0);
        BottomSheetBehavior r114 = ((BottomSheetBehavior.a) this.q).a;
        if (r114.q == false) goto L32;
        int r115 = r114.J;
    L33:
        this.p.startScroll(r14, r15, r16, r17, (int) ((r113 * r112) + (g(r17, r13, r115) * r30)));
        p(2);
        return true;
    L32:
        r115 = r114.p;
        goto L33
    L28:
        r28 = r22;
        r29 = r26;
        goto L29
    L24:
        r111 = r110;
        r27 = r26;
        goto L25
    L17:
        if (r21 <= r20) goto L21;
        if (r13 <= 0) goto L20;
        r13 = r20;
        goto L21
    L20:
        r13 = -r20;
        goto L21
    L10:
        if (r1 <= r0) goto L14;
        if (r12 <= 0) goto L13;
        r12 = r0;
        goto L14
    L13:
        r12 = -r0;
        goto L14
    }
}
