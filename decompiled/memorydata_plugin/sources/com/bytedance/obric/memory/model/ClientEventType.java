package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ClientEventType extends Enum<ClientEventType> {
    private static final /* synthetic */ ClientEventType[] $VALUES = null;

    @SerializedName("1")
    public static final ClientEventType Install = null;

    @SerializedName("3")
    public static final ClientEventType Remove = null;

    @SerializedName("4")
    public static final ClientEventType RemoveAll = null;

    @SerializedName("2")
    public static final ClientEventType Update = null;
    private final int value;

    static {
        ClientEventType r0 = new ClientEventType("Install", 0, 1);
        Install = r0;
        ClientEventType r1 = new ClientEventType("Update", 1, 2);
        Update = r1;
        ClientEventType r4 = new ClientEventType("Remove", 2, 3);
        Remove = r4;
        ClientEventType r6 = new ClientEventType("RemoveAll", 3, 4);
        RemoveAll = r6;
        $VALUES = new ClientEventType[]{r0, r1, r4, r6};
    }

    private ClientEventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ClientEventType findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return RemoveAll;
    L15:
        return Remove;
    L17:
        return Update;
    L19:
        return Install;
    }

    public static ClientEventType valueOf(String r2) {
        return (ClientEventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ClientEventType.class, r2), ClientEventType.class, "com.obric.memorydata.plugin");
    }

    public static ClientEventType[] values() {
        return (ClientEventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ClientEventType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
