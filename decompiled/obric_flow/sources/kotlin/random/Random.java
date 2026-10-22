package kotlin.random;

import ai.j0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
public abstract class Random {
    public static final Default Default = null;
    private static final Random defaultRandom = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Random implements Serializable {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Serialized implements Serializable {
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

        public /* synthetic */ Default(DefaultConstructorMarker r5) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int r5) {
            return Random.access$getDefaultRandom$cp().nextBits(r5);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.access$getDefaultRandom$cp().nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r5) {
            Intrinsics.checkNotNullParameter(r5, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r5);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.access$getDefaultRandom$cp().nextDouble();
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
        public long nextLong() {
            return Random.access$getDefaultRandom$cp().nextLong();
        }

        private Default() {
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int r5) {
            return Random.access$getDefaultRandom$cp().nextBytes(r5);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r5) {
            return Random.access$getDefaultRandom$cp().nextDouble(r5);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r5) {
            return Random.access$getDefaultRandom$cp().nextInt(r5);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r5) {
            return Random.access$getDefaultRandom$cp().nextLong(r5);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r5, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r5, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r5, r10, r11);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r5, double r10) {
            return Random.access$getDefaultRandom$cp().nextDouble(r5, r10);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r5, int r10) {
            return Random.access$getDefaultRandom$cp().nextInt(r5, r10);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r5, long r10) {
            return Random.access$getDefaultRandom$cp().nextLong(r5, r10);
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

    public static /* synthetic */ byte[] nextBytes$default(Random r5, byte[] r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 2) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r13 & 4) == 0) goto L10;
        r12 = r10.length;
    L10:
        return r5.nextBytes(r10, r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int r5);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public byte[] nextBytes(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "array");
        if (r11 < 0) goto L20;
        if (r11 > r10.length) goto L20;
        if (r12 < 0) goto L20;
        if (r12 > r10.length) goto L20;
        if (r11 > r12) goto L18;
        int r5 = (r12 - r11) / 4;
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r14 >= r5) goto L13;
        int r15 = nextInt();
        r10[r11] = (byte) r15;
        r10[r11 + 1] = (byte) (r15 >>> 8);
        r10[r11 + 2] = (byte) (r15 >>> 16);
        r10[r11 + 3] = (byte) (r15 >>> 24);
        r11 = r11 + 4;
        r14 = r14 + 1;
        goto L11
    L13:
        int r16 = r12 - r11;
        int r17 = nextBits(r16 * 8);
    L14:
        if (r13 >= r16) goto L16;
        r10[r11 + r13] = (byte) (r17 >>> (r13 * 8));
        r13 = r13 + 1;
        goto L14
    L16:
        return r10;
    L18:
        throw new IllegalArgumentException(("fromIndex (" + r11 + ") must be not greater than toIndex (" + r12 + ").").toString());
    L20:
        throw new IllegalArgumentException(j0.n(j0.v("fromIndex (", r11, r12, ") or toIndex (", ") are out of range: 0.."), r10.length, '.').toString());
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double r5) {
        return nextDouble(0.0d, r5);
    }

    public int nextInt(int r5) {
        return nextInt(0, r5);
    }

    public long nextLong(long r5) {
        return nextLong(0, r5);
    }

    public double nextDouble(double r10, double r11) {
        RandomKt.checkRangeBounds(r10, r11);
        double r5 = r11 - r10;
        if (Double.isInfinite(r5) == true) goto L5;
    L13:
        double r12 = r10 + (nextDouble() * r5);
    L15:
        if (r12 >= r11) goto L17;
        return r12;
    L17:
        return Math.nextAfter(r11, Double.NEGATIVE_INFINITY);
    L5:
        if (Double.isInfinite(r10) == true) goto L13;
        if (Double.isNaN(r10) == true) goto L13;
        if (Double.isInfinite(r11) == true) goto L13;
        if (Double.isNaN(r11) == true) goto L13;
        double r13 = 2;
        double r14 = ((r11 / r13) - (r10 / r13)) * nextDouble();
        r12 = (r10 + r14) + r14;
        goto L15
    }

    public int nextInt(int r5, int r10) {
        RandomKt.checkRangeBounds(r5, r10);
        int r11 = r10 - r5;
        if (r11 > 0) goto L12;
        if (r11 == Integer.MIN_VALUE) goto L12;
    L7:
        int r12 = nextInt();
        if (r5 > r12) goto L7;
        if (r12 >= r10) goto L7;
        return r12;
    L12:
        if (((-r11) & r11) != r11) goto L14;
        int r13 = nextBits(RandomKt.fastLog2(r11));
    L18:
        return r5 + r13;
    L14:
        int r14 = nextInt() >>> 1;
        int r15 = r14 % r11;
        if (((r11 - 1) + (r14 - r15)) < 0) goto L14;
        r13 = r15;
        goto L18
    }

    public long nextLong(long r10, long r12) {
        RandomKt.checkRangeBounds(r10, r12);
        long r5 = r12 - r10;
        if (r5 > 0) goto L5;
    L18:
        long r11 = nextLong();
        if (r10 > r11) goto L18;
        if (r11 >= r12) goto L18;
        return r11;
    L5:
        if (((-r5) & r5) != r5) goto L13;
        int r13 = (int) r5;
        int r14 = (int) (r5 >>> 32);
        if (r13 == 0) goto L10;
        int r15 = nextBits(RandomKt.fastLog2(r13));
    L9:
        long r16 = ((long) r15) & 4294967295L;
    L17:
        return r10 + r16;
    L10:
        if (r14 != 1) goto L12;
        r15 = nextInt();
        goto L9
    L12:
        r16 = (((long) nextBits(RandomKt.fastLog2(r14))) << 32) + (((long) nextInt()) & 4294967295L);
    L13:
        long r17 = nextLong() >>> 1;
        long r18 = r17 % r5;
        long r19 = r5 - 1;
        if ((r19 + (r17 - r18)) < 0) goto L13;
        r16 = r18;
        goto L17
    }

    public byte[] nextBytes(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        return nextBytes(r5, 0, r5.length);
    }

    public byte[] nextBytes(int r5) {
        return nextBytes(new byte[r5]);
    }
}
