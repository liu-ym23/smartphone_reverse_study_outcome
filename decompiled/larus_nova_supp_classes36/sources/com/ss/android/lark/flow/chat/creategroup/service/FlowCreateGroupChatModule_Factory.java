package com.ss.android.lark.flow.chat.creategroup.service;

import com.ss.android.lark.chatwindow.launcher.c;
import com.ss.android.lark.create.groupchat.impl.service.h;
import dagger.internal.Factory;
import dgb.a;
import hab.b;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowCreateGroupChatModule_Factory implements Factory<a> {
    private final Provider<b> chatDependencyProvider;
    private final Provider<c> chatLauncherV2Provider;
    private final Provider<h> createGroupServiceProvider;

    public static a newInstance() {
        return new a();
    }

    public a get() {
        a r0 = newInstance();
        r0.a = (h) this.createGroupServiceProvider.get();
        r0.b = (c) this.chatLauncherV2Provider.get();
        r0.c = (b) this.chatDependencyProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m39get() {
        return get();
    }

    public FlowCreateGroupChatModule_Factory(Provider<h> r1, Provider<c> r2, Provider<b> r3) {
        this.createGroupServiceProvider = r1;
        this.chatLauncherV2Provider = r2;
        this.chatDependencyProvider = r3;
    }

    public static FlowCreateGroupChatModule_Factory create(Provider<h> r1, Provider<c> r2, Provider<b> r3) {
        return new FlowCreateGroupChatModule_Factory(r1, r2, r3);
    }
}
