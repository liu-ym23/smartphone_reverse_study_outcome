package org.apache.xmlbeans.impl.store;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.a;
import javax.xml.stream.e;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameCache;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.SAXHelper;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: classes7.dex */
public final class Locale implements XmlLocale, Saaj.SaajCallback, DOMImplementation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    static final QName _openuriFragment = null;
    static final QName _xmlFragment = null;
    static final QName _xsiLoc = null;
    static final QName _xsiNil = null;
    static final QName _xsiNoLoc = null;
    static final QName _xsiType = null;
    private static final ThreadLocal<SoftReference<ScrubBuffer>> tl_scrubBuffer = null;
    int _cchSrc;
    ChangeListener _changeListeners;
    private CharUtil _charUtil;
    Cur _curPool;
    int _curPoolCount;
    domNthCache _domNthCache_A;
    domNthCache _domNthCache_B;
    private int _entryCount;
    Cur.Locations _locations;
    boolean _noSync;
    nthCache _nthCache_A;
    nthCache _nthCache_B;
    int _numTempFramesLeft;
    int _offSrc;
    DomImpl.Dom _ownerDoc;
    int _posTemp;
    QNameFactory _qnameFactory;
    private ReferenceQueue<Ref> _refQueue;
    Cur _registered;
    Saaj _saaj;
    SchemaTypeLoader _schemaTypeLoader;
    Cur[] _tempFrames;
    boolean _validateOnSet;
    long _versionAll;
    long _versionSansText;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.Locale$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    interface ChangeListener {
        ChangeListener getNextChangeListener();

        void notifyChange();

        void setNextChangeListener(ChangeListener r1);
    }

    private static class DefaultEntityResolver implements EntityResolver {
        private DefaultEntityResolver() {
        }

        /* synthetic */ DefaultEntityResolver(AnonymousClass1 r1) {
            this();
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String r1, String r2) {
            return new InputSource(new StringReader(""));
        }
    }

    private static final class DefaultQNameFactory implements QNameFactory {
        private final QNameCache _cache;

        private DefaultQNameFactory() {
            this._cache = XmlBeans.getQNameCache();
        }

        /* synthetic */ DefaultQNameFactory(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String r2, String r3) {
            return this._cache.getName(r2, r3, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String r1, String r2, String r3) {
            return this._cache.getName(r1, r2, r3);
        }
    }

    private static class DocProps extends XmlDocumentProperties {
        private final HashMap<Object, Object> _map;

        private DocProps() {
            this._map = new HashMap();
        }

        /* synthetic */ DocProps(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object get(Object r1) {
            return this._map.get(r1);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object put(Object r1, Object r2) {
            return this._map.put(r1, r2);
        }
    }

    public static abstract class LoadContext {
        private Hashtable<String, String> _idAttrs;

        public LoadContext() {
        }

        public abstract void abort();

        public void addIdAttr(String r2, String r3) {
            if (this._idAttrs != null) goto L5;
            this._idAttrs = new Hashtable();
        L5:
            this._idAttrs.put(r3, r2);
        }

        public abstract void attr(String r1, String r2, String r3, String r4);

        public abstract void attr(QName r1, String r2);

        public abstract void bookmark(XmlCursor.XmlBookmark r1);

        public abstract void bookmarkLastNonAttr(XmlCursor.XmlBookmark r1);

        public abstract void comment(String r1);

        public abstract void comment(char[] r1, int r2, int r3);

        public abstract void endDTD();

        public abstract void endElement();

        public abstract Cur finish();

        public boolean isAttrOfTypeId(QName r5, QName r6) {
            if (this._idAttrs == null) goto L5;
            String r0 = r5.getPrefix();
            String r7 = r5.getLocalPart();
            if ("".equals(r0) == true) goto L10;
            r7 = r0 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r7;
        L10:
            String r4 = (String) ZeusTransformUtils.preCheckCast(this._idAttrs.get(r7), String.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L14;
            return false;
        L14:
            String r8 = r6.getPrefix();
            String r9 = r6.getLocalPart();
            if ("".equals(r8) == true) goto L19;
            r9 = r8 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r9;
        L19:
            return r4.equals(r9);
        L5:
            return OaidModel.KEY_ID.equalsIgnoreCase(r5.getLocalPart());
        }

        public abstract void lineNumber(int r1, int r2, int r3);

        public abstract void procInst(String r1, String r2);

        public abstract void startDTD(String r1, String r2, String r3);

        public abstract void startElement(QName r1);

        public abstract void text(String r1);

        public abstract void text(char[] r1, int r2, int r3);

        public abstract void xmlns(String r1, String r2);
    }

    static final class Ref extends PhantomReference {
        Cur _cur;

        Ref(Cur r2, Object r3) {
            super(r3, r2._locale.refQueue());
            this._cur = r2;
        }
    }

    private static abstract class SaxHandler implements ContentHandler, DTDHandler, DeclHandler, LexicalHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected LoadContext _context;
        private int _entityBytes;
        private int _entityBytesLimit;
        private boolean _insideCDATA;
        private int _insideEntity;
        protected Locale _locale;
        private Locator _startLocator;
        private boolean _wantCdataBookmarks;
        private boolean _wantLineNumbers;
        private boolean _wantLineNumbersAtEndElt;
        private Map<String, String> delayedPrefixMappings;

        static {
        }

        SaxHandler(Locator r3) {
            Locator r4 = (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin");
            this._insideCDATA = false;
            this._entityBytesLimit = 10240;
            this._entityBytes = 0;
            this._insideEntity = 0;
            this.delayedPrefixMappings = new LinkedHashMap();
            this._startLocator = r4;
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void attributeDecl(String r1, String r2, String r3, String r4, String r5) {
            if (r3.equals("ID") == false) goto L6;
            this._context.addIdAttr(r1, r2);
            return;
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] r2, int r3, int r4) {
            this._context.text(r2, r3, r4);
            if (this._wantCdataBookmarks == false) goto L10;
            if (this._insideCDATA == false) goto L10;
            if (this._startLocator == null) goto L10;
            this._context.bookmarkLastNonAttr(CDataBookmark.CDATA_BOOKMARK);
        L10:
            if (this._insideEntity == 0) goto L16;
            int r5 = this._entityBytes + r4;
            this._entityBytes = r5;
            int r1 = this._entityBytesLimit;
            if (r5 > r1) goto L15;
            return;
        L15:
            throw new SAXException(XmlError.forMessage("exceeded-entity-bytes", new Integer[]{Integer.valueOf(r1)}).getMessage());
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void comment(char[] r1, int r2, int r3) {
            this._context.comment(r1, r2, r3);
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void elementDecl(String r1, String r2) {
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endCDATA() {
            this._insideCDATA = false;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endDTD() {
            this._context.endDTD();
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String r2, String r3, String r4) {
            this._context.endElement();
            if (this._wantLineNumbersAtEndElt == true) goto L5;
            return;
        L5:
            if (this._startLocator == null) goto L9;
            this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            return;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endEntity(String r1) {
            int r2 = this._insideEntity - 1;
            this._insideEntity = r2;
            if (r2 != 0) goto L6;
            this._entityBytes = 0;
            return;
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String r1) {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void externalEntityDecl(String r1, String r2, String r3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] r1, int r2, int r3) {
        }

        void initSaxHandler(Locale r2, XmlOptions r3) {
            this._locale = r2;
            XmlOptions r4 = XmlOptions.maskNull(r3);
            this._context = new Cur.CurLoadContext(this._locale, r4);
            this._wantLineNumbers = r4.isLoadLineNumbers();
            this._wantLineNumbersAtEndElt = r4.isLoadLineNumbersEndElement();
            this._wantCdataBookmarks = r4.isUseCDataBookmarks();
            Integer r5 = r4.getLoadEntityBytesLimit();
            if (r5 == null) goto L6;
            this._entityBytesLimit = r5.intValue();
            return;
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void internalEntityDecl(String r1, String r2) {
        }

        @Override // org.xml.sax.DTDHandler
        public void notationDecl(String r1, String r2, String r3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String r1, String r2) {
            this._context.procInst(r1, r2);
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator r3) {
            Locator r4 = (Locator) ZeusTransformUtils.wrapperContextForParams(r3, Locator.class, "com.obric.memorydata.plugin");
            if (this._startLocator != null) goto L6;
            this._startLocator = r4;
            return;
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String r1) {
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startCDATA() {
            this._insideCDATA = true;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startDTD(String r1, String r2, String r3) {
            this._context.startDTD(r1, r2, r3);
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String r8, String r9, String r10, Attributes r11) {
            Attributes r12 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r11, Attributes.class, "com.obric.memorydata.plugin");
            if (r10.indexOf(58) >= 0) goto L5;
        L9:
            this._context.startElement(this._locale.makeQualifiedQName(r8, r10));
            if (this._wantLineNumbers == true) goto L12;
        L14:
            Iterator<Map.Entry<String, String>> r13 = this.delayedPrefixMappings.entrySet().iterator();
        L16:
            if (r13.hasNext() == false) goto L18;
            Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this._context.xmlns((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin"));
            goto L16
        L18:
            this.delayedPrefixMappings.clear();
            int r15 = r12.getLength();
            int r16 = 0;
        L19:
            if (r16 >= r15) goto L25;
            String r0 = r12.getQName(r16);
            int r1 = r0.indexOf(58);
            if (r1 >= 0) goto L23;
            this._context.attr(r0, r12.getURI(r16), null, r12.getValue(r16));
        L24:
            r16 = r16 + 1;
            goto L19
        L23:
            this._context.attr(r0.substring(r1 + 1), r12.getURI(r16), r0.substring(0, r1), r12.getValue(r16));
            goto L24
        L25:
            return;
        L12:
            if (this._startLocator == null) goto L14;
            this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            goto L14
        L5:
            if (r8.length() != 0) goto L9;
            XmlError r7 = XmlError.forMessage("Use of undefined namespace prefix: " + r10.substring(0, r10.indexOf(58)));
            throw new XmlRuntimeException(r7.toString(), null, r7);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startEntity(String r1) {
            this._insideEntity++;
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String r2, String r3) {
            if (Locale.beginsWithXml(r2) == true) goto L5;
        L11:
            this.delayedPrefixMappings.put(r2, r3);
            return;
        L5:
            if ("xml".equals(r2) == true) goto L7;
        L9:
            XmlError r1 = XmlError.forMessage("Prefix can't begin with XML: " + r2, 0);
            throw new XmlRuntimeException(r1.toString(), null, r1);
        L7:
            if ("http://www.w3.org/XML/1998/namespace".equals(r3) == false) goto L9;
            goto L9
        }

        @Override // org.xml.sax.DTDHandler
        public void unparsedEntityDecl(String r1, String r2, String r3, String r4) {
        }
    }

    private static abstract class SaxLoader extends SaxHandler implements ErrorHandler {
        private final XMLReader _xr;

        SaxLoader(XMLReader r3, Locator r4) {
            XMLReader r5 = (XMLReader) ZeusTransformUtils.wrapperContextForParams(r3, XMLReader.class, "com.obric.memorydata.plugin");
            super((Locator) ZeusTransformUtils.wrapperContextForParams(r4, Locator.class, "com.obric.memorydata.plugin"));
            this._xr = r5;
            r5.setFeature("http://xml.org/sax/features/namespaces", true);     // Catch: Throwable -> L13
            r5.setFeature("http://xml.org/sax/features/validation", false);     // Catch: Throwable -> L13
            r5.setProperty("http://xml.org/sax/properties/lexical-handler", this);     // Catch: Throwable -> L13
            r5.setContentHandler(this);     // Catch: Throwable -> L13
            r5.setDTDHandler(this);     // Catch: Throwable -> L13
            r5.setErrorHandler(this);     // Catch: Throwable -> L13
            r5.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);     // Catch: Throwable -> L6
        L16:
            this._xr.setProperty("http://xml.org/sax/properties/declaration-handler", this);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            Locale.access$600().atWarn().a(th).a("SAX Declaration Handler is not supported");
            return;
        L6:
            th = move-exception;
            Locale.access$600().atWarn().a(th).a("Secure Processing Feature is not supported");
        L13:
            th = move-exception;
            throw new RuntimeException(th.getMessage(), th);
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException r1) {
            throw r1;
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException r1) {
            throw r1;
        }

        public Cur load(Locale r3, InputSource r4, XmlOptions r5) {
            r4.setSystemId("file://");
            initSaxHandler(r3, r5);
            this._xr.parse(r4);     // Catch: RuntimeException -> L5 SAXException -> L8 SAXParseException -> L11 XmlRuntimeException -> L18
            Cur r6 = this._context.finish();     // Catch: RuntimeException -> L5 SAXException -> L8 SAXParseException -> L11 XmlRuntimeException -> L18
            Locale.associateSourceName(r6, r5);     // Catch: RuntimeException -> L5 SAXException -> L8 SAXParseException -> L11 XmlRuntimeException -> L18
            postLoad(r6);     // Catch: RuntimeException -> L5 SAXException -> L8 SAXParseException -> L11 XmlRuntimeException -> L18
            return r6;
        L18:
            e = move-exception;
            this._context.abort();
            throw new XmlException(e);
        L5:
            e = move-exception;
            this._context.abort();
            throw e;
        L11:
            e = move-exception;
            this._context.abort();
            String r2 = e.getMessage();
            if (r5 != null) goto L15;
            String r7 = null;
        L16:
            XmlError r8 = XmlError.forLocation(r2, r7, e.getLineNumber(), e.getColumnNumber(), -1);
            throw new XmlException(r8.toString(), e, r8);
        L15:
            r7 = r5.getDocumentSourceName();
        L8:
            e = move-exception;
            this._context.abort();
            XmlError r9 = XmlError.forMessage(e.getMessage());
            throw new XmlException(r9.toString(), e, r9);
        }

        void postLoad(Cur r1) {
            this._locale = null;
            this._context = null;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException r1) {
            throw r1;
        }
    }

    static final class ScrubBuffer {
        private final StringBuffer _sb;
        private char[] _srcBuf;
        private int _state;
        private int _wsr;

        ScrubBuffer() {
            this._srcBuf = new char[1024];
            this._sb = new StringBuffer();
        }

        String getResultAsString() {
            return this._sb.toString();
        }

        void init(int r4) {
            StringBuffer r0 = this._sb;
            r0.delete(0, r0.length());
            this._wsr = r4;
            this._state = 0;
        }

        void scrub(Object r8, int r9, int r10) {
            if (r10 != 0) goto L6;
            return;
        L6:
            if (this._wsr != 1) goto L9;
            CharUtil.getString(this._sb, r8, r9, r10);
            return;
        L9:
            int r3 = 0;
            if ((r8 instanceof char[]) == false) goto L12;
            char[] r11 = (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r8, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin");
        L20:
            int r0 = 0;
        L21:
            if (r3 >= r10) goto L42;
            char r1 = r11[r9 + r3];
            if (r1 != ' ') goto L25;
        L35:
            this._sb.append(r11, r9 + r0, r3 - r0);
            r0 = r3 + 1;
            if (this._wsr != 2) goto L39;
            this._sb.append(' ');
        L41:
            r3 = r3 + 1;
            goto L21
        L39:
            if (this._state != 2) goto L41;
            this._state = 1;
            goto L41
        L25:
            if (r1 == '\n') goto L35;
            if (r1 == '\r') goto L35;
            if (r1 == '\t') goto L35;
            if (this._state != 1) goto L34;
            this._sb.append(' ');
        L34:
            this._state = 2;
            goto L41
        L42:
            this._sb.append(r11, r9 + r0, r10 - r0);
            return;
        L12:
            char[] r2 = this._srcBuf;
            if (r10 > r2.length) goto L16;
        L19:
            CharUtil.getChars(r2, 0, r8, r9, r10);
            r11 = r2;
            r9 = 0;
            goto L20
        L16:
            if (r10 > 16384) goto L18;
            r2 = new char[16384];
            this._srcBuf = r2;
            goto L19
        L18:
            r2 = new char[r10];
            goto L19
        }
    }

    private interface SyncWrapFun<T> {
        T parse(Locale r1);
    }

    private static class XmlReaderSaxLoader extends SaxLoader {
        XmlReaderSaxLoader(XMLReader r3) {
            super((XMLReader) ZeusTransformUtils.wrapperContextForParams(r3, XMLReader.class, "com.obric.memorydata.plugin"), null);
        }
    }

    class domNthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private DomImpl.Dom _child;
        private int _len;
        private int _n;
        private DomImpl.Dom _parent;
        private long _version;
        final /* synthetic */ Locale this$0;

        static {
        }

        domNthCache(Locale r1) {
            this.this$0 = r1;
        }

        static /* synthetic */ int access$200(domNthCache r0) {
            return r0._len;
        }

        static /* synthetic */ long access$302(domNthCache r0, long r1) {
            r0._version = r1;
            return r1;
        }

        static /* synthetic */ DomImpl.Dom access$400(domNthCache r0) {
            return r0._parent;
        }

        int distance(DomImpl.Dom r5, int r6) {
            DomImpl.Dom r7 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r5, DomImpl.Dom.class, "com.obric.memorydata.plugin");
            if (this._version == this.this$0.version()) goto L7;
            return 2147483646;
        L7:
            if (r7 == this._parent) goto L10;
            return Integer.MAX_VALUE;
        L10:
            int r4 = this._n;
            if (r6 <= r4) goto L14;
            return r6 - r4;
        L14:
            return r4 - r6;
        }

        DomImpl.Dom fetch(DomImpl.Dom r7, int r8) {
            DomImpl.Dom r9 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r7, DomImpl.Dom.class, "com.obric.memorydata.plugin");
            if (this._version == this.this$0.version()) goto L5;
        L26:
            this._parent = r9;
            this._version = this.this$0.version();
            this._child = null;
            this._n = -1;
            this._len = -1;
            Node r10 = DomImpl.firstChild(this._parent);
        L27:
            DomImpl.Dom r11 = (DomImpl.Dom) ZeusTransformUtils.preCheckCast(r10, DomImpl.Dom.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L35;
            int r0 = this._n + 1;
            this._n = r0;
            if (this._child != null) goto L33;
            if (r8 != r0) goto L33;
            this._child = r11;
        L33:
            r10 = DomImpl.nextSibling(r11);
        L35:
            return this._child;
        L5:
            if (this._parent != r9) goto L26;
            int r12 = this._n;
            if (r12 >= 0) goto L10;
            return null;
        L10:
            if (r8 > r12) goto L12;
            if (r8 < r12) goto L19;
        L25:
            return this._child;
        L19:
            if (r8 >= this._n) goto L25;
            DomImpl.Dom r13 = (DomImpl.Dom) ZeusTransformUtils.preCheckCast(DomImpl.prevSibling(this._child), DomImpl.Dom.class, "com.obric.memorydata.plugin");
            if (r13 == null) goto L22;
            this._child = r13;
            this._n--;
            goto L19
        L22:
            return null;
        L12:
            if (r8 <= this._n) goto L25;
            DomImpl.Dom r14 = (DomImpl.Dom) ZeusTransformUtils.preCheckCast(DomImpl.nextSibling(this._child), DomImpl.Dom.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L15;
            this._child = r14;
            this._n++;
            goto L12
        L15:
            return null;
        }

        int length(DomImpl.Dom r7) {
            DomImpl.Dom r8 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r7, DomImpl.Dom.class, "com.obric.memorydata.plugin");
            if (this._version == this.this$0.version()) goto L5;
        L6:
            this._parent = r8;
            this._version = this.this$0.version();
            this._child = null;
            this._n = -1;
            this._len = -1;
        L8:
            if (this._len != (-1)) goto L18;
            DomImpl.Dom r9 = this._child;
            if (r9 == null) goto L14;
            int r0 = this._n;
            if (r0 == (-1)) goto L14;
            this._len = r0;
        L15:
            if (r9 == null) goto L18;
            this._len++;
            r9 = (DomImpl.Dom) ZeusTransformUtils.preCheckCast(DomImpl.nextSibling(r9), DomImpl.Dom.class, "com.obric.memorydata.plugin");
        L14:
            r9 = (DomImpl.Dom) ZeusTransformUtils.preCheckCast(DomImpl.firstChild(this._parent), DomImpl.Dom.class, "com.obric.memorydata.plugin");
            this._len = 0;
            this._child = r9;
            this._n = 0;
        L18:
            return this._len;
        L5:
            if (this._parent == r8) goto L8;
            goto L6
        }
    }

    class nthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Xobj _child;
        private int _n;
        private QName _name;
        private Xobj _parent;
        private QNameSet _set;
        private long _version;
        final /* synthetic */ Locale this$0;

        static {
        }

        nthCache(Locale r1) {
            this.this$0 = r1;
        }

        private boolean cacheSame(QName r1, QNameSet r2) {
            if (r2 != null) goto L5;
            return namesSame(r1, this._name);
        L5:
            return setsSame(r2, this._set);
        }

        private boolean nameHit(QName r1, QNameSet r2, QName r3) {
            if (r2 != null) goto L5;
            return namesSame(r1, r3);
        L5:
            return r2.contains(r3);
        }

        private boolean namesSame(QName r1, QName r2) {
            if (r1 != null) goto L4;
        L7:
            return true;
        L4:
            if (r1.equals(r2) == true) goto L7;
            return false;
        }

        private boolean setsSame(QNameSet r1, QNameSet r2) {
            if (r1 == null) goto L5;
            if (r1 != r2) goto L5;
            return true;
        L5:
            return false;
        }

        int distance(Xobj r5, QName r6, QNameSet r7, int r8) {
            if (this._version == this.this$0.version()) goto L7;
            return 2147483646;
        L7:
            if (r5 == this._parent) goto L9;
            return Integer.MAX_VALUE;
        L9:
            if (cacheSame(r6, r7) == false) goto L19;
            int r4 = this._n;
            if (r8 <= r4) goto L15;
            return r8 - r4;
        L15:
            return r4 - r8;
        L19:
            return Integer.MAX_VALUE;
        }

        Xobj fetch(Xobj r5, QName r6, QNameSet r7, int r8) {
            if (this._version == this.this$0.version()) goto L5;
        L9:
            this._version = this.this$0.version();
            this._parent = r5;
            this._name = r6;
            this._child = null;
            this._n = -1;
            Xobj r9 = r5._firstChild;
        L10:
            if (r9 == null) goto L17;
            if (r9.isElem() == false) goto L16;
            if (nameHit(r6, r7, r9._name) == false) goto L16;
            this._child = r9;
            this._n = 0;
        L16:
            r9 = r9._nextSibling;
        L17:
            int r10 = this._n;
            if (r10 >= 0) goto L20;
            return null;
        L20:
            if (r8 > r10) goto L22;
            if (r8 < r10) goto L34;
        L45:
            return this._child;
        L34:
            if (r8 >= this._n) goto L45;
            Xobj r11 = this._child;
        L36:
            r11 = r11._prevSibling;
            if (r11 == null) goto L38;
            if (r11.isElem() == false) goto L36;
            if (nameHit(r6, r7, r11._name) == false) goto L36;
            this._child = r11;
            this._n--;
            goto L34
        L38:
            return null;
        L22:
            if (r8 <= this._n) goto L45;
            Xobj r12 = this._child;
        L24:
            r12 = r12._nextSibling;
            if (r12 == null) goto L26;
            if (r12.isElem() == false) goto L24;
            if (nameHit(r6, r7, r12._name) == false) goto L24;
            this._child = r12;
            this._n++;
            goto L22
        L26:
            return null;
        L5:
            if (this._parent != r5) goto L9;
            if (cacheSame(r6, r7) == false) goto L9;
            if (r8 != 0) goto L17;
            goto L9
        }
    }

    static {
        LOG = b.a(Locale.class);
        _xsiNil = new QName(XMLSchemaSchema.XMLSchemaInstanceNamespace, "nil", "xsi");
        _xsiType = new QName(XMLSchemaSchema.XMLSchemaInstanceNamespace, "type", "xsi");
        _xsiLoc = new QName(XMLSchemaSchema.XMLSchemaInstanceNamespace, "schemaLocation", "xsi");
        _xsiNoLoc = new QName(XMLSchemaSchema.XMLSchemaInstanceNamespace, "noNamespaceSchemaLocation", "xsi");
        _openuriFragment = new QName("http://www.openuri.org/fragment", "fragment", "frag");
        _xmlFragment = new QName("xml-fragment");
        tl_scrubBuffer = ThreadLocal.withInitial($$Lambda$Locale$LwNWkGAhdef7L8M3lQe_iGGxk.INSTANCE);
    }

    private Locale(SchemaTypeLoader r3, XmlOptions r4) {
        SchemaTypeLoader r5 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        this._nthCache_A = new nthCache(this);
        this._nthCache_B = new nthCache(this);
        this._domNthCache_A = new domNthCache(this);
        this._domNthCache_B = new domNthCache(this);
        XmlOptions r6 = XmlOptions.maskNull(r4);
        this._noSync = r6.isUnsynchronized();
        this._numTempFramesLeft = 8;
        this._tempFrames = new Cur[8];
        this._qnameFactory = new DefaultQNameFactory(null);
        this._locations = new Cur.Locations(this);
        this._schemaTypeLoader = r5;
        this._validateOnSet = r6.isValidateOnSet();
        Saaj r7 = r6.getSaaj();
        this._saaj = r7;
        if (r7 == null) goto L6;
        r7.setCallback(this);
        return;
    }

    static /* synthetic */ c access$600() {
        return LOG;
    }

    private static void addNamespace(StringBuilder r1, QName r2) {
        if (r2.getNamespaceURI() != null) goto L5;
        r1.append("<no namespace>");
        return;
    L5:
        r1.append("\"");
        r1.append(r2.getNamespaceURI());
        r1.append("\"");
    }

    static void applyNamespaces(Cur r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Iterator r0 = r7.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r2.toLowerCase(java.util.Locale.ROOT).startsWith("xml") == true) goto L4;
        if (r5.namespaceForPrefix(r2, false) != null) goto L4;
        r5.push();
        r5.next();
        r5.createAttr(r5._locale.createXmlns(r2));
        r5.next();
        r5.insertString((String) ZeusTransformUtils.preCheckCast(r7.get(r2), String.class, "com.obric.memorydata.plugin"));
        r5.pop();
        goto L4
    }

    static String applyWhiteSpaceRule(String r4, int r5) {
        int r0 = 0;
        boolean r1 = false;
        if (r4 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 == 0) goto L47;
        int r3 = 1;
        if (r5 != 1) goto L11;
        return r4;
    L11:
        if (r5 != 2) goto L24;
    L12:
        if (r0 >= r2) goto L50;
        char r6 = r4.charAt(r0);
        if (r6 == '\n') goto L22;
        if (r6 == '\r') goto L22;
        if (r6 == '\t') goto L22;
        r0 = r0 + 1;
    L22:
        return processWhiteSpaceRule(r4, r5);
    L50:
        return r4;
    L24:
        if (r5 == 3) goto L26;
        return r4;
    L26:
        if (CharUtil.isWhiteSpace(r4.charAt(0)) == true) goto L38;
        if (CharUtil.isWhiteSpace(r4.charAt(r2 - 1)) == true) goto L38;
    L30:
        if (r3 >= r2) goto L51;
        boolean r7 = CharUtil.isWhiteSpace(r4.charAt(r3));
        if (r7 == false) goto L36;
        if (r1 == false) goto L36;
        return processWhiteSpaceRule(r4, r5);
    L36:
        r3 = r3 + 1;
        r1 = r7;
        goto L30
    L51:
        return r4;
    L38:
        return processWhiteSpaceRule(r4, r5);
    L47:
        return r4;
    L5:
        r2 = r4.length();
        goto L6
    }

    public static void associateSourceName(Cur r1, XmlOptions r2) {
        if (r2 != null) goto L4;
        String r3 = null;
    L5:
        if (r3 == null) goto L8;
        getDocProps(r1, true).setSourceName(r3);
        return;
    L8:
        return;
    L4:
        r3 = r2.getDocumentSourceName();
        goto L5
    }

    public static void autoTypeDocument(Cur r4, SchemaType r5, XmlOptions r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        SchemaType r8 = XmlOptions.maskNull(r6).getDocumentType();
        if (r8 == null) goto L6;
        r4.setType(r8);
        return;
    L6:
        SchemaType r9 = null;
        if (r7 != null) goto L9;
    L10:
        QName r0 = r4.getXsiTypeName();
        if (r0 != null) goto L13;
        SchemaType r1 = null;
    L14:
        if (r7 != null) goto L16;
    L19:
        if (r1 != null) goto L43;
        if (r7 != null) goto L22;
    L23:
        r4.push();
        if (r4.hasAttrs() == false) goto L26;
    L30:
        QName r2 = null;
    L31:
        r4.pop();
        if (r2 == null) goto L43;
        r1 = r4._locale._schemaTypeLoader.findDocumentType(r2);
        if (r1 == null) goto L43;
        if (r7 == null) goto L43;
        QName r3 = r7.getDocumentElementName();
        if (r3.equals(r2) == true) goto L43;
        if (r7.isValidSubstitution(r2) == true) goto L43;
        throw new XmlException("Element " + QNameHelper.pretty(r2) + " is not a valid " + QNameHelper.pretty(r3) + " document or a valid substitution.");
    L26:
        if (toFirstChildElement(r4) == false) goto L30;
        if (toNextSiblingElement(r4) == true) goto L30;
        r2 = r4.getName();
        goto L31
    L22:
        if (r7.isDocumentType() == true) goto L23;
    L43:
        if (r1 != null) goto L51;
        if (r7 != null) goto L51;
        r4.push();
        if (toFirstNormalAttr(r4) == true) goto L48;
    L50:
        r4.pop();
        r1 = r9;
        goto L51
    L48:
        if (toNextNormalAttr(r4) == true) goto L50;
        r9 = r4._locale._schemaTypeLoader.findAttributeType(r4.getName());
    L51:
        if (r1 != null) goto L53;
        r1 = r7;
    L53:
        if (r1 != null) goto L55;
        r1 = XmlBeans.NO_TYPE;
    L55:
        r4.setType(r1);
        if (r7 != null) goto L58;
        return;
    L58:
        if (r1.isDocumentType() == false) goto L61;
        verifyDocumentType(r4, r1.getDocumentElementName());
        return;
    L61:
        if (r1.isAttributeType() == false) goto L66;
        verifyAttributeType(r4, r1.getAttributeTypeAttributeName());
        return;
    L66:
        return;
    L16:
        if (r7.isAssignableFrom(r1) == true) goto L19;
    L18:
        r1 = null;
        goto L19
    L13:
        r1 = r4._locale._schemaTypeLoader.findType(r0);
        goto L14
    L9:
        if (r7.getName() == null) goto L18;
        goto L10
    }

    static boolean beginsWithXml(String r4) {
        if (r4.length() < 3) goto L18;
        char r0 = r4.charAt(0);
        if (r0 != 'x') goto L7;
    L8:
        char r1 = r4.charAt(1);
        if (r1 != 'm') goto L11;
    L12:
        char r5 = r4.charAt(2);
        if (r5 != 'l') goto L15;
        return true;
    L15:
        if (r5 != 'L') goto L18;
        return true;
    L11:
        if (r1 != 'M') goto L18;
    L7:
        if (r0 == 'X') goto L8;
    L18:
        return false;
    }

    private void doAttributes(e r6, LoadContext r7) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        int r8 = r5.getAttributeCount();
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L5;
        r7.attr(r5.getAttributeLocalName(r0), r5.getAttributeNamespace(r0), r5.getAttributePrefix(r0), r5.getAttributeValue(r0));
        r0 = r0 + 1;
        goto L3
    }

    private void doNamespaces(e r6, LoadContext r7) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        int r8 = r5.getNamespaceCount();
        int r0 = 0;
    L3:
        if (r0 >= r8) goto L12;
        String r1 = r5.getNamespacePrefix(r0);
        if (r1 != null) goto L7;
    L10:
        r7.attr("xmlns", "http://www.w3.org/2000/xmlns/", null, r5.getNamespaceURI(r0));
    L11:
        r0 = r0 + 1;
        goto L3
    L7:
        if (r1.length() == 0) goto L10;
        r7.attr(r1, "http://www.w3.org/2000/xmlns/", "xmlns", r5.getNamespaceURI(r0));
        goto L11
    }

    static Map<String, String> getAllNamespaces(Cur r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        r3.push();
        if (r3.isContainer() == true) goto L6;
        r3.toParent();
    L6:
        if (r3.toNextAttr() == true) goto L8;
        if (r3.isContainer() == true) goto L19;
        r3.toParentRaw();
    L19:
        if (r3.toParentRaw() == true) goto L6;
        r3.pop();
        return r5;
    L8:
        if (r3.isXmlns() == false) goto L6;
        String r0 = r3.getXmlnsPrefix();
        String r1 = r3.getXmlnsUri();
        if (r5 != null) goto L13;
        r5 = new HashMap();
    L13:
        if (r5.containsKey(r0) == true) goto L6;
        r5.put(r0, r1);
        goto L6
    }

    static XmlDocumentProperties getDocProps(Cur r3, boolean r4) {
        r3.push();
    L4:
        if (r3.toParent() == true) goto L4;
        DocProps r0 = (DocProps) ZeusTransformUtils.preCheckCast(r3.getBookmark(DocProps.class), DocProps.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        if (r4 == false) goto L10;
        r0 = new DocProps(null);
        r3.setBookmark(DocProps.class, r0);
    L10:
        r3.pop();
        return r0;
    }

    public static Locale getLocale(SchemaTypeLoader r4, XmlOptions r5) {
        SchemaTypeLoader r6 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r4, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        r6 = XmlBeans.getContextTypeLoader();
    L5:
        XmlOptions r7 = XmlOptions.maskNull(r5);
        Object r1 = r7.getUseSameLocale();
        if (r1 != null) goto L10;
        return new Locale(r6, r7);
    L10:
        if (ZeusTransformUtils.instanceOf(r1, Locale.class) == false) goto L13;
    L11:
        Locale r0 = (Locale) ZeusTransformUtils.preCheckCast(r1, Locale.class, "com.obric.memorydata.plugin");
        if (r0._schemaTypeLoader != r6) goto L33;
        Saaj r8 = r0._saaj;
        if (r8 == null) goto L25;
        if (r8 == r7.getSaaj()) goto L25;
        throw new IllegalArgumentException("Source locale does not support same saaj");
    L25:
        if (r0._validateOnSet == true) goto L27;
    L31:
        return r0;
    L27:
        if (r7.isValidateOnSet() == true) goto L31;
        throw new IllegalArgumentException("Source locale does not support same validate on set");
    L33:
        throw new IllegalArgumentException("Source locale does not support same schema type loader");
    L13:
        if (ZeusTransformUtils.instanceOf(r1, XmlTokenSource.class) == false) goto L35;
        r1 = ((XmlTokenSource) ZeusTransformUtils.preCheckCast(r1, XmlTokenSource.class, "com.obric.memorydata.plugin")).monitor();
        goto L11
    L35:
        throw new IllegalArgumentException("Source locale not understood: " + r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static SaxLoader getSaxLoader(XmlOptions r2) {
        XmlOptions r3 = XmlOptions.maskNull(r2);
        EntityResolver r1 = null;
        Object[] r4 = 0;
        if (r3.isLoadUseDefaultResolver() == true) goto L10;
        EntityResolver r0 = r3.getEntityResolver();
        if (r0 != null) goto L7;
        r0 = ResolverUtil.getGlobalEntityResolver();
    L7:
        if (r0 != null) goto L9;
        r0 = new DefaultEntityResolver(r4 == true ? 1 : 0);
    L9:
        r1 = r0;
    L10:
        XMLReader r5 = r3.getLoadUseXMLReader();
        if (r5 == null) goto L21;
    L17:
        XmlReaderSaxLoader r6 = new XmlReaderSaxLoader(r5);
        if (r1 == null) goto L20;
        r5.setEntityResolver(r1);
    L20:
        return r6;
    L21:
        r5 = SAXHelper.newXMLReader(new XmlOptions(r3));     // Catch: Exception -> L14
    L14:
        e = move-exception;
        throw new XmlException("Problem creating XMLReader", e);
    }

    static ScrubBuffer getScrubBuffer(int r4) {
        ThreadLocal<SoftReference<ScrubBuffer>> r0 = tl_scrubBuffer;
        ScrubBuffer r1 = (ScrubBuffer) ZeusTransformUtils.preCheckCast(((SoftReference) ZeusTransformUtils.preCheckCast(r0.get(), SoftReference.class, "com.obric.memorydata.plugin")).get(), ScrubBuffer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = new ScrubBuffer();
        r0.set(new SoftReference(r1));
    L5:
        r1.init(r4);
        return r1;
    }

    static String getTextValue(Cur r4) {
        if (r4.hasChildren() == false) goto L5;
        StringBuffer r0 = new StringBuffer();
        r4.push();
    L7:
        r4.next();
        if (r4.isAtEndOfLastPush() == true) goto L19;
        if (r4.isText() == false) goto L7;
        if (r4._xobj.isComment() == true) goto L16;
        if (r4._xobj.isProcinst() == true) goto L16;
    L18:
        CharUtil.getString(r0, r4.getChars(-1), r4._offSrc, r4._cchSrc);
    L16:
        if (r4._pos >= r4._xobj._cchValue) goto L18;
    L19:
        r4.pop();
        return r0.toString();
    L5:
        return r4.getValueAsString();
    }

    static boolean isFragment(Cur r5, Cur r6) {
        r5.push();
        r6.push();
        int r1 = 0;
    L4:
        if (r5.isSamePos(r6) == true) goto L20;
        int r2 = r5.kind();
        if (r2 == 3) goto L20;
        if (r2 != 0) goto L13;
        if (isWhiteSpace(r5.getCharsAsString()) == true) goto L13;
    L11:
        boolean r3 = true;
    L21:
        r5.pop();
        r6.pop();
        if (r3 == true) goto L25;
        if (r1 != 1) goto L25;
        return false;
    L25:
        return true;
    L13:
        if (r2 != 2) goto L17;
        r1 = r1 + 1;
        if (r1 > 1) goto L11;
    L17:
        if (r2 == 0) goto L19;
        r5.toEnd();
    L19:
        r5.next();
    L20:
        r3 = false;
        goto L21
    }

    static boolean isFragmentQName(QName r1) {
        if (r1.equals(_openuriFragment) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.equals(_xmlFragment) == true) goto L8;
        return false;
    }

    static boolean isWhiteSpace(String r2) {
        int r0 = r2.length();
    L3:
        int r1 = r0 - 1;
        if (r0 <= 0) goto L10;
        if (CharUtil.isWhiteSpace(r2.charAt(r1)) == false) goto L7;
        r0 = r1;
        goto L3
    L7:
        return false;
    L10:
        return true;
    }

    static boolean isXmlns(QName r4) {
        String r0 = r4.getPrefix();
        if (r0.equals("xmlns") == false) goto L6;
        return true;
    L6:
        if (r0.length() == 0) goto L8;
    L10:
        return false;
    L8:
        if (r4.getLocalPart().equals("xmlns") == false) goto L10;
        return true;
    }

    static /* synthetic */ XmlObject lambda$newInstance$0(XmlOptions r2, SchemaType r3, Locale r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        Cur r6 = r4.tempCur();
        SchemaType r7 = XmlOptions.maskNull(r2).getDocumentType();
        if (r7 != null) goto L8;
        if (r5 != null) goto L6;
        r5 = XmlObject.type;
    L6:
        r7 = r5;
    L8:
        if (r7.isDocumentType() == false) goto L10;
        r6.createDomDocumentRoot();
    L11:
        r6.setType(r7);
        XmlObject r8 = (XmlObject) ZeusTransformUtils.preCheckCast(r6.getUser(), XmlObject.class, "com.obric.memorydata.plugin");
        r6.release();
        return r8;
    L10:
        r6.createRoot();
        goto L11
    }

    static /* synthetic */ XmlObject lambda$parseToXmlObject$1(String r3, XmlOptions r4, SchemaType r5, Locale r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        StringReader r0 = new StringReader(r3);
        Cur r8 = getSaxLoader(r4).load(r6, new InputSource(r0), r4);     // Catch: Throwable -> L6
        autoTypeDocument(r8, r7, r4);     // Catch: Throwable -> L6
        XmlObject r9 = (XmlObject) ZeusTransformUtils.preCheckCast(r8.getUser(), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        r8.release();     // Catch: Throwable -> L6
        r0.close();
        return r9;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    static /* synthetic */ XmlObject lambda$parseToXmlObject$2(e r2, XmlOptions r3, SchemaType r4, Locale r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        Cur r8 = r5.loadXMLStreamReader(r6, r3);     // Catch: XMLStreamException -> L6
        autoTypeDocument(r8, r7, r3);
        XmlObject r9 = (XmlObject) ZeusTransformUtils.preCheckCast(r8.getUser(), XmlObject.class, "com.obric.memorydata.plugin");
        r8.release();
        return r9;
    L6:
        e = move-exception;
        throw new XmlException(e.getMessage(), e);
    }

    static /* synthetic */ XmlObject lambda$parseToXmlObject$3(XmlOptions r3, InputStream r4, SchemaType r5, Locale r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        Cur r8 = getSaxLoader(r3).load(r6, new InputSource(r4), r3);
        autoTypeDocument(r8, r7, r3);
        XmlObject r9 = (XmlObject) ZeusTransformUtils.preCheckCast(r8.getUser(), XmlObject.class, "com.obric.memorydata.plugin");
        r8.release();
        return r9;
    }

    static /* synthetic */ XmlObject lambda$parseToXmlObject$5(XmlOptions r2, Node r3, SchemaType r4, Locale r5) {
        Node r6 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        Cur.CurLoadContext r0 = new Cur.CurLoadContext(r5, r2);
        r5.loadNode(r6, r0);
        Cur r8 = r0.finish();
        associateSourceName(r8, r2);
        autoTypeDocument(r8, r7, r2);
        XmlObject r9 = (XmlObject) ZeusTransformUtils.preCheckCast(r8.getUser(), XmlObject.class, "com.obric.memorydata.plugin");
        r8.release();
        return r9;
    }

    static /* synthetic */ SoftReference lambda$static$7() {
        return new SoftReference(new ScrubBuffer());
    }

    private static void lineNumber(e r2, LoadContext r3) {
        a r4 = ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin")).getLocation();
        if (r4 == null) goto L6;
        r3.lineNumber(r4.getLineNumber(), r4.getColumnNumber(), r4.getCharacterOffset());
        return;
    }

    private DomImpl.Dom load(InputSource r2, XmlOptions r3) {
        return getSaxLoader(r3).load(this, r2, r3).getDom();
    }

    private void loadNodeChildren(Node r3, LoadContext r4) {
        Node r5 = ((Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin")).getFirstChild();
    L3:
        if (r5 == null) goto L5;
        loadNode(r5, r4);
        r5 = r5.getNextSibling();
        goto L3
    }

    private Cur loadXMLStreamReader(e r10, XmlOptions r11) {
        e r12 = (e) ZeusTransformUtils.wrapperContextForParams(r10, e.class, "com.obric.memorydata.plugin");
        XmlOptions r13 = XmlOptions.maskNull(r11);
        boolean r0 = r13.isLoadLineNumbers();
        Cur.CurLoadContext r1 = new Cur.CurLoadContext(this, r13);
        int r2 = r12.getEventType();
        int r3 = 0;
        String r5 = null;
        String r6 = null;
        boolean r4 = false;
    L3:
        switch(r2) {
            case 1: goto L26;
            case 2: goto L23;
            case 3: goto L20;
            case 4: goto L17;
            case 5: goto L14;
            case 6: goto L32;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L32;
            case 12: goto L17;
            case 13: goto L30;
            default: goto L5;
        };
    L6:
        doAttributes(r12, r1);
        goto L32
    L7:
        r1.text(r12.getText());
        goto L32
    L10:
        r3 = r3 + 1;
        String r7 = r12.getCharacterEncodingScheme();
        String r8 = r12.getVersion();
        boolean r9 = r12.isStandalone();
        if (r0 == false) goto L13;
        lineNumber(r12, r1);
    L13:
        r6 = r8;
        r4 = r9;
        r5 = r7;
        goto L32
    L14:
        r1.comment(r12.getText());
        if (r0 == false) goto L32;
    L22:
        lineNumber(r12, r1);
        goto L32
    L17:
        r1.text(r12.getTextCharacters(), r12.getTextStart(), r12.getTextLength());
        if (r0 == false) goto L32;
    L20:
        r1.procInst(r12.getPITarget(), r12.getPIData());
        if (r0 == false) goto L32;
    L23:
        r3 = r3 - 1;
        r1.endElement();
        if (r0 == false) goto L32;
    L26:
        r3 = r3 + 1;
        r1.startElement(r12.getName());
        if (r0 == false) goto L29;
        lineNumber(r12, r1);
    L29:
        doAttributes(r12, r1);
    L30:
        doNamespaces(r12, r1);
    L32:
        if (r12.hasNext() == false) goto L36;
        if (r3 <= 0) goto L36;
        r2 = r12.next();
    L36:
        Cur r14 = r1.finish();
        associateSourceName(r14, r13);
        XmlDocumentProperties r15 = getDocProps(r14, true);
        r15.setEncoding(r5);
        r15.setVersion(r6);
        r15.setStandalone(r4);
        return r14;
    L5:
        throw new RuntimeException("Unhandled xml event type: " + r2);
    L8:
        if (r0 == false) goto L36;
        lineNumber(r12, r1);
        goto L36
    }

    private static boolean namespacesSame(QName r0, QName r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        if (r0 == null) goto L10;
        if (r1 != null) goto L9;
        return false;
    L9:
        return Objects.equals(r0.getNamespaceURI(), r1.getNamespaceURI());
    L10:
        return false;
    }

    public static XmlObject newInstance(SchemaTypeLoader r2, SchemaType r3, final XmlOptions r4) {
        SchemaTypeLoader r5 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r2, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        final SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        return (XmlObject) ZeusTransformUtils.preCheckCast(syncWrap(r5, r4, new $$Lambda$Locale$TH8wXiSAtPhlFujFXkwekvStLP0(r4, r6)), XmlObject.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader r2, final InputStream r3, SchemaType r4, final XmlOptions r5) {
        SchemaTypeLoader r6 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r2, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        final SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        return (XmlObject) ZeusTransformUtils.preCheckCast(syncWrap(r6, r5, new $$Lambda$Locale$R3Cuio_p3eMRApdpvCBLexFmKjQ(r5, r3, r7)), XmlObject.class, "com.obric.memorydata.plugin");
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader r2, final String r3, SchemaType r4, final XmlOptions r5) {
        SchemaTypeLoader r6 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r2, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        final SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        return (XmlObject) ZeusTransformUtils.preCheckCast(syncWrap(r6, r5, new $$Lambda$Locale$TXUPTposnU3nGquXXX72xLOSrLM(r3, r5, r7)), XmlObject.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new XmlException(e.getMessage(), e);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader r2, e r3, SchemaType r4, final XmlOptions r5) {
        SchemaTypeLoader r6 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r2, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        final e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        final SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        return (XmlObject) ZeusTransformUtils.preCheckCast(syncWrap(r6, r5, new $$Lambda$Locale$Ry17EytpOvuFkqWiMMOnTp1eSF4(r7, r5, r8)), XmlObject.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader r2, Node r3, SchemaType r4, final XmlOptions r5) {
        SchemaTypeLoader r6 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r2, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        final Node r7 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        final SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        return (XmlObject) ZeusTransformUtils.preCheckCast(syncWrap(r6, r5, new $$Lambda$Locale$t9pWhjxkGBB6qTVJ4XKkYkjUlLw(r5, r7, r8)), XmlObject.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void pollQueue() {
        if (this._refQueue == null) goto L10;
    L4:
        Ref r0 = (Ref) ZeusTransformUtils.preCheckCast(this._refQueue.poll(), Ref.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L16;
        if (r0._cur == null) goto L4;
        r0._cur.release();
        goto L4
    L16:
        return;
    }

    static String processWhiteSpaceRule(String r2, int r3) {
        ScrubBuffer r4 = getScrubBuffer(r3);
        r4.scrub(r2, 0, r2.length());
        return r4.getResultAsString();
    }

    static boolean pushToContainer(Cur r3) {
        r3.push();
    L3:
        int r0 = r3.kind();
        if (r0 == (-2)) goto L18;
        if (r0 == (-1)) goto L18;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L17;
        if (r0 == 4) goto L16;
        if (r0 == 5) goto L16;
        r3.nextWithAttrs();
    L16:
        r3.skip();
    L17:
        return true;
    L18:
        r3.pop();
        return false;
    }

    private static <T> T syncWrap(SchemaTypeLoader r2, XmlOptions r3, SyncWrapFun<T> r4) {
        SchemaTypeLoader r5 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r2, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        SyncWrapFun r6 = (SyncWrapFun) ZeusTransformUtils.wrapperContextForParams(r4, SyncWrapFun.class, "com.obric.memorydata.plugin");
        Locale r7 = getLocale(r5, r3);
        if (r7.noSync() == false) goto L11;
        r7.enter();
        T r8 = (T) r6.parse(r7);
        r7.exit();
        return r8;
    L8:
        th = move-exception;
        r7.exit();
        throw th;
    L11:
        monitor-enter(r7);
        r7.enter();     // Catch: Throwable -> L20
        T r9 = (T) r6.parse(r7);
        r7.exit();     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
        return r9;
    L17:
        th = move-exception;
        r7.exit();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    static boolean toChild(Cur r3, QName r4, int r5) {
        if (r5 >= 0) goto L4;
        return false;
    L4:
        if (pushToContainer(r3) == false) goto L11;
        Xobj r6 = r3._locale.findNthChildElem(r3._xobj, r4, null, r5);
        r3.pop();
        if (r6 == null) goto L12;
        r3.moveTo(r6);
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static boolean toFirstChildElement(Cur r6) {
        Xobj r0 = r6._xobj;
        int r1 = r6._pos;
    L3:
        int r2 = r6.kind();
        if (r2 == (-2)) goto L27;
        if (r2 == (-1)) goto L27;
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L18;
        if (r2 == 4) goto L16;
        if (r2 == 5) goto L16;
        r6.nextWithAttrs();
    L16:
        r6.skip();
    L18:
        if (r6.toFirstChild() == true) goto L20;
    L25:
        r6.moveTo(r0, r1);
        return false;
    L20:
        if (r6.isElem() == false) goto L22;
    L24:
        return true;
    L22:
        if (toNextSiblingElement(r6) == true) goto L24;
    L27:
        r6.moveTo(r0, r1);
        return false;
    }

    static boolean toFirstNormalAttr(Cur r1) {
        r1.push();
        if (r1.toFirstAttr() == true) goto L5;
    L10:
        r1.pop();
        return false;
    L5:
        if (r1.isXmlns() == false) goto L6;
        if (r1.toNextAttr() == true) goto L5;
    L6:
        r1.popButStay();
        return true;
    }

    static boolean toNextNormalAttr(Cur r1) {
        r1.push();
    L4:
        if (r1.toNextAttr() == false) goto L9;
        if (r1.isXmlns() == true) goto L4;
        r1.popButStay();
        return true;
    L9:
        r1.pop();
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002c -> B:8:0x0016). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x002e -> B:8:0x0016). Please report as a decompilation issue!!! */
    static boolean toNextSiblingElement(Cur r4) {
        if (r4.hasParent() == true) goto L5;
        return false;
    L5:
        r4.push();
        int r0 = r4.kind();
        if (r0 != 3) goto L9;
        r4.toParent();
    L8:
        r4.next();
    L11:
        int r1 = r4.kind();
        if (r1 < 0) goto L18;
        if (r1 != 2) goto L16;
        r4.popButStay();
        return true;
    L16:
        if (r1 <= 0) goto L8;
        r4.toEnd();
        goto L8
    L18:
        r4.pop();
        return false;
    L9:
        if (r0 != 2) goto L11;
        r4.skip();
        goto L11
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0022 -> B:5:0x000f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0024 -> B:5:0x000f). Please report as a decompilation issue!!! */
    static boolean toNextSiblingElement(Cur r5, Xobj r6) {
        Xobj r0 = r5._xobj;
        int r1 = r5._pos;
        int r2 = r5.kind();
        if (r2 != 3) goto L6;
        r5.moveTo(r6);
    L5:
        r5.next();
    L8:
        int r7 = r5.kind();
        if (r7 < 0) goto L15;
        if (r7 != 2) goto L13;
        return true;
    L13:
        if (r7 <= 0) goto L5;
        r5.toEnd();
        goto L5
    L15:
        r5.moveTo(r0, r1);
        return false;
    L6:
        if (r2 != 2) goto L8;
        r5.skip();
        goto L8
    }

    private static void verifyAttributeType(Cur r6, QName r7) {
        r6.push();
    L31:
        th = move-exception;
        r6.pop();
        throw th;
    L5:
        if (toFirstNormalAttr(r6) == true) goto L7;
    L21:
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L31
        r3.append("The document is not a ");     // Catch: Throwable -> L31
        r3.append(QNameHelper.pretty(r7));     // Catch: Throwable -> L31
        if (r6.isRoot() == false) goto L24;
        String r8 = ": no attributes";
    L19:
        r3.append(r8);     // Catch: Throwable -> L31
    L26:
        if (r3 != null) goto L29;
        r6.pop();
        return;
    L29:
        XmlError r9 = XmlError.forCursor(r3.toString(), new Cursor(r6));     // Catch: Throwable -> L31
        throw new XmlException(r9.toString(), null, r9);     // Catch: Throwable -> L31
    L24:
        r8 = ": multiple attributes";
        goto L19
    L7:
        if (toNextNormalAttr(r6) == true) goto L21;
        QName r0 = r6.getName();     // Catch: Throwable -> L31
        if (r0.equals(r7) == true) goto L20;
        r3 = new StringBuilder();     // Catch: Throwable -> L31
        r3.append("The document is not a ");     // Catch: Throwable -> L31
        r3.append(QNameHelper.pretty(r7));     // Catch: Throwable -> L31
        if (r7.getLocalPart().equals(r0.getLocalPart()) == false) goto L16;
        r3.append(": attribute namespace mismatch ");     // Catch: Throwable -> L31
        r3.append("expected ");     // Catch: Throwable -> L31
        addNamespace(r3, r7);     // Catch: Throwable -> L31
        r3.append(" got ");     // Catch: Throwable -> L31
        addNamespace(r3, r0);     // Catch: Throwable -> L31
        goto L26
    L16:
        if (namespacesSame(r7, r0) == false) goto L18;
        r3.append(": attribute local name mismatch ");     // Catch: Throwable -> L31
        r3.append("expected ").append(r7.getLocalPart());     // Catch: Throwable -> L31
        r3.append(" got ").append(r0.getLocalPart());     // Catch: Throwable -> L31
        goto L26
    L18:
        r3.append(": attribute element mismatch ");     // Catch: Throwable -> L31
        r3.append("got ");     // Catch: Throwable -> L31
        r8 = QNameHelper.pretty(r0);     // Catch: Throwable -> L31
        goto L19
    L20:
        r3 = null;
        goto L26
    }

    private static void verifyDocumentType(Cur r5, QName r6) {
        r5.push();
    L31:
        th = move-exception;
        r5.pop();
        throw th;
    L5:
        if (toFirstChildElement(r5) == true) goto L7;
    L21:
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L31
        r3.append("The document is not a ");     // Catch: Throwable -> L31
        r3.append(QNameHelper.pretty(r6));     // Catch: Throwable -> L31
        if (r5.isRoot() == false) goto L24;
        String r7 = ": no document element";
    L19:
        r3.append(r7);     // Catch: Throwable -> L31
    L26:
        if (r3 != null) goto L29;
        r5.pop();
        return;
    L29:
        XmlError r8 = XmlError.forCursor(r3.toString(), new Cursor(r5));     // Catch: Throwable -> L31
        throw new XmlException(r8.toString(), null, r8);     // Catch: Throwable -> L31
    L24:
        r7 = ": multiple document elements";
        goto L19
    L7:
        if (toNextSiblingElement(r5) == true) goto L21;
        QName r0 = r5.getName();     // Catch: Throwable -> L31
        if (r0.equals(r6) == true) goto L20;
        r3 = new StringBuilder();     // Catch: Throwable -> L31
        r3.append("The document is not a ");     // Catch: Throwable -> L31
        r3.append(QNameHelper.pretty(r6));     // Catch: Throwable -> L31
        if (r6.getLocalPart().equals(r0.getLocalPart()) == false) goto L16;
        r3.append(": document element namespace mismatch ");     // Catch: Throwable -> L31
        r3.append("expected ");     // Catch: Throwable -> L31
        addNamespace(r3, r6);     // Catch: Throwable -> L31
        r3.append(" got ");     // Catch: Throwable -> L31
        addNamespace(r3, r0);     // Catch: Throwable -> L31
        goto L26
    L16:
        if (namespacesSame(r6, r0) == false) goto L18;
        r3.append(": document element local name mismatch expected ").append(r6.getLocalPart()).append(" got ").append(r0.getLocalPart());     // Catch: Throwable -> L31
        goto L26
    L18:
        r3.append(": document element mismatch got ");     // Catch: Throwable -> L31
        r7 = QNameHelper.pretty(r0);     // Catch: Throwable -> L31
        goto L19
    L20:
        r3 = null;
        goto L26
    }

    static String xmlnsPrefix(QName r2) {
        if (r2.getPrefix().equals("xmlns") == true) goto L7;
        return "";
    L7:
        return r2.getLocalPart();
    }

    int count(Xobj r2, QName r3, QNameSet r4) {
        int r0 = 0;
        Xobj r1 = findNthChildElem(r2, r3, r4, 0);
    L3:
        if (r1 == null) goto L15;
        if (r1.isElem() == false) goto L14;
        QName r5 = r1._name;
        if (r4 != null) goto L12;
        if (r5.equals(r3) == false) goto L14;
    L13:
        r0 = r0 + 1;
        goto L14
    L12:
        if (r4.contains(r5) == true) goto L13;
    L14:
        r1 = r1._nextSibling;
        goto L3
    L15:
        return r0;
    }

    CdataNode createCdataNode() {
        if (this._saaj != null) goto L6;
        return new CdataNode(this);
    L6:
        return new SaajCdataNode(this);
    }

    @Override // org.w3c.dom.DOMImplementation
    public Document createDocument(String r3, String r4, DocumentType r5) {
        return DomImpl._domImplementation_createDocument(this, r3, r4, (DocumentType) ZeusTransformUtils.wrapperContextForParams(r5, DocumentType.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.DOMImplementation
    public DocumentType createDocumentType(String r1, String r2, String r3) {
        throw new RuntimeException("Not implemented");
    }

    TextNode createTextNode() {
        if (this._saaj != null) goto L6;
        return new TextNode(this);
    L6:
        return new SaajTextNode(this);
    }

    QName createXmlns(String r5) {
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r5.length() != 0) goto L9;
        return makeQName("http://www.w3.org/2000/xmlns/", "xmlns", "");
    L9:
        return makeQName("http://www.w3.org/2000/xmlns/", r5, "xmlns");
    }

    int domLength(DomImpl.Dom r4) {
        DomImpl.Dom r5 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r4, DomImpl.Dom.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = this._domNthCache_A.distance(r5, 0);
        int r0 = this._domNthCache_B.distance(r5, 0);
        if (r1 > r0) goto L8;
        domNthCache r2 = this._domNthCache_A;
    L9:
        int r6 = r2.length(r5);
        if (r1 != r0) goto L12;
        domNthCache r3 = this._domNthCache_A;
        this._domNthCache_A = this._domNthCache_B;
        this._domNthCache_B = r3;
    L12:
        return r6;
    L8:
        r2 = this._domNthCache_B;
        goto L9
    }

    void embedCurs() {
    L2:
        Cur r0 = this._registered;
        if (r0 == null) goto L5;
        this._registered = r0.listRemove(r0);
        Xobj r1 = r0._xobj;
        r1._embedded = r0.listInsert(r0._xobj._embedded);
        r0._state = 2;
        goto L2
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void enter() {
        int r0 = this._numTempFramesLeft - 1;
        this._numTempFramesLeft = r0;
        if (r0 > 0) goto L5;
        Cur[] r1 = this._tempFrames;
        Cur[] r2 = new Cur[r1.length * 2];
        this._numTempFramesLeft = r1.length;
        System.arraycopy(r1, 0, r2, 0, r1.length);
        this._tempFrames = r2;
    L5:
        int r3 = this._entryCount + 1;
        this._entryCount = r3;
        if (r3 <= 1000) goto L9;
        pollQueue();
        this._entryCount = 0;
        return;
    }

    public void enter(Locale r1) {
        enter();
        if (r1 == this) goto L6;
        r1.enter();
        return;
    }

    boolean entered() {
        if ((this._tempFrames.length - this._numTempFramesLeft) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void exit() {
        int r0 = this._tempFrames.length;
        int r1 = this._numTempFramesLeft + 1;
        this._numTempFramesLeft = r1;
        int r2 = r0 - r1;
    L3:
        Cur[] r3 = this._tempFrames;
        if (r3[r2] == null) goto L6;
        r3[r2].release();
        goto L3
    }

    public void exit(Locale r1) {
        exit();
        if (r1 == this) goto L6;
        r1.exit();
        return;
    }

    DomImpl.Dom findDomNthChild(DomImpl.Dom r7, int r8) {
        DomImpl.Dom r9 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r7, DomImpl.Dom.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L6;
        return null;
    L6:
        int r0 = this._domNthCache_A.distance(r9, r8);
        int r1 = this._domNthCache_B.distance(r9, r8);
        boolean r3 = true;
        if ((r1 - (domNthCache.access$200(this._domNthCache_B) / 2)) > 0) goto L9;
    L11:
        boolean r2 = false;
    L13:
        if ((r0 - (domNthCache.access$200(this._domNthCache_A) / 2)) > 0) goto L15;
    L17:
        r3 = false;
    L19:
        if (r0 > r1) goto L23;
        if (r3 == false) goto L26;
        domNthCache.access$302(this._domNthCache_B, -1);
    L24:
        domNthCache r4 = this._domNthCache_B;
    L27:
        DomImpl.Dom r10 = r4.fetch(r9, r8);
        if (r0 != r1) goto L30;
        domNthCache r11 = this._domNthCache_A;
        this._domNthCache_A = this._domNthCache_B;
        this._domNthCache_B = r11;
    L30:
        return r10;
    L26:
        r4 = this._domNthCache_A;
        goto L27
    L23:
        if (r2 == false) goto L24;
        domNthCache.access$302(this._domNthCache_A, -1);
        goto L26
    L15:
        if (((r0 - (domNthCache.access$200(this._domNthCache_A) / 2)) - 40) <= 0) goto L17;
    L9:
        if (((r1 - (domNthCache.access$200(this._domNthCache_B) / 2)) - 40) <= 0) goto L11;
        r2 = true;
        goto L13
    }

    Xobj findNthChildElem(Xobj r4, QName r5, QNameSet r6, int r7) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = this._nthCache_A.distance(r4, r5, r6, r7);
        int r1 = this._nthCache_B.distance(r4, r5, r6, r7);
        if (r0 > r1) goto L8;
        nthCache r2 = this._nthCache_A;
    L9:
        Xobj r8 = r2.fetch(r4, r5, r6, r7);
        if (r0 != r1) goto L12;
        nthCache r9 = this._nthCache_A;
        this._nthCache_A = this._nthCache_B;
        this._nthCache_B = r9;
    L12:
        return r8;
    L8:
        r2 = this._nthCache_B;
        goto L9
    }

    CharUtil getCharUtil() {
        if (this._charUtil != null) goto L6;
        this._charUtil = new CharUtil(1024);
    L6:
        return this._charUtil;
    }

    Cur getCur() {
        Cur r0 = this._curPool;
        if (r0 != null) goto L5;
        r0 = new Cur(this);
    L6:
        this._registered = r0.listInsert(this._registered);
        r0._state = 1;
        return r0;
    L5:
        this._curPool = r0.listRemove(r0);
        this._curPoolCount--;
        goto L6
    }

    @Override // org.w3c.dom.DOMImplementation
    public Object getFeature(String r1, String r2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public SchemaTypeLoader getSchemaTypeLoader() {
        return this._schemaTypeLoader;
    }

    @Override // org.w3c.dom.DOMImplementation
    public boolean hasFeature(String r1, String r2) {
        return DomImpl._domImplementation_hasFeature(this, r1, r2);
    }

    void invalidateDomCaches(DomImpl.Dom r4) {
        DomImpl.Dom r5 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r4, DomImpl.Dom.class, "com.obric.memorydata.plugin");
        if (domNthCache.access$400(this._domNthCache_A) != r5) goto L6;
        domNthCache.access$302(this._domNthCache_A, -1);
    L6:
        if (domNthCache.access$400(this._domNthCache_B) != r5) goto L9;
        domNthCache.access$302(this._domNthCache_B, -1);
        return;
    }

    public DomImpl.Dom load(Reader r2, XmlOptions r3) {
        return load(new InputSource(r2), r3);
    }

    public DomImpl.Dom load(String r2) {
        return load(r2, null);
    }

    public DomImpl.Dom load(String r2, XmlOptions r3) {
        StringReader r0 = new StringReader(r2);     // Catch: IOException -> L14
        DomImpl.Dom r1 = load(r0, r3);     // Catch: Throwable -> L6
        r0.close();     // Catch: IOException -> L14
        return r1;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: IOException -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    L14:
        e = move-exception;
        throw new XmlException(e.getMessage(), e);
    }

    public void loadNode(Node r8, LoadContext r9) {
        Node r10 = (Node) ZeusTransformUtils.wrapperContextForParams(r8, Node.class, "com.obric.memorydata.plugin");
        switch(r10.getNodeType()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            case 9: goto L10;
            case 10: goto L7;
            case 11: goto L10;
            case 12: goto L7;
            default: goto L37;
        };
    L5:
        r9.comment(r10.getNodeValue());
        return;
    L6:
        r9.procInst(r10.getNodeName(), r10.getNodeValue());
        return;
    L7:
        Node r11 = r10.getNextSibling();
        if (r11 == null) goto L33;
        loadNode(r11, r9);
        return;
    L33:
        return;
    L10:
        loadNodeChildren(r10, r9);
        return;
    L11:
        r9.text(r10.getNodeValue());
        return;
    L14:
        r9.startElement(makeQualifiedQName(r10.getNamespaceURI(), r10.getNodeName()));
        NamedNodeMap r0 = r10.getAttributes();
        int r1 = 0;
    L16:
        if (r1 >= r0.getLength()) goto L26;
        Node r2 = r0.item(r1);
        String r3 = r2.getNodeName();
        String r4 = r2.getNodeValue();
        if (r3.toLowerCase(java.util.Locale.ROOT).startsWith("xmlns") == true) goto L20;
        r9.attr(makeQualifiedQName(r2.getNamespaceURI(), r3), r4);
    L25:
        r1 = r1 + 1;
        goto L16
    L20:
        if (r3.length() != 5) goto L22;
        String r5 = null;
    L23:
        r9.xmlns(r5, r4);
        goto L25
    L22:
        r5 = r3.substring(6);
        goto L23
    L26:
        loadNodeChildren(r10, r9);
        r9.endElement();
        return;
    L37:
        return;
    L13:
        throw new RuntimeException("Unexpected node");
    }

    QName makeQName(String r1, String r2) {
        return this._qnameFactory.getQName(r1, r2);
    }

    QName makeQName(String r1, String r2, String r3) {
        QNameFactory r0 = this._qnameFactory;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        return r0.getQName(r1, r2, r3);
    }

    QName makeQNameNoCheck(String r1, String r2) {
        return this._qnameFactory.getQName(r1, r2);
    }

    QName makeQualifiedQName(String r4, String r5) {
        if (r5 != null) goto L4;
        r5 = "";
    L4:
        int r0 = r5.indexOf(58);
        QNameFactory r3 = this._qnameFactory;
        if (r0 >= 0) goto L8;
        return r3.getQName(r4, r5);
    L8:
        return r3.getQName(r4, r5.substring(r0 + 1), r5.substring(0, r0));
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean noSync() {
        return this._noSync;
    }

    void notifyChange() {
    L2:
        ChangeListener r0 = this._changeListeners;
        if (r0 == null) goto L8;
        r0.notifyChange();
        ChangeListener r1 = this._changeListeners.getNextChangeListener();
        ChangeListener r2 = this._changeListeners;
        if (r1 != r2) goto L7;
        r2.setNextChangeListener(null);
    L7:
        ChangeListener r3 = this._changeListeners.getNextChangeListener();
        this._changeListeners.setNextChangeListener(null);
        this._changeListeners = r3;
        goto L2
    L8:
        this._locations.notifyChange();
    }

    final ReferenceQueue<Ref> refQueue() {
        if (this._refQueue != null) goto L6;
        this._refQueue = new ReferenceQueue();
    L6:
        return this._refQueue;
    }

    void registerForChange(ChangeListener r3) {
        ChangeListener r4 = (ChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ChangeListener.class, "com.obric.memorydata.plugin");
        if (r4.getNextChangeListener() != null) goto L10;
        ChangeListener r0 = this._changeListeners;
        if (r0 != null) goto L7;
        r4.setNextChangeListener(r4);
    L8:
        this._changeListeners = r4;
        return;
    L7:
        r4.setNextChangeListener(r0);
        goto L8
    }

    Cur tempCur() {
        return tempCur(null);
    }

    Cur tempCur(String r5) {
        Cur r0 = getCur();
        Cur[] r1 = this._tempFrames;
        int r2 = (r1.length - this._numTempFramesLeft) - 1;
        Cur r3 = r1[r2];
        r0._nextTemp = r3;
        if (r3 == null) goto L5;
        r3._prevTemp = r0;
    L5:
        this._tempFrames[r2] = r0;
        r0._tempFrame = r2;
        r0._id = r5;
        return r0;
    }

    public long version() {
        return this._versionAll;
    }

    Cur weakCur(Object r2) {
        Cur r1 = getCur();
        r1._ref = new Ref(r1, r2);
        return r1;
    }
}
