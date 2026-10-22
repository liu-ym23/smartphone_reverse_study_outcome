package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0081\u0002\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CotEventType;", BuildConfig.FLAVOR, "rawName", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawName", "()Ljava/lang/String;", "UNKNOWN", "RUN_STARTED", "RUN_FINISHED", "RUN_ERROR", "STEP_STARTED", "STEP_FINISHED", "TEXT_MESSAGE_START", "TEXT_MESSAGE_CONTENT", "TEXT_MESSAGE_END", "TEXT_MESSAGE_CHUNK", "TOOL_CALL_START", "TOOL_CALL_ARGS", "TOOL_CALL_END", "TOOL_CALL_RESULT", "TOOL_CALL_CHUNK", "STATE_SNAPSHOT", "STATE_DELTA", "MESSAGES_SNAPSHOT", "ACTIVITY_SNAPSHOT", "ACTIVITY_DELTA", "REASONING_START", "REASONING_MESSAGE_START", "REASONING_MESSAGE_CONTENT", "REASONING_MESSAGE_END", "REASONING_MESSAGE_CHUNK", "REASONING_END", "REASONING_ENCRYPTED_VALUE", "RAW", "CUSTOM", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotEventType extends Enum<CotEventType> {
    public static final CotEventType ACTIVITY_DELTA = null;
    public static final CotEventType ACTIVITY_SNAPSHOT = null;
    public static final CotEventType CUSTOM = null;
    public static final a Companion = null;
    public static final CotEventType MESSAGES_SNAPSHOT = null;
    public static final CotEventType RAW = null;
    public static final CotEventType REASONING_ENCRYPTED_VALUE = null;
    public static final CotEventType REASONING_END = null;
    public static final CotEventType REASONING_MESSAGE_CHUNK = null;
    public static final CotEventType REASONING_MESSAGE_CONTENT = null;
    public static final CotEventType REASONING_MESSAGE_END = null;
    public static final CotEventType REASONING_MESSAGE_START = null;
    public static final CotEventType REASONING_START = null;
    public static final CotEventType RUN_ERROR = null;
    public static final CotEventType RUN_FINISHED = null;
    public static final CotEventType RUN_STARTED = null;
    public static final CotEventType STATE_DELTA = null;
    public static final CotEventType STATE_SNAPSHOT = null;
    public static final CotEventType STEP_FINISHED = null;
    public static final CotEventType STEP_STARTED = null;
    public static final CotEventType TEXT_MESSAGE_CHUNK = null;
    public static final CotEventType TEXT_MESSAGE_CONTENT = null;
    public static final CotEventType TEXT_MESSAGE_END = null;
    public static final CotEventType TEXT_MESSAGE_START = null;
    public static final CotEventType TOOL_CALL_ARGS = null;
    public static final CotEventType TOOL_CALL_CHUNK = null;
    public static final CotEventType TOOL_CALL_END = null;
    public static final CotEventType TOOL_CALL_RESULT = null;
    public static final CotEventType TOOL_CALL_START = null;
    public static final CotEventType UNKNOWN = null;
    public static final /* synthetic */ CotEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String rawName;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CotEventType> getEntries() {
        return b;
    }

    static {
        CotEventType r0 = new CotEventType("UNKNOWN", 0, "UNKNOWN");
        UNKNOWN = r0;
        CotEventType r1 = new CotEventType("RUN_STARTED", 1, "RUN_STARTED");
        RUN_STARTED = r1;
        CotEventType r3 = new CotEventType("RUN_FINISHED", 2, "RUN_FINISHED");
        RUN_FINISHED = r3;
        CotEventType r5 = new CotEventType("RUN_ERROR", 3, "RUN_ERROR");
        RUN_ERROR = r5;
        CotEventType r7 = new CotEventType("STEP_STARTED", 4, "STEP_STARTED");
        STEP_STARTED = r7;
        CotEventType r9 = new CotEventType("STEP_FINISHED", 5, "STEP_FINISHED");
        STEP_FINISHED = r9;
        CotEventType r11 = new CotEventType("TEXT_MESSAGE_START", 6, "TEXT_MESSAGE_START");
        TEXT_MESSAGE_START = r11;
        CotEventType r13 = new CotEventType("TEXT_MESSAGE_CONTENT", 7, "TEXT_MESSAGE_CONTENT");
        TEXT_MESSAGE_CONTENT = r13;
        CotEventType r15 = new CotEventType("TEXT_MESSAGE_END", 8, "TEXT_MESSAGE_END");
        TEXT_MESSAGE_END = r15;
        CotEventType r14 = new CotEventType("TEXT_MESSAGE_CHUNK", 9, "TEXT_MESSAGE_CHUNK");
        TEXT_MESSAGE_CHUNK = r14;
        CotEventType r12 = new CotEventType("TOOL_CALL_START", 10, "TOOL_CALL_START");
        TOOL_CALL_START = r12;
        CotEventType r10 = new CotEventType("TOOL_CALL_ARGS", 11, "TOOL_CALL_ARGS");
        TOOL_CALL_ARGS = r10;
        CotEventType r8 = new CotEventType("TOOL_CALL_END", 12, "TOOL_CALL_END");
        TOOL_CALL_END = r8;
        CotEventType r6 = new CotEventType("TOOL_CALL_RESULT", 13, "TOOL_CALL_RESULT");
        TOOL_CALL_RESULT = r6;
        CotEventType r4 = new CotEventType("TOOL_CALL_CHUNK", 14, "TOOL_CALL_CHUNK");
        TOOL_CALL_CHUNK = r4;
        CotEventType r2 = new CotEventType("STATE_SNAPSHOT", 15, "STATE_SNAPSHOT");
        STATE_SNAPSHOT = r2;
        CotEventType r16 = new CotEventType("STATE_DELTA", 16, "STATE_DELTA");
        STATE_DELTA = r16;
        CotEventType r17 = new CotEventType("MESSAGES_SNAPSHOT", 17, "MESSAGES_SNAPSHOT");
        MESSAGES_SNAPSHOT = r17;
        CotEventType r18 = new CotEventType("ACTIVITY_SNAPSHOT", 18, "ACTIVITY_SNAPSHOT");
        ACTIVITY_SNAPSHOT = r18;
        CotEventType r19 = new CotEventType("ACTIVITY_DELTA", 19, "ACTIVITY_DELTA");
        ACTIVITY_DELTA = r19;
        CotEventType r20 = new CotEventType("REASONING_START", 20, "REASONING_START");
        REASONING_START = r20;
        CotEventType r21 = new CotEventType("REASONING_MESSAGE_START", 21, "REASONING_MESSAGE_START");
        REASONING_MESSAGE_START = r21;
        CotEventType r22 = new CotEventType("REASONING_MESSAGE_CONTENT", 22, "REASONING_MESSAGE_CONTENT");
        REASONING_MESSAGE_CONTENT = r22;
        CotEventType r23 = new CotEventType("REASONING_MESSAGE_END", 23, "REASONING_MESSAGE_END");
        REASONING_MESSAGE_END = r23;
        CotEventType r24 = new CotEventType("REASONING_MESSAGE_CHUNK", 24, "REASONING_MESSAGE_CHUNK");
        REASONING_MESSAGE_CHUNK = r24;
        CotEventType r25 = new CotEventType("REASONING_END", 25, "REASONING_END");
        REASONING_END = r25;
        CotEventType r26 = new CotEventType("REASONING_ENCRYPTED_VALUE", 26, "REASONING_ENCRYPTED_VALUE");
        REASONING_ENCRYPTED_VALUE = r26;
        CotEventType r27 = new CotEventType("RAW", 27, "RAW");
        RAW = r27;
        CotEventType r28 = new CotEventType("CUSTOM", 28, "CUSTOM");
        CUSTOM = r28;
        CotEventType[] r29 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28};
        a = r29;
        b = EnumEntriesKt.enumEntries(r29);
        Companion = new a();
    }

    public static CotEventType[] values() {
        return (CotEventType[]) a.clone();
    }

    public final String getRawName() {
        return this.rawName;
    }

    @JvmStatic
    public static final CotEventType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L49;
        if (r1 == 2) goto L77;
        if (r1 == 3) goto L76;
        if (r1 == 4) goto L75;
        if (r1 == 5) goto L74;
        if (r1 == 50) goto L73;
        if (r1 == 51) goto L72;
        switch(r1) {
            case 10: goto L54;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L51;
            default: goto L17;
        };
    L17:
        switch(r1) {
            case 20: goto L59;
            case 21: goto L58;
            case 22: goto L57;
            case 23: goto L56;
            case 24: goto L55;
            default: goto L18;
        };
    L18:
        switch(r1) {
            case 30: goto L64;
            case 31: goto L63;
            case 32: goto L62;
            case 33: goto L61;
            case 34: goto L60;
            default: goto L19;
        };
    L19:
        switch(r1) {
            case 40: goto L71;
            case 41: goto L70;
            case 42: goto L69;
            case 43: goto L68;
            case 44: goto L67;
            case 45: goto L66;
            case 46: goto L65;
            default: goto L50;
        };
    L50:
        return UNKNOWN;
    L65:
        return REASONING_ENCRYPTED_VALUE;
    L66:
        return REASONING_END;
    L67:
        return REASONING_MESSAGE_CHUNK;
    L68:
        return REASONING_MESSAGE_END;
    L69:
        return REASONING_MESSAGE_CONTENT;
    L70:
        return REASONING_MESSAGE_START;
    L71:
        return REASONING_START;
    L60:
        return ACTIVITY_DELTA;
    L61:
        return ACTIVITY_SNAPSHOT;
    L62:
        return MESSAGES_SNAPSHOT;
    L63:
        return STATE_DELTA;
    L64:
        return STATE_SNAPSHOT;
    L55:
        return TOOL_CALL_CHUNK;
    L56:
        return TOOL_CALL_RESULT;
    L57:
        return TOOL_CALL_END;
    L58:
        return TOOL_CALL_ARGS;
    L59:
        return TOOL_CALL_START;
    L51:
        return TEXT_MESSAGE_CHUNK;
    L52:
        return TEXT_MESSAGE_END;
    L53:
        return TEXT_MESSAGE_CONTENT;
    L54:
        return TEXT_MESSAGE_START;
    L72:
        return CUSTOM;
    L73:
        return RAW;
    L74:
        return STEP_FINISHED;
    L75:
        return STEP_STARTED;
    L76:
        return RUN_ERROR;
    L77:
        return RUN_FINISHED;
    L49:
        return RUN_STARTED;
    }

    public static CotEventType valueOf(String r1) {
        return (CotEventType) r27.a.a(CotEventType.class, r1);
    }

    public CotEventType(String r1, int r2, String r3) {
        super(r1, r2);
        this.rawName = r3;
    }
}
