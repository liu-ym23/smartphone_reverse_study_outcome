package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.apache.xmlbeans.impl.xpath.XPathFactory;

/* JADX INFO: loaded from: classes7.dex */
abstract class Xobj implements TypeStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int _bits;
    Bookmark _bookmarks;
    int _cchAfter;
    int _cchValue;
    CharNode _charNodesAfter;
    CharNode _charNodesValue;
    Cur _embedded;
    Xobj _firstChild;
    Xobj _lastChild;
    Locale _locale;
    QName _name;
    Xobj _nextSibling;
    int _offAfter;
    int _offValue;
    Xobj _parent;
    Xobj _prevSibling;
    Object _srcAfter;
    Object _srcValue;
    TypeStoreUser _user;

    static {
    }

    Xobj(Locale r1, int r2, int r3) {
        this._locale = r1;
        this._bits = (r3 << 4) + r2;
    }

    private static TypeStoreUser insertElement(QName r1, Xobj r2, int r3) {
        r2._locale.enter();
        Cur r0 = r2._locale.tempCur();     // Catch: Throwable -> L6
        r0.moveTo(r2, r3);     // Catch: Throwable -> L6
        r0.createElement(r1);     // Catch: Throwable -> L6
        TypeStoreUser r4 = r0.getUser();     // Catch: Throwable -> L6
        r0.release();     // Catch: Throwable -> L6
        r2._locale.exit();
        return r4;
    L6:
        th = move-exception;
        r2._locale.exit();
        throw th;
    }

    private static void removeElement(Xobj r2) {
        if (r2 == null) goto L11;
        r2._locale.enter();
        Cur r0 = r2.tempCur();     // Catch: Throwable -> L7
        r0.moveNode(null);     // Catch: Throwable -> L7
        r0.release();     // Catch: Throwable -> L7
        r2._locale.exit();
        return;
    L7:
        th = move-exception;
        r2._locale.exit();
        throw th;
    L11:
        throw new IndexOutOfBoundsException();
    }

    private void setValue(String r9) {
        if (r9.length() > 0) goto L5;
        return;
    L5:
        this._locale.notifyChange();
        Xobj r0 = lastAttr();
        int r1 = 1;
        if (r0 == null) goto L8;
        r1 = r0.posAfter();
        Xobj r2 = r0;
    L9:
        r2.insertCharsHelper(r1, r9, 0, r9.length(), true);
        return;
    L8:
        r2 = this;
        goto L9
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_attribute_user(QName r2) {
        if (getAttr(r2) != null) goto L12;
        this._locale.enter();
        TypeStoreUser r3 = setAttr(r2, "").getUser();     // Catch: Throwable -> L8
        this._locale.exit();
        return r3;
    L8:
        th = move-exception;
        this._locale.exit();
        throw th;
    L12:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_element_user(QName r7) {
        if (isContainer() == false) goto L23;
        Xobj r0 = this._lastChild;
        Xobj r2 = null;
        boolean r4 = false;
        QNameSet r3 = null;
    L5:
        if (r0 == null) goto L18;
        if (r0.isContainer() == false) goto L17;
        if (r0._name.equals(r7) == true) goto L18;
        if (r4 == true) goto L13;
        r3 = this._user.get_element_ending_delimiters(r7);
        r4 = true;
    L13:
        if (r3 != null) goto L15;
    L16:
        r2 = r0;
        goto L17
    L15:
        if (r3.contains(r0._name) == true) goto L16;
    L17:
        r0 = r0._prevSibling;
    L18:
        if (r2 != null) goto L21;
        return insertElement(r7, this, -1);
    L21:
        return insertElement(r7, r2, 0);
    L23:
        throw new IllegalStateException();
    }

    final Xobj appendXobj(Xobj r2) {
        r2._parent = this;
        Xobj r0 = this._lastChild;
        r2._prevSibling = r0;
        if (r0 != null) goto L5;
        this._firstChild = r2;
    L6:
        this._lastChild = r2;
        return this;
    L5:
        r0._nextSibling = r2;
        goto L6
    }

    final void appendXobjs(Xobj r2, Xobj r3) {
        Xobj r0 = this._lastChild;
        r2._prevSibling = r0;
        if (r0 != null) goto L5;
        this._firstChild = r2;
    L6:
        this._lastChild = r3;
    L7:
        if (r2 == null) goto L9;
        r2._parent = this;
        r2 = r2._nextSibling;
        goto L7
    L9:
        return;
    L5:
        r0._nextSibling = r2;
        goto L6
    }

    final boolean bitIsClear(int r1) {
        if ((this._bits & r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean bitIsSet(int r1) {
        if ((this._bits & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    final int cchAfter() {
        return this._cchAfter;
    }

    final int cchLeft(int r2) {
        if (isRoot() == false) goto L7;
        if (r2 != 0) goto L7;
        return 0;
    L7:
        Xobj r3 = getDenormal(r2);
        int r1 = posTemp();
        int r4 = r3.posAfter();
        if (r1 >= r4) goto L11;
        r4 = 1;
    L11:
        return r1 - r4;
    }

    final int cchRight(int r2) {
        if (r2 > 0) goto L5;
        return 0;
    L5:
        int r0 = posAfter();
        if (r2 >= r0) goto L9;
        return (r0 - r2) - 1;
    L9:
        return posMax() - r2;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser change_type(SchemaType r3) {
        SchemaType r4 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        this._locale.enter();
        Cur r0 = tempCur();     // Catch: Throwable -> L6
        r0.setType(r4, false);     // Catch: Throwable -> L6
        r0.release();     // Catch: Throwable -> L6
        this._locale.exit();
        return getUser();
    L6:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    final void clearBit(int r2) {
        int r0 = this._bits;
        this._bits = (~r2) & r0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String compute_default_text() {
        if (isRoot() == false) goto L5;
        return null;
    L5:
        TypeStoreUser r0 = ensureParent().getUser();
        if (isAttr() == true) goto L8;
        String r2 = r0.get_default_element_text(this._name);
        if (r2 == null) goto L12;
        return r2;
    L12:
        TypeStoreVisitor r1 = r0.new_visitor();
        if (r1 != null) goto L15;
        return null;
    L15:
        Xobj r3 = this._parent._firstChild;
    L17:
        if (r3.isElem() == false) goto L22;
        r1.visit(r3._name);
        if (r3 != this) goto L22;
        return r1.get_default_text();
    L22:
        r3 = r3._nextSibling;
        goto L17
    L8:
        return r0.get_default_attribute_text(this._name);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int compute_flags() {
        if (isRoot() == false) goto L5;
        return 0;
    L5:
        TypeStoreUser r0 = ensureParent().getUser();
        if (isAttr() == true) goto L8;
        int r2 = r0.get_elementflags(this._name);
        if (r2 == (-1)) goto L12;
        return r2;
    L12:
        TypeStoreVisitor r1 = r0.new_visitor();
        if (r1 != null) goto L15;
        return 0;
    L15:
        Xobj r3 = this._parent._firstChild;
    L17:
        if (r3.isElem() == false) goto L22;
        r1.visit(r3._name);
        if (r3 != this) goto L22;
        return r1.get_elementflags();
    L22:
        r3 = r3._nextSibling;
        goto L17
    L8:
        return r0.get_attributeflags(this._name);
    }

    final boolean contains(Cur r2) {
        return contains(r2._xobj, r2._pos);
    }

    final boolean contains(Xobj r3, int r4) {
        if (this != r3) goto L13;
        if (r4 == (-1)) goto L22;
        if (r4 <= 0) goto L11;
        if (r4 >= posAfter()) goto L11;
        return true;
    L11:
        return false;
    L22:
        return true;
    L13:
        if (this._firstChild != null) goto L15;
        return false;
    L15:
        if (r3 == null) goto L19;
        if (r3 == this) goto L17;
        r3 = r3._parent;
        goto L15
    L17:
        return true;
    L19:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy(SchemaTypeLoader r4, SchemaType r5, XmlOptions r6) {
        SchemaTypeLoader r7 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r4, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        XmlOptions r9 = XmlOptions.maskNull(r6);
        SchemaType r0 = r9.getDocumentType();
        if (r0 != null) goto L7;
        if (r8 != null) goto L6;
        r0 = XmlObject.type;
        goto L7
    L6:
        r0 = r8;
    L7:
        Locale r1 = locale();
        if (r9.isCopyUseNewSynchronizationDomain() == false) goto L11;
        r1 = Locale.getLocale(r7, r9);
    L11:
        if (r0.isDocumentType() == false) goto L13;
    L17:
        boolean r10 = false;
    L18:
        Xobj r11 = Cur.createDomDocumentRootXobj(r1, r10);
        r1.enter();
        Cur r12 = r11.tempCur();     // Catch: Throwable -> L22
        r12.setType(r8);     // Catch: Throwable -> L22
        r12.release();     // Catch: Throwable -> L22
        r1.exit();
        return r11.copy_contents_from(this);
    L22:
        th = move-exception;
        r1.exit();
        throw th;
    L13:
        if (r0.isNoType() == true) goto L15;
    L16:
        r10 = true;
        goto L18
    L15:
        if (ZeusTransformUtils.instanceOf(this, DocumentXobj.class) == true) goto L17;
        goto L16
    }

    Xobj copyNode(Locale r10) {
        Xobj r1 = this;
        Xobj r2 = null;
        Xobj r3 = null;
    L3:
        r1.ensureOccupancy();
        Xobj r4 = r1.newNode(r10);
        r4._srcValue = r1._srcValue;
        r4._offValue = r1._offValue;
        r4._cchValue = r1._cchValue;
        r4._srcAfter = r1._srcAfter;
        r4._offAfter = r1._offAfter;
        r4._cchAfter = r1._cchAfter;
        Bookmark r5 = r1._bookmarks;
    L4:
        if (r5 == null) goto L9;
        if (r1.hasBookmark(CDataBookmark.CDATA_BOOKMARK.getKey(), r5._pos) == false) goto L8;
        r4.setBookmark(r5._pos, CDataBookmark.CDATA_BOOKMARK.getKey(), CDataBookmark.CDATA_BOOKMARK);
    L8:
        r5 = r5._next;
        goto L4
    L9:
        if (r2 != null) goto L11;
        r3 = r4;
    L12:
        Xobj r6 = r1.walk(this, true);
        if (r6 == null) goto L14;
        if (r1 != r6._parent) goto L19;
        r2 = r4;
    L22:
        r1 = r6;
    L19:
        r1 = r1._parent;
        if (r1 == r6._parent) goto L22;
        r2 = r2._parent;
        goto L19
    L14:
        r3._srcAfter = null;
        r3._offAfter = 0;
        r3._cchAfter = 0;
        return r3;
    L11:
        r2.appendXobj(r4);
        goto L12
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy_contents_from(TypeStore r8) {
        Xobj r9 = (Xobj) ZeusTransformUtils.preCheckCast((TypeStore) ZeusTransformUtils.wrapperContextForParams(r8, TypeStore.class, "com.obric.memorydata.plugin"), Xobj.class, "com.obric.memorydata.plugin");
        if (r9 == this) goto L5;
        this._locale.enter();
        r9._locale.enter();     // Catch: Throwable -> L30
        Cur r0 = tempCur();     // Catch: Throwable -> L30
        Cur r1 = r9.tempCur();     // Catch: Throwable -> L27
        Map<String, String> r3 = Locale.getAllNamespaces(r1, null);     // Catch: Throwable -> L27
        r1.release();     // Catch: Throwable -> L27
        if (isAttr() == false) goto L11;
        Cur r2 = r9.tempCur();     // Catch: Throwable -> L27
        String r4 = Locale.getTextValue(r2);     // Catch: Throwable -> L27
        r2.release();     // Catch: Throwable -> L27
        r0.setValue(r4);     // Catch: Throwable -> L27
    L19:
        if (r3 != null) goto L21;
    L24:
        r0.release();     // Catch: Throwable -> L30
        r9._locale.exit();     // Catch: Throwable -> L30
        this._locale.exit();
        return getUser();
    L21:
        if (r0.isContainer() == true) goto L23;
        r0.toParent();     // Catch: Throwable -> L27
    L23:
        Locale.applyNamespaces(r0, r3);     // Catch: Throwable -> L27
    L11:
        disconnectChildrenUsers();     // Catch: Throwable -> L27
        setBit(1024);     // Catch: Throwable -> L27
        if (isContainer() == false) goto L14;
        QName r5 = getXsiTypeName();     // Catch: Throwable -> L27
    L15:
        Xobj r6 = r9.copyNode(this._locale);     // Catch: Throwable -> L27
        Cur.moveNodeContents(this, null, true);     // Catch: Throwable -> L27
        r0.next();     // Catch: Throwable -> L27
        Cur.moveNodeContents(r6, r0, true);     // Catch: Throwable -> L27
        r0.moveTo(this);     // Catch: Throwable -> L27
        if (r5 == null) goto L18;
        r0.setXsiType(r5);     // Catch: Throwable -> L27
    L18:
        clearBit(1024);     // Catch: Throwable -> L27
        goto L19
    L14:
        r5 = null;
    L27:
        th = move-exception;
        r0.release();     // Catch: Throwable -> L30
        r9._locale.exit();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this._locale.exit();
        throw th;
    L5:
        return getUser();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QName r3) {
        return this._locale.count(this, r3, null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QNameSet r3) {
        return this._locale.count(this, null, r3);
    }

    void disconnectChildrenUsers() {
        if (this._user != null) goto L5;
        boolean r0 = true;
    L6:
        Xobj r1 = walk(this, r0);
    L7:
        if (r1 == null) goto L13;
        if (r1._user == null) goto L11;
        boolean r3 = true;
    L12:
        Xobj r4 = r1.walk(this, r3);
        r1.disconnectUser();
        r1 = r4;
        goto L7
    L11:
        r3 = false;
        goto L12
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    void disconnectNonRootUsers() {
        Xobj r0 = this;
    L3:
        if (r0 == null) goto L12;
        if (r0._user == null) goto L7;
        boolean r1 = true;
    L8:
        Xobj r2 = r0.walk(this, r1);
        if (r0.isRoot() == true) goto L11;
        r0.disconnectUser();
    L11:
        r0 = r2;
        goto L3
    L7:
        r1 = false;
        goto L8
    }

    void disconnectUser() {
        if (this._user != null) goto L5;
        return;
    L5:
        if (inhibitDisconnect() == true) goto L9;
        ensureOccupancy();
        this._user.disconnect_store();
        this._user = null;
        return;
    }

    final int domType() {
        return (this._bits & 240) >> 4;
    }

    final void ensureOccupancy() {
        if (isVacant() == false) goto L6;
        clearBit(256);
        TypeStoreUser r0 = this._user;
        this._user = null;
        String r1 = r0.build_text(this);
        long r2 = this._locale._versionAll;
        long r4 = this._locale._versionSansText;
        setValue(r1);
        this._locale._versionAll = r2;
        this._user = r0;
        return;
    }

    final Xobj ensureParent() {
        Xobj r0 = this._parent;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new DocumentFragXobj(this._locale).appendXobj(this);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlObject[] exec_query(String r2, XmlOptions r3) {
        this._locale.enter();
        Cur r0 = tempCur();     // Catch: Throwable -> L6
        XmlObject[] r4 = XPathFactory.objectExecQuery(r0, r2, r3);     // Catch: Throwable -> L6
        r0.release();     // Catch: Throwable -> L6
        this._locale.exit();
        return r4;
    L6:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String fetch_text(int r2) {
        this._locale.enter();
        String r3 = getValueAsString(r2);     // Catch: Throwable -> L6
        this._locale.exit();
        return r3;
    L6:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    final Xobj findXmlnsForPrefix(String r3) {
    L2:
        if (this == null) goto L12;
        Xobj r0 = this.firstAttr();
    L4:
        if (r0 == null) goto L11;
        if (r0.isXmlns() == false) goto L10;
        if (r0.getXmlnsPrefix().equals(r3) == false) goto L10;
        return r0;
    L10:
        r0 = r0.nextAttr();
        goto L4
    L11:
        Xobj this = this._parent;
        goto L2
    L12:
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public <T extends XmlObject> void find_all_element_users(QName r4, List<T> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Xobj r3 = this._firstChild;
    L3:
        if (r3 == null) goto L10;
        if (r3.isElem() == false) goto L9;
        if (r3._name.equals(r4) == false) goto L9;
        r6.add((XmlObject) ZeusTransformUtils.preCheckCast(r3.getUser(), XmlObject.class, "com.obric.memorydata.plugin"));
    L9:
        r3 = r3._nextSibling;
        goto L3
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public <T extends XmlObject> void find_all_element_users(QNameSet r4, List<T> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Xobj r3 = this._firstChild;
    L3:
        if (r3 == null) goto L10;
        if (r3.isElem() == false) goto L9;
        if (r4.contains(r3._name) == false) goto L9;
        r6.add((XmlObject) ZeusTransformUtils.preCheckCast(r3.getUser(), XmlObject.class, "com.obric.memorydata.plugin"));
    L9:
        r3 = r3._nextSibling;
        goto L3
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_attribute_user(QName r1) {
        Xobj r0 = getAttr(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getUser();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QName r2, int r3) {
        Xobj r1 = this._firstChild;
    L3:
        if (r1 == null) goto L13;
        if (r1.isElem() == false) goto L12;
        if (r1._name.equals(r2) == false) goto L12;
        r3 = r3 - 1;
        if (r3 >= 0) goto L12;
        return r1.getUser();
    L12:
        r1 = r1._nextSibling;
        goto L3
    L13:
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QNameSet r2, int r3) {
        Xobj r1 = this._firstChild;
    L3:
        if (r1 == null) goto L13;
        if (r1.isElem() == false) goto L12;
        if (r2.contains(r1._name) == false) goto L12;
        r3 = r3 - 1;
        if (r3 >= 0) goto L12;
        return r1.getUser();
    L12:
        r1 = r1._nextSibling;
        goto L3
    L13:
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean find_nil() {
        boolean r1 = false;
        if (isAttr() == false) goto L5;
        return false;
    L5:
        this._locale.enter();
        Xobj r0 = getAttr(Locale._xsiNil);     // Catch: Throwable -> L16
        if (r0 != null) goto L11;
    L8:
        this._locale.exit();
        return r1;
    L11:
        String r2 = r0.getValueAsString(3);     // Catch: Throwable -> L16
        if (r2.equals("true") == true) goto L15;
        if (r2.equals("1") == false) goto L8;
    L15:
        r1 = true;
    L16:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.values.NamespaceManager
    public String find_prefix_for_nsuri(String r2, String r3) {
        this._locale.enter();
        String r4 = prefixForNamespace(r2, r3, true);     // Catch: Throwable -> L6
        this._locale.exit();
        return r4;
    L6:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    final Xobj firstAttr() {
        Xobj r0 = this._firstChild;
        if (r0 != null) goto L5;
    L8:
        return null;
    L5:
        if (r0.isAttr() == false) goto L8;
        return this._firstChild;
    }

    final Xobj getAttr(QName r2) {
        Xobj r1 = this._firstChild;
    L3:
        if (r1 == null) goto L10;
        if (r1.isAttr() == false) goto L15;
        if (r1._name.equals(r2) == true) goto L8;
        r1 = r1._nextSibling;
        goto L3
    L8:
        return r1;
    L15:
        return null;
    L10:
        return null;
    }

    Object getChars(int r2, int r3) {
        int r0 = cchRight(r2);
        if (r3 < 0) goto L5;
        if (r3 > r0) goto L5;
    L6:
        if (r3 != 0) goto L10;
        this._locale._offSrc = 0;
        this._locale._cchSrc = 0;
        return null;
    L10:
        return getCharsHelper(r2, r3);
    L5:
        r3 = r0;
        goto L6
    }

    Object getChars(int r1, int r2, Cur r3) {
        Object r4 = getChars(r1, r2);
        r3._offSrc = this._locale._offSrc;
        r3._cchSrc = this._locale._cchSrc;
        return r4;
    }

    String getCharsAfterAsString(int r2, int r3) {
        int r4 = (r2 + this._cchValue) + 2;
        if (r4 != posMax()) goto L6;
        r4 = -1;
    L6:
        return getCharsAsString(r4, r3, 1);
    }

    String getCharsAsString(int r2, int r3, int r4) {
        if (cchRight(r2) != 0) goto L6;
        return "";
    L6:
        Object r5 = getChars(r2, r3);
        if (r4 == 1) goto L9;
        Locale.ScrubBuffer r6 = Locale.getScrubBuffer(r4);
        r6.scrub(r5, this._locale._offSrc, this._locale._cchSrc);
        return r6.getResultAsString();
    L9:
        return CharUtil.getString(r5, this._locale._offSrc, this._locale._cchSrc);
    }

    Object getCharsHelper(int r5, int r6) {
        int r0 = posAfter();
        if (r5 < r0) goto L5;
        Object r1 = this._srcAfter;
        this._locale._offSrc = (this._offAfter + r5) - r0;
    L6:
        this._locale._cchSrc = r6;
        return r1;
    L5:
        r1 = this._srcValue;
        this._locale._offSrc = (this._offValue + r5) - 1;
        goto L6
    }

    String getCharsValueAsString(int r2, int r3) {
        return getCharsAsString(r2 + 1, r3, 1);
    }

    final Xobj getDenormal(int r3) {
        if (r3 != 0) goto L9;
        Xobj r4 = this._prevSibling;
        if (r4 != null) goto L6;
        r4 = ensureParent();
        int r0 = r4.posAfter() - 1;
    L7:
        int r1 = r0;
        Xobj r2 = r4;
        r3 = r1;
    L14:
        this._locale._posTemp = r3;
        return r2;
    L6:
        r0 = r4.posMax();
        goto L7
    L9:
        if (r3 != (-1)) goto L13;
        r4 = this._lastChild;
        if (r4 != null) goto L6;
        r3 = posAfter() - 1;
    L13:
        r2 = this;
        goto L14
    }

    abstract DomImpl.Dom getDom();

    public final int getDomZeroOneChildren() {
        if (this._firstChild == null) goto L5;
    L9:
        Xobj r0 = this._lastChild;
        if (r0 != null) goto L12;
    L22:
        Xobj r1 = this._firstChild;
        if (r1 != this._lastChild) goto L35;
        if (r1 == null) goto L35;
        if (r1.isAttr() == true) goto L35;
        if (this._srcValue != null) goto L35;
        if (this._charNodesValue != null) goto L35;
        if (this._firstChild._srcAfter != null) goto L35;
        return 1;
    L35:
        if (this._firstChild == null) goto L37;
    L45:
        Xobj r3 = lastAttr();
        if (r3 != null) goto L48;
        Xobj r2 = null;
    L49:
        if (r3 != null) goto L51;
        return 2;
    L51:
        if (r3._srcAfter != null) goto L60;
        if (r2 != null) goto L54;
        return 2;
    L54:
        if (r2._srcAfter == null) goto L56;
        return 2;
    L56:
        if (r2._nextSibling != null) goto L63;
        return 1;
    L63:
        return 2;
    L60:
        return 2;
    L48:
        r2 = r3._nextSibling;
        goto L49
    L37:
        if (this._srcValue == null) goto L45;
        CharNode r4 = this._charNodesValue;
        if (r4 != null) goto L41;
    L44:
        return 1;
    L41:
        if (r4._next != null) goto L45;
        if (this._charNodesValue._cch != this._cchValue) goto L45;
    L12:
        if (r0.isAttr() == false) goto L22;
        Xobj r5 = this._lastChild;
        if (r5._charNodesAfter != null) goto L22;
        if (r5._srcAfter != null) goto L22;
        if (this._srcValue != null) goto L22;
        if (this._charNodesValue != null) goto L22;
        return 0;
    L5:
        if (this._srcValue != null) goto L9;
        if (this._charNodesValue != null) goto L9;
        return 0;
    }

    final Cur getEmbedded() {
        this._locale.embedCurs();
        return this._embedded;
    }

    Object getFirstChars() {
        ensureOccupancy();
        if (this._cchValue > 0) goto L5;
        Xobj r0 = lastAttr();
        if (r0 != null) goto L9;
    L13:
        this._locale._offSrc = 0;
        this._locale._cchSrc = 0;
        return null;
    L9:
        if (r0._cchAfter <= 0) goto L13;
        return r0.getChars(r0.posAfter(), -1);
    L5:
        return getChars(1, -1);
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String r2) {
        return namespaceForPrefix(r2, true);
    }

    final Xobj getNormal(int r4) {
        if (r4 != posMax()) goto L9;
        Xobj r5 = this._nextSibling;
        if (r5 == null) goto L7;
        Xobj r0 = r5;
        r4 = 0;
    L13:
        this._locale._posTemp = r4;
        return r0;
    L7:
        r0 = ensureParent();
    L11:
        r4 = -1;
        goto L13
    L9:
        if (r4 != (posAfter() - 1)) goto L12;
        r0 = this;
        goto L11
    L12:
        r0 = this;
        goto L13
    }

    public final QName getQName() {
        return this._name;
    }

    final TypeStoreUser getUser() {
        if (this._user != null) goto L14;
        Xobj r0 = this._parent;
        if (r0 != null) goto L7;
        TypeStoreUser r1 = ((TypeStoreUserFactory) ZeusTransformUtils.preCheckCast(XmlBeans.NO_TYPE, TypeStoreUserFactory.class, "com.obric.memorydata.plugin")).createTypeStoreUser();
    L9:
        if (isElem() == false) goto L11;
        TypeStoreUser r2 = r1.create_element_user(this._name, getXsiTypeName());
    L12:
        this._user = r2;
        r2.attach_store(this);
        goto L14
    L11:
        r2 = r1.create_attribute_user(this._name);
        goto L12
    L7:
        r1 = r0.getUser();
    L14:
        return this._user;
    }

    final QName getValueAsQName() {
        String r0 = getValueAsString(3);
        int r1 = r0.indexOf(58);
        if (r1 < 0) goto L5;
        String r3 = r0.substring(0, r1);
        r0 = r0.substring(r1 + 1);
    L6:
        String r4 = namespaceForPrefix(r3, true);
        if (r4 != null) goto L11;
        return null;
    L11:
        return new QName(r4, r0);
    L5:
        r3 = "";
        goto L6
    }

    String getValueAsString() {
        return getValueAsString(1);
    }

    String getValueAsString(int r4) {
        if (hasChildren() == true) goto L15;
        Object r0 = getFirstChars();
        if (r4 != 1) goto L13;
        String r5 = CharUtil.getString(r0, this._locale._offSrc, this._locale._cchSrc);
        if (r5.length() <= 0) goto L12;
        Xobj r1 = lastAttr();
        if (r1 == null) goto L11;
        r1._srcAfter = r5;
        r1._offAfter = 0;
        goto L12
    L11:
        this._srcValue = r5;
        this._offValue = 0;
    L12:
        return r5;
    L13:
        Locale.ScrubBuffer r6 = Locale.getScrubBuffer(r4);
        r6.scrub(r0, this._locale._offSrc, this._locale._cchSrc);
        return r6.getResultAsString();
    L15:
        Locale.ScrubBuffer r7 = Locale.getScrubBuffer(r4);
        Cur r3 = tempCur();
        r3.push();
    L16:
        r3.next();
    L18:
        if (r3.isAtEndOfLastPush() == true) goto L27;
        if (r3.isText() == false) goto L23;
        r7.scrub(r3.getChars(-1), r3._offSrc, r3._cchSrc);
    L23:
        if (r3.isComment() == true) goto L26;
        if (r3.isProcinst() == false) goto L16;
    L26:
        r3.skip();
        goto L18
    L27:
        String r8 = r7.getResultAsString();
        r3.release();
        return r8;
    }

    final String getXmlnsPrefix() {
        return Locale.xmlnsPrefix(this._name);
    }

    final String getXmlnsUri() {
        return getValueAsString();
    }

    final QName getXsiTypeName() {
        Xobj r1 = getAttr(Locale._xsiType);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getValueAsQName();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlLocale get_locale() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaField get_schema_field() {
        if (isRoot() == false) goto L5;
        return null;
    L5:
        TypeStoreUser r0 = ensureParent().getUser();
        if (isAttr() == true) goto L8;
        TypeStoreVisitor r1 = r0.new_visitor();
        if (r1 != null) goto L12;
        return null;
    L12:
        Xobj r2 = this._parent._firstChild;
    L14:
        if (r2.isElem() == false) goto L19;
        r1.visit(r2._name);
        if (r2 != this) goto L19;
        return r1.get_schema_field();
    L19:
        r2 = r2._nextSibling;
        goto L14
    L8:
        return r0.get_attribute_field(this._name);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaTypeLoader get_schematypeloader() {
        return this._locale._schemaTypeLoader;
    }

    final boolean hasAttrs() {
        Xobj r0 = this._firstChild;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isAttr() == false) goto L7;
        return true;
    }

    final boolean hasBookmark(Object r2, int r3) {
        Bookmark r1 = this._bookmarks;
    L3:
        if (r1 == null) goto L11;
        if (r1._pos != r3) goto L10;
        if (r2 != r1._key) goto L10;
        return true;
    L10:
        r1 = r1._next;
        goto L3
    L11:
        return false;
    }

    final boolean hasChildren() {
        Xobj r0 = this._lastChild;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isAttr() == true) goto L7;
        return true;
    }

    final boolean hasTextEnsureOccupancy() {
        ensureOccupancy();
        return hasTextNoEnsureOccupancy();
    }

    final boolean hasTextNoEnsureOccupancy() {
        if (this._cchValue <= 0) goto L5;
        return true;
    L5:
        Xobj r2 = lastAttr();
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2._cchAfter <= 0) goto L10;
        return true;
    }

    final boolean inChars(int r3, Xobj r4, int r5, int r6, boolean r7) {
        if (r7 == true) goto L5;
        int r8 = 0;
    L10:
        if (r4 != this) goto L16;
        if (r5 < r3) goto L16;
        if (r5 >= ((r3 + r6) + r8)) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r4.isRoot() == false) goto L8;
        if (r5 != 0) goto L8;
        return false;
    L8:
        r4 = r4.getDenormal(r5);
        r5 = r4.posTemp();
        r8 = 1;
        goto L10
    }

    final boolean inhibitDisconnect() {
        return bitIsSet(1024);
    }

    final void insertCharsHelper(int r11, Object r12, int r13, int r14, boolean r15) {
        int r2 = posAfter();
        if (r11 >= r2) goto L5;
        int r4 = 1;
    L7:
        if ((r11 - r4) >= (this._cchValue + this._cchAfter)) goto L20;
        Cur r5 = getEmbedded();
    L9:
        if (r5 == null) goto L14;
        if (r5._pos < r11) goto L13;
        r5._pos += r14;
    L13:
        r5 = r5._next;
        goto L9
    L14:
        Bookmark r6 = this._bookmarks;
    L15:
        if (r6 == null) goto L20;
        if (r6._pos < r11) goto L19;
        r6._pos += r14;
    L19:
        r6 = r6._next;
    L20:
        CharUtil r9 = this._locale.getCharUtil();
        if (r11 >= r2) goto L25;
        this._srcValue = r9.insertChars(r11 - 1, this._srcValue, this._offValue, this._cchValue, r12, r13, r14);
        this._offValue = r9._offSrc;
        this._cchValue = r9._cchSrc;
        if (r15 == false) goto L37;
        invalidateUser();
        invalidateSpecialAttr(null);
        return;
    L37:
        return;
    L25:
        this._srcAfter = r9.insertChars(r11 - r2, this._srcAfter, this._offAfter, this._cchAfter, r12, r13, r14);
        this._offAfter = r9._offSrc;
        this._cchAfter = r9._cchSrc;
        if (r15 == false) goto L39;
        Xobj r0 = this._parent;
        if (r0 == null) goto L40;
        r0.invalidateUser();
        return;
    L40:
        return;
    L39:
        return;
    L5:
        r4 = 2;
        goto L7
    }

    final void insertXobj(Xobj r2) {
        ensureParent();
        r2._parent = this._parent;
        r2._prevSibling = this._prevSibling;
        r2._nextSibling = this;
        Xobj r0 = this._prevSibling;
        if (r0 == null) goto L5;
        r0._nextSibling = r2;
    L6:
        this._prevSibling = r2;
        return;
    L5:
        this._parent._firstChild = r2;
        goto L6
    }

    final void insertXobjs(Xobj r2, Xobj r3) {
        r2._prevSibling = this._prevSibling;
        r3._nextSibling = this;
        Xobj r0 = this._prevSibling;
        if (r0 == null) goto L5;
        r0._nextSibling = r2;
    L6:
        this._prevSibling = r3;
    L7:
        if (r2 == this) goto L9;
        r2._parent = this._parent;
        r2 = r2._nextSibling;
        goto L7
    L9:
        return;
    L5:
        this._parent._firstChild = r2;
        goto L6
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QName r3, int r4) {
        if (r4 < 0) goto L18;
        if (isContainer() == false) goto L16;
        Xobj r0 = this._locale.findNthChildElem(this, r3, null, r4);
        if (r0 != null) goto L14;
        if (r4 > (this._locale.count(this, r3, null) + 1)) goto L12;
        return add_element_user(r3);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        return insertElement(r3, r0, 0);
    L16:
        throw new IllegalStateException();
    L18:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QNameSet r3, QName r4, int r5) {
        if (r5 < 0) goto L18;
        if (isContainer() == false) goto L16;
        Xobj r0 = this._locale.findNthChildElem(this, null, r3, r5);
        if (r0 != null) goto L14;
        if (r5 > (this._locale.count(this, null, r3) + 1)) goto L12;
        return add_element_user(r4);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        return insertElement(r4, r0, 0);
    L16:
        throw new IllegalStateException();
    L18:
        throw new IndexOutOfBoundsException();
    }

    void invalidateNil() {
        TypeStoreUser r0 = this._user;
        if (r0 == null) goto L6;
        r0.invalidate_nilvalue();
        return;
    }

    final void invalidateSpecialAttr(Xobj r3) {
        if (isAttr() == true) goto L5;
        return;
    L5:
        if (this._name.equals(Locale._xsiType) == false) goto L12;
        Xobj r0 = this._parent;
        if (r0 == null) goto L9;
        r0.disconnectNonRootUsers();
    L9:
        if (r3 == null) goto L12;
        r3.disconnectNonRootUsers();
    L12:
        if (this._name.equals(Locale._xsiNil) == false) goto L20;
        Xobj r2 = this._parent;
        if (r2 == null) goto L16;
        r2.invalidateNil();
    L16:
        if (r3 == null) goto L21;
        r3.invalidateNil();
        return;
    L21:
        return;
    }

    final void invalidateUser() {
        TypeStoreUser r0 = this._user;
        if (r0 == null) goto L6;
        r0.invalidate_value();
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_nil() {
        if (isAttr() == false) goto L5;
        return;
    L5:
        this._locale.enter();
    L12:
        th = move-exception;
        this._locale.exit();
        throw th;
    L7:
        if (this._user.build_nil() == true) goto L9;
        removeAttr(Locale._xsiNil);     // Catch: Throwable -> L12
    L10:
        this._locale.exit();
        return;
    L9:
        setAttr(Locale._xsiNil, "true");     // Catch: Throwable -> L12
        goto L10
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_text() {
        this._locale.enter();
    L13:
        th = move-exception;
        this._locale.exit();
        throw th;
    L4:
        if (isOccupied() == true) goto L6;
    L11:
        this._locale.exit();
        return;
    L6:
        if (hasTextNoEnsureOccupancy() == false) goto L8;
    L9:
        TypeStoreUser r0 = this._user;     // Catch: Throwable -> L13
        this._user = null;     // Catch: Throwable -> L13
        Cur r2 = tempCur();     // Catch: Throwable -> L13
        r2.moveNodeContents(null, false);     // Catch: Throwable -> L13
        r2.release();     // Catch: Throwable -> L13
        this._user = r0;     // Catch: Throwable -> L13
    L10:
        setBit(256);     // Catch: Throwable -> L13
        goto L11
    L8:
        if (hasChildren() == false) goto L10;
        goto L9
    }

    final boolean isAttr() {
        if (kind() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCharNodesAfterUsable() {
        if (this._srcAfter != null) goto L5;
        return false;
    L5:
        CharNode r0 = this._charNodesAfter;
        if (r0 != null) goto L8;
    L12:
        CharNode r1 = Cur.updateCharNodes(this._locale, this, this._charNodesAfter, this._cchAfter);
        this._charNodesAfter = r1;
        if (r1 != null) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (r0._next != null) goto L12;
        if (this._charNodesAfter._cch != this._cchAfter) goto L12;
        return true;
    }

    public final boolean isCharNodesValueUsable() {
        if (isExistingCharNodesValueUsable() == true) goto L8;
        CharNode r0 = Cur.updateCharNodes(this._locale, this, this._charNodesValue, this._cchValue);
        this._charNodesValue = r0;
        if (r0 != null) goto L8;
        return false;
    L8:
        return true;
    }

    final boolean isComment() {
        if (kind() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean isContainer() {
        return Cur.kindIsContainer(kind());
    }

    final boolean isElem() {
        if (kind() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isExistingCharNodesValueUsable() {
        if (this._srcValue != null) goto L5;
        return false;
    L5:
        CharNode r0 = this._charNodesValue;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0._next == null) goto L10;
        return false;
    L10:
        if (this._charNodesValue._cch != this._cchValue) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean isFirstChildPtrDomUsable() {
        Xobj r0 = this._firstChild;
        if (r0 == null) goto L5;
    L9:
        if (r0 != null) goto L11;
        return false;
    L11:
        if (r0.isAttr() == false) goto L13;
        return false;
    L13:
        if (this._srcValue == null) goto L15;
        return false;
    L15:
        if (this._charNodesValue != null) goto L21;
        return true;
    L21:
        return false;
    L5:
        if (this._srcValue != null) goto L9;
        if (this._charNodesValue != null) goto L9;
        return true;
    }

    final boolean isInSameTree(Xobj r5) {
        if (this._locale == r5._locale) goto L5;
        return false;
    L5:
        Xobj r0 = this;
    L7:
        if (r0 == r5) goto L8;
        Xobj r3 = r0._parent;
        if (r3 == null) goto L11;
        r0 = r3;
    L11:
        if (r5 == this) goto L12;
        Xobj r4 = r5._parent;
        if (r4 == null) goto L15;
        r5 = r4;
        goto L11
    L15:
        if (r5 == r0) goto L17;
        return false;
    L17:
        return true;
    L12:
        return true;
    L8:
        return true;
    }

    final boolean isJustAfterEnd(Xobj r3, int r4) {
        if (r3.isRoot() == false) goto L7;
        if (r4 != 0) goto L7;
        return false;
    L7:
        if (r3 != this) goto L12;
        if (r4 == posAfter()) goto L17;
        return false;
    L17:
        return true;
    L12:
        if (r3.getDenormal(r4) == this) goto L14;
        return false;
    L14:
        if (r3.posTemp() == posAfter()) goto L17;
        return false;
    }

    public final boolean isNextSiblingPtrDomUsable() {
        if (this._charNodesAfter == null) goto L5;
        return false;
    L5:
        if (this._srcAfter != null) goto L10;
        return true;
    L10:
        return false;
    }

    final boolean isNormal(int r4) {
        if (isValid() == true) goto L6;
        return false;
    L6:
        if (r4 == (-1)) goto L32;
        if (r4 == 0) goto L32;
        if (r4 >= 0) goto L11;
        return false;
    L11:
        if (r4 < posMax()) goto L14;
        return false;
    L14:
        if (r4 < posAfter()) goto L29;
        if (isRoot() == false) goto L18;
        return false;
    L18:
        Xobj r0 = this._nextSibling;
        if (r0 != null) goto L21;
    L23:
        Xobj r1 = this._parent;
        if (r1 != null) goto L26;
    L27:
        return false;
    L26:
        if (r1.isContainer() == true) goto L29;
    L21:
        if (r0.isAttr() == false) goto L23;
        return false;
    L29:
        if (r4 != (posAfter() - 1)) goto L31;
        return false;
    L31:
        return true;
    L32:
        return true;
    }

    final boolean isNormalAttr() {
        if (isAttr() == true) goto L5;
    L7:
        return false;
    L5:
        if (Locale.isXmlns(this._name) == true) goto L7;
        return true;
    }

    final boolean isOccupied() {
        return bitIsClear(256);
    }

    final boolean isProcinst() {
        if (kind() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean isRoot() {
        if (kind() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    final boolean isStableUser() {
        return bitIsSet(512);
    }

    final boolean isUserNode() {
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

    final boolean isVacant() {
        return bitIsSet(256);
    }

    final boolean isValid() {
        if (isVacant() == true) goto L5;
    L10:
        return true;
    L5:
        if (this._cchValue == 0) goto L7;
    L9:
        return false;
    L7:
        if (this._user == null) goto L9;
        goto L9
    }

    final boolean isXmlns() {
        if (isAttr() == true) goto L5;
    L7:
        return false;
    L5:
        if (Locale.isXmlns(this._name) == false) goto L7;
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean is_attribute() {
        return isAttr();
    }

    final int kind() {
        return this._bits & 15;
    }

    final Xobj lastAttr() {
        Xobj r0 = this._firstChild;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isAttr() == false) goto L18;
        Xobj r1 = this._firstChild;
    L8:
        Xobj r2 = r1._nextSibling;
        if (r2 == null) goto L13;
        if (r2.isAttr() == false) goto L13;
        r1 = r1._nextSibling;
    L13:
        return r1;
    L18:
        return null;
    }

    public final Locale locale() {
        return this._locale;
    }

    final String namespaceForPrefix(String r4, boolean r5) {
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        if (r4.equals("xml") == false) goto L10;
        return "http://www.w3.org/XML/1998/namespace";
    L10:
        if (r4.equals("xmlns") == false) goto L13;
        return "http://www.w3.org/2000/xmlns/";
    L13:
        if (this == null) goto L26;
        Xobj r1 = this._firstChild;
    L15:
        if (r1 == null) goto L25;
        if (r1.isAttr() == false) goto L25;
        if (r1.isXmlns() == false) goto L24;
        if (r1.getXmlnsPrefix().equals(r4) == false) goto L24;
        return r1.getXmlnsUri();
    L24:
        r1 = r1._nextSibling;
    L25:
        Xobj this = this._parent;
        goto L13
    L26:
        if (r5 == true) goto L28;
    L30:
        return null;
    L28:
        if (r4.length() != 0) goto L30;
        return "";
    }

    abstract Xobj newNode(Locale r1);

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlCursor new_cursor() {
        this._locale.enter();
        Cur r0 = tempCur();     // Catch: Throwable -> L6
        Cursor r1 = new Cursor(r0);     // Catch: Throwable -> L6
        r0.release();     // Catch: Throwable -> L6
        this._locale.exit();
        return r1;
    L6:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    final Xobj nextAttr() {
        Xobj r0 = this._firstChild;
        if (r0 != null) goto L5;
    L8:
        Xobj r1 = this._nextSibling;
        if (r1 != null) goto L11;
        return null;
    L11:
        if (r1.isAttr() == true) goto L13;
        return null;
    L13:
        return this._nextSibling;
    L5:
        if (r0.isAttr() == false) goto L8;
        return this._firstChild;
    }

    public final int nodeType() {
        return domType();
    }

    final int posAfter() {
        return this._cchValue + 2;
    }

    final int posMax() {
        return (this._cchValue + 2) + this._cchAfter;
    }

    final int posTemp() {
        return this._locale._posTemp;
    }

    final String prefixForNamespace(String r7, String r8, boolean r9) {
        if (r7 != null) goto L6;
        r7 = "";
    L6:
        if (r7.equals("http://www.w3.org/XML/1998/namespace") == false) goto L9;
        return "xml";
    L9:
        if (r7.equals("http://www.w3.org/2000/xmlns/") == false) goto L12;
        return "xmlns";
    L12:
        Xobj r1 = this;
    L14:
        if (r1.isContainer() == true) goto L17;
        r1 = r1.ensureParent();
        goto L14
    L17:
        if (r7.length() != 0) goto L27;
        Xobj r10 = r1.findXmlnsForPrefix("");
        if (r10 != null) goto L21;
    L26:
        return "";
    L21:
        if (r10.getXmlnsUri().length() == 0) goto L26;
        if (r9 == true) goto L25;
        return null;
    L25:
        r1.setAttr(this._locale.createXmlns(null), "");
        goto L26
    L27:
        Xobj r0 = r1;
    L28:
        if (r0 == null) goto L41;
        Xobj r3 = r0.firstAttr();
    L30:
        if (r3 == null) goto L40;
        if (r3.isXmlns() == false) goto L39;
        if (r3.getXmlnsUri().equals(r7) == false) goto L39;
        if (r1.findXmlnsForPrefix(r3.getXmlnsPrefix()) != r3) goto L39;
        return r3.getXmlnsPrefix();
    L39:
        r3 = r3.nextAttr();
        goto L30
    L40:
        r0 = r0._parent;
        goto L28
    L41:
        if (r9 == true) goto L43;
        return null;
    L43:
        if (r8 != null) goto L45;
    L51:
        if (r8 != null) goto L57;
        String r11 = QNameHelper.suggestPrefix(r7);
        int r2 = 1;
        r8 = r11;
    L54:
        if (r1.findXmlnsForPrefix(r8) == null) goto L57;
        r8 = r11 + r2;
        r2 = r2 + 1;
    L57:
        Xobj r12 = r1;
    L59:
        if (r12.isRoot() == true) goto L63;
        if (r12.ensureParent().isRoot() == true) goto L63;
        r12 = r12._parent;
    L63:
        r1.setAttr(this._locale.createXmlns(r8), r7);
        return r8;
    L45:
        if (r8.length() != 0) goto L47;
    L50:
        r8 = null;
        goto L51
    L47:
        if (r8.toLowerCase(java.util.Locale.ROOT).startsWith("xml") == true) goto L50;
        if (r1.findXmlnsForPrefix(r8) == null) goto L51;
        goto L50
    }

    final boolean removeAttr(QName r3) {
        Xobj r0 = getAttr(r3);
        if (r0 != null) goto L6;
        return false;
    L6:
        Cur r1 = r0.tempCur();
    L7:
        r1.moveNode(null);
        Xobj r2 = getAttr(r3);
        if (r2 == null) goto L9;
        r1.moveTo(r2);
        goto L7
    L9:
        r1.release();
        return true;
    }

    final void removeCharsHelper(int r7, int r8, Xobj r9, int r10, boolean r11, boolean r12) {
        Cur r0 = getEmbedded();
    L3:
        if (r0 == null) goto L18;
        Cur r1 = r0._next;
        if (r0._pos < r7) goto L13;
        if (r0._pos >= (r7 + r8)) goto L13;
        int r2 = r0._pos;
        if (r11 == false) goto L11;
        r0.moveToNoCheck(r9, (r2 + r10) - r7);
        goto L13
    L11:
        r0.nextChars((r8 - r2) + r7);
    L13:
        if (r0._xobj != this) goto L17;
        if (r0._pos < (r7 + r8)) goto L17;
        r0._pos -= r8;
    L17:
        r0 = r1;
        goto L3
    L18:
        Bookmark r13 = this._bookmarks;
    L19:
        if (r13 == null) goto L31;
        if (r13._pos < r7) goto L26;
        if (r13._pos >= (r7 + r8)) goto L26;
        r13.moveTo(r9, (r13._pos + r10) - r7);
    L26:
        if (r13._xobj != this) goto L30;
        if (r13._pos < (r7 + r8)) goto L30;
        r13._pos -= r8;
    L30:
        r13 = r13._next;
        goto L19
    L31:
        int r14 = posAfter();
        CharUtil r15 = this._locale.getCharUtil();
        if (r7 >= r14) goto L36;
        this._srcValue = r15.removeChars(r7 - 1, r8, this._srcValue, this._offValue, this._cchValue);
        this._offValue = r15._offSrc;
        this._cchValue = r15._cchSrc;
        if (r12 == false) goto L50;
        invalidateUser();
        invalidateSpecialAttr(null);
        return;
    L50:
        return;
    L36:
        this._srcAfter = r15.removeChars(r7 - r14, r8, this._srcAfter, this._offAfter, this._cchAfter);
        this._offAfter = r15._offSrc;
        this._cchAfter = r15._cchSrc;
        if (r12 == false) goto L52;
        Xobj r6 = this._parent;
        if (r6 == null) goto L53;
        r6.invalidateUser();
        return;
    L53:
        return;
    }

    final void removeXobj() {
        Xobj r0 = this._parent;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0._firstChild != this) goto L8;
        r0._firstChild = this._nextSibling;
    L8:
        if (r0._lastChild != this) goto L10;
        r0._lastChild = this._prevSibling;
    L10:
        Xobj r1 = this._prevSibling;
        if (r1 == null) goto L13;
        r1._nextSibling = this._nextSibling;
    L13:
        Xobj r2 = this._nextSibling;
        if (r2 == null) goto L16;
        r2._prevSibling = r1;
    L16:
        this._parent = null;
        this._prevSibling = null;
        this._nextSibling = null;
    }

    final void removeXobjs(Xobj r2, Xobj r3) {
        if (this._firstChild != r2) goto L6;
        this._firstChild = r3._nextSibling;
    L6:
        if (this._lastChild != r3) goto L8;
        this._lastChild = r2._prevSibling;
    L8:
        Xobj r1 = r2._prevSibling;
        if (r1 == null) goto L11;
        r1._nextSibling = r3._nextSibling;
    L11:
        Xobj r0 = r3._nextSibling;
        if (r0 == null) goto L14;
        r0._prevSibling = r1;
    L14:
        r2._prevSibling = null;
        r3._nextSibling = null;
    L15:
        if (r2 == null) goto L17;
        r2._parent = null;
        r2 = r2._nextSibling;
        goto L15
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_attribute(QName r2) {
        this._locale.enter();
    L9:
        th = move-exception;
        this._locale.exit();
        throw th;
    L4:
        if (removeAttr(r2) == false) goto L8;
        this._locale.exit();
        return;
    L8:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L9
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QName r2, int r3) {
        if (r3 < 0) goto L20;
        if (isContainer() == false) goto L18;
        Xobj r1 = this._firstChild;
    L6:
        if (r1 == null) goto L15;
        if (r1.isElem() == false) goto L14;
        if (r1._name.equals(r2) == false) goto L14;
        r3 = r3 - 1;
        if (r3 < 0) goto L15;
    L14:
        r1 = r1._nextSibling;
    L15:
        removeElement(r1);
        return;
    L18:
        throw new IllegalStateException();
    L20:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QNameSet r2, int r3) {
        if (r3 < 0) goto L20;
        if (isContainer() == false) goto L18;
        Xobj r1 = this._firstChild;
    L6:
        if (r1 == null) goto L15;
        if (r1.isElem() == false) goto L14;
        if (r2.contains(r1._name) == false) goto L14;
        r3 = r3 - 1;
        if (r3 < 0) goto L15;
    L14:
        r1 = r1._nextSibling;
    L15:
        removeElement(r1);
        return;
    L18:
        throw new IllegalStateException();
    L20:
        throw new IndexOutOfBoundsException();
    }

    final Xobj setAttr(QName r2, String r3) {
        Cur r1 = tempCur();
        if (r1.toAttr(r2) == false) goto L5;
        r1.removeFollowingAttrs();
    L6:
        r1.setValue(r3);
        Xobj r4 = r1._xobj;
        r1.release();
        return r4;
    L5:
        r1.next();
        r1.createAttr(r2);
        goto L6
    }

    final void setBit(int r2) {
        this._bits = r2 | this._bits;
    }

    final Bookmark setBookmark(int r4, Object r5, Object r6) {
        Bookmark r0 = this._bookmarks;
    L4:
        if (r0 == null) goto L15;
        if (r4 != r0._pos) goto L14;
        if (r5 != r0._key) goto L14;
        if (r6 != null) goto L12;
        this._bookmarks = r0.listRemove(this._bookmarks);
        return null;
    L12:
        r0._value = r6;
        return r0;
    L14:
        r0 = r0._next;
        goto L4
    L15:
        if (r6 != null) goto L17;
        return null;
    L17:
        Bookmark r1 = new Bookmark();
        r1._xobj = this;
        r1._pos = r4;
        r1._key = r5;
        r1._value = r6;
        this._bookmarks = r1.listInsert(this._bookmarks);
        return r1;
    }

    final void setName(QName r5) {
        if (this._name.equals(r5) == true) goto L5;
    L6:
        this._locale.notifyChange();
        QName r0 = this._name;
        this._name = r5;
        if (ZeusTransformUtils.instanceOf(this, NamedNodeXobj.class) == false) goto L10;
        ((NamedNodeXobj) ZeusTransformUtils.preCheckCast(this, NamedNodeXobj.class, "com.obric.memorydata.plugin"))._canHavePrefixUri = true;
    L10:
        if (isProcinst() == false) goto L12;
    L29:
        this._locale._versionAll++;
        this._locale._versionSansText++;
        return;
    L12:
        if (isAttr() == true) goto L14;
    L27:
        Xobj r1 = this;
    L28:
        r1.disconnectNonRootUsers();
        goto L29
    L14:
        if (this._parent == null) goto L27;
        if (r0.equals(Locale._xsiType) == false) goto L18;
    L21:
        r1 = this._parent;
    L23:
        if (r0.equals(Locale._xsiNil) == false) goto L25;
    L26:
        this._parent.invalidateNil();
        goto L28
    L25:
        if (r5.equals(Locale._xsiNil) == false) goto L28;
    L18:
        if (r5.equals(Locale._xsiType) == true) goto L21;
        r1 = this;
        goto L23
    L5:
        if (this._name.getPrefix().equals(r5.getPrefix()) == false) goto L6;
    }

    void setStableType(SchemaType r3) {
        setStableUser(((TypeStoreUserFactory) ZeusTransformUtils.preCheckCast((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), TypeStoreUserFactory.class, "com.obric.memorydata.plugin")).createTypeStoreUser());
    }

    void setStableUser(TypeStoreUser r3) {
        TypeStoreUser r4 = (TypeStoreUser) ZeusTransformUtils.wrapperContextForParams(r3, TypeStoreUser.class, "com.obric.memorydata.plugin");
        disconnectNonRootUsers();
        disconnectUser();
        this._user = r4;
        r4.attach_store(this);
        setBit(512);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void store_text(String r5) {
        this._locale.enter();
        TypeStoreUser r0 = this._user;
        this._user = null;
        Cur r2 = tempCur();     // Catch: Throwable -> L11
        r2.moveNodeContents(null, false);     // Catch: Throwable -> L11
        if (r5 != null) goto L6;
    L8:
        r2.release();     // Catch: Throwable -> L11
        this._user = r0;
        this._locale.exit();
        return;
    L6:
        if (r5.length() <= 0) goto L8;
        r2.next();     // Catch: Throwable -> L11
        r2.insertString(r5);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this._user = r0;
        this._locale.exit();
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser substitute(QName r3, SchemaType r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        this._locale.enter();
        Cur r0 = tempCur();     // Catch: Throwable -> L6
        r0.setSubstitution(r3, r5);     // Catch: Throwable -> L6
        r0.release();     // Catch: Throwable -> L6
        this._locale.exit();
        return getUser();
    L6:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    public final Cur tempCur() {
        Cur r0 = this._locale.tempCur();
        r0.moveTo(this);
        return r0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void validate(ValidatorListener r3) {
        ValidatorListener r4 = (ValidatorListener) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.class, "com.obric.memorydata.plugin");
        this._locale.enter();
        Cur r0 = tempCur();     // Catch: Throwable -> L6
        new Validate(r0, r4);     // Catch: Throwable -> L6
        r0.release();     // Catch: Throwable -> L6
        this._locale.exit();
        return;
    L6:
        th = move-exception;
        this._locale.exit();
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean validate_on_set() {
        return this._locale._validateOnSet;
    }

    final Xobj walk(Xobj r2, boolean r3) {
        Xobj r0 = this._firstChild;
        if (r0 == null) goto L6;
        if (r3 == false) goto L6;
        return r0;
    L6:
        if (this == r2) goto L11;
        Xobj r4 = this._nextSibling;
        if (r4 != null) goto L9;
        Xobj this = this._parent;
        goto L6
    L9:
        return r4;
    L11:
        return null;
    }
}
