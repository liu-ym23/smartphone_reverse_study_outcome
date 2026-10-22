package com.mammon.speechaudiosdk.session.task;

import com.mammon.speechaudiosdk.jni.SpeechNativeCore;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeRecorderAudioConsumerCallbackData;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeRecorderAudioConsumerContextParameter;
import com.mammon.speechaudiosdk.session.callback.SpeechRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerCallbackParam;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerTaskCreateParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechRecorderAudioConsumerTaskImpl implements SpeechRecorderAudioConsumerTask {
    private static final String TAG = "mammon SpeechRecorderAudioConsumerTask";
    private SpeechNativeCore nativeCore;
    private final SpeechRecorderAudioConsumerTaskCreateParam taskParam;

    public static class NativeCallbackImpl implements SpeechNativeRecorderAudioConsumerCallback {
        private final SpeechRecorderAudioConsumerCallback userCallback;

        public NativeCallbackImpl(SpeechRecorderAudioConsumerCallback r1) {
            this.userCallback = r1;
        }

        @Override // com.mammon.speechaudiosdk.jni.callback.SpeechNativeRecorderAudioConsumerCallback
        public void onCallback(int r2, String r3, SpeechNativeRecorderAudioConsumerCallbackData r4) {
            SpeechRecorderAudioConsumerCallbackParam r0 = new SpeechRecorderAudioConsumerCallbackParam();
            r0.msgType = r2;
            r0.sessionId = r3;
            if (r2 != 5000) goto L6;
            if (r4 == null) goto L6;
            r0.audioFrameTimestampMs = r4.timestampMs;
            r0.audioData = r4.audioData;
        L6:
            this.userCallback.onCallback(r0);
        }
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public int init() {
        SpeechRecorderAudioConsumerTaskCreateParam r0 = this.taskParam;
        if (r0 != null) goto L5;
        return 100001;
    L5:
        SpeechRecorderAudioConsumerCallback r1 = r0.userCallback;
        if (r1 != null) goto L8;
        return 100001;
    L8:
        NativeCallbackImpl r2 = new NativeCallbackImpl(r1);
        SpeechNativeCore r3 = new SpeechNativeCore();
        this.nativeCore = r3;
        r3.setEnableSyncInterface(true);
        this.nativeCore.setRecorderAudioConsumerCallback(r2);
        SpeechNativeRecorderAudioConsumerContextParameter r4 = new SpeechNativeRecorderAudioConsumerContextParameter();
        SpeechRecorderAudioConsumerTaskCreateParam r5 = this.taskParam;
        r4.vuiId = r5.vuiId;
        r4.sampleRate = r5.sampleRate;
        r4.channel = r5.channel;
        r4.format = r5.format;
        r4.packetDurationMs = r5.packetDurationMs;
        r4.debugPath = r5.debugPath;
        int r6 = this.nativeCore.createHandle(5, r4);
        if (r6 != 0) goto L11;
    L11:
        return r6;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public void release() {
        SpeechNativeCore r0 = this.nativeCore;
        if (r0 == null) goto L6;
        r0.destroyHandle();
        this.nativeCore = null;
        return;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public int start() {
        if (this.nativeCore != null) goto L6;
        return 100010;
    L6:
        SpeechNativeProperty r0 = new SpeechNativeProperty();
        r0.id = 1;
        r0.dataType = 0;
        return this.nativeCore.setProperty(r0);
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask
    public int stop() {
        if (this.nativeCore != null) goto L6;
        return 100010;
    L6:
        SpeechNativeProperty r0 = new SpeechNativeProperty();
        r0.id = 2;
        r0.dataType = 0;
        return this.nativeCore.setProperty(r0);
    }

    public SpeechRecorderAudioConsumerTaskImpl(SpeechRecorderAudioConsumerTaskCreateParam r1) {
        this.taskParam = r1;
    }
}
