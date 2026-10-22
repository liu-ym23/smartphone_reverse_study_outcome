package com.bytedance.agentrobots.audit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
final enum AgentSecurityLogger$PayloadMode extends Enum<AgentSecurityLogger$PayloadMode> {
    public static final AgentSecurityLogger$PayloadMode DISABLED = null;
    public static final AgentSecurityLogger$PayloadMode ENCRYPTED_ONLY = null;
    public static final AgentSecurityLogger$PayloadMode RAW_AND_ENCRYPTED = null;
    public static final AgentSecurityLogger$PayloadMode RAW_ONLY = null;
    public static final /* synthetic */ AgentSecurityLogger$PayloadMode[] a = null;

    static {
        AgentSecurityLogger$PayloadMode r0 = new AgentSecurityLogger$PayloadMode("RAW_AND_ENCRYPTED", 0);
        RAW_AND_ENCRYPTED = r0;
        AgentSecurityLogger$PayloadMode r1 = new AgentSecurityLogger$PayloadMode("RAW_ONLY", 1);
        RAW_ONLY = r1;
        AgentSecurityLogger$PayloadMode r10 = new AgentSecurityLogger$PayloadMode("ENCRYPTED_ONLY", 2);
        ENCRYPTED_ONLY = r10;
        AgentSecurityLogger$PayloadMode r11 = new AgentSecurityLogger$PayloadMode("DISABLED", 3);
        DISABLED = r11;
        a = new AgentSecurityLogger$PayloadMode[]{r0, r1, r10, r11};
    }

    public static AgentSecurityLogger$PayloadMode[] values() {
        return (AgentSecurityLogger$PayloadMode[]) a.clone();
    }

    public static AgentSecurityLogger$PayloadMode valueOf(String r1) {
        return (AgentSecurityLogger$PayloadMode) r27.a.a(AgentSecurityLogger$PayloadMode.class, r1);
    }

    public AgentSecurityLogger$PayloadMode(String r1, int r10) {
        super(r1, r10);
    }
}
