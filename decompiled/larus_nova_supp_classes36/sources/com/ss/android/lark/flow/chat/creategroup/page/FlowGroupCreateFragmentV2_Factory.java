package com.ss.android.lark.flow.chat.creategroup.page;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowGroupCreateFragmentV2_Factory implements Factory<FlowGroupCreateFragmentV2> {
    private final Provider<v> chatAppContainerProvider;

    public static FlowGroupCreateFragmentV2 newInstance() {
        return new FlowGroupCreateFragmentV2();
    }

    public FlowGroupCreateFragmentV2 get() {
        FlowGroupCreateFragmentV2 r0 = newInstance();
        r0.f = (v) this.chatAppContainerProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m35get() {
        return get();
    }

    public FlowGroupCreateFragmentV2_Factory(Provider<v> r1) {
        this.chatAppContainerProvider = r1;
    }

    public static FlowGroupCreateFragmentV2_Factory create(Provider<v> r1) {
        return new FlowGroupCreateFragmentV2_Factory(r1);
    }
}
