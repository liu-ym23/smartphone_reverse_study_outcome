package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
class ConstructedBitStream extends InputStream {
    private ASN1BitStringParser _currentParser;
    private InputStream _currentStream;
    private boolean _first;
    private final boolean _octetAligned;
    private int _padBits;
    private final ASN1StreamParser _parser;

    ConstructedBitStream(ASN1StreamParser r2, boolean r3) {
        this._first = true;
        this._padBits = 0;
        this._parser = r2;
        this._octetAligned = r3;
    }

    private ASN1BitStringParser getNextParser() {
        ASN1Encodable r0 = this._parser.readObject();
        if (r0 != null) goto L14;
        if (this._octetAligned == true) goto L7;
        return null;
    L7:
        if (this._padBits != 0) goto L10;
        return null;
    L10:
        throw new IOException("expected octet-aligned bitstring, but found padBits: " + this._padBits);
    L14:
        if (ZeusTransformUtils.instanceOf(r0, ASN1BitStringParser.class) == false) goto L22;
        if (this._padBits != 0) goto L20;
        return (ASN1BitStringParser) ZeusTransformUtils.preCheckCast(r0, ASN1BitStringParser.class, "com.obric.memorydata.plugin");
    L20:
        throw new IOException("only the last nested bitstring can have padding");
    L22:
        throw new IOException("unknown object encountered: " + r0.getClass());
    }

    int getPadBits() {
        return this._padBits;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this._currentStream != null) goto L11;
        if (this._first == true) goto L7;
        return -1;
    L7:
        ASN1BitStringParser r0 = getNextParser();
        this._currentParser = r0;
        if (r0 != null) goto L10;
        return -1;
    L10:
        this._first = false;
        this._currentStream = r0.getBitStream();
    L11:
        int r1 = this._currentStream.read();
        if (r1 >= 0) goto L13;
        this._padBits = this._currentParser.getPadBits();
        ASN1BitStringParser r2 = getNextParser();
        this._currentParser = r2;
        if (r2 == null) goto L16;
        this._currentStream = r2.getBitStream();
        goto L11
    L16:
        this._currentStream = null;
        return -1;
    L13:
        return r1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r6, int r7, int r8) {
        int r1 = 0;
        if (this._currentStream != null) goto L12;
        if (this._first == true) goto L7;
        return -1;
    L7:
        ASN1BitStringParser r0 = getNextParser();
        this._currentParser = r0;
        if (r0 != null) goto L10;
        return -1;
    L10:
        this._first = false;
        this._currentStream = r0.getBitStream();
    L12:
        int r2 = this._currentStream.read(r6, r7 + r1, r8 - r1);
        if (r2 >= 0) goto L14;
        this._padBits = this._currentParser.getPadBits();
        ASN1BitStringParser r3 = getNextParser();
        this._currentParser = r3;
        if (r3 == null) goto L19;
        this._currentStream = r3.getBitStream();
        goto L12
    L19:
        this._currentStream = null;
        if (r1 >= 1) goto L23;
        return -1;
    L23:
        return r1;
    L14:
        r1 = r1 + r2;
        if (r1 != r8) goto L12;
        return r1;
    }
}
