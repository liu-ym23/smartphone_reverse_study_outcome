package com.ss.android.lark.librabridge.appsetting;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LibraAppConfigExternalSource_Factory implements Factory<LibraAppConfigExternalSource> {

    public static final class a {
        public static final LibraAppConfigExternalSource_Factory a = null;

        static {
            a = new LibraAppConfigExternalSource_Factory();
        }
    }

    public LibraAppConfigExternalSource_Factory() {
    }

    public static LibraAppConfigExternalSource newInstance() {
        return new LibraAppConfigExternalSource();
    }

    public LibraAppConfigExternalSource get() {
        return newInstance();
    }

    public static LibraAppConfigExternalSource_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1394get() {
        return get();
    }
}
