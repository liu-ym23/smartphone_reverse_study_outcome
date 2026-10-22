package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.a;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
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
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe$makeConcurrentSafe$2$1", f = "CoroutinesSafe.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesSafe$makeConcurrentSafe$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ i<T> $it;
    final /* synthetic */ Ref.ObjectRef<StackTraceElement[]> $stackTrace;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoroutinesSafe this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesSafe$makeConcurrentSafe$2$1(CoroutinesSafe r1, Ref.ObjectRef<StackTraceElement[]> r2, i<? super T> r3, Function1<? super Continuation<? super T>, ? extends Object> r4, Continuation<? super CoroutinesSafe$makeConcurrentSafe$2$1> r5) {
        this.this$0 = r1;
        this.$stackTrace = r2;
        this.$it = r3;
        this.$block = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CoroutinesSafe$makeConcurrentSafe$2$1 r6 = new CoroutinesSafe$makeConcurrentSafe$2$1(this.this$0, this.$stackTrace, this.$it, this.$block, r9);
        r6.L$0 = r8;
        return r6;
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        CoroutinesSafe.a(this.this$0, r7);
        SendChannel r4 = null;
        CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1 r8 = new CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1(this.$it, this.$block, null);
        StackTraceElement[] r3 = (StackTraceElement[]) this.$stackTrace.element;
        a r2 = new a(r8);
        SendChannel r9 = this.this$0.b;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("concurrentEvent");
    L12:
        this.label = 1;
        if (r4.send(r2, this) != r0) goto L16;
        return r0;
    L11:
        r4 = r9;
        goto L12
    }
}
