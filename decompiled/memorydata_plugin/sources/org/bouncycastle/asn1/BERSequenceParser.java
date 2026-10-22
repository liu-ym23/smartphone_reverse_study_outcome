package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class BERSequenceParser implements ASN1SequenceParser {
    private ASN1StreamParser _parser;

    BERSequenceParser(ASN1StreamParser r1) {
        this._parser = r1;
    }

    static BERSequence parse(ASN1StreamParser r1) {
        return new BERSequence(r1.readVector());
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return parse(this._parser);
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }
}
