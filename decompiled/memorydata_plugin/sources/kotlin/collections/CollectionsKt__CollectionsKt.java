package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.tom_roush.pdfbox.pdmodel.a.d.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\bø\u0001\u0000\u001aC\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\bø\u0001\u0000\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aN\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a!\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00182\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0002\u0010#\u001a3\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018\"\u0004\b\u0000\u0010\u00072\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010%\u001a\u0012\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020!2\b\u0010*\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010+\u001a3\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020!2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010(\u001a\u0015\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010-\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0002\b0\u001a\b\u00101\u001a\u00020\u001eH\u0001\u001a\b\u00102\u001a\u00020\u001eH\u0001\u001a%\u00103\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u00104\u001aS\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010*\u001a\u0002H\u00072\u001a\u00106\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000707j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`82\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u00109\u001a>\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00105\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070;*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010*\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u0010<\u001ag\u0010=\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u0010>*\b\u0012\u0004\u0012\u0002H>0;*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u0010?\u001a\u0004\u0018\u0001H>2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\u0016\b\u0004\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H>0\u000eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010A\u001a,\u0010B\u001a\u00020C\"\t\b\u0000\u0010\u0007¢\u0006\u0002\bD*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001aH\u0010E\u001a\u0002HF\"\u0010\b\u0000\u0010G*\u0006\u0012\u0002\b\u00030\u0002*\u0002HF\"\u0004\b\u0001\u0010F*\u0002HG2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0IH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010J\u001a\u0019\u0010K\u001a\u00020C\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a,\u0010L\u001a\u00020C\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u001e\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u001a!\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\u0087\b\u001a&\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070P2\u0006\u0010Q\u001a\u00020RH\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", ExifInterface.GPS_DIRECTION_TRUE, "", "getLastIndex", "(Ljava/util/List;)I", e.f16168a, "size", CommonConsts.APM_INNER_EVENT_COST_INIT, "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", ExifInterface.LONGITUDE_EAST, "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "collectionToArrayCommonImpl", "", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", "", "random", "Lkotlin/random/Random;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Integer> {

        /* JADX INFO: Incorrect field signature: TK; */
        final /* synthetic */ Comparable $key;
        final /* synthetic */ Function1<T, K> $selector;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TT;+TK;>;TK;)V */
        public AnonymousClass1(Function1 r3, Comparable r4) {
            Function1<T, K> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            this.$selector = r5;
            this.$key = r6;
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(T r3) {
            return Integer.valueOf(ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(this.$selector.invoke(r3), Comparable.class, "com.obric.memorydata.plugin"), this.$key));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Object r1) {
            return invoke(r1);
        }
    }

    public CollectionsKt__CollectionsKt() {
    }

    private static final <T> List<T> List(int r4, Function1<? super Integer, ? extends T> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, CommonConsts.APM_INNER_EVENT_COST_INIT);
        ArrayList r0 = new ArrayList(r4);
        int r2 = 0;
    L3:
        if (r2 >= r4) goto L6;
        r0.add(r6.invoke(Integer.valueOf(r2)));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final <T> List<T> MutableList(int r4, Function1<? super Integer, ? extends T> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, CommonConsts.APM_INNER_EVENT_COST_INIT);
        ArrayList r0 = new ArrayList(r4);
        int r2 = 0;
    L3:
        if (r2 >= r4) goto L6;
        r0.add(r6.invoke(Integer.valueOf(r2)));
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList();
    }

    public static final <T> ArrayList<T> arrayListOf(T... r3) {
        Intrinsics.checkNotNullParameter(r3, "elements");
        if (r3.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast(new ArrayAsCollection(r3, true), Collection.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Collection<T> asCollection(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (Collection) ZeusTransformUtils.preCheckCast(new ArrayAsCollection(r2, false), Collection.class, "com.obric.memorydata.plugin");
    }

    public static final <T> int binarySearch(List<? extends T> r4, int r5, int r6, Function1<? super T, Integer> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(r8.size(), r5, r6);
        int r10 = r6 - 1;
    L3:
        if (r5 > r10) goto L11;
        int r0 = (r5 + r10) >>> 1;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r8.get(r0)), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 < 0) goto L6;
        if (r2 <= 0) goto L9;
        r10 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r5 = r0 + 1;
        goto L3
    L11:
        return -(r5 + 1);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> r4, T r5, int r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(r8.size(), r6, r7);
        int r10 = r7 - 1;
    L3:
        if (r6 > r10) goto L11;
        int r0 = (r6 + r10) >>> 1;
        int r2 = ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(r8.get(r0), Comparable.class, "com.obric.memorydata.plugin"), r9);
        if (r2 < 0) goto L6;
        if (r2 <= 0) goto L9;
        r10 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r6 = r0 + 1;
        goto L3
    L11:
        return -(r6 + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> int binarySearch(List<? extends T> r2, T r3, Comparator<? super T> r4, int r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Comparator r8 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(r7.size(), r5, r6);
        int r9 = r6 - 1;
    L3:
        if (r5 > r9) goto L11;
        int r0 = (r5 + r9) >>> 1;
        int r1 = r8.compare(r7.get(r0), r3);
        if (r1 < 0) goto L6;
        if (r1 <= 0) goto L9;
        r9 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r5 = r0 + 1;
        goto L3
    L11:
        return -(r5 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List r1, int r2, int r3, Function1 r4, int r5, Object r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r7.size();
    L9:
        return CollectionsKt.binarySearch(r7, r2, r3, r8);
    }

    public static /* synthetic */ int binarySearch$default(List r1, Comparable r2, int r3, int r4, int r5, Object r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = r7.size();
    L9:
        return CollectionsKt.binarySearch(r7, r8, r3, r4);
    }

    public static /* synthetic */ int binarySearch$default(List r1, Object r2, Comparator r3, int r4, int r5, int r6, Object r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        Comparator r9 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = r8.size();
    L9:
        return CollectionsKt.binarySearch(r8, r2, r9, r4, r5);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> r2, K r3, int r4, int r5, Function1<? super T, ? extends K> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        return CollectionsKt.binarySearch(r7, r4, r5, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, r8), Function1.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ int binarySearchBy$default(List r1, Comparable r2, int r3, int r4, Function1 r5, int r6, Object r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = r8.size();
    L8:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "selector");
        return CollectionsKt.binarySearch(r8, r3, r4, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10, r9), Function1.class, "com.obric.memorydata.plugin"));
    }

    private static final <E> List<E> buildList(int r2, Function1<? super List<E>, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        List r5 = CollectionsKt.createListBuilder(r2);
        r4.invoke(r5);
        return CollectionsKt.build(r5);
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> r2) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "builderAction");
        List r0 = CollectionsKt.createListBuilder();
        r3.invoke(r0);
        return CollectionsKt.build(r0);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "collection");
        int r1 = 0;
        if (r5.isEmpty() == true) goto L5;
        Object[] r0 = new Object[r5.size()];
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0[r1] = r6.next();
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L5:
        return new Object[0];
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> r4, T[] r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "collection");
        Intrinsics.checkNotNullParameter(r5, "array");
        int r1 = 0;
        if (r6.isEmpty() == true) goto L5;
        int r0 = r5.length;
        Object[] r7 = r5;
        if (r0 >= r6.size()) goto L9;
        r7 = (T[]) ArraysKt.arrayOfNulls(r5, r6.size());
    L9:
        Iterator r2 = r6.iterator();
    L11:
        if (r2.hasNext() == false) goto L14;
        r7[r1] = r2.next();
        r1 = r1 + 1;
        goto L11
    L14:
        return (T[]) CollectionsKt.terminateCollectionToArray(r6.size(), r7);
    L5:
        return (T[]) CollectionsKt.terminateCollectionToArray(0, r5);
    }

    private static final <T> boolean containsAll(Collection<? extends T> r2, Collection<? extends T> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Collection<?> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "elements");
        return r4.containsAll(r5);
    }

    public static final <T> List<T> emptyList() {
        return (List) ZeusTransformUtils.preCheckCast(EmptyList.INSTANCE, List.class, "com.obric.memorydata.plugin");
    }

    public static final IntRange getIndices(Collection<?> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new IntRange(0, r3.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Collection r2, Function0 r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        if (r4.isEmpty() == true) goto L5;
        return r4;
    L5:
        return r5.invoke();
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return !r3.isEmpty();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        return false;
    }

    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOf(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        if (r1.length <= 0) goto L6;
        return ArraysKt.asList(r1);
    L6:
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOfNotNull(T r0) {
        if (r0 == null) goto L5;
        return CollectionsKt.listOf(r0);
    L5:
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        return ArraysKt.filterNotNull(r1);
    }

    private static final <T> List<T> mutableListOf() {
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static final <T> List<T> mutableListOf(T... r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        if (r4.length != 0) goto L5;
        Object r5 = ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L7:
        return (List) r5;
    L5:
        r5 = ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(new ArrayAsCollection(r4, true), Collection.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
        goto L7
    }

    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> r2) {
        List<T> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = r3.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L10;
        return r3;
    L10:
        return CollectionsKt.listOf(r3.get(0));
    L9:
        return CollectionsKt.emptyList();
    }

    private static final <T> Collection<T> orEmpty(Collection<? extends T> r2) {
        Collection<T> r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin");
    }

    private static final <T> List<T> orEmpty(List<? extends T> r2) {
        List<T> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return CollectionsKt.emptyList();
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int r3, int r4, int r5) {
        if (r4 > r5) goto L12;
        if (r4 < 0) goto L10;
        if (r5 > r3) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("toIndex (" + r5 + ") is greater than size (" + r3 + ").");
    L10:
        throw new IndexOutOfBoundsException("fromIndex (" + r4 + ") is less than zero.");
    L12:
        throw new IllegalArgumentException("fromIndex (" + r4 + ") is greater than toIndex (" + r5 + ").");
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> r2, Random r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "random");
        List<T> r5 = CollectionsKt.toMutableList(r4);
        CollectionsKt.shuffle(r5, r3);
        return r5;
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
