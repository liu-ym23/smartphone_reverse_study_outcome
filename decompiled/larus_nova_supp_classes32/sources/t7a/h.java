package t7a;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class h extends a {
    public final HashMap<String, Object> g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public LynxTouchEvent m;
    public boolean n;
    public boolean o;
    public boolean p;

    @Override // t7a.a
    public final void m() {
        this.b = 0;
        this.n = false;
        this.o = false;
        this.p = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        p(this.m);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        p(this.m);
    }

    public final HashMap<String, Object> o(LynxTouchEvent r4) {
        this.g.put("scrollX", Integer.valueOf(l(this.f.getMemberScrollX())));
        this.g.put("scrollY", Integer.valueOf(l(this.f.getMemberScrollY())));
        this.g.put("isAtStart", Boolean.valueOf(this.f.isAtBorder(true)));
        this.g.put("isAtEnd", Boolean.valueOf(this.f.isAtBorder(false)));
        this.g.putAll(f(r4));
        return this.g;
    }

    public final void p(LynxTouchEvent r2) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.p == false) goto L7;
        return;
    L7:
        if (this.n == false) goto L13;
        this.p = true;
        n("onEnd", o(r2));
        return;
    }

    public h(int r3, LynxContext r4, s7a.a r5, p7a.a r6) {
        super(r3, r4, r5, r6);
        this.h = com.lynx.tasm.utils.i.b(0.0f, 0.0f);
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.n = false;
        this.o = false;
        this.p = false;
        ReadableMap r7 = r5.e;
        if (r7 == null) goto L6;
        this.h = com.lynx.tasm.utils.i.b(r7.getLong("minDistance", 0), 0.0f);
    L6:
        this.g = new HashMap();
    }

    @Override // t7a.a
    public final void k(MotionEvent r3, LynxTouchEvent r4, float r5, float r6, boolean r7, r7a.a r8) {
        if (r4 == null) goto L4;
        this.m = r4;
    L4:
        if (r3 != null) goto L8;
        this.b = 6;
        return;
    L8:
        if (this.b < 3) goto L10;
        return;
    L10:
        int r9 = r3.getActionMasked();
        boolean r0 = false;
        if (r9 == 0) goto L51;
        if (r9 != 1) goto L14;
        e();
        p(this.m);
        return;
    L14:
        if (r9 != 2) goto L63;
        this.k = r3.getX();
        this.l = r3.getY();
        if (this.b != 0) goto L26;
        b();
        if (this.n == true) goto L26;
        this.n = true;
        if (g() == false) goto L26;
        n("onBegin", o(r4));
    L26:
        if (this.b >= 3) goto L33;
        float r10 = Math.abs(this.k - this.i);
        float r11 = Math.abs(this.l - this.j);
        float r12 = this.h;
        if (r10 <= r12) goto L31;
    L32:
        r0 = true;
        goto L33
    L31:
        if (r11 > r12) goto L32;
    L33:
        if (r0 == false) goto L42;
        a();
        if (i() == false) goto L42;
        if (this.o == true) goto L42;
        if (this.n == false) goto L42;
        this.o = true;
        n("onStart", o(r4));
    L42:
        int r13 = this.b;
        if (r13 == 2) goto L45;
        if (r13 < 3) goto L60;
        p(r4);
        return;
    L60:
        return;
    L45:
        if (j() == false) goto L64;
        n("onUpdate", o(r4));
        return;
    L64:
        return;
    L63:
        return;
    L51:
        this.i = r3.getX();
        this.j = r3.getY();
        this.p = false;
        b();
        if (this.n == true) goto L65;
        this.n = true;
        if (g() == false) goto L66;
        n("onBegin", o(r4));
        return;
    L66:
        return;
    }
}
