package kotlin.sequences;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class USequencesKt___USequencesKt {
    public USequencesKt___USequencesKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(Sequence<UByte> r10) {
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
    public static final int sumOfUInt(Sequence<UInt> r10) {
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
    public static final long sumOfULong(Sequence<ULong> r10) {
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
    public static final int sumOfUShort(Sequence<UShort> r10) {
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
}
