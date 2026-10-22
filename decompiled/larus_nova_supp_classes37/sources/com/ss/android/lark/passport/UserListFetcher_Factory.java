package com.ss.android.lark.passport;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserListFetcher_Factory implements Factory<UserListFetcher> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<l> userRustClientProvider;

    public UserListFetcher get() {
        return newInstance((String) this.currentUserIdProvider.get(), (l) this.userRustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m588get() {
        return get();
    }

    public UserListFetcher_Factory(Provider<String> r1, Provider<l> r2) {
        this.currentUserIdProvider = r1;
        this.userRustClientProvider = r2;
    }

    public static UserListFetcher_Factory create(Provider<String> r1, Provider<l> r2) {
        return new UserListFetcher_Factory(r1, r2);
    }

    public static UserListFetcher newInstance(String r1, l r2) {
        return new UserListFetcher(r1, r2);
    }
}
