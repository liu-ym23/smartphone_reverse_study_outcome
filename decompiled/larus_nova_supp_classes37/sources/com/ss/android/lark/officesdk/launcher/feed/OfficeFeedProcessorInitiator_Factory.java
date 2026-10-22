package com.ss.android.lark.officesdk.launcher.feed;

import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeFeedProcessorInitiator_Factory implements Factory<c> {
    private final Provider<InitImSdkTask> initImSdkTaskProvider;
    private final Provider<eva.a> launchPerfDispatcherProvider;
    private final Provider<Set<a>> launchTaskInjectorsProvider;

    public c get() {
        c r0 = newInstance((InitImSdkTask) this.initImSdkTaskProvider.get(), (eva.a) this.launchPerfDispatcherProvider.get());
        r0.b = (Set) this.launchTaskInjectorsProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m143get() {
        return get();
    }

    public static c newInstance(InitImSdkTask r1, eva.a r2) {
        return new c(r1, r2);
    }

    public OfficeFeedProcessorInitiator_Factory(Provider<InitImSdkTask> r1, Provider<eva.a> r2, Provider<Set<a>> r3) {
        this.initImSdkTaskProvider = r1;
        this.launchPerfDispatcherProvider = r2;
        this.launchTaskInjectorsProvider = r3;
    }

    public static OfficeFeedProcessorInitiator_Factory create(Provider<InitImSdkTask> r1, Provider<eva.a> r2, Provider<Set<a>> r3) {
        return new OfficeFeedProcessorInitiator_Factory(r1, r2, r3);
    }
}
