package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final XSDatatypeExp f3615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ctc.wstx.shaded.msv_core.reader.d f3616b;
    private final List c;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f3619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f3620b;
        boolean c;
        com.ctc.wstx.shaded.msv.relaxng_datatype.e d;
        final /* synthetic */ c e;

        public a(c r3, String r4, String r5, boolean r6, com.ctc.wstx.shaded.msv.relaxng_datatype.e r7) {
            com.ctc.wstx.shaded.msv.relaxng_datatype.e r8 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r7, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
            this.e = r3;
            this.f3619a = r4;
            this.f3620b = r5;
            this.c = r6;
            this.d = r8;
        }
    }

    public c(XSDatatypeExp r2, com.ctc.wstx.shaded.msv_core.reader.d r3) {
        this.c = new LinkedList();
        this.f3615a = r2;
        this.f3616b = r3;
    }

    static /* synthetic */ XSDatatypeExp a(c r0) {
        return r0.f3615a;
    }

    static /* synthetic */ List b(c r0) {
        return r0.c;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.k
    public XSDatatypeExp a(final String r5, final String r6) {
        final int r0 = this.c.size();
        if (r0 != 0) goto L7;
        return this.f3615a;
    L7:
        return new XSDatatypeExp(r5, r6, this.f3616b, new AnonymousClass1(this, r0, r5, r6));
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.k
    public void a(String r8, String r9, boolean r10, com.ctc.wstx.shaded.msv.relaxng_datatype.e r11) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r11, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        this.c.add(new a(this, r8, r9, r10, r5));
    }
}
