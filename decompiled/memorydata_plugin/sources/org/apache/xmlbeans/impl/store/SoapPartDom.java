package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: loaded from: classes7.dex */
class SoapPartDom extends SOAPPart implements DomImpl.Dom, Document, NodeList {
    SoapPartDocXobj _docXobj;

    SoapPartDom(SoapPartDocXobj r1) {
        this._docXobj = r1;
    }

    @Override // org.w3c.dom.Document
    public Node adoptNode(Node r2) {
        Node r1 = (Node) ZeusTransformUtils.wrapperContextForParams(r2, Node.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("DOM Level 3 Not implemented");
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

    @Override // org.w3c.dom.Document
    public Attr createAttribute(String r1) {
        return DomImpl._document_createAttribute(this, r1);
    }

    @Override // org.w3c.dom.Document
    public Attr createAttributeNS(String r1, String r2) {
        return DomImpl._document_createAttributeNS(this, r1, r2);
    }

    @Override // org.w3c.dom.Document
    public CDATASection createCDATASection(String r1) {
        return DomImpl._document_createCDATASection(this, r1);
    }

    @Override // org.w3c.dom.Document
    public Comment createComment(String r1) {
        return DomImpl._document_createComment(this, r1);
    }

    @Override // org.w3c.dom.Document
    public DocumentFragment createDocumentFragment() {
        return DomImpl._document_createDocumentFragment(this);
    }

    @Override // org.w3c.dom.Document
    public Element createElement(String r1) {
        return DomImpl._document_createElement(this, r1);
    }

    @Override // org.w3c.dom.Document
    public Element createElementNS(String r1, String r2) {
        return DomImpl._document_createElementNS(this, r1, r2);
    }

    @Override // org.w3c.dom.Document
    public EntityReference createEntityReference(String r1) {
        return DomImpl._document_createEntityReference(this, r1);
    }

    @Override // org.w3c.dom.Document
    public ProcessingInstruction createProcessingInstruction(String r1, String r2) {
        return DomImpl._document_createProcessingInstruction(this, r1, r2);
    }

    @Override // org.w3c.dom.Document
    public Text createTextNode(String r1) {
        return DomImpl._document_createTextNode(this, r1);
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
        return this;
    }

    @Override // org.w3c.dom.Document
    public DocumentType getDoctype() {
        return DomImpl._document_getDoctype(this);
    }

    @Override // org.w3c.dom.Document
    public Element getDocumentElement() {
        return DomImpl._document_getDocumentElement(this);
    }

    @Override // org.w3c.dom.Document
    public String getDocumentURI() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public DOMConfiguration getDomConfig() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public Element getElementById(String r1) {
        return DomImpl._document_getElementById(this, r1);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagName(String r1) {
        return DomImpl._document_getElementsByTagName(this, r1);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagNameNS(String r1, String r2) {
        return DomImpl._document_getElementsByTagNameNS(this, r1, r2);
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String r1, String r2) {
        return DomImpl._node_getFeature(this, r1, r2);
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return DomImpl._node_getFirstChild(this);
    }

    @Override // org.w3c.dom.Document
    public DOMImplementation getImplementation() {
        return DomImpl._document_getImplementation(this);
    }

    @Override // org.w3c.dom.Document
    public String getInputEncoding() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return DomImpl._node_getLastChild(this);
    }

    @Override // org.w3c.dom.NodeList
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
        return this._docXobj._name;
    }

    @Override // org.w3c.dom.Document
    public boolean getStrictErrorChecking() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public String getTextContent() {
        return DomImpl._node_getTextContent(this);
    }

    @Override // org.w3c.dom.Node
    public Object getUserData(String r1) {
        return DomImpl._node_getUserData(this, r1);
    }

    @Override // org.w3c.dom.Document
    public String getXmlEncoding() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public boolean getXmlStandalone() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public String getXmlVersion() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return DomImpl._node_hasAttributes(this);
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return DomImpl._node_hasChildNodes(this);
    }

    @Override // org.w3c.dom.Document
    public Node importNode(Node r3, boolean r4) {
        return DomImpl._document_importNode(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"), r4);
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

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Locale locale() {
        return this._docXobj._locale;
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
        return true;
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 9;
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
        DomImpl._node_normalize(this);
    }

    @Override // org.w3c.dom.Document
    public void normalizeDocument() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node r3) {
        return DomImpl._node_removeChild(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Document
    public Node renameNode(Node r1, String r2, String r3) {
        Node r0 = (Node) ZeusTransformUtils.wrapperContextForParams(r1, Node.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node r3, Node r4) {
        return DomImpl._node_replaceChild(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"), (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Document
    public void setDocumentURI(String r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String r1) {
        DomImpl._node_setNodeValue(this, r1);
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String r1) {
        DomImpl._node_setPrefix(this, r1);
    }

    @Override // org.w3c.dom.Document
    public void setStrictErrorChecking(boolean r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public void setTextContent(String r1) {
        DomImpl._node_setTextContent(this, r1);
    }

    @Override // org.w3c.dom.Node
    public Object setUserData(String r3, Object r4, UserDataHandler r5) {
        return DomImpl._node_setUserData(this, r3, r4, (UserDataHandler) ZeusTransformUtils.wrapperContextForParams(r5, UserDataHandler.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Document
    public void setXmlStandalone(boolean r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setXmlVersion(String r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Cur tempCur() {
        return this._docXobj.tempCur();
    }
}
