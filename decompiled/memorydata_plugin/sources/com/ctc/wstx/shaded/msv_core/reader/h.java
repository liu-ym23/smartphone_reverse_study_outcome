package com.ctc.wstx.shaded.msv_core.reader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.AttributesImpl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends i {
    public h() {
    }

    public abstract i a(com.ctc.wstx.shaded.msv_core.util.c r1);

    public void a() {
    }

    public boolean b(com.ctc.wstx.shaded.msv_core.util.c r1) {
        return this.f3622b.a(r1);
    }

    @Override // org.xml.sax.ContentHandler
    public final void endDocument() {
        a();
        this.f3622b.a();
    }

    @Override // org.xml.sax.ContentHandler
    public final void endElement(String r1, String r2, String r3) {
        Locator r4 = this.f3622b.c();
        this.f3622b.a(this.d);     // Catch: Throwable -> L6
        a();     // Catch: Throwable -> L6
        this.f3622b.a(r4);
        this.f3622b.a();
        return;
    L6:
        th = move-exception;
        this.f3622b.a(r4);
        throw th;
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String r3, String r4, String r5, Attributes r6) {
        com.ctc.wstx.shaded.msv_core.util.c r0 = new com.ctc.wstx.shaded.msv_core.util.c(r3, r4, r5, new AttributesImpl((Attributes) ZeusTransformUtils.wrapperContextForParams(r6, Attributes.class, "com.obric.memorydata.plugin")));
        if (b(r0) == false) goto L10;
        i r7 = a(r0);
        if (r7 == null) goto L8;
        this.f3622b.a(r7, this, r0);
        return;
    L8:
        this.f3622b.a("GrammarReader.MalplacedElement", r0.c);
    L12:
        this.f3622b.a(new g(), this, r0);
        return;
    L10:
        if (this.f3621a != null) goto L12;
        this.f3622b.a("GrammarReader.MalplacedElement", r0.c);
        this.f3622b.a("GrammarReader.Warning.MaybeWrongNamespace", r0.f3641a);
        goto L12
    }
}
