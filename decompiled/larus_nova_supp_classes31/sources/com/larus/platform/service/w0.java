package com.larus.platform.service;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w0 {
    static {
    }

    public static String b() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        String r1 = null;
        if (r0 == null) goto L5;
        r0.i0();
        com.larus.home.impl.sdk.y r2 = com.larus.home.impl.sdk.y.a;
    L6:
        if (r2 == null) goto L8;
        r1 = r2.f();
    L8:
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1;
    L5:
        r2 = null;
        goto L6
    }

    public static Fragment a(Activity r2) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.i0();
        com.larus.home.impl.sdk.y r1 = com.larus.home.impl.sdk.y.a;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b(r2);
    L5:
        r1 = null;
        goto L6
    }
}
