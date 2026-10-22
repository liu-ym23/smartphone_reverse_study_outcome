package com.ss.android.lark.im.base.browser;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DefaultImBrowserService_Factory implements Factory<com.ss.android.lark.im.base.browser.a> {

    public static final class a {
        public static final DefaultImBrowserService_Factory a = null;

        static {
            a = new DefaultImBrowserService_Factory();
        }
    }

    public DefaultImBrowserService_Factory() {
    }

    public static com.ss.android.lark.im.base.browser.a newInstance() {
        return new com.ss.android.lark.im.base.browser.a();
    }

    public com.ss.android.lark.im.base.browser.a get() {
        return newInstance();
    }

    public static DefaultImBrowserService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m707get() {
        return get();
    }
}
