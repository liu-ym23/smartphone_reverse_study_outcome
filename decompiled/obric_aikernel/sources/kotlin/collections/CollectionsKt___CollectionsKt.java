package kotlin.collections;

import a1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,3683:1\n288#1,2:3684\n518#1,7:3686\n533#1,6:3693\n857#1,2:3700\n788#1:3702\n1864#1,2:3703\n789#1,2:3705\n1866#1:3707\n791#1:3708\n1864#1,3:3709\n809#1,2:3712\n847#1,2:3714\n1253#1,4:3720\n1222#1,4:3724\n1238#1,4:3728\n1285#1,4:3732\n1446#1,5:3736\n1461#1,5:3741\n1502#1,3:3746\n1505#1,3:3756\n1520#1,3:3759\n1523#1,3:3769\n1620#1,3:3786\n1590#1,4:3789\n1579#1:3793\n1864#1,2:3794\n1866#1:3797\n1580#1:3798\n1864#1,3:3799\n1611#1:3802\n1855#1:3803\n1856#1:3805\n1612#1:3806\n1855#1,2:3807\n1864#1,3:3809\n2847#1,3:3812\n2850#1,6:3816\n2872#1,3:3822\n2875#1,7:3826\n857#1,2:3833\n819#1:3835\n847#1,2:3836\n819#1:3838\n847#1,2:3839\n819#1:3841\n847#1,2:3842\n3405#1,8:3848\n3433#1,7:3856\n3464#1,10:3863\n1#2:3699\n1#2:3796\n1#2:3804\n1#2:3815\n1#2:3825\n37#3,2:3716\n37#3,2:3718\n372#4,7:3749\n372#4,7:3762\n372#4,7:3772\n372#4,7:3779\n32#5,2:3844\n32#5,2:3846\n*S KotlinDebug\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n167#1:3684,2\n177#1:3686,7\n187#1:3693,6\n766#1:3700,2\n777#1:3702\n777#1:3703,2\n777#1:3705,2\n777#1:3707\n777#1:3708\n788#1:3709,3\n800#1:3712,2\n819#1:3714,2\n1180#1:3720,4\n1195#1:3724,4\n1209#1:3728,4\n1272#1:3732,4\n1360#1:3736,5\n1373#1:3741,5\n1477#1:3746,3\n1477#1:3756,3\n1490#1:3759,3\n1490#1:3769,3\n1549#1:3786,3\n1559#1:3789,4\n1569#1:3793\n1569#1:3794,2\n1569#1:3797\n1569#1:3798\n1579#1:3799,3\n1603#1:3802\n1603#1:3803\n1603#1:3805\n1603#1:3806\n1611#1:3807,2\n2645#1:3809,3\n2949#1:3812,3\n2949#1:3816,6\n2967#1:3822,3\n2967#1:3826,7\n3143#1:3833,2\n3151#1:3835\n3151#1:3836,2\n3161#1:3838\n3161#1:3839,2\n3171#1:3841\n3171#1:3842,2\n3394#1:3848,8\n3422#1:3856,7\n3451#1:3863,10\n1569#1:3796\n1603#1:3804\n2949#1:3815\n2967#1:3825\n1032#1:3716,2\n1075#1:3718,2\n1477#1:3749,7\n1490#1:3762,7\n1504#1:3772,7\n1522#1:3779,7\n3339#1:3844,2\n3381#1:3846,2\n*E\n"})
class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public CollectionsKt___CollectionsKt() {
    }

    public static <T> boolean all(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<? extends T> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        if (r11.invoke(r12.next()).booleanValue() == true) goto L9;
        return false;
    L14:
        return true;
    L5:
        if (((Collection) r10).isEmpty() == false) goto L7;
        return true;
    }

    public static final <T> boolean any(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L7;
        return !((Collection) r10).isEmpty();
    L7:
        return r10.iterator().hasNext();
    }

    public static final <T> boolean any(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<? extends T> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        if (r11.invoke(r12.next()).booleanValue() == false) goto L9;
        return true;
    L14:
        return false;
    L5:
        if (((Collection) r10).isEmpty() == false) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Iterable<T> asIterable(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10;
    }

    public static <T> Sequence<T> asSequence(final Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(r10);
    }

    public static final <T, K, V> Map<K, V> associate(Iterable<? extends T> r10, Function1<? super T, ? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16));
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r14 = r11.invoke(r13.next());
        r12.put(r14.getFirst(), r14.getSecond());
        goto L4
    L6:
        return r12;
    }

    public static final <T, K> Map<K, T> associateBy(Iterable<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16));
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        T r14 = r13.next();
        r12.put(r11.invoke(r14), r14);
        goto L4
    L6:
        return r12;
    }

    public static final <T, K, V> Map<K, V> associateBy(Iterable<? extends T> r10, Function1<? super T, ? extends K> r11, Function1<? super T, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16));
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        T r15 = r14.next();
        r13.put(r11.invoke(r15), r12.invoke(r15));
        goto L4
    L6:
        return r13;
    }

    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Iterable<? extends T> r10, M r11, Function1<? super T, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        T r14 = r13.next();
        r11.put(r12.invoke(r14), r14);
        goto L4
    L6:
        return r11;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Iterable<? extends T> r10, M r11, Function1<? super T, ? extends K> r12, Function1<? super T, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        T r15 = r14.next();
        r11.put(r12.invoke(r15), r13.invoke(r15));
        goto L4
    L6:
        return r11;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Iterable<? extends T> r10, M r11, Function1<? super T, ? extends Pair<? extends K, ? extends V>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r14 = r12.invoke(r13.next());
        r11.put(r14.getFirst(), r14.getSecond());
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static final <K, V> Map<K, V> associateWith(Iterable<? extends K> r10, Function1<? super K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "valueSelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16));
        Iterator<? extends K> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        K r14 = r13.next();
        r12.put(r14, r11.invoke(r14));
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Iterable<? extends K> r10, M r11, Function1<? super K, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "valueSelector");
        Iterator<? extends K> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        K r14 = r13.next();
        r11.put(r14, r12.invoke(r14));
        goto L4
    L6:
        return r11;
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(Iterable<Byte> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Byte> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().byteValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfDouble")
    public static final double averageOfDouble(Iterable<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + r11.next().doubleValue();
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfFloat")
    public static final double averageOfFloat(Iterable<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().floatValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfInt")
    public static final double averageOfInt(Iterable<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Integer> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().intValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfLong")
    public static final double averageOfLong(Iterable<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Long> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + r11.next().longValue();
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfShort")
    public static final double averageOfShort(Iterable<Short> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Short> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().shortValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<List<T>> chunked(Iterable<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return windowed(r10, r11, r11, true);
    }

    @SinceKotlin(version = "1.2")
    public static final <T, R> List<R> chunked(Iterable<? extends T> r10, int r11, Function1<? super List<? extends T>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "transform");
        return windowed(r10, r11, r11, true, r12);
    }

    @InlineOnly
    private static final <T> T component1(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(0);
    }

    @InlineOnly
    private static final <T> T component2(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(1);
    }

    @InlineOnly
    private static final <T> T component3(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(2);
    }

    @InlineOnly
    private static final <T> T component4(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(3);
    }

    @InlineOnly
    private static final <T> T component5(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(4);
    }

    public static <T> boolean contains(Iterable<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L7;
        return ((Collection) r10).contains(r11);
    L7:
        if (indexOf(r10, r11) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static final <T> int count(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L5;
        int r11 = 0;
        Iterator<? extends T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        r12.next();
        r11 = r11 + 1;
        if (r11 >= 0) goto L8;
        CollectionsKt.throwCountOverflow();
        goto L8
    L12:
        return r11;
    L5:
        return ((Collection) r10).size();
    }

    public static final <T> int count(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<? extends T> r13 = r10.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        if (r11.invoke(r13.next()).booleanValue() == false) goto L9;
        r12 = r12 + 1;
        if (r12 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L15:
        return r12;
    L5:
        if (((Collection) r10).isEmpty() == false) goto L7;
        return 0;
    }

    @InlineOnly
    private static final <T> int count(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    public static <T> List<T> distinct(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.toList(CollectionsKt.toMutableSet(r10));
    }

    public static final <T, K> List<T> distinctBy(Iterable<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        HashSet r12 = new HashSet();
        ArrayList r13 = new ArrayList();
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        T r15 = r14.next();
        if (r12.add(r11.invoke(r15)) == false) goto L4;
        r13.add(r15);
        goto L4
    L8:
        return r13;
    }

    public static <T> List<T> drop(Iterable<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L42;
        if (r11 != 0) goto L11;
        return CollectionsKt.toList(r10);
    L11:
        if ((r10 instanceof Collection) == false) goto L31;
        Collection r14 = (Collection) r10;
        int r15 = r14.size() - r11;
        if (r15 <= 0) goto L15;
        if (r15 == 1) goto L18;
        ArrayList r16 = new ArrayList(r15);
        if ((r10 instanceof List) == true) goto L22;
    L32:
        Iterator<? extends T> r17 = r10.iterator();
    L34:
        if (r17.hasNext() == false) goto L40;
        T r18 = r17.next();
        if (r12 >= r11) goto L37;
        r12 = r12 + 1;
        goto L34
    L37:
        r16.add(r18);
        goto L34
    L40:
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(r16);
    L22:
        if ((r10 instanceof RandomAccess) == false) goto L26;
        int r19 = r14.size();
    L24:
        if (r11 >= r19) goto L30;
        r16.add(((List) r10).get(r11));
        r11 = r11 + 1;
    L30:
        return r16;
    L26:
        ListIterator r20 = ((List) r10).listIterator(r11);
    L28:
        if (r20.hasNext() == false) goto L30;
        r16.add(r20.next());
        goto L28
    L18:
        return CollectionsKt.listOf(CollectionsKt.last(r10));
    L15:
        return CollectionsKt.emptyList();
    L31:
        r16 = new ArrayList();
        goto L32
    L42:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r13 = false;
        goto L6
    }

    public static <T> List<T> dropLast(List<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return CollectionsKt.take(r10, RangesKt.coerceAtLeast(r10.size() - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final <T> List<T> dropLastWhile(List<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (r10.isEmpty() == true) goto L12;
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
    L6:
        if (r12.hasPrevious() == false) goto L12;
        if (r11.invoke(r12.previous()).booleanValue() == true) goto L6;
        return CollectionsKt.take(r10, r12.nextIndex() + 1);
    L12:
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> dropWhile(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L11;
        T r15 = r13.next();
        if (r14 == true) goto L7;
        if (r11.invoke(r15).booleanValue() == true) goto L4;
        r12.add(r15);
        r14 = true;
        goto L4
    L7:
        r12.add(r15);
        goto L4
    L11:
        return r12;
    }

    public static <T> T elementAt(Iterable<? extends T> r10, final int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == false) goto L7;
        return (T) ((List) r10).get(r11);
    L7:
        return (T) elementAtOrElse(r10, r11, new AnonymousClass1(r11));
    }

    @InlineOnly
    private static final <T> T elementAt(List<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.get(r11);
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> r10, int r11, Function1<? super Integer, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if ((r10 instanceof List) == false) goto L11;
        List r13 = (List) r10;
        if (r11 < 0) goto L10;
        if (r11 > CollectionsKt.getLastIndex(r13)) goto L10;
        return (T) r13.get(r11);
    L10:
        return r12.invoke(Integer.valueOf(r11));
    L11:
        if (r11 < 0) goto L13;
        Iterator<? extends T> r14 = r10.iterator();
        int r15 = 0;
    L16:
        if (r14.hasNext() == false) goto L13;
        T r16 = r14.next();
        int r17 = r15 + 1;
        if (r11 == r15) goto L19;
        r15 = r17;
        goto L16
    L19:
        return r16;
    L13:
        return r12.invoke(Integer.valueOf(r11));
    }

    @InlineOnly
    private static final <T> T elementAtOrElse(List<? extends T> r10, int r11, Function1<? super Integer, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > CollectionsKt.getLastIndex(r10)) goto L8;
        return r10.get(r11);
    L8:
        return r12.invoke(Integer.valueOf(r11));
    }

    public static final <T> T elementAtOrNull(Iterable<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == false) goto L7;
        return (T) CollectionsKt.getOrNull((List) r10, r11);
    L7:
        if (r11 >= 0) goto L9;
        return null;
    L9:
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L11:
        if (r12.hasNext() == false) goto L16;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r11 == r13) goto L14;
        r13 = r15;
        goto L11
    L14:
        return r14;
    L16:
        return null;
    }

    @InlineOnly
    private static final <T> T elementAtOrNull(List<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (T) CollectionsKt.getOrNull(r10, r11);
    }

    public static <T> List<T> filter(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        T r14 = r13.next();
        if (r11.invoke(r14).booleanValue() == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    public static final <T> List<T> filterIndexed(Iterable<? extends T> r10, Function2<? super Integer, ? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L12;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r11.invoke(Integer.valueOf(r14), r15).booleanValue() == false) goto L11;
        r12.add(r15);
    L11:
        r14 = r16;
        goto L4
    L12:
        return r12;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Iterable<? extends T> r10, C r11, Function2<? super Integer, ? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L12;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r12.invoke(Integer.valueOf(r14), r15).booleanValue() == false) goto L11;
        r11.add(r15);
    L11:
        r14 = r16;
        goto L4
    L12:
        return r11;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Iterable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = new ArrayList();
        Iterator<?> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        Intrinsics.reifiedOperationMarker(3, "R");
        if ((r13 instanceof Object) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Iterable<?> r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<?> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        Intrinsics.reifiedOperationMarker(3, "R");
        if ((r13 instanceof Object) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public static final <T> List<T> filterNot(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        T r14 = r13.next();
        if (r11.invoke(r14).booleanValue() == true) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    public static <T> List<T> filterNotNull(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (List) filterNotNullTo(r10, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (r13 == null) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Iterable<? extends T> r10, C r11, Function1<? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        T r14 = r13.next();
        if (r12.invoke(r14).booleanValue() == true) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Iterable<? extends T> r10, C r11, Function1<? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        T r14 = r13.next();
        if (r12.invoke(r14).booleanValue() == false) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @InlineOnly
    private static final <T> T find(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L8:
        return null;
    }

    @InlineOnly
    private static final <T> T findLast(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
    L4:
        if (r12.hasNext() == false) goto L8;
        T r14 = r12.next();
        if (r11.invoke(r14).booleanValue() == false) goto L4;
        r13 = r14;
        goto L4
    L8:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    @InlineOnly
    private static final <T> T findLast(List<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
    L4:
        if (r12.hasPrevious() == false) goto L8;
        T r13 = r12.previous();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L8:
        return null;
    }

    public static <T> T first(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L11;
        return r11.next();
    L11:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return (T) CollectionsKt.first((List) r10);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T first(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        T r13 = r12.next();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L9:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static <T> T first(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.get(0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R firstNotNullOf(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        R r13 = r11.invoke(r12.next());
        if (r13 == null) goto L4;
    L9:
        if (r13 == null) goto L12;
        return r13;
    L12:
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    L8:
        r13 = null;
        goto L9
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R firstNotNullOfOrNull(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        R r13 = r11.invoke(r12.next());
        if (r13 == null) goto L4;
        return r13;
    L8:
        return null;
    }

    public static <T> T firstOrNull(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == false) goto L9;
        List r11 = (List) r10;
        if (r11.isEmpty() == false) goto L8;
        return null;
    L8:
        return (T) r11.get(0);
    L9:
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L13;
        return null;
    L13:
        return r12.next();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T firstOrNull(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L8:
        return null;
    }

    public static <T> T firstOrNull(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return r10.get(0);
    }

    public static final <T, R> List<R> flatMap(Iterable<? extends T> r10, Function1<? super T, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r12, r11.invoke(r13.next()));
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R> List<R> flatMapIndexedIterable(Iterable<? extends T> r10, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CollectionsKt.addAll(r12, r11.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(Iterable<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequence")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R> List<R> flatMapIndexedSequence(Iterable<? extends T> r10, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CollectionsKt.addAll(r12, r11.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequenceTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(Iterable<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapSequence")
    public static final <T, R> List<R> flatMapSequence(Iterable<? extends T> r10, Function1<? super T, ? extends Sequence<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r12, r11.invoke(r13.next()));
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapSequenceTo")
    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(Iterable<? extends T> r10, C r11, Function1<? super T, ? extends Sequence<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Iterable<? extends T> r10, C r11, Function1<? super T, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    public static final <T, R> R fold(Iterable<? extends T> r10, R r11, Function2<? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        R r14 = r11;
        r11 = r12.invoke(r14, r13.next());
        goto L4
    L6:
        return r11;
    }

    public static final <T, R> R foldIndexed(Iterable<? extends T> r10, R r11, Function3<? super Integer, ? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r11 = r12.invoke(Integer.valueOf(r14), r11, r15);
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    public static final <T, R> R foldRight(List<? extends T> r10, R r11, Function2<? super T, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (r10.isEmpty() == true) goto L8;
        ListIterator<? extends T> r13 = r10.listIterator(r10.size());
    L6:
        if (r13.hasPrevious() == false) goto L8;
        r11 = r12.invoke(r13.previous(), r11);
    L8:
        return r11;
    }

    public static final <T, R> R foldRightIndexed(List<? extends T> r10, R r11, Function3<? super Integer, ? super T, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (r10.isEmpty() == true) goto L8;
        ListIterator<? extends T> r13 = r10.listIterator(r10.size());
    L6:
        if (r13.hasPrevious() == false) goto L8;
        r11 = r12.invoke(Integer.valueOf(r13.previousIndex()), r13.previous(), r11);
    L8:
        return r11;
    }

    @HidesMembers
    public static final <T> void forEach(Iterable<? extends T> r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.invoke(r12.next());
        goto L4
    }

    public static final <T> void forEachIndexed(Iterable<? extends T> r10, Function2<? super Integer, ? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r11.invoke(Integer.valueOf(r13), r14);
        r13 = r15;
        goto L4
    }

    @InlineOnly
    private static final <T> T getOrElse(List<? extends T> r10, int r11, Function1<? super Integer, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > CollectionsKt.getLastIndex(r10)) goto L8;
        return r10.get(r11);
    L8:
        return r12.invoke(Integer.valueOf(r11));
    }

    public static <T> T getOrNull(List<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > CollectionsKt.getLastIndex(r10)) goto L7;
        return r10.get(r11);
    }

    public static final <T, K> Map<K, List<T>> groupBy(Iterable<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        T r14 = r13.next();
        K r15 = r11.invoke(r14);
        Object r16 = r12.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L8:
        ((List) r16).add(r14);
        goto L4
    L9:
        return r12;
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(Iterable<? extends T> r10, Function1<? super T, ? extends K> r11, Function1<? super T, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        T r15 = r14.next();
        K r16 = r11.invoke(r15);
        List<V> r17 = r13.get(r16);
        if (r17 != null) goto L8;
        r17 = new ArrayList();
        r13.put(r16, r17);
    L8:
        r17.add(r12.invoke(r15));
        goto L4
    L9:
        return r13;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Iterable<? extends T> r10, M r11, Function1<? super T, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        T r14 = r13.next();
        K r15 = r12.invoke(r14);
        Object r16 = r11.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r11.put(r15, r16);
    L8:
        ((List) r16).add(r14);
        goto L4
    L9:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Iterable<? extends T> r10, M r11, Function1<? super T, ? extends K> r12, Function1<? super T, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        T r15 = r14.next();
        K r16 = r12.invoke(r15);
        Object r17 = r11.get(r16);
        if (r17 != null) goto L8;
        r17 = new ArrayList();
        r11.put(r16, r17);
    L8:
        ((List) r17).add(r13.invoke(r15));
        goto L4
    L9:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <T, K> Grouping<T, K> groupingBy(final Iterable<? extends T> r10, final Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        return new C03981(r10, r11);
    }

    public static final <T> int indexOf(Iterable<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        int r12 = 0;
        Iterator<? extends T> r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L16;
        T r14 = r13.next();
        if (r12 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        if (Intrinsics.areEqual(r11, r14) == true) goto L14;
        r12 = r12 + 1;
        goto L8
    L14:
        return r12;
    L16:
        return -1;
    L5:
        return ((List) r10).indexOf(r11);
    }

    public static <T> int indexOf(List<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.indexOf(r11);
    }

    public static final <T> int indexOfFirst(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        if (r13 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r11.invoke(r14).booleanValue() == true) goto L10;
        r13 = r13 + 1;
        goto L4
    L10:
        return r13;
    L12:
        return -1;
    }

    public static final <T> int indexOfFirst(List<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r11.invoke(r12.next()).booleanValue() == true) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        return r13;
    L9:
        return -1;
    }

    public static final <T> int indexOfLast(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = -1;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        T r15 = r12.next();
        if (r14 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r11.invoke(r15).booleanValue() == false) goto L11;
        r13 = r14;
    L11:
        r14 = r14 + 1;
        goto L4
    L12:
        return r13;
    }

    public static final <T> int indexOfLast(List<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
    L4:
        if (r12.hasPrevious() == false) goto L9;
        if (r11.invoke(r12.previous()).booleanValue() == false) goto L4;
        return r12.nextIndex();
    L9:
        return -1;
    }

    public static <T> Set<T> intersect(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Set<T> r12 = CollectionsKt.toMutableSet(r10);
        CollectionsKt__MutableCollectionsKt.retainAll(r12, r11);
        return r12;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> r10, A r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1<? super T, ? extends CharSequence> r17) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "buffer");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Intrinsics.checkNotNullParameter(r14, "postfix");
        Intrinsics.checkNotNullParameter(r16, "truncated");
        r11.append(r13);
        Iterator<? extends T> r18 = r10.iterator();
        int r19 = 0;
    L4:
        if (r18.hasNext() == false) goto L11;
        T r20 = r18.next();
        r19 = r19 + 1;
        if (r19 <= 1) goto L8;
        r11.append(r12);
    L8:
        if (r15 < 0) goto L10;
        if (r19 > r15) goto L11;
    L10:
        StringsKt.appendElement(r11, r20, r17);
    L11:
        if (r15 < 0) goto L14;
        if (r19 <= r15) goto L14;
        r11.append(r16);
    L14:
        r11.append(r14);
        return r11;
    }

    public static /* synthetic */ Appendable joinTo$default(Iterable r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17, int r18, Object r19) {
        if ((r18 & 2) == 0) goto L5;
        CharSequence r20 = ", ";
    L6:
        CharSequence r21 = "";
        if ((r18 & 4) == 0) goto L9;
        CharSequence r22 = "";
    L11:
        if ((r18 & 8) != 0) goto L15;
        r21 = r14;
    L15:
        if ((r18 & 16) == 0) goto L17;
        int r23 = -1;
    L19:
        if ((r18 & 32) == 0) goto L21;
        CharSequence r24 = "...";
    L23:
        if ((r18 & 64) == 0) goto L25;
        Function1 r25 = null;
    L27:
        return joinTo(r10, r11, r20, r22, r21, r23, r24, r25);
    L25:
        r25 = r17;
        goto L27
    L21:
        r24 = r16;
        goto L23
    L17:
        r23 = r15;
        goto L19
    L9:
        r22 = r13;
        goto L11
    L5:
        r20 = r12;
        goto L6
    }

    public static final <T> String joinToString(Iterable<? extends T> r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1<? super T, ? extends CharSequence> r16) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "separator");
        Intrinsics.checkNotNullParameter(r12, "prefix");
        Intrinsics.checkNotNullParameter(r13, "postfix");
        Intrinsics.checkNotNullParameter(r15, "truncated");
        String r17 = ((StringBuilder) joinTo(r10, new StringBuilder(), r11, r12, r13, r14, r15, r16)).toString();
        Intrinsics.checkNotNullExpressionValue(r17, "joinTo(StringBuilder(), …ed, transform).toString()");
        return r17;
    }

    public static /* synthetic */ String joinToString$default(Iterable r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L5;
        r11 = ", ";
    L5:
        CharSequence r19 = "";
        if ((r17 & 2) == 0) goto L8;
        CharSequence r110 = "";
    L10:
        if ((r17 & 4) != 0) goto L14;
        r19 = r13;
    L14:
        if ((r17 & 8) == 0) goto L16;
        r14 = -1;
    L16:
        int r20 = r14;
        if ((r17 & 16) == 0) goto L19;
        r15 = "...";
    L19:
        CharSequence r21 = r15;
        if ((r17 & 32) == 0) goto L22;
        r16 = null;
    L22:
        CharSequence r22 = r11;
        CharSequence r23 = r110;
        CharSequence r24 = r19;
        return joinToString(r10, r22, r23, r24, r20, r21, r16);
    L8:
        r110 = r12;
        goto L10
    }

    public static <T> T last(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L13;
    L8:
        T r12 = r11.next();
        if (r11.hasNext() == true) goto L8;
        return r12;
    L13:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return (T) CollectionsKt.last((List) r10);
    }

    public static final <T> T last(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
        boolean r14 = false;
    L4:
        if (r12.hasNext() == false) goto L8;
        T r15 = r12.next();
        if (r11.invoke(r15).booleanValue() == false) goto L4;
        r14 = true;
        r13 = r15;
        goto L4
    L8:
        if (r14 == false) goto L11;
        return r13;
    L11:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static <T> T last(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.get(CollectionsKt.getLastIndex(r10));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T last(List<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
    L4:
        if (r12.hasPrevious() == false) goto L9;
        T r13 = r12.previous();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L9:
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(Iterable<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        int r12 = -1;
        int r13 = 0;
        Iterator<? extends T> r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L16;
        T r15 = r14.next();
        if (r13 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        if (Intrinsics.areEqual(r11, r15) == false) goto L15;
        r12 = r13;
    L15:
        r13 = r13 + 1;
        goto L8
    L16:
        return r12;
    L5:
        return ((List) r10).lastIndexOf(r11);
    }

    public static final <T> int lastIndexOf(List<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.lastIndexOf(r11);
    }

    public static <T> T lastOrNull(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == false) goto L9;
        List r11 = (List) r10;
        if (r11.isEmpty() == false) goto L8;
        return null;
    L8:
        return (T) r11.get(r11.size() - 1);
    L9:
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L12;
        return null;
    L12:
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L12;
        return r13;
    }

    public static final <T> T lastOrNull(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
    L4:
        if (r12.hasNext() == false) goto L8;
        T r14 = r12.next();
        if (r11.invoke(r14).booleanValue() == false) goto L4;
        r13 = r14;
        goto L4
    L8:
        return r13;
    }

    public static <T> T lastOrNull(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return r10.get(r10.size() - 1);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T lastOrNull(List<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
    L4:
        if (r12.hasPrevious() == false) goto L8;
        T r13 = r12.previous();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L8:
        return null;
    }

    public static <T, R> List<R> map(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r11.invoke(r13.next()));
        goto L4
    L6:
        return r12;
    }

    public static final <T, R> List<R> mapIndexed(Iterable<? extends T> r10, Function2<? super Integer, ? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r12.add(r11.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r12;
    }

    public static final <T, R> List<R> mapIndexedNotNull(Iterable<? extends T> r10, Function2<? super Integer, ? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L12;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        R r17 = r11.invoke(Integer.valueOf(r14), r15);
        if (r17 == null) goto L11;
        r12.add(r17);
    L11:
        r14 = r16;
        goto L4
    L12:
        return r12;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Iterable<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L12;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        R r17 = r12.invoke(Integer.valueOf(r14), r15);
        if (r17 == null) goto L11;
        r11.add(r17);
    L11:
        r14 = r16;
        goto L4
    L12:
        return r11;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Iterable<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r11.add(r12.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    public static final <T, R> List<R> mapNotNull(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        R r14 = r11.invoke(r13.next());
        if (r14 == null) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Iterable<? extends T> r10, C r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        R r14 = r12.invoke(r13.next());
        if (r14 == null) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Iterable<? extends T> r10, C r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r11.add(r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L9;
        return r13;
    L9:
        R r14 = r11.invoke(r13);
    L10:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) >= 0) goto L14;
        r14 = r16;
        r13 = r15;
    L14:
        if (r12.hasNext() == true) goto L10;
        return (T) r13;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L15;
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L7;
        return r13;
    L7:
        R r14 = r11.invoke(r13);
    L8:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) >= 0) goto L12;
        r14 = r16;
        r13 = r15;
    L12:
        if (r12.hasNext() == true) goto L8;
        return (T) r13;
    L15:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double maxOf(Iterable<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        double r13 = r11.invoke(r12.next()).doubleValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.max(r13, r11.invoke(r12.next()).doubleValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m463maxOf(Iterable<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        float r13 = r11.invoke(r12.next()).floatValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.max(r13, r11.invoke(r12.next()).floatValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m464maxOf(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        R r13 = r11.invoke(r12.next());
    L6:
        if (r12.hasNext() == false) goto L10;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) >= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        R r13 = r11.invoke(r12.next());
    L8:
        if (r12.hasNext() == false) goto L12;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) >= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m465maxOfOrNull(Iterable<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        double r13 = r11.invoke(r12.next()).doubleValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.max(r13, r11.invoke(r12.next()).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m466maxOfOrNull(Iterable<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        float r13 = r11.invoke(r12.next()).floatValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.max(r13, r11.invoke(r12.next()).floatValue());
        goto L8
    L11:
        return Float.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R maxOfWith(Iterable<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == false) goto L12;
        R r14 = r12.invoke(r13.next());
    L6:
        if (r13.hasNext() == false) goto L10;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) >= 0) goto L6;
        r14 = r15;
        goto L6
    L10:
        return r14;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R maxOfWithOrNull(Iterable<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == true) goto L6;
        return null;
    L6:
        R r14 = r12.invoke(r13.next());
    L8:
        if (r13.hasNext() == false) goto L12;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) >= 0) goto L8;
        r14 = r15;
        goto L8
    L12:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        T r12 = r11.next();
    L8:
        if (r11.hasNext() == false) goto L12;
        T r13 = r11.next();
        if (r12.compareTo(r13) >= 0) goto L8;
        r12 = r13;
        goto L8
    L12:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Double m467maxOrNull(Iterable<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        double r12 = r11.next().doubleValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.next().doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m468maxOrNull(Iterable<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        float r12 = r11.next().floatValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.next().floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double maxOrThrow(Iterable<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        double r12 = r11.next().doubleValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.next().doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final float m469maxOrThrow(Iterable<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        float r12 = r11.next().floatValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.next().floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m470maxOrThrow(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L12;
        T r12 = r11.next();
    L6:
        if (r11.hasNext() == false) goto L10;
        T r13 = r11.next();
        if (r12.compareTo(r13) >= 0) goto L6;
        r12 = r13;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T maxWithOrNull(Iterable<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
    L8:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        if (r11.compare(r13, r14) >= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final <T> T maxWithOrThrow(Iterable<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        T r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L10;
        T r14 = r12.next();
        if (r11.compare(r13, r14) >= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T minByOrNull(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L9;
        return r13;
    L9:
        R r14 = r11.invoke(r13);
    L10:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) <= 0) goto L14;
        r14 = r16;
        r13 = r15;
    L14:
        if (r12.hasNext() == true) goto L10;
        return (T) r13;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T minByOrThrow(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L15;
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L7;
        return r13;
    L7:
        R r14 = r11.invoke(r13);
    L8:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) <= 0) goto L12;
        r14 = r16;
        r13 = r15;
    L12:
        if (r12.hasNext() == true) goto L8;
        return (T) r13;
    L15:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double minOf(Iterable<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        double r13 = r11.invoke(r12.next()).doubleValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.min(r13, r11.invoke(r12.next()).doubleValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m471minOf(Iterable<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        float r13 = r11.invoke(r12.next()).floatValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.min(r13, r11.invoke(r12.next()).floatValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m472minOf(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        R r13 = r11.invoke(r12.next());
    L6:
        if (r12.hasNext() == false) goto L10;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) <= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R minOfOrNull(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        R r13 = r11.invoke(r12.next());
    L8:
        if (r12.hasNext() == false) goto L12;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) <= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m473minOfOrNull(Iterable<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        double r13 = r11.invoke(r12.next()).doubleValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.min(r13, r11.invoke(r12.next()).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m474minOfOrNull(Iterable<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        float r13 = r11.invoke(r12.next()).floatValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.min(r13, r11.invoke(r12.next()).floatValue());
        goto L8
    L11:
        return Float.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R minOfWith(Iterable<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == false) goto L12;
        R r14 = r12.invoke(r13.next());
    L6:
        if (r13.hasNext() == false) goto L10;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) <= 0) goto L6;
        r14 = r15;
        goto L6
    L10:
        return r14;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R minOfWithOrNull(Iterable<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == true) goto L6;
        return null;
    L6:
        R r14 = r12.invoke(r13.next());
    L8:
        if (r13.hasNext() == false) goto L12;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) <= 0) goto L8;
        r14 = r15;
        goto L8
    L12:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    public static <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        T r12 = r11.next();
    L8:
        if (r11.hasNext() == false) goto L12;
        T r13 = r11.next();
        if (r12.compareTo(r13) <= 0) goto L8;
        r12 = r13;
        goto L8
    L12:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m475minOrNull(Iterable<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        double r12 = r11.next().doubleValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.next().doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m476minOrNull(Iterable<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        float r12 = r11.next().floatValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.next().floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double minOrThrow(Iterable<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        double r12 = r11.next().doubleValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.next().doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final float m477minOrThrow(Iterable<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        float r12 = r11.next().floatValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.next().floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m478minOrThrow(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L12;
        T r12 = r11.next();
    L6:
        if (r11.hasNext() == false) goto L10;
        T r13 = r11.next();
        if (r12.compareTo(r13) <= 0) goto L6;
        r12 = r13;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T minWithOrNull(Iterable<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
    L8:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        if (r11.compare(r13, r14) <= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final <T> T minWithOrThrow(Iterable<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        T r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L10;
        T r14 = r12.next();
        if (r11.compare(r13, r14) <= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    public static final <T> List<T> minus(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        Collection r12 = CollectionsKt.convertToListIfNotCollection(r11);
        if (r12.isEmpty() == true) goto L5;
        ArrayList r13 = new ArrayList();
        Iterator<? extends T> r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        T r15 = r14.next();
        if (r12.contains(r15) == true) goto L8;
        r13.add(r15);
        goto L8
    L12:
        return r13;
    L5:
        return CollectionsKt.toList(r10);
    }

    public static <T> List<T> minus(Iterable<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<? extends T> r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L12;
        T r15 = r13.next();
        boolean r16 = true;
        if (r14 == false) goto L8;
    L10:
        if (r16 == false) goto L4;
        r12.add(r15);
        goto L4
    L8:
        if (Intrinsics.areEqual(r15, r11) == false) goto L10;
        r14 = true;
        r16 = false;
        goto L10
    L12:
        return r12;
    }

    public static final <T> List<T> minus(Iterable<? extends T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        List r12 = SequencesKt.toList(r11);
        if (r12.isEmpty() == true) goto L5;
        ArrayList r13 = new ArrayList();
        Iterator<? extends T> r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        T r15 = r14.next();
        if (r12.contains(r15) == true) goto L8;
        r13.add(r15);
        goto L8
    L12:
        return r13;
    L5:
        return CollectionsKt.toList(r10);
    }

    public static final <T> List<T> minus(Iterable<? extends T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        ArrayList r13 = new ArrayList();
        Iterator<? extends T> r14 = r10.iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        T r15 = r14.next();
        if (ArraysKt.contains(r11, r15) == true) goto L11;
        r13.add(r15);
        goto L11
    L15:
        return r13;
    L8:
        return CollectionsKt.toList(r10);
    L5:
        r12 = false;
        goto L6
    }

    @InlineOnly
    private static final <T> List<T> minusElement(Iterable<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.minus(r10, r11);
    }

    public static final <T> boolean none(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L7;
        return ((Collection) r10).isEmpty();
    L7:
        return !r10.iterator().hasNext();
    }

    public static final <T> boolean none(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<? extends T> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        if (r11.invoke(r12.next()).booleanValue() == false) goto L9;
        return false;
    L14:
        return true;
    L5:
        if (((Collection) r10).isEmpty() == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final <T, C extends Iterable<? extends T>> C onEach(C r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.invoke(r12.next());
        goto L4
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    public static final <T, C extends Iterable<? extends T>> C onEachIndexed(C r10, Function2<? super Integer, ? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r11.invoke(Integer.valueOf(r13), r14);
        r13 = r15;
        goto L4
    L9:
        return r10;
    }

    public static final <T> Pair<List<T>, List<T>> partition(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        T r15 = r14.next();
        if (r11.invoke(r15).booleanValue() == true) goto L7;
        r13.add(r15);
        goto L4
    L7:
        r12.add(r15);
        goto L4
    L10:
        return new Pair(r12, r13);
    }

    public static <T> List<T> plus(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if ((r10 instanceof Collection) == true) goto L5;
        ArrayList r12 = new ArrayList();
        CollectionsKt.addAll(r12, r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    L5:
        return CollectionsKt.plus((Collection) r10, r11);
    }

    public static <T> List<T> plus(Iterable<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L5;
        ArrayList r12 = new ArrayList();
        CollectionsKt.addAll(r12, r10);
        r12.add(r11);
        return r12;
    L5:
        return CollectionsKt.plus((Collection) r10, r11);
    }

    public static final <T> List<T> plus(Iterable<? extends T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        ArrayList r12 = new ArrayList();
        CollectionsKt.addAll(r12, r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    }

    public static final <T> List<T> plus(Iterable<? extends T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if ((r10 instanceof Collection) == true) goto L5;
        ArrayList r12 = new ArrayList();
        CollectionsKt.addAll(r12, r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    L5:
        return plus((Collection) r10, r11);
    }

    public static <T> List<T> plus(Collection<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if ((r11 instanceof Collection) == false) goto L6;
        Collection r12 = (Collection) r11;
        ArrayList r13 = new ArrayList(r10.size() + r12.size());
        r13.addAll(r10);
        r13.addAll(r12);
        return r13;
    L6:
        ArrayList r14 = new ArrayList(r10);
        CollectionsKt.addAll(r14, r11);
        return r14;
    }

    public static <T> List<T> plus(Collection<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r12 = new ArrayList(r10.size() + 1);
        r12.addAll(r10);
        r12.add(r11);
        return r12;
    }

    public static final <T> List<T> plus(Collection<? extends T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        ArrayList r12 = new ArrayList(r10.size() + 10);
        r12.addAll(r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    }

    public static final <T> List<T> plus(Collection<? extends T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        ArrayList r12 = new ArrayList(r10.size() + r11.length);
        r12.addAll(r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    }

    @InlineOnly
    private static final <T> List<T> plusElement(Iterable<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.plus(r10, r11);
    }

    @InlineOnly
    private static final <T> List<T> plusElement(Collection<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.plus(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T random(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (T) random(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T random(Collection<? extends T> r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.isEmpty() == true) goto L7;
        return (T) CollectionsKt.elementAt(r10, r11.nextInt(r10.size()));
    L7:
        throw new NoSuchElementException("Collection is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final <T> T randomOrNull(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (T) randomOrNull(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T randomOrNull(Collection<? extends T> r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return (T) CollectionsKt.elementAt(r10, r11.nextInt(r10.size()));
    }

    public static final <S, T extends S> S reduce(Iterable<? extends T> r10, Function2<? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        S r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L8;
        S r14 = r13;
        r13 = r11.invoke(r14, r12.next());
        goto L6
    L8:
        return r13;
    L10:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(Iterable<? extends T> r10, Function3<? super Integer, ? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L13;
        S r13 = r12.next();
        int r14 = 1;
    L6:
        if (r12.hasNext() == false) goto L11;
        int r15 = r14 + 1;
        if (r14 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        S r16 = r13;
        r13 = r11.invoke(Integer.valueOf(r14), r16, r12.next());
        r14 = r15;
        goto L6
    L11:
        return r13;
    L13:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final <S, T extends S> S reduceIndexedOrNull(Iterable<? extends T> r10, Function3<? super Integer, ? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        S r13 = r12.next();
        int r14 = 1;
    L8:
        if (r12.hasNext() == false) goto L13;
        int r15 = r14 + 1;
        if (r14 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        S r16 = r13;
        r13 = r11.invoke(Integer.valueOf(r14), r16, r12.next());
        r14 = r15;
        goto L8
    L13:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceOrNull(Iterable<? extends T> r10, Function2<? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        S r13 = r12.next();
    L8:
        if (r12.hasNext() == false) goto L10;
        S r14 = r13;
        r13 = r11.invoke(r14, r12.next());
        goto L8
    L10:
        return r13;
    }

    public static final <S, T extends S> S reduceRight(List<? extends T> r10, Function2<? super T, ? super S, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
        if (r12.hasPrevious() == false) goto L10;
        S r13 = r12.previous();
    L6:
        if (r12.hasPrevious() == false) goto L8;
        r13 = r11.invoke(r12.previous(), r13);
        goto L6
    L8:
        return r13;
    L10:
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexed(List<? extends T> r10, Function3<? super Integer, ? super T, ? super S, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
        if (r12.hasPrevious() == false) goto L10;
        S r13 = r12.previous();
    L6:
        if (r12.hasPrevious() == false) goto L8;
        r13 = r11.invoke(Integer.valueOf(r12.previousIndex()), r12.previous(), r13);
        goto L6
    L8:
        return r13;
    L10:
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final <S, T extends S> S reduceRightIndexedOrNull(List<? extends T> r10, Function3<? super Integer, ? super T, ? super S, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
        if (r12.hasPrevious() == true) goto L6;
        return null;
    L6:
        S r13 = r12.previous();
    L8:
        if (r12.hasPrevious() == false) goto L10;
        r13 = r11.invoke(Integer.valueOf(r12.previousIndex()), r12.previous(), r13);
        goto L8
    L10:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceRightOrNull(List<? extends T> r10, Function2<? super T, ? super S, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
        if (r12.hasPrevious() == true) goto L6;
        return null;
    L6:
        S r13 = r12.previous();
    L8:
        if (r12.hasPrevious() == false) goto L10;
        r13 = r11.invoke(r12.previous(), r13);
        goto L8
    L10:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Iterable<T> requireNoNulls(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        if (r11.next() != null) goto L4;
        throw new IllegalArgumentException("null element found in " + r10 + '.');
    L10:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> requireNoNulls(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        if (r11.next() != null) goto L4;
        throw new IllegalArgumentException("null element found in " + r10 + '.');
    L10:
        return r10;
    }

    public static <T> List<T> reversed(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == true) goto L5;
    L8:
        List<T> r11 = toMutableList(r10);
        CollectionsKt.reverse(r11);
        return r11;
    L5:
        if (((Collection) r10).size() > 1) goto L8;
        return CollectionsKt.toList(r10);
    }

    @SinceKotlin(version = "1.4")
    public static final <T, R> List<R> runningFold(Iterable<? extends T> r10, R r11, Function2<? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = CollectionsKt.collectionSizeOrDefault(r10, 9);
        if (r13 == 0) goto L5;
        ArrayList r14 = new ArrayList(r13 + 1);
        r14.add(r11);
        Iterator<? extends T> r15 = r10.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        R r16 = r11;
        r11 = r12.invoke(r16, r15.next());
        r14.add(r11);
        goto L8
    L10:
        return r14;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    public static final <T, R> List<R> runningFoldIndexed(Iterable<? extends T> r10, R r11, Function3<? super Integer, ? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = CollectionsKt.collectionSizeOrDefault(r10, 9);
        if (r13 == 0) goto L5;
        ArrayList r14 = new ArrayList(r13 + 1);
        r14.add(r11);
        int r15 = 0;
        Iterator<? extends T> r16 = r10.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        T r17 = r16.next();
        int r18 = r15 + 1;
        r11 = r12.invoke(Integer.valueOf(r15), r11, r17);
        r14.add(r11);
        r15 = r18;
        goto L8
    L10:
        return r14;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> List<S> runningReduce(Iterable<? extends T> r10, Function2<? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L5;
        S r13 = r12.next();
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
    L7:
        r14.add(r13);
        if (r12.hasNext() == false) goto L10;
        c r15 = r13;
        r13 = r11.invoke(r15, r12.next());
        goto L7
    L10:
        return r14;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    public static final <S, T extends S> List<S> runningReduceIndexed(Iterable<? extends T> r10, Function3<? super Integer, ? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L5;
        S r13 = r12.next();
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        r14.add(r13);
        int r15 = 1;
    L8:
        if (r12.hasNext() == false) goto L10;
        int r16 = r15 + 1;
        c r17 = r13;
        r13 = r11.invoke(Integer.valueOf(r15), r17, r12.next());
        r14.add(r13);
        r15 = r16;
        goto L8
    L10:
        return r14;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> List<R> scan(Iterable<? extends T> r10, R r11, Function2<? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = CollectionsKt.collectionSizeOrDefault(r10, 9);
        if (r13 == 0) goto L12;
        ArrayList r14 = new ArrayList(r13 + 1);
        r14.add(r11);
        Iterator<? extends T> r15 = r10.iterator();
    L7:
        if (r15.hasNext() == false) goto L10;
        R r16 = r11;
        r11 = r12.invoke(r16, r15.next());
        r14.add(r11);
        goto L7
    L10:
        return r14;
    L12:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> List<R> scanIndexed(Iterable<? extends T> r10, R r11, Function3<? super Integer, ? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = CollectionsKt.collectionSizeOrDefault(r10, 9);
        if (r13 == 0) goto L12;
        ArrayList r14 = new ArrayList(r13 + 1);
        r14.add(r11);
        int r15 = 0;
        Iterator<? extends T> r16 = r10.iterator();
    L7:
        if (r16.hasNext() == false) goto L10;
        T r17 = r16.next();
        int r18 = r15 + 1;
        r11 = r12.invoke(Integer.valueOf(r15), r11, r17);
        r14.add(r11);
        r15 = r18;
        goto L7
    L10:
        return r14;
    L12:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void shuffle(List<T> r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        int r12 = CollectionsKt.getLastIndex(r10);
    L3:
        if (r12 <= 0) goto L5;
        int r13 = r11.nextInt(r12 + 1);
        r10.set(r13, r10.set(r12, r10.get(r13)));
        r12 = r12 - 1;
        goto L3
    }

    public static <T> T single(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == true) goto L5;
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L14;
        T r12 = r11.next();
        if (r11.hasNext() == true) goto L12;
        return r12;
    L12:
        throw new IllegalArgumentException("Collection has more than one element.");
    L14:
        throw new NoSuchElementException("Collection is empty.");
    L5:
        return (T) CollectionsKt.single((List) r10);
    }

    public static final <T> T single(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
        boolean r14 = false;
    L4:
        if (r12.hasNext() == false) goto L11;
        T r15 = r12.next();
        if (r11.invoke(r15).booleanValue() == false) goto L4;
        if (r14 == true) goto L10;
        r14 = true;
        r13 = r15;
        goto L4
    L10:
        throw new IllegalArgumentException("Collection contains more than one matching element.");
    L11:
        if (r14 == false) goto L14;
        return r13;
    L14:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static <T> T single(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L9;
        return r10.get(0);
    L9:
        throw new IllegalArgumentException("List has more than one element.");
    L11:
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T singleOrNull(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof List) == false) goto L8;
        List r11 = (List) r10;
        if (r11.size() == 1) goto L7;
        return null;
    L7:
        return (T) r11.get(0);
    L8:
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L11;
        return null;
    L11:
        T r13 = r12.next();
        if (r12.hasNext() == false) goto L14;
        return null;
    L14:
        return r13;
    }

    public static final <T> T singleOrNull(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        boolean r13 = false;
        T r14 = null;
    L4:
        if (r12.hasNext() == false) goto L10;
        T r15 = r12.next();
        if (r11.invoke(r15).booleanValue() == false) goto L4;
        if (r13 == true) goto L8;
        r13 = true;
        r14 = r15;
        goto L4
    L8:
        return null;
    L10:
        if (r13 == true) goto L12;
        return null;
    L12:
        return r14;
    }

    public static <T> T singleOrNull(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 1) goto L7;
        return null;
    L7:
        return r10.get(0);
    }

    public static final <T> List<T> slice(List<? extends T> r10, Iterable<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indices");
        int r12 = CollectionsKt.collectionSizeOrDefault(r11, 10);
        if (r12 == 0) goto L5;
        ArrayList r13 = new ArrayList(r12);
        Iterator<Integer> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(r10.get(r14.next().intValue()));
        goto L8
    L10:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> slice(List<? extends T> r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indices");
        if (r11.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.toList(r10.subList(r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1));
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(List<T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.size() <= 1) goto L6;
        CollectionsKt.sortWith(r10, new ComparisonsKt__ComparisonsKt.AnonymousClass2(r11));
        return;
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(List<T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.size() <= 1) goto L6;
        CollectionsKt.sortWith(r10, new ComparisonsKt__ComparisonsKt.AnonymousClass1(r11));
        return;
    }

    public static final <T extends Comparable<? super T>> void sortDescending(List<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CollectionsKt.sortWith(r10, ComparisonsKt.reverseOrder());
    }

    public static <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L10;
        Collection r11 = (Collection) r10;
        if (r11.size() <= 1) goto L7;
        Object[] r12 = r11.toArray(new Comparable[0]);
        ArraysKt___ArraysJvmKt.sort((Comparable[]) r12);
        return ArraysKt.asList(r12);
    L7:
        return CollectionsKt.toList(r10);
    L10:
        List<T> r13 = toMutableList(r10);
        CollectionsKt.sort(r13);
        return r13;
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return CollectionsKt.sortedWith(r10, new ComparisonsKt__ComparisonsKt.AnonymousClass2(r11));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(Iterable<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return CollectionsKt.sortedWith(r10, new ComparisonsKt__ComparisonsKt.AnonymousClass1(r11));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.sortedWith(r10, ComparisonsKt.reverseOrder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> sortedWith(Iterable<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if ((r10 instanceof Collection) == false) goto L10;
        Collection r12 = (Collection) r10;
        if (r12.size() <= 1) goto L7;
        Object[] r13 = r12.toArray(new Object[0]);
        ArraysKt___ArraysJvmKt.sortWith(r13, r11);
        return ArraysKt.asList(r13);
    L7:
        return CollectionsKt.toList(r10);
    L10:
        List<T> r14 = toMutableList(r10);
        CollectionsKt.sortWith(r14, r11);
        return r14;
    }

    public static final <T> Set<T> subtract(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Set<T> r12 = CollectionsKt.toMutableSet(r10);
        CollectionsKt__MutableCollectionsKt.removeAll(r12, r11);
        return r12;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int sumBy(Iterable<? extends T> r10, Function1<? super T, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).intValue();
        goto L4
    L6:
        return r13;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double sumByDouble(Iterable<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        double r13 = 0.0d;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).doubleValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(Iterable<Byte> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Byte> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().byteValue();
        goto L4
    L6:
        return r12;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(Iterable<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        double r12 = 0.0d;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().doubleValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final <T> double sumOfDouble(Iterable<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        double r13 = 0.0d;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).doubleValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(Iterable<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        float r12 = 0.0f;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().floatValue();
        goto L4
    L6:
        return r12;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(Iterable<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Integer> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().intValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfInt")
    @OverloadResolutionByLambdaReturnType
    private static final <T> int sumOfInt(Iterable<? extends T> r10, Function1<? super T, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).intValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfLong")
    public static final long sumOfLong(Iterable<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Long> r11 = r10.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().longValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long sumOfLong(Iterable<? extends T> r10, Function1<? super T, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        long r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).longValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(Iterable<Short> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Short> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().shortValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final <T> int sumOfUInt(Iterable<? extends T> r10, Function1<? super T, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UInt.m127constructorimpl(0);
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = UInt.m127constructorimpl(r12 + r11.invoke(r13.next()).m179unboximpl());
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final <T> long sumOfULong(Iterable<? extends T> r10, Function1<? super T, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = ULong.m206constructorimpl(0);
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = ULong.m206constructorimpl(r12 + r11.invoke(r13.next()).m258unboximpl());
        goto L4
    L6:
        return r12;
    }

    public static <T> List<T> take(Iterable<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L27;
        if (r11 != 0) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if ((r10 instanceof Collection) == true) goto L13;
    L19:
        ArrayList r14 = new ArrayList(r11);
        Iterator<? extends T> r15 = r10.iterator();
    L21:
        if (r15.hasNext() == false) goto L25;
        r14.add(r15.next());
        r12 = r12 + 1;
        if (r12 != r11) goto L21;
    L25:
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(r14);
    L13:
        if (r11 >= ((Collection) r10).size()) goto L15;
        if (r11 != 1) goto L19;
        return CollectionsKt.listOf(CollectionsKt.first(r10));
    L15:
        return CollectionsKt.toList(r10);
    L27:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r13 = false;
        goto L6
    }

    public static <T> List<T> takeLast(List<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L28;
        if (r11 == 0) goto L9;
        int r13 = r10.size();
        if (r11 >= r13) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        if ((r10 instanceof RandomAccess) == false) goto L22;
        int r15 = r13 - r11;
    L20:
        if (r15 >= r13) goto L26;
        r14.add(r10.get(r15));
        r15 = r15 + 1;
    L26:
        return r14;
    L22:
        ListIterator<? extends T> r16 = r10.listIterator(r13 - r11);
    L24:
        if (r16.hasNext() == false) goto L26;
        r14.add(r16.next());
        goto L24
    L16:
        return CollectionsKt.listOf(CollectionsKt.last(r10));
    L13:
        return CollectionsKt.toList(r10);
    L9:
        return CollectionsKt.emptyList();
    L28:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final <T> List<T> takeLastWhile(List<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (r10.isEmpty() == true) goto L5;
        ListIterator<? extends T> r12 = r10.listIterator(r10.size());
    L8:
        if (r12.hasPrevious() == false) goto L21;
        if (r11.invoke(r12.previous()).booleanValue() == true) goto L8;
        r12.next();
        int r13 = r10.size() - r12.nextIndex();
        if (r13 == 0) goto L14;
        ArrayList r14 = new ArrayList(r13);
    L17:
        if (r12.hasNext() == false) goto L19;
        r14.add(r12.next());
        goto L17
    L19:
        return r14;
    L14:
        return CollectionsKt.emptyList();
    L21:
        return CollectionsKt.toList(r10);
    L5:
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> takeWhile(Iterable<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        T r14 = r13.next();
        if (r11.invoke(r14).booleanValue() == false) goto L9;
        r12.add(r14);
    L9:
        return r12;
    }

    public static boolean[] toBooleanArray(Collection<Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean[] r11 = new boolean[r10.size()];
        Iterator<Boolean> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().booleanValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final byte[] toByteArray(Collection<Byte> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = new byte[r10.size()];
        Iterator<Byte> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().byteValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final char[] toCharArray(Collection<Character> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        char[] r11 = new char[r10.size()];
        Iterator<Character> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().charValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(r12.next());
        goto L4
    L6:
        return r11;
    }

    public static double[] toDoubleArray(Collection<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        double[] r11 = new double[r10.size()];
        Iterator<Double> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().doubleValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static float[] toFloatArray(Collection<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float[] r11 = new float[r10.size()];
        Iterator<Float> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().floatValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <T> HashSet<T> toHashSet(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (HashSet) toCollection(r10, new HashSet(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 12))));
    }

    public static int[] toIntArray(Collection<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int[] r11 = new int[r10.size()];
        Iterator<Integer> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().intValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static <T> List<T> toList(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L17;
        Collection r11 = (Collection) r10;
        int r12 = r11.size();
        if (r12 == 0) goto L15;
        if (r12 == 1) goto L10;
        return CollectionsKt.toMutableList(r11);
    L10:
        if ((r10 instanceof List) == false) goto L12;
        Object r13 = ((List) r10).get(0);
    L19:
        return CollectionsKt.listOf(r13);
    L12:
        r13 = r10.iterator().next();
        goto L19
    L15:
        return CollectionsKt.emptyList();
    L17:
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(r10));
    }

    public static long[] toLongArray(Collection<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long[] r11 = new long[r10.size()];
        Iterator<Long> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().longValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L7;
        return CollectionsKt.toMutableList((Collection) r10);
    L7:
        return (List) toCollection(r10, new ArrayList());
    }

    public static <T> List<T> toMutableList(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new ArrayList(r10);
    }

    public static <T> Set<T> toMutableSet(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L6;
        return new LinkedHashSet((Collection) r10);
    L6:
        return (Set) toCollection(r10, new LinkedHashSet());
    }

    public static <T> Set<T> toSet(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L17;
        Collection r11 = (Collection) r10;
        int r12 = r11.size();
        if (r12 == 0) goto L15;
        if (r12 == 1) goto L10;
        return (Set) toCollection(r10, new LinkedHashSet(MapsKt.mapCapacity(r11.size())));
    L10:
        if ((r10 instanceof List) == false) goto L12;
        Object r13 = ((List) r10).get(0);
    L19:
        return SetsKt.setOf(r13);
    L12:
        r13 = r10.iterator().next();
        goto L19
    L15:
        return SetsKt.emptySet();
    L17:
        return SetsKt__SetsKt.optimizeReadOnlySet((Set) toCollection(r10, new LinkedHashSet()));
    }

    public static final short[] toShortArray(Collection<Short> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        short[] r11 = new short[r10.size()];
        Iterator<Short> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next().shortValue();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static <T> Set<T> union(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Set<T> r12 = CollectionsKt.toMutableSet(r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<List<T>> windowed(Iterable<? extends T> r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SlidingWindowKt.checkWindowSizeStep(r11, r12);
        if ((r10 instanceof RandomAccess) == true) goto L5;
    L24:
        ArrayList r14 = new ArrayList();
        Iterator r15 = SlidingWindowKt.windowedIterator(r10.iterator(), r11, r12, r13, false);
    L26:
        if (r15.hasNext() == false) goto L28;
        r14.add((List) r15.next());
        goto L26
    L28:
        return r14;
    L5:
        if ((r10 instanceof List) == false) goto L24;
        List r16 = (List) r10;
        int r17 = r16.size();
        int r18 = r17 / r12;
        if ((r17 % r12) != 0) goto L9;
        int r19 = 0;
    L10:
        ArrayList r20 = new ArrayList(r18 + r19);
        int r21 = 0;
    L11:
        if (r21 < 0) goto L14;
        if (r21 >= r17) goto L14;
        boolean r22 = true;
    L15:
        if (r22 == false) goto L23;
        int r23 = RangesKt.coerceAtMost(r11, r17 - r21);
        if (r23 >= r11) goto L19;
        if (r13 == false) goto L23;
    L19:
        ArrayList r24 = new ArrayList(r23);
        int r25 = 0;
    L20:
        if (r25 >= r23) goto L22;
        r24.add(r16.get(r25 + r21));
        r25 = r25 + 1;
        goto L20
    L22:
        r20.add(r24);
        r21 = r21 + r12;
    L23:
        return r20;
    L14:
        r22 = false;
        goto L15
    L9:
        r19 = 1;
        goto L10
    }

    @SinceKotlin(version = "1.2")
    public static final <T, R> List<R> windowed(Iterable<? extends T> r10, int r11, int r12, boolean r13, Function1<? super List<? extends T>, ? extends R> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "transform");
        SlidingWindowKt.checkWindowSizeStep(r11, r12);
        if ((r10 instanceof RandomAccess) == true) goto L5;
    L21:
        ArrayList r15 = new ArrayList();
        Iterator r16 = SlidingWindowKt.windowedIterator(r10.iterator(), r11, r12, r13, true);
    L23:
        if (r16.hasNext() == false) goto L25;
        r15.add(r14.invoke((List) r16.next()));
        goto L23
    L25:
        return r15;
    L5:
        if ((r10 instanceof List) == false) goto L21;
        List r17 = (List) r10;
        int r18 = r17.size();
        int r19 = r18 / r12;
        if ((r18 % r12) != 0) goto L9;
        int r20 = 0;
    L10:
        ArrayList r21 = new ArrayList(r19 + r20);
        MovingSubList r22 = new MovingSubList(r17);
        int r23 = 0;
    L11:
        if (r23 < 0) goto L14;
        if (r23 >= r18) goto L14;
        boolean r24 = true;
    L15:
        if (r24 == false) goto L20;
        int r25 = RangesKt.coerceAtMost(r11, r18 - r23);
        if (r13 == true) goto L19;
        if (r25 < r11) goto L20;
    L19:
        r22.move(r23, r25 + r23);
        r21.add(r14.invoke(r22));
        r23 = r23 + r12;
    L20:
        return r21;
    L14:
        r24 = false;
        goto L15
    L9:
        r20 = 1;
        goto L10
    }

    public static /* synthetic */ List windowed$default(Iterable r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowed(r10, r11, r12, r13);
    }

    public static /* synthetic */ List windowed$default(Iterable r10, int r11, int r12, boolean r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowed(r10, r11, r12, r13, r14);
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new IndexingIterable(new C03991(r10));
    }

    public static <T, R> List<Pair<T, R>> zip(Iterable<? extends T> r10, Iterable<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Iterator<? extends T> r12 = r10.iterator();
        Iterator<? extends R> r13 = r11.iterator();
        ArrayList r14 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r10, 10), CollectionsKt.collectionSizeOrDefault(r11, 10)));
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r13.hasNext() == false) goto L8;
        r14.add(TuplesKt.to(r12.next(), r13.next()));
    L8:
        return r14;
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> r10, Iterable<? extends R> r11, Function2<? super T, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        Iterator<? extends R> r14 = r11.iterator();
        ArrayList r15 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r10, 10), CollectionsKt.collectionSizeOrDefault(r11, 10)));
    L4:
        if (r13.hasNext() == false) goto L8;
        if (r14.hasNext() == false) goto L8;
        r15.add(r12.invoke(r13.next(), r14.next()));
    L8:
        return r15;
    }

    public static final <T, R> List<Pair<T, R>> zip(Iterable<? extends T> r10, R[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        ArrayList r13 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r10, 10), r12));
        Iterator<? extends T> r14 = r10.iterator();
        int r15 = 0;
    L4:
        if (r14.hasNext() == false) goto L8;
        T r16 = r14.next();
        if (r15 >= r12) goto L8;
        int r17 = r15 + 1;
        r13.add(TuplesKt.to(r16, r11[r15]));
        r15 = r17;
    L8:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R, V> List<V> zip(Iterable<? extends T> r10, R[] r11, Function2<? super T, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = r11.length;
        ArrayList r14 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r10, 10), r13));
        Iterator<? extends T> r15 = r10.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L8;
        T r17 = r15.next();
        if (r16 >= r13) goto L8;
        int r18 = r16 + 1;
        r14.add(r12.invoke(r17, r11[r16]));
        r16 = r18;
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.2")
    public static final <T> List<Pair<T, T>> zipWithNext(Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L12;
        ArrayList r12 = new ArrayList();
        T r13 = r11.next();
    L7:
        if (r11.hasNext() == false) goto L10;
        T r14 = r11.next();
        r12.add(TuplesKt.to(r13, r14));
        r13 = r14;
        goto L7
    L10:
        return r12;
    L12:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.2")
    public static final <T, R> List<R> zipWithNext(Iterable<? extends T> r10, Function2<? super T, ? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L5;
        ArrayList r13 = new ArrayList();
        c r14 = r12.next();
    L8:
        if (r12.hasNext() == false) goto L10;
        T r15 = r12.next();
        r13.add(r11.invoke(r14, r15));
        r14 = r15;
        goto L8
    L10:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }
}
