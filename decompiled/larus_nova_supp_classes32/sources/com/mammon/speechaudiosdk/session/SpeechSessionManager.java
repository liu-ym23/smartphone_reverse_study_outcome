package com.mammon.speechaudiosdk.session;

import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionTaskCreateParam;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerTaskCreateParam;
import com.mammon.speechaudiosdk.session.task.SpeechHostInjectionRealtimeCallTask;
import com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask;
import com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask;
import com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTaskImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechSessionManager {
    private static final String TAG = "mammon SpeechSessionManager";

    public SpeechSessionManager() {
    }

    public SpeechRealtimeCallTask createHostInjectionRealtimeCallTask(SpeechHostInjectionTaskCreateParam r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new SpeechHostInjectionRealtimeCallTask(r2);
    }

    public SpeechRecorderAudioConsumerTask createRecorderAudioConsumerTask(SpeechRecorderAudioConsumerTaskCreateParam r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new SpeechRecorderAudioConsumerTaskImpl(r2);
    }

    public void releaseRealtimeCallTask(SpeechRealtimeCallTask r1) {
        r1.release();
    }

    public void releaseRecorderAudioConsumerTask(SpeechRecorderAudioConsumerTask r1) {
        if (r1 == null) goto L5;
        r1.release();
        return;
    }
}
