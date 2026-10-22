package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public CollectionsKt__MutableCollectionsJVMKt() {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void fill(List<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collections.fill(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void shuffle(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collections.shuffle(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void shuffle(List<T> r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        Collections.shuffle(r10, r11);
    }

    public static <T extends Comparable<? super T>> void sort(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() <= 1) goto L6;
        Collections.sort(r10);
        return;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    @InlineOnly
    private static final <T> void sort(List<T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @InlineOnly
    private static final <T> void sort(List<T> r10, Function2<? super T, ? super T, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    public static <T> void sortWith(List<T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r10.size() <= 1) goto L6;
        Collections.sort(r10, r11);
        return;
    }
}
