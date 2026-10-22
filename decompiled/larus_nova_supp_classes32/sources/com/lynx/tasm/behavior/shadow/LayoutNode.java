package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.LayoutNodeManager;
import y6a.a;
import y6a.b;
import y6a.e;
import y6a.g;
import y6a.h;
import y6a.j;
import y6a.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LayoutNode {
    public LayoutNodeManager a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public h f;
    public e g;
    public o h;
    public long i;

    public void g() {
    }

    public void align() {
        if (this.g == null) goto L6;
        b r0 = new b();
        a r1 = new a();
        this.g.d(r0, r1);
        return;
    }

    public void e() {
        this.h = new o((ShadowNode) this);
        if (this.c == true) goto L8;
        h r0 = this.f;
        if (r0 == null) goto L8;
        i(r0);
        return;
    L8:
        if (this.d == true) goto L14;
        e r1 = this.g;
        if (r1 == null) goto L15;
        h(r1);
        return;
    L15:
        return;
    }

    public LayoutNode() {
        this.c = false;
        this.d = false;
        this.e = false;
        this.g = null;
        this.i = 0;
    }

    public final void h(e r2) {
        this.g = r2;
        LayoutNodeManager r3 = this.a;
        if (r3 == null) goto L6;
        this.d = true;
        r3.i(this.b, this);
        return;
    }

    public final void i(h r2) {
        this.f = r2;
        LayoutNodeManager r3 = this.a;
        if (r3 == null) goto L6;
        this.c = true;
        r3.i(this.b, this);
        return;
    }

    public void f(int r1, int r2) {
        this.e = false;
    }

    public float[] measure(float r11, int r12, float r13, int r14, boolean r15) {
        float[] r0 = new float[3];
        h r1 = this.f;
        if (r1 == null) goto L6;
        long r16 = r1.c(this, r11, MeasureMode.fromInt(r12), r13, MeasureMode.fromInt(r14));
        r0[0] = Float.intBitsToFloat((int) ((r16 >> 32) & (-1)));
        r0[1] = Float.intBitsToFloat((int) (r16 & (-1)));
        r0[2] = this.i;
    L8:
        return r0;
    L6:
        if (this.g == null) goto L8;
        g r2 = new g(r15);
        j r17 = new j();
        MeasureMode r18 = MeasureMode.fromInt(r12);
        MeasureMode r19 = MeasureMode.fromInt(r14);
        r17.a = r11;
        r17.b = r18;
        r17.c = r13;
        r17.d = r19;
        float[] r110 = this.g.b(r17, r2).a;
        r0[0] = r110[0];
        r0[1] = r110[1];
        r0[2] = r110[2];
        goto L8
    }
}
