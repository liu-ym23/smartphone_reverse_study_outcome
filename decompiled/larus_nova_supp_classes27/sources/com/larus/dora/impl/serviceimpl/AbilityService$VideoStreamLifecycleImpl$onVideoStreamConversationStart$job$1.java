package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.AbilityService$VideoStreamLifecycleImpl$onVideoStreamConversationStart$job$1", f = "AbilityService.kt", i = {}, l = {221, 226}, m = "invokeSuspend", n = {}, s = {})
public final class AbilityService$VideoStreamLifecycleImpl$onVideoStreamConversationStart$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDoraService.a $ability;
    int label;

    public AbilityService$VideoStreamLifecycleImpl$onVideoStreamConversationStart$job$1(IDoraService.a r1, Continuation<? super AbilityService$VideoStreamLifecycleImpl$onVideoStreamConversationStart$job$1> r2) {
        this.$ability = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AbilityService$VideoStreamLifecycleImpl$onVideoStreamConversationStart$job$1(this.$ability, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L20:
        boolean r7 = ((Boolean) r6).booleanValue();
        FLogger.a.i("AbilityService", "prepare ordinary P2P RTC result: " + r7);
        if (r7 == true) goto L24;
        this.$ability.a();
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L14:
        if (((Boolean) r6).booleanValue() == true) goto L17;
        FLogger.a.e("AbilityService", "reset stale P2P RTC failed, keep Bluetooth RTC");
        return Unit.INSTANCE;
    L17:
        FLogger.a.i("AbilityService", "prepare ordinary P2P RTC");
        final IDoraService.a r8 = this.$ability;
        Function0 r2 = new e(r8);
        this.label = 2;
        r6 = a1.a(r2, this);
        if (r6 != r0) goto L20;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        final IDoraService.a r9 = this.$ability;
        Function0 r3 = new d(r9);
        this.label = 1;
        r6 = a1.a(r3, this);
        if (r6 != r0) goto L14;
        return r0;
    }
}
