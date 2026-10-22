package com.ss.android.lark.feed.shared.data.stranger;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import oeb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedStrangerDataCache_Factory implements Factory<a> {
    private final Provider<m> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m1197get() {
        return newInstance((m) this.passportProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1197get();
    }

    public FeedStrangerDataCache_Factory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static FeedStrangerDataCache_Factory create(Provider<m> r1) {
        return new FeedStrangerDataCache_Factory(r1);
    }

    public static a newInstance(m r1) {
        return new a(r1);
    }
}
