package com.larus.bmhome.block.holder.content.lynx;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements f4 {
    public final /* synthetic */ CompletableDeferred<Boolean> a;
    public final /* synthetic */ SpringLynxBlockHolder b;

    public final void a() {
        FLogger.a.i("SpringLynxBlockHolder", "[onTimingSetup]");
        if (this.a.isCompleted() == true) goto L5;
        this.a.complete(Boolean.TRUE);
    L5:
        View r0 = this.b.n;
        if (r0 == null) goto L8;
        r0.setVisibility(8);
    L8:
        FrameLayout r1 = this.b.f;
        if (r1 == null) goto L15;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L14;
        r2.height = -2;
        r1.setLayoutParams(r2);
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L15:
        this.b.l(true, 0, null);
    }

    public final void f() {
        FLogger.a.i("SpringLynxBlockHolder", "[onViewDestroy]");
    }

    public final void onLoadStart() {
        FLogger.a.i("SpringLynxBlockHolder", "[onLoadStart]");
    }

    public final void b(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.e("SpringLynxBlockHolder", "[onFallback]", r4);
        if (this.a.isCompleted() == true) goto L5;
        this.a.complete(Boolean.FALSE);
    L5:
        SpringLynxBlockHolder r0 = this.b;
        String r5 = r4.getMessage();
        int r1 = SpringLynxBlockHolder.v;
        r0.l(false, 101, r5);
    }

    public final void c(BulletContainerView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("SpringLynxBlockHolder", "[onRuntimeReady]");
    }

    public final void d(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("SpringLynxBlockHolder", "[onViewCreate]");
    }

    public final void e(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.e("SpringLynxBlockHolder", "[onLoadFail]", r4);
        if (this.a.isCompleted() == true) goto L5;
        this.a.complete(Boolean.FALSE);
    L5:
        SpringLynxBlockHolder r0 = this.b;
        String r5 = r4.getMessage();
        int r1 = SpringLynxBlockHolder.v;
        r0.l(false, DoraCallStateCode.DORA_NEW_USER_GUIDE, r5);
    }

    public final void onLoadSuccess(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("SpringLynxBlockHolder", "[onLoadSuccess]");
        if (this.a.isCompleted() == true) goto L6;
        this.a.complete(Boolean.TRUE);
        return;
    }

    public p(CompletableDeferred<Boolean> r1, SpringLynxBlockHolder r2) {
        this.a = r1;
        this.b = r2;
    }
}
