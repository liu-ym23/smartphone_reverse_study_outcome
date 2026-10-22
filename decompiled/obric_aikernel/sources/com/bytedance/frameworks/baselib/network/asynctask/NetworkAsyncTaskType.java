package com.bytedance.frameworks.baselib.network.asynctask;

/* JADX INFO: loaded from: classes.dex */
public final enum NetworkAsyncTaskType extends Enum<NetworkAsyncTaskType> {
    private static final /* synthetic */ NetworkAsyncTaskType[] $VALUES = null;
    public static final NetworkAsyncTaskType NETWORK = null;

    static {
        NetworkAsyncTaskType r10 = new NetworkAsyncTaskType("NETWORK", 0);
        NETWORK = r10;
        $VALUES = new NetworkAsyncTaskType[]{r10};
    }

    private NetworkAsyncTaskType(String r10, int r11) {
        super(r10, r11);
    }

    public static NetworkAsyncTaskType valueOf(String r10) {
        return (NetworkAsyncTaskType) Enum.valueOf(NetworkAsyncTaskType.class, r10);
    }

    public static NetworkAsyncTaskType[] values() {
        return (NetworkAsyncTaskType[]) $VALUES.clone();
    }
}
