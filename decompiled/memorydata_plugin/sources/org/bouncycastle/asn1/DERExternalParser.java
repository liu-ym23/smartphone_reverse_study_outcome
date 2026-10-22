package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DERExternalParser implements ASN1ExternalParser {
    private ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser r1) {
        this._parser = r1;
    }

    static DLExternal parse(ASN1StreamParser r2) {
        return new DLExternal(r2.readVector());
    L4:
        e = move-exception;
        throw new ASN1Exception(e.getMessage(), e);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return parse(this._parser);
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L8:
        e = move-exception;
        throw new ASN1ParsingException("unable to get DER object", e);
    L5:
        e = move-exception;
        throw new ASN1ParsingException("unable to get DER object", e);
    }
}
