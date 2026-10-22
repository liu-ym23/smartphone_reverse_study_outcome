package com.bytedance.bmmt.video;

import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class VideoDecoderWrapper {
    public VideoDecoderWrapper() {
    }

    public static /* bridge */ /* synthetic */ void a(long r0, BmmtVideoFrameInterface r2) {
        nativeOnDecodedFrame(r0, r2);
    }

    public static /* bridge */ /* synthetic */ void b(long r0, VideoCodecStatus r2, String r3) {
        nativeOnMediaCodecStatus(r0, r2, r3);
    }

    private static native void nativeOnDecodedFrame(long r0, BmmtVideoFrameInterface r2);

    private static native void nativeOnMediaCodecStatus(long r0, VideoCodecStatus r2, String r3);

    public static VideoDecoder.Callback createDecoderCallback(final long r1) {
        return new AnonymousClass1(r1);
    }
}
