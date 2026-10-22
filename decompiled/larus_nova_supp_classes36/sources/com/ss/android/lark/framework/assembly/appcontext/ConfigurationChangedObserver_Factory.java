package com.ss.android.lark.framework.assembly.appcontext;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ConfigurationChangedObserver_Factory implements Factory<com.ss.android.lark.framework.assembly.appcontext.a> {

    public static final class a {
        public static final ConfigurationChangedObserver_Factory a = null;

        static {
            a = new ConfigurationChangedObserver_Factory();
        }
    }

    public ConfigurationChangedObserver_Factory() {
    }

    public static com.ss.android.lark.framework.assembly.appcontext.a newInstance() {
        return new com.ss.android.lark.framework.assembly.appcontext.a();
    }

    public com.ss.android.lark.framework.assembly.appcontext.a get() {
        return newInstance();
    }

    public static ConfigurationChangedObserver_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m651get() {
        return get();
    }
}
