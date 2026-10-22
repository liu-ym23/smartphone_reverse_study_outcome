package org.bouncycastle.cms;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class CMSTypedStream {
    protected InputStream _in;
    private final ASN1ObjectIdentifier _oid;

    private static class FullReaderStream extends FilterInputStream {
        FullReaderStream(InputStream r1) {
            super(r1);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r1, int r2, int r3) {
            if (r3 != 0) goto L5;
            return 0;
        L5:
            int r0 = Streams.readFully(((FilterInputStream) this).in, r1, r2, r3);
            if (r0 > 0) goto L10;
            return -1;
        L10:
            return r0;
        }
    }

    public CMSTypedStream(ASN1ObjectIdentifier r2, InputStream r3) {
        this(r2, r3, 32768);
    }

    public CMSTypedStream(ASN1ObjectIdentifier r2, InputStream r3, int r4) {
        this._oid = r2;
        this._in = new FullReaderStream(new BufferedInputStream(r3, r4));
    }

    public InputStream getContentStream() {
        return this._in;
    }
}
