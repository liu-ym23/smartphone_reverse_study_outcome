package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes2.dex */
class FrameMetrics {
    public final Long[] durationsNs;
    public final Integer[] skippedFrames;
    public final Long[] timestampsNs;

    public FrameMetrics() {
        this.timestampsNs = new Long[0];
        this.durationsNs = new Long[0];
        this.skippedFrames = new Integer[0];
    }

    public FrameMetrics(Long[] r10, Long[] r11, Integer[] r12) {
        this.timestampsNs = r10;
        this.durationsNs = r11;
        this.skippedFrames = r12;
    }
}
