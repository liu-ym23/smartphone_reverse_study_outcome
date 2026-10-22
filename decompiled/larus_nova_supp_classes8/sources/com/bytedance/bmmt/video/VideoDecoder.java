package com.bytedance.bmmt.video;

import android.view.Surface;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface VideoDecoder {

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.VideoDecoder$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$createNativeVideoDecoder(VideoDecoder r2) {
            return 0;
        }
    }

    public interface Callback {
        void onDecodedFrame(BmmtVideoFrameInterface r1);

        void onMediaCodecStatus(VideoCodecStatus r1, String r2);
    }

    public static class DecodeInfo {
        public final boolean isMissingFrames;
        public final long renderTimeMs;

        public DecodeInfo(boolean r1, long r2) {
            this.isMissingFrames = r1;
            this.renderTimeMs = r2;
        }
    }

    public static class Settings {
        public final int adaptivePlaybackMaxHeight;
        public final int adaptivePlaybackMaxWidth;
        public final int directRenderMode;
        public final boolean enableAGFXSurfaceTextureHelper;
        public final boolean enableAdaptivePlayback;
        public final boolean enableAsyncMode;
        public final boolean enableBFrameDecode;
        public final boolean enableRecreateByResolution;
        public final boolean enableSmoothOutput;
        public final boolean enableSurfaceTextureReuse;
        public final boolean enableYUVOutput;
        public final int height;
        public final boolean latencyInsensitiveMode;
        public final int numberOfCores;
        public final boolean outputByDts;
        public final EglBase.Context sharedContext;
        public final int superResolutionHeight;
        public final int superResolutionMode;
        public final float superResolutionRatio;
        public final int superResolutionWidth;
        public final int texturePlayoutMode;
        public final int width;

        public Settings(int r3, int r4, int r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, EglBase.Context r14, boolean r15, int r16, int r17, int r18, float r19, int r20, int r21, boolean r22, int r23, int r24) {
            this.numberOfCores = r3;
            this.width = r4;
            this.height = r5;
            this.outputByDts = r6;
            this.enableSmoothOutput = r7;
            this.enableYUVOutput = r8;
            this.latencyInsensitiveMode = r9;
            this.enableSurfaceTextureReuse = r10;
            this.enableRecreateByResolution = r11;
            this.enableBFrameDecode = r12;
            this.sharedContext = r14;
            this.enableAGFXSurfaceTextureHelper = r13;
            this.enableAsyncMode = r15;
            this.directRenderMode = r16;
            this.texturePlayoutMode = r17;
            this.superResolutionMode = r18;
            this.superResolutionRatio = r19;
            this.superResolutionWidth = r20;
            this.superResolutionHeight = r21;
            this.enableAdaptivePlayback = r22;
            this.adaptivePlaybackMaxWidth = r23;
            this.adaptivePlaybackMaxHeight = r24;
        }
    }

    long createNativeVideoDecoder();

    VideoCodecStatus decode(EncodedImage r1);

    void disableExternalSurface();

    String getImplementationName();

    boolean getPrefersLateDecoding();

    VideoCodecStatus initDecode(Settings r1, Callback r2);

    void onFrame(BmmtVideoFrameInterface r1);

    VideoCodecStatus release();

    VideoCodecStatus setDeliverParams(boolean r1, int r2, float r3, float r4, int r5);

    void setExternalSurface(Surface r1);

    VideoCodecStatus setPrivateParam(String r1, String r2);

    VideoCodecStatus updateSettings(Settings r1);
}
