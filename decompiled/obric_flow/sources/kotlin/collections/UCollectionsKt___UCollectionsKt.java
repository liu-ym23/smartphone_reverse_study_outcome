package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0017\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public UCollectionsKt___UCollectionsKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(Iterable<UByte> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<UByte> r10 = r5.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = androidx.room.jarjarred.org.antlr.runtime.a.b(r10.next().m192unboximpl() & UByte.MAX_VALUE, r11);
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(Iterable<UInt> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<UInt> r10 = r5.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = androidx.room.jarjarred.org.antlr.runtime.a.i(r10.next(), r11);
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(Iterable<ULong> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<ULong> r10 = r5.iterator();
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = ULong.m298constructorimpl(r10.next().m350unboximpl() + r11);
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(Iterable<UShort> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<UShort> r10 = r5.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = androidx.room.jarjarred.org.antlr.runtime.a.b(r10.next().m455unboximpl() & UShort.MAX_VALUE, r11);
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(Collection<UByte> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        byte[] r10 = UByteArray.m194constructorimpl(r5.size());
        Iterator<UByte> r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        UByteArray.m205setVurrAj0(r10, r12, r11.next().m192unboximpl());
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(Collection<UInt> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int[] r10 = UIntArray.m273constructorimpl(r5.size());
        Iterator<UInt> r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        UIntArray.m284setVXSXFK8(r10, r12, r11.next().m271unboximpl());
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(Collection<ULong> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        long[] r10 = ULongArray.m352constructorimpl(r5.size());
        Iterator<ULong> r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        ULongArray.m363setk8EXiF4(r10, r12, r11.next().m350unboximpl());
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(Collection<UShort> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        short[] r10 = UShortArray.m457constructorimpl(r5.size());
        Iterator<UShort> r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        UShortArray.m468set01HTLdE(r10, r12, r11.next().m455unboximpl());
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }
}
