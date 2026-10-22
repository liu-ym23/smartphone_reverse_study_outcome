package kotlin.random;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    private final FallbackThreadLocalRandom$implStorage$1 implStorage;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.random.FallbackThreadLocalRandom$implStorage$1] */
    public FallbackThreadLocalRandom() {
        this.implStorage = new FallbackThreadLocalRandom$implStorage$1();
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public java.util.Random getImpl() {
        java.util.Random r10 = get();
        Intrinsics.checkNotNullExpressionValue(r10, "implStorage.get()");
        return r10;
    }
}
