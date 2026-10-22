package com.ss.android.lark.flow.chatthread.page;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatThreadFragment_Factory implements Factory<FlowChatThreadFragment> {
    private final Provider<v> chatAppContainerProvider;
    private final Provider<pya.a> configuratorFactoryProvider;
    private final Provider<qya.a> pluginFactoryProvider;

    public static FlowChatThreadFragment newInstance() {
        return new FlowChatThreadFragment();
    }

    public FlowChatThreadFragment get() {
        FlowChatThreadFragment r0 = newInstance();
        r0.f = (qya.a) this.pluginFactoryProvider.get();
        r0.g = (pya.a) this.configuratorFactoryProvider.get();
        r0.k = (v) this.chatAppContainerProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m365get() {
        return get();
    }

    public FlowChatThreadFragment_Factory(Provider<qya.a> r1, Provider<pya.a> r2, Provider<v> r3) {
        this.pluginFactoryProvider = r1;
        this.configuratorFactoryProvider = r2;
        this.chatAppContainerProvider = r3;
    }

    public static FlowChatThreadFragment_Factory create(Provider<qya.a> r1, Provider<pya.a> r2, Provider<v> r3) {
        return new FlowChatThreadFragment_Factory(r1, r2, r3);
    }
}
