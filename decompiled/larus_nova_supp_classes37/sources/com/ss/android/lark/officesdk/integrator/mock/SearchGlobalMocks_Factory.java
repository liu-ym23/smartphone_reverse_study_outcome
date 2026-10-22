package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchGlobalMocks_Factory implements Factory<r> {

    public static final class a {
        public static final SearchGlobalMocks_Factory a = null;

        static {
            a = new SearchGlobalMocks_Factory();
        }
    }

    public SearchGlobalMocks_Factory() {
    }

    public static r newInstance() {
        return new r();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m108get();
    }

    public static SearchGlobalMocks_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public r m108get() {
        return newInstance();
    }
}
