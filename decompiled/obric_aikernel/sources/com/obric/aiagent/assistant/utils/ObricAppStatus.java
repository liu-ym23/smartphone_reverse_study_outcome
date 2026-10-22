package com.obric.aiagent.assistant.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ObricAppStatus extends Enum<ObricAppStatus> {
    private static final /* synthetic */ ObricAppStatus[] $VALUES = null;
    public static final ObricAppStatus AppDisabledError = null;
    public static final ObricAppStatus NoInstalledError = null;
    public static final ObricAppStatus NotRoleAssistant = null;
    public static final ObricAppStatus PrivacyNotApprovalError = null;
    public static final ObricAppStatus PrivacyNotObtainError = null;
    public static final ObricAppStatus Success = null;
    public static final ObricAppStatus Unknown = null;
    public static final ObricAppStatus UserNoLogin = null;
    private final int errorCode;
    private final String errorMessage;

    private static final /* synthetic */ ObricAppStatus[] $values() {
        return new ObricAppStatus[]{Success, Unknown, NoInstalledError, AppDisabledError, PrivacyNotApprovalError, PrivacyNotObtainError, UserNoLogin, NotRoleAssistant};
    }

    static {
        Success = new ObricAppStatus("Success", 0, 0, "success");
        Unknown = new ObricAppStatus("Unknown", 1, -1, "unknown");
        NoInstalledError = new ObricAppStatus("NoInstalledError", 2, 1, "noInstalled");
        AppDisabledError = new ObricAppStatus("AppDisabledError", 3, 2, "appDisabled");
        PrivacyNotApprovalError = new ObricAppStatus("PrivacyNotApprovalError", 4, 3, "PrivacyNotApproval");
        PrivacyNotObtainError = new ObricAppStatus("PrivacyNotObtainError", 5, 4, "PrivacyNotObtainOrTimeout");
        UserNoLogin = new ObricAppStatus("UserNoLogin", 6, 5, "noLogin");
        NotRoleAssistant = new ObricAppStatus("NotRoleAssistant", 7, 6, "NotRoleAssistant");
        $VALUES = $values();
    }

    private ObricAppStatus(String r10, int r11, int r12, String r13) {
        super(r10, r11);
        this.errorCode = r12;
        this.errorMessage = r13;
    }

    public static ObricAppStatus valueOf(String r10) {
        return (ObricAppStatus) Enum.valueOf(ObricAppStatus.class, r10);
    }

    public static ObricAppStatus[] values() {
        return (ObricAppStatus[]) $VALUES.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
