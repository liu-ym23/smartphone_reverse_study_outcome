package org.apache.xmlbeans.impl.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.SAXParserFactory;
import org.apache.logging.log4j.a;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.xmlbeans.XmlOptions;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes7.dex */
public final class SAXHelper {
    public static final EntityResolver IGNORING_ENTITY_RESOLVER = null;
    private static final c LOG = null;
    private static long lastLog;

    static {
        LOG = b.a(SAXHelper.class);
        IGNORING_ENTITY_RESOLVER = $$Lambda$SAXHelper$eky8k1b2wXvxVMKQhI69aCwA.INSTANCE;
    }

    private SAXHelper() {
    }

    static /* synthetic */ InputSource lambda$static$0(String r1, String r2) {
        return new InputSource(new StringReader(""));
    }

    public static XMLReader newXMLReader(XmlOptions r2) {
        XMLReader r0 = saxFactory(r2).newSAXParser().getXMLReader();
        r0.setEntityResolver(IGNORING_ENTITY_RESOLVER);
        trySetSAXFeature(r0, "http://javax.xml.XMLConstants/feature/secure-processing");
        trySetXercesSecurityManager(r0, r2);
        return r0;
    }

    static SAXParserFactory saxFactory(XmlOptions r3) {
        SAXParserFactory r0 = SAXParserFactory.newInstance();
        r0.setValidating(false);
        r0.setNamespaceAware(true);
        trySetSAXFeature(r0, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(r0, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", r3.isLoadDTDGrammar());
        trySetSAXFeature(r0, "http://apache.org/xml/features/nonvalidating/load-external-dtd", r3.isLoadExternalDTD());
        trySetSAXFeature(r0, "http://apache.org/xml/features/disallow-doctype-decl", r3.disallowDocTypeDeclaration());
        return r0;
    }

    private static void trySetSAXFeature(SAXParserFactory r0, String r1, boolean r2) {
        r0.setFeature(r1, r2);     // Catch: AbstractMethodError -> L4 Exception -> L6
    L12:
        return;
    L4:
        e = move-exception;
        a r3 = LOG.atWarn().a(e);
        String r4 = "Cannot set SAX feature {} because outdated XML parser in classpath";
    L8:
        r3.a(r4, r1);
        return;
    L6:
        e = move-exception;
        r3 = LOG.atWarn().a(e);
        r4 = "SAX Feature unsupported: {}";
        goto L8
    }

    private static void trySetSAXFeature(XMLReader r2, String r3) {
        ((XMLReader) ZeusTransformUtils.wrapperContextForParams(r2, XMLReader.class, "com.obric.memorydata.plugin")).setFeature(r3, true);     // Catch: AbstractMethodError -> L5 Exception -> L7
    L13:
        return;
    L5:
        e = move-exception;
        a r4 = LOG.atWarn().a(e);
        String r0 = "Cannot set SAX feature {} because outdated XML parser in classpath";
    L9:
        r4.a(r0, r3);
        return;
    L7:
        e = move-exception;
        r4 = LOG.atWarn().a(e);
        r0 = "SAX Feature unsupported: {}";
        goto L9
    }

    private static void trySetXercesSecurityManager(XMLReader r13, XmlOptions r14) {
        XMLReader r15 = (XMLReader) ZeusTransformUtils.wrapperContextForParams(r13, XMLReader.class, "com.obric.memorydata.plugin");
        String[] r0 = {"org.apache.xerces.util.SecurityManager"};
        int r3 = 0;
    L4:
        if (r3 < 1) goto L22;
        r15.setProperty("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(r14.getEntityExpansionLimit()));     // Catch: SAXException -> L16
        return;
    L16:
        e = move-exception;
        if (System.currentTimeMillis() <= (lastLog + TimeUnit.MINUTES.toMillis(5))) goto L31;
        LOG.atWarn().a(e).a("SAX Security Manager could not be setup [log suppressed for 5 minutes]");
        lastLog = System.currentTimeMillis();
        return;
    L31:
        return;
    L22:
        Class r8 = ZeusTransformUtils.forName(r0[r3], "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Object r9 = r8.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L9
        r8.getMethod("setEntityExpansionLimit", new Class[]{Integer.TYPE}).invoke(r9, new Object[]{Integer.valueOf(r14.getEntityExpansionLimit())});     // Catch: Throwable -> L9
        r15.setProperty("http://apache.org/xml/properties/security-manager", r9);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (System.currentTimeMillis() <= (lastLog + TimeUnit.MINUTES.toMillis(5))) goto L13;
        LOG.atWarn().a(th).a("SAX Security Manager could not be setup [log suppressed for 5 minutes]");
        lastLog = System.currentTimeMillis();
    L13:
        r3 = r3 + 1;
        goto L4
    }
}
