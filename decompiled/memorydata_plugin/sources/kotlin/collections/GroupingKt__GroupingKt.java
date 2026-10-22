package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.AppDataCenter;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u009e\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\bø\u0001\u0000\u001a·\u0001\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a¿\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\bø\u0001\u0000\u001a\u007f\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aØ\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u001026\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0093\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u008b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\bø\u0001\u0000\u001a¤\u0001\u0010\"\u001a\u0002H\u0010\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"aggregate", "", "K", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", TraceCons.METRIC_REDUCE, "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingKt() {
    }

    public static final <T, K, R> Map<K, R> aggregate(Grouping<T, ? extends K> r6, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> r7) {
        Grouping r8 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r6, Grouping.class, "com.obric.memorydata.plugin");
        Function4 r9 = (Function4) ZeusTransformUtils.wrapperContextForParams(r7, Function4.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "operation");
        AppDataCenter r0 = (Map<K, R>) ((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin"));
        Iterator<T> r1 = r8.sourceIterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        T r2 = r1.next();
        Object r3 = r8.keyOf(r2);
        Object r4 = r0.get(r3);
        if (r4 == null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        r0.put(r3, r9.invoke(r3, r4, r2, Boolean.valueOf(r5)));
        goto L4
    L8:
        if (r0.containsKey(r3) == true) goto L10;
        r5 = true;
        goto L11
    L12:
        return r0;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(Grouping<T, ? extends K> r5, M r6, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> r7) {
        Grouping r8 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r5, Grouping.class, "com.obric.memorydata.plugin");
        M r9 = (M) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function4 r10 = (Function4) ZeusTransformUtils.wrapperContextForParams(r7, Function4.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "destination");
        Intrinsics.checkNotNullParameter(r10, "operation");
        Iterator<T> r0 = r8.sourceIterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        T r1 = r0.next();
        Object r2 = r8.keyOf(r1);
        Object r3 = r9.get(r2);
        if (r3 == null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        r9.put(r2, r10.invoke(r2, r3, r1, Boolean.valueOf(r4)));
        goto L4
    L8:
        if (r9.containsKey(r2) == true) goto L10;
        r4 = true;
        goto L11
    L12:
        return r9;
    }

    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(Grouping<T, ? extends K> r8, M r9) {
        Grouping r10 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r8, Grouping.class, "com.obric.memorydata.plugin");
        M r11 = (M) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<T> r3 = r10.sourceIterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r10.keyOf(r3.next());
        Object r5 = r11.get(r4);
        if (r5 == null) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == false) goto L13;
        r5 = 0;
    L13:
        r11.put(r4, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue() + 1));
        goto L4
    L8:
        if (r11.containsKey(r4) == true) goto L10;
        r7 = true;
        goto L11
    L14:
        return r11;
    }

    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> r6, R r7, Function2<? super R, ? super T, ? extends R> r8) {
        Grouping r9 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r6, Grouping.class, "com.obric.memorydata.plugin");
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r8, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "operation");
        AppDataCenter r0 = (Map<K, R>) ((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin"));
        Iterator<T> r1 = r9.sourceIterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        T r2 = r1.next();
        Object r3 = r9.keyOf(r2);
        Object r4 = r0.get(r3);
        if (r4 == null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L13;
        r4 = r7;
    L13:
        r0.put(r3, r10.invoke(r4, r2));
        goto L4
    L8:
        if (r0.containsKey(r3) == true) goto L10;
        r5 = true;
        goto L11
    L14:
        return r0;
    }

    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> r6, Function2<? super K, ? super T, ? extends R> r7, Function3<? super K, ? super R, ? super T, ? extends R> r8) {
        Grouping r9 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r6, Grouping.class, "com.obric.memorydata.plugin");
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Function3 r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r8, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "initialValueSelector");
        Intrinsics.checkNotNullParameter(r11, "operation");
        AppDataCenter r0 = (Map<K, R>) ((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin"));
        Iterator<T> r1 = r9.sourceIterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        T r2 = r1.next();
        Object r3 = r9.keyOf(r2);
        Object r4 = r0.get(r3);
        if (r4 == null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L13;
        r4 = r10.invoke(r3, r2);
    L13:
        r0.put(r3, r11.invoke(r3, r4, r2));
        goto L4
    L8:
        if (r0.containsKey(r3) == true) goto L10;
        r5 = true;
        goto L11
    L14:
        return r0;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> r5, M r6, R r7, Function2<? super R, ? super T, ? extends R> r8) {
        Grouping r9 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r5, Grouping.class, "com.obric.memorydata.plugin");
        M r10 = (M) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r8, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "destination");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<T> r0 = r9.sourceIterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        T r1 = r0.next();
        Object r2 = r9.keyOf(r1);
        Object r3 = r10.get(r2);
        if (r3 == null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L13;
        r3 = r7;
    L13:
        r10.put(r2, r11.invoke(r3, r1));
        goto L4
    L8:
        if (r10.containsKey(r2) == true) goto L10;
        r4 = true;
        goto L11
    L14:
        return r10;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> r5, M r6, Function2<? super K, ? super T, ? extends R> r7, Function3<? super K, ? super R, ? super T, ? extends R> r8) {
        Grouping r9 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r5, Grouping.class, "com.obric.memorydata.plugin");
        M r10 = (M) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Function3 r12 = (Function3) ZeusTransformUtils.wrapperContextForParams(r8, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "destination");
        Intrinsics.checkNotNullParameter(r11, "initialValueSelector");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Iterator<T> r0 = r9.sourceIterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        T r1 = r0.next();
        Object r2 = r9.keyOf(r1);
        Object r3 = r10.get(r2);
        if (r3 == null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L13;
        r3 = r11.invoke(r2, r1);
    L13:
        r10.put(r2, r12.invoke(r2, r3, r1));
        goto L4
    L8:
        if (r10.containsKey(r2) == true) goto L10;
        r4 = true;
        goto L11
    L14:
        return r10;
    }

    public static final <S, T extends S, K> Map<K, S> reduce(Grouping<T, ? extends K> r6, Function3<? super K, ? super S, ? super T, ? extends S> r7) {
        Grouping r8 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r6, Grouping.class, "com.obric.memorydata.plugin");
        Function3 r9 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "operation");
        AppDataCenter r0 = (Map<K, S>) ((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin"));
        Iterator r1 = r8.sourceIterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        Object r2 = r1.next();
        Object r3 = r8.keyOf(r2);
        Object r4 = r0.get(r3);
        if (r4 == null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L14;
        r2 = r9.invoke(r3, r4, r2);
    L14:
        r0.put(r3, r2);
        goto L4
    L8:
        if (r0.containsKey(r3) == true) goto L10;
        r5 = true;
        goto L11
    L15:
        return r0;
    }

    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(Grouping<T, ? extends K> r5, M r6, Function3<? super K, ? super S, ? super T, ? extends S> r7) {
        Grouping r8 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r5, Grouping.class, "com.obric.memorydata.plugin");
        M r9 = (M) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function3 r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "destination");
        Intrinsics.checkNotNullParameter(r10, "operation");
        Iterator r0 = r8.sourceIterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Object r1 = r0.next();
        Object r2 = r8.keyOf(r1);
        Object r3 = r9.get(r2);
        if (r3 == null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L14;
        r1 = r10.invoke(r2, r3, r1);
    L14:
        r9.put(r2, r1);
        goto L4
    L8:
        if (r9.containsKey(r2) == true) goto L10;
        r4 = true;
        goto L11
    L15:
        return r9;
    }
}
