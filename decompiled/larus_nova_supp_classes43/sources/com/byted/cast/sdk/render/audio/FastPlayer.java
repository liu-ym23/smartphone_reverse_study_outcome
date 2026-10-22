package com.byted.cast.sdk.render.audio;

import com.byted.cast.sdk.RTCAudioProfile;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class FastPlayer {
    private static final String TAG = "FastPlayer";
    private long enginehandle;
    private byte[] mAudioBuffer;
    private IAudioFrameReader mAudioFrameReader;
    private Runnable mAudioPlayRunnable;
    private volatile boolean mIsLoopExit;
    private volatile boolean mIsPlayStarted;
    private Logger mLogger;
    private String mMirrorId;
    private Thread mPlayThread;

    public interface IAudioFrameReader {
        int readAudioFrame(byte[] r1);
    }

    public static /* synthetic */ void access$001(String r0) {
        System.loadLibrary(r0);
    }

    private native long native_setup();

    private native int native_start(long r1);

    private native void native_stop(long r1);

    private native int native_write(long r1, byte[] r10, int r11);

    static {
        INVOKESTATIC_com_byted_cast_sdk_render_audio_FastPlayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("oboeplayer_jni");
    }

    public void stop() {
        if (this.mIsPlayStarted == true) goto L5;
        return;
    L5:
        this.mIsLoopExit = true;
        this.mPlayThread.interrupt();     // Catch: InterruptedException -> L8
        ThreadMethodProxy.join(this.mPlayThread, 1000);     // Catch: InterruptedException -> L8
    L10:
        native_stop(this.enginehandle);
        this.mIsPlayStarted = false;
        this.mLogger.d(TAG, "FastPlayer stop success !");
        return;
    L8:
        e = move-exception;
        this.mLogger.e(TAG, e.getMessage());
        goto L10
    }

    public boolean isStarted() {
        return this.mIsPlayStarted;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_sdk_render_audio_FastPlayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r10) {
        Intrinsics.checkNotNullParameter(r10, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r10);
        com.bytedance.librarian.a.c(r10);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r10);
    }

    public static /* synthetic */ boolean access$000(FastPlayer r0) {
        return r0.mIsLoopExit;
    }

    public static /* synthetic */ byte[] access$100(FastPlayer r0) {
        return r0.mAudioBuffer;
    }

    public static /* synthetic */ IAudioFrameReader access$200(FastPlayer r0) {
        return r0.mAudioFrameReader;
    }

    private boolean playback(byte[] r10) {
        return playback(r10, 0, r10.length);
    }

    public FastPlayer(IAudioFrameReader r10, String r11) {
        this.enginehandle = 0;
        this.mIsLoopExit = false;
        this.mIsPlayStarted = false;
        this.mAudioPlayRunnable = new AnonymousClass1(this);
        this.mMirrorId = r11;
        this.mLogger = LoggerManager.getLogger(r11);
        this.mAudioFrameReader = r10;
        if (this.enginehandle != 0) goto L6;
        this.enginehandle = native_setup();
        return;
    }

    public static /* synthetic */ boolean access$300(FastPlayer r0, byte[] r1) {
        return r0.playback(r1);
    }

    private boolean playback(byte[] r10, int r11, int r12) {
        if (this.mIsPlayStarted == true) goto L6;
        this.mLogger.e(TAG, "Player not started !");
        return false;
    L6:
        native_write(this.enginehandle, r10, r12);
        return true;
    }

    public boolean start(int r10, int r11, int r12, int r13) {
        if (this.mIsPlayStarted == false) goto L5;
        return false;
    L5:
        native_start(this.enginehandle);
        this.mAudioBuffer = new byte[RTCAudioProfile.getFrameSize(r11)];
        this.mIsLoopExit = false;
        PthreadThreadV2 r14 = new PthreadThreadV2(this.mAudioPlayRunnable, "FastPlayerThread");
        this.mPlayThread = r14;
        ThreadMethodProxy.setPriority(r14, 10);
        ThreadMethodProxy.start(this.mPlayThread);
        this.mIsPlayStarted = true;
        this.mLogger.d(TAG, "FastPlayer start success: " + r11 + ", " + r12 + ", " + r13);
        return true;
    }
}
