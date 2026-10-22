package kotlin.ranges;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class RangesKt__RangesKt {
    public RangesKt__RangesKt() {
    }

    public static final void checkStepIsPositive(boolean r10, Number r11) {
        Intrinsics.checkNotNullParameter(r11, "step");
        if (r10 == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Step must be positive, was: " + r11 + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/ClosedRange<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(ClosedRange r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.contains((Comparable) r11) == false) goto L7;
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/OpenEndRange<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final boolean contains(OpenEndRange r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.contains((Comparable) r11) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Double> rangeTo(double r10, double r11) {
        return new ClosedDoubleRange(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Float> rangeTo(float r10, float r11) {
        return new ClosedFloatRange(r10, r11);
    }

    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "that");
        return new ComparableRange(r10, r11);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final OpenEndRange<Double> rangeUntil(double r10, double r11) {
        return new OpenEndDoubleRange(r10, r11);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final OpenEndRange<Float> rangeUntil(float r10, float r11) {
        return new OpenEndFloatRange(r10, r11);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T extends Comparable<? super T>> OpenEndRange<T> rangeUntil(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "that");
        return new ComparableOpenEndRange(r10, r11);
    }
}
