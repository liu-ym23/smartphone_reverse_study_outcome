package com.ss.android.lark.feed.shared.data.priority;

import dagger.internal.Factory;
import javax.inject.Provider;
import neb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PriorityDataCache_Factory implements Factory<b> {
    private final Provider<String> userIdProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m1195get() {
        return newInstance((String) this.userIdProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1195get();
    }

    public PriorityDataCache_Factory(Provider<String> r1) {
        this.userIdProvider = r1;
    }

    public static PriorityDataCache_Factory create(Provider<String> r1) {
        return new PriorityDataCache_Factory(r1);
    }

    public static b newInstance(String r1) {
        return new b(r1);
    }
}
