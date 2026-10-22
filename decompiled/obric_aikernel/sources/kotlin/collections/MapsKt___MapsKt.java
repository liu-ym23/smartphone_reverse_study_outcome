package kotlin.collections;

import a1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\n_Maps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,594:1\n96#1,5:595\n111#1,5:600\n152#1,3:605\n143#1:608\n215#1:609\n216#1:611\n144#1:612\n215#1:613\n216#1:615\n1#2:610\n1#2:614\n1940#3,14:616\n1963#3,14:630\n2310#3,14:644\n2333#3,14:658\n1864#3,3:672\n*S KotlinDebug\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n76#1:595,5\n89#1:600,5\n125#1:605,3\n135#1:608\n135#1:609\n135#1:611\n135#1:612\n143#1:613\n143#1:615\n135#1:610\n230#1:616,14\n241#1:630,14\n390#1:644,14\n401#1:658,14\n574#1:672,3\n*E\n"})
class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    public MapsKt___MapsKt() {
    }

    public static final <K, V> boolean all(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (r10.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        if (r11.invoke(r12.next()).booleanValue() == true) goto L7;
        return false;
    L12:
        return true;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return !r10.isEmpty();
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        if (r11.invoke(r12.next()).booleanValue() == false) goto L7;
        return true;
    L12:
        return false;
    }

    @InlineOnly
    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.entrySet();
    }

    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.asSequence(r10.entrySet());
    }

    @InlineOnly
    private static final <K, V> int count(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = 0;
        if (r10.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        if (r11.invoke(r13.next()).booleanValue() == false) goto L7;
        r12 = r12 + 1;
        goto L7
    L11:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        R r13 = r11.invoke(r12.next());
        if (r13 == null) goto L4;
    L9:
        if (r13 == null) goto L12;
        return r13;
    L12:
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    L8:
        r13 = null;
        goto L9
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        R r13 = r11.invoke(r12.next());
        if (r13 == null) goto L4;
        return r13;
    L8:
        return null;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r12, r11.invoke(r13.next()));
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapSequence")
    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
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
    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> r10, C r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> r10, C r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    @HidesMembers
    public static final <K, V> void forEach(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.invoke(r12.next());
        goto L4
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(r10.size());
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r11.invoke(r13.next()));
        goto L4
    L6:
        return r12;
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        R r14 = r11.invoke(r13.next());
        if (r14 == null) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> r10, C r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        R r14 = r12.invoke(r13.next());
        if (r14 == null) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> r10, C r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r11.add(r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
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

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "maxByOrThrow")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrThrow(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L16;
        Map.Entry<K, V> r13 = (Object) r12.next();
        if (r12.hasNext() == false) goto L14;
        R r14 = r11.invoke(r13);
    L8:
        Map.Entry<K, V> r15 = (Object) r12.next();
        R r16 = r11.invoke(r15);
        if (r14.compareTo(r16) >= 0) goto L12;
        r13 = r15;
        r14 = r16;
    L12:
        if (r12.hasNext() == true) goto L8;
    L14:
        return r13;
    L16:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double maxOf(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L10;
        double r13 = r11.invoke((Object) r12.next()).doubleValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.max(r13, r11.invoke((Object) r12.next()).doubleValue());
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
    private static final <K, V> float m479maxOf(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L10;
        float r13 = r11.invoke((Object) r12.next()).floatValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.max(r13, r11.invoke((Object) r12.next()).floatValue());
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
    private static final <K, V, R extends Comparable<? super R>> R m480maxOf(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L12;
        R r13 = r11.invoke((Object) r12.next());
    L6:
        if (r12.hasNext() == false) goto L10;
        R r14 = r11.invoke((Object) r12.next());
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
    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        R r13 = r11.invoke((Object) r12.next());
    L7:
        if (r12.hasNext() == false) goto L12;
        R r14 = r11.invoke((Object) r12.next());
        if (r13.compareTo(r14) >= 0) goto L7;
        r13 = r14;
        goto L7
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m481maxOfOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        double r13 = r11.invoke((Object) r12.next()).doubleValue();
    L7:
        if (r12.hasNext() == false) goto L10;
        r13 = Math.max(r13, r11.invoke((Object) r12.next()).doubleValue());
        goto L7
    L10:
        return Double.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m482maxOfOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        float r13 = r11.invoke((Object) r12.next()).floatValue();
    L7:
        if (r12.hasNext() == false) goto L10;
        r13 = Math.max(r13, r11.invoke((Object) r12.next()).floatValue());
        goto L7
    L10:
        return Float.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> r10, Comparator<? super R> r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<T> r13 = r10.entrySet().iterator();
        if (r13.hasNext() == false) goto L12;
        R r14 = r12.invoke((Object) r13.next());
    L6:
        if (r13.hasNext() == false) goto L10;
        R r15 = r12.invoke((Object) r13.next());
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
    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> r10, Comparator<? super R> r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<T> r13 = r10.entrySet().iterator();
        if (r13.hasNext() == true) goto L5;
        return null;
    L5:
        R r14 = r12.invoke((Object) r13.next());
    L7:
        if (r13.hasNext() == false) goto L12;
        R r15 = r12.invoke((Object) r13.next());
        if (r11.compare(r14, r15) >= 0) goto L7;
        r14 = (Object) r15;
        goto L7
    L12:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> r10, Comparator<? super Map.Entry<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.maxWithOrNull(r10.entrySet(), r11);
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "maxWithOrThrow")
    private static final <K, V> Map.Entry<K, V> maxWithOrThrow(Map<? extends K, ? extends V> r10, Comparator<? super Map.Entry<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.maxWithOrThrow(r10.entrySet(), r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
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

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "minByOrThrow")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrThrow(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L16;
        Map.Entry<K, V> r13 = (Object) r12.next();
        if (r12.hasNext() == false) goto L14;
        R r14 = r11.invoke(r13);
    L8:
        Map.Entry<K, V> r15 = (Object) r12.next();
        R r16 = r11.invoke(r15);
        if (r14.compareTo(r16) <= 0) goto L12;
        r13 = r15;
        r14 = r16;
    L12:
        if (r12.hasNext() == true) goto L8;
    L14:
        return r13;
    L16:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double minOf(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L10;
        double r13 = r11.invoke((Object) r12.next()).doubleValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.min(r13, r11.invoke((Object) r12.next()).doubleValue());
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
    private static final <K, V> float m483minOf(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L10;
        float r13 = r11.invoke((Object) r12.next()).floatValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.min(r13, r11.invoke((Object) r12.next()).floatValue());
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
    private static final <K, V, R extends Comparable<? super R>> R m484minOf(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L12;
        R r13 = r11.invoke((Object) r12.next());
    L6:
        if (r12.hasNext() == false) goto L10;
        R r14 = r11.invoke((Object) r12.next());
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
    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        R r13 = r11.invoke((Object) r12.next());
    L7:
        if (r12.hasNext() == false) goto L12;
        R r14 = r11.invoke((Object) r12.next());
        if (r13.compareTo(r14) <= 0) goto L7;
        r13 = r14;
        goto L7
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m485minOfOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        double r13 = r11.invoke((Object) r12.next()).doubleValue();
    L7:
        if (r12.hasNext() == false) goto L10;
        r13 = Math.min(r13, r11.invoke((Object) r12.next()).doubleValue());
        goto L7
    L10:
        return Double.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m486minOfOrNull(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<T> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == true) goto L5;
        return null;
    L5:
        float r13 = r11.invoke((Object) r12.next()).floatValue();
    L7:
        if (r12.hasNext() == false) goto L10;
        r13 = Math.min(r13, r11.invoke((Object) r12.next()).floatValue());
        goto L7
    L10:
        return Float.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> r10, Comparator<? super R> r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<T> r13 = r10.entrySet().iterator();
        if (r13.hasNext() == false) goto L12;
        R r14 = r12.invoke((Object) r13.next());
    L6:
        if (r13.hasNext() == false) goto L10;
        R r15 = r12.invoke((Object) r13.next());
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
    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> r10, Comparator<? super R> r11, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<T> r13 = r10.entrySet().iterator();
        if (r13.hasNext() == true) goto L5;
        return null;
    L5:
        R r14 = r12.invoke((Object) r13.next());
    L7:
        if (r13.hasNext() == false) goto L12;
        R r15 = r12.invoke((Object) r13.next());
        if (r11.compare(r14, r15) <= 0) goto L7;
        r14 = (Object) r15;
        goto L7
    L12:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> r10, Comparator<? super Map.Entry<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.minWithOrNull(r10.entrySet(), r11);
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "minWithOrThrow")
    private static final <K, V> Map.Entry<K, V> minWithOrThrow(Map<? extends K, ? extends V> r10, Comparator<? super Map.Entry<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.minWithOrThrow(r10.entrySet(), r11);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.isEmpty();
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> r10, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (r10.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<Map.Entry<? extends K, ? extends V>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        if (r11.invoke(r12.next()).booleanValue() == false) goto L7;
        return false;
    L12:
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M r10, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.invoke(r12.next());
        goto L4
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M r10, Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<T> r12 = r10.entrySet().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        c r14 = (Object) r12.next();
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

    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 0) goto L5;
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.entrySet().iterator();
        if (r11.hasNext() == false) goto L9;
        Map.Entry<? extends K, ? extends V> r12 = r11.next();
        if (r11.hasNext() == false) goto L13;
        ArrayList r13 = new ArrayList(r10.size());
        r13.add(new Pair(r12.getKey(), r12.getValue()));
    L15:
        Map.Entry<? extends K, ? extends V> r14 = r11.next();
        r13.add(new Pair(r14.getKey(), r14.getValue()));
        if (r11.hasNext() == true) goto L15;
        return r13;
    L13:
        return CollectionsKt.listOf(new Pair(r12.getKey(), r12.getValue()));
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }
}
