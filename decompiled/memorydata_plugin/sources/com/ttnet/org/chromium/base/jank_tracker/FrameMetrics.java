package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes6.dex */
class FrameMetrics {
    public final Long[] durationsNs;
    public final Integer[] skippedFrames;
    public final Long[] timestampsNs;

    public FrameMetrics() {
        this.timestampsNs = new Long[0];
        this.durationsNs = new Long[0];
        this.skippedFrames = new Integer[0];
    }

    public FrameMetrics(Long[] r1, Long[] r2, Integer[] r3) {
        this.timestampsNs = r1;
        this.durationsNs = r2;
        this.skippedFrames = r3;
    }
}
