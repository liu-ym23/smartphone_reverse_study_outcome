package com.bytedance.live.artist.utils;

import com.bytedance.android.live.base.model.message.k0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@"}, d2 = {"", "method", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "continuation", "withSuspendTrace"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.bytedance.live.artist.utils.MethodTimeCostTracer", f = "MethodTimeCostTracer.kt", i = {0, 0, 0}, l = {k0.INDIVIUAL_CHAT_PRIORITY_LOW}, m = "withSuspendTrace", n = {"this", "method", "block"}, s = {"L$0", "L$1", "L$2"})
final class MethodTimeCostTracer$withSuspendTrace$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public MethodTimeCostTracer$withSuspendTrace$1(b r1, Continuation r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        b r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        MethodTimeCostTracer$withSuspendTrace$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L13;
        if (r3 != 1) goto L12;
        Function1 r9 = (Function1) r0.L$2;
        String r11 = (String) r0.L$1;
        b r4 = (b) r0.L$0;
        ResultKt.throwOnFailure(r2);
        r4.a(r11);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r2);
        r8.a.put(null, Long.valueOf(System.nanoTime()));
        r0.L$0 = r8;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new MethodTimeCostTracer$withSuspendTrace$1(r8, this);
        goto L6
    }
}
