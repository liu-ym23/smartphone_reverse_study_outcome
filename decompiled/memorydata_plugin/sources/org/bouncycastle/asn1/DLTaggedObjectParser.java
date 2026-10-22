package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
class DLTaggedObjectParser extends BERTaggedObjectParser {
    private final boolean _constructed;

    DLTaggedObjectParser(int r1, int r2, boolean r3, ASN1StreamParser r4) {
        super(r1, r2, r4);
        this._constructed = r3;
    }

    @Override // org.bouncycastle.asn1.BERTaggedObjectParser, org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return this._parser.loadTaggedDL(this._tagClass, this._tagNo, this._constructed);
    }
}
