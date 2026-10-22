package com.ss.android.lark.feed.molten;

import com.bytedance.lark.view_flow_wrapper.v;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import eeb.a;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import yrb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory implements Factory<v> {
    private final a module;
    private final Provider<m> passportProvider;

    public v get() {
        return providesSuspendStrategy(this.module, (m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1177get() {
        return get();
    }

    public FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory(a r1, Provider<m> r2) {
        this.module = r1;
        this.passportProvider = r2;
    }

    public static FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory create(a r1, Provider<m> r2) {
        return new FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory(r1, r2);
    }

    public static v providesSuspendStrategy(a r0, m r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        if (r1 != null) goto L5;
        v.a.getClass();
        v.b r2 = v.b.b;
    L7:
        return (v) Preconditions.checkNotNullFromProvides(r2);
    L5:
        r2 = new b(r1);
        goto L7
    }
}
