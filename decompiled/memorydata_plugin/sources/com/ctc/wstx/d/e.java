package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f3488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f3489b;
    BitSet c;
    HashMap<com.ctc.wstx.util.h, e> d;

    public e(int r2, BitSet r3) {
        this.d = new HashMap();
        this.f3488a = r2;
        this.f3489b = r3.get(0);
        this.c = r3;
    }

    public static e a(d r9) {
        af r10 = r9.b();
        an r0 = an.c();
        c r1 = new c(r10, r0);
        ArrayList r11 = new ArrayList();
        r11.add(r0);
        r1.a(r11);
        int r2 = r11.size();
        BitSet[] r3 = new BitSet[r2];
        com.ctc.wstx.util.h[] r4 = new com.ctc.wstx.util.h[r2];
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r6 >= r2) goto L6;
        r3[r6] = new BitSet(r2);
        r4[r6] = ((an) ZeusTransformUtils.preCheckCast(r11.get(r6), an.class, "com.obric.memorydata.plugin")).d();
        r6 = r6 + 1;
        goto L4
    L6:
        r1.a(r3);
        BitSet r12 = new BitSet(r2);
        r1.a(r12);
        e r7 = new e(0, r12);
        ArrayList r8 = new ArrayList();
        r8.add(r7);
        HashMap r13 = new HashMap();
        r13.put(r12, r7);
    L8:
        if (r5 >= r8.size()) goto L10;
        ((e) ZeusTransformUtils.preCheckCast(r8.get(r5), e.class, "com.obric.memorydata.plugin")).a(r4, r3, r8, r13);
        r5 = r5 + 1;
        goto L8
    L10:
        return r7;
    }

    public e a(com.ctc.wstx.util.h r2) {
        return (e) ZeusTransformUtils.preCheckCast(this.d.get(r2), e.class, "com.obric.memorydata.plugin");
    }

    public void a(com.ctc.wstx.util.h[] r8, BitSet[] r9, List<e> r10, Map<BitSet, e> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        BitSet r0 = (BitSet) ZeusTransformUtils.preCheckCast(this.c.clone(), BitSet.class, "com.obric.memorydata.plugin");
        this.c = null;
        int r2 = -1;
    L3:
        r2 = r0.nextSetBit(r2 + 1);
        if (r2 < 0) goto L18;
        com.ctc.wstx.util.h r3 = r8[r2];
        if (r3 == null) goto L3;
        BitSet r4 = (BitSet) ZeusTransformUtils.preCheckCast(r9[r2].clone(), BitSet.class, "com.obric.memorydata.plugin");
        int r5 = r2;
    L9:
        r5 = r0.nextSetBit(r5 + 1);
        if (r5 <= 0) goto L14;
        if (r8[r5] != r3) goto L9;
        r0.clear(r5);
        r4.or(r9[r5]);
        goto L9
    L14:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r13.get(r4), e.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L17;
        r6 = new e(r12.size(), r4);
        r12.add(r6);
        r13.put(r4, r6);
    L17:
        this.d.put(r3, r6);
        goto L3
    }

    public boolean a() {
        return this.f3489b;
    }

    public int b() {
        return this.f3488a;
    }

    public TreeSet<com.ctc.wstx.util.h> c() {
        TreeSet<com.ctc.wstx.util.h> r0 = new TreeSet();
        Iterator<com.ctc.wstx.util.h> r4 = this.d.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add((com.ctc.wstx.util.h) ZeusTransformUtils.preCheckCast(r4.next(), com.ctc.wstx.util.h.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("State #" + this.f3488a + ":\n");
        r0.append("  Accepting: " + this.f3489b);
        r0.append("\n  Next states:\n");
        Iterator<Map.Entry<com.ctc.wstx.util.h, e>> r4 = this.d.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.append(r1.getKey());
        r0.append(" -> ");
        r0.append(((e) ZeusTransformUtils.preCheckCast(r1.getValue(), e.class, "com.obric.memorydata.plugin")).b());
        r0.append("\n");
        goto L4
    L7:
        return r0.toString();
    }
}
