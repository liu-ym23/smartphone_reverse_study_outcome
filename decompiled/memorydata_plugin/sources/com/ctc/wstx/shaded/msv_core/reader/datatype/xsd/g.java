package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

/* JADX INFO: loaded from: classes2.dex */
abstract class g extends com.ctc.wstx.shaded.msv_core.reader.h {
    g() {
    }

    private l g() {
        if (ZeusTransformUtils.instanceOf(this.f3621a, l.class) == true) goto L5;
        return null;
    L5:
        return (l) ZeusTransformUtils.preCheckCast(this.f3621a, l.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.h
    public void a() {
        super.a();
        XSDatatypeExp r0 = e();
        if (ZeusTransformUtils.instanceOf(this.f3621a, l.class) == false) goto L7;
        ((l) ZeusTransformUtils.preCheckCast(this.f3621a, l.class, "com.obric.memorydata.plugin")).b(r0);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(this.f3621a, com.ctc.wstx.shaded.msv_core.reader.datatype.b.class) == false) goto L11;
        ((com.ctc.wstx.shaded.msv_core.reader.datatype.b) ZeusTransformUtils.preCheckCast(this.f3621a, com.ctc.wstx.shaded.msv_core.reader.datatype.b.class, "com.obric.memorydata.plugin")).a(r0, r0.name);
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(this.f3621a, com.ctc.wstx.shaded.msv_core.reader.c.class) == false) goto L15;
        ((com.ctc.wstx.shaded.msv_core.reader.c) ZeusTransformUtils.preCheckCast(this.f3621a, com.ctc.wstx.shaded.msv_core.reader.c.class, "com.obric.memorydata.plugin")).a(r0);
        return;
    L15:
        throw new Error(this.f3621a.getClass().getName() + " doesn't implement any of TypeOwner");
    }

    public final String d() {
        if (g() != null) goto L5;
        return "";
    L5:
        return g().d();
    }

    XSDatatypeExp e() {
        return f();
    L4:
        e = move-exception;
        this.f3622b.a(e, "GrammarReader.BadType");
        return new XSDatatypeExp(StringType.theInstance, this.f3622b.c);
    }

    public abstract XSDatatypeExp f();

    @Override // com.ctc.wstx.shaded.msv_core.reader.h, org.xml.sax.ContentHandler
    public final void startElement(String r3, String r4, String r5, Attributes r6) {
        com.ctc.wstx.shaded.msv_core.util.c r0 = new com.ctc.wstx.shaded.msv_core.util.c(r3, r4, r5, new AttributesImpl((Attributes) ZeusTransformUtils.wrapperContextForParams(r6, Attributes.class, "com.obric.memorydata.plugin")));
        com.ctc.wstx.shaded.msv_core.reader.i r7 = a(r0);
        if (r7 == null) goto L6;
        this.f3622b.a(r7, this, r0);
        return;
    L6:
        this.f3622b.a("GrammarReader.MalplacedElement", r0.c);
        this.f3622b.a(new com.ctc.wstx.shaded.msv_core.reader.g(), this, r0);
    }
}
