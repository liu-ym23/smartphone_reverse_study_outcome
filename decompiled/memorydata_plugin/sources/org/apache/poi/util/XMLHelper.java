package org.apache.poi.util;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes7.dex */
public final class XMLHelper {
    private static final c LOG = null;
    static final String[] SECURITY_MANAGERS = null;
    private static final DocumentBuilderFactory documentBuilderFactory = null;
    private static long lastLog;
    private static final SAXParserFactory saxFactory = null;

    /* JADX INFO: renamed from: org.apache.poi.util.XMLHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DocHelperErrorHandler implements ErrorHandler {
        private DocHelperErrorHandler() {
        }

        /* synthetic */ DocHelperErrorHandler(AnonymousClass1 r1) {
            this();
        }

        private void printError(Level r3, SAXParseException r4) {
            String r2 = r4.getSystemId();
            if (r2 == null) goto L7;
            int r0 = r2.lastIndexOf(47);
            if (r0 == (-1)) goto L7;
            r2 = r2.substring(r0 + 1);
        L7:
            StringBuilder r1 = new StringBuilder();
            if (r2 != null) goto L10;
            r2 = "";
        L10:
            String r5 = r1.append(r2).append(':').append(r4.getLineNumber()).append(':').append(r4.getColumnNumber()).append(':').append(r4.getMessage()).toString();
            XMLHelper.access$100().atLevel(r3).a(r4).a(r5);
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException r2) {
            printError(Level.ERROR, r2);
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException r2) {
            printError(Level.FATAL, r2);
            throw r2;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException r2) {
            printError(Level.WARN, r2);
        }
    }

    @FunctionalInterface
    private interface SecurityFeature {
        void accept(String r1, boolean r2);
    }

    @FunctionalInterface
    private interface SecurityProperty {
        void accept(String r1, Object r2);
    }

    static {
        SECURITY_MANAGERS = new String[]{"org.apache.xerces.util.SecurityManager"};
        LOG = b.a(XMLHelper.class);
        documentBuilderFactory = getDocumentBuilderFactory();
        saxFactory = getSaxParserFactory();
    }

    private XMLHelper() {
    }

    static /* synthetic */ c access$100() {
        return LOG;
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        final DocumentBuilderFactory r0 = DocumentBuilderFactory.newInstance();
        r0.setNamespaceAware(true);
        r0.setExpandEntityReferences(false);
        r0.setValidating(false);
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$pTLxavYkNVYj3CbQS9lmbvfVVQ(r0), "http://javax.xml.XMLConstants/feature/secure-processing", true);
        r0.getClass();
        quietSet(new $$Lambda$XMLHelper$17s6nJ3_emwuLq5wLJrPeYgFH0(r0), "http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        r0.getClass();
        quietSet(new $$Lambda$XMLHelper$17s6nJ3_emwuLq5wLJrPeYgFH0(r0), "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$pTLxavYkNVYj3CbQS9lmbvfVVQ(r0), "http://xml.org/sax/features/external-general-entities", false);
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$pTLxavYkNVYj3CbQS9lmbvfVVQ(r0), "http://xml.org/sax/features/external-parameter-entities", false);
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$pTLxavYkNVYj3CbQS9lmbvfVVQ(r0), "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$pTLxavYkNVYj3CbQS9lmbvfVVQ(r0), "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$pTLxavYkNVYj3CbQS9lmbvfVVQ(r0), "http://apache.org/xml/features/disallow-doctype-decl", true);
        trySet(new $$Lambda$XMLHelper$GEngWk3g9OfdgbP9CD_VOOZho(r0), "XIncludeAware", false);
        Object r2 = getXercesSecurityManager();
        if (r2 == null) goto L6;
        r0.getClass();
        if (trySet(new $$Lambda$XMLHelper$17s6nJ3_emwuLq5wLJrPeYgFH0(r0), "http://apache.org/xml/properties/security-manager", r2) == false) goto L6;
    L7:
        return r0;
    L6:
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$17s6nJ3_emwuLq5wLJrPeYgFH0(r0), "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", 1);
        goto L7
    }

    public static SAXParserFactory getSaxParserFactory() {
        final SAXParserFactory r2 = SAXParserFactory.newInstance();     // Catch: Exception -> L5 Throwable -> L8
        r2.setValidating(false);     // Catch: Exception -> L5 Throwable -> L8
        r2.setNamespaceAware(true);     // Catch: Exception -> L5 Throwable -> L8
        r2.getClass();     // Catch: Exception -> L5 Throwable -> L8
        trySet(new $$Lambda$XMLHelper$B70AM7ZDYf7RlBUfS99B1FfJxDU(r2), "http://javax.xml.XMLConstants/feature/secure-processing", true);     // Catch: Exception -> L5 Throwable -> L8
        r2.getClass();     // Catch: Exception -> L5 Throwable -> L8
        trySet(new $$Lambda$XMLHelper$B70AM7ZDYf7RlBUfS99B1FfJxDU(r2), "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);     // Catch: Exception -> L5 Throwable -> L8
        r2.getClass();     // Catch: Exception -> L5 Throwable -> L8
        trySet(new $$Lambda$XMLHelper$B70AM7ZDYf7RlBUfS99B1FfJxDU(r2), "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);     // Catch: Exception -> L5 Throwable -> L8
        r2.getClass();     // Catch: Exception -> L5 Throwable -> L8
        trySet(new $$Lambda$XMLHelper$B70AM7ZDYf7RlBUfS99B1FfJxDU(r2), "http://xml.org/sax/features/external-general-entities", false);     // Catch: Exception -> L5 Throwable -> L8
        r2.getClass();     // Catch: Exception -> L5 Throwable -> L8
        trySet(new $$Lambda$XMLHelper$B70AM7ZDYf7RlBUfS99B1FfJxDU(r2), "http://apache.org/xml/features/disallow-doctype-decl", true);     // Catch: Exception -> L5 Throwable -> L8
        return r2;
    L8:
        e = move-exception;
        logThrowable(e, "Failed to create SAXParserFactory", "-");
        throw e;
    L5:
        e = move-exception;
        logThrowable(e, "Failed to create SAXParserFactory", "-");
        throw new RuntimeException("Failed to create SAXParserFactory", e);
    }

    public static TransformerFactory getTransformerFactory() {
        final TransformerFactory r0 = TransformerFactory.newInstance();
        r0.getClass();
        trySet(new $$Lambda$XMLHelper$Dgq4E4aUcC7YkpIL4MMkYwiobLw(r0), "http://javax.xml.XMLConstants/feature/secure-processing", true);
        r0.getClass();
        quietSet(new $$Lambda$XMLHelper$CrP1xaPzIdzLMLCcKVYrUEZ3r8(r0), "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        r0.getClass();
        quietSet(new $$Lambda$XMLHelper$CrP1xaPzIdzLMLCcKVYrUEZ3r8(r0), "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
        r0.getClass();
        quietSet(new $$Lambda$XMLHelper$CrP1xaPzIdzLMLCcKVYrUEZ3r8(r0), "http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        return r0;
    }

    private static Object getXercesSecurityManager() {
        String[] r0 = SECURITY_MANAGERS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L10;
        String r4 = r0[r3];
        Object r5 = ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L7 ClassNotFoundException -> L12
        r5.getClass().getMethod("setEntityExpansionLimit", new Class[]{Integer.TYPE}).invoke(r5, new Object[]{1});     // Catch: Throwable -> L7 ClassNotFoundException -> L12
        goto L9
    L6:
        return r5;
    L7:
        th = move-exception;
        logThrowable(th, "SAX Feature unsupported", r4);
    L9:
        r3 = r3 + 1;
        goto L3
    L10:
        return null;
    }

    private static InputSource ignoreEntity(String r1, String r2) {
        return new InputSource(new StringReader(""));
    }

    /* JADX INFO: renamed from: lambda$17s6nJ3_emwuLq5-wLJrPeYgFH0, reason: not valid java name */
    public static /* synthetic */ void m3187lambda$17s6nJ3_emwuLq5wLJrPeYgFH0(DocumentBuilderFactory r0, String r1, Object r2) {
        r0.setAttribute(r1, r2);
    }

    public static /* synthetic */ void lambda$B70AM7ZDYf7RlBUfS99B1FfJxDU(SAXParserFactory r0, String r1, boolean r2) {
        r0.setFeature(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$CrP1xaPzIdzLMLCcKVYrU-EZ3r8, reason: not valid java name */
    public static /* synthetic */ void m3188lambda$CrP1xaPzIdzLMLCcKVYrUEZ3r8(TransformerFactory r0, String r1, Object r2) {
        r0.setAttribute(r1, r2);
    }

    public static /* synthetic */ void lambda$Dgq4E4aUcC7YkpIL4MMkYwiobLw(TransformerFactory r0, String r1, boolean r2) {
        r0.setFeature(r1, r2);
    }

    public static /* synthetic */ InputSource lambda$e6ZBpJZpZdbbmsFR25LeglJVBQk(String r0, String r1) {
        return ignoreEntity(r0, r1);
    }

    static /* synthetic */ void lambda$getDocumentBuilderFactory$0(DocumentBuilderFactory r0, String r1, boolean r2) {
        r0.setXIncludeAware(r2);
    }

    /* JADX INFO: renamed from: lambda$pTLxavYkNVYj3CbQS9-lmbvfVVQ, reason: not valid java name */
    public static /* synthetic */ void m3189lambda$pTLxavYkNVYj3CbQS9lmbvfVVQ(DocumentBuilderFactory r0, String r1, boolean r2) {
        r0.setFeature(r1, r2);
    }

    private static void logThrowable(Throwable r7, String r8, String r9) {
        if (System.currentTimeMillis() <= (lastLog + TimeUnit.MINUTES.toMillis(5))) goto L6;
        LOG.atWarn().a(r7).a("{} [log suppressed for 5 minutes] {}", r8, r9);
        lastLog = System.currentTimeMillis();
        return;
    }

    public static DocumentBuilder newDocumentBuilder() {
        DocumentBuilder r0 = documentBuilderFactory.newDocumentBuilder();     // Catch: ParserConfigurationException -> L4
        r0.setEntityResolver($$Lambda$XMLHelper$e6ZBpJZpZdbbmsFR25LeglJVBQk.INSTANCE);     // Catch: ParserConfigurationException -> L4
        r0.setErrorHandler(new DocHelperErrorHandler(null));     // Catch: ParserConfigurationException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new IllegalStateException("cannot create a DocumentBuilder", e);
    }

    public static Transformer newTransformer() {
        Transformer r0 = getTransformerFactory().newTransformer();
        r0.setOutputProperty("encoding", RpcUtils.CHARSET_UTF8);
        r0.setOutputProperty("indent", "no");
        r0.setOutputProperty("method", "xml");
        return r0;
    }

    public static XMLReader newXMLReader() {
        final XMLReader r0 = saxFactory.newSAXParser().getXMLReader();
        r0.setEntityResolver($$Lambda$XMLHelper$e6ZBpJZpZdbbmsFR25LeglJVBQk.INSTANCE);
        r0.getClass();
        trySet(new $$Lambda$ju2OlIle01Dy89PfhOGvArV4qcQ(r0), "http://javax.xml.XMLConstants/feature/secure-processing", true);
        r0.getClass();
        trySet(new $$Lambda$ju2OlIle01Dy89PfhOGvArV4qcQ(r0), "http://xml.org/sax/features/external-general-entities", false);
        Object r1 = getXercesSecurityManager();
        if (r1 == null) goto L6;
        r0.getClass();
        if (trySet(new $$Lambda$Dp9bA9328_Tf0jVt64N8WniQUtE(r0), "http://apache.org/xml/properties/security-manager", r1) == false) goto L6;
    L7:
        return r0;
    L6:
        r0.getClass();
        trySet(new $$Lambda$Dp9bA9328_Tf0jVt64N8WniQUtE(r0), "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", 1);
        goto L7
    }

    private static boolean quietSet(SecurityProperty r2, String r3, Object r4) {
        ((SecurityProperty) ZeusTransformUtils.wrapperContextForParams(r2, SecurityProperty.class, "com.obric.memorydata.plugin")).accept(r3, r4);     // Catch: Throwable -> L6
        return true;
    L6:
        return false;
    }

    private static boolean trySet(SecurityFeature r2, String r3, boolean r4) {
        ((SecurityFeature) ZeusTransformUtils.wrapperContextForParams(r2, SecurityFeature.class, "com.obric.memorydata.plugin")).accept(r3, r4);     // Catch: Error -> L6 Exception -> L8
        return true;
    L6:
        e = e;
        String r5 = "Cannot set SAX feature because outdated XML parser in classpath";
    L10:
        logThrowable(e, r5, r3);
        return false;
    L8:
        e = e;
        r5 = "SAX Feature unsupported";
        goto L10
    }

    private static boolean trySet(SecurityProperty r2, String r3, Object r4) {
        ((SecurityProperty) ZeusTransformUtils.wrapperContextForParams(r2, SecurityProperty.class, "com.obric.memorydata.plugin")).accept(r3, r4);     // Catch: Error -> L6 Exception -> L8
        return true;
    L6:
        e = e;
        String r5 = "Cannot set SAX feature because outdated XML parser in classpath";
    L10:
        logThrowable(e, r5, r3);
        return false;
    L8:
        e = e;
        r5 = "SAX Feature unsupported";
        goto L10
    }
}
