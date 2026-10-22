package com.ss.android.lark.officesdk.language;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeGlobalLanguageServiceImpl_Factory implements Factory<OfficeGlobalLanguageServiceImpl> {

    public static final class a {
        public static final OfficeGlobalLanguageServiceImpl_Factory a = null;

        static {
            a = new OfficeGlobalLanguageServiceImpl_Factory();
        }
    }

    public OfficeGlobalLanguageServiceImpl_Factory() {
    }

    public static OfficeGlobalLanguageServiceImpl newInstance() {
        return new OfficeGlobalLanguageServiceImpl();
    }

    public OfficeGlobalLanguageServiceImpl get() {
        return newInstance();
    }

    public static OfficeGlobalLanguageServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m122get() {
        return get();
    }
}
