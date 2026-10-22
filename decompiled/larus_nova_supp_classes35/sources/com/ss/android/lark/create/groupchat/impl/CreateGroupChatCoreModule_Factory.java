package com.ss.android.lark.create.groupchat.impl;

import dagger.internal.Factory;
import hab.b;
import iab.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CreateGroupChatCoreModule_Factory implements Factory<a> {
    private final Provider<hab.a> auditDependencyProvider;
    private final Provider<b> chatDependencyProvider;

    public static a newInstance() {
        return new a();
    }

    public a get() {
        a r0 = newInstance();
        r0.a = (b) this.chatDependencyProvider.get();
        r0.b = (hab.a) this.auditDependencyProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1114get() {
        return get();
    }

    public CreateGroupChatCoreModule_Factory(Provider<b> r1, Provider<hab.a> r2) {
        this.chatDependencyProvider = r1;
        this.auditDependencyProvider = r2;
    }

    public static CreateGroupChatCoreModule_Factory create(Provider<b> r1, Provider<hab.a> r2) {
        return new CreateGroupChatCoreModule_Factory(r1, r2);
    }
}
