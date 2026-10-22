package com.obric.assistant.state.api.v2.core.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b*\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u0006+"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "DEEP_THINK_START", "DEEP_THINK_END", "TTS_PLAYING", "TTS_END", "REALTIME_CALL_END", "REALTIME_CALL_INVALID", "REALTIME_CALL_UNINITIALIZED", "REALTIME_CALL_CONNECTING", "REALTIME_CALL_WAITING", "REALTIME_CALL_LISTENING", "REALTIME_CALL_THINKING", "REALTIME_CALL_SPEAKING", "REALTIME_CALL_NETWORK_ERROR", "REALTIME_CALL_PAUSED", "REALTIME_CALL_RESUME", "REALTIME_CALL_WAITING_HELLO", "REALTIME_CALL_LOADING", "REALTIME_CALL_PENDING", "REALTIME_CALL_SCENE_MODE_CHANGE", "REALTIME_CALL_DORA_STOP", "REALTIME_CALL_MUTE", "REALTIME_CALL_UN_MUTE", "REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY", "COMPLEX_TASK_THINK_START", "COMPLEX_TASK_THINK_END", "COMPLEX_TASK_ASK_USER", "COMPLEX_TASK_CALL_USER", "COMPLEX_TASK_TAKING_OVER", "COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN", "COMPLEX_TASK_RECEIVE_USER_CLARIFY", "COMPLEX_TASK_COMPLETED", "COMPLEX_TASK_INTERRUPTED", "CLICK_TALK_START", "CLICK_TALK_END", "CLICK_TALK_ASR_START", "CLICK_TALK_ASR_END", "MSG_START", "MSG_END", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricIslandStateType extends Enum<ObricIslandStateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricIslandStateType[] $VALUES = null;
    public static final ObricIslandStateType CLICK_TALK_ASR_END = null;
    public static final ObricIslandStateType CLICK_TALK_ASR_START = null;
    public static final ObricIslandStateType CLICK_TALK_END = null;
    public static final ObricIslandStateType CLICK_TALK_START = null;
    public static final ObricIslandStateType COMPLEX_TASK_ASK_USER = null;
    public static final ObricIslandStateType COMPLEX_TASK_CALL_USER = null;
    public static final ObricIslandStateType COMPLEX_TASK_COMPLETED = null;
    public static final ObricIslandStateType COMPLEX_TASK_INTERRUPTED = null;
    public static final ObricIslandStateType COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN = null;
    public static final ObricIslandStateType COMPLEX_TASK_RECEIVE_USER_CLARIFY = null;
    public static final ObricIslandStateType COMPLEX_TASK_TAKING_OVER = null;
    public static final ObricIslandStateType COMPLEX_TASK_THINK_END = null;
    public static final ObricIslandStateType COMPLEX_TASK_THINK_START = null;
    public static final ObricIslandStateType DEEP_THINK_END = null;
    public static final ObricIslandStateType DEEP_THINK_START = null;
    public static final ObricIslandStateType IDLE = null;
    public static final ObricIslandStateType MSG_END = null;
    public static final ObricIslandStateType MSG_START = null;
    public static final ObricIslandStateType REALTIME_CALL_CONNECTING = null;
    public static final ObricIslandStateType REALTIME_CALL_DORA_STOP = null;
    public static final ObricIslandStateType REALTIME_CALL_END = null;
    public static final ObricIslandStateType REALTIME_CALL_INVALID = null;
    public static final ObricIslandStateType REALTIME_CALL_LISTENING = null;
    public static final ObricIslandStateType REALTIME_CALL_LOADING = null;
    public static final ObricIslandStateType REALTIME_CALL_MUTE = null;
    public static final ObricIslandStateType REALTIME_CALL_NETWORK_ERROR = null;
    public static final ObricIslandStateType REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY = null;
    public static final ObricIslandStateType REALTIME_CALL_PAUSED = null;
    public static final ObricIslandStateType REALTIME_CALL_PENDING = null;
    public static final ObricIslandStateType REALTIME_CALL_RESUME = null;
    public static final ObricIslandStateType REALTIME_CALL_SCENE_MODE_CHANGE = null;
    public static final ObricIslandStateType REALTIME_CALL_SPEAKING = null;
    public static final ObricIslandStateType REALTIME_CALL_THINKING = null;
    public static final ObricIslandStateType REALTIME_CALL_UNINITIALIZED = null;
    public static final ObricIslandStateType REALTIME_CALL_UN_MUTE = null;
    public static final ObricIslandStateType REALTIME_CALL_WAITING = null;
    public static final ObricIslandStateType REALTIME_CALL_WAITING_HELLO = null;
    public static final ObricIslandStateType TTS_END = null;
    public static final ObricIslandStateType TTS_PLAYING = null;

    private static final /* synthetic */ ObricIslandStateType[] $values() {
        return new ObricIslandStateType[]{IDLE, DEEP_THINK_START, DEEP_THINK_END, TTS_PLAYING, TTS_END, REALTIME_CALL_END, REALTIME_CALL_INVALID, REALTIME_CALL_UNINITIALIZED, REALTIME_CALL_CONNECTING, REALTIME_CALL_WAITING, REALTIME_CALL_LISTENING, REALTIME_CALL_THINKING, REALTIME_CALL_SPEAKING, REALTIME_CALL_NETWORK_ERROR, REALTIME_CALL_PAUSED, REALTIME_CALL_RESUME, REALTIME_CALL_WAITING_HELLO, REALTIME_CALL_LOADING, REALTIME_CALL_PENDING, REALTIME_CALL_SCENE_MODE_CHANGE, REALTIME_CALL_DORA_STOP, REALTIME_CALL_MUTE, REALTIME_CALL_UN_MUTE, REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY, COMPLEX_TASK_THINK_START, COMPLEX_TASK_THINK_END, COMPLEX_TASK_ASK_USER, COMPLEX_TASK_CALL_USER, COMPLEX_TASK_TAKING_OVER, COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN, COMPLEX_TASK_RECEIVE_USER_CLARIFY, COMPLEX_TASK_COMPLETED, COMPLEX_TASK_INTERRUPTED, CLICK_TALK_START, CLICK_TALK_END, CLICK_TALK_ASR_START, CLICK_TALK_ASR_END, MSG_START, MSG_END};
    }

    public static EnumEntries<ObricIslandStateType> getEntries() {
        return $ENTRIES;
    }

    static {
        IDLE = new ObricIslandStateType("IDLE", 0);
        DEEP_THINK_START = new ObricIslandStateType("DEEP_THINK_START", 1);
        DEEP_THINK_END = new ObricIslandStateType("DEEP_THINK_END", 2);
        TTS_PLAYING = new ObricIslandStateType("TTS_PLAYING", 3);
        TTS_END = new ObricIslandStateType("TTS_END", 4);
        REALTIME_CALL_END = new ObricIslandStateType("REALTIME_CALL_END", 5);
        REALTIME_CALL_INVALID = new ObricIslandStateType("REALTIME_CALL_INVALID", 6);
        REALTIME_CALL_UNINITIALIZED = new ObricIslandStateType("REALTIME_CALL_UNINITIALIZED", 7);
        REALTIME_CALL_CONNECTING = new ObricIslandStateType("REALTIME_CALL_CONNECTING", 8);
        REALTIME_CALL_WAITING = new ObricIslandStateType("REALTIME_CALL_WAITING", 9);
        REALTIME_CALL_LISTENING = new ObricIslandStateType("REALTIME_CALL_LISTENING", 10);
        REALTIME_CALL_THINKING = new ObricIslandStateType("REALTIME_CALL_THINKING", 11);
        REALTIME_CALL_SPEAKING = new ObricIslandStateType("REALTIME_CALL_SPEAKING", 12);
        REALTIME_CALL_NETWORK_ERROR = new ObricIslandStateType("REALTIME_CALL_NETWORK_ERROR", 13);
        REALTIME_CALL_PAUSED = new ObricIslandStateType("REALTIME_CALL_PAUSED", 14);
        REALTIME_CALL_RESUME = new ObricIslandStateType("REALTIME_CALL_RESUME", 15);
        REALTIME_CALL_WAITING_HELLO = new ObricIslandStateType("REALTIME_CALL_WAITING_HELLO", 16);
        REALTIME_CALL_LOADING = new ObricIslandStateType("REALTIME_CALL_LOADING", 17);
        REALTIME_CALL_PENDING = new ObricIslandStateType("REALTIME_CALL_PENDING", 18);
        REALTIME_CALL_SCENE_MODE_CHANGE = new ObricIslandStateType("REALTIME_CALL_SCENE_MODE_CHANGE", 19);
        REALTIME_CALL_DORA_STOP = new ObricIslandStateType("REALTIME_CALL_DORA_STOP", 20);
        REALTIME_CALL_MUTE = new ObricIslandStateType("REALTIME_CALL_MUTE", 21);
        REALTIME_CALL_UN_MUTE = new ObricIslandStateType("REALTIME_CALL_UN_MUTE", 22);
        REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY = new ObricIslandStateType("REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY", 23);
        COMPLEX_TASK_THINK_START = new ObricIslandStateType("COMPLEX_TASK_THINK_START", 24);
        COMPLEX_TASK_THINK_END = new ObricIslandStateType("COMPLEX_TASK_THINK_END", 25);
        COMPLEX_TASK_ASK_USER = new ObricIslandStateType("COMPLEX_TASK_ASK_USER", 26);
        COMPLEX_TASK_CALL_USER = new ObricIslandStateType("COMPLEX_TASK_CALL_USER", 27);
        COMPLEX_TASK_TAKING_OVER = new ObricIslandStateType("COMPLEX_TASK_TAKING_OVER", 28);
        COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN = new ObricIslandStateType("COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN", 29);
        COMPLEX_TASK_RECEIVE_USER_CLARIFY = new ObricIslandStateType("COMPLEX_TASK_RECEIVE_USER_CLARIFY", 30);
        COMPLEX_TASK_COMPLETED = new ObricIslandStateType("COMPLEX_TASK_COMPLETED", 31);
        COMPLEX_TASK_INTERRUPTED = new ObricIslandStateType("COMPLEX_TASK_INTERRUPTED", 32);
        CLICK_TALK_START = new ObricIslandStateType("CLICK_TALK_START", 33);
        CLICK_TALK_END = new ObricIslandStateType("CLICK_TALK_END", 34);
        CLICK_TALK_ASR_START = new ObricIslandStateType("CLICK_TALK_ASR_START", 35);
        CLICK_TALK_ASR_END = new ObricIslandStateType("CLICK_TALK_ASR_END", 36);
        MSG_START = new ObricIslandStateType("MSG_START", 37);
        MSG_END = new ObricIslandStateType("MSG_END", 38);
        ObricIslandStateType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ObricIslandStateType[] values() {
        return (ObricIslandStateType[]) $VALUES.clone();
    }

    public static ObricIslandStateType valueOf(String r1) {
        return (ObricIslandStateType) a.a(ObricIslandStateType.class, r1);
    }

    private ObricIslandStateType(String r1, int r2) {
        super(r1, r2);
    }
}
