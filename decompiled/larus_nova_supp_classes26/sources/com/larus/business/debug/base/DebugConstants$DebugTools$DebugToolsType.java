package com.larus.business.debug.base;

import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u0006+"}, d2 = {"Lcom/larus/business/debug/base/DebugConstants$DebugTools$DebugToolsType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "USER_INFO_COPY", "OLYMPUS_ACCOUNT", "SAMI_PPE", "UPLOAD_LOG", "SET_PPE_BOE", "SET_SCHEDULE_VDC", "SET_REQUEST_PARAMS", "SET_FRONTIER", "CALIDGE", "ANYDOOR", "REAL_TIME_CALL_DEBUG", "DORA_MAIN_BOT", "DORA_VAD", "CHAT_COMFORT_DEBUG", "DORA_AUDIO_DUMP_SWITCH", "OPEN_URL", "GECKO_DEBUG", "STREAM_DEBUG", "MARKDOWN_DEBUG", "LYNX_SCHEMA_DEBUG", "HYBRID_DEV", "LOGIN_DEV", SuggestPromptErrorType.ERROR_TYPE_CRASH, "UI", "KEVA_EDITOR", "SP_DEBUG", "LIBRA", "WASTE", "ADVANCED_WHITE", "NEW_USER_MODE", "SETTINGS", "EVENT_MOB", "CHANGE_PAGE", "SEARCH", "FAVORITE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DebugConstants$DebugTools$DebugToolsType extends Enum<DebugConstants$DebugTools$DebugToolsType> {
    public static final DebugConstants$DebugTools$DebugToolsType ADVANCED_WHITE = null;
    public static final DebugConstants$DebugTools$DebugToolsType ANYDOOR = null;
    public static final DebugConstants$DebugTools$DebugToolsType CALIDGE = null;
    public static final DebugConstants$DebugTools$DebugToolsType CHANGE_PAGE = null;
    public static final DebugConstants$DebugTools$DebugToolsType CHAT_COMFORT_DEBUG = null;
    public static final DebugConstants$DebugTools$DebugToolsType CRASH = null;
    public static final DebugConstants$DebugTools$DebugToolsType DORA_AUDIO_DUMP_SWITCH = null;
    public static final DebugConstants$DebugTools$DebugToolsType DORA_MAIN_BOT = null;
    public static final DebugConstants$DebugTools$DebugToolsType DORA_VAD = null;
    public static final DebugConstants$DebugTools$DebugToolsType EVENT_MOB = null;
    public static final DebugConstants$DebugTools$DebugToolsType FAVORITE = null;
    public static final DebugConstants$DebugTools$DebugToolsType GECKO_DEBUG = null;
    public static final DebugConstants$DebugTools$DebugToolsType HYBRID_DEV = null;
    public static final DebugConstants$DebugTools$DebugToolsType KEVA_EDITOR = null;
    public static final DebugConstants$DebugTools$DebugToolsType LIBRA = null;
    public static final DebugConstants$DebugTools$DebugToolsType LOGIN_DEV = null;
    public static final DebugConstants$DebugTools$DebugToolsType LYNX_SCHEMA_DEBUG = null;
    public static final DebugConstants$DebugTools$DebugToolsType MARKDOWN_DEBUG = null;
    public static final DebugConstants$DebugTools$DebugToolsType NEW_USER_MODE = null;
    public static final DebugConstants$DebugTools$DebugToolsType OLYMPUS_ACCOUNT = null;
    public static final DebugConstants$DebugTools$DebugToolsType OPEN_URL = null;
    public static final DebugConstants$DebugTools$DebugToolsType REAL_TIME_CALL_DEBUG = null;
    public static final DebugConstants$DebugTools$DebugToolsType SAMI_PPE = null;
    public static final DebugConstants$DebugTools$DebugToolsType SEARCH = null;
    public static final DebugConstants$DebugTools$DebugToolsType SETTINGS = null;
    public static final DebugConstants$DebugTools$DebugToolsType SET_FRONTIER = null;
    public static final DebugConstants$DebugTools$DebugToolsType SET_PPE_BOE = null;
    public static final DebugConstants$DebugTools$DebugToolsType SET_REQUEST_PARAMS = null;
    public static final DebugConstants$DebugTools$DebugToolsType SET_SCHEDULE_VDC = null;
    public static final DebugConstants$DebugTools$DebugToolsType SP_DEBUG = null;
    public static final DebugConstants$DebugTools$DebugToolsType STREAM_DEBUG = null;
    public static final DebugConstants$DebugTools$DebugToolsType UI = null;
    public static final DebugConstants$DebugTools$DebugToolsType UPLOAD_LOG = null;
    public static final DebugConstants$DebugTools$DebugToolsType USER_INFO_COPY = null;
    public static final DebugConstants$DebugTools$DebugToolsType WASTE = null;
    public static final /* synthetic */ DebugConstants$DebugTools$DebugToolsType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<DebugConstants$DebugTools$DebugToolsType> getEntries() {
        return b;
    }

    static {
        DebugConstants$DebugTools$DebugToolsType r0 = new DebugConstants$DebugTools$DebugToolsType("USER_INFO_COPY", 0, "user_info_copy");
        USER_INFO_COPY = r0;
        DebugConstants$DebugTools$DebugToolsType r1 = new DebugConstants$DebugTools$DebugToolsType("OLYMPUS_ACCOUNT", 1, "olympus_account");
        OLYMPUS_ACCOUNT = r1;
        DebugConstants$DebugTools$DebugToolsType r2 = new DebugConstants$DebugTools$DebugToolsType("SAMI_PPE", 2, "sami_ppe");
        SAMI_PPE = r2;
        DebugConstants$DebugTools$DebugToolsType r4 = new DebugConstants$DebugTools$DebugToolsType("UPLOAD_LOG", 3, "upload_log");
        UPLOAD_LOG = r4;
        DebugConstants$DebugTools$DebugToolsType r6 = new DebugConstants$DebugTools$DebugToolsType("SET_PPE_BOE", 4, "set_ppe_boe");
        SET_PPE_BOE = r6;
        DebugConstants$DebugTools$DebugToolsType r8 = new DebugConstants$DebugTools$DebugToolsType("SET_SCHEDULE_VDC", 5, "set_schedule_vdc");
        SET_SCHEDULE_VDC = r8;
        DebugConstants$DebugTools$DebugToolsType r10 = new DebugConstants$DebugTools$DebugToolsType("SET_REQUEST_PARAMS", 6, "set_request_params");
        SET_REQUEST_PARAMS = r10;
        DebugConstants$DebugTools$DebugToolsType r12 = new DebugConstants$DebugTools$DebugToolsType("SET_FRONTIER", 7, "set_frontier");
        SET_FRONTIER = r12;
        DebugConstants$DebugTools$DebugToolsType r14 = new DebugConstants$DebugTools$DebugToolsType("CALIDGE", 8, "calidge");
        CALIDGE = r14;
        DebugConstants$DebugTools$DebugToolsType r13 = new DebugConstants$DebugTools$DebugToolsType("ANYDOOR", 9, "anydoor");
        ANYDOOR = r13;
        DebugConstants$DebugTools$DebugToolsType r11 = new DebugConstants$DebugTools$DebugToolsType("REAL_TIME_CALL_DEBUG", 10, "real_time_call_debug");
        REAL_TIME_CALL_DEBUG = r11;
        DebugConstants$DebugTools$DebugToolsType r9 = new DebugConstants$DebugTools$DebugToolsType("DORA_MAIN_BOT", 11, "dora_main_bot");
        DORA_MAIN_BOT = r9;
        DebugConstants$DebugTools$DebugToolsType r7 = new DebugConstants$DebugTools$DebugToolsType("DORA_VAD", 12, "dora_vad");
        DORA_VAD = r7;
        DebugConstants$DebugTools$DebugToolsType r5 = new DebugConstants$DebugTools$DebugToolsType("CHAT_COMFORT_DEBUG", 13, "chat_comfort_enable");
        CHAT_COMFORT_DEBUG = r5;
        DebugConstants$DebugTools$DebugToolsType r3 = new DebugConstants$DebugTools$DebugToolsType("DORA_AUDIO_DUMP_SWITCH", 14, "dora_audio_dump_switch");
        DORA_AUDIO_DUMP_SWITCH = r3;
        DebugConstants$DebugTools$DebugToolsType r15 = new DebugConstants$DebugTools$DebugToolsType("OPEN_URL", 15, "open_url");
        OPEN_URL = r15;
        DebugConstants$DebugTools$DebugToolsType r16 = new DebugConstants$DebugTools$DebugToolsType("GECKO_DEBUG", 16, "gecko_debug");
        GECKO_DEBUG = r16;
        DebugConstants$DebugTools$DebugToolsType r17 = new DebugConstants$DebugTools$DebugToolsType("STREAM_DEBUG", 17, "stream_debug");
        STREAM_DEBUG = r17;
        DebugConstants$DebugTools$DebugToolsType r18 = new DebugConstants$DebugTools$DebugToolsType("MARKDOWN_DEBUG", 18, "markdown_debug");
        MARKDOWN_DEBUG = r18;
        DebugConstants$DebugTools$DebugToolsType r19 = new DebugConstants$DebugTools$DebugToolsType("LYNX_SCHEMA_DEBUG", 19, "lynx_schema_debug");
        LYNX_SCHEMA_DEBUG = r19;
        DebugConstants$DebugTools$DebugToolsType r20 = new DebugConstants$DebugTools$DebugToolsType("HYBRID_DEV", 20, "hybrid_dev");
        HYBRID_DEV = r20;
        DebugConstants$DebugTools$DebugToolsType r21 = new DebugConstants$DebugTools$DebugToolsType("LOGIN_DEV", 21, "login_dev");
        LOGIN_DEV = r21;
        DebugConstants$DebugTools$DebugToolsType r22 = new DebugConstants$DebugTools$DebugToolsType(SuggestPromptErrorType.ERROR_TYPE_CRASH, 22, "crash");
        CRASH = r22;
        DebugConstants$DebugTools$DebugToolsType r23 = new DebugConstants$DebugTools$DebugToolsType("UI", 23, "ui");
        UI = r23;
        DebugConstants$DebugTools$DebugToolsType r24 = new DebugConstants$DebugTools$DebugToolsType("KEVA_EDITOR", 24, "keva_editor");
        KEVA_EDITOR = r24;
        DebugConstants$DebugTools$DebugToolsType r25 = new DebugConstants$DebugTools$DebugToolsType("SP_DEBUG", 25, "sp_debug");
        SP_DEBUG = r25;
        DebugConstants$DebugTools$DebugToolsType r26 = new DebugConstants$DebugTools$DebugToolsType("LIBRA", 26, "libra");
        LIBRA = r26;
        DebugConstants$DebugTools$DebugToolsType r27 = new DebugConstants$DebugTools$DebugToolsType("WASTE", 27, "waste");
        WASTE = r27;
        DebugConstants$DebugTools$DebugToolsType r28 = new DebugConstants$DebugTools$DebugToolsType("ADVANCED_WHITE", 28, "advanced_white");
        ADVANCED_WHITE = r28;
        DebugConstants$DebugTools$DebugToolsType r29 = new DebugConstants$DebugTools$DebugToolsType("NEW_USER_MODE", 29, "new_user_mode");
        NEW_USER_MODE = r29;
        DebugConstants$DebugTools$DebugToolsType r30 = new DebugConstants$DebugTools$DebugToolsType("SETTINGS", 30, "settings");
        SETTINGS = r30;
        DebugConstants$DebugTools$DebugToolsType r31 = new DebugConstants$DebugTools$DebugToolsType("EVENT_MOB", 31, "event_mob");
        EVENT_MOB = r31;
        DebugConstants$DebugTools$DebugToolsType r32 = new DebugConstants$DebugTools$DebugToolsType("CHANGE_PAGE", 32, "change_page");
        CHANGE_PAGE = r32;
        DebugConstants$DebugTools$DebugToolsType r33 = new DebugConstants$DebugTools$DebugToolsType("SEARCH", 33, "search");
        SEARCH = r33;
        DebugConstants$DebugTools$DebugToolsType r34 = new DebugConstants$DebugTools$DebugToolsType("FAVORITE", 34, "favorite");
        FAVORITE = r34;
        DebugConstants$DebugTools$DebugToolsType[] r35 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34};
        a = r35;
        b = EnumEntriesKt.enumEntries(r35);
    }

    public static DebugConstants$DebugTools$DebugToolsType[] values() {
        return (DebugConstants$DebugTools$DebugToolsType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static DebugConstants$DebugTools$DebugToolsType valueOf(String r1) {
        return (DebugConstants$DebugTools$DebugToolsType) a.a(DebugConstants$DebugTools$DebugToolsType.class, r1);
    }

    public DebugConstants$DebugTools$DebugToolsType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
