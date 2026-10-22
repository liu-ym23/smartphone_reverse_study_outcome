package com.ss.android.lark.officesdk.applink;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKAppLinkServiceImpl_Factory implements Factory<OfficeSDKAppLinkServiceImpl> {

    public static final class a {
        public static final OfficeSDKAppLinkServiceImpl_Factory a = null;

        static {
            a = new OfficeSDKAppLinkServiceImpl_Factory();
        }
    }

    public OfficeSDKAppLinkServiceImpl_Factory() {
    }

    public static OfficeSDKAppLinkServiceImpl newInstance() {
        return new OfficeSDKAppLinkServiceImpl();
    }

    public OfficeSDKAppLinkServiceImpl get() {
        return newInstance();
    }

    public static OfficeSDKAppLinkServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m16get() {
        return get();
    }
}
