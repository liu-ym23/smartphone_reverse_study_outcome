package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.function.Supplier;
import javax.xml.namespace.QName;
import javax.xml.stream.e;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: classes7.dex */
public final class Cursor implements XmlCursor, Locale.ChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Cur _cur;
    private int _currentSelection;
    private Locale.ChangeListener _nextChangeListener;
    private XPathEngine _pathEngine;

    private interface WrapIOEx {
        void run();
    }

    private interface WrapSAXEx {
        void run();
    }

    static {
    }

    public Cursor(Cur r2) {
        this(r2._xobj, r2._pos);
    }

    Cursor(Xobj r2, int r3) {
        Cur r0 = r2._locale.weakCur(this);
        this._cur = r0;
        r0.moveTo(r2, r3);
        this._currentSelection = -1;
    }

    private boolean checkContentInsertionValidity(Cursor r2) {
        this._cur.push();
        this._cur.next();
        if (this._cur.isFinish() == false) goto L12;
        this._cur.pop();
        return false;
    L12:
        r2.checkInsertionValidity(this._cur);     // Catch: IllegalArgumentException -> L9
        this._cur.pop();
        return true;
    L9:
        e = move-exception;
        this._cur.pop();
        throw e;
    }

    private Cursor checkCursors(XmlCursor r4) {
        XmlCursor r5 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r4, XmlCursor.class, "com.obric.memorydata.plugin");
        checkThisCursor();
        if (r5 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r5, Cursor.class) == false) goto L12;
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r5, Cursor.class, "com.obric.memorydata.plugin");
        if (r3._cur == null) goto L10;
        return r3;
    L10:
        throw new IllegalStateException("Other cursor has been disposed");
    L12:
        throw new IllegalArgumentException("Incompatible cursors: " + r5);
    L14:
        throw new IllegalArgumentException("Other cursor is <null>");
    }

    private void checkInsertionValidity(Cur r6) {
        int r7 = r6.kind();
        if (r7 >= 0) goto L6;
        complain("Can't move/copy/insert an end token.");
    L6:
        if (r7 != 1) goto L8;
        complain("Can't move/copy/insert a whole document.");
    L8:
        int r1 = this._cur.kind();
        if (r1 != 1) goto L12;
        complain("Can't insert before the start of the document.");
    L12:
        if (r7 != 3) goto L19;
        this._cur.push();
        this._cur.prevWithAttrs();
        int r4 = this._cur.kind();
        this._cur.pop();
        if (r4 == 2) goto L19;
        if (r4 == 1) goto L19;
        if (r4 == (-3)) goto L19;
        complain("Can only insert attributes before other attributes or after containers.");
    L19:
        if (r1 != 3) goto L23;
        if (r7 == 3) goto L24;
        complain("Can only insert attributes before other attributes or after containers.");
        return;
    L24:
        return;
    }

    private void checkThisCursor() {
        if (this._cur == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("This cursor has been disposed");
    }

    private static void complain(String r1) {
        throw new IllegalArgumentException(r1);
    }

    static XmlCursor.XmlBookmark getBookmark(Object r1, Cur r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        Object r3 = r2.getBookmark(r1);
        if (ZeusTransformUtils.instanceOf(r3, XmlCursor.XmlBookmark.class) == true) goto L8;
        return null;
    L8:
        return (XmlCursor.XmlBookmark) ZeusTransformUtils.preCheckCast(r3, XmlCursor.XmlBookmark.class, "com.obric.memorydata.plugin");
    }

    private void insertNode(Cur r2, String r3) {
        if (r3 != null) goto L4;
    L6:
        checkInsertionValidity(r2);
        r2.moveNode(this._cur);
        this._cur.toEnd();
        this._cur.nextWithAttrs();
        return;
    L4:
        if (r3.length() <= 0) goto L6;
        r2.next();
        r2.insertString(r3);
        r2.toParent();
        goto L6
    }

    private boolean isDomFragment() {
        if (isStartdoc() == true) goto L5;
        return true;
    L5:
        boolean r0 = false;
        XmlCursor r3 = newCursor();
        XmlCursor.TokenType r2 = r3.toNextToken();     // Catch: Throwable -> L32
    L20:
        int r4 = r2.intValue();     // Catch: Throwable -> L32
    L8:
        switch(r4) {
            case 0: goto L28;
            case 1: goto L28;
            case 2: goto L28;
            case 3: goto L22;
            case 4: goto L19;
            case 5: goto L14;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L8;
        };
    L10:
        if (r3 == null) goto L12;
        r3.close();
    L12:
        return true;
    L19:
        r2 = r3.toNextToken();     // Catch: Throwable -> L32
        goto L20
    L28:
        if (r3 == null) goto L31;
        r3.close();
    L31:
        return !r0;
    L14:
        if (Locale.isWhiteSpace(r3.getChars()) == false) goto L15;
        r2 = r3.toNextToken();     // Catch: Throwable -> L32
        goto L20
    L15:
        if (r3 == null) goto L17;
        r3.close();
    L17:
        return true;
    L22:
        if (r0 == true) goto L23;
        r4 = r3.toEndToken().intValue();     // Catch: Throwable -> L32
        r0 = true;
        goto L8
    L23:
        if (r3 == null) goto L25;
        r3.close();
    L25:
        return true;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (r3 != null) goto L45;
    L40:
        throw th;
    L45:
        r3.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.addSuppressed(th);
        goto L40
    }

    private boolean isValid() {
        return isValid(this._cur);
    }

    private static boolean isValid(Cur r2) {
        if (r2.kind() > 0) goto L19;
        r2.push();
        if (r2.toParentRaw() == false) goto L14;
        int r0 = r2.kind();
        if (r0 != 4) goto L9;
        return false;
    L9:
        if (r0 != 5) goto L11;
        return false;
    L11:
        if (r0 != 3) goto L14;
        return false;
    L14:
        r2.pop();
        return true;
    L19:
        return true;
    }

    private boolean preCheck() {
        checkThisCursor();
        return this._cur._locale.noSync();
    }

    private <T> T syncWrap(Supplier<T> r3) {
        Supplier<T> r4 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin");
        if (preCheck() == true) goto L5;
        Locale r0 = this._cur._locale;
        monitor-enter(r0);
        T r2 = (T) syncWrapHelper(r4, true);
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    L5:
        return (T) syncWrapHelper(r4, true);
    }

    private void syncWrap(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (preCheck() == false) goto L5;
        syncWrapHelper(r4, true);
        return;
    L5:
        Locale r0 = this._cur._locale;
        monitor-enter(r0);
        syncWrapHelper(r4, true);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private <T> T syncWrapHelper(Supplier<T> r3, boolean r4) {
        Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin");
        Locale r2 = this._cur._locale;
        if (r4 == false) goto L13;
        r2.enter();
    L13:
        T r6 = (T) r5.get();
        if (r4 == false) goto L8;
        r2.exit();
    L8:
        return r6;
    L9:
        th = move-exception;
        if (r4 == false) goto L12;
        r2.exit();
    L12:
        throw th;
    }

    private void syncWrapHelper(Runnable r3, boolean r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Locale r2 = this._cur._locale;
        if (r4 == false) goto L13;
        r2.enter();
    L13:
        r5.run();     // Catch: Throwable -> L9
        if (r4 == false) goto L15;
        r2.exit();
        return;
    L15:
        return;
    L9:
        th = move-exception;
        if (r4 == false) goto L12;
        r2.exit();
    L12:
        throw th;
    }

    private void syncWrapHelper(WrapIOEx r3) {
        WrapIOEx r4 = (WrapIOEx) ZeusTransformUtils.wrapperContextForParams(r3, WrapIOEx.class, "com.obric.memorydata.plugin");
        Locale r2 = this._cur._locale;
        r2.enter();
        r4.run();     // Catch: Throwable -> L6
        r2.exit();
        return;
    L6:
        th = move-exception;
        r2.exit();
        throw th;
    }

    private void syncWrapHelper(WrapSAXEx r3) {
        WrapSAXEx r4 = (WrapSAXEx) ZeusTransformUtils.wrapperContextForParams(r3, WrapSAXEx.class, "com.obric.memorydata.plugin");
        Locale r2 = this._cur._locale;
        r2.enter();
        r4.run();     // Catch: Throwable -> L6
        r2.exit();
        return;
    L6:
        th = move-exception;
        r2.exit();
        throw th;
    }

    private void syncWrapIOEx(WrapIOEx r3) {
        WrapIOEx r4 = (WrapIOEx) ZeusTransformUtils.wrapperContextForParams(r3, WrapIOEx.class, "com.obric.memorydata.plugin");
        if (preCheck() == false) goto L5;
        syncWrapHelper(r4);
        return;
    L5:
        Locale r0 = this._cur._locale;
        monitor-enter(r0);
        syncWrapHelper(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private <T> T syncWrapNoEnter(Supplier<T> r3) {
        Supplier<T> r4 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin");
        if (preCheck() == true) goto L5;
        Locale r0 = this._cur._locale;
        monitor-enter(r0);
        T r2 = (T) syncWrapHelper(r4, false);
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    L5:
        return (T) syncWrapHelper(r4, false);
    }

    private void syncWrapNoEnter(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (preCheck() == false) goto L5;
        syncWrapHelper(r4, false);
        return;
    L5:
        Locale r0 = this._cur._locale;
        monitor-enter(r0);
        syncWrapHelper(r4, false);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void syncWrapSAXEx(WrapSAXEx r3) {
        WrapSAXEx r4 = (WrapSAXEx) ZeusTransformUtils.wrapperContextForParams(r3, WrapSAXEx.class, "com.obric.memorydata.plugin");
        if (preCheck() == false) goto L5;
        syncWrapHelper(r4);
        return;
    L5:
        Locale r0 = this._cur._locale;
        monitor-enter(r0);
        syncWrapHelper(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private int twoLocaleOp(XmlCursor r5, final int r6, final int r7) {
        final Cursor r8 = checkCursors((XmlCursor) ZeusTransformUtils.wrapperContextForParams(r5, XmlCursor.class, "com.obric.memorydata.plugin"));
        Locale r0 = this._cur._locale;
        Locale r1 = r8._cur._locale;
        if (r0 != r1) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$Cursor$6JqOe5Cl50QDZEFlIkMBQ4HD9k(this, r8, r6, r7)), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        if (r0.noSync() == false) goto L20;
        if (r1.noSync() == true) goto L11;
        monitor-enter(r1);
        int r4 = twoLocaleOp(r8, r6, r7);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r4;
    L16:
        th = move-exception;
        throw th;
    L11:
        return twoLocaleOp(r8, r6, r7);
    L20:
        if (r1.noSync() == false) goto L28;
        monitor-enter(r0);
        int r9 = twoLocaleOp(r8, r6, r7);     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        return r9;
    L25:
        th = move-exception;
        throw th;
    L28:
        boolean r2 = false;
        GlobalLock.acquire();     // Catch: Throwable -> L54 InterruptedException -> L56
        monitor-enter(r0);     // Catch: Throwable -> L50 InterruptedException -> L52
        monitor-enter(r1);     // Catch: Throwable -> L44
        GlobalLock.release();     // Catch: Throwable -> L40
        int r10 = twoLocaleOp(r8, r6, r7);     // Catch: Throwable -> L38
        monitor-exit(r1);     // Catch: Throwable -> L38
        monitor-exit(r0);     // Catch: Throwable -> L48
        return r10;
    L40:
        th = th;
    L42:
        monitor-exit(r1);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L48
    L44:
        th = th;
        r2 = true;
    L46:
        monitor-exit(r0);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L54 InterruptedException -> L56
    L38:
        th = th;
        goto L42
    L48:
        th = th;
    L52:
        e = e;
        r2 = true;
    L58:
        throw new RuntimeException(e.getMessage(), e);     // Catch: Throwable -> L54
    L50:
        th = th;
        r2 = true;
    L59:
        if (r2 == false) goto L61;
        GlobalLock.release();
    L61:
        throw th;
    L56:
        e = e;
    L54:
        th = th;
        goto L59
    }

    private int twoLocaleOp(Cursor r4, int r5, int r6) {
        Locale r0 = this._cur._locale;
        Locale r1 = r4._cur._locale;
        r0.enter(r1);
        if (r5 != 0) goto L5;
        boolean r3 = _moveXml(r4);     // Catch: Throwable -> L34
        r0.exit(r1);
        return r3 ? 1 : 0;
    L5:
        if (r5 != 1) goto L7;
        boolean r7 = _copyXml(r4);     // Catch: Throwable -> L34
        r0.exit(r1);
        return r7 ? 1 : 0;
    L7:
        if (r5 != 2) goto L9;
        boolean r8 = _moveXmlContents(r4);     // Catch: Throwable -> L34
        r0.exit(r1);
        return r8 ? 1 : 0;
    L9:
        if (r5 != 3) goto L11;
        boolean r9 = _copyXmlContents(r4);     // Catch: Throwable -> L34
        r0.exit(r1);
        return r9 ? 1 : 0;
    L11:
        if (r5 != 4) goto L13;
        int r10 = _moveChars(r6, r4);     // Catch: Throwable -> L34
        r0.exit(r1);
        return r10;
    L13:
        if (r5 != 5) goto L18;
        int r11 = _copyChars(r6, r4);     // Catch: Throwable -> L34
        r0.exit(r1);
        return r11;
    L18:
        throw new RuntimeException("Unknown operation: " + r5);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r0.exit(r1);
        throw th;
    }

    static void validateLocalName(String r1) {
        if (r1 == null) goto L13;
        if (r1.length() == 0) goto L11;
        if (XMLChar.isValidNCName(r1) == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Name is not valid");
    L11:
        throw new IllegalArgumentException("Name is empty");
    L13:
        throw new IllegalArgumentException("Name is null");
    }

    public boolean ___toNextSibling() {
        if (this._cur.hasParent() == true) goto L6;
        return false;
    L6:
        Xobj r0 = this._cur.getParentNoRoot();
        if (r0 != null) goto L15;
        this._cur._locale.enter();
        r0 = this._cur.getParent();     // Catch: Throwable -> L11
        this._cur._locale.exit();
    L11:
        th = move-exception;
        this._cur._locale.exit();
        throw th;
    L15:
        return Locale.toNextSiblingElement(this._cur, r0);
    }

    public void _clearSelections() {
        XPathEngine r0 = this._pathEngine;
        if (r0 == null) goto L5;
        r0.release();
        this._pathEngine = null;
    L5:
        this._cur.clearSelection();
        this._currentSelection = -1;
    }

    public int _copyChars(int r4, Cursor r5) {
        int r0 = this._cur.cchRight();
        if (r0 <= 0) goto L11;
        if (r4 == 0) goto L13;
        if (r4 < 0) goto L8;
        if (r4 > r0) goto L8;
    L9:
        r5.checkInsertionValidity(this._cur);
        r5._cur.insertChars(this._cur.getChars(r4), this._cur._offSrc, this._cur._cchSrc);
        r5._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    L8:
        r4 = r0;
        goto L9
    L13:
        return 0;
    L11:
        return 0;
    }

    public boolean _copyXml(Cursor r5) {
        r5.checkInsertionValidity(this._cur);
        Cur r0 = r5.tempCur();
        if (this._cur.isText() == false) goto L5;
        r5._cur.insertChars(this._cur.getChars(-1), this._cur._offSrc, this._cur._cchSrc);
    L6:
        r5._cur.moveToCur(r0);
        r0.release();
        return true;
    L5:
        this._cur.copyNode(r5._cur);
        goto L6
    }

    public boolean _copyXmlContents(Cursor r4) {
        if (this._cur.isContainer() == true) goto L5;
    L12:
        return false;
    L5:
        if (this._cur.contains(r4._cur) == true) goto L12;
        if (checkContentInsertionValidity(r4) == true) goto L10;
        return false;
    L10:
        Cur r0 = this._cur._locale.tempCur();
        this._cur.copyNode(r0);
        Cur r3 = r4._cur.tempCur();
        r0.moveNodeContents(r4._cur, false);
        r0.release();
        r4._cur.moveToCur(r3);
        r3.release();
        return true;
    }

    public XmlCursor.TokenType _currentTokenType() {
        switch(this._cur.kind()) {
            case -2: goto L24;
            case -1: goto L22;
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException();
    L7:
        return XmlCursor.TokenType.PROCINST;
    L9:
        return XmlCursor.TokenType.COMMENT;
    L11:
        if (this._cur.isXmlns() == false) goto L14;
        return XmlCursor.TokenType.NAMESPACE;
    L14:
        return XmlCursor.TokenType.ATTR;
    L16:
        return XmlCursor.TokenType.START;
    L18:
        return XmlCursor.TokenType.STARTDOC;
    L20:
        return XmlCursor.TokenType.TEXT;
    L22:
        return XmlCursor.TokenType.ENDDOC;
    L24:
        return XmlCursor.TokenType.END;
    }

    public void _dispose() {
        this._cur.release();
        this._cur = null;
    }

    public XmlDocumentProperties _documentProperties() {
        return Locale.getDocProps(this._cur, true);
    }

    public void _dump() {
        this._cur.dump();
    }

    public String _getAttributeText(QName r2) {
        if (r2 == null) goto L10;
        if (this._cur.isContainer() == true) goto L8;
        return null;
    L8:
        return this._cur.getAttrValue(r2);
    L10:
        throw new IllegalArgumentException("Attr name is null");
    }

    public XmlCursor.XmlBookmark _getBookmark(Object r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return getBookmark(r1, this._cur);
    }

    public String _getChars() {
        return this._cur.getCharsAsString();
    }

    public Node _getDomNode() {
        return (Node) ZeusTransformUtils.preCheckCast(this._cur.getDom(), Node.class, "com.obric.memorydata.plugin");
    }

    public QName _getName() {
        int r0 = this._cur.kind();
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L11;
        if (r0 == 5) goto L15;
        return null;
    L11:
        if (this._cur.isXmlns() == false) goto L15;
        return this._cur._locale.makeQNameNoCheck(this._cur.getXmlnsUri(), this._cur.getXmlnsPrefix());
    L15:
        return this._cur.getName();
    }

    public XmlObject _getObject() {
        return this._cur.getObject();
    }

    public int _getSelectionCount() {
        _toSelection(Integer.MAX_VALUE);
        return this._cur.selectionCount();
    }

    public String _getTextValue() {
        if (this._cur.isText() == false) goto L7;
        return _getChars();
    L7:
        if (this._cur.isNode() == false) goto L14;
        boolean r0 = this._cur.hasChildren();
        Cur r1 = this._cur;
        if (r0 == false) goto L12;
        return Locale.getTextValue(r1);
    L12:
        return r1.getValueAsString();
    L14:
        throw new IllegalStateException("Can't get text value, current token can have no text value");
    }

    public boolean _hasNextSelection() {
        int r0 = this._currentSelection;
        push();
        boolean r1 = _toNextSelection();     // Catch: Throwable -> L6
        this._currentSelection = r0;
        pop();
        return r1;
    L6:
        th = move-exception;
        this._currentSelection = r0;
        pop();
        throw th;
    }

    public boolean _hasNextToken() {
        if (this._cur._pos == (-1)) goto L5;
        return true;
    L5:
        if (this._cur._xobj.kind() != 1) goto L10;
        return false;
    L10:
        return true;
    }

    public void _insertAttributeWithValue(QName r2, String r3) {
        if (r2 == null) goto L6;
        validateLocalName(r2.getLocalPart());
        Cur r0 = this._cur._locale.tempCur();
        r0.createAttr(r2);
        insertNode(r0, r3);
        r0.release();
        return;
    L6:
        throw new IllegalArgumentException("QName must not be null");
    }

    public void _insertChars(String r4) {
        if (r4 != null) goto L5;
        int r1 = 0;
    L6:
        if (r1 > 0) goto L8;
        return;
    L8:
        if (this._cur.isRoot() == true) goto L13;
        if (this._cur.isAttr() == true) goto L13;
        this._cur.insertChars(r4, 0, r1);
        this._cur.nextChars(r1);
        return;
    L13:
        throw new IllegalStateException("Can't insert before the document or an attribute.");
    L5:
        r1 = r4.length();
        goto L6
    }

    public boolean _isContainer() {
        return this._cur.isContainer();
    }

    public boolean _isEnd() {
        return this._cur.isEnd();
    }

    public boolean _isStart() {
        return this._cur.isElem();
    }

    public boolean _isStartdoc() {
        return this._cur.isRoot();
    }

    public Object _monitor() {
        return this._cur._locale;
    }

    public int _moveChars(int r3, Cursor r4) {
        int r0 = this._cur.cchRight();
        if (r0 <= 0) goto L11;
        if (r3 == 0) goto L13;
        if (r3 < 0) goto L8;
        if (r3 > r0) goto L8;
    L9:
        r4.checkInsertionValidity(this._cur);
        this._cur.moveChars(r4._cur, r3);
        r4._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    L8:
        r3 = r0;
        goto L9
    L13:
        return 0;
    L11:
        return 0;
    }

    public boolean _moveXml(Cursor r6) {
        r6.checkInsertionValidity(this._cur);
        if (this._cur.isText() == false) goto L10;
        int r0 = this._cur.cchRight();
        if (this._cur.inChars(r6._cur, r0, true) == false) goto L7;
        return false;
    L7:
        this._cur.moveChars(r6._cur, r0);
        r6._cur.nextChars(r0);
        return true;
    L10:
        if (this._cur.contains(r6._cur) == false) goto L12;
        return false;
    L12:
        Cur r1 = r6.tempCur();
        this._cur.moveNode(r6._cur);
        r6._cur.moveToCur(r1);
        r1.release();
        return true;
    }

    public boolean _moveXmlContents(Cursor r4) {
        if (this._cur.isContainer() == true) goto L5;
    L12:
        return false;
    L5:
        if (this._cur.contains(r4._cur) == true) goto L12;
        if (checkContentInsertionValidity(r4) == true) goto L10;
        return false;
    L10:
        Cur r0 = r4.tempCur();
        this._cur.moveNodeContents(r4._cur, false);
        r4._cur.moveToCur(r0);
        r0.release();
        return true;
    }

    public String _namespaceForPrefix(String r2) {
        if (this._cur.isContainer() == false) goto L7;
        return this._cur.namespaceForPrefix(r2, true);
    L7:
        throw new IllegalStateException("Not on a container");
    }

    public XmlCursor _newCursor() {
        return new Cursor(this._cur);
    }

    public Node _newDomNode(XmlOptions r3) {
        if (r3 == null) goto L7;
        if (r3.isSaveInner() == false) goto L7;
        XmlOptions r0 = new XmlOptions(r3);
        r0.setSaveInner(false);
        r3 = r0;
    L7:
        return new DomSaver(this._cur, isDomFragment(), r3).saveDom();
    }

    public InputStream _newInputStream(XmlOptions r2) {
        return new Saver.InputStreamSaver(this._cur, r2);
    }

    public Reader _newReader(XmlOptions r2) {
        return new Saver.TextReader(this._cur, r2);
    }

    public e _newXMLStreamReader() {
        return _newXMLStreamReader(null);
    }

    public e _newXMLStreamReader(XmlOptions r1) {
        return Jsr173.newXmlStreamReader(this._cur, r1);
    }

    public boolean _pop() {
        return this._cur.pop();
    }

    public void _push() {
        this._cur.push();
    }

    public void _save(File r2, XmlOptions r3) {
        if (r2 == null) goto L16;
        FileOutputStream r0 = new FileOutputStream(r2);
        _save(r0, r3);     // Catch: Throwable -> L7
        r0.close();
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    L16:
        throw new IllegalArgumentException("Null file specified");
    }

    public void _save(OutputStream r3, XmlOptions r4) {
        if (r3 == null) goto L23;
        InputStream r2 = _newInputStream(r4);
        byte[] r5 = new byte[8192];     // Catch: Throwable -> L13
    L5:
        int r0 = r2.read(r5);     // Catch: Throwable -> L13
        if (r0 < 0) goto L7;
        r3.write(r5, 0, r0);     // Catch: Throwable -> L13
        goto L5
    L7:
        if (r2 == null) goto L32;
        r2.close();
        return;
    L32:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r2 != null) goto L24;
    L21:
        throw th;
    L24:
        r2.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    L23:
        throw new IllegalArgumentException("Null OutputStream specified");
    }

    public void _save(Writer r3, XmlOptions r4) {
        if (r3 == null) goto L28;
        if (r4 != null) goto L5;
    L8:
        Reader r2 = _newReader(r4);
        char[] r5 = new char[8192];     // Catch: Throwable -> L18
    L10:
        int r0 = r2.read(r5);     // Catch: Throwable -> L18
        if (r0 < 0) goto L12;
        r3.write(r5, 0, r0);     // Catch: Throwable -> L18
        goto L10
    L12:
        if (r2 == null) goto L37;
        r2.close();
        return;
    L37:
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r2 != null) goto L29;
    L26:
        throw th;
    L29:
        r2.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);
        goto L26
    L5:
        if (r4.isSaveOptimizeForSpeed() == false) goto L8;
        Saver.OptimizedForSpeedSaver.save(this._cur, r3);
        return;
    L28:
        throw new IllegalArgumentException("Null Writer specified");
    }

    public void _save(ContentHandler r3, LexicalHandler r4, XmlOptions r5) {
        ContentHandler r6 = (ContentHandler) ZeusTransformUtils.wrapperContextForParams(r3, ContentHandler.class, "com.obric.memorydata.plugin");
        LexicalHandler r7 = (LexicalHandler) ZeusTransformUtils.wrapperContextForParams(r4, LexicalHandler.class, "com.obric.memorydata.plugin");
        new Saver.SaxSaver(this._cur, r5, r6, r7);
    }

    public void _selectPath(String r2) {
        _selectPath(r2, null);
    }

    public void _selectPath(String r2, XmlOptions r3) {
        _clearSelections();
        this._pathEngine = XPathFactory.getCompiledPath(r2, r3).execute(this._cur, r3);
        this._cur._locale.registerForChange(this);
    }

    public boolean _toChild(String r2, String r3) {
        validateLocalName(r3);
        return _toChild(this._cur._locale.makeQName(r2, r3), 0);
    }

    public boolean _toChild(QName r2) {
        return _toChild(r2, 0);
    }

    public boolean _toChild(QName r1, int r2) {
        return Locale.toChild(this._cur, r1, r2);
    }

    public XmlCursor.TokenType _toEndToken() {
        if (this._cur.isContainer() == false) goto L5;
        this._cur.toEnd();
        return currentTokenType();
    L5:
        return XmlCursor.TokenType.NONE;
    }

    public boolean _toFirstAttribute() {
        if (this._cur.isContainer() == true) goto L5;
    L7:
        return false;
    L5:
        if (Locale.toFirstNormalAttr(this._cur) == false) goto L7;
        return true;
    }

    public boolean _toFirstChild() {
        return Locale.toFirstChildElement(this._cur);
    }

    public boolean _toNextAttribute() {
        if (this._cur.isAttr() == true) goto L5;
    L7:
        return false;
    L5:
        if (Locale.toNextNormalAttr(this._cur) == false) goto L7;
        return true;
    }

    public boolean _toNextSelection() {
        return _toSelection(this._currentSelection + 1);
    }

    public boolean _toNextSibling(QName r2) {
        this._cur.push();
    L4:
        if (___toNextSibling() == false) goto L9;
        if (this._cur.getName().equals(r2) == false) goto L4;
        this._cur.popButStay();
        return true;
    L9:
        this._cur.pop();
        return false;
    }

    public XmlCursor.TokenType _toNextToken() {
        int r0 = this._cur.kind();
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L11;
    L16:
        this._cur.skip();
    L24:
        return _currentTokenType();
    L11:
        if (r0 == 5) goto L16;
        if (this._cur.next() == true) goto L24;
        return XmlCursor.TokenType.NONE;
    L18:
        if (this._cur.toNextSibling() == true) goto L24;
        this._cur.toParent();
    L22:
        this._cur.next();
    L21:
        if (this._cur.toFirstAttr() == true) goto L24;
        goto L22
    }

    public boolean _toParent() {
        Cur r0 = this._cur.tempCur();
        if (r0.toParent() == true) goto L6;
        return false;
    L6:
        this._cur.moveToCur(r0);
        r0.release();
        return true;
    }

    public XmlCursor.XmlBookmark _toPrevBookmark(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        this._cur.push();
    L6:
        int r1 = this._cur.cchLeft();
        if (r1 <= 1) goto L13;
        this._cur.prevChars(1);
        Cur r3 = this._cur;
        int r2 = r3.firstBookmarkInCharsLeft(r5, r1 - 1);
        if (r2 >= 0) goto L12;
        r2 = -1;
    L12:
        r3.prevChars(r2);
    L19:
        XmlCursor.XmlBookmark r4 = getBookmark(r5, this._cur);
        if (r4 != null) goto L21;
        if (this._cur.kind() != 1) goto L6;
    L17:
        this._cur.pop();
        return null;
    L21:
        this._cur.popButStay();
        return r4;
    L13:
        if (r1 != 1) goto L16;
        this._cur.prevChars(1);
        goto L19
    L16:
        if (_toPrevToken().isNone() == false) goto L19;
        goto L19
    }

    public XmlCursor.TokenType _toPrevToken() {
        boolean r0 = this._cur.isText();
        if (this._cur.prev() == false) goto L5;
        int r1 = this._cur.kind();
        if (r1 != (-4)) goto L11;
    L23:
        this._cur.toParent();
    L25:
        return _currentTokenType();
    L11:
        if (r1 == (-5)) goto L23;
        if (r1 == (-3)) goto L23;
        if (this._cur.isContainer() == false) goto L18;
        this._cur.toLastAttr();
        goto L25
    L18:
        if (r0 == false) goto L25;
        if (this._cur.isText() == false) goto L25;
        return _toPrevToken();
    L5:
        if (this._cur.isRoot() == false) goto L23;
        return XmlCursor.TokenType.NONE;
    }

    public boolean _toSelection(int r4) {
        if (r4 >= 0) goto L6;
        return false;
    L6:
        if (r4 < this._cur.selectionCount()) goto L14;
        XPathEngine r1 = this._pathEngine;
        if (r1 == null) goto L9;
        if (r1.next(this._cur) == true) goto L6;
        this._pathEngine.release();
        this._pathEngine = null;
        return false;
    L9:
        return false;
    L14:
        Cur r0 = this._cur;
        this._currentSelection = r4;
        r0.moveToSelection(r4);
        return true;
    }

    public void _toStartDoc() {
        this._cur.toRoot();
    }

    public String _xmlText() {
        return _xmlText(null);
    }

    public String _xmlText(XmlOptions r3) {
        return new Saver.TextSaver(this._cur, r3, null).saveToString();
    }

    @Override // org.apache.xmlbeans.XmlCursor, java.lang.AutoCloseable
    public void close() {
        if (this._cur == null) goto L6;
        syncWrap(new $$Lambda$qjcvvixJFIB8LTY6s67y5RDef2Y(this));
        return;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean copyXmlContents(XmlCursor r3) {
        if (twoLocaleOp((XmlCursor) ZeusTransformUtils.wrapperContextForParams(r3, XmlCursor.class, "com.obric.memorydata.plugin"), 3, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType currentTokenType() {
        return (XmlCursor.TokenType) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$aOioVqEy0oPpkwjLST751_X5T0(this)), XmlCursor.TokenType.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    @Deprecated
    public void dispose() {
        close();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        return (XmlDocumentProperties) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$A91oy5eIwoFOxOJa8eMUYhmWQHQ(this)), XmlDocumentProperties.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        syncWrap(new $$Lambda$DFUvYCJnzLSlniQF1ptSAbIttg8(this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getAttributeText(final QName r2) {
        return (String) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$7NCEGfZhUnC1j2xoJ_J17Om8CYs(this, r2)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark getBookmark(final Object r2) {
        return (XmlCursor.XmlBookmark) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$ams4_T2N0W3vHlfO5KcenDqrnoA(this, r2)), XmlCursor.XmlBookmark.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getChars() {
        return (String) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$MHfxeNkM7sxpSKHPBZ1yyFcpozs(this)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Oe6n5a9Cv9YdaE9ABfjRoUvyqc(this)), Node.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public QName getName() {
        return (QName) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$CWY_eRLxwuAcrDtpNWltSX0O40(this)), QName.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public Locale.ChangeListener getNextChangeListener() {
        return this._nextChangeListener;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlObject getObject() {
        return (XmlObject) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$49ytV6351uwPjl_2jTJWoE5qs(this)), XmlObject.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getSelectionCount() {
        return ((Integer) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$cMyKkgWNHpi5hpWnCLc8SE30_4g(this)), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getTextValue() {
        return (String) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$assnlmCSoxSF1rbwiDQO_B3McOU(this)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextSelection() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$hQ7RS3YBztkemyOgfX3H1JDvqtc(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextToken() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$z7FF5ziVfYK3RdSYNwmS8cD8gQQ(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(final QName r2, final String r3) {
        syncWrap(new $$Lambda$Cursor$JJfNDGyydKQ4ObY8W_klRT1VTw(this, r2, r3));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertChars(final String r2) {
        syncWrap(new $$Lambda$Cursor$Ub4qp5RLesujG1hCPt80FXRPs1w(this, r2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isContainer() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$_bvFhqbkTlFDtXzIgOcX7r6oPE(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isEnd() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$qnQHst17ahcpsInYNDwD0NdPOjQ(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isStart() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$SCfoQ0Nq6muHjUUeKfaFK9Ui0Xk(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public boolean isStartdoc() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$BdWVARLEIrNE_0phX6EV_UtVf4(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public /* synthetic */ String lambda$getAttributeText$39$Cursor(QName r1) {
        return _getAttributeText(r1);
    }

    public /* synthetic */ XmlCursor.XmlBookmark lambda$getBookmark$49$Cursor(Object r1) {
        return _getBookmark(r1);
    }

    public /* synthetic */ void lambda$insertAttributeWithValue$68$Cursor(QName r1, String r2) {
        _insertAttributeWithValue(r1, r2);
    }

    public /* synthetic */ void lambda$insertChars$53$Cursor(String r1) {
        _insertChars(r1);
    }

    public /* synthetic */ String lambda$namespaceForPrefix$26$Cursor(String r1) {
        return _namespaceForPrefix(r1);
    }

    public /* synthetic */ Node lambda$newDomNode$14$Cursor(XmlOptions r1) {
        return _newDomNode(r1);
    }

    public /* synthetic */ InputStream lambda$newInputStream$12$Cursor(XmlOptions r1) {
        return _newInputStream(r1);
    }

    public /* synthetic */ Reader lambda$newReader$13$Cursor(XmlOptions r1) {
        return _newReader(r1);
    }

    public /* synthetic */ e lambda$newXMLStreamReader$6$Cursor(XmlOptions r1) {
        return _newXMLStreamReader(r1);
    }

    public /* synthetic */ void lambda$save$15$Cursor(ContentHandler r3, LexicalHandler r4, XmlOptions r5) {
        _save((ContentHandler) ZeusTransformUtils.wrapperContextForParams(r3, ContentHandler.class, "com.obric.memorydata.plugin"), (LexicalHandler) ZeusTransformUtils.wrapperContextForParams(r4, LexicalHandler.class, "com.obric.memorydata.plugin"), r5);
    }

    public /* synthetic */ void lambda$save$16$Cursor(File r1, XmlOptions r2) {
        _save(r1, r2);
    }

    public /* synthetic */ void lambda$save$17$Cursor(OutputStream r1, XmlOptions r2) {
        _save(r1, r2);
    }

    public /* synthetic */ void lambda$save$18$Cursor(Writer r1, XmlOptions r2) {
        _save(r1, r2);
    }

    public /* synthetic */ void lambda$selectPath$19$Cursor(String r1) {
        _selectPath(r1);
    }

    public /* synthetic */ void lambda$selectPath$20$Cursor(String r1, XmlOptions r2) {
        _selectPath(r1, r2);
    }

    public /* synthetic */ Boolean lambda$toChild$32$Cursor(String r1, String r2) {
        return Boolean.valueOf(_toChild(r1, r2));
    }

    public /* synthetic */ Boolean lambda$toChild$33$Cursor(QName r1) {
        return Boolean.valueOf(_toChild(r1));
    }

    public /* synthetic */ Boolean lambda$toNextSibling$38$Cursor(QName r1) {
        return Boolean.valueOf(_toNextSibling(r1));
    }

    public /* synthetic */ XmlCursor.XmlBookmark lambda$toPrevBookmark$24$Cursor(Object r1) {
        return _toPrevBookmark(r1);
    }

    public /* synthetic */ Integer lambda$twoLocaleOp$0$Cursor(Cursor r1, int r2, int r3) {
        return Integer.valueOf(twoLocaleOp(r1, r2, r3));
    }

    public /* synthetic */ String lambda$xmlText$11$Cursor(XmlOptions r1) {
        return _xmlText(r1);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Object monitor() {
        return syncWrap(new $$Lambda$b6tDRXAndM7ceYA6rovUo3ddfyI(this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String namespaceForPrefix(final String r2) {
        return (String) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$pfbP6bGAyNq3RXOOsx1qWtLaAU(this, r2)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        return (XmlCursor) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$aS_DTeQnHX6DGrqTkxwX6KiPSoc(this)), XmlCursor.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(final XmlOptions r2) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$cdzRV4x13oPUDdlqd09rcJklnlU(this, r2)), Node.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(final XmlOptions r2) {
        return (InputStream) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$7_vTbyDYMSA3JbvbHyjL6IGoI(this, r2)), InputStream.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(final XmlOptions r2) {
        return (Reader) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$P4QPXP6eo1Gamo63jpgUmpFmpgI(this, r2)), Reader.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public e newXMLStreamReader() {
        return (e) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$1k2GMGI6MSZBZopAuOERo9ci_iU(this)), e.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public e newXMLStreamReader(final XmlOptions r2) {
        return (e) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$tNl9CiTgsYMXyA79qSISxZoqCsA(this, r2)), e.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void notifyChange() {
        if (this._cur == null) goto L6;
        _getSelectionCount();
        return;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean pop() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$qnfbfmqg9MuNAhq8Q2C8rMrj2E(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void push() {
        syncWrap(new $$Lambda$sJQWZYsM_ZN8fuZiKsBXBI6BvE(this));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final File r2, final XmlOptions r3) {
        syncWrapIOEx(new $$Lambda$Cursor$FLa5OyN2FSeett0z_44dTSjB8fc(this, r2, r3));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final OutputStream r2, final XmlOptions r3) {
        syncWrapIOEx(new $$Lambda$Cursor$o7Aj5tvo4bOMk4WKCO5cv7UhE(this, r2, r3));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final Writer r2, final XmlOptions r3) {
        syncWrapIOEx(new $$Lambda$Cursor$2eQsnemKjF_dmdRc2MuO1mH1Eo(this, r2, r3));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler r3, LexicalHandler r4, final XmlOptions r5) {
        final ContentHandler r6 = (ContentHandler) ZeusTransformUtils.wrapperContextForParams(r3, ContentHandler.class, "com.obric.memorydata.plugin");
        final LexicalHandler r7 = (LexicalHandler) ZeusTransformUtils.wrapperContextForParams(r4, LexicalHandler.class, "com.obric.memorydata.plugin");
        syncWrapSAXEx(new $$Lambda$Cursor$OwbcgobVhUfVOjhBZdZdGBNfw0k(this, r6, r7, r5));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(final String r2) {
        syncWrap(new $$Lambda$Cursor$5YdrUGwKGOp4BuQNlSDc2ePA8Bg(this, r2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(final String r2, final XmlOptions r3) {
        syncWrap(new $$Lambda$Cursor$b_9dohUeVRkLPLA31wlOBOB38Gc(this, r2, r3));
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void setNextChangeListener(Locale.ChangeListener r3) {
        this._nextChangeListener = (Locale.ChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, Locale.ChangeListener.class, "com.obric.memorydata.plugin");
    }

    Cur tempCur() {
        return this._cur.tempCur();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(final String r2, final String r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$A5P7RftOvw3RHPd0ptrLgDjNpg(this, r2, r3)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(final QName r2) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$BjfRQ7nOWWhU05e2AqLSX_VdA(this, r2)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toEndToken() {
        return (XmlCursor.TokenType) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$bf06ak9xBoedzxo4QcHGCYi8rrI(this)), XmlCursor.TokenType.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstAttribute() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$CUH8cx3EHKDLruRlplll1oVR0uc(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstChild() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$tEuYe8793UbwzDOY00CW_sLt4Ns(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextAttribute() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$PVQK8IRtk8ck8cEGIYFyq8XQO2o(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSelection() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$JawJKFRL9i1R_hBg8xOBGUCoA(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(new $$Lambda$41QSUIxh_F4im3kQaH_YLTfSl8U(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(final QName r2) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$CtrgShgNdhcuYotJAbGt1OMLx_g(this, r2)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toNextToken() {
        return (XmlCursor.TokenType) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$rTb8jOFx6kOAYyrCg_nYIoid1M(this)), XmlCursor.TokenType.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toParent() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$sPdUzxKPuflGisbTFmwh1T5DV0(this)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark toPrevBookmark(final Object r2) {
        return (XmlCursor.XmlBookmark) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$5RyOkxQRIU_AM5txypll1bldDOQ(this, r2)), XmlCursor.XmlBookmark.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toPrevToken() {
        return (XmlCursor.TokenType) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$77O0e5jCUvJIHIfVbjm6W3fDSjA(this)), XmlCursor.TokenType.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void toStartDoc() {
        syncWrapNoEnter(new $$Lambda$cvk4RAPwpvmvg8NpuTwIsAlXkqY(this));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return (String) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$2aIY78DxsnrL6YoiyD7xSvGSKPk(this)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(final XmlOptions r2) {
        return (String) ZeusTransformUtils.preCheckCast(syncWrap(new $$Lambda$Cursor$egqRU9Gc3_D9yTo4mu6S8T4YhH8(this, r2)), String.class, "com.obric.memorydata.plugin");
    }
}
