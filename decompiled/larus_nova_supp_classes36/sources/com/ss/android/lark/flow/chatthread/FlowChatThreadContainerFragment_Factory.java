package com.ss.android.lark.flow.chatthread;

import com.ss.android.lark.flow.chatthread.page.FlowChatThreadFragment;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatThreadContainerFragment_Factory implements Factory<FlowChatThreadContainerFragment> {
    private final Provider<FlowChatThreadFragment> mFragmentProvider;

    public static FlowChatThreadContainerFragment newInstance() {
        return new FlowChatThreadContainerFragment();
    }

    public FlowChatThreadContainerFragment get() {
        FlowChatThreadContainerFragment r0 = newInstance();
        r0.f = (FlowChatThreadFragment) this.mFragmentProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m360get() {
        return get();
    }

    public FlowChatThreadContainerFragment_Factory(Provider<FlowChatThreadFragment> r1) {
        this.mFragmentProvider = r1;
    }

    public static FlowChatThreadContainerFragment_Factory create(Provider<FlowChatThreadFragment> r1) {
        return new FlowChatThreadContainerFragment_Factory(r1);
    }
}
