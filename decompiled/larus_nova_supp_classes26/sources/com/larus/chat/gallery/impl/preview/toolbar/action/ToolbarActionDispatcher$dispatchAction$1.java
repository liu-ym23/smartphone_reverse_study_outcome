package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.ToolbarActionDispatcher$dispatchAction$1", f = "ToolbarActionDispatcher.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class ToolbarActionDispatcher$dispatchAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o $action;
    final /* synthetic */ l0 $contextWithOverflow;
    final /* synthetic */ ToolbarButtonType $type;
    private /* synthetic */ Object L$0;
    int label;

    public ToolbarActionDispatcher$dispatchAction$1(o r1, l0 r2, ToolbarButtonType r3, Continuation<? super ToolbarActionDispatcher$dispatchAction$1> r4) {
        this.$action = r1;
        this.$contextWithOverflow = r2;
        this.$type = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ToolbarActionDispatcher$dispatchAction$1 r0 = new ToolbarActionDispatcher$dispatchAction$1(this.$action, this.$contextWithOverflow, this.$type, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        ToolbarButtonType r2 = this.$type;
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L21;
        FLogger.a.w("ToolbarActionDispatcher", "Action " + r2 + " failed: " + r7.getMessage(), r7);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        o r9 = this.$action;
        l0 r3 = this.$contextWithOverflow;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r9.a(r3, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
