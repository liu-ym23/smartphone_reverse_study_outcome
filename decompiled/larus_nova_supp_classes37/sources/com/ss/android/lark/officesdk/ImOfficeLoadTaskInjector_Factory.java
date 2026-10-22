package com.ss.android.lark.officesdk;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImOfficeLoadTaskInjector_Factory implements Factory<ImOfficeLoadTaskInjector> {

    public static final class a {
        public static final ImOfficeLoadTaskInjector_Factory a = null;

        static {
            a = new ImOfficeLoadTaskInjector_Factory();
        }
    }

    public ImOfficeLoadTaskInjector_Factory() {
    }

    public static ImOfficeLoadTaskInjector newInstance() {
        return new ImOfficeLoadTaskInjector();
    }

    public ImOfficeLoadTaskInjector get() {
        return newInstance();
    }

    public static ImOfficeLoadTaskInjector_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m7get() {
        return get();
    }
}
