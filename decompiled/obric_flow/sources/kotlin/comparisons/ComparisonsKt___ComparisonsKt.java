package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f\u001aG\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public ComparisonsKt___ComparisonsKt() {
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(T r5, T r10, T r11, Comparator<? super T> r12) {
        Intrinsics.checkNotNullParameter(r12, "comparator");
        return (T) maxOf(r5, maxOf(r10, r11, r12), r12);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(T r5, T r10, T r11, Comparator<? super T> r12) {
        Intrinsics.checkNotNullParameter(r12, "comparator");
        return (T) minOf(r5, minOf(r10, r11, r12), r12);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(T r5, T r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r11.compare(r5, r10) < 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(T r5, T r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r11.compare(r5, r10) > 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T maxOf(T r5, T[] r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        T r14 = r10[r13];
        if (r11.compare(r5, r14) >= 0) goto L7;
        r5 = r14;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T minOf(T r5, T[] r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        T r14 = r10[r13];
        if (r11.compare(r5, r14) <= 0) goto L7;
        r5 = r14;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r5;
    }
}
