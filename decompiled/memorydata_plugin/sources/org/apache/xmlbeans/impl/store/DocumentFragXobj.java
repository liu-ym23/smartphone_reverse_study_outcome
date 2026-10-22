package org.apache.xmlbeans.impl.store;

import org.w3c.dom.DocumentFragment;

/* JADX INFO: loaded from: classes7.dex */
class DocumentFragXobj extends NodeXobj implements DocumentFragment {
    DocumentFragXobj(Locale r3) {
        super(r3, 1, 11);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r1) {
        return new DocumentFragXobj(r1);
    }
}
