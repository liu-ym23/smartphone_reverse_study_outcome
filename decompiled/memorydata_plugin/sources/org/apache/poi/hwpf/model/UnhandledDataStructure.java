package org.apache.poi.hwpf.model;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class UnhandledDataStructure {
    private final byte[] _buf;

    public UnhandledDataStructure(byte[] r5, int r6, int r7) {
        int r0 = r6 + r7;
        if (r0 > r5.length) goto L12;
        if (r0 < 0) goto L12;
        if (r6 < 0) goto L10;
        if (r7 < 0) goto L10;
        this._buf = Arrays.copyOfRange(r5, r6, r0);
        return;
    L10:
        throw new IndexOutOfBoundsException("Offset and Length must both be >= 0, negative indicies are not permitted - code is tried to read " + r7 + " from offset " + r6);
    L12:
        throw new IndexOutOfBoundsException("Buffer Length is " + r5.length + " but code is tried to read " + r7 + " from offset " + r6 + " to " + r0);
    }

    byte[] getBuf() {
        return this._buf;
    }
}
