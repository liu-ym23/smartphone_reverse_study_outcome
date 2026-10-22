package kotlin.collections;

import a1.b;
import a1.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nGrouping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n1#1,291:1\n80#1,6:292\n53#1:298\n80#1,6:299\n80#1,6:305\n53#1:311\n80#1,6:312\n80#1,6:318\n53#1:324\n80#1,6:325\n80#1,6:331\n189#1:337\n80#1,6:338\n*S KotlinDebug\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n53#1:292,6\n112#1:298\n112#1:299,6\n143#1:305,6\n164#1:311\n164#1:312,6\n189#1:318,6\n211#1:324\n211#1:325,6\n239#1:331,6\n257#1:337\n257#1:338,6\n*E\n"})
class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingKt() {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> aggregate(Grouping<T, ? extends K> r10, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<T> r13 = r10.sourceIterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        ?? r14 = r13.next();
        Object r15 = r10.keyOf(r14);
        b r16 = (Object) r12.get(r15);
        if (r16 == null) goto L8;
    L10:
        boolean r17 = false;
    L11:
        r12.put(r15, r11.invoke(r15, r16, r14, Boolean.valueOf(r17)));
        goto L4
    L8:
        if (r12.containsKey(r15) == true) goto L10;
        r17 = true;
        goto L11
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(Grouping<T, ? extends K> r10, M r11, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Iterator<T> r13 = r10.sourceIterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        ?? r14 = r13.next();
        Object r15 = r10.keyOf(r14);
        b r16 = (Object) r11.get(r15);
        if (r16 == null) goto L8;
    L10:
        boolean r17 = false;
    L11:
        r11.put(r15, r12.invoke(r15, r16, r14, Boolean.valueOf(r17)));
        goto L4
    L8:
        if (r11.containsKey(r15) == true) goto L10;
        r17 = true;
        goto L11
    L12:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(Grouping<T, ? extends K> r10, M r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<T> r12 = r10.sourceIterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        K r13 = r10.keyOf(r12.next());
        Object r14 = r11.get(r13);
        if (r14 == null) goto L8;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L13;
        r14 = 0;
    L13:
        r11.put(r13, Integer.valueOf(((Number) r14).intValue() + 1));
        goto L4
    L8:
        if (r11.containsKey(r13) == true) goto L10;
        r15 = true;
        goto L11
    L14:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> r10, R r11, Function2<? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<T> r14 = r10.sourceIterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        ?? r15 = r14.next();
        K r16 = r10.keyOf(r15);
        c r17 = (Object) r13.get(r16);
        if (r17 == null) goto L8;
    L10:
        boolean r18 = false;
    L11:
        if (r18 == false) goto L13;
        r17 = (Object) r11;
    L13:
        r13.put(r16, r12.invoke(r17, r15));
        goto L4
    L8:
        if (r13.containsKey(r16) == true) goto L10;
        r18 = true;
        goto L11
    L14:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> r10, Function2<? super K, ? super T, ? extends R> r11, Function3<? super K, ? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "initialValueSelector");
        Intrinsics.checkNotNullParameter(r12, "operation");
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<T> r14 = r10.sourceIterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        ?? r15 = r14.next();
        Object r16 = r10.keyOf(r15);
        R r17 = (Object) r13.get(r16);
        if (r17 == null) goto L8;
    L10:
        boolean r18 = false;
    L11:
        if (r18 == false) goto L13;
        r17 = r11.invoke(r16, r15);
    L13:
        r13.put(r16, r12.invoke(r16, r17, r15));
        goto L4
    L8:
        if (r13.containsKey(r16) == true) goto L10;
        r18 = true;
        goto L11
    L14:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> r10, M r11, R r12, Function2<? super R, ? super T, ? extends R> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r13, "operation");
        Iterator<T> r14 = r10.sourceIterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        ?? r15 = r14.next();
        K r16 = r10.keyOf(r15);
        c r17 = (Object) r11.get(r16);
        if (r17 == null) goto L8;
    L10:
        boolean r18 = false;
    L11:
        if (r18 == false) goto L13;
        r17 = (Object) r12;
    L13:
        r11.put(r16, r13.invoke(r17, r15));
        goto L4
    L8:
        if (r11.containsKey(r16) == true) goto L10;
        r18 = true;
        goto L11
    L14:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> r10, M r11, Function2<? super K, ? super T, ? extends R> r12, Function3<? super K, ? super R, ? super T, ? extends R> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "initialValueSelector");
        Intrinsics.checkNotNullParameter(r13, "operation");
        Iterator<T> r14 = r10.sourceIterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        ?? r15 = r14.next();
        Object r16 = r10.keyOf(r15);
        R r17 = (Object) r11.get(r16);
        if (r17 == null) goto L8;
    L10:
        boolean r18 = false;
    L11:
        if (r18 == false) goto L13;
        r17 = r12.invoke(r16, r15);
    L13:
        r11.put(r16, r13.invoke(r16, r17, r15));
        goto L4
    L8:
        if (r11.containsKey(r16) == true) goto L10;
        r18 = true;
        goto L11
    L14:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <S, T extends S, K> Map<K, S> reduce(Grouping<T, ? extends K> r10, Function3<? super K, ? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r10.sourceIterator();
    L4:
        if (r13.hasNext() == false) goto L15;
        S r14 = (Object) r13.next();
        Object r15 = r10.keyOf(r14);
        b r16 = (Object) r12.get(r15);
        if (r16 == null) goto L8;
    L10:
        boolean r17 = false;
    L11:
        if (r17 == true) goto L14;
        r14 = r11.invoke(r15, r16, r14);
    L14:
        r12.put(r15, r14);
        goto L4
    L8:
        if (r12.containsKey(r15) == true) goto L10;
        r17 = true;
        goto L11
    L15:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(Grouping<T, ? extends K> r10, M r11, Function3<? super K, ? super S, ? super T, ? extends S> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Iterator r13 = r10.sourceIterator();
    L4:
        if (r13.hasNext() == false) goto L15;
        S r14 = (Object) r13.next();
        Object r15 = r10.keyOf(r14);
        b r16 = (Object) r11.get(r15);
        if (r16 == null) goto L8;
    L10:
        boolean r17 = false;
    L11:
        if (r17 == true) goto L14;
        r14 = r12.invoke(r15, r16, r14);
    L14:
        r11.put(r15, r14);
        goto L4
    L8:
        if (r11.containsKey(r15) == true) goto L10;
        r17 = true;
        goto L11
    L15:
        return r11;
    }
}
