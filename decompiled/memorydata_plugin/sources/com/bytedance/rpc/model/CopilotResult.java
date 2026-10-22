package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CopilotResult extends Enum<CopilotResult> {
    private static final /* synthetic */ CopilotResult[] $VALUES = null;

    @SerializedName("1")
    public static final CopilotResult Success = null;

    @SerializedName("2")
    public static final CopilotResult SystemLimitation = null;

    @SerializedName("3")
    public static final CopilotResult UserLimitation = null;
    private final int value;

    static {
        CopilotResult r0 = new CopilotResult("Success", 0, 1);
        Success = r0;
        CopilotResult r1 = new CopilotResult("SystemLimitation", 1, 2);
        SystemLimitation = r1;
        CopilotResult r4 = new CopilotResult("UserLimitation", 2, 3);
        UserLimitation = r4;
        $VALUES = new CopilotResult[]{r0, r1, r4};
    }

    private CopilotResult(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static CopilotResult findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return UserLimitation;
    L13:
        return SystemLimitation;
    L15:
        return Success;
    }

    public static CopilotResult valueOf(String r2) {
        return (CopilotResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(CopilotResult.class, r2), CopilotResult.class, "com.obric.memorydata.plugin");
    }

    public static CopilotResult[] values() {
        return (CopilotResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CopilotResult[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
