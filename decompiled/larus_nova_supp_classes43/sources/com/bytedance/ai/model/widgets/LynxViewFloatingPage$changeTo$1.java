package com.bytedance.ai.model.widgets;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxViewFloatingPage$changeTo$1", f = "LynxViewFloatingPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LynxViewFloatingPage$changeTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $errorLogBlock;
    final /* synthetic */ Lifecycle.Event $event;
    final /* synthetic */ LifecycleRegistry $this_changeTo;
    int label;

    public LynxViewFloatingPage$changeTo$1(LifecycleRegistry r1, Lifecycle.Event r10, Function0<Unit> r11, Continuation<? super LynxViewFloatingPage$changeTo$1> r12) {
        this.$this_changeTo = r1;
        this.$event = r10;
        this.$errorLogBlock = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LynxViewFloatingPage$changeTo$1(this.$this_changeTo, this.$event, this.$errorLogBlock, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r10);
        LifecycleRegistry r11 = this.$this_changeTo;
        Lifecycle.Event r0 = this.$event;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        r11.handleLifecycleEvent(r0);     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        if (Result.exceptionOrNull-impl(r12) == null) goto L13;
        this.$errorLogBlock.invoke();
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
