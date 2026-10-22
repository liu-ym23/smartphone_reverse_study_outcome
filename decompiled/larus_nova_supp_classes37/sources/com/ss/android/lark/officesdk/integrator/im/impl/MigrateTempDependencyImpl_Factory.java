package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MigrateTempDependencyImpl_Factory implements Factory<k> {

    public static final class a {
        public static final MigrateTempDependencyImpl_Factory a = null;

        static {
            a = new MigrateTempDependencyImpl_Factory();
        }
    }

    public MigrateTempDependencyImpl_Factory() {
    }

    public static k newInstance() {
        return new k();
    }

    public k get() {
        return newInstance();
    }

    public static MigrateTempDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m84get() {
        return get();
    }
}
