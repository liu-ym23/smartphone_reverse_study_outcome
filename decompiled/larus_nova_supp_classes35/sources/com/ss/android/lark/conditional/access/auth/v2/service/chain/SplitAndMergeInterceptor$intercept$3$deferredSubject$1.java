package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.l;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/conditional/access/auth/v2/FilePolicyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.SplitAndMergeInterceptor$intercept$3$deferredSubject$1", f = "SplitAndMergeInterceptor.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {"preTraceId$iv$iv"}, s = {"L$0"})
public final class SplitAndMergeInterceptor$intercept$3$deferredSubject$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends com.ss.android.lark.conditional.access.auth.v2.c>>, Object> {
    final /* synthetic */ l $chain;
    final /* synthetic */ List<PolicyModel> $models;
    Object L$0;
    int label;

    public SplitAndMergeInterceptor$intercept$3$deferredSubject$1(l r1, List<PolicyModel> r2, Continuation<? super SplitAndMergeInterceptor$intercept$3$deferredSubject$1> r3) {
        this.$chain = r1;
        this.$models = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SplitAndMergeInterceptor$intercept$3$deferredSubject$1(this.$chain, this.$models, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, com.ss.android.lark.conditional.access.auth.v2.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L8
    L18:
        Map r7 = (Map) r6;     // Catch: Throwable -> L8
        qqb.a.a();
        qqb.a.f(r2);
        return r7;
    L8:
        th = th;
    L25:
        qqb.a.a();
        qqb.a.f(r2);
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r6);
        String r8 = this.$chain.getTraceId();
        l r3 = this.$chain;
        List<PolicyModel> r4 = this.$models;
        String r5 = qqb.a.d();     // Catch: Throwable -> L23
        qqb.a.f(r8);     // Catch: Throwable -> L21
        this.L$0 = r5;     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        r6 = r3.a(r4, this);     // Catch: Throwable -> L21
        if (r6 != r0) goto L17;
        return r0;
    L17:
        r2 = r5;
    L21:
        th = th;
        r2 = r5;
    L23:
        th = th;
        r2 = BuildConfig.FLAVOR;
        goto L25
    }
}
