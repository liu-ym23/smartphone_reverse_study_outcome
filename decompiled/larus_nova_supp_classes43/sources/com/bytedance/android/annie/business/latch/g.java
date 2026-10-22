package com.bytedance.android.annie.business.latch;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.lynx.tasm.LynxView;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements l.a, Disposable {
    public final /* synthetic */ kx.a.b a;
    public final AtomicBoolean b;
    public final /* synthetic */ kx.a.b c;

    @Override // com.bytedance.android.annie.business.latch.l.a
    public final List<com.bytedance.android.latch.a.c> a() {
        HybridLogger.f("AnnieBusinessLatchService", "======createOrGetLynxModule=========", null, 12);
        return this.c.a();
    }

    public final void dispose() {
        this.a.dispose();
    }

    public final boolean isDisposed() {
        return this.a.isDisposed();
    }

    public g(kx.a.b r10) {
        this.c = r10;
        this.a = r10;
        this.b = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService.b
    public final void X0(IHybridComponent r10) {
        if (this.b.getAndSet(true) == false) goto L6;
        HybridLogger.f("AnnieBusinessLatchService", "======attachToHybridComponent: attachToHybridComponent has attached=========", null, 12);
        return;
    L6:
        HybridLogger.f("AnnieBusinessLatchService", "======attachToHybridComponent=========", null, 12);
        kx.a.b r0 = this.c;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        if (r10 == null) goto L10;
        View r12 = r10.getHybridView();     // Catch: Throwable -> L13
    L11:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.lynx.tasm.LynxView");     // Catch: Throwable -> L13
        r0.y((LynxView) r12);     // Catch: Throwable -> L13
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L21;
        this.b.set(false);
        HybridLogger r1 = HybridLogger.a;
        HybridLogger.i("AnnieBusinessLatchService", "attachToHybridComponent exception: " + r14, null, 12);
        return;
    L21:
        return;
    L10:
        r12 = null;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService.b
    public final void Y0(LynxView r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        if (this.b.getAndSet(true) == false) goto L6;
        HybridLogger.f("AnnieBusinessLatchService", "======attachToLynxView: attachToHybridComponent has attached=========", null, 12);
        return;
    L6:
        HybridLogger.f("AnnieBusinessLatchService", "======attachToLynxView=========", null, 12);
        if ((r10 instanceof LynxView) == true) goto L10;
        this.b.set(false);
        HybridLogger.i("AnnieBusinessLatchService", "attachToLynxView failed, view is not LynxView", null, 12);
        return;
    L10:
        kx.a.b r0 = this.c;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        r0.y(r10);     // Catch: Throwable -> L13
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L21;
        this.b.set(false);
        HybridLogger r1 = HybridLogger.a;
        HybridLogger.i("AnnieBusinessLatchService", "attachToLynxView exception: " + r13, null, 12);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
