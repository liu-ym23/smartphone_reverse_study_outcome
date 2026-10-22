package com.mammon.speechaudiosdk.session.task;

import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionUplinkParam;
import com.mammon.speechlinklayersdk.SpeechLinkLayer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface SpeechRealtimeCallTask {
    int init();

    void release();

    int sendHostInjectionUplinkData(SpeechHostInjectionUplinkParam r1);

    int setCloudWakeupIntentResult(boolean r1);

    int setLocalParam(int r1, Object r2);

    int setSpeechLinkLayer(SpeechLinkLayer r1);

    int start();

    int stop();
}
