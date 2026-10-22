package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.utils.BitInputStream;

/* JADX INFO: loaded from: classes6.dex */
class BitStream extends BitInputStream {
    BitStream(InputStream r2) {
        super(r2, ByteOrder.LITTLE_ENDIAN);
    }

    int nextBit() {
        return (int) readBits(1);
    }

    long nextBits(int r3) {
        if (r3 < 0) goto L8;
        if (r3 > 8) goto L8;
        return readBits(r3);
    L8:
        throw new IOException("Trying to read " + r3 + " bits, at most 8 are allowed");
    }

    int nextByte() {
        return (int) readBits(8);
    }
}
