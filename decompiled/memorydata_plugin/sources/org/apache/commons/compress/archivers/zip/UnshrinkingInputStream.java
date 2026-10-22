package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

/* JADX INFO: loaded from: classes6.dex */
class UnshrinkingInputStream extends LZWInputStream {
    private final boolean[] isUsed;

    public UnshrinkingInputStream(InputStream r3) {
        super(r3, ByteOrder.LITTLE_ENDIAN);
        setClearCode(9);
        initializeTables(13);
        this.isUsed = new boolean[getPrefixesLength()];
        int r4 = 0;
    L4:
        if (r4 >= 256) goto L6;
        this.isUsed[r4] = true;
        r4 = r4 + 1;
        goto L4
    L6:
        setTableSize(getClearCode() + 1);
    }

    private void partialClear() {
        boolean[] r1 = new boolean[8192];
        int r3 = 0;
    L3:
        boolean[] r4 = this.isUsed;
        if (r3 >= r4.length) goto L11;
        if (r4[r3] == false) goto L10;
        if (getPrefix(r3) == (-1)) goto L10;
        r1[getPrefix(r3)] = true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        int r5 = getClearCode() + 1;
    L12:
        if (r5 >= 8192) goto L17;
        if (r1[r5] == true) goto L16;
        this.isUsed[r5] = false;
        setPrefix(r5, -1);
    L16:
        r5 = r5 + 1;
        goto L12
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    public int addEntry(int r4, byte r5) {
        int r0 = getTableSize();
    L4:
        if (r0 >= 8192) goto L8;
        if (this.isUsed[r0] == false) goto L8;
        r0 = r0 + 1;
    L8:
        setTableSize(r0);
        int r6 = addEntry(r4, r5, 8192);
        if (r6 < 0) goto L11;
        this.isUsed[r6] = true;
    L11:
        return r6;
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    public int decompressNextSymbol() {
        int r0 = readNextCode();
        if (r0 >= 0) goto L6;
        return -1;
    L6:
        boolean r2 = false;
        if (r0 != getClearCode()) goto L9;
        int r1 = readNextCode();
        if (r1 < 0) goto L28;
        if (r1 != 1) goto L22;
        if (getCodeSize() >= 13) goto L20;
        incrementCodeSize();
    L24:
        return 0;
    L20:
        throw new IOException("Attempt to increase code size beyond maximum");
    L22:
        if (r1 != 2) goto L26;
        partialClear();
        setTableSize(getClearCode() + 1);
        goto L24
    L26:
        throw new IOException("Invalid clear code subcode " + r1);
    L28:
        throw new IOException("Unexpected EOF;");
    L9:
        if (this.isUsed[r0] == true) goto L12;
        r0 = addRepeatOfPreviousCode();
        r2 = true;
    L12:
        return expandCodeToOutputStack(r0, r2);
    }
}
