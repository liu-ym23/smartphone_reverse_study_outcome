package org.apache.xmlbeans.impl.store;

/* JADX INFO: loaded from: classes7.dex */
abstract class NamedNodeXobj extends NodeXobj {
    boolean _canHavePrefixUri;

    NamedNodeXobj(Locale r1, int r2, int r3) {
        super(r1, r2, r3);
        this._canHavePrefixUri = true;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.apache.xmlbeans.impl.store.DomImpl.Dom
    public boolean nodeCanHavePrefixUri() {
        return this._canHavePrefixUri;
    }
}
