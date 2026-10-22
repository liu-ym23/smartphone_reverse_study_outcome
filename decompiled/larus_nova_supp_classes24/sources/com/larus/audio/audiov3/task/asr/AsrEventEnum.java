package com.larus.audio.audiov3.task.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrEventEnum;", "", "code", "", "text", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getText", "()Ljava/lang/String;", "ASR_TASK_FAIL", "ASR_SUCCESS", "ASR_RESPONSE", "ASR_CANCEL", "ASR_SESSION_FAIL", "ASR_SESSION_START", "ASR_SESSION_FINISH", "ASR_SESSION_CANCEL", "ASR_NETWORK_FAILED", "ASR_TIMEOUT", "ASR_TOKEN_FAIL", "ASR_NOT_NETWORK", "ASR_STREAM", "ASR_RECORDER_SILENCED", "ASR_REQUEST_MEDIA_FAILED", "ASR_RESEND_FILE_NOT_EXIST", "ASR_SAMI_NOT_READY_ERROR", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrEventEnum extends Enum<AsrEventEnum> {
    public static final AsrEventEnum ASR_CANCEL = null;
    public static final AsrEventEnum ASR_NETWORK_FAILED = null;
    public static final AsrEventEnum ASR_NOT_NETWORK = null;
    public static final AsrEventEnum ASR_RECORDER_SILENCED = null;
    public static final AsrEventEnum ASR_REQUEST_MEDIA_FAILED = null;
    public static final AsrEventEnum ASR_RESEND_FILE_NOT_EXIST = null;
    public static final AsrEventEnum ASR_RESPONSE = null;
    public static final AsrEventEnum ASR_SAMI_NOT_READY_ERROR = null;
    public static final AsrEventEnum ASR_SESSION_CANCEL = null;
    public static final AsrEventEnum ASR_SESSION_FAIL = null;
    public static final AsrEventEnum ASR_SESSION_FINISH = null;
    public static final AsrEventEnum ASR_SESSION_START = null;
    public static final AsrEventEnum ASR_STREAM = null;
    public static final AsrEventEnum ASR_SUCCESS = null;
    public static final AsrEventEnum ASR_TASK_FAIL = null;
    public static final AsrEventEnum ASR_TIMEOUT = null;
    public static final AsrEventEnum ASR_TOKEN_FAIL = null;
    public static final /* synthetic */ AsrEventEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;
    private final String text;

    public static EnumEntries<AsrEventEnum> getEntries() {
        return b;
    }

    static {
        AsrEventEnum r0 = new AsrEventEnum("ASR_TASK_FAIL", 0, 500, "ASR_START");
        ASR_TASK_FAIL = r0;
        AsrEventEnum r1 = new AsrEventEnum("ASR_SUCCESS", 1, 501, "AS_SUCCESS");
        ASR_SUCCESS = r1;
        AsrEventEnum r2 = new AsrEventEnum("ASR_RESPONSE", 2, 510, "ASR_RESPONSE");
        ASR_RESPONSE = r2;
        AsrEventEnum r3 = new AsrEventEnum("ASR_CANCEL", 3, 502, "ASR_CANCEL");
        ASR_CANCEL = r3;
        AsrEventEnum r5 = new AsrEventEnum("ASR_SESSION_FAIL", 4, 503, "ASR_SESSION_FAIL");
        ASR_SESSION_FAIL = r5;
        AsrEventEnum r8 = new AsrEventEnum("ASR_SESSION_START", 5, 511, "ASR_SESSION_START");
        ASR_SESSION_START = r8;
        AsrEventEnum r10 = new AsrEventEnum("ASR_SESSION_FINISH", 6, 508, "ASR_SESSION_FINISH");
        ASR_SESSION_FINISH = r10;
        AsrEventEnum r12 = new AsrEventEnum("ASR_SESSION_CANCEL", 7, 509, "ASR_SESSION_CANCEL");
        ASR_SESSION_CANCEL = r12;
        AsrEventEnum r14 = new AsrEventEnum("ASR_NETWORK_FAILED", 8, 504, "ASR_NETWORK_FAILED");
        ASR_NETWORK_FAILED = r14;
        AsrEventEnum r13 = new AsrEventEnum("ASR_TIMEOUT", 9, 505, "ASR_TIMEOUT");
        ASR_TIMEOUT = r13;
        AsrEventEnum r11 = new AsrEventEnum("ASR_TOKEN_FAIL", 10, 506, "ASR_TOKEN_FAIL");
        ASR_TOKEN_FAIL = r11;
        AsrEventEnum r9 = new AsrEventEnum("ASR_NOT_NETWORK", 11, 507, "ASR_NOT_NETWORK");
        ASR_NOT_NETWORK = r9;
        AsrEventEnum r7 = new AsrEventEnum("ASR_STREAM", 12, 512, "ASR_STREAM");
        ASR_STREAM = r7;
        AsrEventEnum r4 = new AsrEventEnum("ASR_RECORDER_SILENCED", 13, 513, "ASR_RECORDER_SILENCED");
        ASR_RECORDER_SILENCED = r4;
        AsrEventEnum r6 = new AsrEventEnum("ASR_REQUEST_MEDIA_FAILED", 14, 514, "ASR_REQUEST_MEDIA_FAILED");
        ASR_REQUEST_MEDIA_FAILED = r6;
        AsrEventEnum r15 = new AsrEventEnum("ASR_RESEND_FILE_NOT_EXIST", 15, 515, "ASR_RESEND_FILE_NOT_EXIST");
        ASR_RESEND_FILE_NOT_EXIST = r15;
        AsrEventEnum r16 = new AsrEventEnum("ASR_SAMI_NOT_READY_ERROR", 16, 516, "ASR_SAMI_NOT_READY_ERROR");
        ASR_SAMI_NOT_READY_ERROR = r16;
        AsrEventEnum[] r17 = {r0, r1, r2, r3, r5, r8, r10, r12, r14, r13, r11, r9, r7, r4, r6, r15, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static AsrEventEnum[] values() {
        return (AsrEventEnum[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getText() {
        return this.text;
    }

    public static AsrEventEnum valueOf(String r1) {
        return (AsrEventEnum) a.a(AsrEventEnum.class, r1);
    }

    public AsrEventEnum(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.text = r4;
    }
}
