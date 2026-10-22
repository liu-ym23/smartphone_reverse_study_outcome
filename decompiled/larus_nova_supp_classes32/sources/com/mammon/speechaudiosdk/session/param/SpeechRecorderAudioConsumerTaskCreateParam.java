package com.mammon.speechaudiosdk.session.param;

import com.mammon.speechaudiosdk.session.callback.SpeechRecorderAudioConsumerCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechRecorderAudioConsumerTaskCreateParam {
    public int channel;
    public String debugPath;
    public String format;
    public int packetDurationMs;
    public int sampleRate;
    public SpeechRecorderAudioConsumerCallback userCallback;
    public String vuiId;

    public SpeechRecorderAudioConsumerTaskCreateParam() {
        this.sampleRate = 16000;
        this.channel = 2;
        this.format = "pcm";
        this.packetDurationMs = 20;
    }
}
