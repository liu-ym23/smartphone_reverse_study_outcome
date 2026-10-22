package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class EditMessageService_Factory implements Factory<EditMessageService> {
    private final Provider<m6b.j> configServiceProvider;
    private final Provider<com.ss.android.lark.im.sdk.service.p> msgServiceProvider;
    private final Provider<b38.b> rucketProvider;

    public EditMessageService get() {
        return newInstance((b38.b) this.rucketProvider.get(), (m6b.j) this.configServiceProvider.get(), (com.ss.android.lark.im.sdk.service.p) this.msgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m685get() {
        return get();
    }

    public EditMessageService_Factory(Provider<b38.b> r1, Provider<m6b.j> r2, Provider<com.ss.android.lark.im.sdk.service.p> r3) {
        this.rucketProvider = r1;
        this.configServiceProvider = r2;
        this.msgServiceProvider = r3;
    }

    public static EditMessageService_Factory create(Provider<b38.b> r1, Provider<m6b.j> r2, Provider<com.ss.android.lark.im.sdk.service.p> r3) {
        return new EditMessageService_Factory(r1, r2, r3);
    }

    public static EditMessageService newInstance(b38.b r1, m6b.j r2, com.ss.android.lark.im.sdk.service.p r3) {
        return new EditMessageService(r1, r2, r3);
    }
}
