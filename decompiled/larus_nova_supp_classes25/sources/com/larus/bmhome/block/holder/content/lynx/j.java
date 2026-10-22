package com.larus.bmhome.block.holder.content.lynx;

import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements f4 {
    public final /* synthetic */ LynxCardBlockHolder a;
    public final /* synthetic */ CompletableDeferred<Boolean> b;
    public final /* synthetic */ String c;

    public final void c(BulletContainerView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final void a() {
        FLogger.a.i(this.a.f, "[onTimingSetup]");
        if (this.b.isCompleted() == true) goto L5;
        this.b.complete(Boolean.TRUE);
    L5:
        this.a.s(this.c, true, 0, null);
    }

    public final void f() {
        FLogger.a.i(this.a.f, "[onViewDestroy]");
    }

    public final void onLoadStart() {
        FLogger.a.i(this.a.f, "[onLoadStart]");
    }

    public final void b(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        FLogger.a.e(this.a.f, "[onFallback]", r5);
        if (this.b.isCompleted() == true) goto L5;
        this.b.complete(Boolean.FALSE);
    L5:
        this.a.s(this.c, false, 101, r5.getMessage());
    }

    public final void e(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        FLogger.a.e(this.a.f, "[onLoadFail]", r5);
        if (this.b.isCompleted() == true) goto L5;
        this.b.complete(Boolean.FALSE);
    L5:
        this.a.s(this.c, false, DoraCallStateCode.DORA_NEW_USER_GUIDE, r5.getMessage());
    }

    public final void onLoadSuccess(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i(this.a.f, "[onLoadSuccess]");
        if (this.b.isCompleted() == true) goto L6;
        this.b.complete(Boolean.TRUE);
        return;
    }

    public j(LynxCardBlockHolder r1, CompletableDeferred<Boolean> r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
