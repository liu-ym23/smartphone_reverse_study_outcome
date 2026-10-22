package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InfraCleanModule_Factory implements Factory<InfraCleanModule> {

    public static final class a {
        public static final InfraCleanModule_Factory a = null;

        static {
            a = new InfraCleanModule_Factory();
        }
    }

    public InfraCleanModule_Factory() {
    }

    public static InfraCleanModule newInstance() {
        return new InfraCleanModule();
    }

    public InfraCleanModule get() {
        return newInstance();
    }

    public static InfraCleanModule_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1742get() {
        return get();
    }
}
