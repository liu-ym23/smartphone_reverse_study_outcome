package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadPush_Factory implements Factory<k2> {
    private final Provider<m6b.r> repositoryProvider;

    public k2 get() {
        return newInstance((m6b.r) this.repositoryProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m721get() {
        return get();
    }

    public ThreadPush_Factory(Provider<m6b.r> r1) {
        this.repositoryProvider = r1;
    }

    public static ThreadPush_Factory create(Provider<m6b.r> r1) {
        return new ThreadPush_Factory(r1);
    }

    public static k2 newInstance(m6b.r r1) {
        return new k2(r1);
    }
}
