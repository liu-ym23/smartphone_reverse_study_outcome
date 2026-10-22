package com.larus.bot.impl.feature.edit.feature.autofill;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillUIBinder$showAutoFillSuggestDialog$1$3$1", f = "BotAutoFillUIBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillUIBinder$showAutoFillSuggestDialog$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotAutoFillUIBinder this$0;

    public BotAutoFillUIBinder$showAutoFillSuggestDialog$1$3$1(BotAutoFillUIBinder r1, Continuation<? super BotAutoFillUIBinder$showAutoFillSuggestDialog$1$3$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotAutoFillUIBinder$showAutoFillSuggestDialog$1$3$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r12);
        BotAutoFillUIBinder r13 = this.this$0;
        dv8.b r0 = r13.d;
        if (r0 == null) goto L8;
        c0.I(r0.f(), r13.d.d(), r13.d.o(), r13.d.c(), "auto_fill_skip", "auto_fill", r13.d.i(), r13.d.h(), r13.a, 513);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
