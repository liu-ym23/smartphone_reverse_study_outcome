package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PlatformRandomKt {
    @SinceKotlin(version = "1.3")
    public static final java.util.Random asJavaRandom(Random r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof AbstractPlatformRandom) == false) goto L5;
        AbstractPlatformRandom r10 = (AbstractPlatformRandom) r5;
    L6:
        if (r10 == null) goto L10;
        java.util.Random r11 = r10.getImpl();
        if (r11 == null) goto L10;
        return r11;
    L10:
        return new KotlinRandom(r5);
    L5:
        r10 = null;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    public static final Random asKotlinRandom(java.util.Random r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KotlinRandom) == false) goto L5;
        KotlinRandom r10 = (KotlinRandom) r5;
    L6:
        if (r10 == null) goto L10;
        Random r11 = r10.getImpl();
        if (r11 == null) goto L10;
        return r11;
    L10:
        return new PlatformRandom(r5);
    L5:
        r10 = null;
        goto L6
    }

    @InlineOnly
    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int r5, int r10) {
        return ((((long) r5) << 27) + ((long) r10)) / 9.007199254740992E15d;
    }
}
