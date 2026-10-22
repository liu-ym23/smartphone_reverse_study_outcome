package com.larus.bmhome.auth;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.utils.logger.FLogger;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h1 {
    public static final i1 a() {
        AuthModelDelegate r0 = AuthModelDelegate.b;
        c1 r1 = (c1) r0.a().getValue();
        String r2 = null;
        if (r1 == null) goto L5;
        h0 r3 = (h0) r1.d;
    L7:
        if (r3 == null) goto L12;
        String r5 = r3.h();
        TouristModeABParam r6 = r3.i();
        String r4 = r3.b();
        e r7 = (e) r0.y().getValue();
        if (r7 == null) goto L11;
        r2 = r7.a;
    L11:
        i1 r8 = new i1(r5, r6, r4, r2);
        FLogger.a.d("TouristModeConfig", "getTouristModeConfig from current launch info  " + r8);
        return r8;
    L12:
        i1 r9 = LaunchCacheDelegate.b.e();
        FLogger.a.d("TouristModeConfig", "getTouristModeConfig from cache  " + r9);
        return r9;
    L5:
        r3 = null;
        goto L7
    }
}
