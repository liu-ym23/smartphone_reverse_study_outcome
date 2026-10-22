package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class VideoPlayer implements com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a {
    private static final int DEFAULT_POSITION_INTERVAL = 166;
    private static final int MIN_POSITION_INTERVAL = 15;
    private static final String TAG = "VideoPlayer";
    private final ClayPluginContext ClayPluginContext;
    private Handler mainHandler;
    private long nativePtr;
    private SurfaceTexture surfaceTexture;
    private boolean updatePosition;
    private int updatePositionInterval;
    private final Runnable updatePositionRunnable;
    private Timer updatePositionTimer;
    private TimerTask updatePositionTimerTask;
    private com.lynx.clay.embedding.engine.plugins.video.a videoEngine;
    private d videoRenderer;

    public class a implements Runnable {
        public final /* synthetic */ VideoPlayer a;

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.a.getPosition();     // Catch: Throwable -> L6
            if (r0 < 0) goto L9;
            this.a.onPositionUpdated(r0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(VideoPlayer r1) {
            this.a = r1;
        }
    }

    public class b extends TimerTask {
        public final /* synthetic */ VideoPlayer a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (VideoPlayer.access$000(this.a) == false) goto L9;
            VideoPlayer.access$200(this.a).post(VideoPlayer.access$100(this.a));     // Catch: Throwable -> L6
            return;
        }

        public b(VideoPlayer r1) {
            this.a = r1;
        }
    }

    private static native void nativeOnBufferingChange(long r0, int r2);

    private static native void nativeOnCanPlay(long r0);

    private static native void nativeOnEnded(long r0);

    private static native void nativeOnError(long r0, int r2, String r3, String r4);

    private static native void nativeOnFirstFrame(long r0);

    private static native void nativeOnPause(long r0);

    private static native void nativeOnPlay(long r0);

    private static native void nativeOnPlaying(long r0);

    private static native void nativeOnPositionUpdated(long r0, int r2);

    private static native void nativeOnPrepared(long r0, int r2);

    private static native void nativeOnVideoInfos(long r0, String r2, long r3);

    private static native void nativeOnVideoSizeChanged(long r0, int r2, int r3);

    private static native void nativeOnWaiting(long r0);

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onEnded() {
        this.updatePosition = false;
        nativeOnEnded(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onPause() {
        this.updatePosition = false;
        nativeOnPause(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onPlay() {
        this.updatePosition = true;
        nativeOnPlay(this.nativePtr);
    }

    private void ensureVideoRenderer() {
        boolean r1 = false;
        if (this.surfaceTexture == null) goto L5;
        boolean r0 = true;
    L6:
        d r3 = this.videoRenderer;
        if (r3 != null) goto L9;
    L14:
        if (r0 == false) goto L16;
        d r2 = new f(this.surfaceTexture);
    L17:
        this.videoRenderer = r2;
        r2.a(this.ClayPluginContext.a, this.videoEngine);
        return;
    L16:
        r2 = new e();
        goto L17
    L9:
        if (r3.c() == 1) goto L11;
        r1 = true;
    L11:
        if (r1 != r0) goto L13;
        this.videoRenderer.dispose();
        goto L14
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void stopTimer() {
        TimerTask r0 = this.updatePositionTimerTask;
        if (r0 == null) goto L6;
        r0.cancel();
        this.updatePositionTimerTask = null;
        return;
    }

    public int getDuration() {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getDuration();
    }

    public int getPosition() {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getPosition();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onCanPlay() {
        nativeOnCanPlay(this.nativePtr);
    }

    public void onEnterBackground() {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L11;
        r0.enterBackground();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        c5a.c.d(6, TAG, "onEnterBackground error:" + th.toString());
        return;
    }

    public void onEnterForeground() {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L11;
        r0.enterForeground();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        c5a.c.d(6, TAG, "onEnterForeground error:" + th.toString());
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onFirstFrame() {
        nativeOnFirstFrame(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onPlaying() {
        nativeOnPlaying(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onWaiting() {
        nativeOnWaiting(this.nativePtr);
    }

    public void pause() {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    public void play() {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.play();
        return;
    }

    public void stop() {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    private void startTimer() {
        stopTimer();
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L9;
        r0.g();
        if (this.updatePositionTimer != null) goto L7;
        this.updatePositionTimer = new PthreadTimer("o/VideoPlayer");
    L7:
        b r3 = new b(this);
        this.updatePositionTimerTask = r3;
        this.updatePositionTimer.schedule(r3, 0, this.updatePositionInterval);
        return;
    }

    public void didUpdateAttributes() {
        ensureVideoRenderer();
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public void onDestroy() {
        stopTimer();
        Timer r0 = this.updatePositionTimer;
        if (r0 == null) goto L5;
        r0.cancel();
        this.updatePositionTimer = null;
    L5:
        d r1 = this.videoRenderer;
        if (r1 == null) goto L8;
        r1.detach();
        this.videoRenderer.dispose();
        this.videoRenderer = null;
    L8:
        com.lynx.clay.embedding.engine.plugins.video.a r2 = this.videoEngine;
        if (r2 == null) goto L11;
        r2.dispose();
        this.videoEngine = null;
    L11:
        this.nativePtr = 0;
    }

    public void onCompletion() {
        onEnded();
    }

    public VideoPlayer(ClayPluginContext r3) {
        this.updatePositionRunnable = new a(this);
        this.updatePositionInterval = DEFAULT_POSITION_INTERVAL;
        this.updatePosition = false;
        this.ClayPluginContext = r3;
        Context r4 = r3.a.getContext();
        this.mainHandler = new Handler(r4.getMainLooper());
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r5a.a.a(r4) == true) goto L14;
    L9:
        com.lynx.clay.embedding.engine.plugins.video.a r0 = new VideoEngineMPImpl(this);     // Catch: Throwable -> L12
    L10:
        this.videoEngine = r0;
        startTimer();
        return;
    L14:
        r0 = new com.lynx.clay.embedding.engine.plugins.video.b(r4, this);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
        goto L9
    }

    public static VideoPlayer Create(ClayPluginContext r1) {
        return new VideoPlayer(r1);
    }

    public static /* synthetic */ boolean access$000(VideoPlayer r0) {
        return r0.updatePosition;
    }

    public static /* synthetic */ Runnable access$100(VideoPlayer r0) {
        return r0.updatePositionRunnable;
    }

    public static /* synthetic */ Handler access$200(VideoPlayer r0) {
        return r0.mainHandler;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onBufferingChange(int r3) {
        nativeOnBufferingChange(this.nativePtr, r3);
    }

    public void onPositionUpdated(int r3) {
        nativeOnPositionUpdated(this.nativePtr, r3);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onPrepared(int r3) {
        nativeOnPrepared(this.nativePtr, r3);
    }

    public void seekTo(int r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.seekTo(r2);
        return;
    }

    public void setAutoplay(boolean r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public void setCache(boolean r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public void setInitTime(int r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    public void setLoop(boolean r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.setLoop(r2);
        return;
    }

    public void setMuted(boolean r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.setMuted(r2);
        return;
    }

    public void setNativePtr(long r1) {
        this.nativePtr = r1;
    }

    public void setPreloadKey(String r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    public void setReuseEngine(boolean r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    public void setSpeed(float r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.setSpeed(r2);
        return;
    }

    public void setSrc(String r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.setSrc(r2);
        return;
    }

    public void setSurfaceTexture(SurfaceTexture r1) {
        this.surfaceTexture = r1;
    }

    public void setTimeUpdateInterval(int r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        stopTimer();
        if (r2 >= MIN_POSITION_INTERVAL) goto L8;
        r2 = MIN_POSITION_INTERVAL;
    L8:
        this.updatePositionInterval = r2;
        startTimer();
    }

    public void setVolume(double r2) {
        com.lynx.clay.embedding.engine.plugins.video.a r0 = this.videoEngine;
        if (r0 == null) goto L6;
        r0.setVolume(r2);
        return;
    }

    public void onError(int r1, int r2) {
        onError(r1, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onVideoInfos(String r3, long r4) {
        nativeOnVideoInfos(this.nativePtr, r3, r4);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onVideoSizeChanged(int r3, int r4) {
        nativeOnVideoSizeChanged(this.nativePtr, r3, r4);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a
    public void onError(int r3, String r4, String r5) {
        this.updatePosition = false;
        nativeOnError(this.nativePtr, r3, r4, r5);
    }

    public void updateVideoBound(int r4, int r5, int r6, int r7) {
        c5a.c.d(6, TAG, String.format("updateVideoBound x=%d, y=%d, w=%d, h=%d", new Object[]{Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7)}));
        d r0 = this.videoRenderer;
        if (r0 == null) goto L6;
        r0.b(r4, r5, r6, r7);
        return;
    }
}
