package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AudioTextPush_Factory implements Factory<f> {
    private final Provider<m6b.b> pushRepoProvider;

    public f get() {
        return newInstance((m6b.b) this.pushRepoProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m682get() {
        return get();
    }

    public AudioTextPush_Factory(Provider<m6b.b> r1) {
        this.pushRepoProvider = r1;
    }

    public static AudioTextPush_Factory create(Provider<m6b.b> r1) {
        return new AudioTextPush_Factory(r1);
    }

    public static f newInstance(m6b.b r1) {
        return new f(r1);
    }
}
