package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TranslateDependencyImpl_Factory implements Factory<t> {

    public static final class a {
        public static final TranslateDependencyImpl_Factory a = null;

        static {
            a = new TranslateDependencyImpl_Factory();
        }
    }

    public TranslateDependencyImpl_Factory() {
    }

    public static t newInstance() {
        return new t();
    }

    public t get() {
        return newInstance();
    }

    public static TranslateDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m91get() {
        return get();
    }
}
