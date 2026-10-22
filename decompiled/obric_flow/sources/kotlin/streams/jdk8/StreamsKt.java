package kotlin.streams.jdk8;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.javapoet.f;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, pn = "kotlin.streams", xi = 48)
@JvmName(name = "StreamsKt")
public final class StreamsKt {
    public static /* synthetic */ Spliterator a(Sequence r5) {
        return asStream$lambda$4(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Sequence<T> asSequence(final Stream<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$1(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Stream<T> asStream(Sequence<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return StreamSupport.stream(new f(r5, 1), 16, false);
    }

    private static final Spliterator asStream$lambda$4(Sequence r5) {
        Intrinsics.checkNotNullParameter(r5, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(r5.iterator(), 16);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<T> toList(Stream<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (List) r5.collect(Collectors.toList());
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Integer> asSequence(final IntStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$2(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final List<Integer> toList(IntStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ArraysKt.asList(r5.toArray());
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Long> asSequence(final LongStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$3(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final List<Long> toList(LongStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ArraysKt.asList(r5.toArray());
    }

    @SinceKotlin(version = "1.2")
    public static final Sequence<Double> asSequence(final DoubleStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$4(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final List<Double> toList(DoubleStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ArraysKt.asList(r5.toArray());
    }
}
