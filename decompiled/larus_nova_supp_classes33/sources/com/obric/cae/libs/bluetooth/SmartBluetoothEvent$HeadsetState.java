package com.obric.cae.libs.bluetooth;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum SmartBluetoothEvent$HeadsetState extends Enum<SmartBluetoothEvent$HeadsetState> {
    public static final SmartBluetoothEvent$HeadsetState STATE_AUDIO_CONNECTED = null;
    public static final SmartBluetoothEvent$HeadsetState STATE_AUDIO_CONNECTING = null;
    public static final SmartBluetoothEvent$HeadsetState STATE_AUDIO_DISCONNECTED = null;
    public static final SmartBluetoothEvent$HeadsetState STATE_CONNECTED = null;
    public static final SmartBluetoothEvent$HeadsetState STATE_CONNECTING = null;
    public static final SmartBluetoothEvent$HeadsetState STATE_DISCONNECTED = null;
    public static final SmartBluetoothEvent$HeadsetState STATE_DISCONNECTING = null;
    public static final /* synthetic */ SmartBluetoothEvent$HeadsetState[] b = null;
    public final int a;

    static {
        SmartBluetoothEvent$HeadsetState r0 = new SmartBluetoothEvent$HeadsetState(0, 0, "STATE_DISCONNECTED");
        STATE_DISCONNECTED = r0;
        SmartBluetoothEvent$HeadsetState r1 = new SmartBluetoothEvent$HeadsetState(1, 1, "STATE_CONNECTING");
        STATE_CONNECTING = r1;
        SmartBluetoothEvent$HeadsetState r3 = new SmartBluetoothEvent$HeadsetState(2, 2, "STATE_CONNECTED");
        STATE_CONNECTED = r3;
        SmartBluetoothEvent$HeadsetState r5 = new SmartBluetoothEvent$HeadsetState(3, 3, "STATE_DISCONNECTING");
        STATE_DISCONNECTING = r5;
        SmartBluetoothEvent$HeadsetState r7 = new SmartBluetoothEvent$HeadsetState(4, 10, "STATE_AUDIO_DISCONNECTED");
        STATE_AUDIO_DISCONNECTED = r7;
        SmartBluetoothEvent$HeadsetState r9 = new SmartBluetoothEvent$HeadsetState(5, 11, "STATE_AUDIO_CONNECTING");
        STATE_AUDIO_CONNECTING = r9;
        SmartBluetoothEvent$HeadsetState r10 = new SmartBluetoothEvent$HeadsetState(6, 12, "STATE_AUDIO_CONNECTED");
        STATE_AUDIO_CONNECTED = r10;
        b = new SmartBluetoothEvent$HeadsetState[]{r0, r1, r3, r5, r7, r9, r10};
    }

    public static SmartBluetoothEvent$HeadsetState[] values() {
        return (SmartBluetoothEvent$HeadsetState[]) b.clone();
    }

    public int getValue() {
        return this.a;
    }

    public static SmartBluetoothEvent$HeadsetState valueOf(String r1) {
        return (SmartBluetoothEvent$HeadsetState) a.a(SmartBluetoothEvent$HeadsetState.class, r1);
    }

    public SmartBluetoothEvent$HeadsetState(int r1, int r2, String r3) {
        super(r3, r1);
        this.a = r2;
    }
}
