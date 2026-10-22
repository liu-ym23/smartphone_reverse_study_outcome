package com.ctc.wstx.shaded.msv_core.reader.trex.ng;

import com.ctc.wstx.shaded.msv.relaxng_datatype.b;
import com.ctc.wstx.shaded.msv.relaxng_datatype.c;
import com.ctc.wstx.shaded.msv_core.reader.trex.a;
import com.ctc.wstx.shaded.msv_core.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes2.dex */
public class RELAXNGReader extends a {
    protected static com.ctc.wstx.shaded.msv.org_isorelax.verifier.a h;
    protected String i;
    private c j;
    private b k;
    private final com.ctc.wstx.shaded.msv_core.util.b l;
    private final com.ctc.wstx.shaded.msv_core.util.b m;

    /* JADX INFO: renamed from: com.ctc.wstx.shaded.msv_core.reader.trex.ng.RELAXNGReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AbortException extends Exception {
        private AbortException() {
        }

        /* synthetic */ AbortException(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.trex.a, com.ctc.wstx.shaded.msv_core.reader.d
    public String a(String r2, Object[] r3) {
        return MessageFormat.format(ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.reader.trex.ng.Messages").getString(r2), r3);
    L6:
        return super.a(r2, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.d
    public boolean a(com.ctc.wstx.shaded.msv_core.util.c r2) {
        if ("http://relaxng.org/ns/structure/1.0".equals(r2.f3641a) == false) goto L5;
    L8:
        return true;
    L5:
        if ("http://relaxng.org/ns/structure/0.9".equals(r2.f3641a) == true) goto L8;
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.d, com.ctc.wstx.shaded.msv.relaxng_datatype.e
    public String a_(String r2) {
        if (r2.equals("") == false) goto L7;
        return this.g;
    L7:
        return super.a_(r2);
    }

    public b e(String r3) {
        b r0 = this.j.a(r3);     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        return r0;
    L5:
        a("TREXGrammarReader.UnknownDataTypeVocabulary", r3);     // Catch: Throwable -> L7
    L10:
        return com.ctc.wstx.shaded.msv_core.datatype.b.f3553a;
    L7:
        th = move-exception;
        a("RELAXNGReader.UnknownDatatypeVocabulary1", r3, th.toString());
        goto L10
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endDocument() {
        super.endDocument();
        this.k = (b) ZeusTransformUtils.preCheckCast(this.l.a(), b.class, "com.obric.memorydata.plugin");
        this.i = (String) ZeusTransformUtils.preCheckCast(this.m.a(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.trex.a, org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endElement(String r1, String r2, String r3) {
        super.endElement(r1, r2, r3);
        this.k = (b) ZeusTransformUtils.preCheckCast(this.l.a(), b.class, "com.obric.memorydata.plugin");
        this.i = (String) ZeusTransformUtils.preCheckCast(this.m.a(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startDocument() {
        this.l.a(this.k);
        this.m.a(this.i);
        this.k = e("");
        this.i = "";
        super.startDocument();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.trex.a, org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startElement(String r4, String r5, String r6, Attributes r7) {
        Attributes r8 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r7, Attributes.class, "com.obric.memorydata.plugin");
        this.l.a(this.k);
        this.m.a(this.i);
        if (r8.getIndex("datatypeLibrary") == (-1)) goto L10;
        String r0 = r8.getValue("datatypeLibrary");
        this.i = r0;
        this.k = null;
        if (f.a(r0) == true) goto L8;
        a("RELAXNGReader.NotAbsoluteURI", this.i);
    L8:
        if (this.i.indexOf(35) < 0) goto L10;
        a("GrammarReader.FragmentIdentifier", this.i);
    L10:
        super.startElement(r4, r5, r6, r8);
    }
}
