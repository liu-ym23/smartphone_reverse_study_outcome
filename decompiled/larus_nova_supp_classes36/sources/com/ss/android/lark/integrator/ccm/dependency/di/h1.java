package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class h1 implements com.bytedance.ee.bear.lark.dependency.e0 {
    @Inject
    public h1() {
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void e(com.bytedance.ee.bear.lark.dependency.a r2, Function2 r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "onLaunchRequested");
    }

    public final void g() {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final void j(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final void k() {
    }

    public final void l() {
    }

    public final void c(osb.b r3, IGetDataCallback<osb.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.onError(new ErrorResult(-1, "Office not supported"));
    }

    public final void d(String r3, SpaceHomePageAiLauncher.getMyAIParam.1 r4) {
        Intrinsics.checkNotNullParameter(r3, "chatModeId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.onError(new ErrorResult(-1, "Office not supported"));
    }

    public final void f(String r3, SpaceHomePageAiLauncher.closeChatMode.1.1 r4) {
        Intrinsics.checkNotNullParameter(r3, "chatModeId");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.onError(new ErrorResult(-1, "Office not supported"));
    }
}
