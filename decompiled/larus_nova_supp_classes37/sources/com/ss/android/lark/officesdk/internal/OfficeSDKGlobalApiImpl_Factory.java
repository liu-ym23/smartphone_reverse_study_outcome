package com.ss.android.lark.officesdk.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKGlobalApiImpl_Factory implements Factory<e> {

    public static final class a {
        public static final OfficeSDKGlobalApiImpl_Factory a = null;

        static {
            a = new OfficeSDKGlobalApiImpl_Factory();
        }
    }

    public OfficeSDKGlobalApiImpl_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    public e get() {
        return newInstance();
    }

    public static OfficeSDKGlobalApiImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m112get() {
        return get();
    }
}
