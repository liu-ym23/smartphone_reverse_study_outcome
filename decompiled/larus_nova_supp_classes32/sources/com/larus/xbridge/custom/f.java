package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends bx7.c {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.bindPlatform";
    }

    public f() {
    }

    public final void a(dx7.b r8, ux7.d.d r9, IvyBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        String r11 = cx7.a.d(r8, "platform", NameKeys.UnloadStrategy_No_Strategy);
        if (Intrinsics.areEqual(r11, "douyin") == false) goto L6;
        ILoginService.a.d(ILoginService.a, LoginPlatform.DOUYIN, new h(r9, this), null, false, null, 28);
        return;
    L6:
        if (Intrinsics.areEqual(r11, "weixin") == false) goto L8;
        ILoginService.a.v(LoginPlatform.WEIXIN, new i(r9));
        return;
    L8:
        LinkedHashMap r12 = new LinkedHashMap();
        FLogger.a.e("AppBindPlatformMethod", "unsupported platform");
        r12.put(LynxResourceModule.CODE_KEY, -3);
        r9.invoke(r12);
    }
}
