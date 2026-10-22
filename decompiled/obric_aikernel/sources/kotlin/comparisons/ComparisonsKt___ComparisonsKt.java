package kotlin.comparisons;

import java.util.Comparator;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public ComparisonsKt___ComparisonsKt() {
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(T r10, T r11, T r12, Comparator<? super T> r13) {
        Intrinsics.checkNotNullParameter(r13, "comparator");
        return (T) maxOf(r10, maxOf(r11, r12, r13), r13);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(T r10, T r11, Comparator<? super T> r12) {
        Intrinsics.checkNotNullParameter(r12, "comparator");
        if (r12.compare(r10, r11) < 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T maxOf(T r10, T[] r11, Comparator<? super T> r12) {
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        T r15 = r11[r14];
        if (r12.compare(r10, r15) >= 0) goto L7;
        r10 = r15;
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(T r10, T r11, T r12, Comparator<? super T> r13) {
        Intrinsics.checkNotNullParameter(r13, "comparator");
        return (T) minOf(r10, minOf(r11, r12, r13), r13);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(T r10, T r11, Comparator<? super T> r12) {
        Intrinsics.checkNotNullParameter(r12, "comparator");
        if (r12.compare(r10, r11) > 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T minOf(T r10, T[] r11, Comparator<? super T> r12) {
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        T r15 = r11[r14];
        if (r12.compare(r10, r15) <= 0) goto L7;
        r10 = r15;
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r10;
    }
}
