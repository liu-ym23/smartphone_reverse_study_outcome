package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
class ConstructedOctetStream extends InputStream {
    private InputStream _currentStream;
    private boolean _first;
    private final ASN1StreamParser _parser;

    ConstructedOctetStream(ASN1StreamParser r2) {
        this._first = true;
        this._parser = r2;
    }

    private ASN1OctetStringParser getNextParser() {
        ASN1Encodable r3 = this._parser.readObject();
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ASN1OctetStringParser.class) == false) goto L11;
        return (ASN1OctetStringParser) ZeusTransformUtils.preCheckCast(r3, ASN1OctetStringParser.class, "com.obric.memorydata.plugin");
    L11:
        throw new IOException("unknown object encountered: " + r3.getClass());
    }

    @Override // java.io.InputStream
    public int read() {
        if (this._currentStream != null) goto L11;
        if (this._first == true) goto L7;
        return -1;
    L7:
        ASN1OctetStringParser r0 = getNextParser();
        if (r0 != null) goto L10;
        return -1;
    L10:
        this._first = false;
        this._currentStream = r0.getOctetStream();
    L11:
        int r1 = this._currentStream.read();
        if (r1 >= 0) goto L13;
        ASN1OctetStringParser r2 = getNextParser();
        if (r2 == null) goto L16;
        this._currentStream = r2.getOctetStream();
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
        ASN1OctetStringParser r0 = getNextParser();
        if (r0 != null) goto L10;
        return -1;
    L10:
        this._first = false;
        this._currentStream = r0.getOctetStream();
    L12:
        int r2 = this._currentStream.read(r6, r7 + r1, r8 - r1);
        if (r2 >= 0) goto L14;
        ASN1OctetStringParser r3 = getNextParser();
        if (r3 == null) goto L19;
        this._currentStream = r3.getOctetStream();
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
