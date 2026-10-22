package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
@SourceDebugExtension({"SMAP\n_Sets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n865#2,2:141\n855#2,2:143\n1#3:145\n*S KotlinDebug\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n*L\n29#1:141,2\n53#1:143,2\n*E\n"})
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public SetsKt___SetsKt() {
    }

    public static <T> Set<T> minus(Set<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashSet r5 = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(r10.size()));
        Iterator<T> r12 = r10.iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        boolean r15 = true;
        if (r13 == false) goto L8;
    L10:
        if (r15 == false) goto L4;
        r5.add(r14);
        goto L4
    L8:
        if (Intrinsics.areEqual(r14, r11) == false) goto L10;
        r13 = true;
        r15 = false;
        goto L10
    L12:
        return r5;
    }

    @InlineOnly
    private static final <T> Set<T> minusElement(Set<? extends T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return minus(r5, r10);
    }

    public static <T> Set<T> plus(Set<? extends T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        LinkedHashSet r11 = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(r5.size() + 1));
        r11.addAll(r5);
        r11.add(r10);
        return r11;
    }

    @InlineOnly
    private static final <T> Set<T> plusElement(Set<? extends T> r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return plus(r5, r10);
    }

    public static final <T> Set<T> plus(Set<? extends T> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        LinkedHashSet r11 = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(r5.size() + r10.length));
        r11.addAll(r5);
        CollectionsKt__MutableCollectionsKt.addAll(r11, r10);
        return r11;
    }

    public static final <T> Set<T> minus(Set<? extends T> r5, T[] r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        LinkedHashSet r11 = new LinkedHashSet(r5);
        CollectionsKt__MutableCollectionsKt.removeAll(r11, r10);
        return r11;
    }

    public static <T> Set<T> plus(Set<? extends T> r5, Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        Integer r11 = CollectionsKt__IterablesKt.collectionSizeOrNull(r10);
        if (r11 == null) goto L5;
        int r12 = r11.intValue();
        int r13 = r5.size() + r12;
    L6:
        LinkedHashSet r14 = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(r13));
        r14.addAll(r5);
        CollectionsKt__MutableCollectionsKt.addAll(r14, r10);
        return r14;
    L5:
        r13 = r5.size() * 2;
        goto L6
    }

    public static <T> Set<T> minus(Set<? extends T> r5, Iterable<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        Collection<?> r11 = CollectionsKt__MutableCollectionsKt.convertToListIfNotCollection(r10);
        if (r11.isEmpty() == false) goto L7;
        return CollectionsKt___CollectionsKt.toSet(r5);
    L7:
        if ((r11 instanceof Set) == false) goto L15;
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator<T> r13 = r5.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        T r14 = r13.next();
        if (r11.contains(r14) == true) goto L10;
        r12.add(r14);
        goto L10
    L14:
        return r12;
    L15:
        LinkedHashSet r15 = new LinkedHashSet(r5);
        r15.removeAll(r11);
        return r15;
    }

    public static final <T> Set<T> plus(Set<? extends T> r5, Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        LinkedHashSet r11 = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(r5.size() * 2));
        r11.addAll(r5);
        CollectionsKt__MutableCollectionsKt.addAll(r11, r10);
        return r11;
    }

    public static final <T> Set<T> minus(Set<? extends T> r5, Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "elements");
        LinkedHashSet r11 = new LinkedHashSet(r5);
        CollectionsKt__MutableCollectionsKt.removeAll(r11, r10);
        return r11;
    }
}
