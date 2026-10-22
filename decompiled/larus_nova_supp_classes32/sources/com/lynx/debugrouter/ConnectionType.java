package com.lynx.debugrouter;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ConnectionType extends Enum<ConnectionType> {
    private static final /* synthetic */ ConnectionType[] $VALUES = null;
    public static final ConnectionType USB = null;
    public static final ConnectionType WebSocket = null;

    static {
        ConnectionType r0 = new ConnectionType("WebSocket", 0);
        WebSocket = r0;
        ConnectionType r1 = new ConnectionType("USB", 1);
        USB = r1;
        $VALUES = new ConnectionType[]{r0, r1};
    }

    public static ConnectionType[] values() {
        return (ConnectionType[]) $VALUES.clone();
    }

    public static ConnectionType valueOf(String r1) {
        return (ConnectionType) a.a(ConnectionType.class, r1);
    }

    private ConnectionType(String r1, int r2) {
        super(r1, r2);
    }
}
