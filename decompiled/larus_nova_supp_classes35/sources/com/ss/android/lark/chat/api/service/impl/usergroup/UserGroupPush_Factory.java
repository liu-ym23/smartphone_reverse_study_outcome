package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.o;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserGroupPush_Factory implements Factory<UserGroupPush> {
    private final Provider<b> pushRepoProvider;
    private final Provider<o> userGroupServiceProvider;

    public UserGroupPush get() {
        return newInstance((b) this.pushRepoProvider.get(), (o) this.userGroupServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m103get() {
        return get();
    }

    public UserGroupPush_Factory(Provider<b> r1, Provider<o> r2) {
        this.pushRepoProvider = r1;
        this.userGroupServiceProvider = r2;
    }

    public static UserGroupPush_Factory create(Provider<b> r1, Provider<o> r2) {
        return new UserGroupPush_Factory(r1, r2);
    }

    public static UserGroupPush newInstance(b r1, o r2) {
        return new UserGroupPush(r1, r2);
    }
}
