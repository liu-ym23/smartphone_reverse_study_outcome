package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CustomDisplayNetworkRepository_Factory implements Factory<d> {
    private final Provider<l> rustClientProvider;

    public d get() {
        return newInstance((l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m967get() {
        return get();
    }

    public CustomDisplayNetworkRepository_Factory(Provider<l> r1) {
        this.rustClientProvider = r1;
    }

    public static CustomDisplayNetworkRepository_Factory create(Provider<l> r1) {
        return new CustomDisplayNetworkRepository_Factory(r1);
    }

    public static d newInstance(l r1) {
        return new d(r1);
    }
}
