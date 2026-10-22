package com.obric.assistant.wakeup.bluetooth_headset.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceSwitchState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "ON", "OFF", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueDeviceSwitchState extends Enum<BlueDeviceSwitchState> {
    public static final BlueDeviceSwitchState NA = null;
    public static final BlueDeviceSwitchState OFF = null;
    public static final BlueDeviceSwitchState ON = null;
    public static final /* synthetic */ BlueDeviceSwitchState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BlueDeviceSwitchState> getEntries() {
        return b;
    }

    static {
        BlueDeviceSwitchState r0 = new BlueDeviceSwitchState("NA", 0);
        NA = r0;
        BlueDeviceSwitchState r1 = new BlueDeviceSwitchState("ON", 1);
        ON = r1;
        BlueDeviceSwitchState r3 = new BlueDeviceSwitchState("OFF", 2);
        OFF = r3;
        BlueDeviceSwitchState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BlueDeviceSwitchState[] values() {
        return (BlueDeviceSwitchState[]) a.clone();
    }

    public static BlueDeviceSwitchState valueOf(String r1) {
        return (BlueDeviceSwitchState) a.a(BlueDeviceSwitchState.class, r1);
    }

    public BlueDeviceSwitchState(String r1, int r2) {
        super(r1, r2);
    }
}
