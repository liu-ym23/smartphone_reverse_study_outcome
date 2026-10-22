package com.lynx.canvas;

import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface KryptonVideoPlayer {

    /* JADX INFO: renamed from: com.lynx.canvas.KryptonVideoPlayer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static double $default$getPlaybackRate(KryptonVideoPlayer r2) {
            return 1.0d;
        }

        public static void $default$setPlaybackRate(KryptonVideoPlayer r0, double r1) {
        }
    }

    public interface Listener {
        void onCompletion(KryptonVideoPlayer r1);

        boolean onError(KryptonVideoPlayer r1, Object r2);

        void onPaused(KryptonVideoPlayer r1);

        void onPrepared(KryptonVideoPlayer r1);

        void onRenderStart(KryptonVideoPlayer r1);

        void onSeekComplete(KryptonVideoPlayer r1);

        void onStartPlay(KryptonVideoPlayer r1);
    }

    double getCurrentTime();

    int getDuration();

    boolean getLooping();

    double getPlaybackRate();

    int getRotation();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void play();

    void prepare();

    void release();

    void setCurrentTime(double r1);

    void setDataSource(String r1);

    void setListener(Listener r1);

    void setLooping(boolean r1);

    void setPlaybackRate(double r1);

    void setSurface(Surface r1);

    void setVolume(double r1);
}
