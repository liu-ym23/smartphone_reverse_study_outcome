package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public SetsKt___SetsKt() {
    }

    public static final <T> Set<T> minus(Set<? extends T> r4, Iterable<? extends T> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "elements");
        Collection<?> r8 = CollectionsKt.convertToListIfNotCollection(r7);
        if (r8.isEmpty() == false) goto L7;
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r8, Set.class) == false) goto L16;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<T> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L15;
        T r2 = r10.next();
        if (r8.contains(r2) == true) goto L10;
        r0.add(r2);
        goto L10
    L15:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    L16:
        LinkedHashSet r1 = new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        r1.removeAll(r8);
        return (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Set<T> minus(Set<? extends T> r7, T r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r9.size()));
        Iterator<T> r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r3 = false;
    L4:
        if (r10.hasNext() == false) goto L13;
        T r4 = r10.next();
        boolean r5 = true;
        if (r3 == false) goto L8;
    L10:
        if (r5 == false) goto L4;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(r4);
        goto L4
    L8:
        if (Intrinsics.areEqual(r4, r8) == false) goto L10;
        r3 = true;
        r5 = false;
        goto L10
    L13:
        return (Set) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), Set.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Set<T> minus(Set<? extends T> r3, Sequence<? extends T> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Sequence r6 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r4, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "elements");
        LinkedHashSet r0 = new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        CollectionsKt.removeAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r6);
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Set<T> minus(Set<? extends T> r3, T[] r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r4, "elements");
        LinkedHashSet r0 = new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        CollectionsKt.removeAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r4);
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Set<T> minusElement(Set<? extends T> r2, T r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return SetsKt.minus(r4, r3);
    }

    public static final <T> Set<T> plus(Set<? extends T> r3, Iterable<? extends T> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "elements");
        Integer r0 = CollectionsKt.collectionSizeOrNull(r6);
        if (r0 == null) goto L5;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue();
        int r2 = r5.size() + r1;
    L6:
        LinkedHashSet r7 = new LinkedHashSet(MapsKt.mapCapacity(r2));
        r7.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"), r6);
        return (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.memorydata.plugin");
    L5:
        r2 = r5.size() * 2;
        goto L6
    }

    public static final <T> Set<T> plus(Set<? extends T> r3, T r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r5.size() + 1));
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        r0.add(r4);
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Set<T> plus(Set<? extends T> r3, Sequence<? extends T> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Sequence r6 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r4, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "elements");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r5.size() * 2));
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r6);
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Set<T> plus(Set<? extends T> r4, T[] r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r5, "elements");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r6.size() + r5.length));
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r5);
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Set<T> plusElement(Set<? extends T> r2, T r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return SetsKt.plus(r4, r3);
    }
}
