package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
class AttrIdXobj extends AttrXobj {
    AttrIdXobj(Locale r1, QName r2) {
        super(r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.AttrXobj, org.w3c.dom.Attr
    public boolean isId() {
        return true;
    }
}
