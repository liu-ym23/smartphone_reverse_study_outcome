package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
final class Murmur3_128HashFunction extends b implements Serializable {
    static final f GOOD_FAST_HASH_128 = null;
    static final f MURMUR3_128 = null;
    private static final long serialVersionUID = 0;
    private final int seed;

    private static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4720b;
        private int c;

        a(int r3) {
            super(16);
            long r0 = r3;
            this.f4719a = r0;
            this.f4720b = r0;
            this.c = 0;
        }

        private void a(long r7, long r9) {
            long r0 = this.f4719a;
            long r8 = d(r7) ^ r0;
            this.f4719a = r8;
            long r10 = Long.rotateLeft(r8, 27);
            this.f4719a = r10;
            long r1 = this.f4720b;
            long r11 = r10 + r1;
            this.f4719a = r11;
            this.f4719a = (r11 * 5) + 1390208809;
            long r12 = e(r9) ^ r1;
            this.f4720b = r12;
            long r13 = Long.rotateLeft(r12, 31);
            this.f4720b = r13;
            long r14 = r13 + this.f4719a;
            this.f4720b = r14;
            this.f4720b = (r14 * 5) + 944331445;
        }

        private static long c(long r3) {
            long r4 = (r3 ^ (r3 >>> 33)) * (-49064778989728563L);
            long r5 = (r4 ^ (r4 >>> 33)) * (-4265267296055464877L);
            return r5 ^ (r5 >>> 33);
        }

        private static long d(long r2) {
            return Long.rotateLeft(r2 * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long e(long r2) {
            return Long.rotateLeft(r2 * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.d
        public HashCode b() {
            long r0 = this.f4719a;
            int r2 = this.c;
            long r1 = r0 ^ ((long) r2);
            this.f4719a = r1;
            long r3 = this.f4720b ^ ((long) r2);
            this.f4720b = r3;
            long r4 = r1 + r3;
            this.f4719a = r4;
            this.f4720b = r3 + r4;
            this.f4719a = c(r4);
            long r5 = c(this.f4720b);
            this.f4720b = r5;
            long r6 = this.f4719a + r5;
            this.f4719a = r6;
            this.f4720b = r5 + r6;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f4719a).putLong(this.f4720b).array());
        }

        @Override // com.google.common.hash.d
        public void b(ByteBuffer r5) {
            a(r5.getLong(), r5.getLong());
            this.c += 16;
        }

        @Override // com.google.common.hash.d
        public void c(ByteBuffer r12) {
            this.c += r12.remaining();
            long r6 = 0;
            switch(r12.remaining()) {
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L19;
                case 9: goto L17;
                case 10: goto L15;
                case 11: goto L13;
                case 12: goto L11;
                case 13: goto L9;
                case 14: goto L7;
                case 15: goto L6;
                default: goto L5;
            };
        L6:
            long r0 = (((long) UnsignedBytes.a(r12.get(14))) << 48) ^ 0;
        L8:
            long r1 = r0 ^ (((long) UnsignedBytes.a(r12.get(13))) << 40);
        L10:
            long r2 = r1 ^ (((long) UnsignedBytes.a(r12.get(12))) << 32);
        L12:
            long r3 = r2 ^ (((long) UnsignedBytes.a(r12.get(11))) << 24);
        L14:
            long r4 = r3 ^ (((long) UnsignedBytes.a(r12.get(10))) << 16);
        L16:
            long r5 = r4 ^ (((long) UnsignedBytes.a(r12.get(9))) << 8);
        L18:
            long r7 = r5 ^ ((long) UnsignedBytes.a(r12.get(8)));
        L20:
            long r8 = r12.getLong() ^ 0;
            r6 = r7;
        L34:
            this.f4719a ^= d(r8);
            this.f4720b ^= e(r6);
            return;
        L7:
            r0 = 0;
            goto L8
        L9:
            r1 = 0;
            goto L10
        L11:
            r2 = 0;
            goto L12
        L13:
            r3 = 0;
            goto L14
        L15:
            r4 = 0;
            goto L16
        L17:
            r5 = 0;
            goto L18
        L19:
            r7 = 0;
            goto L20
        L21:
            long r9 = (((long) UnsignedBytes.a(r12.get(6))) << 48) ^ 0;
        L23:
            long r10 = r9 ^ (((long) UnsignedBytes.a(r12.get(5))) << 40);
        L25:
            long r11 = r10 ^ (((long) UnsignedBytes.a(r12.get(4))) << 32);
        L27:
            long r13 = r11 ^ (((long) UnsignedBytes.a(r12.get(3))) << 24);
        L29:
            long r14 = r13 ^ (((long) UnsignedBytes.a(r12.get(2))) << 16);
        L31:
            long r15 = r14 ^ (((long) UnsignedBytes.a(r12.get(1))) << 8);
        L33:
            r8 = ((long) UnsignedBytes.a(r12.get(0))) ^ r15;
            goto L34
        L22:
            r9 = 0;
            goto L23
        L24:
            r10 = 0;
            goto L25
        L26:
            r11 = 0;
            goto L27
        L28:
            r13 = 0;
            goto L29
        L30:
            r14 = 0;
            goto L31
        L32:
            r15 = 0;
            goto L33
        L5:
            throw new AssertionError("Should never get here.");
        }
    }

    static {
        MURMUR3_128 = new Murmur3_128HashFunction(0);
        GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.f4713a);
    }

    Murmur3_128HashFunction(int r1) {
        this.seed = r1;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Murmur3_128HashFunction.class) == false) goto L8;
        Murmur3_128HashFunction r5 = (Murmur3_128HashFunction) ZeusTransformUtils.preCheckCast(r4, Murmur3_128HashFunction.class, "com.obric.memorydata.plugin");
        if (this.seed != r5.seed) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public int hashCode() {
        int r0 = getClass().hashCode();
        return this.seed ^ r0;
    }

    @Override // com.google.common.hash.f
    public g newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }
}
