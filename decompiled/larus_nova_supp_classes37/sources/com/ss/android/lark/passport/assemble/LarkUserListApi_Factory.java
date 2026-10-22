package com.ss.android.lark.passport.assemble;

import com.ss.android.lark.passport_user.api.IUserListService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LarkUserListApi_Factory implements Factory<d> {
    private final Provider<IUserListService> userListServiceProvider;

    public d get() {
        return newInstance((IUserListService) this.userListServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m593get() {
        return get();
    }

    public LarkUserListApi_Factory(Provider<IUserListService> r1) {
        this.userListServiceProvider = r1;
    }

    public static LarkUserListApi_Factory create(Provider<IUserListService> r1) {
        return new LarkUserListApi_Factory(r1);
    }

    public static d newInstance(IUserListService r1) {
        return new d(r1);
    }
}
