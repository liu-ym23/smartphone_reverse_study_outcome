package com.ss.android.lark.conditional.access.auth.v2.service;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.CheckAuthService$asyncCheckAuthorityWithMergedResult$1", f = "CheckAuthService.kt", i = {0, 1, 2}, l = {73, 77, 81}, m = "invokeSuspend", n = {"preTraceId$iv", "preTraceId$iv", "preTraceId$iv"}, s = {"L$5", "L$3", "L$0"})
final class CheckAuthService$asyncCheckAuthorityWithMergedResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.security.compliance.api.model.filepolicy.m $callback;
    final /* synthetic */ List<PolicyModel> $models;
    final /* synthetic */ String $traceId;
    final /* synthetic */ ValidateConfig $validateConfig;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ d this$0;

    public CheckAuthService$asyncCheckAuthorityWithMergedResult$1(String r1, d r2, List<PolicyModel> r3, ValidateConfig r4, com.ss.android.lark.security.compliance.api.model.filepolicy.m r5, Continuation<? super CheckAuthService$asyncCheckAuthorityWithMergedResult$1> r6) {
        this.$traceId = r1;
        this.this$0 = r2;
        this.$models = r3;
        this.$validateConfig = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CheckAuthService$asyncCheckAuthorityWithMergedResult$1(this.$traceId, this.this$0, this.$models, this.$validateConfig, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r4 = BuildConfig.FLAVOR;
        if (r0 == 0) goto L24;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L11;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L59
    L55:
        qqb.a.a();
        qqb.a.f(r5);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r5 = (String) this.L$3;
        com.ss.android.lark.security.compliance.api.model.filepolicy.m r2 = (com.ss.android.lark.security.compliance.api.model.filepolicy.m) this.L$2;
        String r6 = (String) this.L$1;
        List<PolicyModel> r7 = (List) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L15 Throwable -> L59
    L15:
        e = e;
    L52:
        MainCoroutineDispatcher r8 = Dispatchers.getMain();     // Catch: Throwable -> L59
        CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$2 r9 = new CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$2(e, r7, r2, null);     // Catch: Throwable -> L59
        this.L$0 = r5;     // Catch: Throwable -> L59
        this.L$1 = null;     // Catch: Throwable -> L59
        this.L$2 = null;     // Catch: Throwable -> L59
        this.L$3 = null;     // Catch: Throwable -> L59
        this.L$4 = null;     // Catch: Throwable -> L59
        this.L$5 = null;     // Catch: Throwable -> L59
        this.label = 3;     // Catch: Throwable -> L59
        if (com.ss.android.lark.security.compliance.infra.log.a.b(r6, r8, r9, this) != r3) goto L55;
        return r3;
    L17:
        String r10 = (String) this.L$5;
        com.ss.android.lark.security.compliance.api.model.filepolicy.m r11 = (com.ss.android.lark.security.compliance.api.model.filepolicy.m) this.L$4;
        String r12 = (String) this.L$3;
        ValidateConfig r1 = (ValidateConfig) this.L$2;
        List<PolicyModel> r13 = (List) this.L$1;
        d r14 = (d) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L20 Exception -> L22
        Object r15 = r20;
        String r16 = r10;
        r7 = r13;
    L65:
        Map r17 = (Map) r15;     // Catch: Throwable -> L42 Exception -> L44
        r4 = qqb.a.d();     // Catch: Throwable -> L39
        qqb.a.f(r12);     // Catch: Throwable -> L39
        Map r18 = d.e(r14, r7, r17, r1);     // Catch: Throwable -> L39
        qqb.a.a();     // Catch: Throwable -> L42 Exception -> L44
        Intrinsics.checkNotNullParameter(r4, "traceId");     // Catch: Throwable -> L42 Exception -> L44
        qqb.a.g(r4);     // Catch: Throwable -> L42 Exception -> L44
        MainCoroutineDispatcher r19 = Dispatchers.getMain();     // Catch: Throwable -> L42 Exception -> L44
        CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$1 r21 = new CheckAuthService$asyncCheckAuthorityWithMergedResult$1$1$1(r11, r18, null);     // Catch: Throwable -> L42 Exception -> L44
        this.L$0 = r7;     // Catch: Throwable -> L42 Exception -> L44
        this.L$1 = r12;     // Catch: Throwable -> L42 Exception -> L44
        this.L$2 = r11;     // Catch: Throwable -> L42 Exception -> L44
        this.L$3 = r16;     // Catch: Throwable -> L42 Exception -> L44
        this.L$4 = null;     // Catch: Throwable -> L42 Exception -> L44
        this.L$5 = null;     // Catch: Throwable -> L42 Exception -> L44
        this.label = 2;     // Catch: Throwable -> L42 Exception -> L44
        if (com.ss.android.lark.security.compliance.infra.log.a.b(r12, r19, r21, this) != r3) goto L38;
        return r3;
    L38:
        r5 = r16;
    L39:
        th = move-exception;
        qqb.a.a();     // Catch: Throwable -> L42 Exception -> L44
        Intrinsics.checkNotNullParameter(r4, "traceId");     // Catch: Throwable -> L42 Exception -> L44
        qqb.a.g(r4);     // Catch: Throwable -> L42 Exception -> L44
        throw th;     // Catch: Throwable -> L42 Exception -> L44
    L44:
        e = e;
        r5 = r16;
        r2 = r11;
        r6 = r12;
        goto L52
    L22:
        e = e;
        r5 = r10;
        r2 = r11;
        r6 = r12;
        r7 = r13;
    L20:
        th = th;
    L61:
        qqb.a.a();
        qqb.a.f(r10);
        throw th;
    L24:
        ResultKt.throwOnFailure(r20);
        String r22 = this.$traceId;
        r14 = this.this$0;
        List<PolicyModel> r110 = this.$models;
        r1 = this.$validateConfig;
        com.ss.android.lark.security.compliance.api.model.filepolicy.m r111 = this.$callback;
        String r112 = qqb.a.d();     // Catch: Throwable -> L59
        qqb.a.f(r22);     // Catch: Throwable -> L57
        r16 = r112;
        com.ss.android.lark.conditional.access.auth.v2.service.chain.a r113 = new com.ss.android.lark.conditional.access.auth.v2.service.chain.a(r14.d, 0, r110, r1, BuildConfig.FLAVOR);     // Catch: Throwable -> L42 Exception -> L47
        this.L$0 = r14;     // Catch: Throwable -> L42 Exception -> L47
        this.L$1 = r110;     // Catch: Throwable -> L42 Exception -> L47
        this.L$2 = r1;     // Catch: Throwable -> L42 Exception -> L47
        this.L$3 = r22;     // Catch: Throwable -> L42 Exception -> L47
        this.L$4 = r111;     // Catch: Throwable -> L42 Exception -> L47
        this.L$5 = r16;     // Catch: Throwable -> L42 Exception -> L47
        this.label = 1;     // Catch: Throwable -> L42 Exception -> L47
        r15 = r113.a(r110, this);     // Catch: Throwable -> L42 Exception -> L47
        if (r15 != r3) goto L32;
        return r3;
    L32:
        r7 = r110;
        r12 = r22;
        r11 = r111;
    L42:
        th = th;
        r10 = r16;
    L47:
        e = e;
    L51:
        r5 = r16;
        r6 = r22;
        r7 = r110;
        r2 = r111;
        goto L52
    L49:
        e = e;
        r16 = r112;
    L57:
        th = th;
        r10 = r112;
    L59:
        th = th;
        r10 = BuildConfig.FLAVOR;
        goto L61
    }
}
