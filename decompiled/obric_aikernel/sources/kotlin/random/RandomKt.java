package kotlin.random;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
public final class RandomKt {
    @SinceKotlin(version = "1.3")
    public static final Random Random(int r10) {
        return new XorWowRandom(r10, r10 >> 31);
    }

    @SinceKotlin(version = "1.3")
    public static final Random Random(long r10) {
        return new XorWowRandom((int) r10, (int) (r10 >> 32));
    }

    public static final String boundsErrorMessage(Object r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r11, "until");
        return "Random range is empty: [" + r10 + ", " + r11 + ").";
    }

    public static final void checkRangeBounds(double r10, double r11) {
        if (r11 <= r10) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(r10), Double.valueOf(r11)).toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final void checkRangeBounds(int r10, int r11) {
        if (r11 <= r10) goto L4;
        boolean r12 = true;
    L5:
        if (r12 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(r10), Integer.valueOf(r11)).toString());
    L4:
        r12 = false;
        goto L5
    }

    public static final void checkRangeBounds(long r10, long r11) {
        if (r11 <= r10) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(r10), Long.valueOf(r11)).toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final int fastLog2(int r10) {
        return 31 - Integer.numberOfLeadingZeros(r10);
    }

    @SinceKotlin(version = "1.3")
    public static final int nextInt(Random r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if (r11.isEmpty() == true) goto L13;
        if (r11.getLast() >= Integer.MAX_VALUE) goto L8;
        return r10.nextInt(r11.getFirst(), r11.getLast() + 1);
    L8:
        if (r11.getFirst() <= Integer.MIN_VALUE) goto L11;
        return r10.nextInt(r11.getFirst() - 1, r11.getLast()) + 1;
    L11:
        return r10.nextInt();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r11);
    }

    @SinceKotlin(version = "1.3")
    public static final long nextLong(Random r10, LongRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if (r11.isEmpty() == true) goto L13;
        long r12 = r11.getLast();
        long r13 = r11.getFirst();
        if (r12 >= Long.MAX_VALUE) goto L8;
        return r10.nextLong(r13, r11.getLast() + 1);
    L8:
        if (r13 <= Long.MIN_VALUE) goto L11;
        return r10.nextLong(r11.getFirst() - 1, r11.getLast()) + 1;
    L11:
        return r10.nextLong();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r11);
    }

    public static final int takeUpperBits(int r10, int r11) {
        return (r10 >>> (32 - r11)) & ((-r11) >> 31);
    }
}
