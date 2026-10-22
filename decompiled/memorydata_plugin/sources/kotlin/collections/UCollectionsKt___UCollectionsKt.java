package kotlin.collections;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0017\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public UCollectionsKt___UCollectionsKt() {
    }

    public static final int sumOfUByte(Iterable<UByte> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        r0 = UInt.m1516constructorimpl(r0 + UInt.m1516constructorimpl(((UByte) ZeusTransformUtils.preCheckCast(r6.next(), UByte.class, "com.obric.memorydata.plugin")).m1489unboximpl() & 255));
        goto L4
    L6:
        return r0;
    }

    public static final int sumOfUInt(Iterable<UInt> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        r0 = UInt.m1516constructorimpl(r0 + ((UInt) ZeusTransformUtils.preCheckCast(r6.next(), UInt.class, "com.obric.memorydata.plugin")).m1568unboximpl());
        goto L4
    L6:
        return r0;
    }

    public static final long sumOfULong(Iterable<ULong> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Iterator r8 = r7.iterator();
        long r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r2 = ULong.m1595constructorimpl(r2 + ((ULong) ZeusTransformUtils.preCheckCast(r8.next(), ULong.class, "com.obric.memorydata.plugin")).m1647unboximpl());
        goto L4
    L6:
        return r2;
    }

    public static final int sumOfUShort(Iterable<UShort> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        r0 = UInt.m1516constructorimpl(r0 + UInt.m1516constructorimpl(((UShort) ZeusTransformUtils.preCheckCast(r6.next(), UShort.class, "com.obric.memorydata.plugin")).m1752unboximpl() & UShort.MAX_VALUE));
        goto L4
    L6:
        return r0;
    }

    public static final byte[] toUByteArray(Collection<UByte> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        byte[] r0 = UByteArray.m1491constructorimpl(r6.size());
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        UByteArray.m1502setVurrAj0(r0, r2, ((UByte) ZeusTransformUtils.preCheckCast(r7.next(), UByte.class, "com.obric.memorydata.plugin")).m1489unboximpl());
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final int[] toUIntArray(Collection<UInt> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int[] r0 = UIntArray.m1570constructorimpl(r6.size());
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        UIntArray.m1581setVXSXFK8(r0, r2, ((UInt) ZeusTransformUtils.preCheckCast(r7.next(), UInt.class, "com.obric.memorydata.plugin")).m1568unboximpl());
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final long[] toULongArray(Collection<ULong> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        long[] r0 = ULongArray.m1649constructorimpl(r7.size());
        Iterator r8 = r7.iterator();
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        ULongArray.m1660setk8EXiF4(r0, r2, ((ULong) ZeusTransformUtils.preCheckCast(r8.next(), ULong.class, "com.obric.memorydata.plugin")).m1647unboximpl());
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static final short[] toUShortArray(Collection<UShort> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        short[] r0 = UShortArray.m1754constructorimpl(r6.size());
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        UShortArray.m1765set01HTLdE(r0, r2, ((UShort) ZeusTransformUtils.preCheckCast(r7.next(), UShort.class, "com.obric.memorydata.plugin")).m1752unboximpl());
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }
}
