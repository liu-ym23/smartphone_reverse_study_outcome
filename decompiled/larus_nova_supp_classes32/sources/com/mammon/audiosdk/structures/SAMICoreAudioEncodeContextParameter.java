package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreAudioFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SAMICoreAudioEncodeContextParameter {
    public int bitRate;
    public int channel;
    public int complex;
    public SAMICoreAudioFormat inputFormat;
    public SAMICoreAudioFormat outputFormat;
    public String outputPath;
    public int sampleRate;

    public SAMICoreAudioEncodeContextParameter() {
    }

    public int getInputFormat() {
        return this.inputFormat.getValue();
    }

    public int getOutputFormat() {
        return this.outputFormat.getValue();
    }

    public void setInputFormat(int r1) {
        this.inputFormat = SAMICoreAudioFormat.fromInt(r1);
    }

    public void setOutputFormat(int r1) {
        this.outputFormat = SAMICoreAudioFormat.fromInt(r1);
    }
}
