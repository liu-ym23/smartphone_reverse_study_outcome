package com.ss.android.lark.officesdk.injectheader.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKHostAppHeaderUpdateImpl_Factory implements Factory<OfficeSDKHostAppHeaderUpdateImpl> {

    public static final class a {
        public static final OfficeSDKHostAppHeaderUpdateImpl_Factory a = null;

        static {
            a = new OfficeSDKHostAppHeaderUpdateImpl_Factory();
        }
    }

    public OfficeSDKHostAppHeaderUpdateImpl_Factory() {
    }

    public static OfficeSDKHostAppHeaderUpdateImpl newInstance() {
        return new OfficeSDKHostAppHeaderUpdateImpl();
    }

    public OfficeSDKHostAppHeaderUpdateImpl get() {
        return newInstance();
    }

    public static OfficeSDKHostAppHeaderUpdateImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m75get() {
        return get();
    }
}
