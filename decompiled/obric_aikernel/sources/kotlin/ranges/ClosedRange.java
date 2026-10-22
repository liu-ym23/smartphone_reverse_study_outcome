package kotlin.ranges;

import com.bytedance.crash.entity.EventBody;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface ClosedRange<T extends Comparable<? super T>> {

    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(ClosedRange<T> r10, T r11) {
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            if (r11.compareTo(r10.getStart()) >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r11.compareTo(r10.getEndInclusive()) > 0) goto L7;
            return true;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(ClosedRange<T> r10) {
            if (r10.getStart().compareTo(r10.getEndInclusive()) <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    boolean contains(T r10);

    T getEndInclusive();

    T getStart();

    boolean isEmpty();
}
