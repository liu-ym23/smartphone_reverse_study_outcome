package com.bytedance.bmmt.video;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class VideoEncoderWrapper {
    public VideoEncoderWrapper() {
    }

    public static /* bridge */ /* synthetic */ void a(long r0, int r2) {
        nativeOnEncodedEvent(r0, r2);
    }

    public static /* bridge */ /* synthetic */ void b(long r0, ByteBuffer r2, ByteBuffer r3, int r4, int r5, int r6, int r7, long r8, int r10, int r11, int r12, long r13, int r15) {
        nativeOnEncodedFrame(r0, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r15);
    }

    private static native void nativeOnEncodedEvent(long r0, int r2);

    private static native void nativeOnEncodedFrame(long r0, ByteBuffer r2, ByteBuffer r3, int r4, int r5, int r6, int r7, long r8, int r10, int r11, int r12, long r13, int r15);

    public static VideoEncoder.Callback createEncoderCallback(final long r1) {
        return new AnonymousClass1(r1);
    }

    public static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings r0) {
        return r0.high;
    }

    public static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings r0) {
        return r0.low;
    }

    public static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings r0) {
        return r0.on;
    }
}
