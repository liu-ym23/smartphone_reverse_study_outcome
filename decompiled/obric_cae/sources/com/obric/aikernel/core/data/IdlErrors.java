package com.obric.aikernel.core.data;

import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import l6.a;
import xd.d;

/* JADX INFO: loaded from: classes.dex */
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
    public static final IdlErrors INSTANCE = null;
    public static final int S_NOT_FINISH = 1;
    public static final int S_OK = 0;
    private static final Map<Integer, String> defaultErrInfo = null;

    static {
        INSTANCE = new IdlErrors();
        d[] r8 = {new d(106, "invalid method name"), new d(101, "invalid argument"), new d(102, "binder is not ready, or disconnected.")};
        LinkedHashMap r10 = new LinkedHashMap(a.n0(3));
        int r11 = 0;
    L3:
        if (r11 >= 3) goto L5;
        d r12 = r8[r11];
        r10.put(r12.f13867a, r12.f13868b);
        r11 = r11 + 1;
        goto L3
    L5:
        defaultErrInfo = r10;
    }

    private IdlErrors() {
    }

    public final Map<Integer, String> getDefaultErrInfo() {
        return defaultErrInfo;
    }

    public final String toString(int r8) {
        if (r8 != 0) goto L4;
        return "ipc] succeed";
    L4:
        if (r8 != 1) goto L6;
        return "ipc] still ongoing";
    L6:
        if (r8 != 102) goto L8;
        return "ipc] get binder failed";
    L8:
        if (r8 != 200) goto L10;
        return "press] unknown package";
    L10:
        if (r8 == 201) goto L19;
        switch(r8) {
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
