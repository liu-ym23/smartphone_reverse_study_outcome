package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ContextContentType extends Enum<ContextContentType> {
    private static final /* synthetic */ ContextContentType[] $VALUES = null;

    @SerializedName("1")
    public static final ContextContentType USER_LLM_RES = null;

    @SerializedName("4")
    public static final ContextContentType USER_LLM_TOOL = null;

    @SerializedName("2")
    public static final ContextContentType USER_LLM_TOOLLEN_RES = null;

    @SerializedName("3")
    public static final ContextContentType USER_LLM_TOOL_RES = null;

    @SerializedName("0")
    public static final ContextContentType USER_RES = null;
    private final int value;

    static {
        ContextContentType r0 = new ContextContentType("USER_RES", 0, 0);
        USER_RES = r0;
        ContextContentType r1 = new ContextContentType("USER_LLM_RES", 1, 1);
        USER_LLM_RES = r1;
        ContextContentType r3 = new ContextContentType("USER_LLM_TOOLLEN_RES", 2, 2);
        USER_LLM_TOOLLEN_RES = r3;
        ContextContentType r5 = new ContextContentType("USER_LLM_TOOL_RES", 3, 3);
        USER_LLM_TOOL_RES = r5;
        ContextContentType r7 = new ContextContentType("USER_LLM_TOOL", 4, 4);
        USER_LLM_TOOL = r7;
        $VALUES = new ContextContentType[]{r0, r1, r3, r5, r7};
    }

    private ContextContentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ContextContentType findByValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return USER_LLM_TOOL;
    L16:
        return USER_LLM_TOOL_RES;
    L18:
        return USER_LLM_TOOLLEN_RES;
    L20:
        return USER_LLM_RES;
    L22:
        return USER_RES;
    }

    public static ContextContentType valueOf(String r2) {
        return (ContextContentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextContentType.class, r2), ContextContentType.class, "com.obric.memorydata.plugin");
    }

    public static ContextContentType[] values() {
        return (ContextContentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextContentType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
