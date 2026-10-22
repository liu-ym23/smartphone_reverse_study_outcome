package kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
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

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\n_SequencesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,172:1\n1433#2,14:173\n1839#2,14:187\n*S KotlinDebug\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n*L\n89#1:173,14\n126#1:187,14\n*E\n"})
class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    public SequencesKt___SequencesJvmKt() {
    }

    public static final <R> Sequence<R> filterIsInstance(Sequence<?> r10, final Class<R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "klass");
        Sequence<R> r12 = SequencesKt.filter(r10, new AnonymousClass1(r11));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return r12;
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Sequence<?> r10, C r11, Class<R> r12) {
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
    public static final /* synthetic */ Comparable max(Sequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt___SequencesKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Double m1330max(Sequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt___SequencesKt.m1338maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Float m1331max(Sequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt___SequencesKt.m1339maxOrNull(r10);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
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
    public static final /* synthetic */ Object maxWith(Sequence r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return SequencesKt___SequencesKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable min(Sequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt___SequencesKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Double m1332min(Sequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt___SequencesKt.m1346minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Float m1333min(Sequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt___SequencesKt.m1347minOrNull(r10);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
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
    public static final /* synthetic */ Object minWith(Sequence r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return SequencesKt___SequencesKt.minWithOrNull(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal sumOfBigDecimal(Sequence<? extends T> r10, Function1<? super T, ? extends BigDecimal> r11) {
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
    private static final <T> BigInteger sumOfBigInteger(Sequence<? extends T> r10, Function1<? super T, ? extends BigInteger> r11) {
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

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(r10, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Sequence<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(r10, new TreeSet(r11));
    }
}
