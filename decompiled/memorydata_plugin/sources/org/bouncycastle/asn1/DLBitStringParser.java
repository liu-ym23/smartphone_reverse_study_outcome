package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class DLBitStringParser implements ASN1BitStringParser {
    private int padBits;
    private final DefiniteLengthInputStream stream;

    DLBitStringParser(DefiniteLengthInputStream r2) {
        this.padBits = 0;
        this.stream = r2;
    }

    private InputStream getBitStream(boolean r4) {
        int r0 = this.stream.getRemaining();
        if (r0 < 1) goto L21;
        int r1 = this.stream.read();
        this.padBits = r1;
        if (r1 <= 0) goto L19;
        if (r0 < 2) goto L17;
        if (r1 > 7) goto L15;
        if (r4 == false) goto L19;
        throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.padBits);
    L15:
        throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
    L17:
        throw new IllegalStateException("zero length data with non-zero pad bits");
    L19:
        return this.stream;
    L21:
        throw new IllegalStateException("content octets cannot be empty");
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        return getBitStream(false);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return ASN1BitString.createPrimitive(this.stream.toByteArray());
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public int getPadBits() {
        return this.padBits;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L4:
        e = move-exception;
        throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
    }
}
