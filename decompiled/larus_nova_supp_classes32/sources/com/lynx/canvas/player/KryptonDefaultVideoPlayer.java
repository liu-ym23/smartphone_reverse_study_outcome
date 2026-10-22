package com.lynx.canvas.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.view.Surface;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonVideoPlayer;
import fna.g;
import gna.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonDefaultVideoPlayer implements KryptonVideoPlayer, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {
    private static final String TAG = "Player default";
    private Context mContext;
    private double mCurrentTimeForPause;
    private int mDuration;
    private int mHeight;
    private final MediaPlayer mPlayer;
    private KryptonVideoPlayer.Listener mPlayerListener;
    private int mRotation;
    private int mWidth;

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public double getCurrentTime() {
        if (this.mPlayer.isPlaying() == true) goto L7;
        return this.mCurrentTimeForPause;
    L7:
        return ((double) this.mPlayer.getCurrentPosition()) / 1000.0d;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public boolean getLooping() {
        return this.mPlayer.isLooping();
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public double getPlaybackRate() {
    L7:
        e = move-exception;
        KryptonLLog.e(TAG, "getPlaybackRate exception:" + e.getMessage());
        return 1.0d;
    L3:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        return this.mPlayer.getPlaybackParams().getSpeed();
    L13:
        return 1.0d;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void pause() {
        this.mCurrentTimeForPause = ((double) this.mPlayer.getCurrentPosition()) / 1000.0d;     // Catch: IllegalStateException -> L6
        INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(this.mPlayer);     // Catch: IllegalStateException -> L6
        KryptonVideoPlayer.Listener r0 = this.mPlayerListener;     // Catch: IllegalStateException -> L6
        if (r0 == null) goto L11;
        r0.onPaused(this);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        KryptonLLog.e(TAG, "pause exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void play() {
        INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(this.mPlayer);     // Catch: IllegalStateException -> L6
        KryptonVideoPlayer.Listener r0 = this.mPlayerListener;     // Catch: IllegalStateException -> L6
        if (r0 == null) goto L11;
        r0.onStartPlay(this);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        KryptonLLog.e(TAG, "play exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void prepare() {
        this.mPlayer.prepareAsync();     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "prepareAsync exception: " + e.getMessage());
        callbackWithErrorMessage("prepareAsync exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void release() {
        this.mPlayer.release();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "release exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getRotation() {
        return this.mRotation;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getVideoHeight() {
        return this.mHeight;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getVideoWidth() {
        return this.mWidth;
    }

    public KryptonDefaultVideoPlayer(Context r1) {
        this.mContext = r1;
        MediaPlayer r2 = new MediaPlayer();
        this.mPlayer = r2;
        r2.setOnPreparedListener(this);
        r2.setOnErrorListener(this);
        r2.setOnCompletionListener(this);
        r2.setOnSeekCompleteListener(this);
        r2.setOnInfoListener(this);
    }

    public static void INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(MediaPlayer r1) {
        if (g.d() == true) goto L6;
        r1.pause();
        return;
    L6:
        r1.pause();
        a.a(r1.hashCode());
    }

    public static void INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(MediaPlayer r1) {
        if (g.d() == true) goto L6;
        r1.start();
        return;
    L6:
        r1.start();
        a.c(r1.hashCode());
    }

    private void callbackWithErrorMessage(String r3) {
        KryptonVideoPlayer.Listener r0 = this.mPlayerListener;
        if (r0 == null) goto L6;
        r0.onError(this, new Error(r3));
        return;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer r1) {
        KryptonVideoPlayer.Listener r2 = this.mPlayerListener;
        if (r2 == null) goto L6;
        r2.onCompletion(this);
        return;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer r2) {
        KryptonLLog.i(TAG, "onPrepared");
        if (this.mPlayerListener == null) goto L6;
        this.mWidth = this.mPlayer.getVideoWidth();
        this.mHeight = this.mPlayer.getVideoHeight();
        this.mDuration = this.mPlayer.getDuration();
        this.mPlayerListener.onPrepared(this);
        return;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer r1) {
        KryptonVideoPlayer.Listener r2 = this.mPlayerListener;
        if (r2 == null) goto L6;
        r2.onSeekComplete(this);
        return;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setCurrentTime(double r3) {
        int r4 = (int) (r3 * 1000.0d);
    L8:
        e = move-exception;
        KryptonLLog.e(TAG, "seekTo exception:" + e.getMessage());
        return;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mPlayer.seekTo(r4, 3);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        this.mPlayer.seekTo(r4);     // Catch: Exception -> L8
        goto L11
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setDataSource(String r4) {
        this.mPlayer.reset();     // Catch: Exception -> L9
        this.mCurrentTimeForPause = 0.0d;     // Catch: Exception -> L9
        this.mPlayer.setDataSource(this.mContext, UriProtector.parse(r4));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        KryptonLLog.e(TAG, "setDataSource exception: " + e.getMessage());
        callbackWithErrorMessage("setDataSource exception:" + e.getMessage());
        return;
    L9:
        e = move-exception;
        KryptonLLog.e(TAG, "reset exception: " + e.getMessage());
        callbackWithErrorMessage("reset exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setListener(KryptonVideoPlayer.Listener r1) {
        this.mPlayerListener = r1;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setLooping(boolean r2) {
        this.mPlayer.setLooping(r2);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setPlaybackRate(double r4) {
    L8:
        e = move-exception;
        KryptonLLog.e(TAG, "setPlaybackRate exception:" + e.getMessage());
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        PlaybackParams r1 = this.mPlayer.getPlaybackParams();     // Catch: IllegalStateException -> L8
        r1.setSpeed((float) r4);     // Catch: IllegalStateException -> L8
        this.mPlayer.setPlaybackParams(r1);     // Catch: IllegalStateException -> L8
    L11:
        return;
    L6:
        KryptonLLog.i(TAG, "setPlaybackRate is not supported on API < 23");     // Catch: IllegalStateException -> L8
        goto L11
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setSurface(Surface r3) {
        this.mPlayer.setSurface(r3);     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "setSurface exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setVolume(double r2) {
        float r3 = (float) r2;
        this.mPlayer.setVolume(r3, r3);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer r2, int r3, int r4) {
        KryptonLLog.i(TAG, "onError what " + r3 + " extra " + r4);
        callbackWithErrorMessage("what: " + r3 + ", extra: " + r4);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer r2, int r3, int r4) {
        KryptonLLog.i(TAG, "onInfo what " + r3 + " extra " + r4);
        if (r3 != 3) goto L9;
        KryptonVideoPlayer.Listener r5 = this.mPlayerListener;
        if (r5 == null) goto L11;
        r5.onRenderStart(this);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
