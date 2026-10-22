package kotlin.random;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PlatformRandomKt {
    public static final java.util.Random asJavaRandom(Random r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r2, AbstractPlatformRandom.class) == false) goto L5;
        AbstractPlatformRandom r0 = (AbstractPlatformRandom) ZeusTransformUtils.preCheckCast(r2, AbstractPlatformRandom.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L10;
        java.util.Random r1 = r0.getImpl();
        if (r1 == null) goto L10;
        return r1;
    L10:
        return (java.util.Random) ZeusTransformUtils.preCheckCast(new KotlinRandom(r2), java.util.Random.class, "com.obric.memorydata.plugin");
    L5:
        r0 = null;
        goto L6
    }

    public static final Random asKotlinRandom(java.util.Random r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r2, KotlinRandom.class) == false) goto L5;
        KotlinRandom r0 = (KotlinRandom) ZeusTransformUtils.preCheckCast(r2, KotlinRandom.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L10;
        Random r1 = r0.getImpl();
        if (r1 == null) goto L10;
        return r1;
    L10:
        return (Random) ZeusTransformUtils.preCheckCast(new PlatformRandom(r2), Random.class, "com.obric.memorydata.plugin");
    L5:
        r0 = null;
        goto L6
    }

    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int r2, int r3) {
        return ((((long) r2) << 27) + ((long) r3)) / 9.007199254740992E15d;
    }
}
