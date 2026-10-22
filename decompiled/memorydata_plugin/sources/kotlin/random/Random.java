package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class Random {
    public static final Default Default = null;
    private static final Random defaultRandom = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Random implements Serializable {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        public /* synthetic */ Default(DefaultConstructorMarker r1) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int r1) {
            return Random.access$getDefaultRandom$cp().nextBits(r1);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.access$getDefaultRandom$cp().nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int r1) {
            return Random.access$getDefaultRandom$cp().nextBytes(r1);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r1) {
            Intrinsics.checkNotNullParameter(r1, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r1);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r1, r2, r3);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.access$getDefaultRandom$cp().nextDouble();
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r1) {
            return Random.access$getDefaultRandom$cp().nextDouble(r1);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r1, double r3) {
            return Random.access$getDefaultRandom$cp().nextDouble(r1, r3);
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
        public int nextInt(int r1) {
            return Random.access$getDefaultRandom$cp().nextInt(r1);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r1, int r2) {
            return Random.access$getDefaultRandom$cp().nextInt(r1, r2);
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.access$getDefaultRandom$cp().nextLong();
        }

        @Override // kotlin.random.Random
        public long nextLong(long r1) {
            return Random.access$getDefaultRandom$cp().nextLong(r1);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r1, long r3) {
            return Random.access$getDefaultRandom$cp().nextLong(r1, r3);
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

    public static /* synthetic */ byte[] nextBytes$default(Random r0, byte[] r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = r1.length;
    L10:
        return r0.nextBytes(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int r1);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public byte[] nextBytes(int r1) {
        return nextBytes(new byte[r1]);
    }

    public byte[] nextBytes(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "array");
        return nextBytes(r3, 0, r3.length);
    }

    public byte[] nextBytes(byte[] r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "array");
        boolean r0 = true;
        int r1 = 0;
        if (r8 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L16;
        if (r9 >= 0) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L16;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L33;
        if (r8 <= r9) goto L22;
        r0 = false;
    L22:
        if (r0 == false) goto L31;
        int r5 = (r9 - r8) / 4;
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L26;
        int r10 = nextInt();
        r7[r8] = (byte) r10;
        r7[r8 + 1] = (byte) (r10 >>> 8);
        r7[r8 + 2] = (byte) (r10 >>> 16);
        r7[r8 + 3] = (byte) (r10 >>> 24);
        r8 = r8 + 4;
        r6 = r6 + 1;
        goto L24
    L26:
        int r11 = r9 - r8;
        int r12 = nextBits(r11 * 8);
    L27:
        if (r1 >= r11) goto L29;
        r7[r8 + r1] = (byte) (r12 >>> (r1 * 8));
        r1 = r1 + 1;
        goto L27
    L29:
        return r7;
    L31:
        throw new IllegalArgumentException(("fromIndex (" + r8 + ") must be not greater than toIndex (" + r9 + ").").toString());
    L33:
        throw new IllegalArgumentException(("fromIndex (" + r8 + ") or toIndex (" + r9 + ") are out of range: 0.." + r7.length + '.').toString());
    L11:
        if (r9 > r7.length) goto L13;
        r3 = true;
    L16:
        r4 = false;
        goto L18
    L5:
        if (r8 > r7.length) goto L7;
        r2 = true;
        goto L8
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public double nextDouble(double r3) {
        return nextDouble(0.0d, r3);
    }

    public double nextDouble(double r7, double r9) {
        RandomKt.checkRangeBounds(r7, r9);
        double r0 = r9 - r7;
        if (Double.isInfinite(r0) == false) goto L19;
        boolean r3 = true;
        if (Double.isInfinite(r7) == false) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L19;
        if (Double.isInfinite(r9) == false) goto L14;
    L16:
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        double r4 = 2;
        double r1 = nextDouble() * ((r9 / r4) - (r7 / r4));
        double r8 = (r7 + r1) + r1;
    L21:
        if (r8 >= r9) goto L23;
        return r8;
    L23:
        return Math.nextAfter(r9, Double.NEGATIVE_INFINITY);
    L14:
        if (Double.isNaN(r9) == true) goto L16;
    L7:
        if (Double.isNaN(r7) == true) goto L9;
        r2 = true;
    L19:
        r8 = r7 + (nextDouble() * r0);
        goto L21
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int r2) {
        return nextInt(0, r2);
    }

    public int nextInt(int r5, int r6) {
        RandomKt.checkRangeBounds(r5, r6);
        int r0 = r6 - r5;
        if (r0 > 0) goto L14;
        if (r0 == Integer.MIN_VALUE) goto L14;
    L7:
        int r1 = nextInt();
        boolean r2 = false;
        if (r5 > r1) goto L11;
        if (r1 >= r6) goto L11;
        r2 = true;
    L11:
        if (r2 == false) goto L7;
        return r1;
    L14:
        if (((-r0) & r0) != r0) goto L16;
        int r4 = nextBits(RandomKt.fastLog2(r0));
    L20:
        return r5 + r4;
    L16:
        int r7 = nextInt() >>> 1;
        int r3 = r7 % r0;
        if (((r7 - r3) + (r0 - 1)) < 0) goto L16;
        r4 = r3;
        goto L20
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public long nextLong(long r3) {
        return nextLong(0, r3);
    }

    public long nextLong(long r11, long r13) {
        RandomKt.checkRangeBounds(r11, r13);
        long r0 = r13 - r11;
        if (r0 > 0) goto L5;
    L18:
        long r1 = nextLong();
        boolean r3 = false;
        if (r11 > r1) goto L23;
        if (r1 >= r13) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L18;
        return r1;
    L5:
        if (((-r0) & r0) != r0) goto L13;
        int r14 = (int) r0;
        int r2 = (int) (r0 >>> 32);
        if (r14 == 0) goto L10;
        int r10 = nextBits(RandomKt.fastLog2(r14));
    L9:
        long r15 = ((long) r10) & 4294967295L;
    L17:
        return r11 + r15;
    L10:
        if (r2 != 1) goto L12;
        r10 = nextInt();
        goto L9
    L12:
        r15 = (((long) nextBits(RandomKt.fastLog2(r2))) << 32) + (((long) nextInt()) & 4294967295L);
    L13:
        long r16 = nextLong() >>> 1;
        long r6 = r16 % r0;
        if (((r16 - r6) + (r0 - 1)) < 0) goto L13;
        r15 = r6;
        goto L17
    }
}
