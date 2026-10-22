package kotlin.random;

import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class PlatformRandomKt {
    @SinceKotlin(version = "1.3")
    public static final java.util.Random asJavaRandom(Random r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof AbstractPlatformRandom) == false) goto L5;
        AbstractPlatformRandom r11 = (AbstractPlatformRandom) r10;
    L6:
        if (r11 == null) goto L10;
        java.util.Random r12 = r11.getImpl();
        if (r12 == null) goto L10;
        return r12;
    L10:
        return new KotlinRandom(r10);
    L5:
        r11 = null;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    public static final Random asKotlinRandom(java.util.Random r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KotlinRandom) == false) goto L5;
        KotlinRandom r11 = (KotlinRandom) r10;
    L6:
        if (r11 == null) goto L10;
        Random r12 = r11.getImpl();
        if (r12 == null) goto L10;
        return r12;
    L10:
        return new PlatformRandom(r10);
    L5:
        r11 = null;
        goto L6
    }

    @InlineOnly
    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int r10, int r11) {
        return ((((long) r10) << 27) + ((long) r11)) / 9.007199254740992E15d;
    }
}
