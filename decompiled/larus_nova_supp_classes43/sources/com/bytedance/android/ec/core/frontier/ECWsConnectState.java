package com.bytedance.android.ec.core.frontier;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/frontier/ECWsConnectState;", "", "", "toString", "", "typeValue", "I", "CONNECTION_UNKNOWN", "CONNECTING", "CONNECT_FAILED", "CONNECT_CLOSED", "CONNECTED", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECWsConnectState extends Enum<ECWsConnectState> {
    public static final ECWsConnectState CONNECTED = null;
    public static final ECWsConnectState CONNECTING = null;
    public static final ECWsConnectState CONNECTION_UNKNOWN = null;
    public static final ECWsConnectState CONNECT_CLOSED = null;
    public static final ECWsConnectState CONNECT_FAILED = null;
    public static final /* synthetic */ ECWsConnectState[] a = null;
    private final int typeValue;

    static {
        ECWsConnectState r1 = new ECWsConnectState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r1;
        ECWsConnectState r10 = new ECWsConnectState("CONNECTING", 1, 2);
        CONNECTING = r10;
        ECWsConnectState r11 = new ECWsConnectState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r11;
        ECWsConnectState r12 = new ECWsConnectState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r12;
        ECWsConnectState r13 = new ECWsConnectState("CONNECTED", 4, 16);
        CONNECTED = r13;
        a = new ECWsConnectState[]{r1, r10, r11, r12, r13};
    }

    public static ECWsConnectState valueOf(String r1) {
        return (ECWsConnectState) r27.a.a(ECWsConnectState.class, r1);
    }

    public static ECWsConnectState[] values() {
        return (ECWsConnectState[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.typeValue + '}';
    }

    public ECWsConnectState(String r1, int r10, int r11) {
        super(r1, r10);
        this.typeValue = r11;
    }
}
