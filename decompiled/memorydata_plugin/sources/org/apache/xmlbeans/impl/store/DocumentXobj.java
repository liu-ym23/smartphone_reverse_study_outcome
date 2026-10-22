package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* JADX INFO: loaded from: classes7.dex */
class DocumentXobj extends NodeXobj implements Document {
    private Hashtable<String, DomImpl.Dom> _idToElement;

    DocumentXobj(Locale r3) {
        super(r3, 1, 9);
    }

    public void addIdElement(String r3, DomImpl.Dom r4) {
        DomImpl.Dom r5 = (DomImpl.Dom) ZeusTransformUtils.wrapperContextForParams(r4, DomImpl.Dom.class, "com.obric.memorydata.plugin");
        if (this._idToElement != null) goto L5;
        this._idToElement = new Hashtable();
    L5:
        this._idToElement.put(r3, r5);
    }

    @Override // org.w3c.dom.Document
    public Node adoptNode(Node r2) {
        Node r1 = (Node) ZeusTransformUtils.wrapperContextForParams(r2, Node.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("DOM Level 3 Not implemented");
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
    public Element getElementById(String r5) {
        Hashtable<String, DomImpl.Dom> r0 = this._idToElement;
        if (r0 != null) goto L5;
        return null;
    L5:
        Xobj r1 = (Xobj) ZeusTransformUtils.preCheckCast(r0.get(r5), Xobj.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return null;
    L9:
        if (isInSameTree(r1) == true) goto L12;
        this._idToElement.remove(r5);
    L12:
        return (Element) ZeusTransformUtils.preCheckCast(r1, Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagName(String r1) {
        return DomImpl._document_getElementsByTagName(this, r1);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagNameNS(String r1, String r2) {
        return DomImpl._document_getElementsByTagNameNS(this, r1, r2);
    }

    @Override // org.w3c.dom.Document
    public DOMImplementation getImplementation() {
        return DomImpl._document_getImplementation(this);
    }

    @Override // org.w3c.dom.Document
    public String getInputEncoding() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public boolean getStrictErrorChecking() {
        throw new RuntimeException("DOM Level 3 Not implemented");
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

    @Override // org.w3c.dom.Document
    public Node importNode(Node r3, boolean r4) {
        return DomImpl._document_importNode(this, (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r1) {
        return new DocumentXobj(r1);
    }

    @Override // org.w3c.dom.Document
    public void normalizeDocument() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    void removeIdElement(String r1) {
        Hashtable<String, DomImpl.Dom> r0 = this._idToElement;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    @Override // org.w3c.dom.Document
    public Node renameNode(Node r1, String r2, String r3) {
        Node r0 = (Node) ZeusTransformUtils.wrapperContextForParams(r1, Node.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setDocumentURI(String r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setStrictErrorChecking(boolean r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setXmlStandalone(boolean r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setXmlVersion(String r1) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }
}
