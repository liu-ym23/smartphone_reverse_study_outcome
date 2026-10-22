package com.larus.common.account.bdauth.model;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import za7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.model.CustomAuthorizePresenter$doRequestAuthInfo$result$1", f = "CustomAuthorizePresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CustomAuthorizePresenter$doRequestAuthInfo$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ za7.c $authInfoResponseV2;
    final /* synthetic */ fb7.c $request;
    int label;
    final /* synthetic */ a this$0;

    public CustomAuthorizePresenter$doRequestAuthInfo$result$1(za7.c r1, a r2, fb7.c r3, Continuation<? super CustomAuthorizePresenter$doRequestAuthInfo$result$1> r4) {
        this.$authInfoResponseV2 = r1;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CustomAuthorizePresenter$doRequestAuthInfo$result$1(this.$authInfoResponseV2, null, this.$request, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        za7.c r3 = this.$authInfoResponseV2;
        if (r3 != null) goto L7;
    L11:
        int r4 = a.a;
        throw null;
    L7:
        if (((d) r3).a == false) goto L11;
        int r5 = a.a;
        throw null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
