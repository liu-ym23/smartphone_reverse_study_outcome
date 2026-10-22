package com.larus.uaigc.worldcup.component;

import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements f4 {
    public final /* synthetic */ WorldCupLynxComponent a;

    @Override // com.larus.platform.api.f4
    public final void a() {
        FLogger.a.i(this.a.m, "[onTimingSetup] timeMs: " + System.currentTimeMillis());
        WorldCupLynxComponent r0 = this.a;
        System.currentTimeMillis();
        r0.getClass();
    }

    @Override // com.larus.platform.api.f4
    public final void f() {
        FLogger.a.i(this.a.m, "[onViewDestroy] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadStart() {
        FLogger.a.i(this.a.m, "[onLoadStart] timeMs: " + System.currentTimeMillis());
        WorldCupLynxComponent r0 = this.a;
        System.currentTimeMillis();
        r0.getClass();
    }

    public q(WorldCupLynxComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.platform.api.f4
    public final void b(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        FLogger.a.i(this.a.m, "[onFallback] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void c(BulletContainerView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FLogger.a.i(this.a.m, "[onRuntimeReady] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void d(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FLogger.a.i(this.a.m, "[onViewCreate] timeMs: " + System.currentTimeMillis());
    }

    @Override // com.larus.platform.api.f4
    public final void e(Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "e");
        FLogger r0 = FLogger.a;
        r0.i(this.a.m, "[onLoadFail] timeMs: " + System.currentTimeMillis());
        r0.i(this.a.m, "[onLoadFail] e: " + r6.getMessage());
        this.a.getClass();
        WorldCupLynxComponent r1 = this.a;
        r6.getMessage();
        r1.getClass();
        WorldCupLynxComponent.h3(this.a);
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadSuccess(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FLogger.a.i(this.a.m, "[onLoadSuccess] timeMs: " + System.currentTimeMillis());
        this.a.getClass();
        WorldCupLynxComponent.h3(this.a);
    }
}
