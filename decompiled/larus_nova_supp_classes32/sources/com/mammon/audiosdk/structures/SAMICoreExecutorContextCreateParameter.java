package com.mammon.audiosdk.structures;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SAMICoreExecutorContextCreateParameter {
    public String bussinessInfo;
    public String configInfo;
    public int maxBlockSize;
    public byte[] modelBuffer;
    public int modelLen;
    public int numChannel;
    public int numberAudioData;
    public int sampleRate;

    public SAMICoreExecutorContextCreateParameter() {
        this.numberAudioData = 1;
    }
}
