package com.bytedance.crash.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class NumRanges {
    Long[] mSortedArray;
    String mUnit;

    public NumRanges(String r10) {
        this.mUnit = r10;
    }

    public String get(long r13) {
        Long[] r10 = this.mSortedArray;
        if (r10 != null) goto L6;
        return "";
    L6:
        int r11 = r10.length;
        int r12 = 0;
        long r14 = Long.MIN_VALUE;
    L8:
        if (r12 >= r11) goto L13;
        Long r15 = r10[r12];
        if (r13 < r15.longValue()) goto L12;
        r14 = r15.longValue();
        r12 = r12 + 1;
        goto L8
    L12:
        long r16 = r15.longValue() - 1;
    L14:
        String r17 = "[";
        if (r14 == Long.MIN_VALUE) goto L17;
        r17 = "[" + r14 + this.mUnit;
    L17:
        String r18 = r17 + " - ";
        if (r16 == Long.MAX_VALUE) goto L21;
        r18 = r18 + r16 + this.mUnit;
    L21:
        return r18 + "]";
    L13:
        r16 = Long.MAX_VALUE;
        goto L14
    }

    public void set(long r10, long r11, long r12) {
        int r13 = ((int) ((r11 - r10) / r12)) + 1;
        Long[] r14 = new Long[r13];
        int r15 = 0;
    L3:
        int r16 = r13 - 1;
        if (r15 >= r16) goto L6;
        r14[r15] = Long.valueOf((((long) r15) * r12) + r10);
        r15 = r15 + 1;
        goto L3
    L6:
        r14[r16] = Long.valueOf(r11);
        set(r14);
    }

    public void set(Long[] r10) {
        Arrays.sort(r10);
        this.mSortedArray = r10;
    }
}
