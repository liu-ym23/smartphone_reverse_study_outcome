package kotlin.ranges;

import com.bytedance.crash.entity.EventBody;
import java.lang.Comparable;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
public interface OpenEndRange<T extends Comparable<? super T>> {

    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(OpenEndRange<T> r10, T r11) {
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            if (r11.compareTo(r10.getStart()) >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r11.compareTo(r10.getEndExclusive()) >= 0) goto L7;
            return true;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(OpenEndRange<T> r10) {
            if (r10.getStart().compareTo(r10.getEndExclusive()) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    boolean contains(T r10);

    T getEndExclusive();

    T getStart();

    boolean isEmpty();
}
