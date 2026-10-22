package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageTenantConfService_Factory implements Factory<MessageTenantConfService> {
    private final Provider<b38.b> rucketProvider;

    public MessageTenantConfService get() {
        return newInstance((b38.b) this.rucketProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m714get() {
        return get();
    }

    public MessageTenantConfService_Factory(Provider<b38.b> r1) {
        this.rucketProvider = r1;
    }

    public static MessageTenantConfService_Factory create(Provider<b38.b> r1) {
        return new MessageTenantConfService_Factory(r1);
    }

    public static MessageTenantConfService newInstance(b38.b r1) {
        return new MessageTenantConfService(r1);
    }
}
