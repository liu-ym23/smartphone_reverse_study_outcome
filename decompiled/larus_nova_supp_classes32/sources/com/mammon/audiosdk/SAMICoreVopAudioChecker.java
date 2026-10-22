package com.mammon.audiosdk;

import com.bytedance.speech.speechaudio.SpeechAudioLoader;
import com.mammon.audiosdk.bridge.SAMICoreBridge;
import com.mammon.audiosdk.enums.SAMICoreVopAudioCheckerResult;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerAudioMetricParameter;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerConfig;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerOnlineAsrParameter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SAMICoreVopAudioChecker {
    private static SAMICoreBridge bridge;
    private volatile long engine;

    public void destroyEngine() {
        bridge.AudioChecker_native_destroyEngine(this.engine);
    }

    static {
        SpeechAudioLoader.getInstance().load();
        bridge = SpeechAudioLoader.getInstance().createSAMICoreBridge();
    }

    public SAMICoreVopAudioChecker() {
        this.engine = bridge.AudioChecker_native_createEngine();
    }

    public int init(SAMICoreVopAudioCheckerConfig r4) {
        return bridge.AudioChecker_native_init(this.engine, r4);
    }

    public int setAudioMetricParameter(SAMICoreVopAudioCheckerAudioMetricParameter r4) {
        return bridge.AudioChecker_native_setAudioMetricParameter(this.engine, r4);
    }

    public int setOnlineAsrParameter(SAMICoreVopAudioCheckerOnlineAsrParameter r4) {
        return bridge.AudioChecker_native_setOnlineAsrParameter(this.engine, r4);
    }

    public int checkAudioQuality(byte[] r9, int r10, String r11, SAMICoreVopAudioCheckerResult[] r12) {
        int[] r0 = new int[1];
        int r13 = bridge.AudioChecker_native_checkAudioQuality(this.engine, r9, r10, r11, r0);
        r12[0] = SAMICoreVopAudioCheckerResult.values()[r0[0]];
        return r13;
    }
}
