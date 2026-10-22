package com.larus.uaigc.lynx;

import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements f4 {
    public final /* synthetic */ CompletableDeferred<Boolean> a;

    @Override // com.larus.platform.api.f4
    public final void a() {
        FLogger.a.i("LotteryLynxWarmer", "[onTimingSetup]");
        if (this.a.isCompleted() == true) goto L6;
        this.a.complete(Boolean.TRUE);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void f() {
        FLogger.a.i("LotteryLynxWarmer", "[onViewDestroy]");
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadStart() {
        FLogger.a.i("LotteryLynxWarmer", "[onLoadStart]");
    }

    public b(CompletableDeferred<Boolean> r1) {
        this.a = r1;
    }

    @Override // com.larus.platform.api.f4
    public final void b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.e("LotteryLynxWarmer", "[onFallback]", r4);
        if (this.a.isCompleted() == true) goto L6;
        this.a.complete(Boolean.FALSE);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void c(BulletContainerView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("LotteryLynxWarmer", "[onRuntimeReady]");
    }

    @Override // com.larus.platform.api.f4
    public final void d(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("LotteryLynxWarmer", "[onViewCreate]");
    }

    @Override // com.larus.platform.api.f4
    public final void e(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.e("LotteryLynxWarmer", "[onLoadFail]", r4);
        if (this.a.isCompleted() == true) goto L6;
        this.a.complete(Boolean.FALSE);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadSuccess(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("LotteryLynxWarmer", "[onLoadSuccess]");
        if (this.a.isCompleted() == true) goto L6;
        this.a.complete(Boolean.TRUE);
        return;
    }
}
