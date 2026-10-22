package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PostService_Factory implements Factory<v1> {
    private final Provider<m6b.l> repoProvider;

    public v1 get() {
        return newInstance((m6b.l) this.repoProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m716get() {
        return get();
    }

    public PostService_Factory(Provider<m6b.l> r1) {
        this.repoProvider = r1;
    }

    public static PostService_Factory create(Provider<m6b.l> r1) {
        return new PostService_Factory(r1);
    }

    public static v1 newInstance(m6b.l r1) {
        return new v1(r1);
    }
}
