package com.larus.dora.impl.ota.check;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1", f = "DoraOTACheckRepository.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends e49.a>>, Object> {
    final /* synthetic */ String $buildTime;
    final /* synthetic */ String $buildType;
    final /* synthetic */ d $dataSource;
    final /* synthetic */ String $model;
    final /* synthetic */ String $osVersion;
    final /* synthetic */ String $pkgType;
    final /* synthetic */ String $product;
    final /* synthetic */ String $romVersion;
    final /* synthetic */ String $sn;
    int label;

    public DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1(d r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, Continuation<? super DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1> r10) {
        this.$dataSource = r1;
        this.$product = r2;
        this.$model = r3;
        this.$sn = r4;
        this.$osVersion = r5;
        this.$romVersion = r6;
        this.$buildTime = r7;
        this.$pkgType = r8;
        this.$buildType = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1(this.$dataSource, this.$product, this.$model, this.$sn, this.$osVersion, this.$romVersion, this.$buildTime, this.$pkgType, this.$buildType, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<e49.a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
        Object r13 = ((Result) r12).unbox-impl();
    L12:
        return Result.box-impl(r13);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        d r2 = this.$dataSource;
        String r14 = this.$product;
        String r3 = this.$model;
        String r4 = this.$sn;
        String r5 = this.$osVersion;
        String r6 = this.$romVersion;
        String r7 = this.$buildTime;
        String r8 = this.$pkgType;
        String r9 = this.$buildType;
        this.label = 1;
        r13 = r2.a(r14, r3, r4, r5, r6, r7, r8, r9, this);
        if (r13 != r0) goto L12;
        return r0;
    }
}
