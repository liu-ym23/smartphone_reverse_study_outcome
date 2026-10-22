package kotlin.comparisons;

import java.util.Comparator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
class ComparisonsKt__ComparisonsKt {

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class AnonymousClass2<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Comparable<?>> r10) {
            this.$selector = r10;
        }

        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            Function1<T, Comparable<?>> r12 = this.$selector;
            return ComparisonsKt.compareValues(r12.invoke(r10), r12.invoke(r11));
        }
    }

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class AnonymousClass1<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super T, ? extends Comparable<?>> r10) {
            this.$selector = r10;
        }

        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            Function1<T, Comparable<?>> r12 = this.$selector;
            return ComparisonsKt.compareValues(r12.invoke(r11), r12.invoke(r10));
        }
    }

    public ComparisonsKt__ComparisonsKt() {
    }

    public static /* synthetic */ int a(Comparator r10, Comparator r11, Object r12, Object r13) {
        return thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(r10, r11, r12, r13);
    }

    public static /* synthetic */ int b(Comparator r10, Object r11, Object r12) {
        return nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(r10, r11, r12);
    }

    public static /* synthetic */ int c(Comparator r10, Object r11, Object r12) {
        return nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(r10, r11, r12);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareBy(final Comparator<? super K> r10, final Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "comparator");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return new AnonymousClass3(r10, r11);
    }

    @InlineOnly
    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> r10) {
        Intrinsics.checkNotNullParameter(r10, "selector");
        return new AnonymousClass2(r10);
    }

    public static final <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... r10) {
        Intrinsics.checkNotNullParameter(r10, "selectors");
        if (r10.length <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        return new e(r10);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r11 = false;
        goto L6
    }

    private static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] r10, Object r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "$selectors");
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r11, r12, r10);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareByDescending(final Comparator<? super K> r10, final Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "comparator");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return new C04002(r10, r11);
    }

    @InlineOnly
    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> r10) {
        Intrinsics.checkNotNullParameter(r10, "selector");
        return new AnonymousClass1(r10);
    }

    public static <T extends Comparable<?>> int compareValues(T r10, T r11) {
        if (r10 != r11) goto L5;
        return 0;
    L5:
        if (r10 != null) goto L8;
        return -1;
    L8:
        if (r11 != null) goto L12;
        return 1;
    L12:
        return r10.compareTo(r11);
    }

    @InlineOnly
    private static final <T, K> int compareValuesBy(T r10, T r11, Comparator<? super K> r12, Function1<? super T, ? extends K> r13) {
        Intrinsics.checkNotNullParameter(r12, "comparator");
        Intrinsics.checkNotNullParameter(r13, "selector");
        return r12.compare(r13.invoke(r10), r13.invoke(r11));
    }

    @InlineOnly
    private static final <T> int compareValuesBy(T r10, T r11, Function1<? super T, ? extends Comparable<?>> r12) {
        Intrinsics.checkNotNullParameter(r12, "selector");
        return ComparisonsKt.compareValues(r12.invoke(r10), r12.invoke(r11));
    }

    public static final <T> int compareValuesBy(T r10, T r11, Function1<? super T, ? extends Comparable<?>>... r12) {
        Intrinsics.checkNotNullParameter(r12, "selectors");
        if (r12.length <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r10, r11, r12);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r13 = false;
        goto L6
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T r10, T r11, Function1<? super T, ? extends Comparable<?>>[] r12) {
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Function1<? super T, ? extends Comparable<?>> r15 = r12[r14];
        int r16 = ComparisonsKt.compareValues(r15.invoke(r10), r15.invoke(r11));
        if (r16 != 0) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r16;
    L8:
        return 0;
    }

    public static /* synthetic */ int d(Comparator r10, Comparator r11, Object r12, Object r13) {
        return then$lambda$1$ComparisonsKt__ComparisonsKt(r10, r11, r12, r13);
    }

    public static /* synthetic */ int e(Function1[] r10, Object r11, Object r12) {
        return compareBy$lambda$0$ComparisonsKt__ComparisonsKt(r10, r11, r12);
    }

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator r10 = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return r10;
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return nullsFirst(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsFirst(final Comparator<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return new a(r10);
    }

    private static final int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(Comparator r10, Object r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "$comparator");
        if (r11 != r12) goto L5;
        return 0;
    L5:
        if (r11 != null) goto L7;
        return -1;
    L7:
        if (r12 != null) goto L10;
        return 1;
    L10:
        return r10.compare(r11, r12);
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return nullsLast(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsLast(final Comparator<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "comparator");
        return new b(r10);
    }

    private static final int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(Comparator r10, Object r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "$comparator");
        if (r11 != r12) goto L5;
        return 0;
    L5:
        if (r11 != null) goto L7;
        return 1;
    L7:
        if (r12 != null) goto L10;
        return -1;
    L10:
        return r10.compare(r11, r12);
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator r10 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return r10;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ReversedComparator) == true) goto L14;
        Comparator<T> r11 = NaturalOrderComparator.INSTANCE;
        if (Intrinsics.areEqual(r10, r11) == false) goto L9;
        ReverseOrderComparator r12 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        return r12;
    L9:
        if (Intrinsics.areEqual(r10, ReverseOrderComparator.INSTANCE) == false) goto L11;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
    L13:
        return r11;
    L11:
        r11 = new ReversedComparator(r10);
        goto L13
    L14:
        return ((ReversedComparator) r10).getComparator();
    }

    public static final <T> Comparator<T> then(final Comparator<T> r10, final Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return new d(r10, r11);
    }

    private static final int then$lambda$1$ComparisonsKt__ComparisonsKt(Comparator r10, Comparator r11, Object r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "$this_then");
        Intrinsics.checkNotNullParameter(r11, "$comparator");
        int r14 = r10.compare(r12, r13);
        if (r14 == 0) goto L6;
        return r14;
    L6:
        return r11.compare(r12, r13);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> thenBy(final Comparator<T> r10, final Comparator<? super K> r11, final Function1<? super T, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        return new C04022(r10, r11, r12);
    }

    @InlineOnly
    private static final <T> Comparator<T> thenBy(final Comparator<T> r10, final Function1<? super T, ? extends Comparable<?>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return new C04011(r10, r11);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> thenByDescending(final Comparator<T> r10, final Comparator<? super K> r11, final Function1<? super T, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        return new C04042(r10, r11, r12);
    }

    @InlineOnly
    private static final <T> Comparator<T> thenByDescending(final Comparator<T> r10, final Function1<? super T, ? extends Comparable<?>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return new C04031(r10, r11);
    }

    @InlineOnly
    private static final <T> Comparator<T> thenComparator(final Comparator<T> r10, final Function2<? super T, ? super T, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparison");
        return new C04051(r10, r11);
    }

    public static final <T> Comparator<T> thenDescending(final Comparator<T> r10, final Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return new c(r10, r11);
    }

    private static final int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(Comparator r10, Comparator r11, Object r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "$this_thenDescending");
        Intrinsics.checkNotNullParameter(r11, "$comparator");
        int r14 = r10.compare(r12, r13);
        if (r14 == 0) goto L6;
        return r14;
    L6:
        return r11.compare(r13, r12);
    }
}
