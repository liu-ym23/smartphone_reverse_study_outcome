package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;
import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> r10, Range<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Range<T> r12 = r10.intersect(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "intersect(other)");
        return r12;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> r10, Range<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Range<T> r12 = r10.extend(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "extend(other)");
        return r12;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Range<T> r12 = r10.extend(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "extend(value)");
        return r12;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "that");
        return new Range(r10, r11);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(final Range<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (ClosedRange<T>) new AnonymousClass1(r10);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(ClosedRange<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Range(r10.getStart(), r10.getEndInclusive());
    }
}
