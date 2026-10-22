package com.ctc.wstx.shaded.msv_core.reader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements ContentHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected i f3621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f3622b;
    protected com.ctc.wstx.shaded.msv_core.util.c c;
    protected Locator d;
    protected String e;

    public i() {
    }

    public final void a(d r4, i r5, com.ctc.wstx.shaded.msv_core.util.c r6) {
        this.f3622b = r4;
        this.f3621a = r5;
        this.c = r6;
        if (r4.c() == null) goto L6;
        this.d = new LocatorImpl(r4.c());
    L6:
        if (r6 == null) goto L8;
        String r7 = r6.a("http://www.w3.org/XML/1998/namespace", "base");
    L9:
        if (r5 != null) goto L11;
        this.e = null;
    L14:
        if (r7 == null) goto L16;
        this.e = r4.a(this.e, r7);
    L16:
        c();
        return;
    L11:
        String r8 = r5.e;
        this.e = r8;
        if (r8 != null) goto L14;
        this.e = r4.c().getSystemId();
        goto L14
    L8:
        r7 = null;
        goto L9
    }

    public void c() {
    }

    public Locator c_() {
        return this.d;
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] r4, int r5, int r6) {
        int r0 = r5;
    L3:
        if (r0 >= r6) goto L15;
        char r1 = r4[r0];
        if (r1 == '\t') goto L14;
        if (r1 == '\n') goto L14;
        if (r1 == '\r') goto L14;
        if (r1 == ' ') goto L14;
        this.f3622b.a("GrammarReader.Characters", new String(r4, r5, r6).trim());
        return;
    L14:
        r0 = r0 + 1;
        goto L3
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String r1) {
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] r1, int r2, int r3) {
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String r1, String r2) {
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator r2) {
        Locator r1 = (Locator) ZeusTransformUtils.wrapperContextForParams(r2, Locator.class, "com.obric.memorydata.plugin");
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String r1) {
    }

    @Override // org.xml.sax.ContentHandler
    public final void startDocument() {
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String r1, String r2) {
    }
}
