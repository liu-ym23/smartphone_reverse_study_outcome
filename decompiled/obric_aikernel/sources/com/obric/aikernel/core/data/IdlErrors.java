package com.obric.aikernel.core.data;

import androidx.annotation.Keep;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
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

    public final String toString(int r10) {
        if (r10 != 0) goto L4;
        return "ipc] succeed";
    L4:
        if (r10 != 1) goto L6;
        return "ipc] still ongoing";
    L6:
        if (r10 != 102) goto L8;
        return "ipc] get binder failed";
    L8:
        if (r10 != 200) goto L10;
        return "press] unknown package";
    L10:
        if (r10 == 201) goto L19;
        switch(r10) {
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
