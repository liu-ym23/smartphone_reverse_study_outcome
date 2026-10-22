package t7a;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j extends a {
    public float g;
    public long h;
    public float i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public LynxTouchEvent n;
    public Handler o;
    public final i p;

    @Override // t7a.a
    public final void m() {
        this.b = 0;
        this.m = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        o(this.n);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        o(this.n);
    }

    public final void o(LynxTouchEvent r2) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.m == true) goto L10;
        this.m = true;
        n("onEnd", f(r2));
        return;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [t7a.i] */
    public j(int r3, LynxContext r4, s7a.a r5, p7a.a r6) {
        super(r3, r4, r5, r6);
        this.g = com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        this.h = 500;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = new i(this);
        ReadableMap r7 = r5.e;
        if (r7 == null) goto L7;
        this.h = r7.getLong("maxDuration", 500);
        this.g = com.lynx.tasm.utils.i.b(r7.getLong("maxDistance", 10), 0.0f);
        return;
    }

    @Override // t7a.a
    public final void k(MotionEvent r2, LynxTouchEvent r3, float r4, float r5, boolean r6, r7a.a r7) {
        this.n = r3;
        if (r2 != null) goto L9;
        this.b = 6;
        Handler r8 = this.o;
        if (r8 == null) goto L49;
        r8.removeCallbacksAndMessages(null);
        this.o = null;
        return;
    L49:
        return;
    L9:
        if (this.b < 3) goto L14;
        Handler r9 = this.o;
        if (r9 == null) goto L50;
        r9.removeCallbacksAndMessages(null);
        this.o = null;
        return;
    L50:
        return;
    L14:
        int r10 = r2.getActionMasked();
        boolean r11 = false;
        if (r10 != 0) goto L17;
        this.i = r2.getX();
        this.j = r2.getY();
        this.m = false;
        b();
        if (g() == false) goto L43;
        n("onBegin", f(r3));
    L43:
        Handler r12 = this.o;
        if (r12 != null) goto L46;
        this.o = new Handler(Looper.getMainLooper());
    L47:
        this.o.postDelayed(this.p, this.h);
        return;
    L46:
        r12.removeCallbacksAndMessages(null);
        goto L47
    L17:
        if (r10 != 1) goto L19;
        this.k = r2.getX();
        this.l = r2.getY();
        if (this.b < 3) goto L31;
        e();
    L36:
        Handler r13 = this.o;
        if (r13 == null) goto L53;
        r13.removeCallbacksAndMessages(null);
        this.o = null;
        return;
    L53:
        return;
    L31:
        a();
        if (i() == false) goto L35;
        n("onStart", f(r3));
    L35:
        o(r3);
        goto L36
    L19:
        if (r10 != 2) goto L55;
        this.k = r2.getX();
        this.l = r2.getY();
        float r14 = Math.abs(this.k - this.i);
        float r15 = Math.abs(this.l - this.j);
        float r16 = this.g;
        if (r14 <= r16) goto L24;
    L25:
        r11 = true;
    L26:
        if (r11 == false) goto L51;
        e();
        return;
    L51:
        return;
    L24:
        if (r15 <= r16) goto L26;
    }
}
