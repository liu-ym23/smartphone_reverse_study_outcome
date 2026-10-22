package com.larus.dora.impl.ota;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTAManager$scheduleStalledDownloadCheckLocked$1", f = "DoraOTAManager.kt", i = {}, l = {452}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAManager$scheduleStalledDownloadCheckLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e49.a $responseWrapper;
    final /* synthetic */ String $sn;
    int label;

    public DoraOTAManager$scheduleStalledDownloadCheckLocked$1(String r1, e49.a r2, Continuation<? super DoraOTAManager$scheduleStalledDownloadCheckLocked$1> r3) {
        this.$sn = r1;
        this.$responseWrapper = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOTAManager$scheduleStalledDownloadCheckLocked$1(this.$sn, this.$responseWrapper, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Object r7 = DoraOTAManager.h;
        String r2 = this.$sn;
        e49.a r3 = this.$responseWrapper;
        monitor-enter(r7);
        DoraOTAManager$a r4 = DoraOTAManager.i;     // Catch: Throwable -> L20
        if (r4 != null) goto L16;
    L22:
        boolean r5 = false;
    L23:
        monitor-exit(r7);
        if (r5 == false) goto L27;
        DoraOTAManager.a.h("stalled_timer", true);
    L27:
        return Unit.INSTANCE;
    L16:
        if (Intrinsics.areEqual(r4.a, r2) == false) goto L22;
        if (Intrinsics.areEqual(r4.b, r3) == false) goto L22;
        r5 = true;
    L20:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(60000, this) != r0) goto L11;
        return r0;
    }
}
