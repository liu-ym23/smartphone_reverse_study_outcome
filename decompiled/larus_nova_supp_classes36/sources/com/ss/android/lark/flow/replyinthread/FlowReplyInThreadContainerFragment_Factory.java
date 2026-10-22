package com.ss.android.lark.flow.replyinthread;

import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowReplyInThreadContainerFragment_Factory implements Factory<FlowReplyInThreadContainerFragment> {
    private final Provider<FlowReplyInThreadFragment> mFragmentProvider;

    public static FlowReplyInThreadContainerFragment newInstance() {
        return new FlowReplyInThreadContainerFragment();
    }

    public FlowReplyInThreadContainerFragment get() {
        FlowReplyInThreadContainerFragment r0 = newInstance();
        r0.g = (FlowReplyInThreadFragment) this.mFragmentProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m479get() {
        return get();
    }

    public FlowReplyInThreadContainerFragment_Factory(Provider<FlowReplyInThreadFragment> r1) {
        this.mFragmentProvider = r1;
    }

    public static FlowReplyInThreadContainerFragment_Factory create(Provider<FlowReplyInThreadFragment> r1) {
        return new FlowReplyInThreadContainerFragment_Factory(r1);
    }
}
