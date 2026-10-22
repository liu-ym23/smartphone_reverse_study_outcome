package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes2.dex */
class JankMetrics {
    public final long[] durationsNs;
    public final long[] jankBurstsNs;
    public final int skippedFrames;
    public final long[] timestampsNs;

    public JankMetrics(long[] r10, long[] r11, long[] r12, int r13) {
        this.timestampsNs = r10;
        this.durationsNs = r11;
        this.jankBurstsNs = r12;
        this.skippedFrames = r13;
    }
}
