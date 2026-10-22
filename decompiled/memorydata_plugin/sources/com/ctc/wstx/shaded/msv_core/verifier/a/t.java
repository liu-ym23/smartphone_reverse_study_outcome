package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.DataExp;
import com.ctc.wstx.shaded.msv_core.grammar.ListExp;
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class t extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set f3675a;

    t(u r2) {
        this(r2, new HashSet());
    }

    t(u r4, Set r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        super(r4.d, r4.f3677b, r4.c, null);
        this.f3675a = r6;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.u
    public u a(String r4, com.ctc.wstx.shaded.msv_core.util.a r5) {
        return new t(new u(this.d, r4, this.c, r5));
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.u, com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(DataExp r3) {
        if (super.a(r3) == false) goto L5;
        return true;
    L5:
        this.f3675a.add(r3);
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.u, com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(ListExp r1) {
        super.a(r1);
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.u, com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(ValueExp r3) {
        if (super.a(r3) == false) goto L5;
        return true;
    L5:
        this.f3675a.add(r3);
        return true;
    }
}
