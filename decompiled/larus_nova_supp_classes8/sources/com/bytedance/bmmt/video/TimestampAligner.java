package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class TimestampAligner {
    private volatile long nativeTimestampAligner;

    private static native long nativeCreateTimestampAligner();

    private static native void nativeReleaseTimestampAligner(long r0);

    private static native long nativeRtcTimeNanos();

    private static native long nativeTranslateTimestamp(long r0, long r2);

    private void checkNativeAlignerExists() {
        if (this.nativeTimestampAligner == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("TimestampAligner has been disposed.");
    }

    public TimestampAligner() {
        this.nativeTimestampAligner = nativeCreateTimestampAligner();
    }

    public static long getRtcTimeNanos() {
        return nativeRtcTimeNanos();
    }

    public void dispose() {
        checkNativeAlignerExists();
        nativeReleaseTimestampAligner(this.nativeTimestampAligner);
        this.nativeTimestampAligner = 0;
    }

    public long translateTimestamp(long r3) {
        checkNativeAlignerExists();
        return nativeTranslateTimestamp(this.nativeTimestampAligner, r3);
    }
}
