package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    static {
    }

    public static void a() {
        ConcurrentHashMap r0 = com.ss.android.lark.security.compliance.infra.util.c.a;
        Boolean r2 = (Boolean) r0.get("lark.security.screenshot-protection_enabled_doubao");
        if (r2 != null) goto L5;
        boolean r3 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.security.screenshot-protection_enabled_doubao");
        r0.put("lark.security.screenshot-protection_enabled_doubao", Boolean.valueOf(r3));
    L6:
        int r1 = ScsLogger.a;
        ScsLogger.d("FGAction", "executeFG lark.security.screenshot-protection_enabled_doubao, value: " + r3);
        if (r3 == false) goto L9;
        ((com.ss.android.lark.screenprotect.userscope.a) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.screenprotect.userscope.a.class)).init();
        return;
    L9:
        ScsLogger.d("OfficeSDKScreenProtectModule", "Doubao FG off, skip init");
        return;
    L5:
        r3 = r2.booleanValue();
        goto L6
    }
}
