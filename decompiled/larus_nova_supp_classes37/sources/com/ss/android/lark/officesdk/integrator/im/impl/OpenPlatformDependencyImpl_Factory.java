package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OpenPlatformDependencyImpl_Factory implements Factory<n> {

    public static final class a {
        public static final OpenPlatformDependencyImpl_Factory a = null;

        static {
            a = new OpenPlatformDependencyImpl_Factory();
        }
    }

    public OpenPlatformDependencyImpl_Factory() {
    }

    public static n newInstance() {
        return new n();
    }

    public n get() {
        return newInstance();
    }

    public static OpenPlatformDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m86get() {
        return get();
    }
}
