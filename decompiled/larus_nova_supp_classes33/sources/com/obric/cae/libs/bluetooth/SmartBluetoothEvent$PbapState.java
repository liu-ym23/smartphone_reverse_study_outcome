package com.obric.cae.libs.bluetooth;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum SmartBluetoothEvent$PbapState extends Enum<SmartBluetoothEvent$PbapState> {
    public static final SmartBluetoothEvent$PbapState STATE_CONNECTED = null;
    public static final SmartBluetoothEvent$PbapState STATE_CONNECTING = null;
    public static final SmartBluetoothEvent$PbapState STATE_DISCONNECTED = null;
    public static final SmartBluetoothEvent$PbapState STATE_DISCONNECTING = null;
    public static final /* synthetic */ SmartBluetoothEvent$PbapState[] b = null;
    public final int a;

    static {
        SmartBluetoothEvent$PbapState r0 = new SmartBluetoothEvent$PbapState(0, 0, "STATE_DISCONNECTED");
        STATE_DISCONNECTED = r0;
        SmartBluetoothEvent$PbapState r1 = new SmartBluetoothEvent$PbapState(1, 1, "STATE_CONNECTING");
        STATE_CONNECTING = r1;
        SmartBluetoothEvent$PbapState r3 = new SmartBluetoothEvent$PbapState(2, 2, "STATE_CONNECTED");
        STATE_CONNECTED = r3;
        SmartBluetoothEvent$PbapState r5 = new SmartBluetoothEvent$PbapState(3, 3, "STATE_DISCONNECTING");
        STATE_DISCONNECTING = r5;
        b = new SmartBluetoothEvent$PbapState[]{r0, r1, r3, r5};
    }

    public static SmartBluetoothEvent$PbapState[] values() {
        return (SmartBluetoothEvent$PbapState[]) b.clone();
    }

    public int getValue() {
        return this.a;
    }

    public static SmartBluetoothEvent$PbapState valueOf(String r1) {
        return (SmartBluetoothEvent$PbapState) a.a(SmartBluetoothEvent$PbapState.class, r1);
    }

    public SmartBluetoothEvent$PbapState(int r1, int r2, String r3) {
        super(r3, r1);
        this.a = r2;
    }
}
