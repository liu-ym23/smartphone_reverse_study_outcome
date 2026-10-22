package com.ss.android.lark.flow.replyinthread.pages;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowReplyInThreadFragment_Factory implements Factory<FlowReplyInThreadFragment> {
    private final Provider<v> chatAppContainerProvider;
    private final Provider<pya.a> configuratorFactoryProvider;
    private final Provider<qya.a> pluginFactoryProvider;

    public static FlowReplyInThreadFragment newInstance() {
        return new FlowReplyInThreadFragment();
    }

    public FlowReplyInThreadFragment get() {
        FlowReplyInThreadFragment r0 = newInstance();
        r0.f = (v) this.chatAppContainerProvider.get();
        r0.g = (qya.a) this.pluginFactoryProvider.get();
        r0.h = (pya.a) this.configuratorFactoryProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m498get() {
        return get();
    }

    public FlowReplyInThreadFragment_Factory(Provider<v> r1, Provider<qya.a> r2, Provider<pya.a> r3) {
        this.chatAppContainerProvider = r1;
        this.pluginFactoryProvider = r2;
        this.configuratorFactoryProvider = r3;
    }

    public static FlowReplyInThreadFragment_Factory create(Provider<v> r1, Provider<qya.a> r2, Provider<pya.a> r3) {
        return new FlowReplyInThreadFragment_Factory(r1, r2, r3);
    }
}
