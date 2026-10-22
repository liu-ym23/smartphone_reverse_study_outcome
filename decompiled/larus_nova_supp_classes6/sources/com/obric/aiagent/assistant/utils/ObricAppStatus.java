package com.obric.aiagent.assistant.utils;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatus;", "", "errorCode", "", "errorMessage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "Success", "Unknown", "NoInstalledError", "AppDisabledError", "PrivacyNotApprovalError", "PrivacyNotObtainError", "UserNoLogin", "NotRoleAssistant", "assistant-status-utils_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum ObricAppStatus extends Enum<ObricAppStatus> {
    public static final ObricAppStatus AppDisabledError = null;
    public static final ObricAppStatus NoInstalledError = null;
    public static final ObricAppStatus NotRoleAssistant = null;
    public static final ObricAppStatus PrivacyNotApprovalError = null;
    public static final ObricAppStatus PrivacyNotObtainError = null;
    public static final ObricAppStatus Success = null;
    public static final ObricAppStatus Unknown = null;
    public static final ObricAppStatus UserNoLogin = null;
    public static final /* synthetic */ ObricAppStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int errorCode;
    private final String errorMessage;

    public static EnumEntries<ObricAppStatus> getEntries() {
        return b;
    }

    static {
        ObricAppStatus r0 = new ObricAppStatus("Success", 0, 0, "success");
        Success = r0;
        ObricAppStatus r1 = new ObricAppStatus("Unknown", 1, -1, "unknown");
        Unknown = r1;
        ObricAppStatus r2 = new ObricAppStatus("NoInstalledError", 2, 1, "noInstalled");
        NoInstalledError = r2;
        ObricAppStatus r4 = new ObricAppStatus("AppDisabledError", 3, 2, "appDisabled");
        AppDisabledError = r4;
        ObricAppStatus r5 = new ObricAppStatus("PrivacyNotApprovalError", 4, 3, "PrivacyNotApproval");
        PrivacyNotApprovalError = r5;
        ObricAppStatus r8 = new ObricAppStatus("PrivacyNotObtainError", 5, 4, "PrivacyNotObtainOrTimeout");
        PrivacyNotObtainError = r8;
        ObricAppStatus r10 = new ObricAppStatus("UserNoLogin", 6, 5, "noLogin");
        UserNoLogin = r10;
        ObricAppStatus r12 = new ObricAppStatus("NotRoleAssistant", 7, 6, "NotRoleAssistant");
        NotRoleAssistant = r12;
        ObricAppStatus[] r14 = {r0, r1, r2, r4, r5, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static ObricAppStatus[] values() {
        return (ObricAppStatus[]) a.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public static ObricAppStatus valueOf(String r1) {
        return (ObricAppStatus) a.a(ObricAppStatus.class, r1);
    }

    public ObricAppStatus(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.errorCode = r3;
        this.errorMessage = r4;
    }
}
