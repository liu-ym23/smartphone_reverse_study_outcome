package com.obric.assistant.wakeup.bluetooth_headset.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceConnectState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CONNECTED", "DISCONNECTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueDeviceConnectState extends Enum<BlueDeviceConnectState> {
    public static final BlueDeviceConnectState CONNECTED = null;
    public static final BlueDeviceConnectState DISCONNECTED = null;
    public static final BlueDeviceConnectState NA = null;
    public static final /* synthetic */ BlueDeviceConnectState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BlueDeviceConnectState> getEntries() {
        return b;
    }

    static {
        BlueDeviceConnectState r0 = new BlueDeviceConnectState("NA", 0);
        NA = r0;
        BlueDeviceConnectState r1 = new BlueDeviceConnectState("CONNECTED", 1);
        CONNECTED = r1;
        BlueDeviceConnectState r3 = new BlueDeviceConnectState("DISCONNECTED", 2);
        DISCONNECTED = r3;
        BlueDeviceConnectState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BlueDeviceConnectState[] values() {
        return (BlueDeviceConnectState[]) a.clone();
    }

    public static BlueDeviceConnectState valueOf(String r1) {
        return (BlueDeviceConnectState) a.a(BlueDeviceConnectState.class, r1);
    }

    public BlueDeviceConnectState(String r1, int r2) {
        super(r1, r2);
    }
}
