package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1537:1\n1#2:1538\n*E\n"})
class RangesKt___RangesKt extends RangesKt__RangesKt {
    public RangesKt___RangesKt() {
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte r12 = toByteExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    public static final byte coerceAtLeast(byte r10, byte r11) {
        if (r10 < r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static final double coerceAtLeast(double r10, double r11) {
        if (r10 < r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static float coerceAtLeast(float r10, float r11) {
        if (r10 < r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static int coerceAtLeast(int r10, int r11) {
        if (r10 < r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static long coerceAtLeast(long r10, long r11) {
        if (r10 < r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "minimumValue");
        if (r10.compareTo(r11) < 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static final short coerceAtLeast(short r10, short r11) {
        if (r10 < r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static final byte coerceAtMost(byte r10, byte r11) {
        if (r10 > r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static final double coerceAtMost(double r10, double r11) {
        if (r10 > r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static float coerceAtMost(float r10, float r11) {
        if (r10 > r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static int coerceAtMost(int r10, int r11) {
        if (r10 > r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static long coerceAtMost(long r10, long r11) {
        if (r10 > r11) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "maximumValue");
        if (r10.compareTo(r11) > 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static final short coerceAtMost(short r10, short r11) {
        if (r10 > r11) goto L4;
        return r10;
    L4:
        return r11;
    }

    public static final byte coerceIn(byte r10, byte r11, byte r12) {
        if (r11 > r12) goto L9;
        if (r10 >= r11) goto L5;
        return r11;
    L5:
        if (r10 <= r12) goto L7;
        return r12;
    L7:
        return r10;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static final double coerceIn(double r10, double r11, double r12) {
        if (r11 > r12) goto L12;
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        if (r10 <= r12) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static float coerceIn(float r10, float r11, float r12) {
        if (r11 > r12) goto L12;
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        if (r10 <= r12) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static int coerceIn(int r10, int r11, int r12) {
        if (r11 > r12) goto L9;
        if (r10 >= r11) goto L5;
        return r11;
    L5:
        if (r10 <= r12) goto L7;
        return r12;
    L7:
        return r10;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static final int coerceIn(int r10, ClosedRange<Integer> r11) {
        Intrinsics.checkNotNullParameter(r11, "range");
        if ((r11 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((Number) coerceIn(Integer.valueOf(r10), (ClosedFloatingPointRange) r11)).intValue();
    L7:
        if (r11.isEmpty() == true) goto L17;
        if (r10 >= ((Number) r11.getStart()).intValue()) goto L13;
        Object r12 = r11.getStart();
    L15:
        return ((Number) r12).intValue();
    L13:
        if (r10 <= ((Number) r11.getEndInclusive()).intValue()) goto L18;
        r12 = r11.getEndInclusive();
        goto L15
    L18:
        return r10;
    L17:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r11 + '.');
    }

    public static long coerceIn(long r10, long r11, long r12) {
        if (r11 > r12) goto L12;
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        if (r10 <= r12) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    public static long coerceIn(long r10, ClosedRange<Long> r11) {
        Intrinsics.checkNotNullParameter(r11, "range");
        if ((r11 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((Number) coerceIn(Long.valueOf(r10), (ClosedFloatingPointRange) r11)).longValue();
    L7:
        if (r11.isEmpty() == true) goto L17;
        if (r10 >= ((Number) r11.getStart()).longValue()) goto L13;
        Object r12 = r11.getStart();
    L15:
        return ((Number) r12).longValue();
    L13:
        if (r10 <= ((Number) r11.getEndInclusive()).longValue()) goto L18;
        r12 = r11.getEndInclusive();
        goto L15
    L18:
        return r10;
    L17:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r11 + '.');
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T r10, T r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == null) goto L15;
        if (r12 == null) goto L15;
        if (r11.compareTo(r12) > 0) goto L14;
        if (r10.compareTo(r11) >= 0) goto L11;
        return r11;
    L11:
        if (r10.compareTo(r12) <= 0) goto L23;
        return r12;
    L23:
        return r10;
    L14:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    L15:
        if (r11 != null) goto L17;
    L19:
        if (r12 == null) goto L23;
        if (r10.compareTo(r12) <= 0) goto L23;
        return r12;
    L17:
        if (r10.compareTo(r11) >= 0) goto L19;
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T coerceIn(T r10, ClosedFloatingPointRange<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if (r11.isEmpty() == true) goto L16;
        if (r11.lessThanOrEquals(r10, r11.getStart()) == false) goto L10;
        if (r11.lessThanOrEquals(r11.getStart(), r10) == true) goto L10;
        return r11.getStart();
    L10:
        if (r11.lessThanOrEquals(r11.getEndInclusive(), r10) == true) goto L12;
        return r10;
    L12:
        if (r11.lessThanOrEquals(r10, r11.getEndInclusive()) == false) goto L14;
        return r10;
    L14:
        return r11.getEndInclusive();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r11 + '.');
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T r10, ClosedRange<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if ((r11 instanceof ClosedFloatingPointRange) == false) goto L7;
        return (T) coerceIn(r10, (ClosedFloatingPointRange) r11);
    L7:
        if (r11.isEmpty() == true) goto L16;
        if (r10.compareTo(r11.getStart()) >= 0) goto L12;
        return (T) r11.getStart();
    L12:
        if (r10.compareTo(r11.getEndInclusive()) > 0) goto L14;
        return r10;
    L14:
        return (T) r11.getEndInclusive();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r11 + '.');
    }

    public static final short coerceIn(short r10, short r11, short r12) {
        if (r11 > r12) goto L9;
        if (r10 >= r11) goto L5;
        return r11;
    L5:
        if (r10 <= r12) goto L7;
        return r12;
    L7:
        return r10;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r12 + " is less than minimum " + r11 + '.');
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(CharRange r10, Character r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.contains(r11.charValue()) == false) goto L7;
        return true;
    }

    @InlineOnly
    private static final boolean contains(IntRange r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return intRangeContains(r10, r11);
    }

    @InlineOnly
    private static final boolean contains(IntRange r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return RangesKt.intRangeContains(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(IntRange r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.contains(r11.intValue()) == false) goto L7;
        return true;
    }

    @InlineOnly
    private static final boolean contains(IntRange r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return intRangeContains(r10, r11);
    }

    @InlineOnly
    private static final boolean contains(LongRange r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return longRangeContains(r10, r11);
    }

    @InlineOnly
    private static final boolean contains(LongRange r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return longRangeContains(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(LongRange r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.contains(r11.longValue()) == false) goto L7;
        return true;
    }

    @InlineOnly
    private static final boolean contains(LongRange r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return longRangeContains(r10, r11);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Double.valueOf(r11));
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Double.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Double.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Double.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Double.valueOf(r11));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(OpenEndRange<Double> r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Double.valueOf(r11));
    }

    public static final CharProgression downTo(char r10, char r11) {
        return CharProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(byte r10, byte r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(byte r10, int r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(byte r10, short r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(int r10, byte r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static IntProgression downTo(int r10, int r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(int r10, short r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(short r10, byte r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(short r10, int r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(short r10, short r11) {
        return IntProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(byte r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(int r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(long r10, byte r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(long r10, int r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(long r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(long r10, short r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(short r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final char first(CharProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final int first(IntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long first(LongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final Character firstOrNull(CharProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return Character.valueOf(r10.getFirst());
    }

    @SinceKotlin(version = "1.7")
    public static final Integer firstOrNull(IntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r10.getFirst());
    }

    @SinceKotlin(version = "1.7")
    public static final Long firstOrNull(LongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r10.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Float.valueOf(r11));
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Float.valueOf((float) r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Float.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Float.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Float.valueOf(r11));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Integer.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Integer r12 = toIntExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Integer r12 = toIntExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "intRangeContains")
    public static boolean intRangeContains(ClosedRange<Integer> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Integer r12 = toIntExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Integer.valueOf(r11));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Integer.valueOf(r11));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Integer r12 = toIntExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Integer.valueOf(r11));
    }

    @SinceKotlin(version = "1.7")
    public static final char last(CharProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final int last(IntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long last(LongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final Character lastOrNull(CharProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return Character.valueOf(r10.getLast());
    }

    @SinceKotlin(version = "1.7")
    public static final Integer lastOrNull(IntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r10.getLast());
    }

    @SinceKotlin(version = "1.7")
    public static final Long lastOrNull(LongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r10.getLast());
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Long.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Long r12 = toLongExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Long r12 = toLongExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Long.valueOf(r11));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Long.valueOf(r11));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Long.valueOf(r11));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Long.valueOf(r11));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Long.valueOf(r11));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(CharRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return random(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    public static final char random(CharRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        return (char) r11.nextInt(r10.getFirst(), r10.getLast() + 1);
    L6:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int random(IntRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return random(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    public static final int random(IntRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        return RandomKt.nextInt(r11, r10);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long random(LongRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return random(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    public static final long random(LongRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        return RandomKt.nextLong(r11, r10);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Character randomOrNull(CharRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return randomOrNull(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character randomOrNull(CharRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return Character.valueOf((char) r11.nextInt(r10.getFirst(), r10.getLast() + 1));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Integer randomOrNull(IntRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return randomOrNull(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer randomOrNull(IntRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return Integer.valueOf(RandomKt.nextInt(r11, r10));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Long randomOrNull(LongRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return randomOrNull(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Long randomOrNull(LongRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return Long.valueOf(RandomKt.nextLong(r11, r10));
    }

    public static final CharProgression reversed(CharProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CharProgression.Companion.fromClosedRange(r10.getLast(), r10.getFirst(), -r10.getStep());
    }

    public static final IntProgression reversed(IntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return IntProgression.Companion.fromClosedRange(r10.getLast(), r10.getFirst(), -r10.getStep());
    }

    public static final LongProgression reversed(LongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return LongProgression.Companion.fromClosedRange(r10.getLast(), r10.getFirst(), -r10.getStep());
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Short.valueOf(r11));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Short r12 = toShortExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Short r12 = toShortExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Short r12 = toShortExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Short r12 = toShortExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.contains(Short.valueOf(r11));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Short r12 = toShortExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Short r12 = toShortExactOrNull(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r10.contains(r12);
    }

    public static final CharProgression step(CharProgression r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r12, Integer.valueOf(r11));
        CharProgression.Companion r13 = CharProgression.Companion;
        char r14 = r10.getFirst();
        char r15 = r10.getLast();
        if (r10.getStep() > 0) goto L11;
        r11 = -r11;
    L11:
        return r13.fromClosedRange(r14, r15, r11);
    L5:
        r12 = false;
        goto L6
    }

    public static IntProgression step(IntProgression r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r12, Integer.valueOf(r11));
        IntProgression.Companion r13 = IntProgression.Companion;
        int r14 = r10.getFirst();
        int r15 = r10.getLast();
        if (r10.getStep() > 0) goto L11;
        r11 = -r11;
    L11:
        return r13.fromClosedRange(r14, r15, r11);
    L5:
        r12 = false;
        goto L6
    }

    public static final LongProgression step(LongProgression r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r12 <= 0) goto L5;
        boolean r10 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r10, Long.valueOf(r12));
        LongProgression.Companion r13 = LongProgression.Companion;
        long r14 = r11.getFirst();
        long r15 = r11.getLast();
        if (r11.getStep() > 0) goto L11;
        r12 = -r12;
    L11:
        return r13.fromClosedRange(r14, r15, r12);
    L5:
        r10 = false;
        goto L6
    }

    public static final Byte toByteExactOrNull(double r10) {
        boolean r11 = false;
        if ((-128.0d) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Byte.valueOf((byte) r10);
    L5:
        if (r10 > 127.0d) goto L7;
        r11 = true;
        goto L7
    }

    public static final Byte toByteExactOrNull(float r10) {
        boolean r11 = false;
        if ((-128.0f) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Byte.valueOf((byte) r10);
    L5:
        if (r10 > 127.0f) goto L7;
        r11 = true;
        goto L7
    }

    public static final Byte toByteExactOrNull(int r10) {
        if (new IntRange(-128, 127).contains(r10) == true) goto L7;
        return null;
    L7:
        return Byte.valueOf((byte) r10);
    }

    public static final Byte toByteExactOrNull(long r10) {
        if (new LongRange(-128, 127).contains(r10) == true) goto L7;
        return null;
    L7:
        return Byte.valueOf((byte) r10);
    }

    public static final Byte toByteExactOrNull(short r10) {
        if (intRangeContains(new IntRange(-128, 127), r10) == true) goto L7;
        return null;
    L7:
        return Byte.valueOf((byte) r10);
    }

    public static final Integer toIntExactOrNull(double r10) {
        boolean r11 = false;
        if ((-2.147483648E9d) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Integer.valueOf((int) r10);
    L5:
        if (r10 > 2.147483647E9d) goto L7;
        r11 = true;
        goto L7
    }

    public static final Integer toIntExactOrNull(float r10) {
        boolean r11 = false;
        if ((-2.1474836E9f) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Integer.valueOf((int) r10);
    L5:
        if (r10 > 2.1474836E9f) goto L7;
        r11 = true;
        goto L7
    }

    public static final Integer toIntExactOrNull(long r10) {
        if (new LongRange(-2147483648L, 2147483647L).contains(r10) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf((int) r10);
    }

    public static final Long toLongExactOrNull(double r10) {
        boolean r11 = false;
        if ((-9.223372036854776E18d) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Long.valueOf((long) r10);
    L5:
        if (r10 > 9.223372036854776E18d) goto L7;
        r11 = true;
        goto L7
    }

    public static final Long toLongExactOrNull(float r10) {
        boolean r11 = false;
        if ((-9.223372E18f) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Long.valueOf((long) r10);
    L5:
        if (r10 > 9.223372E18f) goto L7;
        r11 = true;
        goto L7
    }

    public static final Short toShortExactOrNull(double r10) {
        boolean r11 = false;
        if ((-32768.0d) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Short.valueOf((short) r10);
    L5:
        if (r10 > 32767.0d) goto L7;
        r11 = true;
        goto L7
    }

    public static final Short toShortExactOrNull(float r10) {
        boolean r11 = false;
        if ((-32768.0f) <= r10) goto L5;
    L7:
        if (r11 == true) goto L11;
        return null;
    L11:
        return Short.valueOf((short) r10);
    L5:
        if (r10 > 32767.0f) goto L7;
        r11 = true;
        goto L7
    }

    public static final Short toShortExactOrNull(int r10) {
        if (new IntRange(-32768, 32767).contains(r10) == true) goto L7;
        return null;
    L7:
        return Short.valueOf((short) r10);
    }

    public static final Short toShortExactOrNull(long r10) {
        if (new LongRange(-32768, 32767).contains(r10) == true) goto L7;
        return null;
    L7:
        return Short.valueOf((short) r10);
    }

    public static final CharRange until(char r10, char r11) {
        if (Intrinsics.compare(r11, 0) > 0) goto L7;
        return CharRange.Companion.getEMPTY();
    L7:
        return new CharRange(r10, (char) (r11 - 1));
    }

    public static final IntRange until(byte r10, byte r11) {
        return new IntRange(r10, r11 - 1);
    }

    public static final IntRange until(byte r10, int r11) {
        if (r11 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r10, r11 - 1);
    }

    public static final IntRange until(byte r10, short r11) {
        return new IntRange(r10, r11 - 1);
    }

    public static final IntRange until(int r10, byte r11) {
        return new IntRange(r10, r11 - 1);
    }

    public static IntRange until(int r10, int r11) {
        if (r11 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r10, r11 - 1);
    }

    public static final IntRange until(int r10, short r11) {
        return new IntRange(r10, r11 - 1);
    }

    public static final IntRange until(short r10, byte r11) {
        return new IntRange(r10, r11 - 1);
    }

    public static final IntRange until(short r10, int r11) {
        if (r11 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r10, r11 - 1);
    }

    public static final IntRange until(short r10, short r11) {
        return new IntRange(r10, r11 - 1);
    }

    public static final LongRange until(byte r10, long r11) {
        if (r11 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r10, r11 - 1);
    }

    public static final LongRange until(int r10, long r11) {
        if (r11 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r10, r11 - 1);
    }

    public static final LongRange until(long r10, byte r11) {
        return new LongRange(r10, ((long) r11) - 1);
    }

    public static final LongRange until(long r10, int r11) {
        return new LongRange(r10, ((long) r11) - 1);
    }

    public static final LongRange until(long r10, long r11) {
        if (r11 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r10, r11 - 1);
    }

    public static final LongRange until(long r10, short r11) {
        return new LongRange(r10, ((long) r11) - 1);
    }

    public static final LongRange until(short r10, long r11) {
        if (r11 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r10, r11 - 1);
    }
}
