package t7a;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends a {
    public long g;
    public float h;
    public Handler i;
    public float j;
    public float k;
    public float l;
    public float m;
    public LynxTouchEvent n;
    public boolean o;
    public final e p;

    @Override // t7a.a
    public final void m() {
        this.b = 0;
        this.o = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        LynxTouchEvent r0 = this.n;
        if (h() == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L10;
        this.o = true;
        n("onEnd", f(r0));
        return;
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        LynxTouchEvent r0 = this.n;
        if (h() == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L10;
        this.o = true;
        n("onEnd", f(r0));
        return;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [t7a.e] */
    public f(int r4, LynxContext r5, s7a.a r6, p7a.a r7) {
        super(r4, r5, r6, r7);
        this.g = 500;
        this.h = com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        this.i = null;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = false;
        this.p = new e(this);
        ReadableMap r8 = r6.e;
        if (r8 == null) goto L7;
        this.g = r8.getLong("minDuration", 500);
        this.h = com.lynx.tasm.utils.i.b(r8.getLong("maxDistance", 10), 0.0f);
        return;
    }

    @Override // t7a.a
    public final void k(MotionEvent r1, LynxTouchEvent r2, float r3, float r4, boolean r5, r7a.a r6) {
        this.n = r2;
        if (r1 != null) goto L7;
        this.b = 6;
        return;
    L7:
        if (this.b < 3) goto L12;
        Handler r7 = this.i;
        if (r7 == null) goto L42;
        r7.removeCallbacksAndMessages(null);
        this.i = null;
        return;
    L42:
        return;
    L12:
        int r8 = r1.getActionMasked();
        boolean r9 = false;
        if (r8 != 0) goto L15;
        this.j = r1.getX();
        this.k = r1.getY();
        this.o = false;
        b();
        if (g() == false) goto L36;
        n("onBegin", f(r2));
    L36:
        Handler r10 = this.i;
        if (r10 != null) goto L39;
        this.i = new Handler(Looper.getMainLooper());
    L40:
        this.i.postDelayed(this.p, this.g);
        return;
    L39:
        r10.removeCallbacksAndMessages(null);
        goto L40
    L15:
        if (r8 != 1) goto L17;
        Handler r11 = this.i;
        if (r11 == null) goto L31;
        r11.removeCallbacksAndMessages(null);
        this.i = null;
    L31:
        e();
        return;
    L17:
        if (r8 != 2) goto L47;
        this.l = r1.getX();
        this.m = r1.getY();
        float r12 = Math.abs(this.l - this.j);
        float r13 = Math.abs(this.m - this.k);
        float r14 = this.h;
        if (r12 <= r14) goto L22;
    L23:
        r9 = true;
    L24:
        if (r9 == false) goto L43;
        e();
        Handler r15 = this.i;
        if (r15 == null) goto L44;
        r15.removeCallbacksAndMessages(null);
        this.i = null;
        return;
    L44:
        return;
    L43:
        return;
    L22:
        if (r13 <= r14) goto L24;
    }
}
