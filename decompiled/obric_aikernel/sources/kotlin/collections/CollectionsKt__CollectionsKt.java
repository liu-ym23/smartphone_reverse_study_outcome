package kotlin.collections;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,481:1\n404#1:483\n1#2:482\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n*L\n398#1:483\n*E\n"})
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1\n*L\n1#1,481:1\n*E\n"})
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Integer> {

        /* JADX INFO: Incorrect field signature: TK; */
        final /* synthetic */ Comparable $key;
        final /* synthetic */ Function1<T, K> $selector;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TT;+TK;>;TK;)V */
        public AnonymousClass1(Function1 r10, Comparable r11) {
            this.$selector = r10;
            this.$key = r11;
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(T r10) {
            return Integer.valueOf(ComparisonsKt.compareValues((Comparable) this.$selector.invoke(r10), this.$key));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Object r10) {
            return invoke(r10);
        }
    }

    public CollectionsKt__CollectionsKt() {
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> List(int r10, Function1<? super Integer, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, CommonConsts.APM_INNER_EVENT_COST_INIT);
        ArrayList r12 = new ArrayList(r10);
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r12.add(r11.invoke(Integer.valueOf(r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> MutableList(int r10, Function1<? super Integer, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, CommonConsts.APM_INNER_EVENT_COST_INIT);
        ArrayList r12 = new ArrayList(r10);
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r12.add(r11.invoke(Integer.valueOf(r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList();
    }

    public static <T> ArrayList<T> arrayListOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new ArrayAsCollection(r10, true));
    }

    public static final <T> Collection<T> asCollection(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ArrayAsCollection(r10, false);
    }

    public static final <T> int binarySearch(List<? extends T> r10, int r11, int r12, Function1<? super T, Integer> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(r10.size(), r11, r12);
        int r14 = r12 - 1;
    L3:
        if (r11 > r14) goto L11;
        int r15 = (r11 + r14) >>> 1;
        int r16 = r13.invoke(r10.get(r15)).intValue();
        if (r16 < 0) goto L6;
        if (r16 <= 0) goto L9;
        r14 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r11 = r15 + 1;
        goto L3
    L11:
        return -(r11 + 1);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> r10, T r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(r10.size(), r12, r13);
        int r14 = r13 - 1;
    L3:
        if (r12 > r14) goto L11;
        int r15 = (r12 + r14) >>> 1;
        int r16 = ComparisonsKt.compareValues(r10.get(r15), r11);
        if (r16 < 0) goto L6;
        if (r16 <= 0) goto L9;
        r14 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r12 = r15 + 1;
        goto L3
    L11:
        return -(r12 + 1);
    }

    public static final <T> int binarySearch(List<? extends T> r10, T r11, Comparator<? super T> r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(r10.size(), r13, r14);
        int r15 = r14 - 1;
    L3:
        if (r13 > r15) goto L11;
        int r16 = (r13 + r15) >>> 1;
        int r17 = r12.compare(r10.get(r16), r11);
        if (r17 < 0) goto L6;
        if (r17 <= 0) goto L9;
        r15 = r16 - 1;
        goto L3
    L9:
        return r16;
    L6:
        r13 = r16 + 1;
        goto L3
    L11:
        return -(r13 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List r10, int r11, int r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.size();
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(List r10, Comparable r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.size();
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(List r10, Object r11, Comparator r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = 0;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r14 = r10.size();
    L9:
        return binarySearch(r10, r11, r12, r13, r14);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> r10, K r11, int r12, int r13, Function1<? super T, ? extends K> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "selector");
        return binarySearch(r10, r12, r13, new AnonymousClass1(r14, r11));
    }

    public static /* synthetic */ int binarySearchBy$default(List r10, Comparable r11, int r12, int r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = r10.size();
    L9:
        return binarySearch(r10, r12, r13, new AnonymousClass1(r14, r11));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> List<E> buildList(int r10, @BuilderInference Function1<? super List<E>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        List r12 = CollectionsKt.createListBuilder(r10);
        r11.invoke(r12);
        return CollectionsKt.build(r12);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> List<E> buildList(@BuilderInference Function1<? super List<E>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        List r11 = CollectionsKt.createListBuilder();
        r10.invoke(r11);
        return CollectionsKt.build(r11);
    }

    @InlineOnly
    private static final <T> boolean containsAll(Collection<? extends T> r10, Collection<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return r10.containsAll(r11);
    }

    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static IntRange getIndices(Collection<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new IntRange(0, r10.size() - 1);
    }

    public static <T> int getLastIndex(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Collection r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if (r10.isEmpty() == true) goto L5;
        return r10;
    L5:
        return r11.invoke();
    }

    @InlineOnly
    private static final <T> boolean isNotEmpty(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return !r10.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean isNullOrEmpty(Collection<? extends T> r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.isEmpty() == true) goto L7;
        return false;
    }

    @InlineOnly
    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> listOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.length <= 0) goto L6;
        return ArraysKt.asList(r10);
    L6:
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> listOfNotNull(T r10) {
        if (r10 == null) goto L5;
        return CollectionsKt.listOf(r10);
    L5:
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> listOfNotNull(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return ArraysKt.filterNotNull(r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    public static <T> List<T> mutableListOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new ArrayAsCollection(r10, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L10;
        return r10;
    L10:
        return CollectionsKt.listOf(r10.get(0));
    L9:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Collection<T> orEmpty(Collection<? extends T> r10) {
        if (r10 == 0) goto L4;
        return r10;
    L4:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> List<T> orEmpty(List<? extends T> r10) {
        if (r10 == 0) goto L4;
        return r10;
    L4:
        return CollectionsKt.emptyList();
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int r10, int r11, int r12) {
        if (r11 > r12) goto L12;
        if (r11 < 0) goto L10;
        if (r12 > r10) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("toIndex (" + r12 + ") is greater than size (" + r10 + ").");
    L10:
        throw new IndexOutOfBoundsException("fromIndex (" + r11 + ") is less than zero.");
    L12:
        throw new IllegalArgumentException("fromIndex (" + r11 + ") is greater than toIndex (" + r12 + ").");
    }

    @SinceKotlin(version = "1.3")
    public static final <T> List<T> shuffled(Iterable<? extends T> r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        List<T> r12 = CollectionsKt___CollectionsKt.toMutableList(r10);
        CollectionsKt___CollectionsKt.shuffle(r12, r11);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
