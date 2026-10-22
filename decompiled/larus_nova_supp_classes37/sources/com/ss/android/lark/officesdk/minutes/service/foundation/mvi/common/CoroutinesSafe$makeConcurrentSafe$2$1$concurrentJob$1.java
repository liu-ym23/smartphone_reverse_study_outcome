package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1", f = "CoroutinesSafe.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ i<T> $it;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1(i<? super T> r1, Function1<? super Continuation<? super T>, ? extends Object> r2, Continuation<? super CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1> r3) {
        this.$it = r1;
        this.$block = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1(this.$it, this.$block, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Continuation r2 = (Continuation) this.L$0;
        ResultKt.throwOnFailure(r4);
    L12:
        r2.resumeWith(Result.constructor-impl(r4));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Continuation r5 = this.$it;
        Result.Companion r3 = Result.Companion;
        Function1<Continuation<? super T>, Object> r6 = this.$block;
        this.L$0 = r5;
        this.label = 1;
        Object r7 = r6.invoke(this);
        if (r7 != r0) goto L11;
        return r0;
    L11:
        r2 = r5;
        r4 = r7;
        goto L12
    }
}
