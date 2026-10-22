package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class f extends h {
    public f() {
    }

    public int a(String r5) {
        StringTokenizer r0 = new StringTokenizer(r5);
        int r1 = 0;
    L4:
        if (r0.hasMoreTokens() == false) goto L19;
        String r2 = r0.nextToken();
        if (r2.equals("#all") == true) goto L7;
        if (r2.equals("restriction") == true) goto L10;
        if (r2.equals(Constants.KEY_LIST) == true) goto L13;
        if (r2.equals("union") == false) goto L17;
        r1 = r1 | 4;
        goto L4
    L17:
        this.f3622b.a("GrammarReader.IllegalFinalValue", r2);
        return 0;
    L13:
        r1 = r1 | 2;
        goto L4
    L10:
        r1 = r1 | 1;
        goto L4
    L7:
        r1 = r1 | 7;
        goto L4
    L19:
        return r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.h
    public XSDatatypeExp a(XSDatatypeExp r3) {
        String r0 = this.c.a("final");
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r3.createFinalizedType(a(r0), this.f3622b);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.h
    public com.ctc.wstx.shaded.msv_core.reader.i a(com.ctc.wstx.shaded.msv_core.util.c r5) {
        if (this.c.f3641a.equals(r5.f3641a) == true) goto L5;
        return null;
    L5:
        String r0 = this.c.a(ActivityLifecycle.NAME);
        String r4 = d();
        if (r5.f3642b.equals("annotation") == false) goto L10;
        return new com.ctc.wstx.shaded.msv_core.reader.g();
    L10:
        if (r5.f3642b.equals("restriction") == false) goto L14;
        return new e(r4, r0);
    L14:
        if (r5.f3642b.equals(Constants.KEY_LIST) == false) goto L18;
        return new d(r4, r0);
    L18:
        if (r5.f3642b.equals("union") == true) goto L20;
        return null;
    L20:
        return new i(r4, r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.g, com.ctc.wstx.shaded.msv_core.reader.h
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.h, com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.l
    public /* bridge */ /* synthetic */ void b(XSDatatypeExp r1) {
        super.b(r1);
    }
}
