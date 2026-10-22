package okio.internal;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.SegmentedByteString;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "-SegmentedByteString")
@SourceDebugExtension({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n63#1,12:252\n85#1,14:264\n85#1,14:278\n85#1,14:292\n85#1,14:306\n63#1,12:320\n1#2:251\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n*L\n147#1:252,12\n160#1:264,14\n182#1:278,14\n202#1:292,14\n219#1:306,14\n239#1:320,12\n*E\n"})
public final class d {
    public static final int a(int[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r14 = r13 - 1;
    L3:
        if (r12 > r14) goto L11;
        int r15 = (r12 + r14) >>> 1;
        int r16 = r10[r15];
        if (r16 < r11) goto L6;
        if (r16 <= r11) goto L9;
        r14 = r15 - 1;
        goto L3
    L9:
        return r15;
    L6:
        r12 = r15 + 1;
        goto L3
    L11:
        return (-r12) - 1;
    }

    public static final int b(SegmentedByteString r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = a(r10.getDirectory$okio(), r11 + 1, 0, r10.getSegments$okio().length);
        if (r12 < 0) goto L6;
        return r12;
    L6:
        return ~r12;
    }
}
