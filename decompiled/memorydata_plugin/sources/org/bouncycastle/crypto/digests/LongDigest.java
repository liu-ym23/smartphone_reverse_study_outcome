package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class LongDigest implements ExtendedDigest, Memoable {
    static final long[] K = null;
    protected long H1;
    protected long H2;
    protected long H3;
    protected long H4;
    protected long H5;
    protected long H6;
    protected long H7;
    protected long H8;
    private long[] W;
    private long byteCount1;
    private long byteCount2;
    protected final CryptoServicePurpose purpose;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    static {
        K = new long[]{4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    }

    public LongDigest(CryptoServicePurpose r2) {
        this.xBuf = new byte[8];
        this.W = new long[80];
        this.purpose = r2;
        this.xBufOff = 0;
        reset();
    }

    public LongDigest(LongDigest r2) {
        this.xBuf = new byte[8];
        this.W = new long[80];
        this.purpose = r2.purpose;
        copyIn(r2);
    }

    private long Ch(long r1, long r3, long r5) {
        long r0 = (~r1) & r5;
        return r0 ^ (r3 & r1);
    }

    private long Maj(long r3, long r5, long r7) {
        long r2 = r3 & r7;
        return (r2 ^ (r3 & r5)) ^ (r5 & r7);
    }

    private long Sigma0(long r7) {
        long r6 = r7 >>> 7;
        return r6 ^ (((r7 << 63) | (r7 >>> 1)) ^ ((r7 << 56) | (r7 >>> 8)));
    }

    private long Sigma1(long r7) {
        long r6 = r7 >>> 6;
        return r6 ^ (((r7 << 45) | (r7 >>> 19)) ^ ((r7 << 3) | (r7 >>> 61)));
    }

    private long Sum0(long r7) {
        long r0 = ((r7 << 36) | (r7 >>> 28)) ^ ((r7 << 30) | (r7 >>> 34));
        long r6 = r7 >>> 39;
        return (r6 | (r7 << 25)) ^ r0;
    }

    private long Sum1(long r7) {
        long r0 = ((r7 << 50) | (r7 >>> 14)) ^ ((r7 << 46) | (r7 >>> 18));
        long r6 = r7 >>> 41;
        return (r6 | (r7 << 23)) ^ r0;
    }

    private void adjustByteCounts() {
        long r0 = this.byteCount1;
        if (r0 <= 2305843009213693951L) goto L6;
        this.byteCount2 += r0 >>> 61;
        this.byteCount1 = r0 & 2305843009213693951L;
        return;
    }

    public void copyIn(LongDigest r5) {
        byte[] r0 = r5.xBuf;
        System.arraycopy(r0, 0, this.xBuf, 0, r0.length);
        this.xBufOff = r5.xBufOff;
        this.byteCount1 = r5.byteCount1;
        this.byteCount2 = r5.byteCount2;
        this.H1 = r5.H1;
        this.H2 = r5.H2;
        this.H3 = r5.H3;
        this.H4 = r5.H4;
        this.H5 = r5.H5;
        this.H6 = r5.H6;
        this.H7 = r5.H7;
        this.H8 = r5.H8;
        long[] r1 = r5.W;
        System.arraycopy(r1, 0, this.W, 0, r1.length);
        this.wOff = r5.wOff;
    }

    public void finish() {
        adjustByteCounts();
        long r0 = this.byteCount1 << 3;
        long r2 = this.byteCount2;
        byte r4 = -128;
    L3:
        update(r4);
        if (this.xBufOff == 0) goto L6;
        r4 = 0;
        goto L3
    L6:
        processLength(r0, r2);
        processBlock();
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    public void processBlock() {
        adjustByteCounts();
        int r0 = 16;
    L4:
        if (r0 > 79) goto L6;
        long[] r1 = this.W;
        long r2 = Sigma1(r1[r0 - 2]);
        long[] r4 = this.W;
        r1[r0] = ((r2 + r4[r0 - 7]) + Sigma0(r4[r0 - 15])) + this.W[r0 - 16];
        r0 = r0 + 1;
        goto L4
    L6:
        long r3 = this.H1;
        long r5 = this.H2;
        long r6 = this.H3;
        long r9 = this.H4;
        long r11 = this.H5;
        long r13 = this.H6;
        long r8 = this.H7;
        long r21 = r13;
        long r19 = r9;
        int r23 = 0;
        long r14 = r5;
        long r15 = r6;
        long r7 = r11;
        int r10 = 0;
        long r12 = this.H8;
        long r16 = r3;
        long r17 = r8;
    L8:
        if (r10 >= 10) goto L10;
        long r27 = r7;
        long r24 = Sum1(r7) + Ch(r7, r21, r17);
        long[] r29 = K;
        int r30 = r23 + 1;
        long r18 = r12 + ((r24 + r29[r23]) + this.W[r23]);
        long r20 = r19 + r18;
        long r110 = r18 + (Sum0(r16) + Maj(r16, r14, r15));
        int r25 = r30 + 1;
        long r111 = r17 + (((Sum1(r20) + Ch(r20, r27, r21)) + r29[r30]) + this.W[r30]);
        long r22 = r15 + r111;
        long r26 = r111 + (Sum0(r110) + Maj(r110, r16, r14));
        int r112 = r25 + 1;
        long r28 = r21 + (((Sum1(r22) + Ch(r22, r20, r27)) + r29[r25]) + this.W[r25]);
        long r113 = r14 + r28;
        long r31 = r28 + (Sum0(r26) + Maj(r26, r110, r16));
        int r210 = r112 + 1;
        long r114 = r27 + (((Sum1(r113) + Ch(r113, r22, r20)) + r29[r112]) + this.W[r112]);
        long r32 = r16 + r114;
        long r33 = r114 + (Sum0(r31) + Maj(r31, r26, r110));
        int r115 = r210 + 1;
        long r116 = r20 + (((Sum1(r32) + Ch(r32, r113, r22)) + r29[r210]) + this.W[r210]);
        long r34 = r110 + r116;
        long r35 = r116 + (Sum0(r33) + Maj(r33, r31, r26));
        int r211 = r115 + 1;
        long r117 = r22 + (((Sum1(r34) + Ch(r34, r32, r113)) + r29[r115]) + this.W[r115]);
        long r118 = r26 + r117;
        long r36 = r117 + (Sum0(r35) + Maj(r35, r33, r31));
        r17 = r118;
        int r119 = r211 + 1;
        long r120 = r113 + (((Sum1(r118) + Ch(r118, r34, r32)) + r29[r211]) + this.W[r211]);
        long r37 = r31 + r120;
        r21 = r37;
        r14 = r120 + (Sum0(r36) + Maj(r36, r35, r33));
        long r121 = r32 + (((Sum1(r37) + Ch(r37, r17, r34)) + r29[r119]) + this.W[r119]);
        long r38 = r121 + (Sum0(r14) + Maj(r14, r36, r35));
        r10 = r10 + 1;
        r7 = r33 + r121;
        r15 = r36;
        r12 = r34;
        r19 = r35;
        r23 = r119 + 1;
        r16 = r38;
        goto L8
    L10:
        this.H1 += r16;
        this.H2 += r14;
        this.H3 += r15;
        this.H4 += r19;
        this.H5 = this.H5 + r7;
        this.H6 += r21;
        this.H7 += r17;
        this.H8 += r12;
        this.wOff = 0;
        int r122 = 0;
    L11:
        if (r122 >= 16) goto L13;
        this.W[r122] = 0;
        r122 = r122 + 1;
        goto L11
    }

    public void processLength(long r3, long r5) {
        if (this.wOff <= 14) goto L5;
        processBlock();
    L5:
        long[] r2 = this.W;
        r2[14] = r5;
        r2[15] = r3;
    }

    public void processWord(byte[] r3, int r4) {
        this.W[this.wOff] = Pack.bigEndianToLong(r3, r4);
        int r5 = this.wOff + 1;
        this.wOff = r5;
        if (r5 != 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount1 = 0;
        this.byteCount2 = 0;
        int r2 = 0;
        this.xBufOff = 0;
        int r3 = 0;
    L3:
        byte[] r4 = this.xBuf;
        if (r3 >= r4.length) goto L6;
        r4[r3] = 0;
        r3 = r3 + 1;
        goto L3
    L6:
        this.wOff = 0;
    L7:
        long[] r5 = this.W;
        if (r2 == r5.length) goto L10;
        r5[r2] = 0;
        r2 = r2 + 1;
        goto L7
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r5) {
        byte[] r0 = this.xBuf;
        int r1 = this.xBufOff;
        int r2 = r1 + 1;
        this.xBufOff = r2;
        r0[r1] = r5;
        if (r2 != r0.length) goto L5;
        processWord(r0, 0);
        this.xBufOff = 0;
    L5:
        this.byteCount1++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r6, int r7, int r8) {
    L3:
        if (this.xBufOff == 0) goto L7;
        if (r8 <= 0) goto L7;
        update(r6[r7]);
        r7 = r7 + 1;
        r8 = r8 - 1;
    L7:
        if (r8 < this.xBuf.length) goto L9;
        processWord(r6, r7);
        byte[] r0 = this.xBuf;
        r7 = r7 + r0.length;
        r8 = r8 - r0.length;
        this.byteCount1 += (long) r0.length;
    L9:
        if (r8 <= 0) goto L11;
        update(r6[r7]);
        r7 = r7 + 1;
        r8 = r8 - 1;
        goto L9
    }
}
