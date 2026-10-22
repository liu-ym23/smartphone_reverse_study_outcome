package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ak extends af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    af f3477a;

    public ak(af r1) {
        this.f3477a = r1;
    }

    @Override // com.ctc.wstx.d.af
    public af a() {
        return new ak(this.f3477a.a());
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet r1) {
        this.f3477a.a(r1);
    }

    @Override // com.ctc.wstx.d.af
    public void a(List<an> r3) {
        List<an> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f3477a.a(r4);
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet[] r4) {
        this.f3477a.a(r4);
        BitSet r0 = new BitSet();
        this.f3477a.a(r0);
        BitSet r1 = new BitSet();
        this.f3477a.b(r1);
        int r3 = 0;
    L3:
        r3 = r1.nextSetBit(r3 + 1);
        if (r3 < 0) goto L6;
        r4[r3].or(r0);
        goto L3
    }

    @Override // com.ctc.wstx.d.af
    public void b(BitSet r1) {
        this.f3477a.b(r1);
    }

    @Override // com.ctc.wstx.d.af
    public boolean b() {
        return true;
    }

    public String toString() {
        return this.f3477a.toString() + "*";
    }
}
