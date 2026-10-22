package com.larus.audio.audiov3.task.tts;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsEventEnum;", "", "code", "", "massage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMassage", "()Ljava/lang/String;", "TTS_START", "TTS_END", "TTS_TASK_FAILED", "TTS_SESSION_FAILED", "TTS_FIRST_PACKAGE", "TTS_NETWORK_FAILED", "CHAT_RESPONSE", "TTS_SENTENCE_START", "TTS_SENTENCE_END", "TTS_SESSION_STARTED", "TTS_UNKNOWN_EVENT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TtsEventEnum extends Enum<TtsEventEnum> {
    public static final TtsEventEnum CHAT_RESPONSE = null;
    public static final TtsEventEnum TTS_END = null;
    public static final TtsEventEnum TTS_FIRST_PACKAGE = null;
    public static final TtsEventEnum TTS_NETWORK_FAILED = null;
    public static final TtsEventEnum TTS_SENTENCE_END = null;
    public static final TtsEventEnum TTS_SENTENCE_START = null;
    public static final TtsEventEnum TTS_SESSION_FAILED = null;
    public static final TtsEventEnum TTS_SESSION_STARTED = null;
    public static final TtsEventEnum TTS_START = null;
    public static final TtsEventEnum TTS_TASK_FAILED = null;
    public static final TtsEventEnum TTS_UNKNOWN_EVENT = null;
    public static final /* synthetic */ TtsEventEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;
    private final String massage;

    public static EnumEntries<TtsEventEnum> getEntries() {
        return b;
    }

    static {
        TtsEventEnum r0 = new TtsEventEnum("TTS_START", 0, 501, "TTS_START");
        TTS_START = r0;
        TtsEventEnum r1 = new TtsEventEnum("TTS_END", 1, 502, "TTS_END");
        TTS_END = r1;
        TtsEventEnum r2 = new TtsEventEnum("TTS_TASK_FAILED", 2, 503, "TTS_TASK_FAILED");
        TTS_TASK_FAILED = r2;
        TtsEventEnum r4 = new TtsEventEnum("TTS_SESSION_FAILED", 3, 504, "TTS_SESSION_FAILED");
        TTS_SESSION_FAILED = r4;
        TtsEventEnum r6 = new TtsEventEnum("TTS_FIRST_PACKAGE", 4, 505, "TTS_FIRST_PACKAGE");
        TTS_FIRST_PACKAGE = r6;
        TtsEventEnum r8 = new TtsEventEnum("TTS_NETWORK_FAILED", 5, 506, "TTS_NETWORK_FAILED");
        TTS_NETWORK_FAILED = r8;
        TtsEventEnum r10 = new TtsEventEnum("CHAT_RESPONSE", 6, 507, "CHAT_RESPONSE");
        CHAT_RESPONSE = r10;
        TtsEventEnum r12 = new TtsEventEnum("TTS_SENTENCE_START", 7, 508, "TTS_SENTENCE_START");
        TTS_SENTENCE_START = r12;
        TtsEventEnum r14 = new TtsEventEnum("TTS_SENTENCE_END", 8, 509, "TTS_SENTENCE_END");
        TTS_SENTENCE_END = r14;
        TtsEventEnum r13 = new TtsEventEnum("TTS_SESSION_STARTED", 9, 510, "TTS_SESSION_STARTED");
        TTS_SESSION_STARTED = r13;
        TtsEventEnum r11 = new TtsEventEnum("TTS_UNKNOWN_EVENT", 10, 10000, "TTS_UNKNOWN_EVENT");
        TTS_UNKNOWN_EVENT = r11;
        TtsEventEnum[] r9 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static TtsEventEnum[] values() {
        return (TtsEventEnum[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMassage() {
        return this.massage;
    }

    public static TtsEventEnum valueOf(String r1) {
        return (TtsEventEnum) a.a(TtsEventEnum.class, r1);
    }

    public TtsEventEnum(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.massage = r4;
    }
}
