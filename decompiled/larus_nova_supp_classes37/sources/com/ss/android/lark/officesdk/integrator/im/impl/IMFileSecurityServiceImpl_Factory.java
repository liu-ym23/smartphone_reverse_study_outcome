package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IMFileSecurityServiceImpl_Factory implements Factory<IMFileSecurityServiceImpl> {

    public static final class a {
        public static final IMFileSecurityServiceImpl_Factory a = null;

        static {
            a = new IMFileSecurityServiceImpl_Factory();
        }
    }

    public IMFileSecurityServiceImpl_Factory() {
    }

    public static IMFileSecurityServiceImpl newInstance() {
        return new IMFileSecurityServiceImpl();
    }

    public IMFileSecurityServiceImpl get() {
        return newInstance();
    }

    public static IMFileSecurityServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m81get() {
        return get();
    }
}
