package com.larus.audio.audiov3.task.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/audio/audiov3/task/asr/AsrStopType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ASR_END", "USER_CANCEL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrStopType extends Enum<AsrStopType> {
    public static final AsrStopType ASR_END = null;
    public static final AsrStopType USER_CANCEL = null;
    public static final /* synthetic */ AsrStopType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<AsrStopType> getEntries() {
        return b;
    }

    static {
        AsrStopType r0 = new AsrStopType("ASR_END", 0, "asr_end");
        ASR_END = r0;
        AsrStopType r1 = new AsrStopType("USER_CANCEL", 1, "user_cancel");
        USER_CANCEL = r1;
        AsrStopType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static AsrStopType[] values() {
        return (AsrStopType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static AsrStopType valueOf(String r1) {
        return (AsrStopType) a.a(AsrStopType.class, r1);
    }

    public AsrStopType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
