package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadService_Factory implements Factory<q1> {
    private final Provider<a2b.m> threadRepoProvider;

    public q1 get() {
        return newInstance((a2b.m) this.threadRepoProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m93get() {
        return get();
    }

    public ThreadService_Factory(Provider<a2b.m> r1) {
        this.threadRepoProvider = r1;
    }

    public static ThreadService_Factory create(Provider<a2b.m> r1) {
        return new ThreadService_Factory(r1);
    }

    public static q1 newInstance(a2b.m r1) {
        return new q1(r1);
    }
}
