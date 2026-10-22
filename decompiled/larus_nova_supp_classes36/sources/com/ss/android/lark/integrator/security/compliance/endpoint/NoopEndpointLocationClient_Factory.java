package com.ss.android.lark.integrator.security.compliance.endpoint;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class NoopEndpointLocationClient_Factory implements Factory<hnb.a> {

    public static final class a {
        public static final NoopEndpointLocationClient_Factory a = null;

        static {
            a = new NoopEndpointLocationClient_Factory();
        }
    }

    public NoopEndpointLocationClient_Factory() {
    }

    public static hnb.a newInstance() {
        return new hnb.a();
    }

    public hnb.a get() {
        return newInstance();
    }

    public static NoopEndpointLocationClient_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m937get() {
        return get();
    }
}
