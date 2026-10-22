package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

/* JADX INFO: loaded from: classes2.dex */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    public PlatformThreadLocalRandom() {
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public Random getImpl() {
        ThreadLocalRandom r10 = ThreadLocalRandom.current();
        Intrinsics.checkNotNullExpressionValue(r10, "current()");
        return r10;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double r10) {
        return ThreadLocalRandom.current().nextDouble(r10);
    }

    @Override // kotlin.random.Random
    public int nextInt(int r10, int r11) {
        return ThreadLocalRandom.current().nextInt(r10, r11);
    }

    @Override // kotlin.random.Random
    public long nextLong(long r10) {
        return ThreadLocalRandom.current().nextLong(r10);
    }

    @Override // kotlin.random.Random
    public long nextLong(long r10, long r11) {
        return ThreadLocalRandom.current().nextLong(r10, r11);
    }
}
