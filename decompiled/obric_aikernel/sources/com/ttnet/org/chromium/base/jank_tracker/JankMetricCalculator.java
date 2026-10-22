package com.ttnet.org.chromium.base.jank_tracker;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class JankMetricCalculator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS = 50000000;
    private static final long JANK_THRESHOLD_NS = 16000000;
    private static final long NANOSECONDS_PER_MILLISECOND = 1000000;

    static {
    }

    JankMetricCalculator() {
    }

    private static boolean areFramesConsecutive(int r10, int r11, long[] r12, long[] r13) {
        if (r10 < 0) goto L15;
        if (r11 >= 0) goto L7;
        return false;
    L7:
        if (r10 < r12.length) goto L9;
        return false;
    L9:
        if (r11 >= r12.length) goto L19;
        long r14 = r12[r10];
        if (((r12[r11] - r13[r11]) - r14) >= JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS) goto L17;
        return true;
    L17:
        return false;
    L19:
        return false;
    L15:
        return false;
    }

    private static long[] calculateJankBurstDurationsNs(long[] r10, long[] r11) {
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        long r14 = 0;
    L4:
        if (r13 >= r10.length) goto L26;
        if (r13 > 0) goto L7;
    L11:
        long r15 = r11[r13];
        if (isFrameJanky(r13, r11) == false) goto L15;
    L13:
        r14 = r14 + r15;
    L24:
        r13 = r13 + 1;
        goto L4
    L15:
        if (r14 <= 0) goto L24;
        if (areFramesConsecutive(r13 - 1, r13, r10, r11) == false) goto L23;
        int r16 = r13 + 1;
        if (areFramesConsecutive(r13, r16, r10, r11) == false) goto L23;
        if (isFrameJanky(r16, r11) == true) goto L13;
    L23:
        r12.add(Long.valueOf(r14));
        r14 = 0;
        goto L24
    L7:
        if (r14 <= 0) goto L11;
        if (areFramesConsecutive(r13 - 1, r13, r10, r11) == true) goto L11;
        r12.add(Long.valueOf(r14));
        r14 = 0;
        goto L11
    L26:
        if (r14 <= 0) goto L29;
        r12.add(Long.valueOf(r14));
    L29:
        return longArrayToPrimitiveArray((Long[]) r12.toArray(new Long[r12.size()]));
    }

    static JankMetrics calculateJankMetrics(FrameMetrics r10) {
        long[] r11 = longArrayToPrimitiveArray(r10.timestampsNs);
        long[] r12 = longArrayToPrimitiveArray(r10.durationsNs);
        int r13 = sumArray(r10.skippedFrames);
        return new JankMetrics(r11, r12, calculateJankBurstDurationsNs(r11, r12), r13);
    }

    private static boolean isFrameJanky(int r10, long[] r11) {
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (r10 < r11.length) goto L8;
        return false;
    L8:
        if (r11[r10] <= JANK_THRESHOLD_NS) goto L12;
        return true;
    L12:
        return false;
    }

    private static long[] longArrayToPrimitiveArray(Long[] r10) {
        long[] r11 = new long[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].longValue();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    private static int sumArray(Integer[] r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].intValue();
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }
}
