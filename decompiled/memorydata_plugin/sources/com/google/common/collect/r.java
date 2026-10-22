package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
final class r {
    static int a(int r2) {
        return Math.max(4, ai.a(r2 + 1, 1.0d));
    }

    static int a(int r0, int r1) {
        return r0 & (~r1);
    }

    static int a(int r1, int r2, int r3) {
        return (r1 & (~r3)) | (r2 & r3);
    }

    static int a(Object r2, int r3) {
        if ((r2 instanceof byte[]) == false) goto L7;
        return ((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"))[r3] & 255;
    L7:
        if ((r2 instanceof short[]) == false) goto L11;
        return ((short[]) ZeusTransformUtils.preCheckCast(r2, short[].class, "com.obric.memorydata.plugin"))[r3] & UShort.MAX_VALUE;
    L11:
        return ((int[]) ZeusTransformUtils.preCheckCast(r2, int[].class, "com.obric.memorydata.plugin"))[r3];
    }

    static int a(Object r8, Object r9, int r10, Object r11, int[] r12, Object[] r13, Object[] r14) {
        int r0 = ai.a(r8);
        int r1 = r0 & r10;
        int r2 = a(r11, r1);
        if (r2 != 0) goto L5;
        return -1;
    L5:
        int r3 = a(r0, r10);
        int r4 = -1;
    L6:
        int r5 = r2 - 1;
        int r6 = r12[r5];
        if (a(r6, r10) == r3) goto L9;
    L18:
        int r7 = b(r6, r10);
        if (r7 == 0) goto L20;
        r4 = r5;
        r2 = r7;
        goto L6
    L20:
        return -1;
    L9:
        if (com.google.common.base.k.a(r8, r13[r5]) == false) goto L18;
        if (r14 == null) goto L13;
        if (com.google.common.base.k.a(r9, r14[r5]) == false) goto L18;
    L13:
        int r15 = b(r6, r10);
        if (r4 != (-1)) goto L16;
        a(r11, r1, r15);
    L17:
        return r5;
    L16:
        r12[r4] = a(r12[r4], r15, r10);
        goto L17
    }

    static void a(Object r3) {
        if ((r3 instanceof byte[]) == false) goto L6;
        Arrays.fill((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), (byte) 0);
        return;
    L6:
        if ((r3 instanceof short[]) == false) goto L8;
        Arrays.fill((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.memorydata.plugin"), 0);
        return;
    L8:
        Arrays.fill((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"), 0);
    }

    static void a(Object r2, int r3, int r4) {
        if ((r2 instanceof byte[]) == false) goto L6;
        ((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"))[r3] = (byte) r4;
        return;
    L6:
        if ((r2 instanceof short[]) == false) goto L8;
        ((short[]) ZeusTransformUtils.preCheckCast(r2, short[].class, "com.obric.memorydata.plugin"))[r3] = (short) r4;
        return;
    L8:
        ((int[]) ZeusTransformUtils.preCheckCast(r2, int[].class, "com.obric.memorydata.plugin"))[r3] = r4;
    }

    static int b(int r0, int r1) {
        return r0 & r1;
    }

    static Object b(int r3) {
        if (r3 < 2) goto L19;
        if (r3 > 1073741824) goto L19;
        if (Integer.highestOneBit(r3) != r3) goto L19;
        if (r3 > 256) goto L13;
        return new byte[r3];
    L13:
        if (r3 > 65536) goto L17;
        return new short[r3];
    L17:
        return new int[r3];
    L19:
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + r3);
    }

    static int c(int r1) {
        if (r1 >= 32) goto L5;
        int r0 = 4;
    L7:
        return r0 * (r1 + 1);
    L5:
        r0 = 2;
        goto L7
    }
}
