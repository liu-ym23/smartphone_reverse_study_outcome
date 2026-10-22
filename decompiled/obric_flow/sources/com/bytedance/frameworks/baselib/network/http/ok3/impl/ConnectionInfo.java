package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes2.dex */
final enum ConnectionInfo extends Enum<ConnectionInfo> {
    public static final ConnectionInfo CONNECTION_INFO_DEPRECATED_SPDY3 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_0 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_1 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP2 = null;
    public static final ConnectionInfo CONNECTION_INFO_QUIC_UNKNOWN_VERSION = null;
    public static final ConnectionInfo CONNECTION_INFO_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectionInfo[] f4676a = null;
    final int mValue;

    static {
        ConnectionInfo r5 = new ConnectionInfo("CONNECTION_INFO_UNKNOWN", 0, 0);
        CONNECTION_INFO_UNKNOWN = r5;
        ConnectionInfo r10 = new ConnectionInfo("CONNECTION_INFO_HTTP1_1", 1, 1);
        CONNECTION_INFO_HTTP1_1 = r10;
        ConnectionInfo r11 = new ConnectionInfo("CONNECTION_INFO_DEPRECATED_SPDY3", 2, 3);
        CONNECTION_INFO_DEPRECATED_SPDY3 = r11;
        ConnectionInfo r12 = new ConnectionInfo("CONNECTION_INFO_HTTP2", 3, 4);
        CONNECTION_INFO_HTTP2 = r12;
        ConnectionInfo r13 = new ConnectionInfo("CONNECTION_INFO_QUIC_UNKNOWN_VERSION", 4, 5);
        CONNECTION_INFO_QUIC_UNKNOWN_VERSION = r13;
        ConnectionInfo r14 = new ConnectionInfo("CONNECTION_INFO_HTTP1_0", 5, 9);
        CONNECTION_INFO_HTTP1_0 = r14;
        f4676a = new ConnectionInfo[]{r5, r10, r11, r12, r13, r14};
    }

    public ConnectionInfo(String r5, int r10, int r11) {
        super(r5, r10);
        this.mValue = r11;
    }

    public static ConnectionInfo valueOf(String r5) {
        return (ConnectionInfo) Enum.valueOf(ConnectionInfo.class, r5);
    }

    public static ConnectionInfo[] values() {
        return (ConnectionInfo[]) f4676a.clone();
    }
}
