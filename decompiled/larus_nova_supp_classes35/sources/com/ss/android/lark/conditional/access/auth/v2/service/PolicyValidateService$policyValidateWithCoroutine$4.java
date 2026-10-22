package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.v;
import i8b.w;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.PolicyValidateService$policyValidateWithCoroutine$4", f = "PolicyValidateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PolicyValidateService$policyValidateWithCoroutine$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Unit>>, Object> {
    final /* synthetic */ List<PolicyModel> $modifyPolicyModelList;
    final /* synthetic */ Map<String, b0> $modifyResultMap;
    final /* synthetic */ String $traceId;
    final /* synthetic */ FileAuthMonitor.a $updateInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PolicyValidateService this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.auth.v2.service.PolicyValidateService$policyValidateWithCoroutine$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.PolicyValidateService$policyValidateWithCoroutine$4$1", f = "PolicyValidateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<PolicyModel> $modifyPolicyModelList;
        final /* synthetic */ Map<String, b0> $modifyResultMap;
        final /* synthetic */ String $traceId;
        final /* synthetic */ FileAuthMonitor.a $updateInfo;
        int label;
        final /* synthetic */ PolicyValidateService this$0;

        public AnonymousClass1(String r1, PolicyValidateService r2, List<PolicyModel> r3, Map<String, b0> r4, FileAuthMonitor.a r5, Continuation<? super AnonymousClass1> r6) {
            this.$traceId = r1;
            this.this$0 = r2;
            this.$modifyPolicyModelList = r3;
            this.$modifyResultMap = r4;
            this.$updateInfo = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$traceId, this.this$0, this.$modifyPolicyModelList, this.$modifyResultMap, this.$updateInfo, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r8);
            String r9 = this.$traceId;
            PolicyValidateService r1 = this.this$0;
            List<PolicyModel> r2 = this.$modifyPolicyModelList;
            Map<String, b0> r3 = this.$modifyResultMap;
            FileAuthMonitor.a r4 = this.$updateInfo;
            String r5 = qqb.a.d();     // Catch: Throwable -> L11
            qqb.a.f(r9);     // Catch: Throwable -> L9
            ScsLogger.d("SecurityPolicy_PolicyValidateService", "notifyEvent ValidateUpdateEvent");     // Catch: Throwable -> L9
            w r10 = new w(new v(r2, r3, r4));     // Catch: Throwable -> L9
            int r6 = PolicyValidateService.c;     // Catch: Throwable -> L9
            r1.c(r10);     // Catch: Throwable -> L9
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r5, "traceId");
            qqb.a.g(r5);
            return Unit.INSTANCE;
        L9:
            th = th;
        L13:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r5, "traceId");
            qqb.a.g(r5);
            throw th;
        L11:
            th = th;
            r5 = BuildConfig.FLAVOR;
            goto L13
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PolicyValidateService$policyValidateWithCoroutine$4(String r1, PolicyValidateService r2, List<PolicyModel> r3, Map<String, b0> r4, FileAuthMonitor.a r5, Continuation<? super PolicyValidateService$policyValidateWithCoroutine$4> r6) {
        this.$traceId = r1;
        this.this$0 = r2;
        this.$modifyPolicyModelList = r3;
        this.$modifyResultMap = r4;
        this.$updateInfo = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        PolicyValidateService$policyValidateWithCoroutine$4 r7 = new PolicyValidateService$policyValidateWithCoroutine$4(this.$traceId, this.this$0, this.$modifyPolicyModelList, this.$modifyResultMap, this.$updateInfo, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Deferred<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r11);
        return BuildersKt.async$default((CoroutineScope) this.L$0, Dispatchers.getIO(), null, new AnonymousClass1(this.$traceId, this.this$0, this.$modifyPolicyModelList, this.$modifyResultMap, this.$updateInfo, null), 2, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
