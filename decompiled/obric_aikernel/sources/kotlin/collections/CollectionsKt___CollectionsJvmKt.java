package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\n_CollectionsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1963#2,14:169\n2333#2,14:183\n*S KotlinDebug\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n*L\n89#1:169,14\n126#1:183,14\n*E\n"})
class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public CollectionsKt___CollectionsJvmKt() {
    }

    public static <R> List<R> filterIsInstance(Iterable<?> r10, Class<R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "klass");
        return (List) filterIsInstanceTo(r10, new ArrayList(), r11);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> r10, C r11, Class<R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "klass");
        Iterator<?> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if (r12.isInstance(r14) == false) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable max(Iterable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt___CollectionsKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Double m459max(Iterable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt___CollectionsKt.m467maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Float m460max(Iterable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt___CollectionsKt.m468maxOrNull(r10);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        T r13 = r12.next();
        if (r12.hasNext() == false) goto L18;
        R r14 = r11.invoke(r13);
    L9:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        if (r14.compareTo(r16) >= 0) goto L13;
        r13 = r15;
        r14 = r16;
    L13:
        if (r12.hasNext() == true) goto L9;
    L18:
        return (T) r13;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object maxWith(Iterable r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return CollectionsKt___CollectionsKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable min(Iterable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Double m461min(Iterable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt___CollectionsKt.m475minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Float m462min(Iterable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt___CollectionsKt.m476minOrNull(r10);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        T r13 = r12.next();
        if (r12.hasNext() == false) goto L18;
        R r14 = r11.invoke(r13);
    L9:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        if (r14.compareTo(r16) <= 0) goto L13;
        r13 = r15;
        r14 = r16;
    L13:
        if (r12.hasNext() == true) goto L9;
    L18:
        return (T) r13;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object minWith(Iterable r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return CollectionsKt___CollectionsKt.minWithOrNull(r10, r11);
    }

    public static <T> void reverse(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collections.reverse(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal sumOfBigDecimal(Iterable<? extends T> r10, Function1<? super T, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = r12.add(r11.invoke(r13.next()));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigInteger sumOfBigInteger(Iterable<? extends T> r10, Function1<? super T, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = r12.add(r11.invoke(r13.next()));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        goto L4
    L6:
        return r12;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(r10, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(r10, new TreeSet(r11));
    }
}
