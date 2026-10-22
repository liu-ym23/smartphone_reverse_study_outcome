package com.larus.audio.audiov3.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/asr/AsrCallBackType;", "", "<init>", "(Ljava/lang/String;I)V", "ASR_START", "AS_SUCCESS", "ASR_CANCEL", "ASR_FAILED", "ASR_FAILED_SERVER", "ASR_FAILED_TOKEN", "ASR_STREAM", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrCallBackType extends Enum<AsrCallBackType> {
    public static final AsrCallBackType ASR_CANCEL = null;
    public static final AsrCallBackType ASR_FAILED = null;
    public static final AsrCallBackType ASR_FAILED_SERVER = null;
    public static final AsrCallBackType ASR_FAILED_TOKEN = null;
    public static final AsrCallBackType ASR_START = null;
    public static final AsrCallBackType ASR_STREAM = null;
    public static final AsrCallBackType AS_SUCCESS = null;
    public static final /* synthetic */ AsrCallBackType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AsrCallBackType> getEntries() {
        return b;
    }

    static {
        AsrCallBackType r0 = new AsrCallBackType("ASR_START", 0);
        ASR_START = r0;
        AsrCallBackType r1 = new AsrCallBackType("AS_SUCCESS", 1);
        AS_SUCCESS = r1;
        AsrCallBackType r3 = new AsrCallBackType("ASR_CANCEL", 2);
        ASR_CANCEL = r3;
        AsrCallBackType r5 = new AsrCallBackType("ASR_FAILED", 3);
        ASR_FAILED = r5;
        AsrCallBackType r7 = new AsrCallBackType("ASR_FAILED_SERVER", 4);
        ASR_FAILED_SERVER = r7;
        AsrCallBackType r9 = new AsrCallBackType("ASR_FAILED_TOKEN", 5);
        ASR_FAILED_TOKEN = r9;
        AsrCallBackType r11 = new AsrCallBackType("ASR_STREAM", 6);
        ASR_STREAM = r11;
        AsrCallBackType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static AsrCallBackType[] values() {
        return (AsrCallBackType[]) a.clone();
    }

    public static AsrCallBackType valueOf(String r1) {
        return (AsrCallBackType) a.a(AsrCallBackType.class, r1);
    }

    public AsrCallBackType(String r1, int r2) {
        super(r1, r2);
    }
}
