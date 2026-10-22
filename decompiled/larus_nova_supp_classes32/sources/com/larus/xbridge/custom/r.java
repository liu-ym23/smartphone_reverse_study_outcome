package com.larus.xbridge.custom;

import android.app.Activity;
import android.app.Application;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.LoginService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.logout";
    }

    public r() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        AppHost.Companion r6 = AppHost.a;
        Activity r0 = r6.a().getCurrentActivity();
        if (r0 != null) goto L5;
    L12:
        t19.s r7 = t19.s.a;
        Application r8 = r6.getApplication();
        r7.getClass();
        t19.s.s(r8, 2131910343);
        FLogger.a.e("AppLogoutMethod", "current activity " + r0 + " is illegal, Abort.");
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put(LynxResourceModule.CODE_KEY, 0);
        r4.invoke(r9);
        return;
    L5:
        if (r0.isFinishing() == true) goto L12;
        if (r0.isDestroyed() == true) goto L12;
        if (cx7.a.c(r3, "logoutType") != 1) goto L11;
        LoginService.a.H(r0, "logout_by_jsb_app_logout_method", new s(r4));
        return;
    L11:
        LoginService.a.o(r0, "logout_by_jsb_app_logout_method", new t(r4));
    }
}
