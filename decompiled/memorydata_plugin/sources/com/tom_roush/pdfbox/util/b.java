package com.tom_roush.pdfbox.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static <T> void a(List<T> r3, Comparator<? super T> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        if (r5.size() >= 2) goto L5;
        return;
    L5:
        Object[] r0 = r5.toArray();
        a(r0, r6);
        ListIterator r7 = r5.listIterator();
        int r8 = r0.length;
        int r1 = 0;
    L6:
        if (r1 >= r8) goto L8;
        Object r2 = r0[r1];
        r7.next();
        r7.set(r2);
        r1 = r1 + 1;
        goto L6
    }

    private static <T> void a(T[] r9, Comparator<? super T> r10) {
        Comparator r11 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r10, Comparator.class, "com.obric.memorydata.plugin");
        Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast(r9.clone(), Object[].class, "com.obric.memorydata.plugin");
        int r1 = 1;
    L4:
        if (r1 >= r9.length) goto L10;
        int r4 = 0;
    L7:
        if (r4 >= r9.length) goto L9;
        int r8 = r4 + (r1 << 1);
        a(r9, r0, r4, r4 + r1, r8, r11);
        r4 = r8;
        goto L7
    L9:
        r1 = r1 << 1;
        goto L4
    }

    private static <T> void a(T[] r5, T[] r6, int r7, int r8, int r9, Comparator<? super T> r10) {
        Comparator r11 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r10, Comparator.class, "com.obric.memorydata.plugin");
        if (r8 < r5.length) goto L6;
        return;
    L6:
        if (r9 <= r5.length) goto L8;
        r9 = r5.length;
    L8:
        int r0 = r7;
        int r1 = r0;
        int r2 = r8;
    L9:
        if (r0 >= r9) goto L21;
        if (r1 != r8) goto L13;
        int r3 = r2 + 1;
        r6[r0] = r5[r2];
    L12:
        r2 = r3;
    L20:
        r0 = r0 + 1;
        goto L9
    L13:
        if (r2 != r9) goto L17;
        int r4 = r1 + 1;
        r6[r0] = r5[r1];
    L15:
        r1 = r4;
        goto L20
    L17:
        if (r11.compare(r5[r2], r5[r1]) >= 0) goto L19;
        r3 = r2 + 1;
        r6[r0] = r5[r2];
        goto L12
    L19:
        r4 = r1 + 1;
        r6[r0] = r5[r1];
        goto L15
    L21:
        System.arraycopy(r6, r7, r5, r7, r9 - r7);
    }
}
