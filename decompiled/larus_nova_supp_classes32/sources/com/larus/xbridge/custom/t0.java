package com.larus.xbridge.custom;

import com.larus.account.base.model.AuthorizationPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t0 extends s0 {
    public t0() {
    }

    @Override // com.larus.xbridge.custom.s0
    public final Map<String, Object> f(cx7.d r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformAuthorizationProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((IThirdPartyPlatformAuthorizationProvider) r1).c() != AuthorizationPlatform.LARK) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        IThirdPartyPlatformAuthorizationProvider r3 = (IThirdPartyPlatformAuthorizationProvider) r1;
        if (r3 != null) goto L15;
        FLogger.a.w("BizUtilAuthorization", "authorization provider unavailable, method=" + this.b);
    L15:
        if (r3 == null) goto L17;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        String r6 = cx7.a.d(r5, "method", NameKeys.UnloadStrategy_No_Strategy);
        if (r6 != null) goto L21;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        String r7 = cx7.a.d(r5, LynxEventReporter.PROP_NAME_URL, NameKeys.UnloadStrategy_No_Strategy);
        if (r7 == null) goto L25;
        r4 = r7;
    L25:
        Map r8 = IThirdPartyPlatformAuthorizationProvider.a.a(r3, r6, r4, 12);
        LinkedHashMap r9 = new LinkedHashMap();
        r9.putAll(r8);
        Lazy r10 = com.larus.network.m.a;
        String r11 = com.larus.network.m.a().d;
        if (AppHost.a.isDebug() == true) goto L28;
    L30:
        return r9;
    L28:
        if (com.larus.utils.o0.d(r11) == false) goto L30;
        r9.put("x-tt-env", r11);
        r9.put("env", "pre_release");
        goto L30
    L17:
        return MapsKt.emptyMap();
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }
}
