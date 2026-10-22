package org.apache.xmlbeans.impl.store;

/* JADX INFO: loaded from: classes7.dex */
class SoapPartDocXobj extends DocumentXobj {
    SoapPartDom _soapPartDom;

    SoapPartDocXobj(Locale r1) {
        super(r1);
        this._soapPartDom = new SoapPartDom(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.apache.xmlbeans.impl.store.Xobj
    DomImpl.Dom getDom() {
        return this._soapPartDom;
    }

    @Override // org.apache.xmlbeans.impl.store.DocumentXobj, org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r1) {
        return new SoapPartDocXobj(r1);
    }
}
