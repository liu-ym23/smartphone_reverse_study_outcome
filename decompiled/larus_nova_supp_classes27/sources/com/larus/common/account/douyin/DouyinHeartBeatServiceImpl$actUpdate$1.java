package com.larus.common.account.douyin;

import com.larus.network.http.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import n38.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinHeartBeatServiceImpl$actUpdate$1", f = "DouyinHeartBeatServiceImpl.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
final class DouyinHeartBeatServiceImpl$actUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n38.f $callback;
    final /* synthetic */ e $douYinTokenResult;
    final /* synthetic */ boolean $isAuto;
    int label;
    final /* synthetic */ DouyinHeartBeatServiceImpl this$0;

    public DouyinHeartBeatServiceImpl$actUpdate$1(DouyinHeartBeatServiceImpl r1, e r2, boolean r3, n38.f r4, Continuation<? super DouyinHeartBeatServiceImpl$actUpdate$1> r5) {
        this.this$0 = r1;
        this.$douYinTokenResult = r2;
        this.$isAuto = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DouyinHeartBeatServiceImpl$actUpdate$1(this.this$0, this.$douYinTokenResult, this.$isAuto, this.$callback, r8);
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
    L12:
        if ((((com.larus.network.http.a) r6) instanceof y) == false) goto L16;
        n38.f r7 = this.$callback;
        if (r7 == null) goto L20;
        e r2 = this.$douYinTokenResult;
        r7.onResult(r2.a, r2.b, r2.c);
    L20:
        return Unit.INSTANCE;
    L16:
        n38.f r8 = this.$callback;
        if (r8 == null) goto L20;
        r8.onResult(null, null, null);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DouyinHeartBeatServiceImpl r9 = this.this$0;
        e r3 = this.$douYinTokenResult;
        boolean r4 = this.$isAuto;
        this.label = 1;
        int r5 = DouyinHeartBeatServiceImpl.d;
        r6 = r9.h(r3, r4, null, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
