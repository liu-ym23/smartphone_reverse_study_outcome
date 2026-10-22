package com.byted.cast.render;

import android.view.Surface;
import com.byted.cast.mediacommon.render.IAudioFrameListener;
import com.byted.cast.mediacommon.render.IMediaRender;
import com.byted.cast.mediacommon.render.IVideoFrameListener;
import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.AudioParameter;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.VideoParameter;
import com.byted.cast.render.imp.MediaRenderImp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class MediaRender implements IMediaRender {
    private MediaRenderImp imp;

    public void stopUrl() {
        this.imp.stopUrl();
    }

    public MediaRender() {
        this.imp = null;
    }

    public MediaRenderState getAudioState(int r10) {
        return this.imp.getAudioState(r10);
    }

    public Object getParameter(MediaParameter r10) {
        return this.imp.getParameter(r10);
    }

    public MediaRenderState getVideoState(int r10) {
        return this.imp.getVideoState(r10);
    }

    public void init(String r10) {
        if (this.imp != null) goto L6;
        this.imp = new MediaRenderImp(r10);
        return;
    }

    public void sendAVStream(byte[] r10) {
        this.imp.sendAVStream(r10);
    }

    public void setAudioFrameListener(IAudioFrameListener r10) {
        this.imp.setAudioFrameListener(r10);
    }

    public void setVideoFrameListener(IVideoFrameListener r10) {
        this.imp.setVideoFrameListener(r10);
    }

    public boolean startAudioPlayer(int r10) {
        return this.imp.startAudioPlayer(r10);
    }

    public boolean startVideoPlayer(int r10) {
        return this.imp.startVideoPlayer(r10);
    }

    public boolean stopAudioPlayer(int r10) {
        return this.imp.stopAudioPlayer(r10);
    }

    public boolean stopVideoPlayer(int r10) {
        return this.imp.stopVideoPlayer(r10);
    }

    public void setAudioParameter(int r10, AudioParameter r11) {
        this.imp.setAudioParameter(r10, r11);
    }

    public void setParameter(MediaParameter r10, Object r11) {
        this.imp.setParameter(r10, r11);
    }

    public void setSurface(int r10, Surface r11) {
        this.imp.setSurface(r10, r11);
    }

    public void setVideoParameter(int r10, VideoParameter r11) {
        this.imp.setVideoParameter(r10, r11);
    }

    public void startUrl(int r10, String r11) {
        this.imp.startUrl(r10, r11);
    }

    public void sendAudioPacket(int r10, byte[] r11, long r12) {
        this.imp.sendAudioPacket(r10, r11, r12);
    }

    public void sendVideoPacket(int r10, byte[] r11, long r12) {
        this.imp.sendVideoPacket(r10, r11, r12);
    }
}
