package com.ss.android.lark.integrator.security.compliance.endpoint;

import dagger.internal.Factory;
import hnb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class NoopEndpointSecurityFactorService_Factory implements Factory<b> {

    public static final class a {
        public static final NoopEndpointSecurityFactorService_Factory a = null;

        static {
            a = new NoopEndpointSecurityFactorService_Factory();
        }
    }

    public NoopEndpointSecurityFactorService_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static NoopEndpointSecurityFactorService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m938get() {
        return get();
    }
}
