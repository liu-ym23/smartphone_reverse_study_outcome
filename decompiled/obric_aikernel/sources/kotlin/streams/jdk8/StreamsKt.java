package kotlin.streams.jdk8;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "StreamsKt")
public final class StreamsKt {
    public static /* synthetic */ Spliterator a(Sequence r10) {
        return asStream$lambda$4(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Double> asSequence(final DoubleStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$4(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Integer> asSequence(final IntStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$2(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Long> asSequence(final LongStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$3(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Sequence<T> asSequence(final Stream<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$1(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Stream<T> asStream(final Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Stream<T> r11 = StreamSupport.stream(new a(r10), 16, false);
        Intrinsics.checkNotNullExpressionValue(r11, "stream({ Spliterators.sp…literator.ORDERED, false)");
        return r11;
    }

    private static final Spliterator asStream$lambda$4(Sequence r10) {
        Intrinsics.checkNotNullParameter(r10, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(r10.iterator(), 16);
    }

    @SinceKotlin(version = "1.2")
    public static final List<Double> toList(DoubleStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        double[] r11 = r10.toArray();
        Intrinsics.checkNotNullExpressionValue(r11, "toArray()");
        return ArraysKt.asList(r11);
    }

    @SinceKotlin(version = "1.2")
    public static final List<Integer> toList(IntStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int[] r11 = r10.toArray();
        Intrinsics.checkNotNullExpressionValue(r11, "toArray()");
        return ArraysKt.asList(r11);
    }

    @SinceKotlin(version = "1.2")
    public static final List<Long> toList(LongStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long[] r11 = r10.toArray();
        Intrinsics.checkNotNullExpressionValue(r11, "toArray()");
        return ArraysKt.asList(r11);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<T> toList(Stream<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Object r11 = r10.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(r11, "collect(Collectors.toList<T>())");
        return (List) r11;
    }
}
