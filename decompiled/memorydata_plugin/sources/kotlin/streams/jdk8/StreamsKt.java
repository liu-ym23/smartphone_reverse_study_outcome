package kotlin.streams.jdk8;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, pn = "kotlin.streams", xi = 48)
public final class StreamsKt {
    public static final Sequence<Double> asSequence(DoubleStream r2) {
        final DoubleStream r3 = (DoubleStream) ZeusTransformUtils.wrapperContextForParams(r2, DoubleStream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (Sequence) ZeusTransformUtils.preCheckCast(new StreamsKt$asSequence$$inlined$Sequence$4(r3), Sequence.class, "com.obric.memorydata.plugin");
    }

    public static final Sequence<Integer> asSequence(IntStream r2) {
        final IntStream r3 = (IntStream) ZeusTransformUtils.wrapperContextForParams(r2, IntStream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (Sequence) ZeusTransformUtils.preCheckCast(new StreamsKt$asSequence$$inlined$Sequence$2(r3), Sequence.class, "com.obric.memorydata.plugin");
    }

    public static final Sequence<Long> asSequence(LongStream r2) {
        final LongStream r3 = (LongStream) ZeusTransformUtils.wrapperContextForParams(r2, LongStream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (Sequence) ZeusTransformUtils.preCheckCast(new StreamsKt$asSequence$$inlined$Sequence$3(r3), Sequence.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Sequence<T> asSequence(Stream<T> r2) {
        final Stream r3 = (Stream) ZeusTransformUtils.wrapperContextForParams(r2, Stream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (Sequence) ZeusTransformUtils.preCheckCast(new StreamsKt$asSequence$$inlined$Sequence$1(r3), Sequence.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Stream<T> asStream(Sequence<? extends T> r2) {
        final Sequence r3 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r2, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Stream<T> r4 = StreamSupport.stream(new $$Lambda$StreamsKt$D6rJ2g9z2pCQAEMFkqgtKPOz0JA(r3), 16, false);
        Intrinsics.checkNotNullExpressionValue(r4, "stream(...)");
        return r4;
    }

    private static final Spliterator asStream$lambda$4(Sequence r2) {
        Sequence r3 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r2, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(r3.iterator(), 16);
    }

    public static /* synthetic */ Spliterator lambda$D6rJ2g9z2pCQAEMFkqgtKPOz0JA(Sequence r0) {
        return asStream$lambda$4(r0);
    }

    public static final List<Double> toList(DoubleStream r2) {
        DoubleStream r3 = (DoubleStream) ZeusTransformUtils.wrapperContextForParams(r2, DoubleStream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        double[] r4 = r3.toArray();
        Intrinsics.checkNotNullExpressionValue(r4, "toArray(...)");
        return ArraysKt.asList(r4);
    }

    public static final List<Integer> toList(IntStream r2) {
        IntStream r3 = (IntStream) ZeusTransformUtils.wrapperContextForParams(r2, IntStream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int[] r4 = r3.toArray();
        Intrinsics.checkNotNullExpressionValue(r4, "toArray(...)");
        return ArraysKt.asList(r4);
    }

    public static final List<Long> toList(LongStream r2) {
        LongStream r3 = (LongStream) ZeusTransformUtils.wrapperContextForParams(r2, LongStream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        long[] r4 = r3.toArray();
        Intrinsics.checkNotNullExpressionValue(r4, "toArray(...)");
        return ArraysKt.asList(r4);
    }

    public static final <T> List<T> toList(Stream<T> r2) {
        Stream r3 = (Stream) ZeusTransformUtils.wrapperContextForParams(r2, Stream.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r4 = r3.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(r4, "collect(...)");
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    }
}
