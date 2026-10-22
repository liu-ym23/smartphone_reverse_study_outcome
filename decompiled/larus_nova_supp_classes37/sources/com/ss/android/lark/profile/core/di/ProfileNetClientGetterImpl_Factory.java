package com.ss.android.lark.profile.core.di;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ProfileNetClientGetterImpl_Factory implements Factory<ProfileNetClientGetterImpl> {
    private final Provider<l> rustClientProvider;
    private final Provider<b38.b> scopedRucketProvider;

    public ProfileNetClientGetterImpl get() {
        return newInstance((l) this.rustClientProvider.get(), (b38.b) this.scopedRucketProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3416get() {
        return get();
    }

    public ProfileNetClientGetterImpl_Factory(Provider<l> r1, Provider<b38.b> r2) {
        this.rustClientProvider = r1;
        this.scopedRucketProvider = r2;
    }

    public static ProfileNetClientGetterImpl_Factory create(Provider<l> r1, Provider<b38.b> r2) {
        return new ProfileNetClientGetterImpl_Factory(r1, r2);
    }

    public static ProfileNetClientGetterImpl newInstance(l r1, b38.b r2) {
        return new ProfileNetClientGetterImpl(r1, r2);
    }
}
