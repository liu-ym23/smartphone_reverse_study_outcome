package com.ss.android.lark.feed.shared.data.click_hint;

import dagger.internal.Factory;
import javax.inject.Provider;
import jeb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedClickDataCache_Factory implements Factory<a> {
    private final Provider<String> userIdProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m1194get() {
        return newInstance((String) this.userIdProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1194get();
    }

    public FeedClickDataCache_Factory(Provider<String> r1) {
        this.userIdProvider = r1;
    }

    public static FeedClickDataCache_Factory create(Provider<String> r1) {
        return new FeedClickDataCache_Factory(r1);
    }

    public static a newInstance(String r1) {
        return new a(r1);
    }
}
