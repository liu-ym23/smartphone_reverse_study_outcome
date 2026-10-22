package com.ss.android.lark.flow.mergeforward;

import com.ss.android.lark.flow.mergeforward.page.FlowMergeForwardFragment;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMergeForwardContainerFragment_Factory implements Factory<FlowMergeForwardContainerFragment> {
    private final Provider<FlowMergeForwardFragment> mFragmentProvider;

    public static FlowMergeForwardContainerFragment newInstance() {
        return new FlowMergeForwardContainerFragment();
    }

    public FlowMergeForwardContainerFragment get() {
        FlowMergeForwardContainerFragment r0 = newInstance();
        r0.f = (FlowMergeForwardFragment) this.mFragmentProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m450get() {
        return get();
    }

    public FlowMergeForwardContainerFragment_Factory(Provider<FlowMergeForwardFragment> r1) {
        this.mFragmentProvider = r1;
    }

    public static FlowMergeForwardContainerFragment_Factory create(Provider<FlowMergeForwardFragment> r1) {
        return new FlowMergeForwardContainerFragment_Factory(r1);
    }
}
