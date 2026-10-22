package com.google.common.hash;

import com.google.common.base.n;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
final class Murmur3_32HashFunction extends b implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    static final f GOOD_FAST_HASH_32 = null;
    static final f MURMUR3_32 = null;
    static final f MURMUR3_32_FIXED = null;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;

    private static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4722b;
        private int c;
        private int d;
        private boolean e;

        a(int r1) {
            this.f4721a = r1;
            this.d = 0;
            this.e = false;
        }

        private void update(int r5, long r6) {
            long r0 = this.f4722b;
            int r2 = this.c;
            long r7 = ((r6 & 4294967295L) << r2) | r0;
            this.f4722b = r7;
            int r3 = r2 + (r5 * 8);
            this.c = r3;
            this.d += r5;
            if (r3 < 32) goto L6;
            this.f4721a = Murmur3_32HashFunction.access$100(this.f4721a, Murmur3_32HashFunction.access$000((int) r7));
            this.f4722b >>>= 32;
            this.c -= 32;
            return;
        }

        @Override // com.google.common.hash.g
        public HashCode a() {
            n.b(!this.e);
            this.e = true;
            int r0 = this.f4721a ^ Murmur3_32HashFunction.access$000((int) this.f4722b);
            this.f4721a = r0;
            return Murmur3_32HashFunction.access$600(r0, this.d);
        }

        @Override // com.google.common.hash.g
        public g a(byte r3) {
            update(1, r3 & 255);
            return this;
        }

        @Override // com.google.common.hash.c
        public g a(char r3) {
            update(2, r3);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g
        public g a(int r3) {
            update(4, r3);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g
        public g a(long r4) {
            update(4, (int) r4);
            update(4, r4 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g
        public g a(CharSequence r10, Charset r11) {
            CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
            if (com.google.common.base.c.c.equals(r11) == false) goto L35;
            int r0 = r12.length();
            int r1 = 0;
        L5:
            int r2 = r1 + 4;
            if (r2 > r0) goto L13;
            char r5 = r12.charAt(r1);
            char r6 = r12.charAt(r1 + 1);
            char r7 = r12.charAt(r1 + 2);
            char r8 = r12.charAt(r1 + 3);
            if (r5 >= 128) goto L13;
            if (r6 >= 128) goto L13;
            if (r7 >= 128) goto L13;
            if (r8 >= 128) goto L13;
            update(4, (((r6 << '\b') | r5) | (r7 << 16)) | (r8 << 24));
            r1 = r2;
        L13:
            if (r1 >= r0) goto L33;
            char r3 = r12.charAt(r1);
            if (r3 >= 128) goto L18;
            update(1, r3);
        L32:
            r1 = r1 + 1;
            goto L13
        L18:
            if (r3 >= 2048) goto L22;
            long r9 = Murmur3_32HashFunction.access$300(r3);
            int r4 = 2;
        L20:
            update(r4, r9);
            goto L32
        L22:
            if (r3 >= 55296) goto L24;
        L31:
            r9 = Murmur3_32HashFunction.access$400(r3);
            r4 = 3;
            goto L20
        L24:
            if (r3 > 57343) goto L31;
            int r13 = Character.codePointAt(r12, r1);
            if (r13 == r3) goto L28;
            r1 = r1 + 1;
            update(4, Murmur3_32HashFunction.access$500(r13));
            goto L32
        L28:
            a(r12.subSequence(r1, r0).toString().getBytes(r11));
            return this;
        L33:
            return this;
        L35:
            return super.a(r12, r11);
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g
        public g a(ByteBuffer r4) {
            ByteOrder r0 = r4.order();
            r4.order(ByteOrder.LITTLE_ENDIAN);
        L4:
            if (r4.remaining() < 4) goto L7;
            a(r4.getInt());
        L7:
            if (r4.hasRemaining() == false) goto L9;
            a(r4.get());
            goto L7
        L9:
            r4.order(r0);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g
        public g a(byte[] r5, int r6, int r7) {
            n.a(r6, r6 + r7, r5.length);
            int r0 = 0;
        L3:
            int r1 = r0 + 4;
            if (r1 > r7) goto L6;
            update(4, Murmur3_32HashFunction.access$200(r5, r0 + r6));
            r0 = r1;
        L6:
            if (r0 >= r7) goto L8;
            a(r5[r6 + r0]);
            r0 = r0 + 1;
            goto L6
        L8:
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
        public /* synthetic */ k b(int r1) {
            return a(r1);
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
        public /* synthetic */ k b(long r1) {
            return a(r1);
        }

        @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
        public /* synthetic */ k b(CharSequence r3, Charset r4) {
            return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static {
        MURMUR3_32 = new Murmur3_32HashFunction(0, false);
        MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
        GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.f4713a, true);
    }

    Murmur3_32HashFunction(int r1, boolean r2) {
        this.seed = r1;
        this.supplementaryPlaneFix = r2;
    }

    static /* synthetic */ int access$000(int r0) {
        return mixK1(r0);
    }

    static /* synthetic */ int access$100(int r0, int r1) {
        return mixH1(r0, r1);
    }

    static /* synthetic */ int access$200(byte[] r0, int r1) {
        return getIntLittleEndian(r0, r1);
    }

    static /* synthetic */ long access$300(char r2) {
        return charToTwoUtf8Bytes(r2);
    }

    static /* synthetic */ long access$400(char r2) {
        return charToThreeUtf8Bytes(r2);
    }

    static /* synthetic */ long access$500(int r2) {
        return codePointToFourUtf8Bytes(r2);
    }

    static /* synthetic */ HashCode access$600(int r0, int r1) {
        return fmix(r0, r1);
    }

    private static long charToThreeUtf8Bytes(char r4) {
        return ((((long) (r4 >>> '\f')) | 224) | ((long) ((((r4 >>> 6) & 63) | 128) << 8))) | ((long) (((r4 & '?') | 128) << 16));
    }

    private static long charToTwoUtf8Bytes(char r4) {
        return (((long) (r4 >>> 6)) | 192) | ((long) (((r4 & '?') | 128) << 8));
    }

    private static long codePointToFourUtf8Bytes(int r7) {
        return (((((long) (r7 >>> 18)) | 240) | ((((long) ((r7 >>> 12) & 63)) | 128) << 8)) | ((((long) ((r7 >>> 6) & 63)) | 128) << 16)) | ((((long) (r7 & 63)) | 128) << 24);
    }

    private static HashCode fmix(int r0, int r1) {
        int r2 = r0 ^ r1;
        int r3 = (r2 ^ (r2 >>> 16)) * (-2048144789);
        int r4 = (r3 ^ (r3 >>> 13)) * (-1028477387);
        return HashCode.fromInt(r4 ^ (r4 >>> 16));
    }

    private static int getIntLittleEndian(byte[] r3, int r4) {
        return Ints.a(r3[r4 + 3], r3[r4 + 2], r3[r4 + 1], r3[r4]);
    }

    private static int mixH1(int r0, int r1) {
        return (Integer.rotateLeft(r0 ^ r1, 13) * 5) - 430675100;
    }

    private static int mixK1(int r1) {
        return Integer.rotateLeft(r1 * (-862048943), 15) * C2;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Murmur3_32HashFunction.class) == false) goto L10;
        Murmur3_32HashFunction r5 = (Murmur3_32HashFunction) ZeusTransformUtils.preCheckCast(r4, Murmur3_32HashFunction.class, "com.obric.memorydata.plugin");
        if (this.seed == r5.seed) goto L7;
        return false;
    L7:
        if (this.supplementaryPlaneFix != r5.supplementaryPlaneFix) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.google.common.hash.b
    public HashCode hashBytes(byte[] r5, int r6, int r7) {
        n.a(r6, r6 + r7, r5.length);
        int r4 = this.seed;
        int r0 = 0;
        int r1 = 0;
    L3:
        int r2 = r1 + 4;
        if (r2 > r7) goto L6;
        r4 = mixH1(r4, mixK1(getIntLittleEndian(r5, r1 + r6)));
        r1 = r2;
        goto L3
    L6:
        int r3 = r1;
        int r8 = 0;
    L7:
        if (r3 >= r7) goto L10;
        r0 = r0 ^ (UnsignedBytes.a(r5[r6 + r3]) << r8);
        r3 = r3 + 1;
        r8 = r8 + 8;
        goto L7
    L10:
        return fmix(r4 ^ mixK1(r0), r7);
    }

    public int hashCode() {
        int r0 = getClass().hashCode();
        return this.seed ^ r0;
    }

    @Override // com.google.common.hash.b
    public HashCode hashInt(int r1) {
        int r2 = mixK1(r1);
        return fmix(mixH1(this.seed, r2), 4);
    }

    @Override // com.google.common.hash.b
    public HashCode hashLong(long r3) {
        int r0 = (int) r3;
        int r4 = mixK1(r0);
        return fmix(mixH1(mixH1(this.seed, r4), mixK1((int) (r3 >>> 32))), 8);
    }

    @Override // com.google.common.hash.b
    public HashCode hashString(CharSequence r12, Charset r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (com.google.common.base.c.c.equals(r13) == false) goto L42;
        int r0 = r14.length();
        int r1 = this.seed;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L5:
        int r5 = r3 + 4;
        if (r5 > r0) goto L13;
        char r7 = r14.charAt(r3);
        char r8 = r14.charAt(r3 + 1);
        char r9 = r14.charAt(r3 + 2);
        char r10 = r14.charAt(r3 + 3);
        if (r7 >= 128) goto L13;
        if (r8 >= 128) goto L13;
        if (r9 >= 128) goto L13;
        if (r10 >= 128) goto L13;
        r1 = mixH1(r1, mixK1((((r8 << '\b') | r7) | (r9 << 16)) | (r10 << 24)));
        r4 = r4 + 4;
        r3 = r5;
    L13:
        long r11 = 0;
    L14:
        if (r3 >= r0) goto L40;
        char r6 = r14.charAt(r3);
        if (r6 >= 128) goto L19;
        r11 = r11 | (((long) r6) << r2);
        r2 = r2 + 8;
        r4 = r4 + 1;
    L36:
        if (r2 < 32) goto L38;
        r1 = mixH1(r1, mixK1((int) r11));
        r11 = r11 >>> 32;
        r2 = r2 - 32;
    L38:
        r3 = r3 + 1;
        goto L14
    L19:
        if (r6 >= 2048) goto L22;
        r11 = r11 | (charToTwoUtf8Bytes(r6) << r2);
        r2 = r2 + 16;
        r4 = r4 + 2;
        goto L36
    L22:
        if (r6 >= 55296) goto L24;
    L34:
        r11 = r11 | (charToThreeUtf8Bytes(r6) << r2);
        r2 = r2 + 24;
        r4 = r4 + 3;
        goto L36
    L24:
        if (r6 > 57343) goto L34;
        int r15 = Character.codePointAt(r14, r3);
        if (r15 == r6) goto L29;
        r3 = r3 + 1;
        r11 = r11 | (codePointToFourUtf8Bytes(r15) << r2);
        if (this.supplementaryPlaneFix == false) goto L33;
        r2 = r2 + 32;
    L33:
        r4 = r4 + 4;
        goto L36
    L29:
        return hashBytes(r14.toString().getBytes(r13));
    L40:
        return fmix(mixK1((int) r11) ^ r1, r4);
    L42:
        return hashBytes(r14.toString().getBytes(r13));
    }

    @Override // com.google.common.hash.b
    public HashCode hashUnencodedChars(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r4 = this.seed;
        int r1 = 1;
    L4:
        if (r1 >= r6.length()) goto L7;
        r4 = mixH1(r4, mixK1(r6.charAt(r1 - 1) | (r6.charAt(r1) << 16)));
        r1 = r1 + 2;
        goto L4
    L7:
        if ((r6.length() & 1) != 1) goto L10;
        r4 = r4 ^ mixK1(r6.charAt(r6.length() - 1));
    L10:
        return fmix(r4, r6.length() * 2);
    }

    @Override // com.google.common.hash.f
    public g newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }
}
