package org.apache.poi.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class ArrayUtil {
    public static void arrayMoveWithin(Object[] r4, int r5, int r6, int r7) {
        if (r7 > 0) goto L4;
        return;
    L4:
        if (r5 != r6) goto L6;
        return;
    L6:
        if (r5 < 0) goto L29;
        if (r5 >= r4.length) goto L29;
        if (r6 < 0) goto L27;
        if (r6 >= r4.length) goto L27;
        int r0 = r5 + r7;
        if (r0 > r4.length) goto L25;
        int r8 = r7 + r6;
        if (r8 > r4.length) goto L23;
        Object[] r1 = Arrays.copyOfRange(r4, r5, r0);
        if (r5 <= r6) goto L19;
        Object[] r9 = Arrays.copyOfRange(r4, r6, r5);
    L20:
        System.arraycopy(r1, 0, r4, r6, r1.length);
        System.arraycopy(r9, 0, r4, r8, r9.length);
        return;
    L19:
        Object[] r10 = Arrays.copyOfRange(r4, r0, r8);
        r8 = r5;
        r9 = r10;
        goto L20
    L23:
        throw new IllegalArgumentException("Asked to move to a position that doesn't have enough space");
    L25:
        throw new IllegalArgumentException("Asked to move more entries than the array has");
    L27:
        throw new IllegalArgumentException("The moveTo must be a valid array index");
    L29:
        throw new IllegalArgumentException("The moveFrom must be a valid array index");
    }
}
