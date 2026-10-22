package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

/* JADX INFO: loaded from: classes7.dex */
class AttrXobj extends NamedNodeXobj implements Attr {
    AttrXobj(Locale r3, QName r4) {
        super(r3, 3, 2);
        this._name = r4;
    }

    @Override // org.w3c.dom.Attr
    public String getName() {
        return DomImpl._node_getNodeName(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public Node getNextSibling() {
        return null;
    }

    @Override // org.w3c.dom.Attr
    public Element getOwnerElement() {
        return DomImpl._attr_getOwnerElement(this);
    }

    @Override // org.w3c.dom.Attr
    public TypeInfo getSchemaTypeInfo() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Attr
    public boolean getSpecified() {
        return DomImpl._attr_getSpecified(this);
    }

    @Override // org.w3c.dom.Attr
    public String getValue() {
        return DomImpl._node_getNodeValue(this);
    }

    public boolean isId() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r2) {
        return new AttrXobj(r2, this._name);
    }

    @Override // org.w3c.dom.Attr
    public void setValue(String r1) {
        DomImpl._node_setNodeValue(this, r1);
    }
}
