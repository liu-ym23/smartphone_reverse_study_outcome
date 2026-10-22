package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

/* JADX INFO: loaded from: classes7.dex */
class ElementXobj extends NamedNodeXobj implements Element {
    private ElementAttributes _attributes;

    ElementXobj(Locale r3, QName r4) {
        super(r3, 2, 1);
        this._name = r4;
    }

    @Override // org.w3c.dom.Element
    public String getAttribute(String r1) {
        return DomImpl._element_getAttribute(this, r1);
    }

    @Override // org.w3c.dom.Element
    public String getAttributeNS(String r1, String r2) {
        return DomImpl._element_getAttributeNS(this, r1, r2);
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNode(String r1) {
        return DomImpl._element_getAttributeNode(this, r1);
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNodeNS(String r1, String r2) {
        return DomImpl._element_getAttributeNodeNS(this, r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        if (this._attributes != null) goto L6;
        this._attributes = new ElementAttributes(this);
    L6:
        return this._attributes;
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagName(String r1) {
        return DomImpl._element_getElementsByTagName(this, r1);
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagNameNS(String r1, String r2) {
        return DomImpl._element_getElementsByTagNameNS(this, r1, r2);
    }

    @Override // org.w3c.dom.Element
    public TypeInfo getSchemaTypeInfo() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Element
    public String getTagName() {
        return DomImpl._element_getTagName(this);
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttribute(String r1) {
        return DomImpl._element_hasAttribute(this, r1);
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttributeNS(String r1, String r2) {
        return DomImpl._element_hasAttributeNS(this, r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r2) {
        return new ElementXobj(r2, this._name);
    }

    @Override // org.w3c.dom.Element
    public void removeAttribute(String r1) {
        DomImpl._element_removeAttribute(this, r1);
    }

    @Override // org.w3c.dom.Element
    public void removeAttributeNS(String r1, String r2) {
        DomImpl._element_removeAttributeNS(this, r1, r2);
    }

    @Override // org.w3c.dom.Element
    public Attr removeAttributeNode(Attr r3) {
        return DomImpl._element_removeAttributeNode(this, (Attr) ZeusTransformUtils.wrapperContextForParams(r3, Attr.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Element
    public void setAttribute(String r1, String r2) {
        DomImpl._element_setAttribute(this, r1, r2);
    }

    @Override // org.w3c.dom.Element
    public void setAttributeNS(String r1, String r2, String r3) {
        DomImpl._element_setAttributeNS(this, r1, r2, r3);
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNode(Attr r3) {
        return DomImpl._element_setAttributeNode(this, (Attr) ZeusTransformUtils.wrapperContextForParams(r3, Attr.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNodeNS(Attr r3) {
        return DomImpl._element_setAttributeNodeNS(this, (Attr) ZeusTransformUtils.wrapperContextForParams(r3, Attr.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.w3c.dom.Element
    public void setIdAttribute(String r1, boolean r2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNS(String r1, String r2, boolean r3) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNode(Attr r1, boolean r2) {
        Attr r0 = (Attr) ZeusTransformUtils.wrapperContextForParams(r1, Attr.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("DOM Level 3 Not implemented");
    }
}
