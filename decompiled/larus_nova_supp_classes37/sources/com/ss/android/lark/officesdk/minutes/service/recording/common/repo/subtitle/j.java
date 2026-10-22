package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public static final int a(List<h> r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "list");
        int r0 = r6.size() - 1;
        int r1 = 0;
    L3:
        if (r1 > r0) goto L11;
        int r2 = (r1 + r0) >>> 1;
        long r3 = ((h) ListProtector.get(r6, r2)).a;
        if (r3 < r7) goto L6;
        if (r3 <= r7) goto L9;
        r0 = r2 - 1;
        goto L3
    L9:
        return r2;
    L6:
        r1 = r2 + 1;
        goto L3
    L11:
        return -(r1 + 1);
    }

    public static final float b(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "s1");
        Intrinsics.checkNotNullParameter(r13, "s2");
        int r3 = 0;
        if (r12.length() != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L15;
        if (r13.length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L15;
        return 1.0f;
    L11:
        r4 = false;
    L15:
        if (r12.length() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        return 0.0f;
    L20:
        if (r13.length() != 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L63;
        Intrinsics.checkNotNullParameter(r12, "s1");
        Intrinsics.checkNotNullParameter(r13, "s2");
        if (Intrinsics.areEqual(r12, r13) == true) goto L55;
        int r0 = r12.length();
        int r1 = r13.length();
        int r7 = r0 + 1;
        int[][] r8 = new int[r7][];
        int r9 = 0;
    L29:
        if (r9 >= r7) goto L31;
        r8[r9] = new int[r1 + 1];
        r9 = r9 + 1;
        goto L29
    L31:
        if (r0 < 0) goto L36;
        int r10 = 0;
    L33:
        r8[r10][0] = r10;
        if (r10 == r0) goto L36;
        r10 = r10 + 1;
    L36:
        if (r1 < 0) goto L41;
        int r11 = 0;
    L38:
        r8[0][r11] = r11;
        if (r11 == r1) goto L41;
        r11 = r11 + 1;
    L41:
        if (1 > r0) goto L53;
        int r14 = 1;
    L43:
        if (1 > r1) goto L51;
        int r15 = 1;
    L45:
        int r16 = r14 - 1;
        int r17 = r15 - 1;
        if (r12.charAt(r16) != r13.charAt(r17)) goto L48;
        r8[r14][r15] = r8[r16][r17];
    L49:
        if (r15 == r1) goto L51;
        r15 = r15 + 1;
        goto L45
    L48:
        int[] r18 = r8[r14];
        int[] r19 = r8[r16];
        r18[r15] = Math.min(r19[r15] + 1, Math.min(r18[r17] + 1, r19[r17] + 1));
    L51:
        if (r14 == r0) goto L53;
        r14 = r14 + 1;
    L53:
        r3 = r8[r0][r1];
    L55:
        return 1.0f - (r3 / Math.max(r12.length(), r13.length()));
    L63:
        return 0.0f;
    L22:
        r6 = false;
        goto L23
    L17:
        r5 = false;
        goto L18
    L5:
        r2 = false;
        goto L7
    }
}
