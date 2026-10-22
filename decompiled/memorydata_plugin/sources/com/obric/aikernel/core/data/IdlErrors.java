package com.obric.aikernel.core.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/obric/aikernel/core/data/IdlErrors;", "", "()V", "E_BinderDied", "", "E_BinderNotReady", "E_BotReqError", "E_CANCELED", "E_CallRejectedByDebugIntercept", "E_DecodeFileError", "E_DoNotSupportVersion", "E_DownloadFailed", "E_HangAndRetry", "E_InstalledModelDecryptFailed", "E_InvalidArgument", "E_InvalidMethod", "E_InvalidModelType", "E_InvalidResult", "E_ModelRunFailed", "E_NetworkException", "E_NetworkNotActive", "E_PackNotAvailable", "E_PackNotFound", "E_PackResNotReady", "E_PresetModelDecryptFailed", "E_RejectInferDeviceOverheat", "E_RejectInferDuePower", "E_RejectInferDueQuota", "E_RuntimeDecryptFailed", "E_TimeOut", "E_UNNAMED_EXCEPTION", "E_UpdateFailed", "E_VLM_LOAD_FAILED", "S_NOT_FINISH", "S_OK", "defaultErrInfo", "", "", "getDefaultErrInfo", "()Ljava/util/Map;", "toString", "code", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IdlErrors {
    public static final int E_BinderDied = 113;
    public static final int E_BinderNotReady = 102;
    public static final int E_BotReqError = 110;
    public static final int E_CANCELED = 501;
    public static final int E_CallRejectedByDebugIntercept = 404;
    public static final int E_DecodeFileError = 10005;
    public static final int E_DoNotSupportVersion = 111;
    public static final int E_DownloadFailed = 104;
    public static final int E_HangAndRetry = 405;
    public static final int E_InstalledModelDecryptFailed = 203;
    public static final int E_InvalidArgument = 101;
    public static final int E_InvalidMethod = 106;
    public static final int E_InvalidModelType = 103;
    public static final int E_InvalidResult = 108;
    public static final int E_ModelRunFailed = 105;
    public static final int E_NetworkException = -1;
    public static final int E_NetworkNotActive = -200;
    public static final int E_PackNotAvailable = 201;
    public static final int E_PackNotFound = 200;
    public static final int E_PackResNotReady = 109;
    public static final int E_PresetModelDecryptFailed = 202;
    public static final int E_RejectInferDeviceOverheat = 119;
    public static final int E_RejectInferDuePower = 121;
    public static final int E_RejectInferDueQuota = 120;
    public static final int E_RuntimeDecryptFailed = 204;
    public static final int E_TimeOut = 107;
    public static final int E_UNNAMED_EXCEPTION = 500;
    public static final int E_UpdateFailed = 104;
    public static final int E_VLM_LOAD_FAILED = 2300;
    public static final IdlErrors INSTANCE = null;
    public static final int S_NOT_FINISH = 1;
    public static final int S_OK = 0;
    private static final Map<Integer, String> defaultErrInfo = null;

    static {
        INSTANCE = new IdlErrors();
        defaultErrInfo = MapsKt.mapOf(new Pair[]{TuplesKt.to(106, "invalid method name"), TuplesKt.to(101, "invalid argument"), TuplesKt.to(102, "binder is not ready, or disconnected.")});
    }

    private IdlErrors() {
    }

    public final Map<Integer, String> getDefaultErrInfo() {
        return defaultErrInfo;
    }

    public final String toString(int r1) {
        if (r1 != 0) goto L4;
        return "ipc] succeed";
    L4:
        if (r1 != 1) goto L6;
        return "ipc] still ongoing";
    L6:
        if (r1 != 102) goto L8;
        return "ipc] get binder failed";
    L8:
        if (r1 != 200) goto L10;
        return "press] unknown package";
    L10:
        if (r1 == 201) goto L19;
        switch(r1) {
            case 104: goto L18;
            case 105: goto L17;
            case 106: goto L16;
            case 107: goto L15;
            case 108: goto L14;
            case 109: goto L13;
            default: goto L12;
        };
    L12:
        return "";
    L13:
        return "press] package res not complete";
    L14:
        return "ipc] call succeed but result is illegal";
    L15:
        return "ipc] timeout";
    L16:
        return "ipc] call unknown method";
    L17:
        return "runtime] run package failed";
    L18:
        return "press] update package failed";
    L19:
        return "press] package is not available";
    }
}
