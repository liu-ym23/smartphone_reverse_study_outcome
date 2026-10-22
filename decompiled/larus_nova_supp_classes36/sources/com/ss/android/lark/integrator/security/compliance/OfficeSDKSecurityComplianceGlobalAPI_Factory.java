package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKSecurityComplianceGlobalAPI_Factory implements Factory<e> {
    private final Provider<com.ss.android.lark.screenprotect.userscope.b> screenProtectServiceProvider;

    public e get() {
        return newInstance((com.ss.android.lark.screenprotect.userscope.b) this.screenProtectServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m932get() {
        return get();
    }

    public OfficeSDKSecurityComplianceGlobalAPI_Factory(Provider<com.ss.android.lark.screenprotect.userscope.b> r1) {
        this.screenProtectServiceProvider = r1;
    }

    public static OfficeSDKSecurityComplianceGlobalAPI_Factory create(Provider<com.ss.android.lark.screenprotect.userscope.b> r1) {
        return new OfficeSDKSecurityComplianceGlobalAPI_Factory(r1);
    }

    public static e newInstance(com.ss.android.lark.screenprotect.userscope.b r1) {
        return new e(r1);
    }
}
