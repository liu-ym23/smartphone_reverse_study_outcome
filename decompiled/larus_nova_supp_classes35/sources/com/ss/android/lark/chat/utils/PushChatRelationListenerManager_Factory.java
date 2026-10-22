package com.ss.android.lark.chat.utils;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PushChatRelationListenerManager_Factory implements Factory<x0> {
    private final Provider<m6b.d> chatSubscribeServiceProvider;

    public x0 get() {
        return newInstance((m6b.d) this.chatSubscribeServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m730get() {
        return get();
    }

    public PushChatRelationListenerManager_Factory(Provider<m6b.d> r1) {
        this.chatSubscribeServiceProvider = r1;
    }

    public static PushChatRelationListenerManager_Factory create(Provider<m6b.d> r1) {
        return new PushChatRelationListenerManager_Factory(r1);
    }

    public static x0 newInstance(m6b.d r1) {
        return new x0(r1);
    }
}
