package org.bouncycastle.asn1.eac;

import java.util.Hashtable;

/* JADX INFO: loaded from: classes7.dex */
public class BidirectionalMap extends Hashtable {
    private static final long serialVersionUID = -7457289971962812909L;
    Hashtable reverseMap;

    public BidirectionalMap() {
        this.reverseMap = new Hashtable();
    }

    public Object getReverse(Object r1) {
        return this.reverseMap.get(r1);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public Object put(Object r2, Object r3) {
        this.reverseMap.put(r3, r2);
        return super.put(r2, r3);
    }
}
