package com.ctc.wstx.shaded.msv_core.verifier;

import com.ctc.wstx.shaded.msv_core.grammar.g;
import com.ctc.wstx.shaded.msv_core.verifier.a.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.NamespaceSupport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements g, ContentHandler, DTDHandler {
    protected static final Locator d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f3647b;
    protected Locator c;
    protected boolean e;
    protected final Map f;
    protected final Set g;
    protected final NamespaceSupport h;
    private final Set i;

    static {
        d = new LocatorImpl();
    }

    public a() {
        this.c = d;
        this.e = true;
        this.f = new HashMap();
        this.g = new HashSet();
        this.f3646a = false;
        this.h = new NamespaceSupport();
        this.f3647b = new HashSet();
        this.i = new HashSet();
    }

    public final Locator a() {
        return this.c;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.g
    public void a(com.ctc.wstx.shaded.msv.relaxng_datatype.a r4, u r5) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.a r6 = (com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin");
        if (this.e == true) goto L5;
        return;
    L5:
        int r7 = r6.getIdType();
        if (r7 != 1) goto L14;
        String r8 = r5.f3677b.trim();
        u r0 = (u) ZeusTransformUtils.preCheckCast(this.f.get(r8), u.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        this.f.put(r8, r5);
        return;
    L10:
        if (r0 == r5) goto L28;
        c(r8);
        return;
    L28:
        return;
    L14:
        if (r7 != 2) goto L18;
        this.g.add(r5.f3677b.trim());
        return;
    L18:
        if (r7 != 3) goto L25;
        StringTokenizer r9 = new StringTokenizer(r5.f3677b);
    L21:
        if (r9.hasMoreTokens() == false) goto L23;
        this.g.add(r9.nextToken());
        goto L21
    L23:
        return;
    L25:
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.e
    public String a_(String r1) {
        String r0 = this.h.getURI(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r1.length() != 0) goto L9;
        return "";
    L9:
        return r0;
    }

    public void b() {
        this.f.clear();
        this.g.clear();
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.e
    public boolean b(String r1) {
        return this.f3647b.contains(r1);
    }

    public abstract void c(String r1);

    @Override // org.xml.sax.ContentHandler
    public void endElement(String r1, String r2, String r3) {
        this.h.popContext();
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String r1) {
    }

    @Override // org.xml.sax.DTDHandler
    public void notationDecl(String r1, String r2, String r3) {
        this.i.add(r1);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String r1, String r2) {
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator r3) {
        this.c = (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin");
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String r1) {
    }

    public void startElement(String r1, String r2, String r3, Attributes r4) {
        Attributes r5 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r4, Attributes.class, "com.obric.memorydata.plugin");
        if (this.f3646a == true) goto L5;
        this.h.pushContext();
    L5:
        this.f3646a = false;
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String r2, String r3) {
        if (this.f3646a == true) goto L5;
        this.h.pushContext();
        this.f3646a = true;
    L5:
        this.h.declarePrefix(r2, r3);
    }

    @Override // org.xml.sax.DTDHandler
    public void unparsedEntityDecl(String r1, String r2, String r3, String r4) {
        this.f3647b.add(r1);
    }
}
