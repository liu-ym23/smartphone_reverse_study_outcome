package com.byted.cast.sdk.render.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Build;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.sdk.RTCAudioProfile;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import fna.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AudioActivePlayer {
    private static final String TAG = "AudioActivePlayer";
    private byte[] mAudioBuffer;
    private IAudioFrameReader mAudioFrameReader;
    private Runnable mAudioPlayRunnable;
    private AudioTrack mAudioTrack;
    private ContextManager.CastContext mCastContext;
    private volatile boolean mIsLoopExit;
    private volatile boolean mIsPlayStarted;
    private CastLogger mLogger;
    private Thread mPlayThread;

    public interface IAudioFrameReader {
        int readAudioFrame(byte[] r1);
    }

    public int getCurrentSampleRate() {
        AudioTrack r0 = this.mAudioTrack;
        if (r0 != null) goto L5;
        this.mLogger.w(TAG, "can not get sample rate, mAudioTrack is null!");
        return -1;
    L5:
        return r0.getSampleRate();
    }

    public void stop() {
        if (this.mIsPlayStarted == true) goto L5;
        return;
    L5:
        this.mIsLoopExit = true;
        this.mPlayThread.interrupt();     // Catch: InterruptedException -> L8
        ThreadMethodProxy.join(this.mPlayThread, 1000);     // Catch: InterruptedException -> L8
    L11:
        if (this.mAudioTrack.getPlayState() != 3) goto L13;
        INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioActivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(this.mAudioTrack);
    L13:
        this.mAudioTrack.release();
        this.mIsPlayStarted = false;
        this.mLogger.d(TAG, "AudioPlayer stop success !");
        return;
    L8:
        e = move-exception;
        this.mLogger.e(TAG, e.getMessage());
        goto L11
    }

    public boolean isStarted() {
        return this.mIsPlayStarted;
    }

    public static void INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioActivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r1) {
        if (g.d() == true) goto L6;
        r1.play();
        return;
    L6:
        r1.play();
        gna.a.c(r1.hashCode());
    }

    public static void INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioActivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(AudioTrack r1) {
        if (g.d() == true) goto L6;
        r1.stop();
        return;
    L6:
        r1.stop();
        gna.a.a(r1.hashCode());
    }

    public static /* synthetic */ boolean access$000(AudioActivePlayer r0) {
        return r0.mIsLoopExit;
    }

    public static /* synthetic */ byte[] access$100(AudioActivePlayer r0) {
        return r0.mAudioBuffer;
    }

    public static /* synthetic */ IAudioFrameReader access$200(AudioActivePlayer r0) {
        return r0.mAudioFrameReader;
    }

    private boolean playback(byte[] r10) {
        return playback(r10, 0, r10.length);
    }

    public void setOnRoutingChangedListener(AudioRouting.OnRoutingChangedListener r10) {
        AudioTrack r0 = this.mAudioTrack;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        r0.addOnRoutingChangedListener(r10, null);
        return;
    }

    public AudioActivePlayer(IAudioFrameReader r10, ContextManager.CastContext r11) {
        this.mIsLoopExit = false;
        this.mIsPlayStarted = false;
        this.mAudioPlayRunnable = new AnonymousClass1(this);
        this.mAudioFrameReader = r10;
        this.mCastContext = r11;
        this.mLogger = ContextManager.getLogger(r11);
    }

    public static /* synthetic */ boolean access$300(AudioActivePlayer r0, byte[] r1) {
        return r0.playback(r1);
    }

    private boolean playback(byte[] r10, int r11, int r12) {
        if (this.mIsPlayStarted == true) goto L7;
        this.mLogger.e(TAG, "Player not started !");
        return false;
    L7:
        if (this.mAudioTrack.write(r10, r11, r12) == r12) goto L10;
        this.mLogger.e(TAG, "Could not write all the samples to the audio device !");
    L10:
        if (this.mIsPlayStarted == false) goto L14;
        INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioActivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(this.mAudioTrack);
        return true;
    L14:
        return true;
    }

    public boolean start(int r17, int r18, int r19, int r20) {
        if (this.mIsPlayStarted == false) goto L6;
        return false;
    L6:
        if (r19 != 1) goto L8;
        int r10 = 4;
    L10:
        if (r20 != 8) goto L12;
        int r11 = 3;
    L13:
        int r13 = AudioTrack.getMinBufferSize(r18, r10, r11);
        if (r13 != (-2)) goto L18;
        this.mLogger.e(TAG, "Invalid parameter !");
        return false;
    L18:
        if (Build.VERSION.SDK_INT < 26) goto L20;
        this.mAudioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setPerformanceMode(1).setAudioFormat(new AudioFormat.Builder().setSampleRate(r18).setEncoding(r11).setChannelMask(r10).build()).setTransferMode(1).setBufferSizeInBytes(r13).build();
    L22:
        if (this.mAudioTrack.getState() != 0) goto L25;
        this.mLogger.e(TAG, "AudioTrack initialize fail !");
        return false;
    L25:
        this.mAudioBuffer = new byte[RTCAudioProfile.getFrameSize(r18)];
        this.mIsLoopExit = false;
        PthreadThreadV2 r1 = new PthreadThreadV2(this.mAudioPlayRunnable, "AudioPlayerThread");
        this.mPlayThread = r1;
        ThreadMethodProxy.setPriority(r1, 10);
        ThreadMethodProxy.start(this.mPlayThread);
        this.mIsPlayStarted = true;
        this.mLogger.d(TAG, "AudioPlayer start success: " + r18 + ", " + r19 + ", " + r20 + ", " + r13);
        return true;
    L20:
        this.mAudioTrack = new AudioTrack(r17, r18, r10, r11, r13, 1);
        goto L22
    L12:
        r11 = 2;
        goto L13
    L8:
        r10 = 12;
        goto L10
    }
}
