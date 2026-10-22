package com.lynx.debugrouter;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ConnectionState extends Enum<ConnectionState> {
    private static final /* synthetic */ ConnectionState[] $VALUES = null;
    public static final ConnectionState CONNECTED = null;
    public static final ConnectionState CONNECTING = null;
    public static final ConnectionState DISCONNECTED = null;
    public static final ConnectionState DISCONNECTING = null;

    static {
        ConnectionState r0 = new ConnectionState("DISCONNECTED", 0);
        DISCONNECTED = r0;
        ConnectionState r1 = new ConnectionState("DISCONNECTING", 1);
        DISCONNECTING = r1;
        ConnectionState r3 = new ConnectionState("CONNECTING", 2);
        CONNECTING = r3;
        ConnectionState r5 = new ConnectionState("CONNECTED", 3);
        CONNECTED = r5;
        $VALUES = new ConnectionState[]{r0, r1, r3, r5};
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }

    public static ConnectionState valueOf(String r1) {
        return (ConnectionState) a.a(ConnectionState.class, r1);
    }

    private ConnectionState(String r1, int r2) {
        super(r1, r2);
    }
}
