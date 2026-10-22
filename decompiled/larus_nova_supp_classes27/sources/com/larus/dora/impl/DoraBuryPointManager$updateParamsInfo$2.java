package com.larus.dora.impl;

import com.larus.applog.api.IApplog;
import java.util.Iterator;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraBuryPointManager$updateParamsInfo$2", f = "DoraBuryPointManager.kt", i = {}, l = {687}, m = "invokeSuspend", n = {}, s = {})
final class DoraBuryPointManager$updateParamsInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $delay;
    int label;

    public DoraBuryPointManager$updateParamsInfo$2(boolean r1, Continuation<? super DoraBuryPointManager$updateParamsInfo$2> r2) {
        this.$delay = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraBuryPointManager$updateParamsInfo$2(this.$delay, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L13:
        DoraBuryPointManager.a.getClass();
        Iterator r5 = DoraBuryPointManager.x().entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r5.next();
        IApplog.a.a((String) r2.getKey(), r2.getValue());
        goto L15
    L17:
        Iterator r6 = DoraBuryPointManager.w(DoraBuryPointManager.a, null, 7).entrySet().iterator();
    L19:
        if (r6.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) r6.next();
        IApplog.a.i((String) r3.getKey(), r3.getValue());
        goto L19
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        if (this.$delay == false) goto L13;
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L13;
        return r0;
    }
}
