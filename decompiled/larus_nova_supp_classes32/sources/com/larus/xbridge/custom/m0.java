package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.service.AccountService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m0 extends bx7.c {
    public final String getName() {
        return "app.thirdPartyAuth";
    }

    public m0() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        String r6 = cx7.a.d(r3, "platform", NameKeys.UnloadStrategy_No_Strategy);
        switch(r6.hashCode()) {
            case -1325936172: goto L22;
            case -1240244679: goto L18;
            case -791575966: goto L14;
            case 3321844: goto L10;
            case 497130182: goto L6;
            default: goto L25;
        };
    L25:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put(LynxResourceModule.CODE_KEY, 0);
        r4.invoke(r7);
        return;
    L6:
        if (r6.equals("facebook") == false) goto L25;
        AccountService.a.g(3, new j0(r4), true);
        return;
    L10:
        if (r6.equals(SVGRenderEngine.LINE) == false) goto L25;
        AccountService.a.g(4, new k0(r4), true);
        return;
    L14:
        if (r6.equals("weixin") == false) goto L25;
        AccountService.a.g(5, new l0(r4), true);
        return;
    L18:
        if (r6.equals("google") == false) goto L25;
        AccountService.a.g(2, new i0(r4), true);
        return;
    L22:
        if (r6.equals("douyin") == false) goto L25;
        AccountService.a.g(1, new h0(r4), false);
    }
}
