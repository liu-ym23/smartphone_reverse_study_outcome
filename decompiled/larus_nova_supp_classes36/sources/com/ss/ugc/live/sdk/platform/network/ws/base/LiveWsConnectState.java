package com.ss.ugc.live.sdk.platform.network.ws.base;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum LiveWsConnectState extends Enum<LiveWsConnectState> {
    public static final LiveWsConnectState CONNECTED = null;
    public static final LiveWsConnectState CONNECTING = null;
    public static final LiveWsConnectState CONNECTION_UNKNOWN = null;
    public static final LiveWsConnectState CONNECT_CLOSED = null;
    public static final LiveWsConnectState CONNECT_FAILED = null;
    public static final /* synthetic */ LiveWsConnectState[] a = null;
    final int mTypeValue;

    static {
        LiveWsConnectState r0 = new LiveWsConnectState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r0;
        LiveWsConnectState r1 = new LiveWsConnectState("CONNECTING", 1, 2);
        CONNECTING = r1;
        LiveWsConnectState r4 = new LiveWsConnectState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r4;
        LiveWsConnectState r6 = new LiveWsConnectState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r6;
        LiveWsConnectState r8 = new LiveWsConnectState("CONNECTED", 4, 16);
        CONNECTED = r8;
        a = new LiveWsConnectState[]{r0, r1, r4, r6, r8};
    }

    public static LiveWsConnectState[] values() {
        return (LiveWsConnectState[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.mTypeValue + '}';
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }

    public static LiveWsConnectState valueOf(String r1) {
        return (LiveWsConnectState) a.a(LiveWsConnectState.class, r1);
    }

    public LiveWsConnectState(String r1, int r2, int r3) {
        super(r1, r2);
        this.mTypeValue = r3;
    }
}
