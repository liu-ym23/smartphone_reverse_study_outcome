package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
public final class RandomKt {
    @SinceKotlin(version = "1.3")
    public static final Random Random(int r5) {
        return new XorWowRandom(r5, r5 >> 31);
    }

    public static final String boundsErrorMessage(Object r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r10, "until");
        return "Random range is empty: [" + r5 + ", " + r10 + ").";
    }

    public static final void checkRangeBounds(int r5, int r10) {
        if (r10 <= r5) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(r5), Integer.valueOf(r10)).toString());
    }

    public static final int fastLog2(int r5) {
        return 31 - Integer.numberOfLeadingZeros(r5);
    }

    @SinceKotlin(version = "1.3")
    public static final int nextInt(Random r5, IntRange r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        if (r10.isEmpty() == true) goto L13;
        if (r10.getLast() >= Integer.MAX_VALUE) goto L8;
        return r5.nextInt(r10.getFirst(), r10.getLast() + 1);
    L8:
        if (r10.getFirst() <= Integer.MIN_VALUE) goto L11;
        return r5.nextInt(r10.getFirst() - 1, r10.getLast()) + 1;
    L11:
        return r5.nextInt();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r10);
    }

    @SinceKotlin(version = "1.3")
    public static final long nextLong(Random r10, LongRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if (r11.isEmpty() == true) goto L13;
        if (r11.getLast() >= Long.MAX_VALUE) goto L8;
        return r10.nextLong(r11.getFirst(), r11.getLast() + 1);
    L8:
        if (r11.getFirst() <= Long.MIN_VALUE) goto L11;
        return r10.nextLong(r11.getFirst() - 1, r11.getLast()) + 1;
    L11:
        return r10.nextLong();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r11);
    }

    public static final int takeUpperBits(int r5, int r10) {
        return (r5 >>> (32 - r10)) & ((-r10) >> 31);
    }

    @SinceKotlin(version = "1.3")
    public static final Random Random(long r5) {
        return new XorWowRandom((int) r5, (int) (r5 >> 32));
    }

    public static final void checkRangeBounds(long r5, long r10) {
        if (r10 <= r5) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(r5), Long.valueOf(r10)).toString());
    }

    public static final void checkRangeBounds(double r5, double r10) {
        if (r10 <= r5) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(r5), Double.valueOf(r10)).toString());
    }
}
