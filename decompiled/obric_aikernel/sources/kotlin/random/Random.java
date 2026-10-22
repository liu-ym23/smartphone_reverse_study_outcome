package kotlin.random;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
public abstract class Random {
    public static final Default Default = null;
    private static final Random defaultRandom = null;

    public static final class Default extends Random implements Serializable {

        private static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = null;
            private static final long serialVersionUID = 0;

            static {
                INSTANCE = new Serialized();
            }

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker r10) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int r10) {
            return Random.access$getDefaultRandom$cp().nextBits(r10);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.access$getDefaultRandom$cp().nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int r10) {
            return Random.access$getDefaultRandom$cp().nextBytes(r10);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r10) {
            Intrinsics.checkNotNullParameter(r10, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r10);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r10, r11, r12);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.access$getDefaultRandom$cp().nextDouble();
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r10) {
            return Random.access$getDefaultRandom$cp().nextDouble(r10);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r10, double r11) {
            return Random.access$getDefaultRandom$cp().nextDouble(r10, r11);
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.access$getDefaultRandom$cp().nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.access$getDefaultRandom$cp().nextInt();
        }

        @Override // kotlin.random.Random
        public int nextInt(int r10) {
            return Random.access$getDefaultRandom$cp().nextInt(r10);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r10, int r11) {
            return Random.access$getDefaultRandom$cp().nextInt(r10, r11);
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.access$getDefaultRandom$cp().nextLong();
        }

        @Override // kotlin.random.Random
        public long nextLong(long r10) {
            return Random.access$getDefaultRandom$cp().nextLong(r10);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r10, long r11) {
            return Random.access$getDefaultRandom$cp().nextLong(r10, r11);
        }
    }

    static {
        Default = new Default(null);
        defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public Random() {
    }

    public static final /* synthetic */ Random access$getDefaultRandom$cp() {
        return defaultRandom;
    }

    public static /* synthetic */ byte[] nextBytes$default(Random r10, byte[] r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = r11.length;
    L10:
        return r10.nextBytes(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int r10);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public byte[] nextBytes(int r10) {
        return nextBytes(new byte[r10]);
    }

    public byte[] nextBytes(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return nextBytes(r10, 0, r10.length);
    }

    public byte[] nextBytes(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "array");
        int r13 = 0;
        boolean r14 = true;
        if (new IntRange(0, r10.length).contains(r11) == true) goto L5;
    L7:
        boolean r15 = false;
    L9:
        if (r15 == false) goto L24;
        if (r11 <= r12) goto L13;
        r14 = false;
    L13:
        if (r14 == false) goto L22;
        int r16 = (r12 - r11) / 4;
        int r17 = 0;
    L15:
        if (r17 >= r16) goto L17;
        int r18 = nextInt();
        r10[r11] = (byte) r18;
        r10[r11 + 1] = (byte) (r18 >>> 8);
        r10[r11 + 2] = (byte) (r18 >>> 16);
        r10[r11 + 3] = (byte) (r18 >>> 24);
        r11 = r11 + 4;
        r17 = r17 + 1;
        goto L15
    L17:
        int r19 = r12 - r11;
        int r20 = nextBits(r19 * 8);
    L18:
        if (r13 >= r19) goto L20;
        r10[r11 + r13] = (byte) (r20 >>> (r13 * 8));
        r13 = r13 + 1;
        goto L18
    L20:
        return r10;
    L22:
        throw new IllegalArgumentException(("fromIndex (" + r11 + ") must be not greater than toIndex (" + r12 + ").").toString());
    L24:
        throw new IllegalArgumentException(("fromIndex (" + r11 + ") or toIndex (" + r12 + ") are out of range: 0.." + r10.length + '.').toString());
    L5:
        if (new IntRange(0, r10.length).contains(r12) == false) goto L7;
        r15 = true;
        goto L9
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public double nextDouble(double r10) {
        return nextDouble(0.0d, r10);
    }

    public double nextDouble(double r10, double r11) {
        RandomKt.checkRangeBounds(r10, r11);
        double r12 = r11 - r10;
        if (Double.isInfinite(r12) == false) goto L19;
        boolean r13 = true;
        if (Double.isInfinite(r10) == false) goto L7;
    L9:
        boolean r14 = false;
    L10:
        if (r14 == false) goto L19;
        if (Double.isInfinite(r11) == false) goto L14;
    L16:
        r13 = false;
    L17:
        if (r13 == false) goto L19;
        double r15 = 2;
        double r16 = nextDouble() * ((r11 / r15) - (r10 / r15));
        double r17 = (r10 + r16) + r16;
    L21:
        if (r17 >= r11) goto L23;
        return r17;
    L23:
        return Math.nextAfter(r11, Double.NEGATIVE_INFINITY);
    L14:
        if (Double.isNaN(r11) == true) goto L16;
    L7:
        if (Double.isNaN(r10) == true) goto L9;
        r14 = true;
    L19:
        r17 = r10 + (nextDouble() * r12);
        goto L21
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int r10) {
        return nextInt(0, r10);
    }

    public int nextInt(int r10, int r11) {
        RandomKt.checkRangeBounds(r10, r11);
        int r12 = r11 - r10;
        if (r12 > 0) goto L14;
        if (r12 == Integer.MIN_VALUE) goto L14;
    L7:
        int r13 = nextInt();
        boolean r14 = false;
        if (r10 > r13) goto L11;
        if (r13 >= r11) goto L11;
        r14 = true;
    L11:
        if (r14 == false) goto L7;
        return r13;
    L14:
        if (((-r12) & r12) != r12) goto L16;
        int r15 = nextBits(RandomKt.fastLog2(r12));
    L20:
        return r10 + r15;
    L16:
        int r16 = nextInt() >>> 1;
        int r17 = r16 % r12;
        if (((r16 - r17) + (r12 - 1)) < 0) goto L16;
        r15 = r17;
        goto L20
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public long nextLong(long r10) {
        return nextLong(0, r10);
    }

    public long nextLong(long r11, long r13) {
        RandomKt.checkRangeBounds(r11, r13);
        long r10 = r13 - r11;
        if (r10 > 0) goto L5;
    L18:
        long r12 = nextLong();
        boolean r14 = false;
        if (r11 > r12) goto L23;
        if (r12 >= r13) goto L23;
        r14 = true;
    L23:
        if (r14 == false) goto L18;
        return r12;
    L5:
        if (((-r10) & r10) != r10) goto L13;
        int r15 = (int) r10;
        int r16 = (int) (r10 >>> 32);
        if (r15 == 0) goto L10;
        int r17 = nextBits(RandomKt.fastLog2(r15));
    L9:
        long r18 = ((long) r17) & 4294967295L;
    L17:
        return r11 + r18;
    L10:
        if (r16 != 1) goto L12;
        r17 = nextInt();
        goto L9
    L12:
        r18 = (((long) nextBits(RandomKt.fastLog2(r16))) << 32) + (((long) nextInt()) & 4294967295L);
    L13:
        long r19 = nextLong() >>> 1;
        long r20 = r19 % r10;
        if (((r19 - r20) + (r10 - 1)) < 0) goto L13;
        r18 = r20;
        goto L17
    }
}
