package com.ss.android.lark.officesdk.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopOnlineOfflineService_Factory implements Factory<NoopOnlineOfflineService> {

    public static final class a {
        public static final NoopOnlineOfflineService_Factory a = null;

        static {
            a = new NoopOnlineOfflineService_Factory();
        }
    }

    public NoopOnlineOfflineService_Factory() {
    }

    public static NoopOnlineOfflineService newInstance() {
        return new NoopOnlineOfflineService();
    }

    public NoopOnlineOfflineService get() {
        return newInstance();
    }

    public static NoopOnlineOfflineService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m11get() {
        return get();
    }
}
