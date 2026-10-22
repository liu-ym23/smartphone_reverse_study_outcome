package com.larus.bmhome.instruction.core.impl.controller;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/bmhome/instruction/core/impl/base/ControllerContextKt$runOnMainThreadIfNeed$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.controller.TranslatorController$getString$$inlined$runOnMainThreadIfNeed$1", f = "TranslatorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorController$getString$$inlined$runOnMainThreadIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $defaultValue$inlined;
    final /* synthetic */ String $key$inlined;
    int label;
    final /* synthetic */ TranslatorController this$0;

    public TranslatorController$getString$$inlined$runOnMainThreadIfNeed$1(Continuation r1, TranslatorController r2, String r3, String r4) {
        this.this$0 = r2;
        this.$key$inlined = r3;
        this.$defaultValue$inlined = r4;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new TranslatorController$getString$$inlined$runOnMainThreadIfNeed$1(r5, this.this$0, this.$key$inlined, this.$defaultValue$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        gb6.c r4 = (gb6.c) this.this$0.q.getValue();
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.getString(this.$key$inlined, this.$defaultValue$inlined);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
