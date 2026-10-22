package com.larus.audio.audiov3.task.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", "", "<init>", "(Ljava/lang/String;I)V", "ASR_START", "ASR_STOP", "ASR_ERROR", "ASR_RESULT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrLifeState extends Enum<AsrLifeState> {
    public static final AsrLifeState ASR_ERROR = null;
    public static final AsrLifeState ASR_RESULT = null;
    public static final AsrLifeState ASR_START = null;
    public static final AsrLifeState ASR_STOP = null;
    public static final /* synthetic */ AsrLifeState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AsrLifeState> getEntries() {
        return b;
    }

    static {
        AsrLifeState r0 = new AsrLifeState("ASR_START", 0);
        ASR_START = r0;
        AsrLifeState r1 = new AsrLifeState("ASR_STOP", 1);
        ASR_STOP = r1;
        AsrLifeState r3 = new AsrLifeState("ASR_ERROR", 2);
        ASR_ERROR = r3;
        AsrLifeState r5 = new AsrLifeState("ASR_RESULT", 3);
        ASR_RESULT = r5;
        AsrLifeState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static AsrLifeState[] values() {
        return (AsrLifeState[]) a.clone();
    }

    public static AsrLifeState valueOf(String r1) {
        return (AsrLifeState) a.a(AsrLifeState.class, r1);
    }

    public AsrLifeState(String r1, int r2) {
        super(r1, r2);
    }
}
