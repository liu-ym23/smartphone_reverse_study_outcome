package com.ss.android.lark.flow.chat.page.flow;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatFragment_Factory implements Factory<FlowChatFragment> {
    private final Provider<v> chatAppContainerProvider;
    private final Provider<pya.a> configuratorFactoryProvider;
    private final Provider<qya.a> pluginFactoryProvider;

    public static FlowChatFragment newInstance() {
        return new FlowChatFragment();
    }

    public FlowChatFragment get() {
        FlowChatFragment r0 = newInstance();
        r0.f = (qya.a) this.pluginFactoryProvider.get();
        r0.g = (pya.a) this.configuratorFactoryProvider.get();
        r0.k = (v) this.chatAppContainerProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m123get() {
        return get();
    }

    public FlowChatFragment_Factory(Provider<qya.a> r1, Provider<pya.a> r2, Provider<v> r3) {
        this.pluginFactoryProvider = r1;
        this.configuratorFactoryProvider = r2;
        this.chatAppContainerProvider = r3;
    }

    public static FlowChatFragment_Factory create(Provider<qya.a> r1, Provider<pya.a> r2, Provider<v> r3) {
        return new FlowChatFragment_Factory(r1, r2, r3);
    }
}
