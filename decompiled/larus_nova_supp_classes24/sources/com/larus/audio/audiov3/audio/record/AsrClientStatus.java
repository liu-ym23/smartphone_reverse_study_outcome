package com.larus.audio.audiov3.audio.record;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/audio/record/AsrClientStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_IDLE", "STATE_TOUCH", "STATE_CANCEL", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrClientStatus extends Enum<AsrClientStatus> {
    public static final AsrClientStatus STATE_CANCEL = null;
    public static final AsrClientStatus STATE_IDLE = null;
    public static final AsrClientStatus STATE_TOUCH = null;
    public static final /* synthetic */ AsrClientStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AsrClientStatus> getEntries() {
        return b;
    }

    static {
        AsrClientStatus r0 = new AsrClientStatus("STATE_IDLE", 0);
        STATE_IDLE = r0;
        AsrClientStatus r1 = new AsrClientStatus("STATE_TOUCH", 1);
        STATE_TOUCH = r1;
        AsrClientStatus r3 = new AsrClientStatus("STATE_CANCEL", 2);
        STATE_CANCEL = r3;
        AsrClientStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AsrClientStatus[] values() {
        return (AsrClientStatus[]) a.clone();
    }

    public static AsrClientStatus valueOf(String r1) {
        return (AsrClientStatus) a.a(AsrClientStatus.class, r1);
    }

    public AsrClientStatus(String r1, int r2) {
        super(r1, r2);
    }
}
