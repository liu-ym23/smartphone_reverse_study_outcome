package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CCMDependencyImpl_Factory implements Factory<b> {

    public static final class a {
        public static final CCMDependencyImpl_Factory a = null;

        static {
            a = new CCMDependencyImpl_Factory();
        }
    }

    public CCMDependencyImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static CCMDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m77get() {
        return get();
    }
}
