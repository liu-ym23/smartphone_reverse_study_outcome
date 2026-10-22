package com.ss.android.lark.conditional.access.auth.v2.service;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.PolicyValidateService$handleEvent$2", f = "PolicyValidateService.kt", i = {0}, l = {183}, m = "invokeSuspend", n = {"preTraceId$iv"}, s = {"L$0"})
public final class PolicyValidateService$handleEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> $event;
    final /* synthetic */ String $traceId;
    Object L$0;
    int label;
    final /* synthetic */ PolicyValidateService this$0;

    public PolicyValidateService$handleEvent$2(String r1, PolicyValidateService r2, com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r3, Continuation<? super PolicyValidateService$handleEvent$2> r4) {
        this.$traceId = r1;
        this.this$0 = r2;
        this.$event = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PolicyValidateService$handleEvent$2(this.$traceId, this.this$0, this.$event, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L8
    L18:
        qqb.a.a();
        qqb.a.f(r2);
        return Unit.INSTANCE;
    L8:
        th = th;
    L24:
        qqb.a.a();
        qqb.a.f(r2);
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        String r9 = this.$traceId;
        PolicyValidateService r3 = this.this$0;
        com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r4 = this.$event;
        String r5 = qqb.a.d();     // Catch: Throwable -> L22
        qqb.a.f(r9);     // Catch: Throwable -> L20
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "accept CCMDLPUpdateEvent, do policyValidateWithCoroutine");     // Catch: Throwable -> L20
        List<PolicyModel> r10 = ((i8b.d) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((i8b.e) r4)).a).a;     // Catch: Throwable -> L20
        FileAuthMonitor.a r6 = new FileAuthMonitor.a(FileAuthMonitor.UpdateTrigger.DocScene, ((i8b.d) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((i8b.e) r4)).a).getIdentifier());     // Catch: Throwable -> L20
        this.L$0 = r5;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        if (r3.e(r10, r6, this) != r0) goto L17;
        return r0;
    L17:
        r2 = r5;
    L20:
        th = th;
        r2 = r5;
    L22:
        th = th;
        r2 = BuildConfig.FLAVOR;
        goto L24
    }
}
