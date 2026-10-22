package com.ss.android.lark.flow.mergeforward.page;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMergeForwardFragment_Factory implements Factory<FlowMergeForwardFragment> {
    private final Provider<v> chatAppContainerProvider;
    private final Provider<pya.a> configuratorFactoryProvider;
    private final Provider<qya.a> pluginFactoryProvider;

    public static FlowMergeForwardFragment newInstance() {
        return new FlowMergeForwardFragment();
    }

    public FlowMergeForwardFragment get() {
        FlowMergeForwardFragment r0 = newInstance();
        r0.f = (qya.a) this.pluginFactoryProvider.get();
        r0.g = (pya.a) this.configuratorFactoryProvider.get();
        r0.m = (v) this.chatAppContainerProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m459get() {
        return get();
    }

    public FlowMergeForwardFragment_Factory(Provider<qya.a> r1, Provider<pya.a> r2, Provider<v> r3) {
        this.pluginFactoryProvider = r1;
        this.configuratorFactoryProvider = r2;
        this.chatAppContainerProvider = r3;
    }

    public static FlowMergeForwardFragment_Factory create(Provider<qya.a> r1, Provider<pya.a> r2, Provider<v> r3) {
        return new FlowMergeForwardFragment_Factory(r1, r2, r3);
    }
}
