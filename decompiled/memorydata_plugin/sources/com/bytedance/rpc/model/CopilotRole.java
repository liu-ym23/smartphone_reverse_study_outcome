package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CopilotRole extends Enum<CopilotRole> {
    private static final /* synthetic */ CopilotRole[] $VALUES = null;

    @SerializedName("2")
    public static final CopilotRole Assistant = null;

    @SerializedName("6")
    public static final CopilotRole Function = null;

    @SerializedName("4")
    public static final CopilotRole LLMOutput = null;

    @SerializedName("3")
    public static final CopilotRole Placeholder = null;

    @SerializedName("0")
    public static final CopilotRole System = null;

    @SerializedName("5")
    public static final CopilotRole ToolOutput = null;

    @SerializedName("1")
    public static final CopilotRole User = null;
    private final int value;

    static {
        CopilotRole r0 = new CopilotRole("System", 0, 0);
        System = r0;
        CopilotRole r1 = new CopilotRole("User", 1, 1);
        User = r1;
        CopilotRole r3 = new CopilotRole("Assistant", 2, 2);
        Assistant = r3;
        CopilotRole r5 = new CopilotRole("Placeholder", 3, 3);
        Placeholder = r5;
        CopilotRole r7 = new CopilotRole("LLMOutput", 4, 4);
        LLMOutput = r7;
        CopilotRole r9 = new CopilotRole("ToolOutput", 5, 5);
        ToolOutput = r9;
        CopilotRole r11 = new CopilotRole("Function", 6, 6);
        Function = r11;
        $VALUES = new CopilotRole[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private CopilotRole(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static CopilotRole findByValue(int r0) {
        switch(r0) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return Function;
    L8:
        return ToolOutput;
    L10:
        return LLMOutput;
    L12:
        return Placeholder;
    L14:
        return Assistant;
    L16:
        return User;
    L18:
        return System;
    }

    public static CopilotRole valueOf(String r2) {
        return (CopilotRole) ZeusTransformUtils.preCheckCast(Enum.valueOf(CopilotRole.class, r2), CopilotRole.class, "com.obric.memorydata.plugin");
    }

    public static CopilotRole[] values() {
        return (CopilotRole[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CopilotRole[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
