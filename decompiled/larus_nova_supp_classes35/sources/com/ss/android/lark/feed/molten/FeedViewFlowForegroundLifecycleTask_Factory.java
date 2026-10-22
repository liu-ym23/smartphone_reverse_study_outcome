package com.ss.android.lark.feed.molten;

import com.bytedance.lark.view_flow_wrapper.m;
import dagger.internal.Factory;
import eeb.b;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedViewFlowForegroundLifecycleTask_Factory implements Factory<b> {
    private final Provider<Set<m>> disposablesProvider;

    public b get() {
        return newInstance((Set) this.disposablesProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1179get() {
        return get();
    }

    public FeedViewFlowForegroundLifecycleTask_Factory(Provider<Set<m>> r1) {
        this.disposablesProvider = r1;
    }

    public static FeedViewFlowForegroundLifecycleTask_Factory create(Provider<Set<m>> r1) {
        return new FeedViewFlowForegroundLifecycleTask_Factory(r1);
    }

    public static b newInstance(Set<m> r1) {
        return new b(r1);
    }
}
