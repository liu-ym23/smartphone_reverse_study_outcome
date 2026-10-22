package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchUserMocks_Factory implements Factory<u> {

    public static final class a {
        public static final SearchUserMocks_Factory a = null;

        static {
            a = new SearchUserMocks_Factory();
        }
    }

    public SearchUserMocks_Factory() {
    }

    public static u newInstance() {
        return new u();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m109get();
    }

    public static SearchUserMocks_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public u m109get() {
        return newInstance();
    }
}
