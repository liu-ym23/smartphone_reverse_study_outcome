package l6a;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ SmartRefreshLayout e;

    public final void a() {
        int r0 = this.a;
        o6a.a r1 = null;
        if (r0 != 0) goto L30;
        SmartRefreshLayout r3 = this.e;
        RefreshState r4 = r3.V1;
        RefreshState r5 = RefreshState.None;
        if (r4 == r5) goto L7;
    L9:
        ValueAnimator r7 = r3.I2;
        if (r7 == null) goto L19;
        if (r4.isHeader == false) goto L19;
        if (r4.isDragging == false) goto L16;
    L17:
        r3.I2 = null;
        r7.cancel();
        this.e.T1.d(r5);
    L28:
        if (this.c != Boolean.TRUE) goto L59;
        this.e.p(true);
        return;
    L59:
        return;
    L16:
        if (r4 == RefreshState.RefreshReleased) goto L17;
    L19:
        if (r4 != RefreshState.Refreshing) goto L28;
        if (r3.L1 == null) goto L28;
        if (r3.P1 == null) goto L28;
        this.a = r0 + 1;
        r3.S1.postDelayed(this, this.b);
        this.e.n(RefreshState.RefreshFinish);
        if (this.c != Boolean.FALSE) goto L28;
        this.e.p(false);
        goto L28
    L7:
        if (r3.b2 != RefreshState.Refreshing) goto L9;
        r3.b2 = r5;
        goto L28
    L30:
        SmartRefreshLayout r2 = this.e;
        int r6 = r2.L1.e(r2, this.d);
        SmartRefreshLayout r8 = this.e;
        q6a.c r9 = r8.k0;
        if (r9 == null) goto L36;
        if ((r8.L1 instanceof f) == false) goto L36;
        r9.h();
    L36:
        if (r6 >= Integer.MAX_VALUE) goto L61;
        SmartRefreshLayout r10 = this.e;
        if (r10.n == false) goto L40;
    L41:
        long r12 = System.currentTimeMillis();
        SmartRefreshLayout r11 = this.e;
        if (r11.n == false) goto L44;
        float r13 = r11.k;
        r11.i = r13;
        r11.d = 0;
        r11.n = false;
        SmartRefreshLayout.a(r11, MotionEvent.obtain(r12, r12, 0, r11.j, (r13 + r11.b) - (r11.a * 2), 0));
        SmartRefreshLayout r14 = this.e;
        SmartRefreshLayout.b(r14, MotionEvent.obtain(r12, r12, 2, r14.j, r14.k + r14.b, 0));
    L44:
        SmartRefreshLayout r15 = this.e;
        if (r15.H0 == false) goto L47;
        r15.p0 = 0;
        SmartRefreshLayout.c(r15, MotionEvent.obtain(r12, r12, 1, r15.j, r15.k, 0));
        SmartRefreshLayout r16 = this.e;
        r16.H0 = false;
        r16.d = 0;
    L47:
        SmartRefreshLayout r17 = this.e;
        int r18 = r17.b;
        if (r18 <= 0) goto L55;
        ValueAnimator r19 = r17.g(0, r6, r17.y, r17.f);
        SmartRefreshLayout r20 = this.e;
        if (r20.N == false) goto L52;
        r1 = r20.P1.e(r20.b);
    L52:
        if (r19 == null) goto L62;
        if (r1 == null) goto L63;
        r19.addUpdateListener(r1);
        return;
    L63:
        return;
    L62:
        return;
    L55:
        if (r18 >= 0) goto L57;
        r17.g(0, r6, r17.y, r17.f);
        return;
    L57:
        r17.T1.b(0, false);
        this.e.T1.d(RefreshState.None);
        return;
    L40:
        if (r10.H0 == false) goto L47;
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

    public a(SmartRefreshLayout r1, int r2, Boolean r3, boolean r4) {
        this.e = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = 0;
    }
}
