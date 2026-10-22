package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EnvironmentDependencyImpl_Factory implements Factory<b> {

    public static final class a {
        public static final EnvironmentDependencyImpl_Factory a = null;

        static {
            a = new EnvironmentDependencyImpl_Factory();
        }
    }

    public EnvironmentDependencyImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static EnvironmentDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m592get() {
        return get();
    }
}
