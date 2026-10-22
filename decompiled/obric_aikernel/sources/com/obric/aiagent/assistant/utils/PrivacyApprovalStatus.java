package com.obric.aiagent.assistant.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PrivacyApprovalStatus extends Enum<PrivacyApprovalStatus> {
    private static final /* synthetic */ PrivacyApprovalStatus[] $VALUES = null;
    public static final PrivacyApprovalStatus Approved = null;
    public static final PrivacyApprovalStatus CannotObtain = null;
    public static final PrivacyApprovalStatus NotApproved = null;
    public static final PrivacyApprovalStatus Timeout = null;

    private static final /* synthetic */ PrivacyApprovalStatus[] $values() {
        return new PrivacyApprovalStatus[]{CannotObtain, Timeout, NotApproved, Approved};
    }

    static {
        CannotObtain = new PrivacyApprovalStatus("CannotObtain", 0);
        Timeout = new PrivacyApprovalStatus("Timeout", 1);
        NotApproved = new PrivacyApprovalStatus("NotApproved", 2);
        Approved = new PrivacyApprovalStatus("Approved", 3);
        $VALUES = $values();
    }

    private PrivacyApprovalStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static PrivacyApprovalStatus valueOf(String r10) {
        return (PrivacyApprovalStatus) Enum.valueOf(PrivacyApprovalStatus.class, r10);
    }

    public static PrivacyApprovalStatus[] values() {
        return (PrivacyApprovalStatus[]) $VALUES.clone();
    }
}
