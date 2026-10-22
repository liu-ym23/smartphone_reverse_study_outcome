package com.larus.audio.audiov3.config.task.sami.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/config/task/sami/asr/AsrResultState;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAIL", "STREAM", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrResultState extends Enum<AsrResultState> {
    public static final AsrResultState FAIL = null;
    public static final AsrResultState STREAM = null;
    public static final AsrResultState SUCCESS = null;
    public static final /* synthetic */ AsrResultState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AsrResultState> getEntries() {
        return b;
    }

    static {
        AsrResultState r0 = new AsrResultState("SUCCESS", 0);
        SUCCESS = r0;
        AsrResultState r1 = new AsrResultState("FAIL", 1);
        FAIL = r1;
        AsrResultState r3 = new AsrResultState("STREAM", 2);
        STREAM = r3;
        AsrResultState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AsrResultState[] values() {
        return (AsrResultState[]) a.clone();
    }

    public static AsrResultState valueOf(String r1) {
        return (AsrResultState) a.a(AsrResultState.class, r1);
    }

    public AsrResultState(String r1, int r2) {
        super(r1, r2);
    }
}
