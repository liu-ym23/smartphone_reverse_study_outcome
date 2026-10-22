package t7a;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends a {
    public final HashMap<String, Object> g;
    public float h;
    public float i;
    public boolean j;
    public boolean k;
    public int l;
    public LynxTouchEvent m;

    @Override // t7a.a
    public final void a() {
        throw null;
    }

    @Override // t7a.a
    public final void m() {
        this.b = 0;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.k = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        LynxTouchEvent r0 = this.m;
        if (r0 != null) goto L5;
        q(null);
        return;
    L5:
        q(r0);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        LynxTouchEvent r0 = this.m;
        if (r0 != null) goto L5;
        q(null);
        return;
    L5:
        q(r0);
    }

    public final void p(LynxTouchEvent r2) {
        if (g() == true) goto L5;
        return;
    L5:
        if (this.j == true) goto L10;
        this.j = true;
        n("onBegin", o(0.0f, 0.0f));
        return;
    }

    public final void q(LynxTouchEvent r2) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.k == false) goto L7;
        return;
    L7:
        if (this.j == false) goto L13;
        this.k = true;
        n("onEnd", o(0.0f, 0.0f));
        return;
    }

    public final HashMap<String, Object> o(float r4, float r5) {
        this.g.put("scrollX", Integer.valueOf(l(this.f.getMemberScrollX())));
        this.g.put("scrollY", Integer.valueOf(l(this.f.getMemberScrollY())));
        this.g.put("deltaX", Integer.valueOf(l(r4)));
        this.g.put("deltaY", Integer.valueOf(l(r5)));
        this.g.put("isAtStart", Boolean.valueOf(this.f.isAtBorder(true)));
        this.g.put("isAtEnd", Boolean.valueOf(this.f.isAtBorder(false)));
        return this.g;
    }

    public final void r(float r2, float r3, r7a.a r4) {
        p7a.a r0 = this.f;
        if (r0 == null) goto L5;
        r0.onGestureScrollBy(r2, r3);
    L5:
        if (r4 == null) goto L8;
        r4.d = true;
        r4.b = r2;
        r4.c = r3;
    L8:
        if (Math.abs((int) r2) <= this.l) goto L10;
    L11:
        this.c.onGestureRecognized(this.a);
    L13:
        if (j() == true) goto L15;
        return;
    L15:
        n("onUpdate", o(r2, r3));
        return;
    L10:
        if (Math.abs((int) r3) <= this.l) goto L13;
        goto L11
    }

    public final boolean s(float r5, float r6, r7a.a r7) {
        if (r7 == null) goto L17;
        p7a.a r1 = this.f;
        if (r1 == null) goto L17;
        if (r7.a != (-1)) goto L12;
        if (r1.getScrollContainerDirection() == (-1)) goto L12;
        return true;
    L12:
        if (r7.a != 1) goto L17;
        if (this.f.getScrollContainerDirection() == 1) goto L17;
        return true;
    L17:
        return !this.f.canConsumeGesture(r5, r6);
    }

    public b(int r1, LynxContext r2, s7a.a r3, p7a.a r4) {
        super(r1, r2, r3, r4);
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.k = false;
        this.l = 3;
        ReadableMap r5 = r3.e;
        if (r5 == null) goto L6;
        this.l = r5.getInt("tapSlop", 3);
    L6:
        this.g = new HashMap();
    }

    @Override // t7a.a
    public final void k(MotionEvent r8, LynxTouchEvent r9, float r10, float r11, boolean r12, r7a.a r13) {
        this.m = r9;
        if (r12 == false) goto L12;
        if (r13 == null) goto L12;
        if (r13.d == false) goto L103;
        p7a.a r14 = this.f;
        if (r14 == null) goto L104;
        r14.onGestureScrollBy(r13.b, r13.c);
        this.f.onInvalidate();
        return;
    L104:
        return;
    L103:
        return;
    L12:
        if (this.b < 3) goto L15;
        q(r9);
        return;
    L15:
        float r1 = 0.0f;
        if (r8 == null) goto L66;
        int r6 = r8.getActionMasked();
        if (r6 == 0) goto L65;
        if (r6 == 1) goto L59;
        if (r6 != 2) goto L112;
        float r15 = this.h - r8.getX();
        float r16 = this.i - r8.getY();
        if (r15 == 0.0f) goto L25;
    L27:
        if (r13 != null) goto L29;
    L35:
        if (r13 == null) goto L40;
        int r3 = r13.a;
        if (r3 == 0) goto L40;
        if (r3 != (-1)) goto L42;
        r1 = r15;
        r16 = 0.0f;
    L42:
        if (this.b != 0) goto L47;
        p(r9);
        if (this.b > 1) goto L57;
        super.a();
    L57:
        this.h = r8.getX();
        this.i = r8.getY();
        return;
    L47:
        if (s(r1, r16, r13) == false) goto L56;
        p7a.a r17 = this.f;
        if (r17 != null) goto L51;
    L55:
        e();
        q(r9);
        goto L57
    L51:
        if (r17.isAtBorder(true) == true) goto L55;
        if (this.f.isAtBorder(false) == true) goto L55;
        r(r1, r16, r13);
        goto L55
    L56:
        super.a();
        r(r1, r16, r13);
    L40:
        r1 = r15;
        goto L42
    L29:
        if (r13.a != 0) goto L35;
        if (Math.abs(r15) <= Math.abs(r16)) goto L33;
        int r4 = -1;
    L34:
        r13.a = r4;
        goto L35
    L33:
        r4 = 1;
        goto L34
    L25:
        if (r16 != 0.0f) goto L27;
        return;
    L112:
        return;
    L59:
        if (this.b == 2) goto L61;
        return;
    L61:
        if (r10 == Float.MIN_VALUE) goto L63;
        return;
    L63:
        if (r11 != Float.MIN_VALUE) goto L108;
        e();
        q(null);
        return;
    L108:
        return;
    L65:
        this.h = r8.getX();
        this.i = r8.getY();
        this.k = false;
        b();
        p(r9);
        return;
    L66:
        p7a.a r18 = this.f;
        if (r18 == null) goto L70;
        r18.onInvalidate();
    L70:
        if (this.b == 2) goto L72;
    L77:
        if (r13 == null) goto L84;
        int r19 = r13.a;
        if (r19 == 0) goto L84;
        if (r19 != (-1)) goto L82;
        r11 = 0.0f;
        goto L84
    L82:
        r10 = 0.0f;
    L84:
        if (s(r10, r11, r13) == false) goto L94;
        p7a.a r20 = this.f;
        if (r20 != null) goto L88;
    L92:
        e();
        q(null);
    L99:
        p7a.a r21 = this.f;
        if (r21 == null) goto L111;
        r21.onInvalidate();
        return;
    L111:
        return;
    L88:
        if (r20.isAtBorder(true) == true) goto L92;
        if (this.f.isAtBorder(false) == true) goto L92;
        r(r10, r11, r13);
        goto L92
    L94:
        if (this.b != 0) goto L98;
        p(r9);
        if (this.b > 1) goto L98;
        super.a();
    L98:
        r(r10, r11, r13);
        goto L99
    L72:
        if (r10 != Float.MIN_VALUE) goto L77;
        if (r11 != Float.MIN_VALUE) goto L77;
        e();
        q(null);
    }
}
