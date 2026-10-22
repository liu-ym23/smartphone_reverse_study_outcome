package com.larus.audio.call;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/call/HangUpState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WAIT_LAST_AUDIO", "SEND_EVENT", "FINISH", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum HangUpState extends Enum<HangUpState> {
    public static final HangUpState FINISH = null;
    public static final HangUpState IDLE = null;
    public static final HangUpState SEND_EVENT = null;
    public static final HangUpState WAIT_LAST_AUDIO = null;
    public static final /* synthetic */ HangUpState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HangUpState> getEntries() {
        return b;
    }

    static {
        HangUpState r0 = new HangUpState("IDLE", 0);
        IDLE = r0;
        HangUpState r1 = new HangUpState("WAIT_LAST_AUDIO", 1);
        WAIT_LAST_AUDIO = r1;
        HangUpState r3 = new HangUpState("SEND_EVENT", 2);
        SEND_EVENT = r3;
        HangUpState r5 = new HangUpState("FINISH", 3);
        FINISH = r5;
        HangUpState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static HangUpState[] values() {
        return (HangUpState[]) a.clone();
    }

    public static HangUpState valueOf(String r1) {
        return (HangUpState) r27.a.a(HangUpState.class, r1);
    }

    public HangUpState(String r1, int r2) {
        super(r1, r2);
    }
}
