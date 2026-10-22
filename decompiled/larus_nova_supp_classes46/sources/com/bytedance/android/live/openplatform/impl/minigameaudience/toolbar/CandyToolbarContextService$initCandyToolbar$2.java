package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.config.j90;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class CandyToolbarContextService$initCandyToolbar$2 implements ToolbarComponentCheckInterface {
    public final /* synthetic */ CandyToolbarContextService a;
    public final /* synthetic */ long b;

    public CandyToolbarContextService$initCandyToolbar$2(CandyToolbarContextService r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r5, final Function0<Unit> r6, Function1<? super String, Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "model");
        Intrinsics.checkNotNullParameter(r6, "loadButton");
        Intrinsics.checkNotNullParameter(r7, "stopLoadCallback");
        int r0 = qo0.a.a;
        qo0.a.c(this.a.a, "checkThenLoad, pre=" + r5.isPreloadScene() + ", this=" + this.a);
        String r1 = r5.getComponentExtra();
        int r2 = r5.getSource();
        if (r2 == 0) goto L9;
        if (r2 == 1) goto L7;
    L26:
        return true;
    L7:
        if (r5.getComponentId() != 9) goto L26;
        qo0.a.c(this.a.a, "candy toolbar message from IM message, extras: " + r1);
        CandyToolbarContextService.g(this.a, r6, r7);
        goto L26
    L9:
        qo0.a.c(this.a.a, "candy toolbar message from enter room, extras: " + r1);
        if (((Boolean) j90.a.getValue()).booleanValue() == true) goto L27;
        CandyToolbarContextService.g(this.a, new CandyToolbarContextService$initCandyToolbar$2$checkThenLoad$2(this, r6), r7);
        goto L26
    L27:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L13
        Object r9 = Result.constructor-impl((fr0.b.a) GsonHelper.get().fromJson(r1, fr0.b.a.class));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r9) == false) goto L18;
        r9 = null;
    L18:
        fr0.b.a r10 = (fr0.b.a) r9;
        if (r10 != null) goto L22;
        CandyToolbarContextService.g(this.a, new CandyToolbarContextService$initCandyToolbar$2$checkThenLoad$1(this, r6), r7);
        goto L26
    L22:
        if (r10.c() == false) goto L24;
        r7.invoke("candy disable entrance is true.");
        this.a.b = null;
        goto L26
    L24:
        this.a.j(r10, r6, true);
        CandyToolbarContextService.f(this.a, true, true, this.b);
    L13:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
