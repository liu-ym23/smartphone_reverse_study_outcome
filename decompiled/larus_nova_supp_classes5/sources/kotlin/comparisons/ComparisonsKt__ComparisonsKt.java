package kotlin.comparisons;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aZ\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a>\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aZ\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aR\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001aR\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001ap\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\bø\u0001\u0000\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", DBDefinition.NAME, "thenDescending", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt__ComparisonsKt {
    public ComparisonsKt__ComparisonsKt() {
    }

    public static /* synthetic */ int a(Comparator r0, Comparator r1, Object r2, Object r3) {
        return thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(r0, r1, r2, r3);
    }

    public static /* synthetic */ int b(Comparator r0, Object r1, Object r2) {
        return nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(r0, r1, r2);
    }

    public static /* synthetic */ int c(Comparator r0, Object r1, Object r2) {
        return nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(r0, r1, r2);
    }

    public static /* synthetic */ int d(Comparator r0, Comparator r1, Object r2, Object r3) {
        return then$lambda$1$ComparisonsKt__ComparisonsKt(r0, r1, r2, r3);
    }

    public static /* synthetic */ int e(Function1[] r0, Object r1, Object r2) {
        return compareBy$lambda$0$ComparisonsKt__ComparisonsKt(r0, r1, r2);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator r0 = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return r0;
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator r0 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return r0;
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return nullsFirst(naturalOrder());
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return nullsLast(naturalOrder());
    }

    public static <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... r1) {
        Intrinsics.checkNotNullParameter(r1, "selectors");
        if (r1.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new b(r1);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> r1) {
        Intrinsics.checkNotNullParameter(r1, "selector");
        return new compareByDescending.1(r1);
    }

    public static final <T> Comparator<T> nullsFirst(Comparator<? super T> r1) {
        Intrinsics.checkNotNullParameter(r1, "comparator");
        return new d(r1);
    }

    public static final <T> Comparator<T> nullsLast(Comparator<? super T> r1) {
        Intrinsics.checkNotNullParameter(r1, "comparator");
        return new e(r1);
    }

    public static final <T> Comparator<T> reversed(Comparator<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof ReversedComparator) == true) goto L14;
        Comparator<T> r0 = NaturalOrderComparator.INSTANCE;
        if (Intrinsics.areEqual(r3, r0) == false) goto L9;
        ReverseOrderComparator r4 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        return r4;
    L9:
        if (Intrinsics.areEqual(r3, ReverseOrderComparator.INSTANCE) == false) goto L11;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
    L13:
        return r0;
    L11:
        r0 = new ReversedComparator(r3);
        goto L13
    L14:
        return ((ReversedComparator) r3).getComparator();
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> r1) {
        Intrinsics.checkNotNullParameter(r1, "selector");
        return new compareBy.2(r1);
    }

    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> r1, Function1<? super T, ? extends K> r2) {
        Intrinsics.checkNotNullParameter(r1, "comparator");
        Intrinsics.checkNotNullParameter(r2, "selector");
        return new compareBy.3(r1, r2);
    }

    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> r1, Function1<? super T, ? extends K> r2) {
        Intrinsics.checkNotNullParameter(r1, "comparator");
        Intrinsics.checkNotNullParameter(r2, "selector");
        return new compareByDescending.2(r1, r2);
    }

    public static <T extends Comparable<?>> int compareValues(T r0, T r1) {
        if (r0 != r1) goto L5;
        return 0;
    L5:
        if (r0 != null) goto L8;
        return -1;
    L8:
        if (r1 != null) goto L12;
        return 1;
    L12:
        return r0.compareTo(r1);
    }

    public static <T> Comparator<T> then(Comparator<T> r1, Comparator<? super T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return new a(r1, r2);
    }

    private static final <T> Comparator<T> thenBy(Comparator<T> r1, Function1<? super T, ? extends Comparable<?>> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "selector");
        return new thenBy.1(r1, r2);
    }

    private static final <T> Comparator<T> thenByDescending(Comparator<T> r1, Function1<? super T, ? extends Comparable<?>> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "selector");
        return new thenByDescending.1(r1, r2);
    }

    private static final <T> Comparator<T> thenComparator(Comparator<T> r1, Function2<? super T, ? super T, Integer> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparison");
        return new thenComparator.1(r1, r2);
    }

    public static final <T> Comparator<T> thenDescending(Comparator<T> r1, Comparator<? super T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        return new c(r1, r2);
    }

    private static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$selectors");
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r2, r3, r1);
    }

    public static final <T> int compareValuesBy(T r1, T r2, Function1<? super T, ? extends Comparable<?>>... r3) {
        Intrinsics.checkNotNullParameter(r3, "selectors");
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r1, r2, r3);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T r5, T r6, Function1<? super T, ? extends Comparable<?>>[] r7) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Function1<? super T, ? extends Comparable<?>> r3 = r7[r2];
        int r4 = compareValues((Comparable) r3.invoke(r5), (Comparable) r3.invoke(r6));
        if (r4 != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return 0;
    }

    private static final int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(Comparator r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$comparator");
        if (r2 != r3) goto L5;
        return 0;
    L5:
        if (r2 != null) goto L7;
        return -1;
    L7:
        if (r3 != null) goto L10;
        return 1;
    L10:
        return r1.compare(r2, r3);
    }

    private static final int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(Comparator r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$comparator");
        if (r2 != r3) goto L5;
        return 0;
    L5:
        if (r2 != null) goto L7;
        return 1;
    L7:
        if (r3 != null) goto L10;
        return -1;
    L10:
        return r1.compare(r2, r3);
    }

    private static final <T, K> Comparator<T> thenBy(Comparator<T> r1, Comparator<? super K> r2, Function1<? super T, ? extends K> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        Intrinsics.checkNotNullParameter(r3, "selector");
        return new thenBy.2(r1, r2, r3);
    }

    private static final <T, K> Comparator<T> thenByDescending(Comparator<T> r1, Comparator<? super K> r2, Function1<? super T, ? extends K> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "comparator");
        Intrinsics.checkNotNullParameter(r3, "selector");
        return new thenByDescending.2(r1, r2, r3);
    }

    private static final <T> int compareValuesBy(T r1, T r2, Function1<? super T, ? extends Comparable<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "selector");
        return compareValues((Comparable) r3.invoke(r1), (Comparable) r3.invoke(r2));
    }

    private static final <T, K> int compareValuesBy(T r1, T r2, Comparator<? super K> r3, Function1<? super T, ? extends K> r4) {
        Intrinsics.checkNotNullParameter(r3, "comparator");
        Intrinsics.checkNotNullParameter(r4, "selector");
        return r3.compare((Object) r4.invoke(r1), (Object) r4.invoke(r2));
    }

    private static final int then$lambda$1$ComparisonsKt__ComparisonsKt(Comparator r1, Comparator r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r1, "$this_then");
        Intrinsics.checkNotNullParameter(r2, "$comparator");
        int r5 = r1.compare(r3, r4);
        if (r5 == 0) goto L6;
        return r5;
    L6:
        return r2.compare(r3, r4);
    }

    private static final int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(Comparator r1, Comparator r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r1, "$this_thenDescending");
        Intrinsics.checkNotNullParameter(r2, "$comparator");
        int r5 = r1.compare(r3, r4);
        if (r5 == 0) goto L6;
        return r5;
    L6:
        return r2.compare(r4, r3);
    }
}
