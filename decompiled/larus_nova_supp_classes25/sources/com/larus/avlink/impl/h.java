package com.larus.avlink.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ DoraAVLinkServiceImpl a;
    public final /* synthetic */ w88.f b;

    public /* synthetic */ h(DoraAVLinkServiceImpl r1, w88.f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraAVLinkServiceImpl r0 = this.a;
        w88.f r1 = this.b;
        if (r0.m.containsKey(r1) == false) goto L14;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        r1.a();     // Catch: Throwable -> L6
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L15;
        FLogger.a.e("DoraAVLinkServiceImpl", "notifyAlbumMediaChanged listener failed", r4);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
