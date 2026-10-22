package com.bytedance.frameworks.baselib.network.asynctask;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum NetworkAsyncTaskType extends Enum<NetworkAsyncTaskType> {
    public static final NetworkAsyncTaskType NETWORK = null;
    public static final /* synthetic */ NetworkAsyncTaskType[] a = null;

    static {
        NetworkAsyncTaskType r0 = new NetworkAsyncTaskType();
        NETWORK = r0;
        a = new NetworkAsyncTaskType[]{r0};
    }

    public NetworkAsyncTaskType() {
        super("NETWORK", 0);
    }

    public static NetworkAsyncTaskType[] values() {
        return (NetworkAsyncTaskType[]) a.clone();
    }

    public static NetworkAsyncTaskType valueOf(String r1) {
        return (NetworkAsyncTaskType) a.a(NetworkAsyncTaskType.class, r1);
    }
}
