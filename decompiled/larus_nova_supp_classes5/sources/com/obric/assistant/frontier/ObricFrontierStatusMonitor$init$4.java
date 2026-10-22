package com.obric.assistant.frontier;

import android.os.PowerManager;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.frontier.ObricFrontierStatusMonitor$init$4", f = "ObricFrontierStatusMonitor.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
final class ObricFrontierStatusMonitor$init$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricFrontierStatusMonitor$init$4(Continuation<? super ObricFrontierStatusMonitor$init$4> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricFrontierStatusMonitor$init$4(r2);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Lazy r7 = d.a;
        PowerManager r8 = (PowerManager) d.c.getValue();
        if (r8 != null) goto L14;
    L16:
        r2 = false;
    L17:
        d.e = r2;
        if (d.b() == false) goto L23;
        FLogger.a.w("ObricFrontierStatusMonitor", "disconnet frontier after init");
        com.larus.im.f r9 = d.c();
        if (r9 == null) goto L23;
        r9.h("monitor init", false);
    L23:
        return Unit.INSTANCE;
    L14:
        if (r8.isInteractive() == true) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(30000, this) != r0) goto L11;
        return r0;
    }
}
