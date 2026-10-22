package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IMMediaSecurityServiceImpl_Factory implements Factory<i> {

    public static final class a {
        public static final IMMediaSecurityServiceImpl_Factory a = null;

        static {
            a = new IMMediaSecurityServiceImpl_Factory();
        }
    }

    public IMMediaSecurityServiceImpl_Factory() {
    }

    public static i newInstance() {
        return new i();
    }

    public i get() {
        return newInstance();
    }

    public static IMMediaSecurityServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m82get() {
        return get();
    }
}
