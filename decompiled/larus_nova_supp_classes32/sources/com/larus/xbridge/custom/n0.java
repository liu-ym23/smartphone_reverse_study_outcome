package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n0 extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.unbindPlatform";
    }

    public n0() {
    }

    public final void a(dx7.b r9, ux7.d.d r10, IvyBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        String r12 = cx7.a.d(r9, "platform", NameKeys.UnloadStrategy_No_Strategy);
        int r13 = r12.hashCode();
        if (r13 == (-1325936172)) goto L20;
        if (r13 != (-791575966)) goto L7;
        String r14 = "weixin";
        if (r12.equals("weixin") == true) goto L16;
    L21:
        FLogger.a.e("AppUnbindPlatformMethod", "unsupported platform");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put(LynxResourceModule.CODE_KEY, -3);
        r10.invoke(r15);
        return;
    L16:
        if (ILoginService.a.C(LoginPlatform.WEIXIN) == true) goto L28;
        FLogger.a.i("AppUnbindPlatformMethod", "unsupported platform");
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("success", 0);
        Unit r0 = Unit.INSTANCE;
        r16.put(LynxResourceModule.DATA_KEY, r17);
        r10.invoke(r16);
        return;
    L28:
        ILoginService.a.e(r14, new o0(r10));
        return;
    L7:
        if (r13 != 93029210) goto L21;
        r14 = "apple";
        if (r12.equals("apple") == true) goto L28;
    L20:
        if (r12.equals("douyin") == false) goto L21;
        if (ILoginService.a.C(LoginPlatform.DOUYIN) == true) goto L27;
        FLogger.a.i("AppUnbindPlatformMethod", "unsupported platform");
        LinkedHashMap r18 = new LinkedHashMap();
        r18.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("success", 0);
        Unit r1 = Unit.INSTANCE;
        r18.put(LynxResourceModule.DATA_KEY, r19);
        r10.invoke(r18);
        return;
    L27:
        r14 = "aweme_v2";
        goto L28
    }
}
