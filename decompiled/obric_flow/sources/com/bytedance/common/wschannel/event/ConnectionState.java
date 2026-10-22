package com.bytedance.common.wschannel.event;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final enum ConnectionState extends Enum<ConnectionState> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConnectionState f3982b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConnectionState f3983c = null;
    public static final ConnectionState d = null;
    public static final ConnectionState e = null;
    public static final ConnectionState f = null;
    public static final /* synthetic */ ConnectionState[] g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3984a;

    static {
        ConnectionState r5 = new ConnectionState("CONNECTION_UNKNOWN", 0, 1);
        f3982b = r5;
        ConnectionState r10 = new ConnectionState("CONNECTING", 1, 2);
        f3983c = r10;
        ConnectionState r11 = new ConnectionState("CONNECT_FAILED", 2, 4);
        d = r11;
        ConnectionState r12 = new ConnectionState("CONNECT_CLOSED", 3, 8);
        e = r12;
        ConnectionState r13 = new ConnectionState("CONNECTED", 4, 16);
        f = r13;
        g = new ConnectionState[]{r5, r10, r11, r12, r13};
    }

    public ConnectionState(String r5, int r10, int r11) {
        super(r5, r10);
        this.f3984a = r11;
    }

    public static ConnectionState valueOf(String r5) {
        return (ConnectionState) Enum.valueOf(ConnectionState.class, r5);
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) g.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return j0.n(new StringBuilder("ConnectionState{State="), this.f3984a, '}');
    }
}
