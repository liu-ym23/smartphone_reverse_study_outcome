package com.byted.cast.render.render.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Build;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.MediaRenderErrorCode;
import com.byted.cast.render.utils.Logger;
import fna.g;
import gna.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AudioTrackRender implements IAudioRender {
    private static final String TAG = "AudioTrackRender";
    private AudioTrack audioTrack;
    private int bitWidth;
    private int channels;
    private float gain;
    private final float max_vol;
    private final float min_vol;
    private AudioRouting.OnRoutingChangedListener routingChangedListener;
    private int sampleRate;
    private int streamType;
    private final String userId;

    @Override // com.byted.cast.render.render.IRender
    public boolean start() {
        Logger.i(TAG, "AudioTrackRender start");
        if (this.audioTrack == null) goto L7;
        Logger.w(TAG, "Render started");
        return false;
    L7:
        if (this.channels != 1) goto L9;
        int r10 = 4;
    L11:
        if (this.bitWidth != 8) goto L13;
        int r11 = 3;
    L14:
        int r12 = AudioTrack.getMinBufferSize(this.sampleRate, r10, r11);
        if (r12 != (-2)) goto L44;
        Logger.e(TAG, "Invalid parameter !");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "Invalid parameter");
        return false;
    L44:
        int r0 = Build.VERSION.SDK_INT;     // Catch: Exception -> L41
        if (r0 < 26) goto L22;
        this.audioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setPerformanceMode(1).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.sampleRate).setEncoding(r11).setChannelMask(r10).build()).setTransferMode(1).setBufferSizeInBytes(r12).build();     // Catch: Exception -> L41
    L26:
        if (this.audioTrack.getState() == 1) goto L29;
        Logger.e(TAG, "audioTrack init failed");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "audioTrack init failed");
        return false;
    L29:
        AudioTrack r13 = this.audioTrack;
        if (r13 != null) goto L32;
    L45:
        AudioTrack r1 = this.audioTrack;     // Catch: IllegalStateException -> L38
        if (r1 == null) goto L37;
        INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(r1);     // Catch: IllegalStateException -> L38
    L37:
        return true;
    L38:
        e = move-exception;
        e.printStackTrace();
        Logger.e(TAG, "audioTrack play failed");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "audioTrack play failed");
        return false;
    L32:
        if (r0 < 24) goto L45;
        r13.addOnRoutingChangedListener(this.routingChangedListener, null);
        goto L45
    L22:
        if (r0 < 23) goto L24;
        this.audioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.sampleRate).setEncoding(r11).setChannelMask(r10).build()).setTransferMode(1).setBufferSizeInBytes(r12).build();     // Catch: Exception -> L41
        goto L26
    L24:
        this.audioTrack = new AudioTrack(this.streamType, this.sampleRate, r10, r11, r12, 1);     // Catch: Exception -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
        Logger.e(TAG, "audioTrack build failed");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "audioTrack build failed");
        return false;
    L13:
        r11 = 2;
        goto L14
    L9:
        r10 = 12;
        goto L11
    }

    @Override // com.byted.cast.render.render.IRender
    public boolean stop() {
        Logger.i(TAG, "AudioTrackRender stop");
        AudioTrack r0 = this.audioTrack;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getState() != 1) goto L9;
        Logger.w(TAG, "render is stopped");
        return false;
    L9:
        this.audioTrack.flush();
        INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(this.audioTrack);
        this.audioTrack.release();
        this.audioTrack = null;
        return true;
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public float getMaxVol() {
        return this.max_vol;
    }

    public float getMaxVolume() {
        return this.max_vol;
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public float getMinVol() {
        return this.min_vol;
    }

    public float getMinVolume() {
        return this.min_vol;
    }

    public AudioTrackRender(String r10) {
        this.audioTrack = null;
        this.channels = 2;
        this.sampleRate = 48000;
        this.bitWidth = 16;
        this.gain = 1.0f;
        this.streamType = 3;
        this.max_vol = AudioTrack.getMaxVolume();
        this.min_vol = AudioTrack.getMinVolume();
        this.userId = r10;
    }

    public static void INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r1) {
        if (g.d() == true) goto L6;
        r1.play();
        return;
    L6:
        r1.play();
        a.c(r1.hashCode());
    }

    public static void INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(AudioTrack r1) {
        if (g.d() == true) goto L6;
        r1.stop();
        return;
    L6:
        r1.stop();
        a.a(r1.hashCode());
    }

    @Override // com.byted.cast.render.render.IRender
    public Object getParameter(MediaParameter r10) {
        if (r10 != MediaParameter.Audio_Render_SessionId) goto L9;
        AudioTrack r11 = this.audioTrack;
        if (r11 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r11.getAudioSessionId());
    L9:
        if (r10 == MediaParameter.Audio_Render_volume) goto L11;
        Logger.e(TAG, "setParameter failed, key not found");
        return null;
    L11:
        return Float.valueOf(this.gain);
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public void setVolume(float r10) {
        float r0 = this.max_vol;
        if (r10 <= r0) goto L5;
    L4:
        r10 = r0;
    L8:
        this.gain = r10;
        AudioTrack r1 = this.audioTrack;
        if (r1 == null) goto L12;
        r1.setVolume(r10);
        Logger.i(TAG, "AudioTrack setVolume: " + r10);
        return;
    L12:
        return;
    L5:
        r0 = this.min_vol;
        if (r10 >= r0) goto L8;
        goto L8
    }

    @Override // com.byted.cast.render.render.IRender
    public void render(byte[] r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        AudioTrack r0 = this.audioTrack;
        if (r0 == null) goto L8;
        r0.write(r10, 0, r11);
        return;
    }

    @Override // com.byted.cast.render.render.IRender
    public void setParameter(MediaParameter r10, Object r11) {
        if (r10 == MediaParameter.Audio_Render_routingChangedListener) goto L5;
        Logger.e(TAG, "[AudioTrackRender]: setParameter key not found! key: " + r10);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        this.routingChangedListener = (AudioRouting.OnRoutingChangedListener) r11;
        return;
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public void config_audio_parameters(int r1, int r10, int r11) {
        this.sampleRate = r1;
        this.channels = r10;
        this.bitWidth = r11;
    }
}
