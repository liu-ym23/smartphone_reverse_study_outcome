package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: loaded from: classes7.dex */
abstract class CharNode implements DomImpl.Dom, CharacterData, Node {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int _cch;
    private Locale _locale;
    CharNode _next;
    int _off;
    CharNode _prev;
    private Object _src;

    static {
    }

    public CharNode(Locale r1) {
        this._locale = r1;
    }

    public static CharNode appendNode(CharNode r1, CharNode r2) {
        return insertNode(r1, r2, null);
    }

    public static CharNode appendNodes(CharNode r2, CharNode r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        CharNode r0 = r2;
    L5:
        CharNode r1 = r0._next;
        if (r1 == null) goto L8;
        r0 = r1;
        goto L5
    L8:
        r0._next = r3;
        r3._prev = r0;
        return r2;
    }

    public static CharNode insertNode(CharNode r2, CharNode r3, CharNode r4) {
        if (r2 == null) goto L17;
        if (r2 != r4) goto L7;
        r2._prev = r3;
        r3._next = r2;
        goto L17
    L7:
        CharNode r0 = r2;
    L8:
        CharNode r1 = r0._next;
        if (r1 == r4) goto L11;
        r0 = r1;
        goto L8
    L11:
        r3._next = r1;
        if (r1 == null) goto L14;
        r0._next._prev = r3;
    L14:
        r3._prev = r0;
        r0._next = r3;
        return r2;
    L17:
        return r3;
    }

    public static boolean isOnList(CharNode r0, CharNode r1) {
    L2:
        if (r0 == null) goto L7;
        if (r0 == r1) goto L4;
        r0 = r0._next;
        goto L2
    L4:
        return true;
    L7:
        return false;
    }

    private boolean isValid() {
        boolean r0 = ZeusTransformUtils.instanceOf(this._src, DomImpl.Dom.class);
        if (this._locale != null) goto L5;
        boolean r3 = true;
    L6:
        if (r0 != r3) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    public static CharNode remove(CharNode r2, CharNode r3) {
        if (r2 != r3) goto L4;
        r2 = r3._next;
    L5:
        CharNode r0 = r3._next;
        if (r0 == null) goto L8;
        r0._prev = r3._prev;
    L8:
        r3._next = null;
        r3._prev = null;
        return r2;
    L4:
        CharNode r1 = r3._prev;
        r1._next = r3._next;
        goto L5
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node r3) {
        return DomImpl._node_appendChild(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.CharacterData
    public void appendData(String r1) {
        DomImpl._characterData_appendData(this, r1);
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean r1) {
        return DomImpl._node_cloneNode(this, r1);
    }

    @Override // org.w3c.dom.Node
    public short compareDocumentPosition(Node r3) {
        return DomImpl._node_compareDocumentPosition(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.CharacterData
    public void deleteData(int r1, int r2) {
        DomImpl._characterData_deleteData(this, r1, r2);
    }

    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getBaseURI() {
        return DomImpl._node_getBaseURI(this);
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return DomImpl._emptyNodeList;
    }

    @Override // org.w3c.dom.CharacterData
    public String getData() {
        return DomImpl._characterData_getData(this);
    }

    public DomImpl.Dom getDom() {
        if (ZeusTransformUtils.instanceOf(this._src, DomImpl.Dom.class) == true) goto L5;
        return null;
    L5:
        return (DomImpl.Dom) ZeusTransformUtils.preCheckCast(this._src, DomImpl.Dom.class, "com.obric.memorydata.plugin");
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String r1, String r2) {
        return DomImpl._node_getFeature(this, r1, r2);
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return null;
    }

    @Override // org.w3c.dom.CharacterData
    public int getLength() {
        return DomImpl._characterData_getLength(this);
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return DomImpl._node_getLocalName(this);
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return DomImpl._node_getNamespaceURI(this);
    }

    @Override // org.w3c.dom.Node
    public Node getNextSibling() {
        return DomImpl._node_getNextSibling(this);
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return DomImpl._node_getNodeName(this);
    }

    @Override // org.w3c.dom.Node
    public short getNodeType() {
        return DomImpl._node_getNodeType(this);
    }

    @Override // org.w3c.dom.Node
    public String getNodeValue() {
        return DomImpl._node_getNodeValue(this);
    }

    Object getObject() {
        return this._src;
    }

    @Override // org.w3c.dom.Node
    public Document getOwnerDocument() {
        return DomImpl._node_getOwnerDocument(this);
    }

    @Override // org.w3c.dom.Node
    public Node getParentNode() {
        return DomImpl._node_getParentNode(this);
    }

    @Override // org.w3c.dom.Node
    public String getPrefix() {
        return DomImpl._node_getPrefix(this);
    }

    @Override // org.w3c.dom.Node
    public Node getPreviousSibling() {
        return DomImpl._node_getPreviousSibling(this);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public QName getQName() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getTextContent() {
        return DomImpl._node_getTextContent(this);
    }

    @Override // org.w3c.dom.Node
    public Object getUserData(String r1) {
        return DomImpl._node_getUserData(this, r1);
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node r3, Node r4) {
        return DomImpl._node_insertBefore(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"), (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.CharacterData
    public void insertData(int r1, String r2) {
        DomImpl._characterData_insertData(this, r1, r2);
    }

    @Override // org.w3c.dom.Node
    public boolean isDefaultNamespace(String r1) {
        return DomImpl._node_isDefaultNamespace(this, r1);
    }

    @Override // org.w3c.dom.Node
    public boolean isEqualNode(Node r3) {
        return DomImpl._node_isEqualNode(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    public boolean isNodeAftertext() {
        Xobj r0 = (Xobj) ZeusTransformUtils.preCheckCast(this._src, Xobj.class, "com.obric.memorydata.plugin");
        if (r0._charNodesValue != null) goto L6;
        return true;
    L6:
        if (r0._charNodesAfter != null) goto L9;
        return false;
    L9:
        return isOnList(r0._charNodesAfter, this);
    }

    @Override // org.w3c.dom.Node
    public boolean isSameNode(Node r3) {
        return DomImpl._node_isSameNode(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String r1, String r2) {
        return DomImpl._node_isSupported(this, r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Locale locale() {
        Locale r0 = this._locale;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ((DomImpl.Dom) ZeusTransformUtils.preCheckCast(this._src, DomImpl.Dom.class, "com.obric.memorydata.plugin")).locale();
    }

    @Override // org.w3c.dom.Node
    public String lookupNamespaceURI(String r1) {
        return DomImpl._node_lookupNamespaceURI(this, r1);
    }

    @Override // org.w3c.dom.Node
    public String lookupPrefix(String r1) {
        return DomImpl._node_lookupPrefix(this, r1);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public boolean nodeCanHavePrefixUri() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
        DomImpl._node_normalize(this);
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node r3) {
        return DomImpl._node_removeChild(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node r3, Node r4) {
        return DomImpl._node_replaceChild(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"), (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.CharacterData
    public void replaceData(int r1, int r2, String r3) {
        DomImpl._characterData_replaceData(this, r1, r2, r3);
    }

    public void setChars(Object r4, int r5, int r6) {
        if (this._locale != null) goto L5;
        this._locale = ((DomImpl.Dom) ZeusTransformUtils.preCheckCast(this._src, DomImpl.Dom.class, "com.obric.memorydata.plugin")).locale();
    L5:
        this._src = r4;
        this._off = r5;
        this._cch = r6;
    }

    @Override // org.w3c.dom.CharacterData
    public void setData(String r1) {
        DomImpl._characterData_setData(this, r1);
    }

    public void setDom(DomImpl.Dom r3) {
        this._src = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r3, DomImpl.Dom.class, "com.obric.memorydata.plugin");
        this._locale = null;
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String r1) {
        DomImpl._node_setNodeValue(this, r1);
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String r1) {
        DomImpl._node_setPrefix(this, r1);
    }

    @Override // org.w3c.dom.Node
    public void setTextContent(String r1) {
        DomImpl._node_setTextContent(this, r1);
    }

    @Override // org.w3c.dom.Node
    public Object setUserData(String r3, Object r4, UserDataHandler r5) {
        return DomImpl._node_setUserData(this, r3, r4, (UserDataHandler) ZeusTransformUtils.wrapperContextForParams(r5, UserDataHandler.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.CharacterData
    public String substringData(int r1, int r2) {
        return DomImpl._characterData_substringData(this, r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Cur tempCur() {
        if (ZeusTransformUtils.instanceOf(this._src, DomImpl.Dom.class) == true) goto L6;
        return null;
    L6:
        Cur r0 = locale().tempCur();
        r0.moveToCharNode(this);
        return r0;
    }
}
