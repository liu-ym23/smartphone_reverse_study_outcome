package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum Act extends Enum<Act> {
    private static final /* synthetic */ Act[] $VALUES = null;

    @SerializedName("0")
    public static final Act RequireAction = null;

    @SerializedName("1")
    public static final Act RequireMessage = null;
    private final int value;

    static {
        Act r0 = new Act("RequireAction", 0, 0);
        RequireAction = r0;
        Act r1 = new Act("RequireMessage", 1, 1);
        RequireMessage = r1;
        $VALUES = new Act[]{r0, r1};
    }

    private Act(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static Act findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return RequireMessage;
    L10:
        return RequireAction;
    }

    public static Act valueOf(String r2) {
        return (Act) ZeusTransformUtils.preCheckCast(Enum.valueOf(Act.class, r2), Act.class, "com.obric.memorydata.plugin");
    }

    public static Act[] values() {
        return (Act[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Act[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
