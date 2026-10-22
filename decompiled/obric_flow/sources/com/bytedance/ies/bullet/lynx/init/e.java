package com.bytedance.ies.bullet.lynx.init;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements AttachUserData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5676a = null;

    static {
        f5676a = new e();
    }

    @Override // com.bytedance.crash.AttachUserData
    public final Map getUserData(CrashType r5) {
        HashMap r10 = new HashMap();
        String r11 = LynxEnv.inst().getLastUrl();
        if (r11 != null) goto L5;
        r11 = "no lynx url";
    L5:
        r10.put("last_lynx_url", r11);
        r10.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        return r10;
    }
}
