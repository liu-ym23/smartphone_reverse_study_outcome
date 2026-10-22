package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: loaded from: classes7.dex */
abstract class NodeXobj extends Xobj implements DomImpl.Dom, Node, NodeList {
    NodeXobj(Locale r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node r3) {
        return DomImpl._node_appendChild(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean r1) {
        return DomImpl._node_cloneNode(this, r1);
    }

    @Override // org.w3c.dom.Node
    public short compareDocumentPosition(Node r3) {
        return DomImpl._node_compareDocumentPosition(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getBaseURI() {
        return DomImpl._node_getBaseURI(this);
    }

    public NodeList getChildNodes() {
        return this;
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    DomImpl.Dom getDom() {
        return this;
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String r1, String r2) {
        return DomImpl._node_getFeature(this, r1, r2);
    }

    public Node getFirstChild() {
        return DomImpl._node_getFirstChild(this);
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return DomImpl._node_getLastChild(this);
    }

    public int getLength() {
        return DomImpl._childNodes_getLength(this);
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return DomImpl._node_getLocalName(this);
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return DomImpl._node_getNamespaceURI(this);
    }

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
        return DomImpl._node_hasAttributes(this);
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return DomImpl._node_hasChildNodes(this);
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node r3, Node r4) {
        return DomImpl._node_insertBefore(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"), (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Node
    public boolean isDefaultNamespace(String r1) {
        return DomImpl._node_isDefaultNamespace(this, r1);
    }

    @Override // org.w3c.dom.Node
    public boolean isEqualNode(Node r3) {
        return DomImpl._node_isEqualNode(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Node
    public boolean isSameNode(Node r3) {
        return DomImpl._node_isSameNode(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String r1, String r2) {
        return DomImpl._node_isSupported(this, r1, r2);
    }

    @Override // org.w3c.dom.NodeList
    public Node item(int r1) {
        return DomImpl._childNodes_item(this, r1);
    }

    @Override // org.w3c.dom.Node
    public String lookupNamespaceURI(String r1) {
        return DomImpl._node_lookupNamespaceURI(this, r1);
    }

    @Override // org.w3c.dom.Node
    public String lookupPrefix(String r1) {
        return DomImpl._node_lookupPrefix(this, r1);
    }

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
}
