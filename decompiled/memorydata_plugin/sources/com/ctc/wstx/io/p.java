package com.ctc.wstx.io;

import com.ctc.wstx.exc.WstxException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public class p extends b {
    final com.ctc.wstx.a.b n;
    protected Reader o;
    final boolean p;
    int q;
    int r;
    int s;

    public p(com.ctc.wstx.a.b r1, v r2, String r3, String r4, r r5, Reader r6, boolean r7) {
        super(r2, r3, r4, r5);
        this.q = 0;
        this.r = 1;
        this.s = 0;
        this.n = r1;
        this.o = r6;
        this.p = r7;
        this.c = r1.l(r1.n());
    }

    private void a(boolean r5) {
        char[] r0 = this.c;
        if (r0 == null) goto L5;
        this.c = null;
        this.n.c(r0);
    L5:
        Reader r1 = this.o;
        if (r1 != null) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L10;
        ((c) ZeusTransformUtils.preCheckCast(this.o, c.class, "com.obric.memorydata.plugin")).c();
    L10:
        if (r5 == false) goto L14;
        Reader r6 = this.o;
        this.o = null;
        r6.close();
        return;
    }

    public void a(int r1, int r2, int r3) {
        this.q = r1;
        this.r = r2;
        this.s = r3;
    }

    @Override // com.ctc.wstx.io.v
    public boolean a(u r8, int r9) {
        if (this.c != null) goto L5;
        return false;
    L5:
        int r0 = r8.f3547J;
        int r2 = this.d - r0;
        r8.L += (long) r0;
        r8.N -= r0;
        if (r2 <= 0) goto L8;
        System.arraycopy(this.c, r0, this.c, 0, r2);
        r9 = r9 - r2;
    L8:
        r8.I = this.c;
        r8.f3547J = 0;
        this.d = r2;
    L10:
        if (r9 <= 0) goto L19;
        int r3 = this.c.length - r2;
        int r4 = this.o.read(this.c, r2, r3);
        if (r4 < 1) goto L13;
        r2 = r2 + r4;
        r9 = r9 - r4;
        goto L10
    L13:
        if (r4 == 0) goto L17;
        this.d = r2;
        r8.K = r2;
        return false;
    L17:
        throw new WstxException("Reader (of type " + this.o.getClass().getName() + ") returned 0 characters, even when asked to read up to " + r3, d());
    L19:
        this.d = r2;
        r8.K = r2;
        return true;
    }

    @Override // com.ctc.wstx.io.v
    public int c(u r6) {
        if (this.c != null) goto L5;
        return -1;
    L5:
        int r0 = this.o.read(this.c, 0, this.c.length);
        if (r0 >= 1) goto L12;
        this.d = 0;
        r6.f3547J = 0;
        r6.K = 0;
        if (r0 == 0) goto L11;
        return -1;
    L11:
        throw new WstxException("Reader (of type " + this.o.getClass().getName() + ") returned 0 characters, even when asked to read up to " + this.c.length, d());
    L12:
        r6.I = this.c;
        r6.f3547J = 0;
        this.d = r0;
        r6.K = r0;
        return r0;
    }

    @Override // com.ctc.wstx.io.v
    public void d(u r3) {
        r3.L = this.q;
        r3.M = this.r;
        r3.N = this.s;
    }

    @Override // com.ctc.wstx.io.v
    public boolean e() {
        return false;
    }

    @Override // com.ctc.wstx.io.v
    public void f() {
        if (this.c == null) goto L6;
        a(this.p);
        return;
    }

    @Override // com.ctc.wstx.io.v
    public void g() {
        if (this.o == null) goto L6;
        a(true);
        return;
    }
}
