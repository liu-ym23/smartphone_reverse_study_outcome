package kotlin.jvm.internal;

import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayIteratorsKt {
    public static final BooleanIterator iterator(boolean[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayBooleanIterator(r10);
    }

    public static final ByteIterator iterator(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayByteIterator(r10);
    }

    public static final CharIterator iterator(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayCharIterator(r10);
    }

    public static final DoubleIterator iterator(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayDoubleIterator(r10);
    }

    public static final FloatIterator iterator(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayFloatIterator(r10);
    }

    public static final IntIterator iterator(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayIntIterator(r10);
    }

    public static final LongIterator iterator(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayLongIterator(r10);
    }

    public static final ShortIterator iterator(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return new ArrayShortIterator(r10);
    }
}
