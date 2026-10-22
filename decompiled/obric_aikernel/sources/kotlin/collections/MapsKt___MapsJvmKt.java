package kotlin.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class MapsKt___MapsJvmKt extends MapsKt__MapsKt {
    public MapsKt___MapsJvmKt() {
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @InlineOnly
    private static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxBy(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        Map.Entry<K, V> r13 = null;
    L16:
        return r13;
    L5:
        Map.Entry<K, V> r14 = (Object) r12.next();
        if (r12.hasNext() == true) goto L8;
    L7:
        r13 = r14;
        goto L16
    L8:
        R r15 = r11.invoke(r14);
    L9:
        Map.Entry<K, V> r16 = (Object) r12.next();
        R r17 = r11.invoke(r16);
        if (r15.compareTo(r17) >= 0) goto L13;
        r14 = r16;
        r15 = r17;
    L13:
        if (r12.hasNext() == true) goto L9;
        goto L7
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @InlineOnly
    private static final /* synthetic */ <K, V> Map.Entry<K, V> maxWith(Map<? extends K, ? extends V> r10, Comparator<? super Map.Entry<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.maxWithOrNull(r10.entrySet(), r11);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minBy(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        Map.Entry<K, V> r13 = null;
    L16:
        return r13;
    L5:
        Map.Entry<K, V> r14 = (Object) r12.next();
        if (r12.hasNext() == true) goto L8;
    L7:
        r13 = r14;
        goto L16
    L8:
        R r15 = r11.invoke(r14);
    L9:
        Map.Entry<K, V> r16 = (Object) r12.next();
        R r17 = r11.invoke(r16);
        if (r15.compareTo(r17) <= 0) goto L13;
        r14 = r16;
        r15 = r17;
    L13:
        if (r12.hasNext() == true) goto L9;
        goto L7
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Map.Entry minWith(Map r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.minWithOrNull(r10.entrySet(), r11);
    }
}
