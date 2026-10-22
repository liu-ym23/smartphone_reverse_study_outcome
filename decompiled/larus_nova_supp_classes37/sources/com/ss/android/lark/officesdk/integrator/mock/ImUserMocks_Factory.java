package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImUserMocks_Factory implements Factory<n> {

    public static final class a {
        public static final ImUserMocks_Factory a = null;

        static {
            a = new ImUserMocks_Factory();
        }
    }

    public ImUserMocks_Factory() {
    }

    public static n newInstance() {
        return new n();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m102get();
    }

    public static ImUserMocks_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public n m102get() {
        return newInstance();
    }
}
