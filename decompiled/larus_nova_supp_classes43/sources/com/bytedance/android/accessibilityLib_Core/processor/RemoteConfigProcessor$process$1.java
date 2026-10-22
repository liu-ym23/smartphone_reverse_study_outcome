package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.remote.step.ApplyStep;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.RemoteConfigProcessor$process$1", f = "RemoteConfigProcessor.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {"start$iv"}, s = {"J$0"})
public final class RemoteConfigProcessor$process$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $update;
    long J$0;
    int label;

    public RemoteConfigProcessor$process$1(boolean r1, Continuation r10) {
        this.$update = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new RemoteConfigProcessor$process$1(this.$update, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r11 = this.J$0;
        ResultKt.throwOnFailure(r10);
    L13:
        if (("remoteConfig apply end, cost time = " + (System.currentTimeMillis() - r11)) == null) goto L16;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r13 = System.currentTimeMillis();
        ApplyStep r14 = (ApplyStep) RemoteConfigProcessor.c.getValue();
        Boolean r15 = Boxing.boxBoolean(this.$update);
        this.J$0 = r13;
        this.label = 1;
        if (r14.a(r15, this) != r0) goto L11;
        return r0;
    L11:
        r11 = r13;
        goto L13
    }
}
