package com.ss.android.lark.conditional.access.auth.v2.service;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$2", f = "CheckAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.m $callback;
    final /* synthetic */ Exception $e;
    final /* synthetic */ List<PolicyModel> $models;
    int label;

    public CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$2(Exception r1, List<PolicyModel> r2, com.ss.android.lark.security.compliance.api.model.filepolicy.m r3, Continuation<? super CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$2> r4) {
        this.$e = r1;
        this.$models = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$2(this.$e, this.$models, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r11);
        int r12 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CheckAuthService", "asyncCheckAuthorityWithMergedResult() error!, e:" + this.$e.getMessage() + '.');
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<T> r0 = this.$models.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        PolicyModel r1 = (PolicyModel) r0.next();
        String r2 = r1.getTaskId();
        com.ss.android.lark.conditional.access.auth.v2.c r9 = new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.DOWNGRADE, null, null, 1016);
        r9.q(r1.getPointKey());
        r13.put(r2, com.ss.android.lark.conditional.access.auth.v2.g.a(r9));
        goto L6
    L8:
        this.$callback.onResult(r13);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
