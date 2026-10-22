package com.google.common.hash;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class SipHashFunction extends b implements Serializable {
    static final f SIP_HASH_24 = null;
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    private static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4724b;
        private long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;

        a(int r12, int r13, long r14, long r16) {
            super(8);
            this.c = 8317987319222330741L;
            this.d = 7237128888997146477L;
            this.e = 7816392313619706465L;
            this.f = 8387220255154660723L;
            this.g = 0;
            this.h = 0;
            this.f4723a = r12;
            this.f4724b = r13;
            this.c = 8317987319222330741L ^ r14;
            this.d = 7237128888997146477L ^ r16;
            this.e = 7816392313619706465L ^ r14;
            this.f = 8387220255154660723L ^ r16;
        }

        private void c(int r9) {
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L5;
            long r1 = this.c;
            long r3 = this.d;
            this.c = r1 + r3;
            this.e += this.f;
            this.d = Long.rotateLeft(r3, 13);
            long r2 = Long.rotateLeft(this.f, 16);
            this.f = r2;
            long r4 = this.d;
            long r5 = this.c;
            this.d = r4 ^ r5;
            this.f = r2 ^ this.e;
            long r6 = Long.rotateLeft(r5, 32);
            this.c = r6;
            long r7 = this.e;
            long r8 = this.d;
            this.e = r7 + r8;
            this.c = r6 + this.f;
            this.d = Long.rotateLeft(r8, 17);
            long r10 = Long.rotateLeft(this.f, 21);
            this.f = r10;
            long r11 = this.d;
            long r12 = this.e;
            this.d = r11 ^ r12;
            this.f = r10 ^ this.c;
            this.e = Long.rotateLeft(r12, 32);
            r0 = r0 + 1;
            goto L3
        }

        private void c(long r3) {
            this.f ^= r3;
            c(this.f4723a);
            this.c = r3 ^ this.c;
        }

        @Override // com.google.common.hash.d
        public HashCode b() {
            long r0 = this.h ^ (this.g << 56);
            this.h = r0;
            c(r0);
            this.e ^= 255;
            c(this.f4724b);
            return HashCode.fromLong(((this.c ^ this.d) ^ this.e) ^ this.f);
        }

        @Override // com.google.common.hash.d
        public void b(ByteBuffer r5) {
            this.g += 8;
            c(r5.getLong());
        }

        @Override // com.google.common.hash.d
        public void c(ByteBuffer r8) {
            this.g += (long) r8.remaining();
            int r0 = 0;
        L4:
            if (r8.hasRemaining() == false) goto L6;
            this.h ^= (((long) r8.get()) & 255) << r0;
            r0 = r0 + 8;
            goto L4
        }
    }

    static {
        SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    }

    SipHashFunction(int r5, int r6, long r7, long r9) {
        boolean r0 = true;
        if (r5 <= 0) goto L5;
        boolean r2 = true;
    L6:
        n.a(r2, "The number of SipRound iterations (c=%s) during Compression must be positive.", r5);
        if (r6 > 0) goto L10;
        r0 = false;
    L10:
        n.a(r0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", r6);
        this.c = r5;
        this.d = r6;
        this.k0 = r7;
        this.k1 = r9;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, SipHashFunction.class) == false) goto L14;
        SipHashFunction r7 = (SipHashFunction) ZeusTransformUtils.preCheckCast(r6, SipHashFunction.class, "com.obric.memorydata.plugin");
        if (this.c == r7.c) goto L7;
        return false;
    L7:
        if (this.d == r7.d) goto L9;
        return false;
    L9:
        if (this.k0 == r7.k0) goto L11;
        return false;
    L11:
        if (this.k1 != r7.k1) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.c) ^ this.d)) ^ this.k0) ^ this.k1);
    }

    @Override // com.google.common.hash.f
    public g newHasher() {
        return new a(this.c, this.d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.c + "" + this.d + "(" + this.k0 + ", " + this.k1 + ")";
    }
}
