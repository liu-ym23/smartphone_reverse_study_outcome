package kotlin.random;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class KotlinRandom extends java.util.Random {
    private static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private final Random impl;
    private boolean seedInitialized;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KotlinRandom(Random r10) {
        Intrinsics.checkNotNullParameter(r10, "impl");
        this.impl = r10;
    }

    public final Random getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int r10) {
        return this.impl.nextBits(r10);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        this.impl.nextBytes(r10);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public int nextInt(int r10) {
        return this.impl.nextInt(r10);
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long r10) {
        if (this.seedInitialized == true) goto L7;
        this.seedInitialized = true;
        return;
    L7:
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }
}
