package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficePrimaryTabServiceImpl_Factory implements Factory<l> {

    public static final class a {
        public static final OfficePrimaryTabServiceImpl_Factory a = null;

        static {
            a = new OfficePrimaryTabServiceImpl_Factory();
        }
    }

    public OfficePrimaryTabServiceImpl_Factory() {
    }

    public static l newInstance() {
        return new l();
    }

    public l get() {
        return newInstance();
    }

    public static OfficePrimaryTabServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m85get() {
        return get();
    }
}
