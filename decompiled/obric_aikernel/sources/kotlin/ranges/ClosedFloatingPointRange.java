package kotlin.ranges;

import com.bytedance.crash.entity.EventBody;
import java.lang.Comparable;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {

    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> r10, T r11) {
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            if (r10.lessThanOrEquals(r10.getStart(), r11) == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.lessThanOrEquals(r11, r10.getEndInclusive()) == false) goto L7;
            return true;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(ClosedFloatingPointRange<T> r10) {
            return !r10.lessThanOrEquals(r10.getStart(), r10.getEndInclusive());
        }
    }

    @Override // kotlin.ranges.ClosedRange
    boolean contains(T r10);

    @Override // kotlin.ranges.ClosedRange
    boolean isEmpty();

    boolean lessThanOrEquals(T r10, T r11);
}
