package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.api.model.filepolicy.h;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/LinkedHashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/conditional/access/auth/v2/FilePolicyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.SplitAndMergeInterceptor$intercept$3", f = "SplitAndMergeInterceptor.kt", i = {0, 0}, l = {74, 75}, m = "invokeSuspend", n = {"deferredObject", "$this$invokeSuspend_u24lambda_u240"}, s = {"L$0", "L$2"})
final class SplitAndMergeInterceptor$intercept$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LinkedHashMap<String, com.ss.android.lark.conditional.access.auth.v2.c>>, Object> {
    final /* synthetic */ l $chain;
    final /* synthetic */ List<PolicyModel> $models;
    final /* synthetic */ List<PolicyModel> $objectPolicyModels;
    final /* synthetic */ long $startTime;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ f this$0;

    public SplitAndMergeInterceptor$intercept$3(l r1, List<PolicyModel> r2, List<PolicyModel> r3, f r4, long r5, Continuation<? super SplitAndMergeInterceptor$intercept$3> r7) {
        this.$chain = r1;
        this.$models = r2;
        this.$objectPolicyModels = r3;
        this.this$0 = r4;
        this.$startTime = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        SplitAndMergeInterceptor$intercept$3 r8 = new SplitAndMergeInterceptor$intercept$3(this.$chain, this.$models, this.$objectPolicyModels, this.this$0, this.$startTime, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super LinkedHashMap<String, com.ss.android.lark.conditional.access.auth.v2.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L10;
        if (r4 == 1) goto L9;
        if (r4 != 2) goto L8;
        LinkedHashMap r5 = (LinkedHashMap) this.L$1;
        LinkedHashMap r6 = (LinkedHashMap) this.L$0;
        ResultKt.throwOnFailure(r20);
        LinkedHashMap r9 = r6;
        Object r7 = r20;
    L18:
        r5.putAll((Map) r7);
        LinkedHashMap r8 = new LinkedHashMap();
        String r10 = this.$chain.getTraceId();
        List<PolicyModel> r11 = this.$models;
        f r12 = this.this$0;
        long r13 = this.$startTime;
        String r14 = qqb.a.d();     // Catch: Throwable -> L45
        qqb.a.f(r10);     // Catch: Throwable -> L41
        Iterator<T> r15 = r11.iterator();     // Catch: Throwable -> L41
    L21:
        if (r15.hasNext() == false) goto L43;
        PolicyModel r16 = (PolicyModel) r15.next();     // Catch: Throwable -> L41
        int r17 = ScsLogger.a;     // Catch: Throwable -> L41
        ScsLogger.d("SecurityPolicy_CheckAuthService", "asyncCheckAuthorityWithMergedResult(), rawTaskId: " + r16.toRawString());     // Catch: Throwable -> L41
        com.ss.android.lark.conditional.access.auth.v2.c r18 = (com.ss.android.lark.conditional.access.auth.v2.c) r9.get(r16.getTaskId());     // Catch: Throwable -> L41
        PolicyModel r19 = h.j(r16);     // Catch: Throwable -> L41
        if (r19 == null) goto L26;
        com.ss.android.lark.conditional.access.auth.v2.c r110 = (com.ss.android.lark.conditional.access.auth.v2.c) r9.get(r19.getTaskId());     // Catch: Throwable -> L41
    L27:
        ScsLogger.d("SecurityPolicy_CheckAuthService", "asyncCheckAuthorityWithMergedResult(), subjectResult is " + r18 + ", objectResult is " + r110);     // Catch: Throwable -> L41
        if (r18 == null) goto L30;
        com.ss.android.lark.conditional.access.auth.v2.c r111 = r18.a(r110);     // Catch: Throwable -> L41
    L32:
        if (r111.h() != ResultType.ERROR) goto L39;
        if (com.ss.android.lark.conditional.access.utils.f.a() == false) goto L36;
    L38:
        r111 = com.ss.android.lark.conditional.access.utils.e.a();     // Catch: Throwable -> L41
        goto L39
    L36:
        if (Intrinsics.areEqual(r16.getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == false) goto L38;
        r111 = r12.a.d(r16);     // Catch: Throwable -> L41
    L39:
        FileAuthMonitor.UpdateTrigger[] r112 = FileAuthMonitor.a;     // Catch: Throwable -> L41
        FileAuthMonitor.q(r16, r111, FileAuthMonitor.CheckType.AsyncCheck, System.currentTimeMillis() - r13);     // Catch: Throwable -> L41
        r8.put(r16.getTaskId(), r111);     // Catch: Throwable -> L41
        goto L21
    L30:
        r111 = new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);     // Catch: Throwable -> L41
        goto L32
    L26:
        r110 = null;
        goto L27
    L43:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r14, "traceId");
        qqb.a.g(r14);
        return r8;
    L41:
        th = th;
    L47:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r14, "traceId");
        qqb.a.g(r14);
        throw th;
    L45:
        th = th;
        r14 = BuildConfig.FLAVOR;
        goto L47
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        LinkedHashMap r21 = (LinkedHashMap) this.L$3;
        LinkedHashMap r22 = (LinkedHashMap) this.L$2;
        LinkedHashMap r23 = (LinkedHashMap) this.L$1;
        Deferred r24 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r20);
        Deferred r113 = r24;
        r9 = r23;
        LinkedHashMap r25 = r21;
        Object r26 = r20;
    L14:
        r25.putAll((Map) r26);
        this.L$0 = r9;
        this.L$1 = r22;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        r7 = r113.await(this);
        if (r7 != r3) goto L17;
        return r3;
    L17:
        r5 = r22;
        goto L18
    L10:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r27 = (CoroutineScope) this.L$0;
        Deferred r114 = BuildersKt.async$default(r27, null, null, new SplitAndMergeInterceptor$intercept$3$deferredSubject$1(this.$chain, this.$models, null), 3, null);
        Deferred r28 = BuildersKt.async$default(r27, null, null, new SplitAndMergeInterceptor$intercept$3$deferredObject$1(this.$chain, this.$objectPolicyModels, null), 3, null);
        r25 = new LinkedHashMap();
        this.L$0 = r28;
        this.L$1 = r25;
        this.L$2 = r25;
        this.L$3 = r25;
        this.label = 1;
        r26 = r114.await(this);
        if (r26 != r3) goto L13;
        return r3;
    L13:
        r22 = r25;
        r113 = r28;
        r9 = r22;
        goto L14
    }
}
