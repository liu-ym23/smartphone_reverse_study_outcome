package com.obric.cae.libs.bluetooth;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum SmartBluetoothEvent$GattState extends Enum<SmartBluetoothEvent$GattState> {
    public static final SmartBluetoothEvent$GattState STATE_CONNECTED = null;
    public static final SmartBluetoothEvent$GattState STATE_DISCONNECTED = null;
    public static final /* synthetic */ SmartBluetoothEvent$GattState[] b = null;
    public final int a;

    static {
        SmartBluetoothEvent$GattState r0 = new SmartBluetoothEvent$GattState(0, 0, "STATE_DISCONNECTED");
        STATE_DISCONNECTED = r0;
        SmartBluetoothEvent$GattState r1 = new SmartBluetoothEvent$GattState(1, 2, "STATE_CONNECTED");
        STATE_CONNECTED = r1;
        b = new SmartBluetoothEvent$GattState[]{r0, r1};
    }

    public static SmartBluetoothEvent$GattState[] values() {
        return (SmartBluetoothEvent$GattState[]) b.clone();
    }

    public int getValue() {
        return this.a;
    }

    public static SmartBluetoothEvent$GattState valueOf(String r1) {
        return (SmartBluetoothEvent$GattState) a.a(SmartBluetoothEvent$GattState.class, r1);
    }

    public SmartBluetoothEvent$GattState(int r1, int r2, String r3) {
        super(r3, r1);
        this.a = r2;
    }
}
