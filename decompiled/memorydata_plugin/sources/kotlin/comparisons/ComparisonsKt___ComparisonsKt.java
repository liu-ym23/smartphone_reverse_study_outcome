package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f\u001aG\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public ComparisonsKt___ComparisonsKt() {
    }

    public static final <T> T maxOf(T r2, T r3, T r4, Comparator<? super T> r5) {
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "comparator");
        return (T) ComparisonsKt.maxOf(r2, ComparisonsKt.maxOf(r3, r4, r6), r6);
    }

    public static final <T> T maxOf(T r2, T r3, Comparator<? super T> r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        if (r5.compare(r2, r3) < 0) goto L6;
        return r2;
    L6:
        return r3;
    }

    public static final <T> T maxOf(T r4, T[] r5, Comparator<? super T> r6) {
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r6, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "other");
        Intrinsics.checkNotNullParameter(r7, "comparator");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        T r2 = r5[r1];
        if (r7.compare(r4, r2) >= 0) goto L7;
        r4 = r2;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }

    public static final <T> T minOf(T r2, T r3, T r4, Comparator<? super T> r5) {
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "comparator");
        return (T) ComparisonsKt.minOf(r2, ComparisonsKt.minOf(r3, r4, r6), r6);
    }

    public static final <T> T minOf(T r2, T r3, Comparator<? super T> r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        if (r5.compare(r2, r3) > 0) goto L6;
        return r2;
    L6:
        return r3;
    }

    public static final <T> T minOf(T r4, T[] r5, Comparator<? super T> r6) {
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r6, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "other");
        Intrinsics.checkNotNullParameter(r7, "comparator");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        T r2 = r5[r1];
        if (r7.compare(r4, r2) <= 0) goto L7;
        r4 = r2;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }
}
