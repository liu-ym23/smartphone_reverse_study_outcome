package com.byted.cast.render.render.audio;

import com.byted.cast.render.render.IRender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IAudioRender extends IRender {
    void config_audio_parameters(int r1, int r10, int r11);

    float getMaxVol();

    float getMinVol();

    void setVolume(float r1);
}
