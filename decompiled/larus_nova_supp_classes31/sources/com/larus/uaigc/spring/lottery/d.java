package com.larus.uaigc.spring.lottery;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.platform.api.f4;
import com.larus.platform.model.CollectionType;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements f4 {
    public final /* synthetic */ ZLotteryGuideCell a;
    public final /* synthetic */ CompletableDeferred<Boolean> b;

    @Override // com.larus.platform.api.f4
    public final void a() {
        FLogger.a.i("ZLotteryGuideCell", "[onTimingSetup]");
        if (this.b.isCompleted() == true) goto L5;
        this.b.complete(Boolean.TRUE);
    L5:
        u7 r0 = (u7) this.a.j.getValue();
        if (r0 == null) goto L9;
        r0.O5(false);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void f() {
        FLogger.a.i("ZLotteryGuideCell", "[onViewDestroy]");
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadStart() {
        FLogger.a.i("ZLotteryGuideCell", "[onLoadStart]");
    }

    @Override // com.larus.platform.api.f4
    public final void b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.e("ZLotteryGuideCell", "[onFallback]", r4);
        this.a.f = null;
        if (this.b.isCompleted() == true) goto L5;
        this.b.complete(Boolean.FALSE);
    L5:
        this.a.o(false, CollectionType.SINGLE_QISHUI_ALBUM, r4.getMessage());
    }

    @Override // com.larus.platform.api.f4
    public final void c(BulletContainerView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("ZLotteryGuideCell", "[onRuntimeReady]");
    }

    @Override // com.larus.platform.api.f4
    public final void d(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("ZLotteryGuideCell", "[onViewCreate]");
    }

    @Override // com.larus.platform.api.f4
    public final void e(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.e("ZLotteryGuideCell", "[onLoadFail]", r4);
        this.a.f = null;
        if (this.b.isCompleted() == true) goto L5;
        this.b.complete(Boolean.FALSE);
    L5:
        this.a.o(false, 201, r4.getMessage());
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadSuccess(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        FLogger.a.i("ZLotteryGuideCell", "[onLoadSuccess]");
        FrameLayout r0 = this.a.e;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L8;
        r2.height = -2;
        r0.setLayoutParams(r2);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L9:
        FrameLayout r1 = this.a.e;
        if (r1 == null) goto L12;
        r1.removeAllViews();
    L12:
        FrameLayout r3 = this.a.e;
        if (r3 == null) goto L16;
        r3.addView(r6, new FrameLayout.LayoutParams(this.a.h - i5.E(), -2));
    L16:
        if (this.b.isCompleted() == true) goto L18;
        this.b.complete(Boolean.TRUE);
    L18:
        this.a.o(true, 0, null);
    }

    public d(ZLotteryGuideCell r1, CompletableDeferred<Boolean> r2) {
        this.a = r1;
        this.b = r2;
    }
}
