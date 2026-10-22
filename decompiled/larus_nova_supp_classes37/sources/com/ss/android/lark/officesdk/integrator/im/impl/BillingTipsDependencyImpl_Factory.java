package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BillingTipsDependencyImpl_Factory implements Factory<com.ss.android.lark.officesdk.integrator.im.impl.a> {

    public static final class a {
        public static final BillingTipsDependencyImpl_Factory a = null;

        static {
            a = new BillingTipsDependencyImpl_Factory();
        }
    }

    public BillingTipsDependencyImpl_Factory() {
    }

    public static com.ss.android.lark.officesdk.integrator.im.impl.a newInstance() {
        return new com.ss.android.lark.officesdk.integrator.im.impl.a();
    }

    public com.ss.android.lark.officesdk.integrator.im.impl.a get() {
        return newInstance();
    }

    public static BillingTipsDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m76get() {
        return get();
    }
}
