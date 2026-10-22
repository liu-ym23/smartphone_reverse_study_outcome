package com.obric.audio.enroll.sidauth;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.sidauth.SidAuthSessionService$dispatchCacheTimeout$1", f = "SidAuthSessionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SidAuthSessionService$dispatchCacheTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ long $wkrId;
    int label;

    public SidAuthSessionService$dispatchCacheTimeout$1(long r1, String r3, Continuation<? super SidAuthSessionService$dispatchCacheTimeout$1> r4) {
        this.$wkrId = r1;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SidAuthSessionService$dispatchCacheTimeout$1(this.$wkrId, this.$reason, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        SidAuthSessionService r5 = SidAuthSessionService.a;
        long r0 = this.$wkrId;
        String r2 = this.$reason;
        r5.getClass();
        SidAuthSessionService.m(r0, r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
