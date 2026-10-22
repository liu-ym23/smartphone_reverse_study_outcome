package com.obric.assistant.remote_card_container;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$showMenu$1$2$1", f = "RemoteCardImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RemoteCardImpl$showMenu$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ o9a.b $menuBean;
    private /* synthetic */ Object L$0;
    int label;

    public RemoteCardImpl$showMenu$1$2$1(o9a.b r1, int r2, Continuation<? super RemoteCardImpl$showMenu$1$2$1> r3) {
        this.$menuBean = r1;
        this.$index = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RemoteCardImpl$showMenu$1$2$1 r0 = new RemoteCardImpl$showMenu$1$2$1(this.$menuBean, this.$index, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        o9a.b r6 = this.$menuBean;
        int r0 = this.$index;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        IHostApiCallback r7 = ((o9a.c) ListProtector.get(r6.a, r0)).b;     // Catch: Throwable -> L11
        if (r7 == null) goto L8;
        r7.onHostApiCallback(new Bundle());     // Catch: Throwable -> L11
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L11
    L13:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L17;
        FLogger.a.w("RemoteCardImpl", "failed: " + r10.getMessage(), r10);
    L17:
        return Unit.INSTANCE;
    L8:
        r8 = null;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
