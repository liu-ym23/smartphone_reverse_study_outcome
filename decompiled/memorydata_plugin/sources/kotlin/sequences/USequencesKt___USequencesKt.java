package kotlin.sequences;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt {
    public USequencesKt___USequencesKt() {
    }

    public static final int sumOfUByte(Sequence<UByte> r4) {
        Sequence r5 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r4, Sequence.class, "com.obric.memorydata.plugin");
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

    public static final int sumOfUInt(Sequence<UInt> r4) {
        Sequence r5 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r4, Sequence.class, "com.obric.memorydata.plugin");
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

    public static final long sumOfULong(Sequence<ULong> r6) {
        Sequence r7 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r6, Sequence.class, "com.obric.memorydata.plugin");
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

    public static final int sumOfUShort(Sequence<UShort> r4) {
        Sequence r5 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r4, Sequence.class, "com.obric.memorydata.plugin");
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
}
