package com.bytedance.frameworks.baselib.network.asynctask;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetworkAsyncTaskType extends Enum<NetworkAsyncTaskType> {
    private static final /* synthetic */ NetworkAsyncTaskType[] $VALUES = null;
    public static final NetworkAsyncTaskType NETWORK = null;

    static {
        NetworkAsyncTaskType r0 = new NetworkAsyncTaskType("NETWORK", 0);
        NETWORK = r0;
        $VALUES = new NetworkAsyncTaskType[]{r0};
    }

    private NetworkAsyncTaskType(String r1, int r2) {
        super(r1, r2);
    }

    public static NetworkAsyncTaskType valueOf(String r2) {
        return (NetworkAsyncTaskType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetworkAsyncTaskType.class, r2), NetworkAsyncTaskType.class, "com.obric.memorydata.plugin");
    }

    public static NetworkAsyncTaskType[] values() {
        return (NetworkAsyncTaskType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetworkAsyncTaskType[].class, "com.obric.memorydata.plugin");
    }
}
