package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.a;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe$runConcurrentSafe$1", f = "CoroutinesSafe.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesSafe$runConcurrentSafe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Ref.ObjectRef<StackTraceElement[]> $stackTrace;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoroutinesSafe this$0;

    public CoroutinesSafe$runConcurrentSafe$1(CoroutinesSafe r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Ref.ObjectRef<StackTraceElement[]> r3, Continuation<? super CoroutinesSafe$runConcurrentSafe$1> r4) {
        this.this$0 = r1;
        this.$block = r2;
        this.$stackTrace = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CoroutinesSafe$runConcurrentSafe$1 r0 = new CoroutinesSafe$runConcurrentSafe$1(this.this$0, this.$block, this.$stackTrace, r6);
        r0.L$0 = r5;
        return r0;
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L18
    L16:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        CoroutinesSafe.a(this.this$0, r7);
        CoroutinesSafe r8 = this.this$0;
        Function1<Continuation<? super Unit>, Object> r2 = this.$block;
        Ref.ObjectRef<StackTraceElement[]> r3 = this.$stackTrace;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        SendChannel r9 = r8.b;     // Catch: Throwable -> L18
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("concurrentEvent");     // Catch: Throwable -> L18
        r9 = null;
    L13:
        StackTraceElement[] r5 = (StackTraceElement[]) r3.element;     // Catch: Throwable -> L18
        a r10 = new a(r2);     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        if (r9.send(r10, this) != r0) goto L16;
        return r0;
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
