package com.ctc.wstx.shaded.msv_core.relaxns.verifier;

import com.ctc.wstx.shaded.msv.org_isorelax.a.e;
import com.ctc.wstx.shaded.msv.org_isorelax.a.f;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.relax.AnyOtherElementExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes2.dex */
public class a extends DefaultHandler implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.ctc.wstx.shaded.msv.org_isorelax.a.c f3633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Locator f3634b;
    private final AnyOtherElementExp[] c;

    public a(AnyOtherElementExp[] r1) {
        this.c = r1;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator r3) {
        this.f3634b = (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String r5, String r6, String r7, Attributes r8) {
        Attributes r9 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r8, Attributes.class, "com.obric.memorydata.plugin");
        e r0 = this.f3633a.b().a(r5);
        if (r0 == null) goto L6;
        f r1 = r0.createNewVerifier(r5, r0.getElementDecls());
        this.f3633a.a(r1);
        r1.startElement(r5, r6, r7, r9);
        return;
    L6:
        int r10 = 0;
        boolean r2 = false;
    L7:
        AnyOtherElementExp[] r3 = this.c;
        if (r10 >= r3.length) goto L16;
        if (r3[r10] == null) goto L15;
        if (r3[r10].getNameClass().accepts(r5, r6) == false) goto L14;
        r2 = true;
        goto L15
    L14:
        this.c[r10] = null;
    L15:
        r10 = r10 + 1;
        goto L7
    L16:
        if (r2 == true) goto L23;
        this.f3633a.a().error(new SAXParseException(b.a("AnyOtherElementVerifier.UnexpectedNamespace", new Object[]{r5}), this.f3634b));
        return;
    }
}
