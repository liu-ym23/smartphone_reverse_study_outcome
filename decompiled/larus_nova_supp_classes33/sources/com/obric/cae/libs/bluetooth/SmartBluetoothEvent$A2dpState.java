package com.obric.cae.libs.bluetooth;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum SmartBluetoothEvent$A2dpState extends Enum<SmartBluetoothEvent$A2dpState> {
    public static final SmartBluetoothEvent$A2dpState STATE_CONNECTED = null;
    public static final SmartBluetoothEvent$A2dpState STATE_CONNECTING = null;
    public static final SmartBluetoothEvent$A2dpState STATE_DISCONNECTED = null;
    public static final SmartBluetoothEvent$A2dpState STATE_DISCONNECTING = null;
    public static final SmartBluetoothEvent$A2dpState STATE_NOT_PLAYING = null;
    public static final SmartBluetoothEvent$A2dpState STATE_PLAYING = null;
    public static final /* synthetic */ SmartBluetoothEvent$A2dpState[] b = null;
    public final int a;

    static {
        SmartBluetoothEvent$A2dpState r0 = new SmartBluetoothEvent$A2dpState(0, 0, "STATE_DISCONNECTED");
        STATE_DISCONNECTED = r0;
        SmartBluetoothEvent$A2dpState r1 = new SmartBluetoothEvent$A2dpState(1, 1, "STATE_CONNECTING");
        STATE_CONNECTING = r1;
        SmartBluetoothEvent$A2dpState r3 = new SmartBluetoothEvent$A2dpState(2, 2, "STATE_CONNECTED");
        STATE_CONNECTED = r3;
        SmartBluetoothEvent$A2dpState r5 = new SmartBluetoothEvent$A2dpState(3, 3, "STATE_DISCONNECTING");
        STATE_DISCONNECTING = r5;
        SmartBluetoothEvent$A2dpState r7 = new SmartBluetoothEvent$A2dpState(4, 10, "STATE_PLAYING");
        STATE_PLAYING = r7;
        SmartBluetoothEvent$A2dpState r9 = new SmartBluetoothEvent$A2dpState(5, 11, "STATE_NOT_PLAYING");
        STATE_NOT_PLAYING = r9;
        b = new SmartBluetoothEvent$A2dpState[]{r0, r1, r3, r5, r7, r9};
    }

    public static SmartBluetoothEvent$A2dpState[] values() {
        return (SmartBluetoothEvent$A2dpState[]) b.clone();
    }

    public int getValue() {
        return this.a;
    }

    public static SmartBluetoothEvent$A2dpState valueOf(String r1) {
        return (SmartBluetoothEvent$A2dpState) a.a(SmartBluetoothEvent$A2dpState.class, r1);
    }

    public SmartBluetoothEvent$A2dpState(int r1, int r2, String r3) {
        super(r3, r1);
        this.a = r2;
    }
}
