package com.google.common.hash;

import com.google.common.base.n;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
abstract enum BloomFilterStrategies extends Enum<BloomFilterStrategies> implements BloomFilter.Strategy {
    private static final /* synthetic */ BloomFilterStrategies[] $VALUES = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_32 = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_64 = null;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicLongArray f4709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j f4710b;

        a(long r5) {
            if (r5 <= 0) goto L5;
            boolean r0 = true;
        L6:
            n.a(r0, "data length is zero!");
            this.f4709a = new AtomicLongArray(Ints.a(LongMath.a(r5, 64, RoundingMode.CEILING)));
            this.f4710b = LongAddables.a();
            return;
        L5:
            r0 = false;
            goto L6
        }

        a(long[] r7) {
            int r1 = 0;
            if (r7.length <= 0) goto L5;
            boolean r0 = true;
        L6:
            n.a(r0, "data length is zero!");
            this.f4709a = new AtomicLongArray(r7);
            this.f4710b = LongAddables.a();
            long r2 = 0;
            int r3 = r7.length;
        L7:
            if (r1 >= r3) goto L9;
            r2 = r2 + ((long) Long.bitCount(r7[r1]));
            r1 = r1 + 1;
            goto L7
        L9:
            this.f4710b.add(r2);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public static long[] a(AtomicLongArray r5) {
            int r0 = r5.length();
            long[] r1 = new long[r0];
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1[r2] = r5.get(r2);
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        long a() {
            return ((long) this.f4709a.length()) * 64;
        }

        void a(int r12, long r13) {
        L2:
            long r7 = this.f4709a.get(r12);
            long r9 = r7 | r13;
            if (r7 == r9) goto L4;
            if (this.f4709a.compareAndSet(r12, r7, r9) == false) goto L2;
            boolean r14 = true;
        L8:
            if (r14 == false) goto L14;
            this.f4710b.add(Long.bitCount(r9) - Long.bitCount(r7));
            return;
        L14:
            return;
        L4:
            r14 = false;
            goto L8
        }

        void a(a r6) {
            int r2 = 0;
            if (this.f4709a.length() != r6.f4709a.length()) goto L5;
            boolean r0 = true;
        L6:
            n.a(r0, "BitArrays must be of equal length (%s != %s)", this.f4709a.length(), r6.f4709a.length());
        L8:
            if (r2 >= this.f4709a.length()) goto L10;
            a(r2, r6.f4709a.get(r2));
            r2 = r2 + 1;
            goto L8
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        boolean a(long r11) {
            if (b(r11) == false) goto L5;
            return false;
        L5:
            int r0 = (int) (r11 >>> 6);
            long r12 = 1 << ((int) r11);
        L6:
            long r6 = this.f4709a.get(r0);
            long r8 = r6 | r12;
            if (r6 == r8) goto L8;
            if (this.f4709a.compareAndSet(r0, r6, r8) == false) goto L6;
            this.f4710b.increment();
            return true;
        L8:
            return false;
        }

        long b() {
            return this.f4710b.sum();
        }

        boolean b(long r3) {
            long r0 = this.f4709a.get((int) (r3 >>> 6));
            if (((1 << ((int) r3)) & r0) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        a c() {
            return new a(a(this.f4709a));
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L6;
            a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
            return Arrays.equals(a(this.f4709a), a(r4.f4709a));
        L6:
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(a(this.f4709a));
        }
    }

    private static /* synthetic */ BloomFilterStrategies[] $values() {
        return new BloomFilterStrategies[]{MURMUR128_MITZ_32, MURMUR128_MITZ_64};
    }

    static {
        final String r1 = "MURMUR128_MITZ_32";
        final int r2 = 0;
        MURMUR128_MITZ_32 = new AnonymousClass1(r1, r2);
        final String r3 = "MURMUR128_MITZ_64";
        final int r4 = 1;
        MURMUR128_MITZ_64 = new AnonymousClass2(r3, r4);
        $VALUES = $values();
    }

    private BloomFilterStrategies(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ BloomFilterStrategies(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static BloomFilterStrategies valueOf(String r2) {
        return (BloomFilterStrategies) ZeusTransformUtils.preCheckCast(Enum.valueOf(BloomFilterStrategies.class, r2), BloomFilterStrategies.class, "com.obric.memorydata.plugin");
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BloomFilterStrategies[].class, "com.obric.memorydata.plugin");
    }
}
