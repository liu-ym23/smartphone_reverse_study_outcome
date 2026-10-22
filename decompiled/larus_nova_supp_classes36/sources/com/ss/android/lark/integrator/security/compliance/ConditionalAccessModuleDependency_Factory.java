package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ConditionalAccessModuleDependency_Factory implements Factory<ConditionalAccessModuleDependency> {

    public static final class a {
        public static final ConditionalAccessModuleDependency_Factory a = null;

        static {
            a = new ConditionalAccessModuleDependency_Factory();
        }
    }

    public ConditionalAccessModuleDependency_Factory() {
    }

    public static ConditionalAccessModuleDependency newInstance() {
        return new ConditionalAccessModuleDependency();
    }

    public ConditionalAccessModuleDependency get() {
        return newInstance();
    }

    public static ConditionalAccessModuleDependency_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m931get() {
        return get();
    }
}
