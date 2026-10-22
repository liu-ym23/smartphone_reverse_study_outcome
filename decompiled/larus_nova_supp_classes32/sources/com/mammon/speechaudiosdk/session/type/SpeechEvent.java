package com.mammon.speechaudiosdk.session.type;

import com.mammon.audiosdk.session.type.RequestEvent;
import com.mammon.audiosdk.session.type.ResponseEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechEvent {
    public static final int AUDIO_DATA = 1;
    public static final int LOCAL_EVENT_BASE = 300;
    public static final int LOCAL_EVENT_SET_LOUDNESS_PARAM = 301;
    public static final int LOCAL_EVENT_SET_LOUDNESS_RESET = 303;
    public static final int LOCAL_EVENT_SET_PLAYER_EVENT = 304;
    public static final int LOCAL_EVENT_SET_VAD_PARAM = 306;
    public static final int LOCAL_EVENT_SET_WAKEUP_PARAM = 302;
    public static final int SERVER_DOWNLINK_EVENT_ASR_ENDED = 209;
    public static final int SERVER_DOWNLINK_EVENT_ASR_INFO = 207;
    public static final int SERVER_DOWNLINK_EVENT_ASR_RESPONSE = 208;
    private static final int SERVER_DOWNLINK_EVENT_BASE = 200;
    public static final int SERVER_DOWNLINK_EVENT_BOT_TRIGGERED = 216;
    public static final int SERVER_DOWNLINK_EVENT_CHAT_ENDED = 211;
    public static final int SERVER_DOWNLINK_EVENT_CHAT_RESPONSE = 210;
    public static final int SERVER_DOWNLINK_EVENT_EVENT_REPLACE_RESULT = 234;
    public static final int SERVER_DOWNLINK_EVENT_SESSION_FAILED = 206;
    public static final int SERVER_DOWNLINK_EVENT_SESSION_FINISHED = 205;
    public static final int SERVER_DOWNLINK_EVENT_SESSION_STARTED = 204;
    public static final int SERVER_DOWNLINK_EVENT_TASK_FAILED = 203;
    public static final int SERVER_DOWNLINK_EVENT_TASK_FINISHED = 202;
    public static final int SERVER_DOWNLINK_EVENT_TASK_STARTED = 201;
    public static final int SERVER_DOWNLINK_EVENT_TTS_ENDED = 215;
    public static final int SERVER_DOWNLINK_EVENT_TTS_RESPONSE = 213;
    public static final int SERVER_DOWNLINK_EVENT_TTS_SENTENCE_END = 214;
    public static final int SERVER_DOWNLINK_EVENT_TTS_SENTENCE_START = 212;
    public static final int SERVER_DOWNLINK_EVENT_UPLINKACK = 217;
    private static final int SERVER_UPLINK_EVENT_BASE = 100;
    public static final int SERVER_UPLINK_EVENT_CANCEL_SESSION = 105;
    public static final int SERVER_UPLINK_EVENT_CLIENT_INTERRUPT = 106;
    public static final int SERVER_UPLINK_EVENT_CONTINUE_CALL = 108;
    public static final int SERVER_UPLINK_EVENT_END_ASR = 114;
    public static final int SERVER_UPLINK_EVENT_FINISH_SESSION = 104;
    public static final int SERVER_UPLINK_EVENT_FINISH_TASK = 102;
    public static final int SERVER_UPLINK_EVENT_MUTE_CALL = 112;
    public static final int SERVER_UPLINK_EVENT_PAUSE_CALL = 107;
    public static final int SERVER_UPLINK_EVENT_RETRY_REQUEST = 109;
    public static final int SERVER_UPLINK_EVENT_START_SESSION = 103;
    public static final int SERVER_UPLINK_EVENT_START_TASK = 101;
    public static final int SERVER_UPLINK_EVENT_TRIGGER_BOT = 110;
    public static final int SERVER_UPLINK_EVENT_UNMUTE_CALL = 113;
    public static final int SERVER_UPLINK_EVENT_UPDATE_UI_CONTEXT = 111;
    public static final int SPEECH_ONLY_DATA = 3;
    public static final int SPEECH_ONLY_EVENT = 2;
    public static final int UNKNOWN = 0;

    public SpeechEvent() {
    }

    public static String getEventName(int r1) {
        if (r1 != 1) goto L5;
        return "AudioData";
    L5:
        if (r1 == 234) goto L72;
        switch(r1) {
            case 101: goto L70;
            case 102: goto L68;
            case 103: goto L66;
            case 104: goto L64;
            case 105: goto L62;
            case 106: goto L60;
            case 107: goto L58;
            case 108: goto L56;
            case 109: goto L54;
            case 110: goto L52;
            case 111: goto L50;
            case 112: goto L48;
            case 113: goto L46;
            case 114: goto L44;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 201: goto L42;
            case 202: goto L40;
            case 203: goto L38;
            case 204: goto L36;
            case 205: goto L34;
            case 206: goto L32;
            case 207: goto L30;
            case 208: goto L28;
            case 209: goto L26;
            case 210: goto L24;
            case 211: goto L22;
            case 212: goto L20;
            case 213: goto L18;
            case 214: goto L16;
            case 215: goto L14;
            case 216: goto L12;
            case 217: goto L10;
            default: goto L8;
        };
    L8:
        return "unknown";
    L10:
        return "UpLinkACK";
    L12:
        return ResponseEvent.BotTriggered;
    L14:
        return ResponseEvent.TTSEnded;
    L16:
        return ResponseEvent.TTSSentenceEnd;
    L18:
        return ResponseEvent.TTSResponse;
    L20:
        return ResponseEvent.TTSSentenceStart;
    L22:
        return ResponseEvent.ChatEnded;
    L24:
        return ResponseEvent.ChatResponse;
    L26:
        return ResponseEvent.ASREnded;
    L28:
        return ResponseEvent.ASRResponse;
    L30:
        return ResponseEvent.ASRInfo;
    L32:
        return ResponseEvent.SessionFailed;
    L34:
        return ResponseEvent.SessionFinished;
    L36:
        return ResponseEvent.SessionStarted;
    L38:
        return ResponseEvent.TaskFailed;
    L40:
        return ResponseEvent.TaskFinished;
    L42:
        return ResponseEvent.TaskStarted;
    L44:
        return RequestEvent.EndASR;
    L46:
        return RequestEvent.UnmuteCall;
    L48:
        return RequestEvent.MuteCall;
    L50:
        return RequestEvent.UpdateUIContext;
    L52:
        return RequestEvent.TriggerBot;
    L54:
        return "RetryRequest";
    L56:
        return RequestEvent.ContinueCall;
    L58:
        return RequestEvent.PauseCall;
    L60:
        return RequestEvent.ClientInterrupt;
    L62:
        return RequestEvent.CancelSession;
    L64:
        return RequestEvent.FinishSession;
    L66:
        return RequestEvent.StartSession;
    L68:
        return RequestEvent.FinishTask;
    L70:
        return RequestEvent.StartTask;
    L72:
        return ResponseEvent.EventReplaceResult;
    }
}
