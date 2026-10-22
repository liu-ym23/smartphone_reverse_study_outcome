package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedRange;", "contains", "", EventBody.KEY_VALUE, "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> r2, T r3) {
            ClosedFloatingPointRange r4 = (ClosedFloatingPointRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedFloatingPointRange.class, "com.obric.memorydata.plugin");
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
            if (r4.lessThanOrEquals(r4.getStart(), r5) == true) goto L5;
        L7:
            return false;
        L5:
            if (r4.lessThanOrEquals(r5, r4.getEndInclusive()) == false) goto L7;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<? super T>> boolean isEmpty(ClosedFloatingPointRange<T> r2) {
            ClosedFloatingPointRange r3 = (ClosedFloatingPointRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedFloatingPointRange.class, "com.obric.memorydata.plugin");
            return !r3.lessThanOrEquals(r3.getStart(), r3.getEndInclusive());
        }
    }

    @Override // kotlin.ranges.ClosedRange
    boolean contains(T r1);

    @Override // kotlin.ranges.ClosedRange
    boolean isEmpty();

    boolean lessThanOrEquals(T r1, T r2);
}
