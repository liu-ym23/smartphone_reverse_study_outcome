package com.obric.aikernel.core.log;

import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import defpackage.b;
import he.i;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class AIKLog implements ILog {
    public static final AIKLog INSTANCE = null;
    private static final boolean NEED_PREFIX = true;
    private static final String TAG_PREFIX = "AIK_Client_";
    private static ILog logInst;

    static {
        INSTANCE = new AIKLog();
    }

    private AIKLog() {
    }

    private final String logTag(String r8) {
        return b.c(TAG_PREFIX, r8);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void d(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        ILog r11 = logInst;
        String r12 = logTag(r8);
        if (r11 == null) goto L5;
        r11.d(r12, r10);
        return;
    L5:
        Log.d(r12, r10);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void e(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        ILog r11 = logInst;
        String r12 = logTag(r8);
        if (r11 == null) goto L5;
        r11.e(r12, r10);
        return;
    L5:
        Log.e(r12, r10);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void i(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        ILog r11 = logInst;
        String r12 = logTag(r8);
        if (r11 == null) goto L5;
        r11.i(r12, r10);
        return;
    L5:
        Log.i(r12, r10);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public boolean isDebug() {
        return true;
    }

    public final void registerLog(ILog r8) {
        i.f(r8, "inst");
        logInst = r8;
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void v(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        ILog r11 = logInst;
        String r12 = logTag(r8);
        if (r11 == null) goto L5;
        r11.v(r12, r10);
        return;
    L5:
        Log.v(r12, r10);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void w(String r8, String r10) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        ILog r11 = logInst;
        String r12 = logTag(r8);
        if (r11 == null) goto L5;
        r11.w(r12, r10);
        return;
    L5:
        Log.w(r12, r10);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void e(String r8, String r10, Throwable r11) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        i.f(r11, "t");
        ILog r12 = logInst;
        String r13 = logTag(r8);
        if (r12 == null) goto L5;
        r12.e(r13, r10, r11);
        return;
    L5:
        Log.e(r13, r10, r11);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void w(String r8, String r10, Throwable r11) {
        i.f(r8, LocationMonitorConst.TAG);
        i.f(r10, "msg");
        i.f(r11, "t");
        ILog r12 = logInst;
        String r13 = logTag(r8);
        if (r12 == null) goto L5;
        r12.w(r13, r10, r11);
        return;
    L5:
        Log.w(r13, r10, r11);
    }
}
