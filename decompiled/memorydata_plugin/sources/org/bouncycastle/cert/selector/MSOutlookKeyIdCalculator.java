package org.bouncycastle.cert.selector;

import java.io.IOException;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
class MSOutlookKeyIdCalculator {

    private static abstract class GeneralDigest {
        private long byteCount;
        private byte[] xBuf;
        private int xBufOff;

        public GeneralDigest() {
            this.xBuf = new byte[4];
            this.xBufOff = 0;
        }

        public void finish() {
            long r0 = this.byteCount << 3;
            byte r2 = -128;
        L3:
            update(r2);
            if (this.xBufOff == 0) goto L6;
            r2 = 0;
            goto L3
        L6:
            processLength(r0);
            processBlock();
        }

        public abstract void processBlock();

        public abstract void processLength(long r1);

        public abstract void processWord(byte[] r1, int r2);

        public void reset() {
            this.byteCount = 0;
            this.xBufOff = 0;
            int r1 = 0;
        L3:
            byte[] r2 = this.xBuf;
            if (r1 >= r2.length) goto L6;
            r2[r1] = 0;
            r1 = r1 + 1;
            goto L3
        }

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
            this.byteCount++;
        }

        public void update(byte[] r6, int r7, int r8) {
        L3:
            if (this.xBufOff == 0) goto L7;
            if (r8 <= 0) goto L7;
            update(r6[r7]);
            r7 = r7 + 1;
            r8 = r8 - 1;
        L7:
            if (r8 <= this.xBuf.length) goto L9;
            processWord(r6, r7);
            byte[] r0 = this.xBuf;
            r7 = r7 + r0.length;
            r8 = r8 - r0.length;
            this.byteCount += (long) r0.length;
        L9:
            if (r8 <= 0) goto L11;
            update(r6[r7]);
            r7 = r7 + 1;
            r8 = r8 - 1;
            goto L9
        }
    }

    private static class SHA1Digest extends GeneralDigest {
        private int H1;
        private int H2;
        private int H3;
        private int H4;
        private int H5;
        private int[] X;
        private int xOff;

        public SHA1Digest() {
            this.X = new int[80];
            reset();
        }

        private int f(int r1, int r2, int r3) {
            return (r1 & r2) | ((~r1) & r3);
        }

        private int g(int r1, int r2, int r3) {
            return ((r1 & r2) | (r1 & r3)) | (r2 & r3);
        }

        private int h(int r1, int r2, int r3) {
            return (r1 ^ r2) ^ r3;
        }

        public int doFinal(byte[] r3, int r4) {
            finish();
            Pack.intToBigEndian(this.H1, r3, r4);
            Pack.intToBigEndian(this.H2, r3, r4 + 4);
            Pack.intToBigEndian(this.H3, r3, r4 + 8);
            Pack.intToBigEndian(this.H4, r3, r4 + 12);
            Pack.intToBigEndian(this.H5, r3, r4 + 16);
            reset();
            return 20;
        }

        public int getDigestSize() {
            return 20;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void processBlock() {
            int r1 = 16;
        L4:
            if (r1 >= 80) goto L6;
            int[] r2 = this.X;
            int r3 = ((r2[r1 - 3] ^ r2[r1 - 8]) ^ r2[r1 - 14]) ^ r2[r1 - 16];
            r2[r1] = (r3 >>> 31) | (r3 << 1);
            r1 = r1 + 1;
            goto L4
        L6:
            int r4 = this.H1;
            int r5 = this.H2;
            int r6 = this.H3;
            int r7 = this.H4;
            int r8 = this.H5;
            int r9 = 0;
            int r10 = 0;
        L8:
            if (r9 >= 4) goto L10;
            int r11 = r10 + 1;
            int r12 = r8 + (((((r4 << 5) | (r4 >>> 27)) + f(r5, r6, r7)) + this.X[r10]) + 1518500249);
            int r13 = (r5 >>> 2) | (r5 << 30);
            int r14 = r11 + 1;
            int r15 = r7 + (((((r12 << 5) | (r12 >>> 27)) + f(r4, r13, r6)) + this.X[r11]) + 1518500249);
            int r16 = (r4 >>> 2) | (r4 << 30);
            int r17 = r14 + 1;
            int r18 = r6 + (((((r15 << 5) | (r15 >>> 27)) + f(r12, r16, r13)) + this.X[r14]) + 1518500249);
            r8 = (r12 >>> 2) | (r12 << 30);
            int r19 = r17 + 1;
            r5 = r13 + (((((r18 << 5) | (r18 >>> 27)) + f(r15, r8, r16)) + this.X[r17]) + 1518500249);
            r7 = (r15 >>> 2) | (r15 << 30);
            r4 = r16 + (((((r5 << 5) | (r5 >>> 27)) + f(r18, r7, r8)) + this.X[r19]) + 1518500249);
            r6 = (r18 >>> 2) | (r18 << 30);
            r9 = r9 + 1;
            r10 = r19 + 1;
            goto L8
        L10:
            int r20 = 0;
        L11:
            if (r20 >= 4) goto L13;
            int r110 = r10 + 1;
            int r21 = r8 + (((((r4 << 5) | (r4 >>> 27)) + h(r5, r6, r7)) + this.X[r10]) + 1859775393);
            int r22 = (r5 >>> 2) | (r5 << 30);
            int r111 = r110 + 1;
            int r23 = r7 + (((((r21 << 5) | (r21 >>> 27)) + h(r4, r22, r6)) + this.X[r110]) + 1859775393);
            int r24 = (r4 >>> 2) | (r4 << 30);
            int r112 = r111 + 1;
            int r25 = r6 + (((((r23 << 5) | (r23 >>> 27)) + h(r21, r24, r22)) + this.X[r111]) + 1859775393);
            r8 = (r21 >>> 2) | (r21 << 30);
            int r113 = r112 + 1;
            r5 = r22 + (((((r25 << 5) | (r25 >>> 27)) + h(r23, r8, r24)) + this.X[r112]) + 1859775393);
            r7 = (r23 >>> 2) | (r23 << 30);
            r4 = r24 + (((((r5 << 5) | (r5 >>> 27)) + h(r25, r7, r8)) + this.X[r113]) + 1859775393);
            r6 = (r25 >>> 2) | (r25 << 30);
            r20 = r20 + 1;
            r10 = r113 + 1;
            goto L11
        L13:
            int r26 = 0;
        L14:
            if (r26 >= 4) goto L16;
            int r114 = r10 + 1;
            int r27 = r8 + (((((r4 << 5) | (r4 >>> 27)) + g(r5, r6, r7)) + this.X[r10]) - 1894007588);
            int r28 = (r5 >>> 2) | (r5 << 30);
            int r115 = r114 + 1;
            int r29 = r7 + (((((r27 << 5) | (r27 >>> 27)) + g(r4, r28, r6)) + this.X[r114]) - 1894007588);
            int r30 = (r4 >>> 2) | (r4 << 30);
            int r116 = r115 + 1;
            int r31 = r6 + (((((r29 << 5) | (r29 >>> 27)) + g(r27, r30, r28)) + this.X[r115]) - 1894007588);
            r8 = (r27 >>> 2) | (r27 << 30);
            int r117 = r116 + 1;
            r5 = r28 + (((((r31 << 5) | (r31 >>> 27)) + g(r29, r8, r30)) + this.X[r116]) - 1894007588);
            r7 = (r29 >>> 2) | (r29 << 30);
            r4 = r30 + (((((r5 << 5) | (r5 >>> 27)) + g(r31, r7, r8)) + this.X[r117]) - 1894007588);
            r6 = (r31 >>> 2) | (r31 << 30);
            r26 = r26 + 1;
            r10 = r117 + 1;
            goto L14
        L16:
            int r32 = 0;
        L18:
            if (r32 > 3) goto L20;
            int r118 = r10 + 1;
            int r33 = r8 + (((((r4 << 5) | (r4 >>> 27)) + h(r5, r6, r7)) + this.X[r10]) - 899497514);
            int r34 = (r5 >>> 2) | (r5 << 30);
            int r119 = r118 + 1;
            int r35 = r7 + (((((r33 << 5) | (r33 >>> 27)) + h(r4, r34, r6)) + this.X[r118]) - 899497514);
            int r36 = (r4 >>> 2) | (r4 << 30);
            int r120 = r119 + 1;
            int r37 = r6 + (((((r35 << 5) | (r35 >>> 27)) + h(r33, r36, r34)) + this.X[r119]) - 899497514);
            r8 = (r33 >>> 2) | (r33 << 30);
            int r121 = r120 + 1;
            r5 = r34 + (((((r37 << 5) | (r37 >>> 27)) + h(r35, r8, r36)) + this.X[r120]) - 899497514);
            r7 = (r35 >>> 2) | (r35 << 30);
            r4 = r36 + (((((r5 << 5) | (r5 >>> 27)) + h(r37, r7, r8)) + this.X[r121]) - 899497514);
            r6 = (r37 >>> 2) | (r37 << 30);
            r32 = r32 + 1;
            r10 = r121 + 1;
            goto L18
        L20:
            this.H1 += r4;
            this.H2 += r5;
            this.H3 += r6;
            this.H4 += r7;
            this.H5 += r8;
            this.xOff = 0;
            int r38 = 0;
        L21:
            if (r38 >= 16) goto L23;
            this.X[r38] = 0;
            r38 = r38 + 1;
            goto L21
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void processLength(long r5) {
            if (this.xOff <= 14) goto L5;
            processBlock();
        L5:
            int[] r4 = this.X;
            r4[14] = (int) (r5 >>> 32);
            r4[15] = (int) (r5 & (-1));
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void processWord(byte[] r4, int r5) {
            int r0 = r4[r5] << 24;
            int r6 = r5 + 1;
            int r1 = r0 | ((r4[r6] & 255) << 16);
            int r7 = r6 + 1;
            int r2 = r1 | ((r4[r7] & 255) << 8);
            int r8 = (r4[r7 + 1] & 255) | r2;
            int[] r9 = this.X;
            int r3 = this.xOff;
            r9[r3] = r8;
            int r10 = r3 + 1;
            this.xOff = r10;
            if (r10 != 16) goto L6;
            processBlock();
            return;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void reset() {
            super.reset();
            this.H1 = 1732584193;
            this.H2 = -271733879;
            this.H3 = -1732584194;
            this.H4 = 271733878;
            this.H5 = -1009589776;
            this.xOff = 0;
            int r1 = 0;
        L3:
            int[] r2 = this.X;
            if (r1 == r2.length) goto L6;
            r2[r1] = 0;
            r1 = r1 + 1;
            goto L3
        }
    }

    static byte[] calculateKeyId(SubjectPublicKeyInfo r4) {
        SHA1Digest r0 = new SHA1Digest();
        byte[] r1 = new byte[r0.getDigestSize()];
        byte[] r5 = r4.getEncoded("DER");     // Catch: IOException -> L6
        r0.update(r5, 0, r5.length);
        r0.doFinal(r1, 0);
        return r1;
    L7:
        return new byte[0];
    }
}
