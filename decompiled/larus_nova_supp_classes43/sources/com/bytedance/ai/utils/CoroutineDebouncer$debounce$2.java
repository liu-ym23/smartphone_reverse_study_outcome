package com.bytedance.ai.utils;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.utils.CoroutineDebouncer$debounce$2", f = "CoroutineDebouncer.kt", i = {}, l = {IAPI.OPTION_SET_USE_UDP_PATH, 34}, m = "invokeSuspend", n = {}, s = {})
final class CoroutineDebouncer$debounce$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
    final /* synthetic */ Object $param;
    int label;
    final /* synthetic */ d this$0;

    public CoroutineDebouncer$debounce$2(d r1, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r10, Object r11, Continuation<? super CoroutineDebouncer$debounce$2> r12) {
        this.this$0 = r1;
        this.$action = r10;
        this.$param = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CoroutineDebouncer$debounce$2(this.this$0, this.$action, this.$param, r11);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        Function2<Object, Continuation<? super Unit>, Object> r11 = this.$action;
        Object r12 = this.$param;
        this.label = 2;
        if (r11.invoke(r12, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        long r13 = this.this$0.a;
        this.label = 1;
        if (DelayKt.delay(r13, this) != r0) goto L13;
        return r0;
    }
}
