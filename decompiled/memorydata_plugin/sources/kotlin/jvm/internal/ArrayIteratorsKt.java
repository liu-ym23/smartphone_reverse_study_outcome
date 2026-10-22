package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007\u001a\u000e\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\t\u001a\u000e\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b\u001a\u000e\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r\u001a\u000e\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f\u001a\u000e\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"iterator", "Lkotlin/collections/BooleanIterator;", "array", "", "Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/ShortIterator;", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ArrayIteratorsKt {
    public static final BooleanIterator iterator(boolean[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (BooleanIterator) ZeusTransformUtils.preCheckCast(new ArrayBooleanIterator(r2), BooleanIterator.class, "com.obric.memorydata.plugin");
    }

    public static final ByteIterator iterator(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (ByteIterator) ZeusTransformUtils.preCheckCast(new ArrayByteIterator(r2), ByteIterator.class, "com.obric.memorydata.plugin");
    }

    public static final CharIterator iterator(char[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (CharIterator) ZeusTransformUtils.preCheckCast(new ArrayCharIterator(r2), CharIterator.class, "com.obric.memorydata.plugin");
    }

    public static final DoubleIterator iterator(double[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (DoubleIterator) ZeusTransformUtils.preCheckCast(new ArrayDoubleIterator(r2), DoubleIterator.class, "com.obric.memorydata.plugin");
    }

    public static final FloatIterator iterator(float[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (FloatIterator) ZeusTransformUtils.preCheckCast(new ArrayFloatIterator(r2), FloatIterator.class, "com.obric.memorydata.plugin");
    }

    public static final IntIterator iterator(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (IntIterator) ZeusTransformUtils.preCheckCast(new ArrayIntIterator(r2), IntIterator.class, "com.obric.memorydata.plugin");
    }

    public static final LongIterator iterator(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (LongIterator) ZeusTransformUtils.preCheckCast(new ArrayLongIterator(r2), LongIterator.class, "com.obric.memorydata.plugin");
    }

    public static final ShortIterator iterator(short[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (ShortIterator) ZeusTransformUtils.preCheckCast(new ArrayShortIterator(r2), ShortIterator.class, "com.obric.memorydata.plugin");
    }
}
