package com.larus.common.account.douyin;

import com.larus.common.account.douyin.network.DouyinAuthNetHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import n38.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinAuthHelper$checkDouyinAuthStatus$1", f = "DouyinAuthHelper.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
final class DouyinAuthHelper$checkDouyinAuthStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ r $callback;
    final /* synthetic */ String $clientKey;
    final /* synthetic */ String $scope;
    final /* synthetic */ String $state;
    int label;

    public DouyinAuthHelper$checkDouyinAuthStatus$1(String r1, String r2, String r3, r r4, Continuation<? super DouyinAuthHelper$checkDouyinAuthStatus$1> r5) {
        this.$clientKey = r1;
        this.$scope = r2;
        this.$state = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DouyinAuthHelper$checkDouyinAuthStatus$1(this.$clientKey, this.$scope, this.$state, this.$callback, r8);
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
    L11:
        boolean r7 = ((Boolean) r6).booleanValue();
        this.$callback.a(r7, this.$clientKey, this.$scope, this.$state);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DouyinAuthNetHelper r8 = DouyinAuthNetHelper.a;
        String r2 = this.$clientKey;
        String r3 = this.$scope;
        String r4 = this.$state;
        this.label = 1;
        r6 = r8.b(r2, r3, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
