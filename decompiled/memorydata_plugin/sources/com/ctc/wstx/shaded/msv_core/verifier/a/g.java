package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;

/* JADX INFO: loaded from: classes2.dex */
public class g extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3653b;
    public String c;
    public u d;
    protected p e;
    public AttributeExp f;
    private boolean g;

    g(p r2) {
        this.f = null;
        this.g = false;
        this.e = r2;
    }

    public g(p r1, String r2, String r3, String r4, u r5) {
        this(r1);
        a(r2, r3, r4, r5);
    }

    void a(String r1, String r2, String r3, u r4) {
        this.f3652a = r1;
        this.f3653b = r2;
        this.c = r3;
        this.d = r4;
        this.f = null;
        this.g = false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(AttributeExp r6) {
        if (r6.nameClass.accepts(this.f3652a, this.f3653b) == true) goto L6;
        return false;
    L6:
        if (this.d.f3677b.trim().length() != 0) goto L11;
        if (r6.exp.isEpsilonReducible() == false) goto L11;
    L12:
        boolean r0 = true;
    L14:
        if (r0 == true) goto L16;
        return false;
    L16:
        if (this.g == true) goto L18;
    L21:
        this.f = r6;
        this.g = true;
        return true;
    L18:
        if (r6 == this.f) goto L21;
        r6 = null;
    L11:
        if (this.e.c.a(r6.exp, this.d).isEpsilonReducible() == true) goto L12;
        r0 = false;
        goto L14
    }

    final e b() {
        return new e(this.e, this.f3652a, this.f3653b, this.c, this.d);
    }
}
