package com.mammon.audiosdk.session;

import com.mammon.audiosdk.session.callback.ISpeechCallback;
import com.mammon.audiosdk.session.data.RealtimeCallTaskParam;
import com.mammon.audiosdk.session.data.SpeechSessionManagerParam;
import com.mammon.audiosdk.session.task.RealtimeCallTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechSessionManager {
    private static final String TAG = "mammon SpeechSessionManager";
    private final SpeechSessionManagerParam mParam;

    public SpeechSessionManagerParam getSessionManagerParam() {
        return this.mParam;
    }

    public SpeechSessionManager(SpeechSessionManagerParam r1) {
        this.mParam = r1;
    }

    public void releaseRealtimeCallTask(RealtimeCallTask r1) {
        r1.release();
    }

    public RealtimeCallTask createRealtimeCallTask(RealtimeCallTaskParam r2, ISpeechCallback r3) {
        return new RealtimeCallTask(r2, r3, this);
    }
}
