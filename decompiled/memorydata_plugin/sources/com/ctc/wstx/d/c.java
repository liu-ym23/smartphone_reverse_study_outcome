package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    af f3486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    af f3487b;
    final boolean c;
    BitSet d;
    BitSet e;

    public c(af r1, af r2) {
        this.f3486a = r1;
        this.f3487b = r2;
        if (r1.b() == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.c = r3;
        return;
    L5:
        if (this.f3487b.b() == false) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.ctc.wstx.d.af
    public af a() {
        return new c(this.f3486a.a(), this.f3487b.a());
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet r3) {
        if (this.d != null) goto L7;
        BitSet r0 = new BitSet();
        this.d = r0;
        this.f3486a.a(r0);
        if (this.f3486a.b() == false) goto L7;
        this.f3487b.a(this.d);
    L7:
        r3.or(this.d);
    }

    @Override // com.ctc.wstx.d.af
    public void a(List<an> r3) {
        List<an> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f3486a.a(r4);
        this.f3487b.a(r4);
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet[] r4) {
        this.f3486a.a(r4);
        this.f3487b.a(r4);
        BitSet r0 = new BitSet();
        this.f3487b.a(r0);
        BitSet r1 = new BitSet();
        this.f3486a.b(r1);
        int r3 = 0;
    L3:
        r3 = r1.nextSetBit(r3 + 1);
        if (r3 < 0) goto L6;
        r4[r3].or(r0);
        goto L3
    }

    @Override // com.ctc.wstx.d.af
    public void b(BitSet r3) {
        if (this.e != null) goto L7;
        BitSet r0 = new BitSet();
        this.e = r0;
        this.f3487b.b(r0);
        if (this.f3487b.b() == false) goto L7;
        this.f3486a.b(this.e);
    L7:
        r3.or(this.e);
    }

    @Override // com.ctc.wstx.d.af
    public boolean b() {
        return this.c;
    }

    public String toString() {
        return '(' + this.f3486a.toString() + ", " + this.f3487b.toString() + ')';
    }
}
