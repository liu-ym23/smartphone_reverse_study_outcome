package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import com.ss.android.lark.endpoint.security.detection.factor.EndpointSecurityFactorReportError;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomNoPermissionFragment$refreshWithGeoFactors$1", f = "CustomNoPermissionFragment.kt", i = {}, l = {1694}, m = "invokeSuspend", n = {}, s = {})
final class CustomNoPermissionFragment$refreshWithGeoFactors$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ scb.b $factorService;
    final /* synthetic */ boolean $isGeoChallengeType2;
    int label;
    final /* synthetic */ CustomNoPermissionFragment this$0;

    public CustomNoPermissionFragment$refreshWithGeoFactors$1(scb.b r1, CustomNoPermissionFragment r2, Context r3, boolean r4, Continuation<? super CustomNoPermissionFragment$refreshWithGeoFactors$1> r5) {
        this.$factorService = r1;
        this.this$0 = r2;
        this.$ctx = r3;
        this.$isGeoChallengeType2 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CustomNoPermissionFragment$refreshWithGeoFactors$1(this.$factorService, this.this$0, this.$ctx, this.$isGeoChallengeType2, r8);
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
        Object r7 = ((Result) r6).unbox-impl();
    L12:
        if (this.this$0.isAdded() == false) goto L14;
        boolean r2 = this.$isGeoChallengeType2;
        CustomNoPermissionFragment r3 = this.this$0;
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 != null) goto L18;
        int r5 = ScsLogger.a;
        ((scb.a) r7).getClass();
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "refreshWithGeoFactors: report done, code=0");
    L23:
        this.this$0.aa0("refresh_button");
        return Unit.INSTANCE;
    L18:
        if (r2 == true) goto L20;
    L22:
        int r8 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_CustomNoPermissionFragment", "refreshWithGeoFactors: report failed, " + r4.getMessage());
        goto L23
    L20:
        if ((r4 instanceof EndpointSecurityFactorReportError.LocationUnknown) == false) goto L22;
        r3.p = true;
        goto L22
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        scb.b r9 = this.$factorService;
        this.this$0.getActivity();
        this.label = 1;
        r7 = r9.a();
        if (r7 != r0) goto L12;
        return r0;
    }
}
