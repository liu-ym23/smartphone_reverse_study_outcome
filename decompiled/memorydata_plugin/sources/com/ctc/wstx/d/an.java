package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class an extends af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final an f3482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.ctc.wstx.util.h f3483b;
    int c;

    static {
        an r0 = new an(null);
        f3482a = r0;
        r0.c = 0;
    }

    public an(com.ctc.wstx.util.h r2) {
        this.c = -1;
        this.f3483b = r2;
    }

    public static an c() {
        return f3482a;
    }

    @Override // com.ctc.wstx.d.af
    public af a() {
        return new an(this.f3483b);
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet r1) {
        r1.set(this.c);
    }

    @Override // com.ctc.wstx.d.af
    public void a(List<an> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (this == f3482a) goto L6;
        this.c = r4.size();
        r4.add(this);
        return;
    }

    @Override // com.ctc.wstx.d.af
    public void a(BitSet[] r1) {
    }

    @Override // com.ctc.wstx.d.af
    public void b(BitSet r1) {
        r1.set(this.c);
    }

    @Override // com.ctc.wstx.d.af
    public boolean b() {
        return false;
    }

    public com.ctc.wstx.util.h d() {
        return this.f3483b;
    }

    public String toString() {
        com.ctc.wstx.util.h r0 = this.f3483b;
        if (r0 != null) goto L6;
        return "[null]";
    L6:
        return r0.toString();
    }
}
