package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImBrowserServiceImpl_Factory implements Factory<j> {

    public static final class a {
        public static final ImBrowserServiceImpl_Factory a = null;

        static {
            a = new ImBrowserServiceImpl_Factory();
        }
    }

    public ImBrowserServiceImpl_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    public j get() {
        return newInstance();
    }

    public static ImBrowserServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m83get() {
        return get();
    }
}
