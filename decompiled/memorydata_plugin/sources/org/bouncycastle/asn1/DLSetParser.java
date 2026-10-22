package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DLSetParser implements ASN1SetParser {
    private ASN1StreamParser _parser;

    DLSetParser(ASN1StreamParser r1) {
        this._parser = r1;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return DLFactory.createSet(this._parser.readVector());
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L4:
        e = move-exception;
        throw new ASN1ParsingException(e.getMessage(), e);
    }
}
