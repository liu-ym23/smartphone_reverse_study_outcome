package com.obric.aiagent.assistant.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum DefaultAssistantStatus extends Enum<DefaultAssistantStatus> {
    private static final /* synthetic */ DefaultAssistantStatus[] $VALUES = null;
    public static final DefaultAssistantStatus IsDefaultAssistant = null;
    public static final DefaultAssistantStatus NotDefaultAssistant = null;
    public static final DefaultAssistantStatus Unknown = null;
    private final int errorCode;
    private final String errorMessage;

    private static final /* synthetic */ DefaultAssistantStatus[] $values() {
        return new DefaultAssistantStatus[]{Unknown, IsDefaultAssistant, NotDefaultAssistant};
    }

    static {
        Unknown = new DefaultAssistantStatus("Unknown", 0, -1, "unknown");
        IsDefaultAssistant = new DefaultAssistantStatus("IsDefaultAssistant", 1, 0, "isDefaultAssistant");
        NotDefaultAssistant = new DefaultAssistantStatus("NotDefaultAssistant", 2, 1, "notDefaultAssistant");
        $VALUES = $values();
    }

    private DefaultAssistantStatus(String r10, int r11, int r12, String r13) {
        super(r10, r11);
        this.errorCode = r12;
        this.errorMessage = r13;
    }

    public static DefaultAssistantStatus valueOf(String r10) {
        return (DefaultAssistantStatus) Enum.valueOf(DefaultAssistantStatus.class, r10);
    }

    public static DefaultAssistantStatus[] values() {
        return (DefaultAssistantStatus[]) $VALUES.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
