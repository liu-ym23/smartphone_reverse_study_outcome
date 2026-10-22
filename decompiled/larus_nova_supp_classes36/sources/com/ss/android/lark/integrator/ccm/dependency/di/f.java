package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.dto.DocAppUserConfig;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements ao4.c {
    public final Map<a, tpb.b> a;

    public interface a {
    }

    public final ao4.a b() {
        ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).checkAndInit();     // Catch: Exception -> L9
        DocAppUserConfig r2 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).c();     // Catch: Exception -> L9
        if (r2.getUrlRegex().isEmpty() == false) goto L8;
        tt5.a.h("AppUserConfigAgentImpl", "update url regex fail url regex is empty");     // Catch: Exception -> L9
        return null;
    L8:
        return new ao4.a(r2.getUrlRegex(), jcb.b.c().a("passport"));
    L9:
        e = move-exception;
        tt5.a.f("AppUserConfigAgentImpl", e, false);
        return null;
    }

    public f() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(ra5.e r3) {
        d r0 = new d(r3);
        e r4 = new e(r0);
        ((ConcurrentHashMap) this.a).put(r0, r4);
        Map<tpb.b, Object> r1 = com.ss.android.lark.larkconfig.userconfig.e.a.a.d;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(r4, new Object());
    }
}
