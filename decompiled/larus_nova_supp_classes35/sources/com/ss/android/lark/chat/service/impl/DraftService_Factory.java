package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DraftService_Factory implements Factory<r> {
    private final Provider<l6b.a> draftRepositoryProvider;

    public r get() {
        return newInstance((l6b.a) this.draftRepositoryProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m684get() {
        return get();
    }

    public DraftService_Factory(Provider<l6b.a> r1) {
        this.draftRepositoryProvider = r1;
    }

    public static DraftService_Factory create(Provider<l6b.a> r1) {
        return new DraftService_Factory(r1);
    }

    public static r newInstance(l6b.a r1) {
        return new r(r1);
    }
}
