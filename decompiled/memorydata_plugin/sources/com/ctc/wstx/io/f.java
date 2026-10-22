package com.ctc.wstx.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends b {
    int j;
    final javax.xml.stream.a k;

    public f(v r3, String r4, char[] r5, int r6, int r7, javax.xml.stream.a r8, r r9) {
        javax.xml.stream.a r10 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r8, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        super(r3, r4, r10.getPublicId(), r9);
        this.c = r5;
        this.j = r6;
        this.d = r6 + r7;
        this.k = r10;
    }

    @Override // com.ctc.wstx.io.v
    public boolean a(u r4, int r5) {
        if (r4.f3547J >= r4.K) goto L5;
        return false;
    L5:
        if ((this.d - this.j) >= r5) goto L7;
        return false;
    L7:
        if (c(r4) <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.ctc.wstx.io.v
    public int c(u r4) {
        if (this.c != null) goto L5;
        return -1;
    L5:
        int r0 = this.d - this.j;
        if (r0 >= 1) goto L8;
        return -1;
    L8:
        r4.I = this.c;
        r4.f3547J = this.j;
        r4.K = this.d;
        this.j = this.d;
        return r0;
    }

    @Override // com.ctc.wstx.io.v
    public void d(u r3) {
        r3.L = this.k.getCharacterOffset();
        r3.M = this.k.getLineNumber();
        r3.N = (-this.k.getColumnNumber()) + 1;
    }

    @Override // com.ctc.wstx.io.v
    public boolean e() {
        return true;
    }

    @Override // com.ctc.wstx.io.v
    public void f() {
        this.c = null;
    }

    @Override // com.ctc.wstx.io.v
    public void g() {
        f();
    }
}
