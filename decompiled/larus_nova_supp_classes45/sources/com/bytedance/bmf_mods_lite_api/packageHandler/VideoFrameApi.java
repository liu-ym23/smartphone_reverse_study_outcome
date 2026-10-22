package com.bytedance.bmf_mods_lite_api.packageHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface VideoFrameApi {

    /* JADX INFO: renamed from: com.bytedance.bmf_mods_lite_api.packageHandler.VideoFrameApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$clearData(VideoFrameApi r0) {
            return -1;
        }

        public static long $default$getNativePtr(VideoFrameApi r2) {
            return 0;
        }

        public static int $default$getVideoFrameFormat(VideoFrameApi r0) {
            return -1;
        }

        public static int $default$getVideoFrameHeight(VideoFrameApi r0) {
            return -1;
        }

        public static int $default$getVideoFrameTexture(VideoFrameApi r0) {
            return -1;
        }

        public static int $default$getVideoFrameWidth(VideoFrameApi r0) {
            return -1;
        }

        public static void $default$release(VideoFrameApi r0) {
        }

        public static int $default$setVideoFrame(VideoFrameApi r0, int r1, int r2, int r3, int r4, int r5) {
            return -1;
        }
    }

    int clearData();

    long getNativePtr();

    int getVideoFrameFormat();

    int getVideoFrameHeight();

    int getVideoFrameTexture();

    int getVideoFrameWidth();

    void release();

    int setVideoFrame(int r1, int r2, int r3, int r4, int r5);
}
