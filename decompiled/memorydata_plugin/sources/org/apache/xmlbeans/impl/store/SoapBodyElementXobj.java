package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;

/* JADX INFO: loaded from: classes7.dex */
class SoapBodyElementXobj extends SoapElementXobj implements SOAPBodyElement {
    SoapBodyElementXobj(Locale r1, QName r2) {
        super(r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.SoapElementXobj, org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r2) {
        return new SoapBodyElementXobj(r2, this._name);
    }
}
