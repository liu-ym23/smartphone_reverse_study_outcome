package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class Base64Encoder implements Encoder {
    protected final byte[] decodingTable;
    protected final byte[] encodingTable;
    protected byte padding;

    public Base64Encoder() {
        this.encodingTable = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        this.padding = kotlin.io.encoding.Base64.padSymbol;
        this.decodingTable = new byte[128];
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream r4, char r5, char r6, char r7, char r8) {
        char r0 = this.padding;
        if (r7 != r0) goto L13;
        if (r8 != r0) goto L12;
        byte[] r3 = this.decodingTable;
        byte r9 = r3[r5];
        byte r10 = r3[r6];
        if ((r9 | r10) < 0) goto L10;
        int r11 = r10 >> 4;
        r4.write(r11 | (r9 << 2));
        return 1;
    L10:
        throw new IOException("invalid characters encountered at end of base64 data");
    L12:
        throw new IOException("invalid characters encountered at end of base64 data");
    L13:
        byte[] r12 = this.decodingTable;
        if (r8 != r0) goto L21;
        byte r13 = r12[r5];
        byte r14 = r12[r6];
        byte r15 = r12[r7];
        if (((r13 | r14) | r15) < 0) goto L20;
        r4.write((r13 << 2) | (r14 >> 4));
        int r16 = r15 >> 2;
        r4.write(r16 | (r14 << 4));
        return 2;
    L20:
        throw new IOException("invalid characters encountered at end of base64 data");
    L21:
        byte r17 = r12[r5];
        byte r18 = r12[r6];
        byte r19 = r12[r7];
        byte r20 = r12[r8];
        if ((((r17 | r18) | r19) | r20) < 0) goto L26;
        r4.write((r17 << 2) | (r18 >> 4));
        r4.write((r18 << 4) | (r19 >> 2));
        r4.write(r20 | (r19 << 6));
        return 3;
    L26:
        throw new IOException("invalid characters encountered at end of base64 data");
    }

    private boolean ignore(char r1) {
        if (r1 != '\n') goto L5;
    L12:
        return true;
    L5:
        if (r1 == '\r') goto L12;
        if (r1 == '\t') goto L12;
        if (r1 == ' ') goto L12;
        return false;
    }

    private int nextI(String r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L6;
        if (ignore(r2.charAt(r3)) == false) goto L6;
        r3 = r3 + 1;
    L6:
        return r3;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String r18, OutputStream r19) {
        byte[] r4 = new byte[54];
        int r5 = r18.length();
    L3:
        if (r5 <= 0) goto L9;
        if (ignore(r18.charAt(r5 - 1)) == false) goto L9;
        r5 = r5 - 1;
    L9:
        if (r5 != 0) goto L11;
        return 0;
    L11:
        int r7 = r5;
        int r8 = 0;
    L12:
        if (r7 <= 0) goto L19;
        if (r8 == 4) goto L19;
        if (ignore(r18.charAt(r7 - 1)) == true) goto L18;
        r8 = r8 + 1;
    L18:
        r7 = r7 - 1;
    L19:
        int r9 = nextI(r18, 0, r7);
        int r10 = 0;
        int r11 = 0;
    L20:
        if (r9 >= r7) goto L29;
        int r12 = r9 + 1;
        byte r13 = this.decodingTable[r18.charAt(r9)];
        int r14 = nextI(r18, r12, r7);
        int r15 = r14 + 1;
        byte r16 = this.decodingTable[r18.charAt(r14)];
        int r17 = nextI(r18, r15, r7);
        int r110 = r17 + 1;
        byte r111 = this.decodingTable[r18.charAt(r17)];
        int r112 = nextI(r18, r110, r7);
        int r113 = r112 + 1;
        byte r114 = this.decodingTable[r18.charAt(r112)];
        if ((((r13 | r16) | r111) | r114) < 0) goto L28;
        int r115 = r10 + 1;
        r4[r10] = (byte) ((r13 << 2) | (r16 >> 4));
        int r20 = r115 + 1;
        r4[r115] = (byte) ((r16 << 4) | (r111 >> 2));
        r10 = r20 + 1;
        r4[r20] = (byte) ((r111 << 6) | r114);
        r11 = r11 + 3;
        if (r10 != 54) goto L26;
        r19.write(r4);
        r10 = 0;
    L26:
        r9 = nextI(r18, r113, r7);
        goto L20
    L28:
        throw new IOException("invalid characters encountered in base64 data");
    L29:
        if (r10 <= 0) goto L31;
        r19.write(r4, 0, r10);
    L31:
        int r3 = nextI(r18, r9, r5);
        int r6 = nextI(r18, r3 + 1, r5);
        int r21 = nextI(r18, r6 + 1, r5);
        return r11 + decodeLastBlock(r19, r18.charAt(r3), r18.charAt(r6), r18.charAt(r21), r18.charAt(nextI(r18, r21 + 1, r5)));
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
        int r9 = Math.min(54, r8);
        r14.write(r1, 0, encode(r11, r12, r9, r1, 0));
        r12 = r12 + r9;
        r8 = r8 - r9;
        goto L6
    L9:
        return ((r13 + 2) / 3) * 4;
    }

    public int encode(byte[] r11, int r12, int r13, byte[] r14, int r15) {
        int r0 = (r12 + r13) - 2;
        int r2 = r12;
        int r3 = r15;
    L3:
        if (r2 >= r0) goto L5;
        int r4 = r2 + 1;
        byte r5 = r11[r2];
        int r6 = r4 + 1;
        int r7 = r11[r4] & 255;
        int r8 = r6 + 1;
        int r9 = r11[r6] & 255;
        int r10 = r3 + 1;
        byte[] r16 = this.encodingTable;
        r14[r3] = r16[(r5 >>> 2) & 63];
        int r17 = r10 + 1;
        r14[r10] = r16[((r5 << 4) | (r7 >>> 4)) & 63];
        int r18 = r17 + 1;
        r14[r17] = r16[((r7 << 2) | (r9 >>> 6)) & 63];
        r3 = r18 + 1;
        r14[r18] = r16[r9 & 63];
        r2 = r8;
        goto L3
    L5:
        int r19 = r13 - (r2 - r12);
        if (r19 == 1) goto L10;
        if (r19 != 2) goto L12;
        int r110 = r11[r2] & 255;
        int r111 = r11[r2 + 1] & 255;
        int r112 = r3 + 1;
        byte[] r1 = this.encodingTable;
        r14[r3] = r1[(r110 >>> 2) & 63];
        int r20 = r112 + 1;
        r14[r112] = r1[((r110 << 4) | (r111 >>> 4)) & 63];
        int r113 = r20 + 1;
        r14[r20] = r1[(r111 << 2) & 63];
        r3 = r113 + 1;
        r14[r113] = this.padding;
    L12:
        return r3 - r15;
    L10:
        int r114 = r11[r2] & 255;
        int r115 = r3 + 1;
        byte[] r116 = this.encodingTable;
        r14[r3] = r116[(r114 >>> 2) & 63];
        int r21 = r115 + 1;
        r14[r115] = r116[(r114 << 4) & 63];
        int r117 = r21 + 1;
        byte r118 = this.padding;
        r14[r21] = r118;
        r3 = r117 + 1;
        r14[r117] = r118;
        goto L12
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getEncodedLength(int r1) {
        return ((r1 + 2) / 3) * 4;
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
    }
}
