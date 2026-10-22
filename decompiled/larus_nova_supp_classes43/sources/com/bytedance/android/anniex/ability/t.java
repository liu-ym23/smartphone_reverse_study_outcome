package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public t() {
    }

    public static final String a(AnnieXWebKit r10, String r11) {
        ArgusWebDelegateAdapter r12 = r10.C;
        if (r12 == null) goto L22;
        ArgusWebDelegate r13 = r12.a;
        if (r13 == null) goto L23;
        com.bytedance.ies.argus.aspect.eventCenter.i r14 = r13.c;
        if (r14 == null) goto L24;
        com.bytedance.ies.argus.aspect.eventCenter.c r15 = r14.t;
        if (r15 == null) goto L25;
        String r1 = "";
        if (r11 != null) goto L13;
        String r16 = "";
    L14:
        String r17 = r15.b(r16);
        if (r17 != null) goto L20;
        if (r11 == null) goto L19;
        r1 = r11;
    L19:
        r17 = r15.a(r1);
    L20:
        ExecutorService r18 = BulletLogger.a;
        BulletLogger.k("XBridgeWebHelper, generateBridgeAuthTokenForClientSideCall, url=" + r11 + ", token=" + r17, null, null, 6);
        return r17;
    L13:
        r16 = r11;
        goto L14
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    }
}
