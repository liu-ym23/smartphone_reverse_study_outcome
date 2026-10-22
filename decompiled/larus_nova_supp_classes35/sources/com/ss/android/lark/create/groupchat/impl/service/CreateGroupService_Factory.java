package com.ss.android.lark.create.groupchat.impl.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CreateGroupService_Factory implements Factory<CreateGroupService> {
    private final Provider<b> createGroupErrorHandleProvider;
    private final Provider<b38.b> rucketProvider;

    public CreateGroupService get() {
        return newInstance((b38.b) this.rucketProvider.get(), (b) this.createGroupErrorHandleProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1119get() {
        return get();
    }

    public CreateGroupService_Factory(Provider<b38.b> r1, Provider<b> r2) {
        this.rucketProvider = r1;
        this.createGroupErrorHandleProvider = r2;
    }

    public static CreateGroupService_Factory create(Provider<b38.b> r1, Provider<b> r2) {
        return new CreateGroupService_Factory(r1, r2);
    }

    public static CreateGroupService newInstance(b38.b r1, b r2) {
        return new CreateGroupService(r1, r2);
    }
}
