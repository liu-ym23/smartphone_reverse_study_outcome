package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class HexEncoder implements Encoder {
    protected final byte[] decodingTable;
    protected final byte[] encodingTable;

    public HexEncoder() {
        this.encodingTable = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        this.decodingTable = new byte[128];
        initialiseDecodingTable();
    }

    private static boolean ignore(char r1) {
        if (r1 != '\n') goto L5;
    L12:
        return true;
    L5:
        if (r1 == '\r') goto L12;
        if (r1 == '\t') goto L12;
        if (r1 == ' ') goto L12;
        return false;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String r11, OutputStream r12) {
        byte[] r1 = new byte[36];
        int r2 = r11.length();
    L3:
        if (r2 <= 0) goto L8;
        if (ignore(r11.charAt(r2 - 1)) == false) goto L8;
        r2 = r2 - 1;
    L8:
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L9:
        if (r4 >= r2) goto L28;
    L10:
        if (r4 >= r2) goto L14;
        if (ignore(r11.charAt(r4)) == false) goto L14;
        r4 = r4 + 1;
    L14:
        int r8 = r4 + 1;
        byte r7 = this.decodingTable[r11.charAt(r4)];
    L15:
        if (r8 >= r2) goto L19;
        if (ignore(r11.charAt(r8)) == false) goto L19;
        r8 = r8 + 1;
    L19:
        int r9 = r8 + 1;
        byte r10 = this.decodingTable[r11.charAt(r8)];
        if ((r7 | r10) < 0) goto L27;
        int r13 = r5 + 1;
        r1[r5] = (byte) ((r7 << 4) | r10);
        if (r13 != 36) goto L24;
        r12.write(r1);
        r5 = 0;
    L25:
        r6 = r6 + 1;
        r4 = r9;
        goto L9
    L24:
        r5 = r13;
        goto L25
    L27:
        throw new IOException("invalid characters encountered in Hex string");
    L28:
        if (r5 <= 0) goto L30;
        r12.write(r1, 0, r5);
    L30:
        return r6;
    }

    byte[] decodeStrict(String r6, int r7, int r8) {
        Objects.requireNonNull(r6, "'str' cannot be null");
        if (r7 < 0) goto L20;
        if (r8 < 0) goto L20;
        if (r7 > (r6.length() - r8)) goto L20;
        if ((r8 & 1) != 0) goto L18;
        int r9 = r8 >>> 1;
        byte[] r0 = new byte[r9];
        int r1 = 0;
    L10:
        if (r1 >= r9) goto L16;
        int r3 = r7 + 1;
        byte r10 = this.decodingTable[r6.charAt(r7)];
        int r4 = r3 + 1;
        int r11 = r10 << 4;
        int r12 = r11 | this.decodingTable[r6.charAt(r3)];
        if (r12 < 0) goto L15;
        r0[r1] = (byte) r12;
        r1 = r1 + 1;
        r7 = r4;
        goto L10
    L15:
        throw new IOException("invalid characters encountered in Hex string");
    L16:
        return r0;
    L18:
        throw new IOException("a hexadecimal encoding must have an even number of characters");
    L20:
        throw new IndexOutOfBoundsException("invalid offset and/or length specified");
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] r11, int r12, int r13, OutputStream r14) {
        if (r13 >= 0) goto L5;
        return 0;
    L5:
        byte[] r1 = new byte[72];
        int r8 = r13;
    L6:
        if (r8 <= 0) goto L9;
        int r9 = Math.min(36, r8);
        r14.write(r1, 0, encode(r11, r12, r9, r1, 0));
        r12 = r12 + r9;
        r8 = r8 - r9;
        goto L6
    L9:
        return r13 * 2;
    }

    public int encode(byte[] r6, int r7, int r8, byte[] r9, int r10) {
        int r11 = r8 + r7;
        int r0 = r10;
    L3:
        if (r7 >= r11) goto L6;
        int r1 = r7 + 1;
        int r12 = r6[r7] & 255;
        int r2 = r0 + 1;
        byte[] r3 = this.encodingTable;
        r9[r0] = r3[r12 >>> 4];
        r0 = r2 + 1;
        r9[r2] = r3[r12 & 15];
        r7 = r1;
        goto L3
    L6:
        return r0 - r10;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getEncodedLength(int r1) {
        return r1 * 2;
    }

    public void initialiseDecodingTable() {
        int r0 = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.decodingTable;
        if (r1 >= r2.length) goto L6;
        r2[r1] = -1;
        r1 = r1 + 1;
    L6:
        byte[] r3 = this.encodingTable;
        if (r0 >= r3.length) goto L9;
        this.decodingTable[r3[r0]] = (byte) r0;
        r0 = r0 + 1;
        goto L6
    L9:
        byte[] r4 = this.decodingTable;
        r4[65] = r4[97];
        r4[66] = r4[98];
        r4[67] = r4[99];
        r4[68] = r4[100];
        r4[69] = r4[101(0x65, float:1.42E-43)];
        r4[70] = r4[102(0x66, float:1.43E-43)];
    }
}
