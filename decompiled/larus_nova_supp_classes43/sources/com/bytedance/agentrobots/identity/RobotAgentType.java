package com.bytedance.agentrobots.identity;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final enum RobotAgentType extends Enum<RobotAgentType> {
    public static final RobotAgentType ASSISTIVE = null;
    public static final RobotAgentType AUTONOMOUS = null;
    public static final RobotAgentType RECORDING = null;
    public static final RobotAgentType SUGGESTIVE = null;
    public static final /* synthetic */ RobotAgentType[] a = null;

    static {
        RobotAgentType r0 = new RobotAgentType("RECORDING", 0);
        RECORDING = r0;
        RobotAgentType r1 = new RobotAgentType("SUGGESTIVE", 1);
        SUGGESTIVE = r1;
        RobotAgentType r10 = new RobotAgentType("ASSISTIVE", 2);
        ASSISTIVE = r10;
        RobotAgentType r11 = new RobotAgentType("AUTONOMOUS", 3);
        AUTONOMOUS = r11;
        a = new RobotAgentType[]{r0, r1, r10, r11};
    }

    public static RobotAgentType[] values() {
        return (RobotAgentType[]) a.clone();
    }

    public static RobotAgentType valueOf(String r1) {
        return (RobotAgentType) a.a(RobotAgentType.class, r1);
    }

    public RobotAgentType(String r1, int r10) {
        super(r1, r10);
    }
}
