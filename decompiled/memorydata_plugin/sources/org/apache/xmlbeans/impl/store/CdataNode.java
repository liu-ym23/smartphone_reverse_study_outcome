package org.apache.xmlbeans.impl.store;

import org.w3c.dom.CDATASection;

/* JADX INFO: loaded from: classes7.dex */
class CdataNode extends TextNode implements CDATASection {
    CdataNode(Locale r1) {
        super(r1);
    }

    @Override // org.apache.xmlbeans.impl.store.TextNode, org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 4;
    }
}
