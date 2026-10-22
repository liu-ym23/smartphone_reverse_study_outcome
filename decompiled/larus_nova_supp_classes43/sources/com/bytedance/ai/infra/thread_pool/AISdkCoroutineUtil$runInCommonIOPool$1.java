package com.bytedance.ai.infra.thread_pool;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.infra.thread_pool.AISdkCoroutineUtil$runInCommonIOPool$1", f = "AISdkCoroutineUtil.kt", i = {}, l = {IAPI.OPTION_USE_BYTE_LINK_PLAYER}, m = "invokeSuspend", n = {}, s = {})
public final class AISdkCoroutineUtil$runInCommonIOPool$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    public AISdkCoroutineUtil$runInCommonIOPool$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super AISdkCoroutineUtil$runInCommonIOPool$1> r10) {
        this.$block = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AISdkCoroutineUtil$runInCommonIOPool$1 r0 = new AISdkCoroutineUtil$runInCommonIOPool$1(this.$block, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Function2<CoroutineScope, Continuation<? super Unit>, Object> r12 = this.$block;
        this.label = 1;
        if (r12.invoke(r11, this) != r0) goto L12;
        return r0;
    }
}
