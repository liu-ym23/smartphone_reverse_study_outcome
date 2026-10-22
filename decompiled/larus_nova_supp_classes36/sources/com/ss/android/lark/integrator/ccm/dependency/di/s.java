package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.bear.dto.DocAppUserConfig;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements com.bytedance.ee.bear.lark.dependency.k {
    public s() {
    }

    public final DocAppUserConfig b() {
        tpb.a r0 = com.ss.android.lark.larkconfig.userconfig.e.a.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new DocAppUserConfig(r0.a(), r0.b());
    }

    public final DocAppUserConfig c() {
        DocAppUserConfig r0 = new DocAppUserConfig();
        tpb.a r1 = com.ss.android.lark.larkconfig.userconfig.e.a.a.a();
        if (r1 == null) goto L5;
        List<String> r2 = r1.a();
        Map<Integer, String> r3 = r1.b();
        r0.setDocDomains(r2);
        r0.setUrlRegex(r3);
    L6:
        return r0;
    L5:
        tt5.a.k("EnvDependencyImpl", "getCachedDocsDomainsConfig() appUserConfig is null");
        goto L6
    }

    public final boolean d() {
        if (PackageChannelManager.isKABuildPackage(getContext()) == true) goto L5;
    L7:
        return false;
    L5:
        if (PackageChannelManager.getDeployMode(getContext()) == 1) goto L7;
        return true;
    }

    public Context getContext() {
        return LarkContext.getApplication();
    }

    public final String getMainDomain() {
        return jcb.b.c().a("suite_main_domain");
    }

    public final boolean isUsPackage() {
        return LarkAppContext.inst().buildConfig().isUsPackage();
    }

    public final String a(String r3) {
        return String.format("https://%s/folder/", new Object[]{gcb.b.a(r3)});
    }

    public final String getPolicyUrl(PolicyAgreement r2) {
        int r0 = jl5.a.a;
        Intrinsics.checkNotNullParameter(r2, "policyAgreement");
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).getPolicyUrl(r2);
    }
}
