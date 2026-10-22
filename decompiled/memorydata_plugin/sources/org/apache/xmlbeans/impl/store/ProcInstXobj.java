package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

/* JADX INFO: loaded from: classes7.dex */
class ProcInstXobj extends NodeXobj implements ProcessingInstruction {
    ProcInstXobj(Locale r3, String r4) {
        super(r3, 5, 7);
        this._name = this._locale.makeQName(null, r4);
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public String getData() {
        return DomImpl._processingInstruction_getData(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.NodeList, org.w3c.dom.CharacterData
    public int getLength() {
        return 0;
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public String getTarget() {
        return DomImpl._processingInstruction_getTarget(this);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r2) {
        return new ProcInstXobj(r2, this._name.getLocalPart());
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public void setData(String r1) {
        DomImpl._processingInstruction_setData(this, r1);
    }
}
