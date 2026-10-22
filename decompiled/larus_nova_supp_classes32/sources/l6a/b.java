package l6a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ SmartRefreshLayout e;

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ b b;

        /* JADX INFO: renamed from: l6a.b$a$a, reason: collision with other inner class name */
        public class C0097a extends AnimatorListenerAdapter {
            public final /* synthetic */ a a;

            public C0097a(a r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r3) {
                b r4 = this.a.b;
                SmartRefreshLayout r0 = r4.e;
                r0.E2 = false;
                if (r4.c == false) goto L5;
                r0.p(true);
            L5:
                SmartRefreshLayout r5 = this.a.b.e;
                if (r5.V1 != RefreshState.LoadFinish) goto L9;
                r5.n(RefreshState.None);
                return;
            }
        }

        public final void a() {
            SmartRefreshLayout r0 = this.b.e;
            if (r0.M == true) goto L5;
        L7:
            o6a.a r1 = null;
        L8:
            if (r1 == null) goto L10;
            r1.onAnimationUpdate(ValueAnimator.ofInt(new int[]{0, 0}));
        L10:
            C0097a r2 = new C0097a(this);
            b r3 = this.b;
            SmartRefreshLayout r4 = r3.e;
            int r5 = r4.b;
            if (r5 <= 0) goto L13;
            ValueAnimator r6 = r4.T1.a(0);
        L30:
            if (r6 == null) goto L32;
            r6.addListener(r2);
            return;
        L32:
            r2.onAnimationEnd(null);
            return;
        L13:
            if (r1 != null) goto L25;
            if (r5 == 0) goto L25;
            if (r3.c == true) goto L19;
        L24:
            r6 = r4.T1.a(0);
            goto L30
        L19:
            if (r4.G == false) goto L24;
            int r7 = -r4.h1;
            if (r5 < r7) goto L23;
            r4.n(RefreshState.None);
        L29:
            r6 = null;
            goto L30
        L23:
            r6 = r4.T1.a(r7);
        L25:
            ValueAnimator r8 = r4.I2;
            if (r8 == null) goto L28;
            r8.cancel();
            this.b.e.I2 = null;
        L28:
            this.b.e.T1.b(0, false);
            this.b.e.T1.d(RefreshState.None);
            goto L29
        L5:
            if (this.a >= 0) goto L7;
            r1 = r0.P1.e(r0.b);
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void a() {
        int r1 = this.a;
        boolean r2 = true;
        if (r1 != 0) goto L29;
        SmartRefreshLayout r3 = this.e;
        RefreshState r4 = r3.V1;
        RefreshState r5 = RefreshState.None;
        if (r4 == r5) goto L7;
    L9:
        ValueAnimator r6 = r3.I2;
        if (r6 == null) goto L19;
        if (r4.isDragging == true) goto L16;
        if (r4 != RefreshState.LoadReleased) goto L19;
    L16:
        if (r4.isFooter == false) goto L19;
        r3.I2 = null;
        r6.cancel();
        this.e.T1.d(r5);
    L27:
        if (this.c == false) goto L70;
        this.e.p(true);
        return;
    L70:
        return;
    L19:
        if (r4 != RefreshState.Loading) goto L27;
        if (r3.M1 == null) goto L27;
        if (r3.P1 == null) goto L27;
        this.a = r1 + 1;
        r3.S1.postDelayed(this, this.b);
        this.e.n(RefreshState.LoadFinish);
        return;
    L7:
        if (r3.b2 != RefreshState.Loading) goto L9;
        r3.b2 = r5;
        goto L27
    L29:
        SmartRefreshLayout r7 = this.e;
        int r8 = r7.M1.e(r7, this.d);
        SmartRefreshLayout r9 = this.e;
        q6a.c r10 = r9.k0;
        if (r10 == null) goto L35;
        if ((r9.M1 instanceof e) == false) goto L35;
        r10.C();
    L35:
        if (r8 < Integer.MAX_VALUE) goto L37;
        return;
    L37:
        if (this.c == false) goto L45;
        SmartRefreshLayout r11 = this.e;
        if (r11.G == false) goto L45;
        if (r11.b >= 0) goto L45;
        if (r11.P1.canLoadMore() == false) goto L45;
    L46:
        SmartRefreshLayout r12 = this.e;
        int r13 = r12.b;
        if (r2 == false) goto L49;
        int r14 = Math.max(r13, -r12.h1);
    L50:
        int r15 = r13 - r14;
        SmartRefreshLayout r16 = this.e;
        if (r16.n == false) goto L53;
    L54:
        long r17 = System.currentTimeMillis();
        SmartRefreshLayout r18 = this.e;
        if (r18.n == false) goto L61;
        float r19 = r18.k;
        r18.i = r19;
        r18.d = r18.b - r15;
        r18.n = false;
        if (r18.F == false) goto L59;
        int r20 = r15;
    L60:
        float r110 = r20;
        SmartRefreshLayout.d(r18, MotionEvent.obtain(r17, r17, 0, r18.j, (r19 + r110) + (r18.a * 2), 0));
        SmartRefreshLayout r111 = this.e;
        SmartRefreshLayout.e(r111, MotionEvent.obtain(r17, r17, 2, r111.j, r111.k + r110, 0));
        goto L61
    L59:
        r20 = 0;
    L61:
        SmartRefreshLayout r112 = this.e;
        if (r112.H0 == false) goto L64;
        r112.p0 = 0;
        SmartRefreshLayout.f(r112, MotionEvent.obtain(r17, r17, 1, r112.j, r112.k, 0));
        SmartRefreshLayout r21 = this.e;
        r21.H0 = false;
        r21.d = 0;
    L64:
        SmartRefreshLayout r22 = this.e;
        Handler r23 = r22.S1;
        a r24 = new a(this, r15);
        if (r22.b >= 0) goto L67;
        long r25 = r8;
    L68:
        r23.postDelayed(r24, r25);
        return;
    L67:
        r25 = 0;
        goto L68
    L53:
        if (r16.H0 == false) goto L64;
    L49:
        r14 = 0;
    L45:
        r2 = false;
        goto L46
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(SmartRefreshLayout r1, int r2, boolean r3) {
        this.e = r1;
        this.b = r2;
        this.c = r3;
        this.d = true;
        this.a = 0;
    }
}
