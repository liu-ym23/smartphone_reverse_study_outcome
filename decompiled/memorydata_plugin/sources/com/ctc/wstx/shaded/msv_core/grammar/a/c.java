package com.ctc.wstx.shaded.msv_core.grammar.a;

/* JADX INFO: loaded from: classes2.dex */
public class c extends d {
    public c() {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.a.d
    public void a(String r2, String r3) {
        if (this.f3589b.accepts(r2, r3) == true) goto L5;
        return;
    L5:
        if (this.c.accepts(r2, r3) == true) goto L8;
        return;
    L8:
        throw this.d;
    }
}
