package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\n_Sets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n857#2,2:140\n847#2,2:142\n1#3:144\n*S KotlinDebug\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n*L\n28#1:140,2\n52#1:142,2\n*E\n"})
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public SetsKt___SetsKt() {
    }

    public static <T> Set<T> minus(Set<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        Collection<?> r12 = CollectionsKt.convertToListIfNotCollection(r11);
        if (r12.isEmpty() == false) goto L7;
        return CollectionsKt.toSet(r10);
    L7:
        if ((r12 instanceof Set) == false) goto L15;
        LinkedHashSet r13 = new LinkedHashSet();
        Iterator<T> r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        T r15 = r14.next();
        if (r12.contains(r15) == true) goto L10;
        r13.add(r15);
        goto L10
    L14:
        return r13;
    L15:
        LinkedHashSet r16 = new LinkedHashSet(r10);
        r16.removeAll(r12);
        return r16;
    }

    public static <T> Set<T> minus(Set<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashSet r12 = new LinkedHashSet(MapsKt.mapCapacity(r10.size()));
        Iterator<T> r13 = r10.iterator();
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

    public static final <T> Set<T> minus(Set<? extends T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        LinkedHashSet r12 = new LinkedHashSet(r10);
        CollectionsKt__MutableCollectionsKt.removeAll(r12, r11);
        return r12;
    }

    public static final <T> Set<T> minus(Set<? extends T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        LinkedHashSet r12 = new LinkedHashSet(r10);
        CollectionsKt__MutableCollectionsKt.removeAll(r12, r11);
        return r12;
    }

    @InlineOnly
    private static final <T> Set<T> minusElement(Set<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SetsKt.minus(r10, r11);
    }

    public static <T> Set<T> plus(Set<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        Integer r12 = CollectionsKt__IterablesKt.collectionSizeOrNull(r11);
        if (r12 == null) goto L5;
        int r13 = r12.intValue();
        int r14 = r10.size() + r13;
    L6:
        LinkedHashSet r15 = new LinkedHashSet(MapsKt.mapCapacity(r14));
        r15.addAll(r10);
        CollectionsKt.addAll(r15, r11);
        return r15;
    L5:
        r14 = r10.size() * 2;
        goto L6
    }

    public static <T> Set<T> plus(Set<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashSet r12 = new LinkedHashSet(MapsKt.mapCapacity(r10.size() + 1));
        r12.addAll(r10);
        r12.add(r11);
        return r12;
    }

    public static final <T> Set<T> plus(Set<? extends T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        LinkedHashSet r12 = new LinkedHashSet(MapsKt.mapCapacity(r10.size() * 2));
        r12.addAll(r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    }

    public static final <T> Set<T> plus(Set<? extends T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        LinkedHashSet r12 = new LinkedHashSet(MapsKt.mapCapacity(r10.size() + r11.length));
        r12.addAll(r10);
        CollectionsKt.addAll(r12, r11);
        return r12;
    }

    @InlineOnly
    private static final <T> Set<T> plusElement(Set<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SetsKt.plus(r10, r11);
    }
}
