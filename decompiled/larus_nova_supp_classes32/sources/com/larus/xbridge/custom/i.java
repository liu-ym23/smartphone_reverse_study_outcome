package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements n38.m {
    public final /* synthetic */ IvyBridgeMethod.a a;

    public i(ux7.d.d r1) {
        this.a = r1;
    }

    public final void onSuccess(String r5) {
        IvyBridgeMethod.a r6 = this.a;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("success", 1);
        Unit r1 = Unit.INSTANCE;
        r0.put(LynxResourceModule.DATA_KEY, r2);
        r6.invoke(r0);
    }

    public final void a(int r4, String r5, String r6, String r7) {
        FLogger.a.i("AppBindPlatformMethod", "bindPlatform onFailed, errorCode = " + r4 + ", errorMsg = " + r5);
        IvyBridgeMethod.a r8 = this.a;
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("success", 0);
        r0.put("errorCode", Integer.valueOf(r4));
        if (r5 == null) goto L5;
        r0.put("errorMsg", r5);
    L5:
        Unit r10 = Unit.INSTANCE;
        r9.put(LynxResourceModule.DATA_KEY, r0);
        r8.invoke(r9);
    }
}
