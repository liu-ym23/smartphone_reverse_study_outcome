package com.ss.android.lark.chat.repository.impl;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DraftRepositoryV2_Factory implements Factory<DraftRepositoryV2> {
    private final Provider<l> userClientProvider;

    public DraftRepositoryV2 get() {
        return newInstance((l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m676get() {
        return get();
    }

    public DraftRepositoryV2_Factory(Provider<l> r1) {
        this.userClientProvider = r1;
    }

    public static DraftRepositoryV2_Factory create(Provider<l> r1) {
        return new DraftRepositoryV2_Factory(r1);
    }

    public static DraftRepositoryV2 newInstance(l r1) {
        return new DraftRepositoryV2(r1);
    }
}
