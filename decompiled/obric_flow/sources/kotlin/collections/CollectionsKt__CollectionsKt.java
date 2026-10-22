package kotlin.collections;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\bø\u0001\u0000\u001aC\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\bø\u0001\u0000\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aN\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a!\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00182\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0002\u0010#\u001a3\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018\"\u0004\b\u0000\u0010\u00072\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010%\u001a\u0012\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020!2\b\u0010*\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010+\u001a3\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020!2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010(\u001a\u0015\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010-\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0002\b0\u001a\b\u00101\u001a\u00020\u001eH\u0001\u001a\b\u00102\u001a\u00020\u001eH\u0001\u001a%\u00103\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u00104\u001aS\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010*\u001a\u0002H\u00072\u001a\u00106\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000707j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`82\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u00109\u001a>\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00105\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070;*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010*\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u0010<\u001ag\u0010=\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u0010>*\b\u0012\u0004\u0012\u0002H>0;*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u0010?\u001a\u0004\u0018\u0001H>2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\u0016\b\u0004\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H>0\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010A\u001a,\u0010B\u001a\u00020C\"\t\b\u0000\u0010\u0007¢\u0006\u0002\bD*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001aH\u0010E\u001a\u0002HF\"\u0010\b\u0000\u0010G*\u0006\u0012\u0002\b\u00030\u0002*\u0002HF\"\u0004\b\u0001\u0010F*\u0002HG2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0IH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010J\u001a\u0019\u0010K\u001a\u00020C\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a,\u0010L\u001a\u00020C\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u001e\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u001a!\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\u0087\b\u001a&\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070P2\u0006\u0010Q\u001a\u00020RH\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", ExifInterface.GPS_DIRECTION_TRUE, "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", ExifInterface.LONGITUDE_EAST, "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "collectionToArrayCommonImpl", "", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", STGroup.DICT_KEY, "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", "", "random", "Lkotlin/random/Random;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,526:1\n1#2:527\n*E\n"})
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "", ST.IMPLICIT_ARG_NAME, "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Integer> {

        /* JADX INFO: Incorrect field signature: TK; */
        final /* synthetic */ Comparable $key;
        final /* synthetic */ Function1<T, K> $selector;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TT;+TK;>;TK;)V */
        public AnonymousClass1(Function1 r5, Comparable r10) {
            this.$selector = r5;
            this.$key = r10;
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(T r5) {
            return Integer.valueOf(ComparisonsKt.compareValues((Comparable) this.$selector.invoke(r5), this.$key));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Object r5) {
            return invoke(r5);
        }
    }

    public CollectionsKt__CollectionsKt() {
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> List(int r5, Function1<? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "init");
        ArrayList r11 = new ArrayList(r5);
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L5;
        r11.add(r10.invoke(Integer.valueOf(r12)));
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> MutableList(int r5, Function1<? super Integer, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "init");
        ArrayList r11 = new ArrayList(r5);
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L5;
        r11.add(r10.invoke(Integer.valueOf(r12)));
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList();
    }

    public static final <T> Collection<T> asCollection(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new ArrayAsCollection(r5, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> r5, T r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(r5.size(), r11, r12);
        int r13 = r12 - 1;
    L3:
        if (r11 > r13) goto L11;
        int r14 = (r11 + r13) >>> 1;
        int r15 = ComparisonsKt.compareValues(r5.get(r14), r10);
        if (r15 < 0) goto L6;
        if (r15 <= 0) goto L9;
        r13 = r14 - 1;
        goto L3
    L9:
        return r14;
    L6:
        r11 = r14 + 1;
        goto L3
    L11:
        return -(r11 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List r5, Comparable r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = r5.size();
    L9:
        return binarySearch(r5, r10, r11, r12);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> r5, K r10, int r11, int r12, Function1<? super T, ? extends K> r13) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r13, "selector");
        return binarySearch(r5, r11, r12, new AnonymousClass1(r13, r10));
    }

    public static /* synthetic */ int binarySearchBy$default(List r5, Comparable r10, int r11, int r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r12 = r5.size();
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r13, "selector");
        return binarySearch(r5, r11, r12, new AnonymousClass1(r13, r10));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> List<E> buildList(@BuilderInference Function1<? super List<E>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "builderAction");
        List r10 = CollectionsKt__CollectionsJVMKt.createListBuilder();
        r5.invoke(r10);
        return CollectionsKt__CollectionsJVMKt.build(r10);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        int r10 = 0;
        if (r5.isEmpty() == true) goto L5;
        Object[] r11 = new Object[r5.size()];
        Iterator<?> r12 = r5.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11[r10] = r12.next();
        r10 = r10 + 1;
        goto L8
    L10:
        return r11;
    L5:
        return new Object[0];
    }

    @InlineOnly
    private static final <T> boolean containsAll(Collection<? extends T> r5, Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        return r5.containsAll(r10);
    }

    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static IntRange getIndices(Collection<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new IntRange(0, r5.size() - 1);
    }

    public static <T> int getLastIndex(List<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object ifEmpty(Collection r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r10, "defaultValue");
        if (r5.isEmpty() == true) goto L5;
        return r5;
    L5:
        return r10.invoke();
    }

    @InlineOnly
    private static final <T> boolean isNotEmpty(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !r5.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean isNullOrEmpty(Collection<? extends T> r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (r5.isEmpty() == true) goto L7;
        return false;
    }

    public static <T> List<T> listOf(T... r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        if (r5.length <= 0) goto L6;
        return ArraysKt___ArraysJvmKt.asList(r5);
    L6:
        return emptyList();
    }

    public static <T> List<T> listOfNotNull(T r5) {
        if (r5 == null) goto L5;
        return CollectionsKt__CollectionsJVMKt.listOf(r5);
    L5:
        return emptyList();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = r5.size();
        if (r10 == 0) goto L9;
        if (r10 == 1) goto L10;
        return r5;
    L10:
        return CollectionsKt__CollectionsJVMKt.listOf(r5.get(0));
    L9:
        return emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Collection<T> orEmpty(Collection<? extends T> r5) {
        if (r5 == 0) goto L4;
        return r5;
    L4:
        return emptyList();
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int r5, int r10, int r11) {
        if (r10 > r11) goto L12;
        if (r10 < 0) goto L10;
        if (r11 > r5) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("toIndex (" + r11 + ") is greater than size (" + r5 + ").");
    L10:
        throw new IndexOutOfBoundsException(j0.h(r10, "fromIndex (", ") is less than zero."));
    L12:
        throw new IllegalArgumentException("fromIndex (" + r10 + ") is greater than toIndex (" + r11 + ").");
    }

    @SinceKotlin(version = "1.3")
    public static final <T> List<T> shuffled(Iterable<? extends T> r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        List<T> r11 = CollectionsKt___CollectionsKt.toMutableList(r5);
        CollectionsKt___CollectionsKt.shuffle(r11, r10);
        return r11;
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

    public static <T> ArrayList<T> arrayListOf(T... r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        if (r5.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new ArrayAsCollection(r5, true));
    }

    public static /* synthetic */ int binarySearch$default(List r5, Object r10, Comparator r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = r5.size();
    L9:
        return binarySearch(r5, r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <E> List<E> buildList(int r5, @BuilderInference Function1<? super List<E>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        List r11 = CollectionsKt__CollectionsJVMKt.createListBuilder(r5);
        r10.invoke(r11);
        return CollectionsKt__CollectionsJVMKt.build(r11);
    }

    @InlineOnly
    private static final <T> List<T> listOf() {
        return emptyList();
    }

    public static <T> List<T> listOfNotNull(T... r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return ArraysKt___ArraysKt.filterNotNull(r5);
    }

    public static <T> List<T> mutableListOf(T... r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        if (r5.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new ArrayAsCollection(r5, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> List<T> orEmpty(List<? extends T> r5) {
        if (r5 == 0) goto L4;
        return r5;
    L4:
        return emptyList();
    }

    public static /* synthetic */ int binarySearch$default(List r5, int r10, int r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.size();
    L9:
        return binarySearch(r5, r10, r11, r12);
    }

    public static final <T> int binarySearch(List<? extends T> r5, T r10, Comparator<? super T> r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(r5.size(), r12, r13);
        int r14 = r13 - 1;
    L3:
        if (r12 > r14) goto L11;
        int r15 = (r12 + r14) >>> 1;
        int r16 = r11.compare(r5.get(r15), r10);
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

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        Intrinsics.checkNotNullParameter(r10, "array");
        int r11 = 0;
        if (r5.isEmpty() == true) goto L5;
        int r12 = r10.length;
        Object[] r13 = r10;
        if (r12 >= r5.size()) goto L9;
        r13 = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(r10, r5.size());
    L9:
        Iterator<?> r14 = r5.iterator();
    L11:
        if (r14.hasNext() == false) goto L14;
        r13[r11] = r14.next();
        r11 = r11 + 1;
        goto L11
    L14:
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(r5.size(), r13);
    L5:
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(0, r10);
    }

    public static final <T> int binarySearch(List<? extends T> r5, int r10, int r11, Function1<? super T, Integer> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r12, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(r5.size(), r10, r11);
        int r13 = r11 - 1;
    L3:
        if (r10 > r13) goto L11;
        int r14 = (r10 + r13) >>> 1;
        int r15 = r12.invoke(r5.get(r14)).intValue();
        if (r15 < 0) goto L6;
        if (r15 <= 0) goto L9;
        r13 = r14 - 1;
        goto L3
    L9:
        return r14;
    L6:
        r10 = r14 + 1;
        goto L3
    L11:
        return -(r10 + 1);
    }
}
