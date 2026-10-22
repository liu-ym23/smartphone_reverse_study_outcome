package com.larus.audio.audiov3.task.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrErrorType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ASR_TASK_FAILED", "ASR_SESSION_FAILED", "WEB_SOCKET_CHANGE_FAIL", "WEB_SOCKET_CONNECTION_FAIL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrErrorType extends Enum<AsrErrorType> {
    public static final AsrErrorType ASR_SESSION_FAILED = null;
    public static final AsrErrorType ASR_TASK_FAILED = null;
    public static final AsrErrorType WEB_SOCKET_CHANGE_FAIL = null;
    public static final AsrErrorType WEB_SOCKET_CONNECTION_FAIL = null;
    public static final /* synthetic */ AsrErrorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<AsrErrorType> getEntries() {
        return b;
    }

    static {
        AsrErrorType r0 = new AsrErrorType("ASR_TASK_FAILED", 0, "asr_task_failed");
        ASR_TASK_FAILED = r0;
        AsrErrorType r1 = new AsrErrorType("ASR_SESSION_FAILED", 1, "asr_session_failed");
        ASR_SESSION_FAILED = r1;
        AsrErrorType r2 = new AsrErrorType("WEB_SOCKET_CHANGE_FAIL", 2, "web_socket_change_fail");
        WEB_SOCKET_CHANGE_FAIL = r2;
        AsrErrorType r4 = new AsrErrorType("WEB_SOCKET_CONNECTION_FAIL", 3, "web_socket_connection_fail");
        WEB_SOCKET_CONNECTION_FAIL = r4;
        AsrErrorType[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static AsrErrorType[] values() {
        return (AsrErrorType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static AsrErrorType valueOf(String r1) {
        return (AsrErrorType) a.a(AsrErrorType.class, r1);
    }

    public AsrErrorType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
