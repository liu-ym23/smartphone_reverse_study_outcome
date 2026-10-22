package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayErrorCode;", "", "", "code", "I", "getCode", "()I", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "STATE_NOT_STOPPED", "ALREADY_CREATED", "STATE_NOT_LOADED", "XPLAY_INSTANCE_NULL", "XPLAY_PLUGIN_FAILED", "REQUEST_APP_TOKEN_FAILED", "GAME_LOADED_FAILED", "REQUEST_APP_START_FAILED", "RECEIVE_FIRST_FRAME_TIMEOUT", "SERVER_MERGE_CAST_FAILED", "XPLAY_INTERNAL_ERROR", "UNKNOWN", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum XplayErrorCode extends Enum<XplayErrorCode> {
    public static final XplayErrorCode ALREADY_CREATED = null;
    public static final XplayErrorCode GAME_LOADED_FAILED = null;
    public static final XplayErrorCode RECEIVE_FIRST_FRAME_TIMEOUT = null;
    public static final XplayErrorCode REQUEST_APP_START_FAILED = null;
    public static final XplayErrorCode REQUEST_APP_TOKEN_FAILED = null;
    public static final XplayErrorCode SERVER_MERGE_CAST_FAILED = null;
    public static final XplayErrorCode STATE_NOT_LOADED = null;
    public static final XplayErrorCode STATE_NOT_STOPPED = null;
    public static final XplayErrorCode UNKNOWN = null;
    public static final XplayErrorCode XPLAY_INSTANCE_NULL = null;
    public static final XplayErrorCode XPLAY_INTERNAL_ERROR = null;
    public static final XplayErrorCode XPLAY_PLUGIN_FAILED = null;
    public static final /* synthetic */ XplayErrorCode[] a = null;
    private final int code;
    private final String errorMsg;

    public static XplayErrorCode valueOf(String r1) {
        return (XplayErrorCode) r27.a.a(XplayErrorCode.class, r1);
    }

    public static XplayErrorCode[] values() {
        return (XplayErrorCode[]) a.clone();
    }

    static {
        XplayErrorCode r1 = new XplayErrorCode("STATE_NOT_STOPPED", 0, 101, "state is not stopped");
        STATE_NOT_STOPPED = r1;
        XplayErrorCode r2 = new XplayErrorCode("ALREADY_CREATED", 1, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH, "Xplay instance is already created");
        ALREADY_CREATED = r2;
        XplayErrorCode r3 = new XplayErrorCode("STATE_NOT_LOADED", 2, 103, "state is not loaded");
        STATE_NOT_LOADED = r3;
        XplayErrorCode r4 = new XplayErrorCode("XPLAY_INSTANCE_NULL", 3, 104, "Xplay instance is null");
        XPLAY_INSTANCE_NULL = r4;
        XplayErrorCode r5 = new XplayErrorCode("XPLAY_PLUGIN_FAILED", 4, 105, "xplay plugin failed");
        XPLAY_PLUGIN_FAILED = r5;
        XplayErrorCode r6 = new XplayErrorCode("REQUEST_APP_TOKEN_FAILED", 5, 301, "request token failure");
        REQUEST_APP_TOKEN_FAILED = r6;
        XplayErrorCode r7 = new XplayErrorCode("GAME_LOADED_FAILED", 6, 302, "game is not loaded");
        GAME_LOADED_FAILED = r7;
        XplayErrorCode r8 = new XplayErrorCode("REQUEST_APP_START_FAILED", 7, 303, "request app start failure");
        REQUEST_APP_START_FAILED = r8;
        XplayErrorCode r9 = new XplayErrorCode("RECEIVE_FIRST_FRAME_TIMEOUT", 8, 304, "receive first frame timeout");
        RECEIVE_FIRST_FRAME_TIMEOUT = r9;
        XplayErrorCode r11 = new XplayErrorCode("SERVER_MERGE_CAST_FAILED", 9, 401, "rtc info is empty");
        SERVER_MERGE_CAST_FAILED = r11;
        XplayErrorCode r12 = new XplayErrorCode("XPLAY_INTERNAL_ERROR", 10, -1, "xplay internal error");
        XPLAY_INTERNAL_ERROR = r12;
        XplayErrorCode r13 = new XplayErrorCode("UNKNOWN", 11, 0, "unknown");
        UNKNOWN = r13;
        a = new XplayErrorCode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public XplayErrorCode(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.errorMsg = r4;
    }
}
