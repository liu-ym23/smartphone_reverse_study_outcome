package com.ss.android.lark.integrator.security.compliance.screen_audit;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKScreenCaptureAuditService_Factory implements Factory<OfficeSDKScreenCaptureAuditService> {
    private final Provider<a> reporterProvider;

    public OfficeSDKScreenCaptureAuditService get() {
        return newInstance((a) this.reporterProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m955get() {
        return get();
    }

    public OfficeSDKScreenCaptureAuditService_Factory(Provider<a> r1) {
        this.reporterProvider = r1;
    }

    public static OfficeSDKScreenCaptureAuditService_Factory create(Provider<a> r1) {
        return new OfficeSDKScreenCaptureAuditService_Factory(r1);
    }

    public static OfficeSDKScreenCaptureAuditService newInstance(a r1) {
        return new OfficeSDKScreenCaptureAuditService(r1);
    }
}
