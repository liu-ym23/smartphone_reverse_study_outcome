package org.bouncycastle.asn1;

import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class BERBitStringParser implements ASN1BitStringParser {
    private ConstructedBitStream _bitStream;
    private ASN1StreamParser _parser;

    BERBitStringParser(ASN1StreamParser r1) {
        this._parser = r1;
    }

    static BERBitString parse(ASN1StreamParser r2) {
        ConstructedBitStream r0 = new ConstructedBitStream(r2, false);
        return new BERBitString(Streams.readAll(r0), r0.getPadBits());
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        ConstructedBitStream r0 = new ConstructedBitStream(this._parser, false);
        this._bitStream = r0;
        return r0;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return parse(this._parser);
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public int getPadBits() {
        return this._bitStream.getPadBits();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L4:
        e = move-exception;
        throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
    }
}
