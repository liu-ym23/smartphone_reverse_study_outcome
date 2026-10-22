package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.platform.service.AccountService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j0 implements com.larus.platform.api.d {
    public final /* synthetic */ IvyBridgeMethod.a a;

    public j0(ux7.d.d r1) {
        this.a = r1;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        f4a.a r0 = new f4a.a();
        Intrinsics.checkNotNullParameter("facebook", "<set-?>");
        r0.a = "facebook";
        String r1 = AccountService.a.m();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.e = r5;
        IvyBridgeMethod.a r6 = this.a;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put(LynxResourceModule.CODE_KEY, 1);
        r2.put(LynxResourceModule.DATA_KEY, f4a.a.C0089a.a(r0));
        r6.invoke(r2);
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        IvyBridgeMethod.a r5 = this.a;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(LynxResourceModule.CODE_KEY, 0);
        r5.invoke(r0);
    }
}
