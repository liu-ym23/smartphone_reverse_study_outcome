package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.service.AccountService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.getLocalLoginChannel";
    }

    public n() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("login_channel_list", AccountService.a.q());
        Unit r0 = Unit.INSTANCE;
        r6.put(LynxResourceModule.DATA_KEY, r7);
        r4.invoke(r6);
    }
}
