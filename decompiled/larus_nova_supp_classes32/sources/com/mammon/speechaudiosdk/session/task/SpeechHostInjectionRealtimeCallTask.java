package com.mammon.speechaudiosdk.session.task;

import com.mammon.speechaudiosdk.jni.SpeechNativeCore;
import com.mammon.speechaudiosdk.jni.callback.SpeechNativeCallback;
import com.mammon.speechaudiosdk.jni.enums.SpeechNativePropertyId;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechaudiosdk.jni.structures.SpeechNativeVoiceAssistantContextParameter;
import com.mammon.speechaudiosdk.session.callback.SpeechHostInjectionCallback;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionDownlinkCallbackParam;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionTaskCreateParam;
import com.mammon.speechaudiosdk.session.param.SpeechHostInjectionUplinkParam;
import com.mammon.speechaudiosdk.session.param.SpeechVoiceAssistantWakeupIntentResult;
import com.mammon.speechlinklayersdk.SpeechLinkLayer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechHostInjectionRealtimeCallTask implements SpeechRealtimeCallTask {
    private static final String TAG = "mammon SpeechInjectionRealtimeCallTask";
    private SpeechNativeCore nativeCore;
    private SpeechLinkLayer speechLinkLayer;
    private final SpeechHostInjectionTaskCreateParam taskParam;

    public static class SpeechNativeCallbackImpl implements SpeechNativeCallback {
        private final SpeechHostInjectionCallback userCallback;

        public SpeechNativeCallbackImpl(SpeechHostInjectionCallback r1) {
            this.userCallback = r1;
        }

        @Override // com.mammon.speechaudiosdk.jni.callback.SpeechNativeCallback
        public void onDownlinkCallback(SpeechHostInjectionDownlinkCallbackParam r2) {
            this.userCallback.onDownlinkCallback(r2);
        }
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int start() {
        return 0;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int stop() {
        return 0;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int init() {
        SpeechHostInjectionTaskCreateParam r0 = this.taskParam;
        if (r0 != null) goto L5;
        return 100001;
    L5:
        SpeechHostInjectionCallback r1 = r0.userCallback;
        if (r1 != null) goto L8;
        return 100001;
    L8:
        SpeechNativeCallbackImpl r2 = new SpeechNativeCallbackImpl(r1);
        SpeechNativeCore r3 = new SpeechNativeCore();
        this.nativeCore = r3;
        r3.setEnableSyncInterface(true);
        this.nativeCore.setSpeechNativeCallback(r2);
        this.nativeCore.setSessionEventCallback(this.taskParam.sessionEventCallback);
        SpeechNativeVoiceAssistantContextParameter r4 = new SpeechNativeVoiceAssistantContextParameter();
        r4.transportType = 2;
        SpeechHostInjectionTaskCreateParam r5 = this.taskParam;
        r4.businessInfo = r5.businessInfo;
        r4.dumpPath = r5.dumpPath;
        int r6 = this.nativeCore.createHandle(1, r4);
        if (r6 != 0) goto L11;
    L11:
        return r6;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public void release() {
        SpeechNativeCore r0 = this.nativeCore;
        if (r0 == null) goto L6;
        r0.destroyHandle();
        return;
    }

    public SpeechHostInjectionRealtimeCallTask(SpeechHostInjectionTaskCreateParam r1) {
        this.taskParam = r1;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int sendHostInjectionUplinkData(SpeechHostInjectionUplinkParam r3) {
        SpeechNativeProperty r0 = new SpeechNativeProperty();
        r0.id = 1001;
        r0.data = r3;
        r0.dataType = 100;
        return this.nativeCore.setProperty(r0);
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int setCloudWakeupIntentResult(boolean r3) {
        SpeechVoiceAssistantWakeupIntentResult r0 = new SpeechVoiceAssistantWakeupIntentResult();
        r0.result = r3;
        SpeechNativeProperty r4 = new SpeechNativeProperty();
        r4.id = SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_WAKEUP_INTENT_RESULT;
        r4.dataType = 105;
        r4.data = r0;
        return this.nativeCore.setProperty(r4);
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int setSpeechLinkLayer(SpeechLinkLayer r4) {
        this.speechLinkLayer = r4;
        SpeechNativeProperty r0 = new SpeechNativeProperty();
        r0.id = 1003;
        r0.dataType = 4;
        r0.data = Long.valueOf(r4.getNativeHandle());
        int r5 = this.nativeCore.setProperty(r0);
        if (r5 != 0) goto L5;
    L5:
        return r5;
    }

    @Override // com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask
    public int setLocalParam(int r2, Object r3) {
        SpeechNativeProperty r0 = new SpeechNativeProperty();
        r0.data = r3;
        switch(r2) {
            case 301: goto L10;
            case 302: goto L9;
            case 303: goto L8;
            case 304: goto L7;
            case 305: goto L4;
            case 306: goto L6;
            default: goto L4;
        };
    L4:
        return 100002;
    L6:
        r0.id = SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_VAD_PARAM;
        r0.dataType = 5;
    L12:
        return this.nativeCore.setProperty(r0);
    L7:
        r0.id = SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_PLAYER_EVENT;
        r0.dataType = 104;
        goto L12
    L8:
        r0.id = SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_LOUDNESS_RESET;
        r0.dataType = 1;
        goto L12
    L9:
        r0.id = SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_WAKEUP_PARAM;
        r0.dataType = 103;
        goto L12
    L10:
        r0.id = SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_LOUDNESS_PARAM;
        r0.dataType = 102;
        goto L12
    }
}
