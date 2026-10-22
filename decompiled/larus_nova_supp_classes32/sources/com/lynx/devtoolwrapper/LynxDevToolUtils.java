package com.lynx.devtoolwrapper;

import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxDevToolService;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevToolUtils {
    private static final ILynxDevToolService DEVTOOL_SERVICE = null;
    private static final String TAG = "LynxDevToolUtils";

    public LynxDevToolUtils() {
    }

    static {
        DEVTOOL_SERVICE = (ILynxDevToolService) n.c().a(ILynxDevToolService.class);
    }

    public static void setDevToolLibraryLoader(INativeLibraryLoader r1) {
        ILynxDevToolService r0 = DEVTOOL_SERVICE;
        if (r0 == null) goto L5;
        r0.devtoolEnvSetDevToolLibraryLoader(r1);
        return;
    L5:
        LLog.e(TAG, "failed to get DevToolService");
    }
}
