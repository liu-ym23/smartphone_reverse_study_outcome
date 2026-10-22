package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.AIGenBgImageViewModel$onClickConfirm$1$1$1", f = "Text2BgImageViewModel.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
public final class AIGenBgImageViewModel$onClickConfirm$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AIGenBgImageViewModel this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ AIGenBgImageViewModel a;

        public a(AIGenBgImageViewModel r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Unit r4 = (Unit) r2;
            Object r5 = AIGenBgImageViewModel.access$get_uiEvent$p(this.a).emit(b.a.a, r3);
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r5;
        L6:
            return Unit.INSTANCE;
        }
    }

    public AIGenBgImageViewModel$onClickConfirm$1$1$1(AIGenBgImageViewModel r1, Continuation<? super AIGenBgImageViewModel$onClickConfirm$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AIGenBgImageViewModel$onClickConfirm$1$1$1(this.this$0, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow<Unit> r6 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.a;
        MutableSharedFlow<Unit> r7 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.c;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
