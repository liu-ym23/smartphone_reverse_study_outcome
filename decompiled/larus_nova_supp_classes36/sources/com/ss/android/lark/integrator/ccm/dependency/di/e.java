package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.dto.DocAppUserConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements tpb.b {
    public final /* synthetic */ f.a a;

    @Override // tpb.b
    public final void a() {
        f.a r0 = this.a;
        if (r0 == null) goto L22;
        ra5.e r1 = ((d) r0).a;
        tt5.a.h("DocSdkProxy", "appconfig create ready");
        DocAppUserConfig r2 = ((com.bytedance.ee.bear.lark.dependency.k) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.k.class)).c();     // Catch: Exception -> L15
        if (r2.getUrlRegex().isEmpty() == false) goto L8;
        tt5.a.h("DocSdkProxy", "update url regex fail  url regex is empty");     // Catch: Exception -> L15
    L18:
        return;
    L8:
        Map r3 = r2.getUrlRegex();     // Catch: Exception -> L15
        String r4 = jcb.b.c().a("passport");     // Catch: Exception -> L15
        r1.a.getClass();     // Catch: Exception -> L15
        if (qa5.b.a() == false) goto L18;
        if (com.larksuite.framework.utils.z.e(eu5.b.a) == false) goto L18;
        s45.k.a().c(r3);     // Catch: Exception -> L15
        s45.k.a().b(r4);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        tt5.a.e("DocSdkProxy", "registerAppConfigReadyDependency() error : ", e, false);
        return;
    }

    public e(d r1) {
        this.a = r1;
    }
}
