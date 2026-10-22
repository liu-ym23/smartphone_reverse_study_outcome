package com.obric.aiagent.assistant.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatus;", "", "errorCode", "", "errorMessage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "Success", "Unknown", "NoInstalledError", "AppDisabledError", "PrivacyNotApprovalError", "PrivacyNotObtainError", "UserNoLogin", "NotRoleAssistant", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ObricAppStatus extends Enum<ObricAppStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
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
        ObricAppStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ObricAppStatus(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.errorCode = r3;
        this.errorMessage = r4;
    }

    public static EnumEntries<ObricAppStatus> getEntries() {
        return $ENTRIES;
    }

    public static ObricAppStatus valueOf(String r2) {
        return (ObricAppStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(ObricAppStatus.class, r2), ObricAppStatus.class, "com.obric.memorydata.plugin");
    }

    public static ObricAppStatus[] values() {
        return (ObricAppStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ObricAppStatus[].class, "com.obric.memorydata.plugin");
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
