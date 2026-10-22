package org.apache.xmlbeans.impl.util;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.UTFDataFormatException;
import okio.Utf8;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public class LongUTFDataInputStream extends DataInputStream {

    private interface IOCall {
        byte onebyte(int[] r1, int[] r2, int[] r3);
    }

    public LongUTFDataInputStream(InputStream r1) {
        super(r1);
    }

    public static int readUnsignedShortOrInt(DataInputStream r2) {
        int r0 = r2.readUnsignedShort();
        if (r0 == 65534) goto L5;
        return r0;
    L5:
        return r2.readInt();
    }

    public /* synthetic */ byte lambda$readLongUTF$0$LongUTFDataInputStream(int r4, byte[] r5, int[] r6, int[] r7, int[] r8) {
        if ((r8[0] + 1) > r4) goto L10;
        if (r6[0] < r7[0]) goto L7;
        r7[0] = Math.min(r5.length, r4 - r8[0]);
        readFully(r5, 0, r7[0]);
        r6[0] = 0;
    L7:
        r8[0] = r8[0] + 1;
        int r3 = r6[0];
        r6[0] = r3 + 1;
        return r5[r3];
    L10:
        throw new UTFDataFormatException("malformed input: partial character at end");
    }

    public String readLongUTF() {
        final int r0 = readUnsignedShortOrInt();
        StringBuilder r1 = new StringBuilder(r0 / 2);
        final byte[] r2 = new byte[4096];
        IOCall r3 = new $$Lambda$LongUTFDataInputStream$A_8ewNlTULD3zlWbzJtFNq5R6gA(this, r0, r2);
        int[] r4 = {0};
        int[] r5 = {0};
        int[] r6 = {0};
    L4:
        if (r4[0] >= r0) goto L24;
        int r7 = r3.onebyte(r5, r6, r4) & 255;
        switch((r7 >> 4)) {
            case 0: goto L22;
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L22;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L9;
            default: goto L8;
        };
    L9:
        byte r8 = r3.onebyte(r5, r6, r4);
        byte r11 = r3.onebyte(r5, r6, r4);
        if ((r8 & MessagePack.Code.NIL) != 128) goto L15;
        if ((r11 & MessagePack.Code.NIL) != 128) goto L15;
        int r9 = ((r7 & 15) << 12) | ((r8 & Utf8.REPLACEMENT_BYTE) << 6);
        int r10 = r11 & Utf8.REPLACEMENT_BYTE;
    L19:
        r7 = r9 | r10;
    L15:
        throw new UTFDataFormatException("malformed input around byte " + (r4[0] - 1));
    L16:
        byte r12 = r3.onebyte(r5, r6, r4);
        if ((r12 & MessagePack.Code.NIL) != 128) goto L21;
        r9 = (r7 & 31) << 6;
        r10 = r12 & Utf8.REPLACEMENT_BYTE;
        goto L19
    L21:
        throw new UTFDataFormatException("malformed input around byte " + r4[0]);
    L8:
        throw new UTFDataFormatException("malformed input around byte " + r4[0]);
    L22:
        r1.append((char) r7);
        goto L4
    L24:
        return r1.toString();
    }

    public int readUnsignedShortOrInt() {
        return readUnsignedShortOrInt(this);
    }
}
