package com.lynx.canvas.player;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonReflectLoader;
import com.lynx.canvas.KryptonSettingsService;
import com.lynx.canvas.KryptonVideoPlayer;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.SurfaceTextureWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PlayerContext implements KryptonVideoPlayer.Listener {
    private static final int CAN_DRAW = 3;
    private static final int CAN_PLAY = 0;
    private static final int END = 1;
    private static final int ERROR = 2;
    private static final int PAUSED = 6;
    private static final int SEEK_END = 4;
    private static final int START_PLAY = 5;
    private static final String TAG = "PlayerContext";
    private static final String USE_CUSTOM_PLAYER = "useCustomPlayer";
    private Context mContext;
    private double mCurrentTime;
    private double mCurrentTimeCache;
    private final KryptonApp mKryptonApp;
    private Looper mLooperTriggerLoad;
    long mNativePtr;
    private Map<String, String> mOptions;
    private volatile boolean mPrepared;
    KryptonVideoPlayer mVideoPlayer;

    private static native void nativeNotifyPlayerState(long r0, int r2, int[] r3, String r4);

    private boolean checkTTEngineHardwareDecodeDisabled() {
        String r1 = Build.MODEL;
        boolean r2 = false;
        KryptonSettingsService r3 = (KryptonSettingsService) this.mKryptonApp.getService(KryptonSettingsService.class);     // Catch: Throwable -> L10
        if (r3 == null) goto L12;
        Collection r4 = (Collection) r3.objectValueForKey("TT_VIDEO_HARDWARE_DECODE_BLACK_LIST", null);     // Catch: Throwable -> L10
        if (r4 == null) goto L12;
        if (r4.contains(r1.toLowerCase()) == false) goto L12;
        r2 = true;
    L12:
        KryptonLLog.i(TAG, "checkTTEngineHardwareDecodeDisabled = " + r2 + " for " + r1);
        return r2;
    L10:
        th = move-exception;
        KryptonLLog.w(TAG, "checkTTEngineHardwareDecodeDisabled error " + th.toString());
        goto L12
    }

    private KryptonVideoPlayer createPlayer() {
        Map<String, String> r0 = this.mOptions;
        boolean r2 = false;
        if (r0 == null) goto L8;
        String r1 = r0.get(USE_CUSTOM_PLAYER);
        if (r1 == null) goto L7;
        r2 = Boolean.parseBoolean(r1);
    L7:
        KryptonLLog.i(TAG, "create player options: " + this.mOptions);
    L8:
        if (r2 == false) goto L15;
        KryptonVideoPlayerService r3 = (KryptonVideoPlayerService) this.mKryptonApp.getService(KryptonVideoPlayerService.class);
        if (r3 != null) goto L12;
        r3 = (KryptonVideoPlayerService) KryptonReflectLoader.inst().getHybridServiceInstance(KryptonVideoPlayerService.class);
    L12:
        if (r3 == null) goto L14;
        KryptonLLog.i(TAG, "create player using custom player service");
    L16:
        if (r3 != null) goto L18;
        r3 = new AnonymousClass1(this);
    L18:
        Boolean r4 = Boolean.valueOf(checkTTEngineHardwareDecodeDisabled());
        Map<String, String> r5 = this.mOptions;
        if (r5 == null) goto L22;
        r5.put("disable_tt_engine_hardware_decode", r4.toString());
    L25:
        return r3.createVideoPlayer(this.mOptions);
    L22:
        if (r4.booleanValue() == false) goto L25;
        HashMap r6 = new HashMap();
        this.mOptions = r6;
        r6.put("disable_tt_engine_hardware_decode", "true");
        goto L25
    L14:
        KryptonLLog.i(TAG, "create player using system player service, as custom player service is not set");
        goto L16
    L15:
        KryptonLLog.i(TAG, "create player using default player service");
        r3 = null;
        goto L16
    }

    public double getCurrentTime() {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.getCurrentTime();
    }

    public boolean getLoop() {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getLooping();
    }

    public double getPlaybackRate() {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L7;
        return 1.0d;
    L7:
        return r0.getPlaybackRate();
    }

    public void pause() {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPlaying() == false) goto L10;
        this.mVideoPlayer.pause();
        return;
    }

    public void play() {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.play();
    }

    public void release() {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 == null) goto L5;
        r0.setListener(null);
        this.mVideoPlayer.release();
        this.mVideoPlayer = null;
    L5:
        this.mNativePtr = 0;
    }

    public static /* synthetic */ Context access$000(PlayerContext r0) {
        return r0.mContext;
    }

    public static /* synthetic */ double access$100(PlayerContext r2) {
        return r2.mCurrentTimeCache;
    }

    private void loadInternal(String r4) {
        if (this.mVideoPlayer != null) goto L6;
        this.mVideoPlayer = createPlayer();
        this.mLooperTriggerLoad = Looper.myLooper();
        this.mVideoPlayer.setListener(this);
    L6:
        if (this.mVideoPlayer != null) goto L9;
        KryptonLLog.e(TAG, "service create video player return null");
        return;
    L9:
        KryptonLLog.i(TAG, "load url " + r4);
        this.mVideoPlayer.setDataSource(r4);
        this.mVideoPlayer.prepare();
    }

    public void load(String r1) {
        loadInternal(r1);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onCompletion(KryptonVideoPlayer r2) {
        callbackOnThreadTriggerLoad(1, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onPaused(KryptonVideoPlayer r2) {
        callbackOnThreadTriggerLoad(6, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onPrepared(KryptonVideoPlayer r2) {
        this.mPrepared = true;
        callbackOnThreadTriggerLoad(0, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onRenderStart(KryptonVideoPlayer r2) {
        callbackOnThreadTriggerLoad(3, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onSeekComplete(KryptonVideoPlayer r2) {
        callbackOnThreadTriggerLoad(4, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onStartPlay(KryptonVideoPlayer r2) {
        callbackOnThreadTriggerLoad(5, null);
    }

    public void setCurrentTime(double r2) {
        if (this.mVideoPlayer != null) goto L5;
    L9:
        this.mCurrentTimeCache = r2;
        return;
    L5:
        if (this.mPrepared == false) goto L9;
        this.mVideoPlayer.setCurrentTime(r2);
    }

    public void setLoop(boolean r2) {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setLooping(r2);
    }

    public void setPlaybackRate(double r2) {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setPlaybackRate(r2);
    }

    public void setVolume(double r2) {
        KryptonVideoPlayer r0 = this.mVideoPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVolume(r2);
    }

    public void setupSurface(SurfaceTextureWrapper r2) {
        this.mVideoPlayer.setSurface(r2.getSurface());
    }

    private void callbackOnThreadTriggerLoad(final int r3, final String r4) {
        new Handler(this.mLooperTriggerLoad).post(new AnonymousClass2(this, r3, r4));
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public boolean onError(KryptonVideoPlayer r1, Object r2) {
        if (r2 == null) goto L5;
        callbackOnThreadTriggerLoad(2, r2.toString());
        return false;
    L5:
        callbackOnThreadTriggerLoad(2, "Internal error");
        return false;
    }

    private PlayerContext(long r3, KryptonApp r5, Map<String, String> r6) {
        this.mCurrentTime = 0.0d;
        this.mNativePtr = r3;
        this.mKryptonApp = r5;
        this.mContext = r5.getContext();
        this.mOptions = r6;
        this.mPrepared = false;
        this.mCurrentTimeCache = 0.0d;
    }

    public static PlayerContext create(long r1, KryptonApp r3, Object r4) {
        return new PlayerContext(r1, r3, (Map) r4);
    }

    public static /* synthetic */ void access$200(long r0, int r2, int[] r3, String r4) {
        nativeNotifyPlayerState(r0, r2, r3, r4);
    }
}
