package com.bytedance.crash.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class NumRanges {
    Long[] mSortedArray;
    String mUnit;

    public NumRanges(String r1) {
        this.mUnit = r1;
    }

    public String get(long r13) {
        Long[] r0 = this.mSortedArray;
        if (r0 != null) goto L6;
        return "";
    L6:
        int r1 = r0.length;
        int r2 = 0;
        long r5 = Long.MIN_VALUE;
    L8:
        if (r2 >= r1) goto L13;
        Long r9 = r0[r2];
        if (r13 < r9.longValue()) goto L12;
        r5 = r9.longValue();
        r2 = r2 + 1;
        goto L8
    L12:
        long r14 = r9.longValue() - 1;
    L14:
        String r3 = "[";
        if (r5 == Long.MIN_VALUE) goto L17;
        r3 = "[" + r5 + this.mUnit;
    L17:
        String r4 = r3 + " - ";
        if (r14 == Long.MAX_VALUE) goto L21;
        r4 = r4 + r14 + this.mUnit;
    L21:
        return r4 + "]";
    L13:
        r14 = Long.MAX_VALUE;
        goto L14
    }

    public void set(long r6, long r8, long r10) {
        int r0 = ((int) ((r8 - r6) / r10)) + 1;
        Long[] r1 = new Long[r0];
        int r2 = 0;
    L3:
        int r3 = r0 - 1;
        if (r2 >= r3) goto L6;
        r1[r2] = Long.valueOf((((long) r2) * r10) + r6);
        r2 = r2 + 1;
        goto L3
    L6:
        r1[r3] = Long.valueOf(r8);
        set(r1);
    }

    public void set(Long[] r1) {
        Arrays.sort(r1);
        this.mSortedArray = r1;
    }
}
