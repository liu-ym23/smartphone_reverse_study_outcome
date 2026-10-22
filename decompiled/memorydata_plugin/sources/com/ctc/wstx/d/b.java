package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final af[] f3484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f3485b;
    BitSet c;
    BitSet d;

    public b(af[] r5) {
        boolean r0 = false;
        this.f3485b = false;
        this.f3484a = r5;
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (r5[r2].b() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r0 = true;
    L8:
        this.f3485b = r0;
    }

    @Override // com.ctc.wstx.d.af
    public af a() {
        int r0 = this.f3484a.length;
        af[] r1 = new af[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = this.f3484a[r2].a();
        r2 = r2 + 1;
        goto L3
    L6:
        return new b(r1);
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet r5) {
        if (this.c != null) goto L7;
        this.c = new BitSet();
        int r0 = 0;
        int r1 = this.f3484a.length;
    L5:
        if (r0 >= r1) goto L7;
        this.f3484a[r0].a(this.c);
        r0 = r0 + 1;
    L7:
        r5.or(this.c);
    }

    @Override // com.ctc.wstx.d.af
    public void a(List<an> r4) {
        List<an> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = this.f3484a.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.f3484a[r1].a(r5);
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet[] r4) {
        int r0 = this.f3484a.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.f3484a[r1].a(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.ctc.wstx.d.af
    public void b(BitSet r5) {
        if (this.d != null) goto L7;
        this.d = new BitSet();
        int r0 = 0;
        int r1 = this.f3484a.length;
    L5:
        if (r0 >= r1) goto L7;
        this.f3484a[r0].b(this.d);
        r0 = r0 + 1;
    L7:
        r5.or(this.d);
    }

    @Override // com.ctc.wstx.d.af
    public boolean b() {
        return this.f3485b;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= this.f3484a.length) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(" | ");
    L7:
        r0.append(this.f3484a[r1].toString());
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append(')');
        return r0.toString();
    }
}
