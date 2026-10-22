package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;

/* JADX INFO: loaded from: classes2.dex */
public class l extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ElementExp[] f3660b;

    public l(ElementExp[] r1) {
        this.f3660b = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(ElementExp r5) {
        int r1 = 0;
    L3:
        ElementExp[] r2 = this.f3660b;
        if (r1 >= r2.length) goto L10;
        if (r2[r1] == r5) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    public String toString() {
        String r0 = "ElementToken";
        int r1 = 0;
    L4:
        if (r1 >= this.f3660b.length) goto L6;
        r0 = r0 + "/" + this.f3660b[r1].getNameClass().toString();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
