package com.mammon.audiosdk.session.task;

import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.SAMICoreHostCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.session.SpeechSessionManager;
import com.mammon.audiosdk.session.callback.ISpeechCallback;
import com.mammon.audiosdk.session.data.ASRParam;
import com.mammon.audiosdk.session.data.AudioConfig;
import com.mammon.audiosdk.session.data.AudioDataParam;
import com.mammon.audiosdk.session.data.EventDataParam;
import com.mammon.audiosdk.session.data.LoudnessStrategyParam;
import com.mammon.audiosdk.session.data.RealtimeCallTaskParam;
import com.mammon.audiosdk.session.data.SpeechReceiverCallbackParam;
import com.mammon.audiosdk.session.data.SpeechSenderCallbackParam;
import com.mammon.audiosdk.session.data.TTSParam;
import com.mammon.audiosdk.session.data.TriggerBotEventParam;
import com.mammon.audiosdk.session.type.ResponseEvent;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreTtsContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantLoudnessStrategyParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RealtimeCallTask implements ISpeechCallback {
    private static final String TAG = "mammon RealtimeCallTask";
    private RealtimeCallTaskParam mParam;
    private SAMICore mSamiCore;
    private SpeechSessionManager mSessionManager;
    private ISpeechCallback mUserCallback;

    public static class HostCallback implements SAMICoreHostCallBackListener {
        private final ISpeechCallback userCallback;

        public HostCallback(ISpeechCallback r1) {
            this.userCallback = r1;
        }

        @Override // com.mammon.audiosdk.SAMICoreHostCallBackListener
        public void onSendToHost(SAMICoreCallBackEventType r3, SAMICoreBlock r4) {
            if (r4.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L6;
            SAMICoreServerEvent r5 = (SAMICoreServerEvent) r4.audioData[0];
            SpeechSenderCallbackParam r0 = new SpeechSenderCallbackParam();
            r0.event = r5.event;
            r0.meta = r5.textMsg;
            r0.data = r5.binaryData;
            this.userCallback.onSenderCallback(r0, r4.userContext);
            return;
        }
    }

    public static class SAMICoreCallback implements SAMICoreCallBackListener {
        private final ISpeechCallback userCallback;

        public SAMICoreCallback(ISpeechCallback r1) {
            this.userCallback = r1;
        }

        public void onMessageReceived(SAMICoreCallBackEventType r3, SAMICoreBlock r4) {
            SAMICoreDataType r5 = r4.dataType;
            if (r5 != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L8;
            SAMICoreServerEvent r6 = (SAMICoreServerEvent) r4.audioData[0];
            if (this.userCallback == null) goto L13;
            SpeechReceiverCallbackParam r0 = new SpeechReceiverCallbackParam();
            r0.event = r6.event;
            r0.statusCode = r6.statusCode;
            r0.statusText = r6.statusText;
            r0.taskId = r6.taskId;
            r0.messageId = r6.messageId;
            r0.sessionId = r6.sessionId;
            r0.meta = r6.textMsg;
            r0.data = r6.binaryData;
            this.userCallback.onReceiverCallback(r0, r4.userContext);
            return;
        L13:
            return;
        L8:
            if (r5 != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event) goto L15;
            SAMICoreWebSocketConnectionEvent r7 = (SAMICoreWebSocketConnectionEvent) r4.audioData[0];
            int r8 = r7.state;
            if (r7.textMsg != null) goto L12;
            return;
        L12:
            return;
        }
    }

    private int createSAMICoreHandle() {
        SAMICoreVoiceAssistantContextCreateParameter r0 = new SAMICoreVoiceAssistantContextCreateParameter();
        r0.url = this.mSessionManager.getSessionManagerParam().url;
        r0.connectTimeout = this.mSessionManager.getSessionManagerParam().connectTimeout;
        r0.header = this.mSessionManager.getSessionManagerParam().header;
        int r1 = this.mSessionManager.getSessionManagerParam().transportType;
        if (r1 != 1) goto L5;
        r0.enableFrontier = true;
    L15:
        RealtimeCallTaskParam r2 = this.mParam;
        r0.appKey = r2.appKey;
        String r3 = r2.token;
        r0.token = r3;
        if (r3 == null) goto L18;
        r0.tokenType = SAMICoreTokenType.TOKEN_TO_B;
    L18:
        r0.taskId = r2.sessionId;
        r0.businessInfo = r2.businessInfo;
        int r4 = this.mSamiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Voice_Assistant_Online, r0);
        if (r4 != 0) goto L21;
    L21:
        return r4;
    L5:
        if (r1 != 2) goto L7;
        r0.enableHostTransport = true;
        goto L15
    L7:
        if (r1 != 3) goto L9;
        r0.enableConnectPool = true;
        goto L15
    L9:
        if (r1 != 4) goto L15;
        r0.enableConnectPool = true;
        r0.enableFrontier = true;
        goto L15
    }

    private int destroySAMICoreHandle() {
        this.mSamiCore.SAMICoreDestroyHandle();
        return 0;
    }

    private int init() {
        SAMICoreCallback r0 = new SAMICoreCallback(this.mUserCallback);
        HostCallback r1 = new HostCallback(this.mUserCallback);
        SAMICore r2 = new SAMICore();
        this.mSamiCore = r2;
        r2.setListener(r0);
        this.mSamiCore.setHostCallBackListener(r1);
        this.mSamiCore.setEnableSyncInterface(true);
        int r3 = createSAMICoreHandle();
        if (r3 == 0) goto L6;
        return r3;
    L6:
        return startNetConnect();
    }

    private int setAsrParam() {
        SAMICoreAsrContextCreateParameter r0 = new SAMICoreAsrContextCreateParameter();
        ASRParam r1 = this.mParam.asrParam;
        AudioConfig r2 = r1.audioConfig;
        r0.sampleRate = r2.sampleRate;
        r0.format = r2.format;
        r0.channel = r2.channel;
        r0.language = r1.language;
        r0.model = r1.model;
        SAMICoreProperty r3 = new SAMICoreProperty();
        r3.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Asr_Param;
        r3.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Asr_Context_Param;
        r3.dataObjectArray = new SAMICoreAsrContextCreateParameter[]{r0};
        r3.dataArrayLen = 1;
        int r4 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r3);
        if (r4 != 0) goto L5;
    L5:
        return r4;
    }

    private int setTtsParam() {
        SAMICoreTtsContextCreateParameter r0 = new SAMICoreTtsContextCreateParameter();
        TTSParam r1 = this.mParam.ttsParam;
        r0.speaker = r1.speaker;
        AudioConfig r2 = r1.audioConfig;
        r0.sampleRate = r2.sampleRate;
        r0.format = r2.format;
        SAMICoreProperty r3 = new SAMICoreProperty();
        r3.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Tts_Param;
        r3.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Tts_Context_Param;
        r3.dataObjectArray = new SAMICoreTtsContextCreateParameter[]{r0};
        r3.dataArrayLen = 1;
        int r4 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r3);
        if (r4 != 0) goto L5;
    L5:
        return r4;
    }

    private int startNetConnect() {
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.enableRealtimeVoiceCall = true;
        SAMICoreProperty r2 = new SAMICoreProperty();
        r2.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Ws_Connect;
        r2.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r2.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r2.dataArrayLen = 1;
        if (this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r2) != 0) goto L5;
    L5:
        return 0;
    }

    private int stopNetConnect() {
        SAMICoreProperty r0 = new SAMICoreProperty();
        r0.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Stop_Ws_Connect;
        r0.type = SAMICoreDataType.SAMICoreDataType_Null;
        int r1 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r0);
        if (r1 != 0) goto L5;
    L5:
        return r1;
    }

    public void release() {
        stopNetConnect();
        destroySAMICoreHandle();
        this.mUserCallback = null;
        this.mSamiCore = null;
        this.mParam = null;
        this.mSessionManager = null;
    }

    private int sendFinishSession(Object r6) {
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.taskId = this.mParam.sessionId;
        SAMICoreProperty r1 = new SAMICoreProperty();
        r1.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Finish_Session;
        r1.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r1.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r1.dataArrayLen = 1;
        r1.userContext = r6;
        int r7 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r1);
        if (r7 != 0) goto L5;
    L5:
        return r7;
    }

    private int sendFinishTask(Object r3) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        r0.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Finish_Task;
        r0.type = SAMICoreDataType.SAMICoreDataType_Null;
        r0.userContext = r3;
        int r4 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r0);
        if (r4 != 0) goto L5;
    L5:
        return r4;
    }

    private int sendStartSession(Object r6) {
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        RealtimeCallTaskParam r1 = this.mParam;
        r0.taskId = r1.sessionId;
        r0.enableAudioInput = true;
        r0.enableTextReading = true;
        r0.enableRealtimeVoiceCall = true;
        r0.requestType = 1;
        r0.interruptType = r1.interruptType;
        r0.business = r1.businessType;
        r0.chat = r1.chat;
        r0.trace = r1.trace;
        r0.sceneType = r1.sceneType;
        r0.extra = r1.extra;
        SAMICoreProperty r2 = new SAMICoreProperty();
        r2.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Session;
        r2.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r2.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r2.dataArrayLen = 1;
        r2.userContext = r6;
        int r7 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r2);
        if (r7 != 0) goto L5;
    L5:
        return r7;
    }

    private int sendStartTask(Object r3) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        r0.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Task;
        r0.type = SAMICoreDataType.SAMICoreDataType_Null;
        r0.userContext = r3;
        int r4 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r0);
        if (r4 != 0) goto L5;
    L5:
        return r4;
    }

    public int start(Object r2) {
        int r0 = sendStartTask(r2);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = setAsrParam();
        if (r1 == 0) goto L8;
        return r1;
    L8:
        int r3 = setTtsParam();
        if (r3 == 0) goto L12;
        return r3;
    L12:
        return sendStartSession(r2);
    }

    public int stop(Object r1) {
        sendFinishSession(r1);
        sendFinishTask(r1);
        return 0;
    }

    private int processSAMICoreAudioReceived(AudioDataParam r5, Object r6) {
        System.currentTimeMillis();
        SAMICoreServerEvent r0 = new SAMICoreServerEvent();
        r0.event = ResponseEvent.TTSResponse;
        r0.binaryData = r5.data;
        if (r5.payloadParam == null) goto L13;
        JSONObject r1 = new JSONObject();
        String r7 = r5.payloadParam.extra;     // Catch: JSONException -> L10
        if (r7 == null) goto L8;
        r1.put("extra", r7);     // Catch: JSONException -> L10
    L8:
        r0.textMsg = r1.toString();     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        SAMICoreProperty r8 = new SAMICoreProperty();
        r8.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Process_Server_Event;
        r8.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event;
        r8.dataObjectArray = new SAMICoreServerEvent[]{r0};
        r8.dataArrayLen = 1;
        r8.userContext = r6;
        int r9 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r8);
        if (r9 != 0) goto L16;
    L16:
        return r9;
    }

    private int processSAMICoreEventReceived(EventDataParam r5, Object r6) {
        SAMICoreServerEvent r0 = new SAMICoreServerEvent();
        r0.binaryData = r5.data;
        SAMICoreProperty r7 = new SAMICoreProperty();
        r7.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Process_Server_Event;
        r7.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event;
        r7.dataObjectArray = new SAMICoreServerEvent[]{r0};
        r7.dataArrayLen = 1;
        r7.userContext = r6;
        int r8 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r7);
        if (r8 != 0) goto L5;
    L5:
        return r8;
    }

    private int sendAudioData(AudioDataParam r5, Object r6) {
        if (r5 != null) goto L5;
        return 100001;
    L5:
        SAMICoreVoiceAssistantAudioData r0 = new SAMICoreVoiceAssistantAudioData();
        r0.taskId = this.mParam.sessionId;
        r0.data = r5.data;
        r0.refData = r5.refData;
        r0.extra = r5.payloadParam.extra;
        SAMICoreBlock r7 = new SAMICoreBlock();
        r7.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        r7.audioData = new SAMICoreVoiceAssistantAudioData[]{r0};
        r7.numberAudioData = 1;
        r7.userContext = r6;
        int r8 = this.mSamiCore.SAMICoreProcess(r7, null);
        if (r8 != 0) goto L8;
    L8:
        return r8;
    }

    private int sendSAMICoreEvent(EventDataParam r6, Object r7) {
        if (r6 != null) goto L6;
        return 100001;
    L6:
        if (r6.dataType != 201) goto L14;
        Object r8 = r6.eventParam;
        if (r8 != null) goto L10;
        return 100001;
    L10:
        LoudnessStrategyParam r9 = (LoudnessStrategyParam) r8;
        SAMICoreVoiceAssistantLoudnessStrategyParameter r10 = new SAMICoreVoiceAssistantLoudnessStrategyParameter();
        r10.metaData = r9.metaData;
        r10.loudNormAlgoType = r9.loudNormAlgoType;
        r10.deviceAiData = r9.deviceAiData;
        r10.audioDumpPath = r9.audioDumpPath;
        SAMICoreProperty r11 = new SAMICoreProperty();
        r11.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param;
        r11.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Loudness_Strategy_Param;
        r11.dataObjectArray = new SAMICoreVoiceAssistantLoudnessStrategyParameter[]{r10};
        r11.dataArrayLen = 1;
        int r12 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r11);
        if (r12 != 0) goto L13;
    L13:
        return r12;
    L14:
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.taskId = this.mParam.sessionId;
        SAMICoreProperty r1 = new SAMICoreProperty();
        r1.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r1.userContext = r7;
        switch(r6.dataType) {
            case 105: goto L21;
            case 106: goto L20;
            case 107: goto L19;
            case 108: goto L18;
            case 109: goto L17;
            default: goto L22;
        };
    L17:
        r1.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Trigger_Bot;
        r0.triggerType = ((TriggerBotEventParam) r6.eventParam).triggerBotType;
        goto L22
    L18:
        r1.id = SAMICorePropertyId.SAMICore_PropertyId_Voice_Assistant_Reconnect_Call;
        goto L22
    L19:
        r1.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Continue_Call;
        goto L22
    L20:
        r1.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Pause_Call;
        goto L22
    L21:
        r1.id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Interrupt_Call;
    L22:
        r1.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r1.dataArrayLen = 1;
        int r13 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r1);
        if (r13 != 0) goto L25;
    L25:
        return r13;
    }

    @Override // com.mammon.audiosdk.session.callback.ISpeechCallback
    public void onReceiverCallback(SpeechReceiverCallbackParam r2, Object r3) {
        ISpeechCallback r0 = this.mUserCallback;
        if (r0 == null) goto L6;
        r0.onReceiverCallback(r2, r3);
        return;
    }

    @Override // com.mammon.audiosdk.session.callback.ISpeechCallback
    public void onSenderCallback(SpeechSenderCallbackParam r2, Object r3) {
        ISpeechCallback r0 = this.mUserCallback;
        if (r0 == null) goto L6;
        r0.onSenderCallback(r2, r3);
        return;
    }

    public int processAudioReceived(AudioDataParam r1, Object r2) {
        return processSAMICoreAudioReceived(r1, r2);
    }

    public int processEventReceived(EventDataParam r1, Object r2) {
        return processSAMICoreEventReceived(r1, r2);
    }

    public int reset(RealtimeCallTaskParam r1, Object r2) {
        this.mParam = r1;
        sendFinishSession(r2);
        return sendStartSession(r2);
    }

    public int sendAudio(AudioDataParam r1, Object r2) {
        return sendAudioData(r1, r2);
    }

    public int sendEvent(EventDataParam r1, Object r2) {
        return sendSAMICoreEvent(r1, r2);
    }

    public RealtimeCallTask(RealtimeCallTaskParam r1, ISpeechCallback r2, SpeechSessionManager r3) {
        this.mUserCallback = r2;
        this.mParam = r1;
        this.mSessionManager = r3;
        init();
    }
}
