package ou;

import kotlin.jvm.internal.Intrinsics;
import okio.SegmentedByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f21307a = null;

    static {
        f21307a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final int a(char r5) {
        if ('0' > r5) goto L9;
        if ('9' < r5) goto L9;
        return r5 - '0';
    L9:
        if ('a' > r5) goto L15;
        if ('f' < r5) goto L15;
        return r5 - 'W';
    L15:
        if ('A' > r5) goto L21;
        if ('F' < r5) goto L21;
        return r5 - '7';
    L21:
        throw new IllegalArgumentException(kotlin.collections.a.g("Unexpected hex digit: ", r5));
    }

    public static final int b(SegmentedByteString r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$segment");
        int[] r11 = r5.getDirectory$okio();
        int r12 = r10 + 1;
        int r13 = r5.getSegments$okio().length;
        Intrinsics.checkNotNullParameter(r11, "$this$binarySearch");
        int r14 = r13 - 1;
        int r15 = 0;
    L3:
        if (r15 > r14) goto L9;
        int r16 = (r15 + r14) >>> 1;
        int r17 = r11[r16];
        if (r17 < r12) goto L6;
        if (r17 <= r12) goto L10;
        r14 = r16 - 1;
    L10:
        if (r16 < 0) goto L13;
        return r16;
    L13:
        return ~r16;
    L6:
        r15 = r16 + 1;
        goto L3
    L9:
        r16 = (-r15) - 1;
        goto L10
    }
}
