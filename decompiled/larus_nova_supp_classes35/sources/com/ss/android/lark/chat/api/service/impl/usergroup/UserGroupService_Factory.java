package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserGroupService_Factory implements Factory<UserGroupService> {
    private final Provider<g> fgServiceProvider;
    private final Provider<l> rustClientProvider;

    public UserGroupService get() {
        return newInstance((l) this.rustClientProvider.get(), (g) this.fgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m105get() {
        return get();
    }

    public UserGroupService_Factory(Provider<l> r1, Provider<g> r2) {
        this.rustClientProvider = r1;
        this.fgServiceProvider = r2;
    }

    public static UserGroupService_Factory create(Provider<l> r1, Provider<g> r2) {
        return new UserGroupService_Factory(r1, r2);
    }

    public static UserGroupService newInstance(l r1, g r2) {
        return new UserGroupService(r1, r2);
    }
}
