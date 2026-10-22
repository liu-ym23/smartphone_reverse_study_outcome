package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ag extends af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    af f3470a;

    public ag(af r1) {
        this.f3470a = r1;
    }

    @Override // com.ctc.wstx.d.af
    public af a() {
        return new ag(this.f3470a.a());
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet r1) {
        this.f3470a.a(r1);
    }

    @Override // com.ctc.wstx.d.af
    public void a(List<an> r3) {
        List<an> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f3470a.a(r4);
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet[] r1) {
        this.f3470a.a(r1);
    }

    @Override // com.ctc.wstx.d.af
    public void b(BitSet r1) {
        this.f3470a.b(r1);
    }

    @Override // com.ctc.wstx.d.af
    public boolean b() {
        return true;
    }

    public String toString() {
        return this.f3470a + "[?]";
    }
}
