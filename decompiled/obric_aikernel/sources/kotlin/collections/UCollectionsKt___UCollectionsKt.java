package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class UCollectionsKt___UCollectionsKt {
    public UCollectionsKt___UCollectionsKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(Iterable<UByte> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<UByte> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = UInt.m127constructorimpl(r12 + UInt.m127constructorimpl(r11.next().m100unboximpl() & 255));
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(Iterable<UInt> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<UInt> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = UInt.m127constructorimpl(r12 + r11.next().m179unboximpl());
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(Iterable<ULong> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<ULong> r11 = r10.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = ULong.m206constructorimpl(r12 + r11.next().m258unboximpl());
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(Iterable<UShort> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<UShort> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = UInt.m127constructorimpl(r12 + UInt.m127constructorimpl(r11.next().m363unboximpl() & UShort.MAX_VALUE));
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(Collection<UByte> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = UByteArray.m102constructorimpl(r10.size());
        Iterator<UByte> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        UByteArray.m113setVurrAj0(r11, r13, r12.next().m100unboximpl());
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(Collection<UInt> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int[] r11 = UIntArray.m181constructorimpl(r10.size());
        Iterator<UInt> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        UIntArray.m192setVXSXFK8(r11, r13, r12.next().m179unboximpl());
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(Collection<ULong> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long[] r11 = ULongArray.m260constructorimpl(r10.size());
        Iterator<ULong> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        ULongArray.m271setk8EXiF4(r11, r13, r12.next().m258unboximpl());
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(Collection<UShort> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        short[] r11 = UShortArray.m365constructorimpl(r10.size());
        Iterator<UShort> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        UShortArray.m376set01HTLdE(r11, r13, r12.next().m363unboximpl());
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }
}
