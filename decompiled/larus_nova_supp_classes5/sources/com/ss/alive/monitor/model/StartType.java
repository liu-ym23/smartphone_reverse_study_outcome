package com.ss.alive.monitor.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum StartType extends Enum<StartType> {
    public static final StartType BIND_SERVICE = null;
    public static final StartType PROVIDER_GET_TYPE = null;
    public static final StartType PROVIDER_QUERY = null;
    public static final StartType SEND_BROADCAST = null;
    public static final StartType START_ACTIVITY = null;
    public static final StartType START_SERVICE = null;
    public static final /* synthetic */ StartType[] a = null;
    public final String methodName;
    public final String startType;

    static {
        StartType r0 = new StartType("START_SERVICE", 0, "startService", "start_service");
        START_SERVICE = r0;
        StartType r1 = new StartType("BIND_SERVICE", 1, "bindIsolatedService", "bind_service");
        BIND_SERVICE = r1;
        StartType r2 = new StartType("PROVIDER_GET_TYPE", 2, "getProviderMimeType", "provider_get_type");
        PROVIDER_GET_TYPE = r2;
        StartType r3 = new StartType("PROVIDER_QUERY", 3, "getContentProvider", "provider_query");
        PROVIDER_QUERY = r3;
        StartType r5 = new StartType("SEND_BROADCAST", 4, "broadcastIntent", "send_broadcast");
        SEND_BROADCAST = r5;
        StartType r7 = new StartType("START_ACTIVITY", 5, "startActivity", "start_activity");
        START_ACTIVITY = r7;
        a = new StartType[]{r0, r1, r2, r3, r5, r7};
    }

    public static StartType[] values() {
        return (StartType[]) a.clone();
    }

    public static StartType valueOf(String r1) {
        return (StartType) a.a(StartType.class, r1);
    }

    public StartType(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.methodName = r3;
        this.startType = r4;
    }
}
