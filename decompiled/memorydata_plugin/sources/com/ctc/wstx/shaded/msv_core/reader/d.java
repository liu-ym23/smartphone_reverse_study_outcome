package com.ctc.wstx.shaded.msv_core.reader;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.AnyURIType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.DurationType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.GDayType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.GMonthDayType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.GMonthType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.GYearMonthType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.GYearType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.NormalizedStringType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.NumberType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.XSDatatypeExp;
import com.ctc.wstx.shaded.msv_core.verifier.a.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Map;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends XMLFilterImpl implements com.ctc.wstx.shaded.msv_core.grammar.g {
    public static final b d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ctc.wstx.shaded.msv_core.reader.b f3602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SAXParserFactory f3603b;
    public final ExpressionPool c;
    public b e;
    private Locator f;
    private final Map g;
    private final Vector h;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f3604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3605b;
        public final String c;
        final /* synthetic */ d d;

        public a(d r1, String r2, String r3) {
            this.d = r1;
            this.f3605b = r2;
            this.c = r3;
            this.f3604a = r1.e;
        }

        @Override // com.ctc.wstx.shaded.msv_core.reader.d.b
        public String a(String r2) {
            if (r2.equals(this.f3605b) == false) goto L7;
            return this.c;
        L7:
            return this.f3604a.a(r2);
        }
    }

    public interface b {
        String a(String r1);
    }

    static {
        d = new AnonymousClass1();
    }

    private Locator[] a(Locator[] r5) {
        int r0 = 0;
        if (r5 == null) goto L23;
        int r4 = 0;
        int r1 = 0;
    L6:
        if (r4 >= r5.length) goto L12;
        if (r5[r4] == null) goto L10;
        r1 = r1 + 1;
    L10:
        r4 = r4 + 1;
        goto L6
    L12:
        if (r5.length != r1) goto L14;
        return r5;
    L14:
        Locator[] r6 = new Locator[r1];
        int r2 = 0;
    L16:
        if (r0 >= r5.length) goto L21;
        if (r5[r0] == null) goto L20;
        r6[r2] = r5[r0];
        r2 = r2 + 1;
    L20:
        r0 = r0 + 1;
        goto L16
    L21:
        return r6;
    L23:
        if (c() == null) goto L27;
        return new Locator[]{c()};
    L27:
        return new Locator[0];
    }

    public final String a(String r1, String r2) {
        return com.ctc.wstx.shaded.msv_core.util.e.a(r1, r2);
    }

    public abstract String a(String r1, Object[] r2);

    public Locator a(Object r2) {
        return (Locator) ZeusTransformUtils.preCheckCast(this.g.get(r2), Locator.class, "com.obric.memorydata.plugin");
    }

    public void a() {
        i r0 = b();
        if (r0.f3621a == null) goto L5;
        ContentHandler r1 = r0.f3621a;
    L6:
        super.setContentHandler(r1);
        return;
    L5:
        r1 = new DefaultHandler();
        goto L6
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.g
    public final void a(com.ctc.wstx.shaded.msv.relaxng_datatype.a r1, u r2) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.a r0 = (com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r1, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin");
    }

    public final void a(XSDatatypeExp r1) {
        this.h.add(r1);
    }

    public void a(i r1, i r2, com.ctc.wstx.shaded.msv_core.util.c r3) {
        super.setContentHandler(r1);
        r1.a(this, r2, r3);
    }

    public final void a(Exception r2, String r3) {
        a(r3, null, r2, null);
    }

    public final void a(Exception r3, String r4, Object r5) {
        a(r4, new Object[]{r5}, r3, null);
    }

    public final void a(Object r4, Locator r5) {
        Locator r6 = (Locator) ZeusTransformUtils.wrapperContextForParams(r5, Locator.class, "com.obric.memorydata.plugin");
        XMLReader r0 = this.f3603b.newSAXParser().getXMLReader();     // Catch: SAXException -> L10 SAXParseException -> L12 IOException -> L14 ParserConfigurationException -> L16
        r0.setContentHandler(this);     // Catch: SAXException -> L10 SAXParseException -> L12 IOException -> L14 ParserConfigurationException -> L16
        r0.setErrorHandler(this.f3602a);     // Catch: SAXException -> L10 SAXParseException -> L12 IOException -> L14 ParserConfigurationException -> L16
        r0.setEntityResolver(this.f3602a);     // Catch: SAXException -> L10 SAXParseException -> L12 IOException -> L14 ParserConfigurationException -> L16
        if (ZeusTransformUtils.instanceOf(r4, InputSource.class) == false) goto L7;
        r0.parse((InputSource) ZeusTransformUtils.preCheckCast(r4, InputSource.class, "com.obric.memorydata.plugin"));     // Catch: SAXException -> L10 SAXParseException -> L12 IOException -> L14 ParserConfigurationException -> L16
    L7:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L21;
        r0.parse((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));     // Catch: SAXException -> L10 SAXParseException -> L12 IOException -> L14 ParserConfigurationException -> L16
    L25:
        return;
    L21:
        return;
    L14:
        e = move-exception;
        this.f3602a.a(e, r6);
        return;
    L16:
        e = move-exception;
        this.f3602a.a(e, r6);
        return;
    L12:
        e = move-exception;
        this.f3602a.error(e);
        return;
    L10:
        e = move-exception;
        this.f3602a.a(e, r6);
    }

    public final void a(String r3, Object r4) {
        a(r3, new Object[]{r4}, null, null);
    }

    public final void a(String r3, Object r4, Object r5) {
        a(r3, new Object[]{r4, r5}, null, null);
    }

    public final void a(String r2, Object[] r3, Exception r4, Locator[] r5) {
        this.f3602a.a(a(r5), a(r2, r3), r4);
    }

    public final void a(String r2, Object[] r3, Locator[] r4) {
        this.f3602a.a(a(r4), a(r2, r3));
    }

    public void a(Locator r3) {
        this.f = (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin");
    }

    public final void a(Locator[] r2, String r3, Object[] r4) {
        a(r3, r4, null, r2);
    }

    public abstract boolean a(com.ctc.wstx.shaded.msv_core.util.c r1);

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.e
    public String a_(String r1) {
        return this.e.a(r1);
    }

    public final i b() {
        return (i) ZeusTransformUtils.preCheckCast(super.getContentHandler(), i.class, "com.obric.memorydata.plugin");
    }

    public final void b(String r3, Object r4, Object r5) {
        a(r3, new Object[]{r4, r5}, null);
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.e
    public boolean b(String r1) {
        return true;
    }

    public XSDatatype c(String r4) {
        if (r4.equals("uriReference") == false) goto L6;
        XSDatatype r0 = AnyURIType.theInstance;
    L30:
        if (r0 == null) goto L32;
        b("GrammarReader.Warning.DeprecatedTypeName", r4, r0.displayName());
    L32:
        return r0;
    L6:
        if (r4.equals("number") == false) goto L9;
        r0 = NumberType.theInstance;
        goto L30
    L9:
        if (r4.equals("timeDuration") == false) goto L12;
        r0 = DurationType.theInstance;
        goto L30
    L12:
        if (r4.equals("CDATA") == false) goto L15;
        r0 = NormalizedStringType.theInstance;
        goto L30
    L15:
        if (r4.equals("year") == false) goto L18;
        r0 = GYearType.theInstance;
        goto L30
    L18:
        if (r4.equals("yearMonth") == false) goto L21;
        r0 = GYearMonthType.theInstance;
        goto L30
    L21:
        if (r4.equals("month") == false) goto L24;
        r0 = GMonthType.theInstance;
        goto L30
    L24:
        if (r4.equals("monthDay") == false) goto L27;
        r0 = GMonthDayType.theInstance;
        goto L30
    L27:
        if (r4.equals("day") == false) goto L29;
        r0 = GDayType.theInstance;
        goto L30
    L29:
        r0 = null;
        goto L30
    }

    public Locator c() {
        return this.f;
    }

    public final void d(String r2) {
        a(r2, null, null, null);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endPrefixMapping(String r4) {
        this.e = ((a) ZeusTransformUtils.preCheckCast(this.e, a.class, "com.obric.memorydata.plugin")).f3604a;
        super.endPrefixMapping(r4);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
    public final void parse(String r2) {
        a(r2, null);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
    public final void parse(InputSource r2) {
        a(r2, null);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator r3) {
        Locator r4 = (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin");
        super.setDocumentLocator(r4);
        a(r4);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startPrefixMapping(String r2, String r3) {
        this.e = new a(this, r2, r3);
        super.startPrefixMapping(r2, r3);
    }
}
