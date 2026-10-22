package com.larus.voicecall.impl.utils;

import com.bytedance.keva.Keva;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.i3;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s {
    public static final Keva a = null;
    public static final Keva b = null;

    public static final boolean a() {
        Pair<Boolean, Boolean> r0 = com.larus.voicecall.impl.l.i;
        if (i3.a.i() == false) goto L13;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L9;
        r1.getAccountService();
        if (com.larus.home.impl.sdk.d.a.M() != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r2 = false;
        goto L10
    L13:
        return false;
    }

    static {
        a = Keva.getRepo("tourist_real_time_call_limit");
        b = Keva.getRepo("audio_debug");
    }
}
