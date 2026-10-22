package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintStream;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPFaultElement;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.values.TypeStoreUser;

/* JADX INFO: loaded from: classes7.dex */
public final class Cur {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int _cchSrc;
    String _id;
    Locale _locale;
    Cur _next;
    Cur _nextTemp;
    int _offSrc;
    int _pos;
    private int _posTemp;
    Cur _prev;
    Cur _prevTemp;
    Locale.Ref _ref;
    int _selectionCount;
    int _selectionFirst;
    int _selectionLoc;
    int _selectionN;
    int _stackTop;
    int _state;
    int _tempFrame;
    Xobj _xobj;

    public static final class CurLoadContext extends Locale.LoadContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Map<String, String> _additionalNamespaces;
        private boolean _after;
        private final CharUtil _charUtil;
        private final boolean _discardDocElem;
        private String _doctypeName;
        private String _doctypePublicId;
        private String _doctypeSystemId;
        private Xobj _frontier;
        private int _lastPos;
        private Xobj _lastXobj;
        private final Locale _locale;
        private final QName _replaceDocElem;
        private final boolean _stripComments;
        private boolean _stripLeft;
        private final boolean _stripProcinsts;
        private final boolean _stripWhitespace;
        private final Map<String, String> _substituteNamespaces;

        static {
        }

        public CurLoadContext(Locale r5, XmlOptions r6) {
            this._stripLeft = true;
            XmlOptions r7 = XmlOptions.maskNull(r6);
            this._locale = r5;
            if (r7.isLoadUseLocaleCharUtil() == false) goto L5;
            CharUtil r0 = r5.getCharUtil();
        L6:
            this._charUtil = r0;
            Xobj r1 = Cur.createDomDocumentRootXobj(r5);
            this._frontier = r1;
            this._after = false;
            this._lastXobj = r1;
            this._lastPos = 0;
            this._replaceDocElem = r7.getLoadReplaceDocumentElement();
            this._discardDocElem = r7.hasOption(XmlOptions.XmlOptionsKeys.LOAD_REPLACE_DOCUMENT_ELEMENT);
            this._stripWhitespace = r7.isSetLoadStripWhitespace();
            this._stripComments = r7.isLoadStripComments();
            this._stripProcinsts = r7.isLoadStripProcinsts();
            this._substituteNamespaces = r7.getLoadSubstituteNamespaces();
            this._additionalNamespaces = r7.getLoadAdditionalNamespaces();
            r5._versionAll++;
            r5._versionSansText++;
            return;
        L5:
            r0 = CharUtil.getThreadLocalCharUtil();
            goto L6
        }

        private QName checkName(QName r3, boolean r4) {
            if (this._substituteNamespaces == null) goto L11;
            if (r4 == true) goto L6;
        L7:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this._substituteNamespaces.get(r3.getNamespaceURI()), String.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L10;
            return r3;
        L10:
            return this._locale.makeQName(r5, r3.getLocalPart(), r3.getPrefix());
        L6:
            if (r3.getNamespaceURI().length() > 0) goto L7;
            return r3;
        L11:
            return r3;
        }

        private void comment(Object r3, int r4, int r5) {
            CommentXobj r0 = new CommentXobj(this._locale);
            start(r0);
            text(r3, r4, r5);
            end();
            this._lastXobj = r0;
            this._lastPos = 0;
        }

        private void end() {
            flushText();
            if (this._after == false) goto L5;
            this._frontier = this._frontier._parent;
        L6:
            this._lastXobj = this._frontier;
            this._lastPos = -1;
            return;
        L5:
            this._after = true;
            goto L6
        }

        private void flushText() {
            if (this._stripWhitespace == true) goto L5;
            return;
        L5:
            if (this._after == false) goto L7;
            Xobj r0 = this._frontier;
            r0._srcAfter = this._charUtil.stripRight(r0._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
            Xobj r1 = this._frontier;
            r1._offAfter = this._charUtil._offSrc;
            Xobj r2 = this._frontier;
            r2._cchAfter = this._charUtil._cchSrc;
            return;
        L7:
            Xobj r3 = this._frontier;
            r3._srcValue = this._charUtil.stripRight(r3._srcValue, this._frontier._offValue, this._frontier._cchValue);
            Xobj r4 = this._frontier;
            r4._offValue = this._charUtil._offSrc;
            Xobj r5 = this._frontier;
            r5._cchValue = this._charUtil._cchSrc;
        }

        private Xobj parent() {
            boolean r0 = this._after;
            Xobj r1 = this._frontier;
            if (r0 == true) goto L5;
            return r1;
        L5:
            return r1._parent;
        }

        private void start(Xobj r3) {
            flushText();
            if (this._after == false) goto L5;
            this._frontier = this._frontier._parent;
            this._after = false;
        L5:
            this._frontier.appendXobj(r3);
            this._frontier = r3;
            this._lastXobj = r3;
            this._lastPos = 0;
        }

        private void stripText(Object r2, int r3, int r4) {
            if (this._stripWhitespace == true) goto L5;
        L7:
            text(r2, r3, r4);
            return;
        L5:
            if (this._stripLeft == false) goto L7;
            r2 = this._charUtil.stripLeft(r2, r3, r4);
            this._stripLeft = false;
            r3 = this._charUtil._offSrc;
            r4 = this._charUtil._cchSrc;
            goto L7
        }

        private void text(Object r9, int r10, int r11) {
            if (r11 > 0) goto L4;
            return;
        L4:
            Xobj r0 = this._frontier;
            this._lastXobj = r0;
            int r1 = r0._cchValue + 1;
            this._lastPos = r1;
            if (this._after == false) goto L7;
            this._lastPos = r1 + (this._frontier._cchAfter + 1);
            Xobj r2 = this._frontier;
            r2._srcAfter = this._charUtil.saveChars(r9, r10, r11, r2._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
            Xobj r12 = this._frontier;
            r12._offAfter = this._charUtil._offSrc;
            Xobj r13 = this._frontier;
            r13._cchAfter = this._charUtil._cchSrc;
            return;
        L7:
            Xobj r3 = this._frontier;
            r3._srcValue = this._charUtil.saveChars(r9, r10, r11, r3._srcValue, this._frontier._offValue, this._frontier._cchValue);
            Xobj r14 = this._frontier;
            r14._offValue = this._charUtil._offSrc;
            Xobj r15 = this._frontier;
            r15._cchValue = this._charUtil._cchSrc;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void abort() {
            this._stripLeft = true;
        L4:
            if (parent().isRoot() == true) goto L6;
            end();
            goto L4
        L6:
            finish().release();
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void attr(String r2, String r3, String r4, String r5) {
            attr(this._locale.makeQName(r3, r2, r4), r5);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void attr(QName r5, String r6) {
            if (this._after == false) goto L5;
            Xobj r0 = this._lastXobj._parent;
        L6:
            boolean r1 = isAttrOfTypeId(r5, r0.getQName());
            if (r1 == false) goto L9;
            Xobj r2 = new AttrIdXobj(this._locale, checkName(r5, true));
        L10:
            start(r2);
            text(r6, 0, r6.length());
            end();
            if (r1 == false) goto L15;
            Cur r7 = r2.tempCur();
            r7.toRoot();
            Xobj r3 = r7._xobj;
            r7.release();
            if (ZeusTransformUtils.instanceOf(r3, DocumentXobj.class) == false) goto L15;
            ((DocumentXobj) ZeusTransformUtils.preCheckCast(r3, DocumentXobj.class, "com.obric.memorydata.plugin")).addIdElement(r6, r2._parent.getDom());
        L15:
            this._lastXobj = r2;
            this._lastPos = 0;
            return;
        L9:
            r2 = new AttrXobj(this._locale, checkName(r5, true));
            goto L10
        L5:
            r0 = this._lastXobj;
            goto L6
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmark(XmlCursor.XmlBookmark r3) {
            this._lastXobj.setBookmark(this._lastPos, r3.getKey(), r3);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmarkLastNonAttr(XmlCursor.XmlBookmark r3) {
            if (this._lastPos <= 0) goto L5;
        L8:
            this._lastXobj.setBookmark(this._lastPos, r3.getKey(), r3);
            return;
        L5:
            if (this._lastXobj.isAttr() == false) goto L8;
            this._lastXobj._parent.setBookmark(0, r3.getKey(), r3);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void comment(String r3) {
            if (this._stripComments == true) goto L5;
            comment(r3, 0, r3.length());
        L5:
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void comment(char[] r2, int r3, int r4) {
            if (this._stripComments == true) goto L5;
            comment(this._charUtil.saveChars(r2, r3, r4), this._charUtil._offSrc, this._charUtil._cchSrc);
        L5:
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void endDTD() {
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void endElement() {
            end();
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public Cur finish() {
            flushText();
            if (this._after == false) goto L5;
            this._frontier = this._frontier._parent;
        L5:
            Cur r0 = this._frontier.tempCur();
            if (Locale.toFirstChildElement(r0) == true) goto L8;
            return r0;
        L8:
            boolean r1 = Locale.isFragmentQName(r0.getName());
            if (this._discardDocElem == true) goto L11;
            if (r1 == true) goto L11;
        L46:
            if (this._additionalNamespaces == null) goto L49;
            r0.moveTo(this._frontier);
            Locale.toFirstChildElement(r0);
            Locale.applyNamespaces(r0, this._additionalNamespaces);
        L49:
            if (this._doctypeName != null) goto L51;
        L60:
            r0.moveTo(this._frontier);
            return r0;
        L51:
            if (this._doctypePublicId == null) goto L53;
        L54:
            XmlDocumentProperties r2 = Locale.getDocProps(r0, true);
            r2.setDoctypeName(this._doctypeName);
            String r3 = this._doctypePublicId;
            if (r3 == null) goto L57;
            r2.setDoctypePublicId(r3);
        L57:
            String r4 = this._doctypeSystemId;
            if (r4 == null) goto L60;
            r2.setDoctypeSystemId(r4);
            goto L60
        L53:
            if (this._doctypeSystemId == null) goto L60;
        L11:
            QName r5 = this._replaceDocElem;
            if (r5 == null) goto L15;
            r0.setName(r5);
        L32:
            if (r1 == false) goto L46;
            r0.moveTo(this._frontier);
            if (r0.toFirstAttr() == true) goto L36;
        L44:
            r0.moveTo(this._frontier);
            Xobj r6 = Cur.createDomDocumentRootXobj(this._locale, true);
            this._frontier = r6;
            Cur r7 = r6.tempCur();
            r7.next();
            r0.moveNodeContents(r7, true);
            r0.moveTo(this._frontier);
            r7.release();
        L36:
            if (r0.isXmlns() == false) goto L43;
            if (r0.getXmlnsUri().equals("http://www.openuri.org/fragment") == false) goto L43;
            r0.moveNode(null);
            if (r0.isAttr() == true) goto L36;
        L43:
            if (r0.toNextAttr() == true) goto L36;
        L15:
            if (r0.toParent() == true) goto L15;
            r0.next();
        L19:
            if (r0.isElem() == true) goto L24;
            if (r0.isText() == true) goto L22;
            r0.moveNode(null);
            goto L19
        L22:
            r0.moveChars(null, -1);
            goto L19
        L24:
            r0.skip();
        L26:
            if (r0.isFinish() == true) goto L31;
            if (r0.isText() == true) goto L29;
            r0.moveNode(null);
            goto L26
        L29:
            r0.moveChars(null, -1);
            goto L26
        L31:
            r0.toParent();
            r0.next();
            Cur r8 = r0.tempCur();
            r0.moveNodeContents(r0, true);
            r0.moveToCur(r8);
            r8.release();
            r0.moveNode(null);
            goto L32
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void lineNumber(int r4, int r5, int r6) {
            this._lastXobj.setBookmark(this._lastPos, XmlLineNumber.class, new XmlLineNumber(r4, r5, r6));
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void procInst(String r3, String r4) {
            if (this._stripProcinsts == true) goto L5;
            ProcInstXobj r0 = new ProcInstXobj(this._locale, r3);
            start(r0);
            text(r4, 0, r4.length());
            end();
            this._lastXobj = r0;
            this._lastPos = 0;
        L5:
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void startDTD(String r1, String r2, String r3) {
            this._doctypeName = r1;
            this._doctypePublicId = r2;
            this._doctypeSystemId = r3;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void startElement(QName r3) {
            start(Cur.createElementXobj(this._locale, checkName(r3, false), parent()._name));
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void text(String r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            stripText(r3, 0, r3.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void text(char[] r1, int r2, int r3) {
            stripText(r1, r2, r3);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void xmlns(String r4, String r5) {
            Map<String, String> r0 = this._substituteNamespaces;
            if (r0 == null) goto L7;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L7;
            r5 = r1;
        L7:
            Locale r2 = this._locale;
            AttrXobj r3 = new AttrXobj(r2, r2.createXmlns(r4));
            start(r3);
            text(r5, 0, r5.length());
            end();
            this._lastXobj = r3;
            this._lastPos = 0;
        }
    }

    static final class Locations {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cur[] _curs;
        private int _free;
        private final Locale _locale;
        private int _naked;
        private int[] _next;
        private int[] _nextN;
        private int[] _poses;
        private int[] _prev;
        private int[] _prevN;
        private Xobj[] _xobjs;

        static {
        }

        Locations(Locale r5) {
            this._locale = r5;
            this._xobjs = new Xobj[32];
            this._poses = new int[32];
            this._curs = new Cur[32];
            this._next = new int[32];
            this._prev = new int[32];
            this._nextN = new int[32];
            this._prevN = new int[32];
            int r0 = 31;
        L4:
            if (r0 < 0) goto L6;
            this._poses[r0] = -2;
            this._next[r0] = r0 + 1;
            this._prev[r0] = -1;
            this._nextN[r0] = -1;
            this._prevN[r0] = -1;
            r0 = r0 - 1;
            goto L4
        L6:
            this._next[31] = -1;
            this._free = 0;
            this._naked = -1;
        }

        private static int insert(int r1, int r2, int r3, int[] r4, int[] r5) {
            if (r1 != (-1)) goto L5;
            r5[r3] = r3;
        L12:
            return r3;
        L5:
            if (r2 == (-1)) goto L9;
            r5[r3] = r5[r2];
            r4[r3] = r2;
            r5[r2] = r3;
            if (r1 == r2) goto L12;
            return r1;
        L9:
            r5[r3] = r5[r1];
            r4[r5[r1]] = r3;
            r5[r1] = r3;
            return r1;
        }

        private void makeRoom() {
            Xobj[] r0 = this._xobjs;
            int r1 = r0.length;
            int[] r2 = this._poses;
            Cur[] r3 = this._curs;
            int[] r4 = this._next;
            int[] r5 = this._prev;
            int[] r6 = this._nextN;
            int[] r7 = this._prevN;
            int r8 = r1 * 2;
            Xobj[] r9 = new Xobj[r8];
            this._xobjs = r9;
            this._poses = new int[r8];
            this._curs = new Cur[r8];
            this._next = new int[r8];
            this._prev = new int[r8];
            this._nextN = new int[r8];
            this._prevN = new int[r8];
            System.arraycopy(r0, 0, r9, 0, r1);
            System.arraycopy(r2, 0, this._poses, 0, r1);
            System.arraycopy(r3, 0, this._curs, 0, r1);
            System.arraycopy(r4, 0, this._next, 0, r1);
            System.arraycopy(r5, 0, this._prev, 0, r1);
            System.arraycopy(r6, 0, this._nextN, 0, r1);
            System.arraycopy(r7, 0, this._prevN, 0, r1);
            int r10 = r8 - 1;
            int r11 = r10;
        L4:
            if (r11 < r1) goto L6;
            this._next[r11] = r11 + 1;
            this._prev[r11] = -1;
            this._nextN[r11] = -1;
            this._prevN[r11] = -1;
            this._poses[r11] = -2;
            r11 = r11 - 1;
            goto L4
        L6:
            this._next[r10] = -1;
            this._free = r1;
        }

        private static int remove(int r3, int r4, int[] r5, int[] r6) {
            if (r6[r4] != r4) goto L5;
            r3 = -1;
        L12:
            r6[r4] = -1;
            return r3;
        L5:
            if (r3 != r4) goto L7;
            r3 = r5[r4];
        L9:
            if (r5[r4] != (-1)) goto L11;
            r6[r3] = r6[r4];
            goto L12
        L11:
            r6[r5[r4]] = r6[r4];
            r5[r4] = -1;
            goto L12
        L7:
            r5[r6[r4]] = r5[r4];
            goto L9
        }

        int allocate(Cur r5) {
            if (this._free != (-1)) goto L5;
            makeRoom();
        L5:
            int r0 = this._free;
            int[] r2 = this._next;
            this._free = r2[r0];
            r2[r0] = -1;
            this._xobjs[r0] = r5._xobj;
            this._poses[r0] = r5._pos;
            this._naked = insert(this._naked, -1, r0, this._nextN, this._prevN);
            return r0;
        }

        int insert(int r2, int r3, int r4) {
            return insert(r2, r3, r4, this._next, this._prev);
        }

        boolean isAtEndOf(int r3, Cur r4) {
            Cur[] r0 = this._curs;
            if (r0[r3] != null) goto L12;
            if (r4._xobj == this._xobjs[r3]) goto L7;
        L9:
            return false;
        L7:
            if (r4._pos != (-1)) goto L9;
            return true;
        L12:
            return r4.isAtEndOf(r0[r3]);
        }

        boolean isSamePos(int r3, Cur r4) {
            Cur[] r0 = this._curs;
            if (r0[r3] != null) goto L12;
            if (r4._xobj == this._xobjs[r3]) goto L7;
        L9:
            return false;
        L7:
            if (r4._pos != this._poses[r3]) goto L9;
            return true;
        L12:
            return r4.isSamePos(r0[r3]);
        }

        void moveTo(int r3, Cur r4) {
            Cur[] r0 = this._curs;
            if (r0[r3] != null) goto L5;
            r4.moveTo(this._xobjs[r3], this._poses[r3]);
            return;
        L5:
            r4.moveToCur(r0[r3]);
        }

        int next(int r1) {
            return this._next[r1];
        }

        void notifyChange() {
        L2:
            int r0 = this._naked;
            if (r0 == (-1)) goto L5;
            this._naked = remove(r0, r0, this._nextN, this._prevN);
            this._curs[r0] = this._locale.getCur();
            this._curs[r0].moveTo(this._xobjs[r0], this._poses[r0]);
            this._xobjs[r0] = null;
            this._poses[r0] = -2;
            goto L2
        }

        int prev(int r1) {
            return this._prev[r1];
        }

        int remove(int r4, int r5) {
            Cur[] r0 = this._curs;
            if (r0[r5] == null) goto L5;
            r0[r5].release();
            this._curs[r5] = null;
        L6:
            int r6 = remove(r4, r5, this._next, this._prev);
            this._next[r5] = this._free;
            this._free = r5;
            return r6;
        L5:
            this._xobjs[r5] = null;
            this._poses[r5] = -2;
            this._naked = remove(this._naked, r5, this._nextN, this._prevN);
            goto L6
        }
    }

    static {
    }

    Cur(Locale r2) {
        this._locale = r2;
        this._pos = -2;
        this._tempFrame = -1;
        this._state = 0;
        this._stackTop = -1;
        this._selectionFirst = -1;
        this._selectionN = -1;
        this._selectionLoc = -1;
        this._selectionCount = 0;
    }

    static Xobj createDomDocumentRootXobj(Locale r1) {
        return createDomDocumentRootXobj(r1, false);
    }

    static Xobj createDomDocumentRootXobj(Locale r1, boolean r2) {
        if (r1._saaj != null) goto L7;
        if (r2 == false) goto L6;
        Xobj r3 = new DocumentFragXobj(r1);
    L9:
        if (r1._ownerDoc != null) goto L11;
        r1._ownerDoc = r3.getDom();
    L11:
        return r3;
    L6:
        r3 = new DocumentXobj(r1);
        goto L9
    L7:
        r3 = new SoapPartDocXobj(r1);
        goto L9
    }

    static Xobj createElementXobj(Locale r1, QName r2, QName r3) {
        if (r1._saaj == null) goto L5;
        Class r4 = r1._saaj.identifyElement(r2, r3);
        if (r4 != SOAPElement.class) goto L11;
        return new SoapElementXobj(r1, r2);
    L11:
        if (r4 != SOAPBody.class) goto L15;
        return new SoapBodyXobj(r1, r2);
    L15:
        if (r4 != SOAPBodyElement.class) goto L19;
        return new SoapBodyElementXobj(r1, r2);
    L19:
        if (r4 != SOAPEnvelope.class) goto L23;
        return new SoapEnvelopeXobj(r1, r2);
    L23:
        if (r4 != SOAPHeader.class) goto L27;
        return new SoapHeaderXobj(r1, r2);
    L27:
        if (r4 != SOAPHeaderElement.class) goto L31;
        return new SoapHeaderElementXobj(r1, r2);
    L31:
        if (r4 != SOAPFaultElement.class) goto L35;
        return new SoapFaultElementXobj(r1, r2);
    L35:
        if (r4 != Detail.class) goto L39;
        return new DetailXobj(r1, r2);
    L39:
        if (r4 != DetailEntry.class) goto L43;
        return new DetailEntryXobj(r1, r2);
    L43:
        if (r4 != SOAPFault.class) goto L47;
        return new SoapFaultXobj(r1, r2);
    L47:
        throw new IllegalStateException("Unknown SAAJ element class: " + r4);
    L5:
        return new ElementXobj(r1, r2);
    }

    private void createHelper(Xobj r2) {
        if (isPositioned() == false) goto L5;
        Cur r0 = tempCur(r2, 0);
        r0.moveNode(this);
        r0.release();
    L5:
        moveTo(r2);
    }

    public static void dump(PrintStream r1, Xobj r2, Object r3) {
        if (r3 != null) goto L5;
        r3 = r2;
    L5:
        if (r2._parent == null) goto L7;
        r2 = r2._parent;
        goto L5
    L7:
        dumpXobj(r1, r2, 0, r3);
        r1.println();
    }

    private static void dumpBookmarks(PrintStream r4, Xobj r5, Object r6) {
        Bookmark r7 = r5._bookmarks;
    L3:
        if (r7 == null) goto L12;
        r4.print(" ");
        if (r6 != r7) goto L8;
        r4.print("*:");
    L8:
        if (ZeusTransformUtils.instanceOf(r7._value, XmlLineNumber.class) == false) goto L10;
        XmlLineNumber r0 = (XmlLineNumber) ZeusTransformUtils.preCheckCast(r7._value, XmlLineNumber.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("<line:").append(r0.getLine());
        String r2 = ">[";
    L11:
        r4.print(r1.append(r2).append(r7._pos).append("]").toString());
        r7 = r7._next;
        goto L3
    L10:
        r1 = new StringBuilder();
        r2 = "<mark>[";
        goto L11
    }

    private static void dumpCharNodes(PrintStream r2, CharNode r3, Object r4) {
    L2:
        if (r3 == null) goto L11;
        r2.print(" ");
        if (r3 != r4) goto L6;
        r2.print("*");
    L6:
        StringBuilder r0 = new StringBuilder();
        if (ZeusTransformUtils.instanceOf(r3, TextNode.class) == false) goto L9;
        String r1 = "TEXT";
    L10:
        r2.print(r0.append(r1).append("[").append(r3._cch).append("]").toString());
        r3 = r3._next;
        goto L2
    L9:
        r1 = "CDATA";
        goto L10
    }

    private static void dumpChars(PrintStream r7, Object r8, int r9, int r10) {
        r7.print("\"");
        String r11 = CharUtil.getString(r8, r9, r10);
        int r12 = 0;
    L4:
        if (r12 >= r11.length()) goto L32;
        if (r12 == 36) goto L7;
        int r1 = r11.codePointAt(r12);
        char[] r2 = Character.toChars(r1);
        if (r2.length != 1) goto L28;
        char r3 = r2[0];
        if (r3 < ' ') goto L17;
        if (r3 >= 127) goto L17;
        if (r3 == '\"') goto L17;
        r7.print(r3);
    L31:
        r12 = r12 + Character.charCount(r1);
    L17:
        if (r3 != '\n') goto L20;
        String r4 = "\\n";
    L30:
        r7.print(r4);
        goto L31
    L20:
        if (r3 != '\r') goto L23;
        r4 = "\\r";
        goto L30
    L23:
        if (r3 != '\t') goto L25;
        r4 = "\\t";
        goto L30
    L25:
        if (r3 != '\"') goto L27;
        r4 = "\\\"";
        goto L30
    L27:
        StringBuilder r5 = new StringBuilder().append("<#").append(r3);
    L29:
        r4 = r5.append(">").toString();
        goto L30
    L28:
        r5 = new StringBuilder().append("<#").append(r1);
        goto L29
    L7:
        r7.print("...");
    L32:
        r7.print("\"");
    }

    private static void dumpCur(PrintStream r1, String r2, Cur r3, Object r4) {
        r1.print(" ");
        if (r4 != r3) goto L5;
        r1.print("*:");
    L5:
        StringBuilder r5 = new StringBuilder().append(r2);
        String r6 = r3._id;
        if (r6 != null) goto L8;
        r6 = "<cur>";
    L8:
        r1.print(r5.append(r6).append("[").append(r3._pos).append("]").toString());
    }

    private static void dumpCurs(PrintStream r2, Xobj r3, Object r4) {
        Cur r0 = r3._embedded;
    L3:
        if (r0 == null) goto L5;
        dumpCur(r2, "E:", r0, r4);
        r0 = r0._next;
        goto L3
    L5:
        Cur r1 = r3._locale._registered;
    L6:
        if (r1 == null) goto L11;
        if (r1._xobj != r3) goto L10;
        dumpCur(r2, "R:", r1, r4);
    L10:
        r1 = r1._next;
        goto L6
    }

    private static void dumpXobj(PrintStream r4, Xobj r5, int r6, Object r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5 != r7) goto L7;
        r4.print("* ");
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r6) goto L11;
        r4.print("  ");
        r1 = r1 + 1;
        goto L9
    L11:
        r4.print(kindName(r5.kind()));
        if (r5._name == null) goto L20;
        r4.print(" ");
        if (r5._name.getPrefix().length() <= 0) goto L16;
        r4.print(r5._name.getPrefix() + ParameterizedMessage.ERROR_MSG_SEPARATOR);
    L16:
        r4.print(r5._name.getLocalPart());
        if (r5._name.getNamespaceURI().length() <= 0) goto L20;
        r4.print("@" + r5._name.getNamespaceURI());
    L20:
        if (r5._srcValue == null) goto L22;
    L23:
        r4.print(" Value( ");
        dumpChars(r4, r5._srcValue, r5._offValue, r5._cchValue);
        dumpCharNodes(r4, r5._charNodesValue, r7);
        r4.print(" )");
    L25:
        if (r5._user == null) goto L28;
        r4.print(" (USER)");
    L28:
        if (r5.isVacant() == false) goto L31;
        r4.print(" (VACANT)");
    L31:
        if (r5._srcAfter == null) goto L33;
    L34:
        r4.print(" After( ");
        dumpChars(r4, r5._srcAfter, r5._offAfter, r5._cchAfter);
        dumpCharNodes(r4, r5._charNodesAfter, r7);
        r4.print(" )");
    L35:
        dumpCurs(r4, r5, r7);
        dumpBookmarks(r4, r5, r7);
        String r0 = r5.getClass().getName();
        int r2 = r0.lastIndexOf(46);
        if (r2 <= 0) goto L40;
        r0 = r0.substring(r2 + 1);
        int r3 = r0.lastIndexOf(36);
        if (r3 <= 0) goto L40;
        r0 = r0.substring(r3 + 1);
    L40:
        r4.print(" (");
        r4.print(r0);
        r4.print(")");
        r4.println();
        Xobj r8 = r5._firstChild;
    L41:
        if (r8 == null) goto L43;
        dumpXobj(r4, r8, r6 + 1, r7);
        r8 = r8._nextSibling;
        goto L41
    L43:
        return;
    L33:
        if (r5._charNodesAfter == null) goto L35;
    L22:
        if (r5._charNodesValue == null) goto L25;
    L7:
        r4.print("  ");
        goto L8
    }

    private Xobj getDenormal() {
        return getDenormal(this._xobj, this._pos);
    }

    private Xobj getDenormal(Xobj r1, int r2) {
        Xobj r3 = r1.getDenormal(r2);
        this._posTemp = r1._locale._posTemp;
        return r3;
    }

    private Xobj getNormal(Xobj r1, int r2) {
        Xobj r3 = r1.getNormal(r2);
        this._posTemp = r1._locale._posTemp;
        return r3;
    }

    static boolean kindIsContainer(int r2) {
        if (r2 == 2) goto L8;
        if (r2 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    static boolean kindIsFinish(int r1) {
        if (r1 != (-2)) goto L5;
    L8:
        return true;
    L5:
        if (r1 == (-1)) goto L8;
        return false;
    }

    static String kindName(int r2) {
        if (r2 != 0) goto L4;
        return "TEXT";
    L4:
        if (r2 != 1) goto L6;
        return "ROOT";
    L6:
        if (r2 != 2) goto L8;
        return "ELEM";
    L8:
        if (r2 != 3) goto L10;
        return "ATTR";
    L10:
        if (r2 != 4) goto L12;
        return "COMMENT";
    L12:
        if (r2 != 5) goto L14;
        return "PROCINST";
    L14:
        return "<< Unknown Kind (" + r2 + ") >>";
    }

    static void moveNode(Xobj r5, Cur r6) {
        if (r6 != null) goto L4;
    L14:
        r5._locale.notifyChange();
        r5._locale._versionAll++;
        r5._locale._versionSansText++;
        if (r6 == null) goto L20;
        if (r6._locale == r5._locale) goto L20;
        r6._locale.notifyChange();
        r6._locale._versionAll++;
        r6._locale._versionSansText++;
    L20:
        if (r5.isAttr() == false) goto L26;
        if (r6 != null) goto L23;
        Xobj r0 = null;
    L24:
        r5.invalidateSpecialAttr(r0);
    L32:
        boolean r1 = false;
        if (r5._cchAfter <= 0) goto L35;
        transferChars(r5, r5.posAfter(), r5.getDenormal(0), r5.posTemp(), r5._cchAfter);
    L35:
        r5._locale.embedCurs();
        Xobj r2 = r5;
    L37:
        if (r2 == null) goto L45;
    L39:
        if (r2._embedded == null) goto L41;
        r2._embedded.moveTo(r5.getNormal(r5.posAfter()));
        goto L39
    L41:
        r2.disconnectUser();
        if (r6 == null) goto L44;
        r2._locale = r6._locale;
    L44:
        r2 = r2.walk(r5, true);
        goto L37
    L45:
        r5.removeXobj();
        if (r6 == null) goto L68;
        Xobj r3 = r6._xobj;
        if (r6._pos == 0) goto L50;
        boolean r4 = true;
    L51:
        int r7 = r6.cchRight();
        if (r7 <= 0) goto L57;
        r6.push();
        r6.next();
        r3 = r6._xobj;
        if (r6._pos == 0) goto L56;
        r1 = true;
    L56:
        r6.pop();
        r4 = r1;
    L57:
        if (r4 == false) goto L59;
        r3.appendXobj(r5);
    L60:
        if (r7 <= 0) goto L62;
        transferChars(r6._xobj, r6._pos, r5, r5.posAfter(), r7);
    L62:
        r6.moveTo(r5);
        return;
    L59:
        r3.insertXobj(r5);
        goto L60
    L50:
        r4 = false;
        goto L51
    L68:
        return;
    L23:
        r0 = r6.getParentRaw();
        goto L24
    L26:
        if (r5._parent == null) goto L28;
        r5._parent.invalidateUser();
    L28:
        if (r6 == null) goto L32;
        if (r6.hasParent() == false) goto L32;
        r6.getParent().invalidateUser();
        goto L32
    L4:
        if (r6._pos != (-1)) goto L7;
        r6._xobj.ensureOccupancy();
    L7:
        if (r6._pos != 0) goto L11;
        if (r6._xobj != r5) goto L11;
    L12:
        r6.moveTo(r5);
        return;
    L11:
        if (r6.isJustAfterEnd(r5) == false) goto L14;
        goto L12
    }

    static void moveNodeContents(Xobj r11, Cur r12, boolean r13) {
        boolean r0 = r11.hasAttrs();
        int r2 = 1;
        boolean r3 = true;
        boolean r4 = false;
        if (r11.hasChildren() == true) goto L7;
        if (r13 == false) goto L6;
        if (r0 == true) goto L7;
    L6:
        boolean r1 = true;
    L8:
        Cur r5 = null;
        r5 = null;
        if (r1 == true) goto L11;
        if (r12 == null) goto L42;
        if (r11 != r12._xobj) goto L31;
        if (r12._pos != (-1)) goto L31;
        r12.moveTo(r11);
        if (r13 == false) goto L27;
        if (r0 == false) goto L27;
    L28:
        r12.next(r3);
        return;
    L27:
        r3 = false;
    L31:
        if (r12._locale != r11._locale) goto L38;
        r12.push();
        r12.moveTo(r11);
        if (r13 == false) goto L36;
        if (r0 == false) goto L36;
        boolean r6 = true;
    L37:
        r12.next(r6);
        boolean r7 = r12.isAtLastPush();
        r12.pop();
    L39:
        if (r7 == false) goto L42;
        return;
    L36:
        r6 = false;
        goto L37
    L38:
        r7 = false;
    L42:
        if (r11.hasTextNoEnsureOccupancy() == false) goto L46;
        Cur r8 = r11.tempCur();
        r8.next();
        r8.moveChars(r12, -1);
        r8.release();
        if (r12 == null) goto L46;
        int r9 = r8._cchSrc;
        r12.nextChars(r9);
    L47:
        r11._locale.embedCurs();
        Xobj r10 = r11.walk(r11, true);
        Xobj r14 = r10;
        boolean r15 = false;
    L48:
        if (r10 == null) goto L72;
        if (r10._parent != r11) goto L59;
        if (r10.isAttr() == false) goto L59;
        if (r13 == true) goto L55;
        r14 = r10._nextSibling;
    L71:
        r10 = r10.walk(r11, true);
        r15 = r15;
        goto L48
    L55:
        if (r12 != null) goto L57;
        Xobj r16 = null;
    L58:
        r10.invalidateSpecialAttr(r16);
        goto L59
    L57:
        r16 = r12.getParent();
    L59:
        Cur r17 = r10._embedded;
        if (r17 == null) goto L62;
        r17.moveTo(r11, -1);
        goto L59
    L62:
        r10.disconnectUser();
        if (r12 == null) goto L65;
        r10._locale = r12._locale;
    L65:
        if (r15 == false) goto L67;
    L70:
        r15 = true;
        goto L71
    L67:
        if (r10._bookmarks != null) goto L70;
        r15 = false;
        goto L71
    L72:
        Xobj r18 = r11._lastChild;
        if (r15 == false) goto L77;
        if (r12 != null) goto L77;
        r12 = r11._locale.tempCur();
        r12.createRoot();
        r12.next();
        r5 = r12;
    L77:
        if (r18.isAttr() == true) goto L79;
        r11.invalidateUser();
    L79:
        r11._locale._versionAll++;
        r11._locale._versionSansText++;
        if (r12 == null) goto L83;
        if (r9 != 0) goto L83;
        r12.getParent().invalidateUser();
        r12._locale._versionAll++;
        r12._locale._versionSansText++;
    L83:
        r11.removeXobjs(r14, r18);
        if (r12 == null) goto L119;
        Xobj r19 = r12._xobj;
        if (r12._pos == 0) goto L88;
        boolean r20 = true;
    L89:
        int r21 = r12.cchRight();
        if (r21 <= 0) goto L96;
        r12.push();
        r12.next();
        r19 = r12._xobj;
        if (r12._pos == 0) goto L94;
        r4 = true;
    L94:
        r12.pop();
        r20 = r4;
    L96:
        if (r14.isAttr() == false) goto L113;
        Xobj r22 = r14;
    L99:
        if (r22._nextSibling == null) goto L103;
        if (r22._nextSibling.isAttr() == false) goto L103;
        r22 = r22._nextSibling;
    L103:
        Xobj r23 = r12.getParent();
        if (r21 <= 0) goto L107;
        transferChars(r12._xobj, r12._pos, r22, r22.posMax(), r21);
    L107:
        if (r23.hasTextNoEnsureOccupancy() == true) goto L109;
    L115:
        if (r20 == false) goto L117;
        r19.appendXobjs(r14, r18);
    L118:
        r12.moveTo(r14);
        r12.prevChars(r9);
        goto L119
    L117:
        r19.insertXobjs(r14, r18);
        goto L118
    L109:
        if (r23._cchValue <= 0) goto L111;
        int r24 = r23._cchValue;
    L112:
        transferChars(r23, r2, r22, r22.posAfter(), r24);
        goto L115
    L111:
        r23 = r23.lastAttr();
        r2 = r23.posAfter();
        r24 = r23._cchAfter;
        goto L112
    L113:
        if (r21 <= 0) goto L115;
        transferChars(r12._xobj, r12._pos, r18, r18.posMax(), r21);
        goto L115
    L88:
        r20 = false;
    L119:
        if (r5 == null) goto L132;
        r5.release();
        return;
    L132:
        return;
    L46:
        r9 = 0;
        goto L47
    L11:
        if (r11.isVacant() == false) goto L15;
        if (r12 != null) goto L15;
        r11.clearBit(256);
        r11.invalidateUser();
        r11.invalidateSpecialAttr(null);
        r11._locale._versionAll++;
        return;
    L15:
        if (r11.hasTextEnsureOccupancy() == false) goto L131;
        Cur r110 = r11.tempCur();
        r110.next();
        r110.moveChars(r12, -1);
        r110.release();
        return;
    L131:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private int selectionIndex(int r3) {
        if (this._selectionN != (-1)) goto L6;
        this._selectionN = 0;
        this._selectionLoc = this._selectionFirst;
    L6:
        if (this._selectionN >= r3) goto L9;
        this._selectionLoc = this._locale._locations.next(this._selectionLoc);
        this._selectionN++;
    L9:
        if (this._selectionN <= r3) goto L12;
        this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
        this._selectionN--;
        goto L9
    L12:
        return this._selectionLoc;
    }

    private Cur tempCur(Xobj r2, int r3) {
        Cur r0 = this._locale.tempCur();
        if (r2 == null) goto L5;
        r0.moveTo(getNormal(r2, r3), this._posTemp);
    L5:
        return r0;
    }

    private static void transferChars(Xobj r9, int r10, Xobj r11, int r12, int r13) {
        r11.insertCharsHelper(r12, r9.getCharsHelper(r10, r13), r9._locale._offSrc, r9._locale._cchSrc, false);
        r9.removeCharsHelper(r10, r13, r11, r12, true, false);
    }

    static CharNode updateCharNodes(Locale r4, Xobj r5, CharNode r6, int r7) {
        CharNode r1 = r6;
        int r2 = 0;
    L3:
        if (r1 == null) goto L9;
        if (r7 <= 0) goto L9;
        if (r1._cch <= r7) goto L8;
        r1._cch = r7;
    L8:
        r1._off = r2;
        r2 = r2 + r1._cch;
        r7 = r7 - r1._cch;
        r1 = r1._next;
    L9:
        if (r7 > 0) goto L15;
    L10:
        if (r1 == null) goto L24;
        if (r1._cch == 0) goto L14;
        r1._cch = 0;
    L14:
        r1._off = r2;
        r1 = r1._next;
        goto L10
    L24:
        return r6;
    L15:
        TextNode r8 = r4.createTextNode();
        r8.setDom((DomImpl.Dom) ZeusTransformUtils.preCheckCast(r5, DomImpl.Dom.class, "com.obric.memorydata.plugin"));
        r8._cch = r7;
        r8._off = r2;
        return CharNode.appendNode(r6, r8);
    }

    public void addToSelection() {
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(this));
        this._selectionCount++;
    }

    public void addToSelection(Cur r4) {
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(r4));
        this._selectionCount++;
    }

    public int cchLeft() {
        return this._xobj.cchLeft(this._pos);
    }

    public int cchRight() {
        return this._xobj.cchRight(this._pos);
    }

    public void clearSelection() {
    L3:
        if (this._selectionCount <= 0) goto L5;
        removeFirstSelection();
        goto L3
    }

    boolean contains(Cur r1) {
        return this._xobj.contains(r1);
    }

    void copyNode(Cur r2) {
        Xobj r1 = this._xobj.copyNode(r2._locale);
        if (r2.isPositioned() == false) goto L5;
        moveNode(r1, r2);
        return;
    L5:
        r2.moveTo(r1);
    }

    void createAttr(QName r3) {
        createHelper(new AttrXobj(this._locale, r3));
    }

    void createComment() {
        createHelper(new CommentXobj(this._locale));
    }

    void createDomDocFragRoot() {
        moveTo(new DocumentFragXobj(this._locale));
    }

    void createDomDocumentRoot() {
        moveTo(createDomDocumentRootXobj(this._locale));
    }

    void createElement(QName r2) {
        createElement(r2, null);
    }

    void createElement(QName r2, QName r3) {
        createHelper(createElementXobj(this._locale, r2, r3));
    }

    void createProcinst(String r3) {
        createHelper(new ProcInstXobj(this._locale, r3));
    }

    void createRoot() {
        createDomDocFragRoot();
    }

    void dump() {
        dump(System.out, this._xobj, this);
    }

    int firstBookmarkInCharsLeft(Object r11, int r12) {
        if (cchLeft() <= 0) goto L22;
        Xobj r0 = getDenormal();
        int r10 = this._posTemp - r12;
        int r9 = -1;
        Bookmark r8 = r0._bookmarks;
    L5:
        if (r8 == null) goto L16;
        if (r8._key != r11) goto L14;
        if (r0.inChars(r10, r8._xobj, r8._pos, r12, false) == false) goto L14;
        if (r9 != (-1)) goto L12;
    L13:
        r9 = r8._pos - r10;
        goto L14
    L12:
        if ((r8._pos - r10) < r9) goto L13;
    L14:
        r8 = r8._next;
        goto L5
    L16:
        return r9;
    L22:
        return -1;
    }

    public String getAttrValue(QName r1) {
        push();
        if (toAttr(r1) == false) goto L5;
        String r2 = getValueAsString();
    L6:
        pop();
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    Object getBookmark(Object r4) {
        Bookmark r0 = this._xobj._bookmarks;
    L3:
        if (r0 == null) goto L11;
        if (r0._pos != this._pos) goto L10;
        if (r0._key != r4) goto L10;
        return r0._value;
    L10:
        r0 = r0._next;
        goto L3
    L11:
        return null;
    }

    CharNode getCharNodes() {
        Xobj r0 = getDenormal();
        if (this._posTemp < r0.posAfter()) goto L5;
        CharNode r3 = updateCharNodes(this._locale, r0, r0._charNodesAfter, r0._cchAfter);
        r0._charNodesAfter = r3;
        return r3;
    L5:
        r0.ensureOccupancy();
        CharNode r4 = updateCharNodes(this._locale, r0, r0._charNodesValue, r0._cchValue);
        r0._charNodesValue = r4;
        return r4;
    }

    Object getChars(int r3) {
        return this._xobj.getChars(this._pos, r3, this);
    }

    String getCharsAsString() {
        return getCharsAsString(1);
    }

    String getCharsAsString(int r3) {
        return this._xobj.getCharsAsString(this._pos, -1, r3);
    }

    public DomImpl.Dom getDom() {
        if (isText() == false) goto L10;
        int r0 = cchLeft();
        CharNode r2 = getCharNodes();
    L5:
        r0 = r0 - r2._cch;
        if (r0 < 0) goto L7;
        r2 = r2._next;
        goto L5
    L7:
        return r2;
    L10:
        return this._xobj.getDom();
    }

    Object getFirstChars() {
        Object r0 = this._xobj.getFirstChars();
        this._offSrc = this._locale._offSrc;
        this._cchSrc = this._locale._cchSrc;
        return r0;
    }

    public Locale getLocale() {
        return this._locale;
    }

    public QName getName() {
        return this._xobj._name;
    }

    public XmlObject getObject() {
        if (isUserNode() == true) goto L7;
        return null;
    L7:
        return (XmlObject) ZeusTransformUtils.preCheckCast(getUser(), XmlObject.class, "com.obric.memorydata.plugin");
    }

    public Xobj getParent() {
        return getParent(false);
    }

    public Xobj getParent(boolean r3) {
        int r0 = this._pos;
        if (r0 == (-1)) goto L22;
        if (r0 < 1) goto L10;
        if (r0 < this._xobj.posAfter()) goto L22;
    L10:
        if (this._xobj._parent != null) goto L12;
        if (r3 == false) goto L15;
        return null;
    L15:
        if (this._xobj.isRoot() == true) goto L23;
        Cur r4 = this._locale.tempCur();
        r4.createRoot();
        Xobj r1 = r4._xobj;
        r4.next();
        moveNode(r4);
        r4.release();
        return r1;
    L23:
        return null;
    L12:
        return this._xobj._parent;
    L22:
        return this._xobj;
    }

    public Xobj getParentNoRoot() {
        int r0 = this._pos;
        if (r0 == (-1)) goto L16;
        if (r0 < 1) goto L10;
        if (r0 < this._xobj.posAfter()) goto L16;
    L10:
        if (this._xobj._parent != null) goto L12;
        return null;
    L12:
        return this._xobj._parent;
    L16:
        return this._xobj;
    }

    public Xobj getParentRaw() {
        return getParent(true);
    }

    public String getUri() {
        return getName().getNamespaceURI();
    }

    TypeStoreUser getUser() {
        return this._xobj.getUser();
    }

    String getValueAsString() {
        return this._xobj.getValueAsString();
    }

    String getValueAsString(int r1) {
        return this._xobj.getValueAsString(r1);
    }

    public String getXmlnsPrefix() {
        return this._xobj.getXmlnsPrefix();
    }

    public String getXmlnsUri() {
        return this._xobj.getXmlnsUri();
    }

    final QName getXsiTypeName() {
        return this._xobj.getXsiTypeName();
    }

    public boolean hasAttrs() {
        return this._xobj.hasAttrs();
    }

    public boolean hasChildren() {
        return this._xobj.hasChildren();
    }

    public boolean hasParent() {
        int r0 = this._pos;
        if (r0 == (-1)) goto L13;
        if (r0 < 1) goto L9;
        if (r0 >= this._xobj.posAfter()) goto L9;
        return true;
    L9:
        if (this._xobj._parent != null) goto L15;
        return false;
    L15:
        return true;
    L13:
        return true;
    }

    public boolean hasText() {
        return this._xobj.hasTextEnsureOccupancy();
    }

    boolean inChars(Bookmark r7, int r8, boolean r9) {
        return this._xobj.inChars(this._pos, r7._xobj, r7._pos, r8, r9);
    }

    boolean inChars(Cur r7, int r8, boolean r9) {
        return this._xobj.inChars(this._pos, r7._xobj, r7._pos, r8, r9);
    }

    void insertChars(Object r9, int r10, int r11) {
        if (r11 > 0) goto L4;
        return;
    L4:
        this._locale.notifyChange();
        if (this._pos != (-1)) goto L7;
        this._xobj.ensureOccupancy();
    L7:
        Xobj r0 = getDenormal();
        int r7 = this._posTemp;
        r0.insertCharsHelper(r7, r9, r10, r11, true);
        moveTo(r0, r7);
        this._locale._versionAll++;
    }

    void insertString(String r3) {
        if (r3 == null) goto L5;
        insertChars(r3, 0, r3.length());
        return;
    }

    boolean isAtEndOf(Cur r2) {
        if (this._xobj == r2._xobj) goto L5;
    L7:
        return false;
    L5:
        if (this._pos != (-1)) goto L7;
        return true;
    }

    public boolean isAtEndOfLastPush() {
        return this._locale._locations.isAtEndOf(this._stackTop, this);
    }

    boolean isAtLastPush() {
        return this._locale._locations.isSamePos(this._stackTop, this);
    }

    public boolean isAttr() {
        if (this._pos == 0) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.kind() != 3) goto L7;
        return true;
    }

    public boolean isComment() {
        if (this._pos == 0) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.kind() != 4) goto L7;
        return true;
    }

    public boolean isContainer() {
        if (this._pos == 0) goto L5;
    L7:
        return false;
    L5:
        if (kindIsContainer(this._xobj.kind()) == false) goto L7;
        return true;
    }

    public boolean isContainerOrFinish() {
        int r0 = this._pos;
        if (r0 == 0) goto L6;
        if (r0 == (-1)) goto L6;
        return false;
    L6:
        int r4 = this._xobj.kind();
        if (r4 == 2) goto L13;
        if (r4 == (-2)) goto L13;
        if (r4 == 1) goto L13;
        if (r4 == (-1)) goto L13;
        return false;
    L13:
        return true;
    }

    public boolean isElem() {
        if (this._pos == 0) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.kind() != 2) goto L7;
        return true;
    }

    public boolean isEnd() {
        if (this._pos == (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.kind() != 2) goto L7;
        return true;
    }

    public boolean isFinish() {
        if (this._pos == (-1)) goto L5;
    L7:
        return false;
    L5:
        if (kindIsContainer(this._xobj.kind()) == false) goto L7;
        return true;
    }

    boolean isJustAfterEnd(Xobj r2) {
        return r2.isJustAfterEnd(this._xobj, this._pos);
    }

    public boolean isNode() {
        if (this._pos != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isNormal() {
        int r0 = this._state;
        if (r0 != 0) goto L5;
    L22:
        return false;
    L5:
        if (r0 == 3) goto L22;
        Xobj r1 = this._xobj;
        if (r1 != null) goto L14;
        if (this._pos != (-2)) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (r1.isNormal(this._pos) == true) goto L17;
        return false;
    L17:
        if (this._state != 2) goto L21;
        Cur r2 = this._xobj._embedded;
    L20:
        return isOnList(r2);
    L21:
        r2 = this._locale._registered;
        goto L20
    }

    public boolean isNormalAttr() {
        if (isNode() == true) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.isNormalAttr() == false) goto L7;
        return true;
    }

    boolean isOnList(Cur r1) {
    L2:
        if (r1 == null) goto L7;
        if (r1 == this) goto L4;
        r1 = r1._next;
        goto L2
    L4:
        return true;
    L7:
        return false;
    }

    public boolean isPositioned() {
        if (this._xobj == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isProcinst() {
        if (this._pos == 0) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.kind() != 5) goto L7;
        return true;
    }

    public boolean isRoot() {
        if (this._pos == 0) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.kind() != 1) goto L7;
        return true;
    }

    boolean isSamePos(Cur r3) {
        if (this._xobj == r3._xobj) goto L5;
    L7:
        return false;
    L5:
        if (this._pos != r3._pos) goto L7;
        return true;
    }

    public boolean isText() {
        if (this._pos <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTextCData() {
        return this._xobj.hasBookmark(CDataBookmark.class, this._pos);
    }

    public boolean isUserNode() {
        int r0 = kind();
        if (r0 == 2) goto L12;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 == 3) goto L8;
    L10:
        return false;
    L8:
        if (isXmlns() == true) goto L10;
        return true;
    L12:
        return true;
    }

    public boolean isXmlns() {
        if (isNode() == true) goto L5;
    L7:
        return false;
    L5:
        if (this._xobj.isXmlns() == false) goto L7;
        return true;
    }

    public int kind() {
        int r0 = this._xobj.kind();
        int r2 = this._pos;
        if (r2 != 0) goto L6;
        return r0;
    L6:
        if (r2 == (-1)) goto L10;
        return 0;
    L10:
        return -r0;
    }

    Cur listInsert(Cur r2) {
        if (r2 != null) goto L4;
        this._prev = this;
        return this;
    L4:
        this._prev = r2._prev;
        r2._prev._next = this;
        r2._prev = this;
        return r2;
    }

    Cur listRemove(Cur r4) {
        Cur r0 = this._prev;
        if (r0 != this) goto L5;
        r4 = null;
    L13:
        this._prev = null;
        return r4;
    L5:
        if (r4 != this) goto L7;
        r4 = this._next;
    L8:
        Cur r2 = this._next;
        if (r2 != null) goto L12;
        if (r4 == null) goto L13;
        r4._prev = r0;
        goto L13
    L12:
        r2._prev = r0;
        this._next = null;
        goto L13
    L7:
        r0._next = this._next;
        goto L8
    }

    Object moveChars(Cur r10, int r11) {
        if (r11 >= 0) goto L5;
        r11 = cchRight();
    L5:
        if (r11 != 0) goto L8;
        this._offSrc = 0;
        this._cchSrc = 0;
        return null;
    L8:
        Object r7 = getChars(r11);
        int r8 = this._offSrc;
        if (r10 != null) goto L18;
        Bookmark r1 = this._xobj._bookmarks;
    L11:
        if (r1 == null) goto L23;
        if (inChars(r1, r11, false) == true) goto L14;
        r1 = r1._next;
        goto L11
    L14:
        Cur r12 = this._locale.tempCur();
        r12.createRoot();
        r12.next();
        Object r9 = moveChars(r12, r11);
        r12.release();
        return r9;
    L23:
        this._locale.notifyChange();
        Xobj r0 = this._xobj;
        int r2 = this._pos;
        if (r10 != null) goto L26;
        Xobj r3 = null;
        int r4 = -2;
    L27:
        r0.removeCharsHelper(r2, r11, r3, r4, false, true);
        this._locale._versionAll++;
    L20:
        this._offSrc = r8;
        this._cchSrc = r11;
        return r7;
    L26:
        r3 = r10._xobj;
        r4 = r10._pos;
        goto L27
    L18:
        if (inChars(r10, r11, true) == false) goto L22;
        r10.moveToCur(this);
        nextChars(r11);
        goto L20
    L22:
        r10.insertChars(r7, r8, r11);
        goto L23
    }

    void moveNode(Cur r2) {
        Xobj r0 = this._xobj;
        skip();
        moveNode(r0, r2);
    }

    void moveNodeContents(Cur r1, boolean r2) {
        moveNodeContents(this._xobj, r1, r2);
    }

    void moveTo(Xobj r2) {
        moveTo(r2, 0);
    }

    void moveTo(Xobj r1, int r2) {
        moveToNoCheck(r1, r2);
    }

    public void moveToCharNode(CharNode r5) {
        moveToDom(r5.getDom());
        this._xobj.ensureOccupancy();
        Xobj r0 = this._xobj;
        CharNode r1 = updateCharNodes(this._locale, r0, r0._charNodesValue, this._xobj._cchValue);
        r0._charNodesValue = r1;
    L3:
        if (r1 == null) goto L9;
        if (r5 == r1) goto L5;
        r1 = r1._next;
        goto L3
    L5:
        Xobj r6 = this._xobj;
        int r2 = r1._off + 1;
    L6:
        moveTo(getNormal(r6, r2), this._posTemp);
        return;
    L9:
        Xobj r3 = this._xobj;
        CharNode r4 = updateCharNodes(this._locale, r3, r3._charNodesAfter, this._xobj._cchAfter);
        r3._charNodesAfter = r4;
    L10:
        if (r4 == null) goto L14;
        if (r5 == r4) goto L12;
        r4 = r4._next;
        goto L10
    L12:
        r6 = this._xobj;
        r2 = (r4._off + this._xobj._cchValue) + 2;
        goto L6
    }

    void moveToCur(Cur r2) {
        if (r2 != null) goto L4;
        moveTo(null, -2);
        return;
    L4:
        moveTo(r2._xobj, r2._pos);
    }

    void moveToDom(DomImpl.Dom r3) {
        DomImpl.Dom r4 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r3, DomImpl.Dom.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Xobj.class) == false) goto L5;
        Xobj r5 = (Xobj) ZeusTransformUtils.preCheckCast(r4, Xobj.class, "com.obric.memorydata.plugin");
    L6:
        moveTo(r5);
        return;
    L5:
        r5 = ((SoapPartDom) ZeusTransformUtils.preCheckCast(r4, SoapPartDom.class, "com.obric.memorydata.plugin"))._docXobj;
        goto L6
    }

    void moveToNoCheck(Xobj r3, int r4) {
        if (this._state != 2) goto L7;
        Xobj r0 = this._xobj;
        if (r3 == r0) goto L7;
        r0._embedded = listRemove(r0._embedded);
        Locale r1 = this._locale;
        r1._registered = listInsert(r1._registered);
        this._state = 1;
    L7:
        this._xobj = r3;
        this._pos = r4;
    }

    public void moveToSelection(int r2) {
        this._locale._locations.moveTo(selectionIndex(r2), this);
    }

    final String namespaceForPrefix(String r1, boolean r2) {
        return this._xobj.namespaceForPrefix(r1, r2);
    }

    public boolean next() {
        Xobj r0 = this._xobj;
        int r1 = this._pos;
        int r2 = r0.posAfter();
        if (r1 < r2) goto L5;
        r2 = this._xobj.posMax();
    L40:
        moveTo(getNormal(r0, r2), this._posTemp);
        return true;
    L5:
        if (r1 == (-1)) goto L7;
        if (r1 > 0) goto L17;
        r0.ensureOccupancy();
        if (r0._cchValue == 0) goto L24;
    L39:
        r2 = 1;
        goto L40
    L24:
        if (r0._firstChild == null) goto L39;
        if (r0._firstChild.isAttr() == true) goto L27;
    L18:
        r0 = r0._firstChild;
    L19:
        r2 = 0;
        goto L40
    L27:
        Xobj r3 = r0._firstChild;
    L29:
        if (r3._nextSibling == null) goto L34;
        if (r3._nextSibling.isAttr() == false) goto L34;
        r3 = r3._nextSibling;
    L34:
        if (r3._cchAfter <= 0) goto L37;
        r2 = r3.posAfter();
        r0 = r3;
        goto L40
    L37:
        if (r3._nextSibling == null) goto L39;
        r0 = r3._nextSibling;
        goto L19
    L17:
        if (r0._firstChild != null) goto L18;
        r2 = -1;
        goto L40
    L7:
        if (r0.isRoot() == false) goto L9;
    L14:
        return false;
    L9:
        if (r0.isAttr() == false) goto L40;
        if (r0._nextSibling == null) goto L14;
        if (r0._nextSibling.isAttr() == true) goto L40;
        goto L14
    }

    public boolean next(boolean r1) {
        if (r1 == false) goto L5;
        return nextWithAttrs();
    L5:
        return next();
    }

    int nextChars(int r3) {
        int r0 = cchRight();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (r3 < 0) goto L11;
        if (r3 >= r0) goto L11;
        moveTo(getNormal(this._xobj, this._pos + r3), this._posTemp);
        return r3;
    L11:
        next();
        return r0;
    }

    public boolean nextWithAttrs() {
        int r0 = kind();
        if (kindIsContainer(r0) == false) goto L8;
        if (toFirstAttr() == false) goto L17;
        return true;
    L17:
        return next();
    L8:
        if (r0 != (-3)) goto L17;
        if (next() == false) goto L12;
        return true;
    L12:
        toParent();
        if (toParentRaw() == true) goto L17;
        return false;
    }

    TypeStoreUser peekUser() {
        return this._xobj._user;
    }

    boolean pop() {
        if (this._stackTop != (-1)) goto L6;
        return false;
    L6:
        this._locale._locations.moveTo(this._stackTop, this);
        Locations r0 = this._locale._locations;
        int r1 = this._stackTop;
        this._stackTop = r0.remove(r1, r1);
        return true;
    }

    void popButStay() {
        if (this._stackTop == (-1)) goto L6;
        Locations r0 = this._locale._locations;
        int r1 = this._stackTop;
        this._stackTop = r0.remove(r1, r1);
        return;
    }

    final String prefixForNamespace(String r2, String r3, boolean r4) {
        if (isContainer() == false) goto L5;
        Xobj r1 = this._xobj;
    L7:
        return r1.prefixForNamespace(r2, r3, r4);
    L5:
        r1 = getParent();
        goto L7
    }

    public boolean prev() {
        int r1 = 0;
        if (this._xobj.isRoot() == false) goto L8;
        if (this._pos != 0) goto L8;
        return false;
    L8:
        if (this._xobj.isAttr() == true) goto L10;
    L14:
        Xobj r0 = getDenormal();
        int r2 = this._posTemp;
        int r3 = r0.posAfter();
        if (r2 <= r3) goto L17;
        r1 = r3;
    L35:
        moveTo(getNormal(r0, r1), this._posTemp);
        return true;
    L17:
        if (r2 != r3) goto L29;
        if (r0.isAttr() == true) goto L21;
    L27:
        r1 = -1;
        goto L35
    L21:
        if (r0._cchAfter <= 0) goto L23;
    L26:
        r0 = r0.ensureParent();
        goto L35
    L23:
        if (r0._nextSibling == null) goto L26;
        if (r0._nextSibling.isAttr() == true) goto L27;
    L29:
        if (r2 != (r3 - 1)) goto L33;
        r0.ensureOccupancy();
        if (r0._cchValue <= 0) goto L35;
    L34:
        r1 = 1;
        goto L35
    L33:
        if (r2 <= 1) goto L35;
    L10:
        if (this._pos != 0) goto L14;
        if (this._xobj._prevSibling != null) goto L14;
        return false;
    }

    int prevChars(int r3) {
        int r0 = cchLeft();
        if (r3 < 0) goto L5;
        if (r3 > r0) goto L5;
    L6:
        if (r3 == 0) goto L8;
        moveTo(getNormal(getDenormal(), this._posTemp - r3), this._posTemp);
    L8:
        return r3;
    L5:
        r3 = r0;
        goto L6
    }

    public boolean prevWithAttrs() {
        if (prev() == false) goto L6;
        return true;
    L6:
        if (isAttr() == true) goto L9;
        return false;
    L9:
        toParent();
        return true;
    }

    public void push() {
        int r0 = this._locale._locations.allocate(this);
        Locations r1 = this._locale._locations;
        int r2 = this._stackTop;
        this._stackTop = r1.insert(r2, r2, r0);
    }

    public void release() {
        if (this._tempFrame < 0) goto L12;
        Cur r0 = this._nextTemp;
        if (r0 == null) goto L7;
        r0._prevTemp = this._prevTemp;
    L7:
        Cur r3 = this._prevTemp;
        if (r3 != null) goto L10;
        this._locale._tempFrames[this._tempFrame] = this._nextTemp;
    L11:
        this._nextTemp = null;
        this._prevTemp = null;
        this._tempFrame = -1;
        goto L12
    L10:
        r3._nextTemp = r0;
    L12:
        int r1 = this._state;
        if (r1 != 0) goto L15;
        return;
    L15:
        if (r1 != 3) goto L17;
        return;
    L17:
        if (this._stackTop == (-1)) goto L19;
        popButStay();
        goto L17
    L19:
        clearSelection();
        this._id = null;
        moveToCur(null);
        Locale.Ref r2 = this._ref;
        if (r2 == null) goto L22;
        r2.clear();
        this._ref._cur = null;
    L22:
        this._ref = null;
        Locale r4 = this._locale;
        r4._registered = listRemove(r4._registered);
        if (this._locale._curPoolCount >= 16) goto L25;
        Locale r5 = this._locale;
        r5._curPool = listInsert(r5._curPool);
        this._state = 0;
        this._locale._curPoolCount++;
        return;
    L25:
        this._locale = null;
        this._state = 3;
    }

    public boolean removeAttr(QName r1) {
        return this._xobj.removeAttr(r1);
    }

    void removeFirstSelection() {
        int r0 = selectionIndex(0);
        int r1 = this._selectionN;
        if (r1 <= 0) goto L5;
        this._selectionN = r1 - 1;
    L7:
        this._selectionFirst = this._locale._locations.remove(this._selectionFirst, r0);
        this._selectionCount--;
        return;
    L5:
        if (r1 != 0) goto L7;
        this._selectionN = r1 - 1;
        this._selectionLoc = -1;
        goto L7
    }

    public void removeFollowingAttrs() {
        QName r0 = getName();
        push();
        if (toNextAttr() == true) goto L5;
    L11:
        pop();
        return;
    L5:
        if (isAttr() == false) goto L11;
        if (getName().equals(r0) == true) goto L8;
        if (toNextAttr() == true) goto L5;
    L8:
        moveNode(null);
        goto L5
    }

    public int selectionCount() {
        return this._selectionCount;
    }

    public void setAttrValueAsQName(QName r3) {
        QName r0 = Locale._xsiType;
        if (r3 != null) goto L7;
        this._xobj.removeAttr(r0);
        return;
    L7:
        if (toAttr(r0) == false) goto L9;
        removeFollowingAttrs();
    L10:
        setValueAsQName(r3);
        toParent();
        return;
    L9:
        next();
        createAttr(r0);
        goto L10
    }

    public final Bookmark setBookmark(Object r2, Object r3) {
        return this._xobj.setBookmark(this._pos, r2, r3);
    }

    void setCharNodes(CharNode r3) {
        Xobj r0 = getDenormal();
        if (this._posTemp < r0.posAfter()) goto L5;
        r0._charNodesAfter = r3;
    L6:
        if (r3 == null) goto L8;
        r3.setDom((DomImpl.Dom) ZeusTransformUtils.preCheckCast(r0, DomImpl.Dom.class, "com.obric.memorydata.plugin"));
        r3 = r3._next;
        goto L6
    L8:
        return;
    L5:
        r0._charNodesValue = r3;
        goto L6
    }

    void setName(QName r1) {
        this._xobj.setName(r1);
    }

    void setSubstitution(QName r3, SchemaType r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        TypeStoreUser r0 = peekUser();
        if (r0 == null) goto L10;
        if (r0.get_schema_type() != r5) goto L10;
        if (r3.equals(getName()) == false) goto L10;
        return;
    L10:
        if (isRoot() == false) goto L12;
        return;
    L12:
        TypeStoreUser r1 = this._xobj.ensureParent().getUser();
        if (isAttr() == false) goto L16;
        return;
    L16:
        if (r1.get_element_type(r3, null) != r5) goto L19;
        setName(r3);
        removeAttr(Locale._xsiType);
        return;
    L19:
        QName r2 = r5.getName();
        if (r2 != null) goto L23;
        return;
    L23:
        if (r1.get_element_type(r3, r2) == r5) goto L25;
        return;
    L25:
        setName(r3);
        setAttrValueAsQName(r2);
    }

    void setType(SchemaType r3) {
        setType((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), true);
    }

    void setType(SchemaType r4, boolean r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        TypeStoreUser r0 = peekUser();
        if (r0 == null) goto L8;
        if (r0.get_schema_type() != r6) goto L8;
        return;
    L8:
        if (isRoot() == false) goto L11;
        this._xobj.setStableType(r6);
        return;
    L11:
        TypeStoreUser r1 = this._xobj.ensureParent().getUser();
        if (isAttr() == false) goto L21;
        if (r5 == true) goto L15;
        return;
    L15:
        if (r1.get_attribute_type(getName()) != r6) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("Can't set type of attribute to " + r6.toString());
    L21:
        if (r1.get_element_type(getName(), null) != r6) goto L24;
        removeAttr(Locale._xsiType);
        return;
    L24:
        QName r2 = r6.getName();
        if (r2 != null) goto L31;
        if (r5 == true) goto L29;
        return;
    L29:
        throw new IllegalArgumentException("Can't set type of element, type is un-named");
    L31:
        if (r1.get_element_type(getName(), r2) == r6) goto L36;
        if (r5 == true) goto L35;
        return;
    L35:
        throw new IllegalArgumentException("Can't set type of element, invalid type");
    L36:
        setAttrValueAsQName(r2);
    }

    public void setValue(String r3) {
        moveNodeContents(null, false);
        next();
        insertString(r3);
        toParent();
    }

    public void setValueAsQName(QName r4) {
        String r0 = r4.getLocalPart();
        String r1 = r4.getNamespaceURI();
        if (r4.getPrefix().length() <= 0) goto L5;
        String r5 = r4.getPrefix();
    L6:
        String r6 = prefixForNamespace(r1, r5, true);
        if (r6.length() <= 0) goto L9;
        r0 = r6 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0;
    L9:
        setValue(r0);
        return;
    L5:
        r5 = null;
        goto L6
    }

    final void setXsiType(QName r1) {
        setAttrValueAsQName(r1);
    }

    public boolean skip() {
        int r1 = 0;
        if (this._xobj.isRoot() == false) goto L6;
        return false;
    L6:
        if (this._xobj.isAttr() == true) goto L8;
        Xobj r0 = this._xobj;
        Xobj r2 = getNormal(r0, r0.posAfter());
        r1 = this._posTemp;
    L15:
        moveTo(r2, r1);
        return true;
    L8:
        if (this._xobj._nextSibling != null) goto L10;
    L13:
        return false;
    L10:
        if (this._xobj._nextSibling.isAttr() == false) goto L13;
        r2 = this._xobj._nextSibling;
        goto L15
    }

    public boolean skipWithAttrs() {
        if (skip() == false) goto L6;
        return true;
    L6:
        if (this._xobj.isRoot() == false) goto L9;
        return false;
    L9:
        toParent();
        next();
        return true;
    }

    Cur tempCur() {
        Cur r0 = this._locale.tempCur(null);
        r0.moveToCur(this);
        return r0;
    }

    public boolean toAttr(QName r2) {
        Xobj r3 = this._xobj.getAttr(r2);
        if (r3 != null) goto L6;
        return false;
    L6:
        moveTo(r3);
        return true;
    }

    public void toEnd() {
        moveTo(this._xobj, -1);
    }

    public boolean toFirstAttr() {
        Xobj r0 = this._xobj.firstAttr();
        if (r0 != null) goto L6;
        return false;
    L6:
        moveTo(r0);
        return true;
    }

    public boolean toFirstChild() {
        if (this._xobj.hasChildren() == true) goto L6;
        return false;
    L6:
        Xobj r0 = this._xobj._firstChild;
    L8:
        if (r0.isAttr() == false) goto L9;
        r0 = r0._nextSibling;
        goto L8
    L9:
        moveTo(r0);
        return true;
    }

    public boolean toLastAttr() {
        if (toFirstAttr() == true) goto L7;
        return false;
    L7:
        if (toNextAttr() == true) goto L7;
        return true;
    }

    public boolean toLastChild() {
        if (this._xobj.hasChildren() == true) goto L6;
        return false;
    L6:
        moveTo(this._xobj._lastChild);
        return true;
    }

    public boolean toNextAttr() {
        Xobj r0 = this._xobj.nextAttr();
        if (r0 != null) goto L6;
        return false;
    L6:
        moveTo(r0);
        return true;
    }

    public boolean toNextSibling() {
        if (this._xobj.isAttr() == false) goto L11;
        if (this._xobj._nextSibling != null) goto L7;
        return false;
    L7:
        if (this._xobj._nextSibling.isAttr() == false) goto L15;
    L8:
        moveTo(this._xobj._nextSibling);
        return true;
    L15:
        return false;
    L11:
        if (this._xobj._nextSibling != null) goto L8;
        return false;
    }

    public boolean toParent() {
        return toParent(false);
    }

    public boolean toParent(boolean r1) {
        Xobj r2 = getParent(r1);
        if (r2 != null) goto L6;
        return false;
    L6:
        moveTo(r2);
        return true;
    }

    public boolean toParentRaw() {
        return toParent(true);
    }

    public boolean toPrevAttr() {
        if (isAttr() == true) goto L5;
        prev();
        if (isContainer() == true) goto L15;
        next();
        return false;
    L15:
        return toLastAttr();
    L5:
        if (this._xobj._prevSibling != null) goto L7;
        Xobj r0 = this._xobj.ensureParent();
    L8:
        moveTo(r0);
        return true;
    L7:
        r0 = this._xobj._prevSibling;
        goto L8
    }

    public void toRoot() {
        Xobj r0 = this._xobj;
    L4:
        if (r0.isRoot() == true) goto L9;
        if (r0._parent == null) goto L7;
        r0 = r0._parent;
        goto L4
    L7:
        Cur r1 = this._locale.tempCur();
        r1.createRoot();
        Xobj r2 = r1._xobj;
        r1.next();
        moveNode(r1);
        r1.release();
        r0 = r2;
    L9:
        moveTo(r0);
    }

    public Cur weakCur(Object r2) {
        Cur r3 = this._locale.weakCur(r2);
        r3.moveToCur(this);
        return r3;
    }
}
