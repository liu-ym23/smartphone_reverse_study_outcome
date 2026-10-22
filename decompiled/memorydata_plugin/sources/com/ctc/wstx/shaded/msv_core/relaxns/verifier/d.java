package com.ctc.wstx.shaded.msv_core.relaxns.verifier;

import com.ctc.wstx.shaded.msv_core.relaxns.grammar.ExternalElementExp;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.relax.AnyOtherElementExp;
import com.ctc.wstx.shaded.msv_core.verifier.a.i;
import com.ctc.wstx.shaded.msv_core.verifier.a.r;
import com.ctc.wstx.shaded.msv_core.verifier.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes2.dex */
class d extends f implements com.ctc.wstx.shaded.msv.org_isorelax.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.ctc.wstx.shaded.msv.org_isorelax.a.c f3636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Map f3637b;
    private String o;
    private String p;
    private String q;
    private Set r;

    d(c r2) {
        super(null, null);
        this.f3637b = new HashMap();
        this.i = r2;
    }

    public void a(ExternalElementExp[] r7, String r8, String r9, String r10, Attributes r11) {
        Attributes r12 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r11, Attributes.class, "com.obric.memorydata.plugin");
        this.o = r8;
        this.p = r9;
        this.q = r10;
        int r0 = r7.length;
        com.ctc.wstx.shaded.msv.org_isorelax.a.d[] r1 = new com.ctc.wstx.shaded.msv.org_isorelax.a.d[r0];
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L7;
        r1[r2] = r7[r2].rule;
        this.f3637b.put(r1[r2], r7[r2]);
        r2 = r2 + 1;
        goto L4
    L7:
        if (this.f3637b.size() != r0) goto L11;
        com.ctc.wstx.shaded.msv.org_isorelax.a.f r13 = this.f3636a.b().a(r8).createNewVerifier(r8, r1);
        this.f3636a.a(r13);
        r13.startElement(r8, r9, r10, r12);
        return;
    L11:
        throw new Error();
    }

    public void a(AnyOtherElementExp[] r5, String r6, String r7, String r8, Attributes r9) {
        Attributes r10 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r9, Attributes.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        this.f3637b.put(r5[r0], r5[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        a r1 = new a(r5);
        this.f3636a.a(r1);
        this.o = r6;
        this.p = r7;
        this.q = r8;
        r1.startElement(r6, r7, r8, r10);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a, com.ctc.wstx.shaded.msv.relaxng_datatype.e
    public boolean b(String r5) {
        if (this.r != null) goto L8;
        this.r = new HashSet();
        int r0 = this.f3636a.c();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L8;
        this.r.add(this.f3636a.a(r1).f3548a);
        r1 = r1 + 1;
    L8:
        return this.r.contains(r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f, com.ctc.wstx.shaded.msv_core.verifier.a, org.xml.sax.ContentHandler
    public void startElement(String r9, String r10, String r11, Attributes r12) {
        Attributes r7 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r12, Attributes.class, "com.obric.memorydata.plugin");
        super.startElement(r9, r10, r11, r7);
        int r0 = 0;
        if (ZeusTransformUtils.instanceOf(this.i, r.class) == false) goto L13;
        r r13 = (r) ZeusTransformUtils.preCheckCast(this.i, r.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13.f3673b, ExternalElementExp.class) == false) goto L9;
        a(new ExternalElementExp[]{(ExternalElementExp) ZeusTransformUtils.preCheckCast(r13.f3673b, ExternalElementExp.class, "com.obric.memorydata.plugin")}, r9, r10, r11, r7);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r13.f3673b, AnyOtherElementExp.class) == false) goto L45;
        a(new AnyOtherElementExp[]{(AnyOtherElementExp) ZeusTransformUtils.preCheckCast(r13.f3673b, AnyOtherElementExp.class, "com.obric.memorydata.plugin")}, r9, r10, r11, r7);
        return;
    L45:
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(this.i, i.class) == false) goto L38;
        i r14 = (i) ZeusTransformUtils.preCheckCast(this.i, i.class, "com.obric.memorydata.plugin");
        Vector r1 = null;
        int r2 = 0;
    L16:
        if (r2 >= r14.f3658a.length) goto L23;
        if (ZeusTransformUtils.instanceOf(r14.f3658a[r2], ExternalElementExp.class) == false) goto L22;
        if (r1 != null) goto L21;
        r1 = new Vector();
    L21:
        r1.add(r14.f3658a[r2]);
    L22:
        r2 = r2 + 1;
        goto L16
    L23:
        if (r1 == null) goto L27;
        ExternalElementExp[] r3 = new ExternalElementExp[r1.size()];
        r1.toArray(r3);
        a(r3, r9, r10, r11, r7);
        return;
    L27:
        if (r0 >= r14.f3658a.length) goto L34;
        if (ZeusTransformUtils.instanceOf(r14.f3658a[r0], AnyOtherElementExp.class) == false) goto L33;
        if (r1 != null) goto L32;
        r1 = new Vector();
    L32:
        r1.add(r14.f3658a[r0]);
    L33:
        r0 = r0 + 1;
        goto L27
    L34:
        if (r1 == null) goto L46;
        AnyOtherElementExp[] r4 = new AnyOtherElementExp[r1.size()];
        r1.toArray(r4);
        a(r4, r9, r10, r11, r7);
        return;
    L46:
        return;
    L38:
        throw new Error();
    }
}
