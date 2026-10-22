package com.ctc.wstx.shaded.msv_core.verifier.psvi;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.util.c;
import com.ctc.wstx.shaded.msv_core.util.d;
import com.ctc.wstx.shaded.msv_core.verifier.ValidityViolation;
import com.ctc.wstx.shaded.msv_core.verifier.a.i;
import com.ctc.wstx.shaded.msv_core.verifier.a.p;
import com.ctc.wstx.shaded.msv_core.verifier.a.r;
import com.ctc.wstx.shaded.msv_core.verifier.b;
import com.ctc.wstx.shaded.msv_core.verifier.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.StringTokenizer;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public class TypeDetector extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f3685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuffer f3686b;
    private final com.ctc.wstx.shaded.msv_core.util.a o;

    public class AmbiguousDocumentException extends SAXException {
        final /* synthetic */ TypeDetector this$0;

        public AmbiguousDocumentException(TypeDetector r1) {
            this.this$0 = r1;
            super("");
        }

        Locator getLocation() {
            return this.this$0.a();
        }
    }

    private void a(String r5, com.ctc.wstx.shaded.msv.relaxng_datatype.a[] r6) {
        if (r6 == null) goto L19;
        int r0 = r6.length;
        if (r0 == 0) goto L21;
        int r1 = 0;
        if (r0 == 1) goto L16;
        StringTokenizer r2 = new StringTokenizer(r5);
    L9:
        if (r1 >= r6.length) goto L12;
        this.f3685a.a(r2.nextToken(), r6[r1]);
        r1 = r1 + 1;
        goto L9
    L12:
        if (r2.hasMoreTokens() == true) goto L15;
        return;
    L15:
        throw new Error();
    L16:
        this.f3685a.a(r5, r6[0]);
        return;
    L21:
        return;
    L19:
        throw new AmbiguousDocumentException(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f
    public void a(c r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        this.f3685a.a(r3.f3641a, r3.f3642b, r3.c);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f
    public com.ctc.wstx.shaded.msv.relaxng_datatype.a[] a(b r9, String r10, String r11, String r12, String r13) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.memorydata.plugin");
        this.f3685a.b(r10, r11, r12);
        com.ctc.wstx.shaded.msv.relaxng_datatype.a[] r14 = super.a(r3, r10, r11, r12, r13);
        a(r13, r14);
        this.f3685a.a(r10, r11, r12, ((p) ZeusTransformUtils.preCheckCast(this.m, p.class, "com.obric.memorydata.plugin")).j.f);
        return r14;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f
    public void c() {
        if (this.f3686b.length() == 0) goto L9;
        String r0 = new String(this.f3686b);
        if (this.i.a(r0, this, null, this.o) == true) goto L7;
        d r1 = new d();
        this.i.a(r0, this, r1, null);
        this.k.error(new ValidityViolation(this.c, a("Verifier.Error.UnexpectedText", null), new com.ctc.wstx.shaded.msv_core.verifier.d.c(r0)));
    L7:
        a(r0, this.o.f3638a);
        this.f3686b = new StringBuffer();
        return;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f, org.xml.sax.ContentHandler
    public void characters(char[] r1, int r2, int r3) {
        this.f3686b.append(r1, r2, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f, org.xml.sax.ContentHandler
    public void endDocument() {
        super.endDocument();
        this.f3685a.a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f, com.ctc.wstx.shaded.msv_core.verifier.a, org.xml.sax.ContentHandler
    public void endElement(String r4, String r5, String r6) {
        b r0 = this.i;
        super.endElement(r4, r5, r6);
        if (ZeusTransformUtils.instanceOf(r0, r.class) == false) goto L6;
        ElementExp r1 = ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).f3673b;
    L10:
        this.f3685a.a(r4, r5, r6, r1);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, i.class) == false) goto L15;
        ElementExp[] r2 = ((i) ZeusTransformUtils.preCheckCast(r0, i.class, "com.obric.memorydata.plugin")).b();
        if (r2.length != 1) goto L13;
        r1 = r2[0];
        goto L10
    L13:
        throw new AmbiguousDocumentException(this);
    L15:
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] r1, int r2, int r3) {
        this.f3686b.append(r1, r2, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f, org.xml.sax.ContentHandler
    public void startDocument() {
        super.startDocument();
        this.f3685a.a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.f, com.ctc.wstx.shaded.msv_core.verifier.a, org.xml.sax.ContentHandler
    public void startElement(String r3, String r4, String r5, Attributes r6) {
        super.startElement(r3, r4, r5, (Attributes) ZeusTransformUtils.wrapperContextForParams(r6, Attributes.class, "com.obric.memorydata.plugin"));
        this.f3685a.b();
    }
}
