package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserGroupPushRepository_Factory implements Factory<UserGroupPushRepository> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<l> userClientProvider;

    public UserGroupPushRepository get() {
        return newInstance((String) this.currentUserIdProvider.get(), (l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m102get() {
        return get();
    }

    public UserGroupPushRepository_Factory(Provider<String> r1, Provider<l> r2) {
        this.currentUserIdProvider = r1;
        this.userClientProvider = r2;
    }

    public static UserGroupPushRepository_Factory create(Provider<String> r1, Provider<l> r2) {
        return new UserGroupPushRepository_Factory(r1, r2);
    }

    public static UserGroupPushRepository newInstance(String r1, l r2) {
        return new UserGroupPushRepository(r1, r2);
    }
}
