package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PolicyEngineManageModuleDependency_Factory implements Factory<k> {

    public static final class a {
        public static final PolicyEngineManageModuleDependency_Factory a = null;

        static {
            a = new PolicyEngineManageModuleDependency_Factory();
        }
    }

    public PolicyEngineManageModuleDependency_Factory() {
    }

    public static k newInstance() {
        return new k();
    }

    public k get() {
        return newInstance();
    }

    public static PolicyEngineManageModuleDependency_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m934get() {
        return get();
    }
}
