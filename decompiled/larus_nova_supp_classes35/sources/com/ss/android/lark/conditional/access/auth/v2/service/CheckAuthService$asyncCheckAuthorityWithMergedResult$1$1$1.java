package com.ss.android.lark.conditional.access.auth.v2.service;

import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$1", f = "CheckAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.m $callback;
    final /* synthetic */ Map<String, ValidateResult> $finalResultMap;
    int label;

    public CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$1(com.ss.android.lark.security.compliance.api.model.filepolicy.m r1, Map<String, ValidateResult> r2, Continuation<? super CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$1> r3) {
        this.$callback = r1;
        this.$finalResultMap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$1(this.$callback, this.$finalResultMap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        this.$callback.onResult(this.$finalResultMap);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
