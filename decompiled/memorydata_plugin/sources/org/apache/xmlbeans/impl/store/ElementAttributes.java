package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
final class ElementAttributes implements NamedNodeMap {
    private ElementXobj _elementXobj;

    ElementAttributes(ElementXobj r1) {
        this._elementXobj = r1;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public int getLength() {
        return DomImpl._attributes_getLength(this._elementXobj);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node getNamedItem(String r1) {
        return DomImpl._attributes_getNamedItem(this._elementXobj, r1);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node getNamedItemNS(String r1, String r2) {
        return DomImpl._attributes_getNamedItemNS(this._elementXobj, r1, r2);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node item(int r1) {
        return DomImpl._attributes_item(this._elementXobj, r1);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node removeNamedItem(String r1) {
        return DomImpl._attributes_removeNamedItem(this._elementXobj, r1);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node removeNamedItemNS(String r1, String r2) {
        return DomImpl._attributes_removeNamedItemNS(this._elementXobj, r1, r2);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node setNamedItem(Node r3) {
        Node r4 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        return DomImpl._attributes_setNamedItem(this._elementXobj, r4);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node setNamedItemNS(Node r3) {
        Node r4 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        return DomImpl._attributes_setNamedItemNS(this._elementXobj, r4);
    }
}
