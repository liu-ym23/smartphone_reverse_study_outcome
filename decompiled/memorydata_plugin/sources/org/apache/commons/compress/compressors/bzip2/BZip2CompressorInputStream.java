package org.apache.commons.compress.compressors.bzip2;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
public class BZip2CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private BitInputStream bin;
    private boolean blockRandomised;
    private int blockSize100k;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private final CRC crc;
    private int currentState;
    private Data data;
    private final boolean decompressConcatenated;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int su_ch2;
    private int su_chPrev;
    private int su_count;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;

    private static final class Data {
        final int[][] base;
        final int[] cftab;
        final char[] getAndMoveToFrontDecode_yy;
        final boolean[] inUse;
        final int[][] limit;
        final byte[] ll8;
        final int[] minLens;
        final int[][] perm;
        final byte[] recvDecodingTables_pos;
        final byte[] selector;
        final byte[] selectorMtf;
        final byte[] seqToUnseq;
        final char[][] temp_charArray2d;
        int[] tt;
        final int[] unzftab;

        Data(int r5) {
            this.inUse = new boolean[256];
            this.seqToUnseq = new byte[256];
            this.selector = new byte[18002];
            this.selectorMtf = new byte[18002];
            this.unzftab = new int[256];
            this.limit = (int[][]) Array.newInstance(int.class, new int[]{6, 258});
            this.base = (int[][]) Array.newInstance(int.class, new int[]{6, 258});
            this.perm = (int[][]) Array.newInstance(int.class, new int[]{6, 258});
            this.minLens = new int[6];
            this.cftab = new int[257];
            this.getAndMoveToFrontDecode_yy = new char[256];
            this.temp_charArray2d = (char[][]) Array.newInstance(char.class, new int[]{6, 258});
            this.recvDecodingTables_pos = new byte[6];
            this.ll8 = new byte[r5 * 100000];
        }

        int[] initTT(int r3) {
            int[] r0 = this.tt;
            if (r0 != null) goto L5;
        L6:
            int[] r1 = new int[r3];
            this.tt = r1;
            return r1;
        L5:
            if (r0.length < r3) goto L6;
            return r0;
        }
    }

    public BZip2CompressorInputStream(InputStream r2) {
        this(r2, false);
    }

    public BZip2CompressorInputStream(InputStream r4, boolean r5) {
        this.crc = new CRC();
        this.currentState = 1;
        if (r4 != System.in) goto L5;
        r4 = new CloseShieldFilterInputStream(r4);
    L5:
        this.bin = new BitInputStream(r4, ByteOrder.BIG_ENDIAN);
        this.decompressConcatenated = r5;
        init(true);
        initBlock();
    }

    private static boolean bsGetBit(BitInputStream r1) {
        if (bsR(r1, 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static int bsGetInt(BitInputStream r1) {
        return bsR(r1, 32);
    }

    private static char bsGetUByte(BitInputStream r1) {
        return (char) bsR(r1, 8);
    }

    private static int bsR(BitInputStream r2, int r3) {
        long r4 = r2.readBits(r3);
        if (r4 < 0) goto L7;
        return (int) r4;
    L7:
        throw new IOException("Unexpected end of stream");
    }

    private static void checkBounds(int r1, int r2, String r3) {
        if (r1 < 0) goto L9;
        if (r1 >= r2) goto L7;
        return;
    L7:
        throw new IOException("Corrupted input, " + r3 + " value too big");
    L9:
        throw new IOException("Corrupted input, " + r3 + " value negative");
    }

    private boolean complete() {
        int r0 = bsGetInt(this.bin);
        this.storedCombinedCRC = r0;
        this.currentState = 0;
        this.data = null;
        if (r0 != this.computedCombinedCRC) goto L11;
        if (this.decompressConcatenated == true) goto L7;
    L8:
        return true;
    L7:
        if (init(false) == false) goto L8;
        return false;
    L11:
        throw new IOException("BZip2 CRC error");
    }

    private void createHuffmanDecodingTables(int r18, int r19) {
        Data r0 = this.data;
        char[][] r1 = r0.temp_charArray2d;
        int[] r2 = r0.minLens;
        int[][] r3 = r0.limit;
        int[][] r4 = r0.base;
        int[][] r5 = r0.perm;
        int r7 = 0;
    L3:
        if (r7 >= r19) goto L13;
        char r8 = ' ';
        char[] r9 = r1[r7];
        int r10 = r18;
        char r15 = 0;
    L5:
        r10 = r10 - 1;
        if (r10 < 0) goto L12;
        char r11 = r9[r10];
        if (r11 <= r15) goto L10;
        r15 = r11;
    L10:
        if (r11 >= r8) goto L5;
        r8 = r11;
        goto L5
    L12:
        hbCreateDecodeTables(r3[r7], r4[r7], r5[r7], r1[r7], r8, r15, r18);
        r2[r7] = r8;
        r7 = r7 + 1;
        goto L3
    }

    private void endBlock() {
        int r0 = this.crc.getFinalCRC();
        this.computedBlockCRC = r0;
        int r1 = this.storedBlockCRC;
        if (r1 != r0) goto L6;
        int r2 = this.computedCombinedCRC;
        int r3 = r2 << 1;
        int r4 = (r2 >>> 31) | r3;
        this.computedCombinedCRC = r4;
        this.computedCombinedCRC = r0 ^ r4;
        return;
    L6:
        int r5 = this.storedCombinedCRC;
        int r6 = r5 << 1;
        int r7 = (r5 >>> 31) | r6;
        this.computedCombinedCRC = r7;
        this.computedCombinedCRC = r7 ^ r1;
        throw new IOException("BZip2 CRC error");
    }

    private void getAndMoveToFrontDecode() {
        BZip2CompressorInputStream r0 = this;
        BitInputStream r1 = r0.bin;
        r0.origPtr = bsR(r1, 24);
        recvDecodingTables();
        Data r2 = r0.data;
        byte[] r3 = r2.ll8;
        int[] r4 = r2.unzftab;
        byte[] r5 = r2.selector;
        byte[] r6 = r2.seqToUnseq;
        char[] r7 = r2.getAndMoveToFrontDecode_yy;
        int[] r8 = r2.minLens;
        int[][] r9 = r2.limit;
        int[][] r10 = r2.base;
        int[][] r11 = r2.perm;
        int r12 = r0.blockSize100k * 100000;
        int r13 = 256;
    L3:
        r13 = r13 - 1;
        if (r13 < 0) goto L6;
        r7[r13] = (char) r13;
        r4[r13] = 0;
        goto L3
    L6:
        int r14 = r0.nInUse + 1;
        int r16 = getAndMoveToFrontDecode0();
        int r15 = r5[0] & 255;
        checkBounds(r15, 6, "zt");
        int[] r19 = r10[r15];
        int[] r20 = r9[r15];
        int[] r21 = r11[r15];
        int r23 = r8[r15];
        int r17 = r16;
        int r25 = 49;
        int r18 = -1;
        int r24 = 0;
    L7:
        if (r17 == r14) goto L51;
        r14 = r14;
        String r22 = "groupNo";
        BitInputStream r29 = r1;
        if (r17 == 0) goto L32;
        if (r17 == 1) goto L32;
        r18 = r18 + 1;
        if (r18 >= r12) goto L31;
        int r31 = r12;
        checkBounds(r17, 257, "nextSym");
        int r26 = r17 - 1;
        char r110 = r7[r26];
        int[] r32 = r8;
        checkBounds(r110, 256, "yy");
        int r27 = r6[r110] & 255;
        r4[r27] = r4[r27] + 1;
        r3[r18] = r6[r110];
        if (r17 > 16) goto L20;
    L17:
        if (r26 <= 0) goto L19;
        int r28 = r26 - 1;
        r7[r26] = r7[r28];
        r26 = r28;
        goto L17
    L19:
        char r30 = 0;
    L21:
        r7[r30] = r110;
        if (r25 != 0) goto L24;
        int r33 = r24 + 1;
        checkBounds(r33, 18002, "groupNo");
        int r34 = r5[r33] & 255;
        checkBounds(r34, 6, "zt");
        int[] r35 = r10[r34];
        int[] r111 = r9[r34];
        int[] r112 = r11[r34];
        int r36 = r32[r34];
        r24 = r33;
        r19 = r35;
        r20 = r111;
        r21 = r112;
        r25 = 49;
    L25:
        checkBounds(r36, 258, "zn");
        int r113 = bsR(r29, r36);
        int r114 = r36;
    L27:
        if (r113 <= r20[r114]) goto L29;
        r114 = r114 + 1;
        checkBounds(r114, 258, "zn");
        r113 = (r113 << 1) | bsR(r29, 1);
        goto L27
    L29:
        int r115 = r113 - r19[r114];
        checkBounds(r115, 258, "zvec");
        r17 = r21[r115];
        r23 = r36;
        r1 = r29;
        r12 = r31;
        r8 = r32;
        r0 = this;
        goto L7
    L24:
        r25 = r25 - 1;
        r36 = r23;
        goto L25
    L20:
        r30 = 0;
        System.arraycopy(r7, 0, r7, 1, r26);
        goto L21
    L31:
        throw new IOException(new StringBuilder().append("Block overrun in MTF, ").append(r18).append(" exceeds ").append(r12).toString());
    L32:
        int[] r37 = r8;
        int r210 = r17;
        int r116 = r12;
        byte[] r211 = r3;
        r17 = r210;
        int r38 = -1;
        int r212 = r25;
        int r213 = r24;
        int r214 = r23;
        int[] r215 = r21;
        int[] r216 = r20;
        int[] r217 = r19;
        int r117 = 1;
    L33:
        if (r17 != 0) goto L35;
        r38 = r38 + r117;
        int r218 = r18;
    L38:
        if (r212 != 0) goto L40;
        int r118 = r213 + 1;
        checkBounds(r118, 18002, r22);
        int r119 = r5[r118] & 255;
        checkBounds(r119, 6, "zt");
        r217 = r10[r119];
        r216 = r9[r119];
        r215 = r11[r119];
        r214 = r37[r119];
        r213 = r118;
        r212 = 49;
    L41:
        int r120 = r214;
        checkBounds(r120, 258, "zn");
        int r39 = bsR(r29, r120);
        int r121 = r120;
    L43:
        if (r39 <= r216[r121]) goto L45;
        int r122 = r121 + 1;
        checkBounds(r122, 258, "zn");
        r39 = (r39 << 1) | bsR(r29, 1);
        r121 = r122;
        r11 = r11;
        goto L43
    L45:
        int r40 = r39 - r217[r121];
        checkBounds(r40, 258, "zvec");
        r117 = r117 << 1;
        r17 = r215[r40];
        r214 = r120;
        r18 = r218;
        r22 = r22;
        r11 = r11;
        goto L33
    L40:
        r212 = r212 - 1;
        goto L41
    L35:
        r218 = r18;
        if (r17 != 1) goto L46;
        r38 = r38 + (r117 << 1);
        goto L38
    L46:
        r0 = this;
        int[][] r310 = r11;
        checkBounds(r38, r0.data.ll8.length, "s");
        char r41 = r7[0];
        checkBounds(r41, 256, "yy");
        byte r42 = r6[r41];
        int r123 = r42 & 255;
        r4[r123] = r4[r123] + (r38 + 1);
        int r124 = r218 + 1;
        int r43 = r38 + r124;
        checkBounds(r43, r0.data.ll8.length, "lastShadow");
        Arrays.fill(r211, r124, r43 + 1, r42);
        if (r43 >= r116) goto L50;
        r18 = r43;
        r19 = r217;
        r20 = r216;
        r21 = r215;
        r23 = r214;
        r24 = r213;
        r25 = r212;
        r8 = r37;
        r3 = r211;
        r11 = r310;
        r12 = r116;
        r1 = r29;
        goto L7
    L50:
        throw new IOException("Block overrun while expanding RLE in MTF, " + r43 + " exceeds " + r116);
    L51:
        r0.last = r18;
    }

    private int getAndMoveToFrontDecode0() {
        Data r0 = this.data;
        int r1 = r0.selector[0] & 255;
        checkBounds(r1, 6, "zt");
        int[] r2 = r0.limit[r1];
        int r3 = r0.minLens[r1];
        checkBounds(r3, 258, "zn");
        int r6 = bsR(this.bin, r3);
    L4:
        if (r6 <= r2[r3]) goto L6;
        r3 = r3 + 1;
        checkBounds(r3, 258, "zn");
        r6 = (r6 << 1) | bsR(this.bin, 1);
        goto L4
    L6:
        int r7 = r6 - r0.base[r1][r3];
        checkBounds(r7, 258, "zvec");
        return r0.perm[r1][r7];
    }

    private static void hbCreateDecodeTables(int[] r6, int[] r7, int[] r8, char[] r9, int r10, int r11, int r12) {
        int r0 = 0;
        int r1 = r10;
        int r2 = 0;
    L3:
        if (r1 > r11) goto L11;
        int r3 = 0;
    L5:
        if (r3 >= r12) goto L10;
        if (r9[r3] != r1) goto L9;
        r8[r2] = r3;
        r2 = r2 + 1;
    L9:
        r3 = r3 + 1;
        goto L5
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        int r4 = 23;
    L12:
        r4 = r4 - 1;
        if (r4 <= 0) goto L15;
        r7[r4] = 0;
        r6[r4] = 0;
        goto L12
    L15:
        int r5 = 0;
    L17:
        if (r5 >= r12) goto L19;
        char r13 = r9[r5];
        checkBounds(r13, 258, XSDatatype.FACET_LENGTH);
        int r14 = r13 + 1;
        r7[r14] = r7[r14] + 1;
        r5 = r5 + 1;
        goto L17
    L19:
        int r15 = r7[0];
        int r16 = 1;
    L20:
        if (r16 >= 23) goto L22;
        r15 = r15 + r7[r16];
        r7[r16] = r15;
        r16 = r16 + 1;
        goto L20
    L22:
        int r17 = r7[r10];
        int r18 = r10;
    L23:
        if (r18 > r11) goto L25;
        int r19 = r18 + 1;
        int r20 = r7[r19];
        int r21 = r0 + (r20 - r17);
        r6[r18] = r21 - 1;
        r0 = r21 << 1;
        r18 = r19;
        r17 = r20;
        goto L23
    L25:
        int r110 = r10 + 1;
    L26:
        if (r110 > r11) goto L28;
        r7[r110] = ((r6[r110 - 1] + 1) << 1) - r7[r110];
        r110 = r110 + 1;
        goto L26
    }

    private boolean init(boolean r6) {
        BitInputStream r0 = this.bin;
        if (r0 == null) goto L32;
        if (r6 == true) goto L6;
        r0.clearBitCache();
    L6:
        int r1 = readNextByte(this.bin);
        if (r1 != (-1)) goto L10;
        if (r6 == true) goto L10;
        return false;
    L10:
        int r2 = readNextByte(this.bin);
        int r3 = readNextByte(this.bin);
        if (r1 != 66) goto L26;
        if (r2 != 90) goto L26;
        if (r3 != 104) goto L26;
        int r7 = readNextByte(this.bin);
        if (r7 < 49) goto L24;
        if (r7 > 57) goto L24;
        this.blockSize100k = r7 - 48;
        this.computedCombinedCRC = 0;
        return true;
    L24:
        throw new IOException("BZip2 block size is invalid");
    L26:
        if (r6 == false) goto L28;
        String r8 = "Stream is not in the BZip2 format";
    L30:
        throw new IOException(r8);
    L28:
        r8 = "Garbage after a valid BZip2 stream";
        goto L30
    L32:
        throw new IOException("No InputStream");
    }

    private void initBlock() {
        BitInputStream r0 = this.bin;
    L3:
        char r1 = bsGetUByte(r0);
        char r2 = bsGetUByte(r0);
        char r3 = bsGetUByte(r0);
        char r4 = bsGetUByte(r0);
        char r5 = bsGetUByte(r0);
        char r6 = bsGetUByte(r0);
        if (r1 != 23) goto L19;
        if (r2 != 'r') goto L19;
        if (r3 != 'E') goto L19;
        if (r4 != '8') goto L19;
        if (r5 != 'P') goto L19;
        if (r6 != 144) goto L19;
        if (complete() == false) goto L3;
        return;
    L19:
        boolean r8 = false;
        if (r1 == '1') goto L22;
    L38:
        this.currentState = 0;
        throw new IOException("Bad block header");
    L22:
        if (r2 != 'A') goto L38;
        if (r3 != 'Y') goto L38;
        if (r4 != '&') goto L38;
        if (r5 != 'S') goto L38;
        if (r6 != 'Y') goto L38;
        this.storedBlockCRC = bsGetInt(r0);
        if (bsR(r0, 1) != 1) goto L33;
        r8 = true;
    L33:
        this.blockRandomised = r8;
        if (this.data != null) goto L36;
        this.data = new Data(this.blockSize100k);
    L36:
        getAndMoveToFrontDecode();
        this.crc.initializeCRC();
        this.currentState = 1;
    }

    private void makeMaps() {
        boolean[] r0 = this.data.inUse;
        byte[] r1 = this.data.seqToUnseq;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= 256) goto L9;
        if (r0[r2] == false) goto L8;
        r1[r3] = (byte) r2;
        r3 = r3 + 1;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        this.nInUse = r3;
    }

    private int read0() {
        switch(this.currentState) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L5;
        };
    L20:
        return -1;
    L5:
        throw new IllegalStateException();
    L7:
        return setupNoRandPartC();
    L9:
        return setupNoRandPartB();
    L11:
        throw new IllegalStateException();
    L13:
        return setupRandPartC();
    L15:
        return setupRandPartB();
    L17:
        throw new IllegalStateException();
    L19:
        return setupBlock();
    }

    private int readNextByte(BitInputStream r1) {
        return (int) r1.readBits(8);
    }

    private void recvDecodingTables() {
        BitInputStream r0 = this.bin;
        Data r1 = this.data;
        boolean[] r2 = r1.inUse;
        byte[] r3 = r1.recvDecodingTables_pos;
        byte[] r4 = r1.selector;
        byte[] r5 = r1.selectorMtf;
        int r7 = 0;
        int r8 = 0;
    L4:
        if (r7 >= 16) goto L9;
        if (bsGetBit(r0) == false) goto L8;
        r8 = r8 | (1 << r7);
    L8:
        r7 = r7 + 1;
        goto L4
    L9:
        Arrays.fill(r2, false);
        int r9 = 0;
    L10:
        if (r9 >= 16) goto L20;
        if (((1 << r9) & r8) == 0) goto L19;
        int r11 = r9 << 4;
        int r12 = 0;
    L14:
        if (r12 >= 16) goto L19;
        if (bsGetBit(r0) == false) goto L18;
        r2[r11 + r12] = true;
    L18:
        r12 = r12 + 1;
    L19:
        r9 = r9 + 1;
        goto L10
    L20:
        makeMaps();
        int r6 = this.nInUse + 2;
        int r10 = bsR(r0, 3);
        int r13 = bsR(r0, 15);
        if (r13 < 0) goto L60;
        checkBounds(r6, 259, "alphaSize");
        checkBounds(r10, 7, "nGroups");
        int r14 = 0;
    L24:
        if (r14 >= r13) goto L32;
        int r15 = 0;
    L27:
        if (bsGetBit(r0) == false) goto L29;
        r15 = r15 + 1;
        goto L27
    L29:
        if (r14 >= 18002) goto L31;
        r5[r14] = (byte) r15;
    L31:
        r14 = r14 + 1;
        goto L24
    L32:
        if (r13 <= 18002) goto L34;
        r13 = 18002;
    L34:
        int r16 = r10;
    L35:
        r16 = r16 - 1;
        if (r16 < 0) goto L38;
        r3[r16] = (byte) r16;
        goto L35
    L38:
        int r17 = 0;
    L39:
        if (r17 >= r13) goto L44;
        int r18 = r5[r17] & 255;
        checkBounds(r18, 6, "selectorMtf");
        byte r19 = r3[r18];
    L41:
        if (r18 <= 0) goto L43;
        r3[r18] = r3[r18 - 1];
        r18 = r18 - 1;
        goto L41
    L43:
        r3[0] = r19;
        r4[r17] = r19;
        r17 = r17 + 1;
        goto L39
    L44:
        char[][] r20 = r1.temp_charArray2d;
        int r21 = 0;
    L45:
        if (r21 >= r10) goto L57;
        int r22 = bsR(r0, 5);
        char[] r23 = r20[r21];
        int r24 = 0;
    L47:
        if (r24 >= r6) goto L56;
    L49:
        if (bsGetBit(r0) == false) goto L55;
        if (bsGetBit(r0) == false) goto L53;
        int r25 = -1;
    L54:
        r22 = r22 + r25;
        goto L49
    L53:
        r25 = 1;
        goto L54
    L55:
        r23[r24] = (char) r22;
        r24 = r24 + 1;
        goto L47
    L56:
        r21 = r21 + 1;
        goto L45
    L57:
        createHuffmanDecodingTables(r6, r10);
        return;
    L60:
        throw new IOException("Corrupted input, nSelectors value negative");
    }

    private int setupBlock() {
        if (this.currentState == 0) goto L25;
        Data r0 = this.data;
        if (r0 == null) goto L29;
        int[] r1 = r0.cftab;
        int r2 = 1;
        int r3 = this.last + 1;
        int[] r4 = this.data.initTT(r3);
        byte[] r5 = this.data.ll8;
        r1[0] = 0;
        System.arraycopy(this.data.unzftab, 0, r1, 1, 256);
        int r6 = r1[0];
    L8:
        if (r2 > 256) goto L10;
        r6 = r6 + r1[r2];
        r1[r2] = r6;
        r2 = r2 + 1;
        goto L8
    L10:
        int r7 = this.last;
        int r8 = 0;
    L11:
        if (r8 > r7) goto L13;
        int r9 = r5[r8] & 255;
        int r10 = r1[r9];
        r1[r9] = r10 + 1;
        checkBounds(r10, r3, "tt index");
        r4[r10] = r8;
        r8 = r8 + 1;
        goto L11
    L13:
        int r11 = this.origPtr;
        if (r11 < 0) goto L24;
        if (r11 >= r4.length) goto L24;
        this.su_tPos = r4[r11];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = 256;
        if (this.blockRandomised == false) goto L22;
        this.su_rNToGo = 0;
        this.su_rTPos = 0;
        return setupRandPartA();
    L22:
        return setupNoRandPartA();
    L24:
        throw new IOException("Stream corrupted");
    L29:
        return -1;
    L25:
        return -1;
    }

    private int setupNoRandPartA() {
        if (this.su_i2 > this.last) goto L6;
        this.su_chPrev = this.su_ch2;
        byte[] r0 = this.data.ll8;
        int r1 = this.su_tPos;
        int r2 = r0[r1] & 255;
        this.su_ch2 = r2;
        checkBounds(r1, this.data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        this.su_i2++;
        this.currentState = 6;
        this.crc.updateCRC(r2);
        return r2;
    L6:
        this.currentState = 5;
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupNoRandPartB() {
        if (this.su_ch2 == this.su_chPrev) goto L6;
        this.su_count = 1;
        return setupNoRandPartA();
    L6:
        int r0 = this.su_count + 1;
        this.su_count = r0;
        if (r0 < 4) goto L11;
        checkBounds(this.su_tPos, this.data.ll8.length, "su_tPos");
        this.su_z = (char) (this.data.ll8[this.su_tPos] & 255);
        this.su_tPos = this.data.tt[this.su_tPos];
        this.su_j2 = 0;
        return setupNoRandPartC();
    L11:
        return setupNoRandPartA();
    }

    private int setupNoRandPartC() {
        if (this.su_j2 >= this.su_z) goto L6;
        int r0 = this.su_ch2;
        this.crc.updateCRC(r0);
        this.su_j2++;
        this.currentState = 7;
        return r0;
    L6:
        this.su_i2++;
        this.su_count = 0;
        return setupNoRandPartA();
    }

    private int setupRandPartA() {
        if (this.su_i2 > this.last) goto L15;
        this.su_chPrev = this.su_ch2;
        byte[] r0 = this.data.ll8;
        int r1 = this.su_tPos;
        int r2 = r0[r1] & 255;
        checkBounds(r1, this.data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        int r3 = this.su_rNToGo;
        int r4 = 0;
        if (r3 != 0) goto L9;
        this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
        int r5 = this.su_rTPos + 1;
        this.su_rTPos = r5;
        if (r5 != 512) goto L11;
        this.su_rTPos = 0;
    L11:
        if (this.su_rNToGo != 1) goto L13;
        r4 = 1;
    L13:
        int r6 = r2 ^ r4;
        this.su_ch2 = r6;
        this.su_i2++;
        this.currentState = 3;
        this.crc.updateCRC(r6);
        return r6;
    L9:
        this.su_rNToGo = r3 - 1;
        goto L11
    L15:
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupRandPartB() {
        if (this.su_ch2 == this.su_chPrev) goto L7;
        this.currentState = 2;
        this.su_count = 1;
    L6:
        return setupRandPartA();
    L7:
        int r0 = this.su_count + 1;
        this.su_count = r0;
        if (r0 >= 4) goto L10;
        this.currentState = 2;
        goto L6
    L10:
        byte[] r1 = this.data.ll8;
        int r2 = this.su_tPos;
        this.su_z = (char) (r1[r2] & 255);
        checkBounds(r2, this.data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        int r3 = this.su_rNToGo;
        if (r3 != 0) goto L15;
        this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
        int r4 = this.su_rTPos + 1;
        this.su_rTPos = r4;
        if (r4 != 512) goto L16;
        this.su_rTPos = 0;
    L16:
        this.su_j2 = 0;
        this.currentState = 4;
        if (this.su_rNToGo != 1) goto L20;
        this.su_z = (char) (this.su_z ^ 1);
    L20:
        return setupRandPartC();
    L15:
        this.su_rNToGo = r3 - 1;
        goto L16
    }

    private int setupRandPartC() {
        if (this.su_j2 >= this.su_z) goto L6;
        this.crc.updateCRC(this.su_ch2);
        this.su_j2++;
        return this.su_ch2;
    L6:
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        return setupRandPartA();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        BitInputStream r0 = this.bin;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.close();     // Catch: Throwable -> L7
        this.data = null;
        this.bin = null;
        return;
    L7:
        th = move-exception;
        this.data = null;
        this.bin = null;
        throw th;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.bin.getBytesRead();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.bin == null) goto L11;
        int r0 = read0();
        if (r0 >= 0) goto L7;
        int r1 = -1;
    L8:
        count(r1);
        return r0;
    L7:
        r1 = 1;
        goto L8
    L11:
        throw new IOException("Stream closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        if (r5 < 0) goto L28;
        if (r6 < 0) goto L26;
        int r0 = r5 + r6;
        if (r0 > r4.length) goto L24;
        if (this.bin == null) goto L22;
        if (r6 != 0) goto L12;
        return 0;
    L12:
        int r7 = r5;
    L13:
        if (r7 >= r0) goto L17;
        int r1 = read0();
        if (r1 < 0) goto L17;
        r4[r7] = (byte) r1;
        count(1);
        r7 = r7 + 1;
    L17:
        if (r7 != r5) goto L20;
        return -1;
    L20:
        return r7 - r5;
    L22:
        throw new IOException("Stream closed");
    L24:
        throw new IndexOutOfBoundsException("offs(" + r5 + ") + len(" + r6 + ") > dest.length(" + r4.length + ").");
    L26:
        throw new IndexOutOfBoundsException("len(" + r6 + ") < 0.");
    L28:
        throw new IndexOutOfBoundsException("offs(" + r5 + ") < 0.");
    }
}
