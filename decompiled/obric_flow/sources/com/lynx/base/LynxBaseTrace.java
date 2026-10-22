package com.lynx.base;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.service.ILynxTraceService;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public class LynxBaseTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9719a = false;

    public static void a() {
        ILynxTraceService r5 = (ILynxTraceService) r.g().e(ILynxTraceService.class);
        if (r5 != null) goto L6;
        nativeInitBaseTrace(0);
        LynxLog.b(2, "LynxBaseTrace", "LynxBaseTrace init successfully by itself.");
        return;
    L6:
        long r10 = r5.getDefaultTraceFunction();
        if (r10 == 0) goto L10;
        nativeInitBaseTrace(r10);
        LynxLog.b(2, "LynxBaseTrace", "LynxBaseTrace init successfully by custom LynxBaseTraceService. function native address is " + r10);
        return;
    L10:
        LynxLog.b(2, "LynxBaseTrace", "failed to init LynxBaseTrace dependency");
    }

    private static native void nativeInitBaseTrace(long r5);
}
