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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository$checkUpdate$3", f = "DoraOTACheckRepository.kt", i = {1, 2}, l = {73, 87, 88}, m = "invokeSuspend", n = {"peripheralResponseDeferred", "normalResponseResult"}, s = {"L$0", "L$0"})
public final class DoraOTACheckRepository$checkUpdate$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends e49.a>>, Object> {
    final /* synthetic */ String $buildTime;
    final /* synthetic */ String $buildType;
    final /* synthetic */ d $dataSource;
    final /* synthetic */ boolean $includePeripheralResponse;
    final /* synthetic */ String $model;
    final /* synthetic */ String $osVersion;
    final /* synthetic */ String $pkgType;
    final /* synthetic */ String $product;
    final /* synthetic */ String $romVersion;
    final /* synthetic */ String $sn;
    private /* synthetic */ Object L$0;
    int label;

    public DoraOTACheckRepository$checkUpdate$3(boolean r1, d r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Continuation<? super DoraOTACheckRepository$checkUpdate$3> r11) {
        this.$includePeripheralResponse = r1;
        this.$dataSource = r2;
        this.$product = r3;
        this.$model = r4;
        this.$sn = r5;
        this.$osVersion = r6;
        this.$romVersion = r7;
        this.$buildTime = r8;
        this.$pkgType = r9;
        this.$buildType = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        DoraOTACheckRepository$checkUpdate$3 r12 = new DoraOTACheckRepository$checkUpdate$3(this.$includePeripheralResponse, this.$dataSource, this.$product, this.$model, this.$sn, this.$osVersion, this.$romVersion, this.$buildTime, this.$pkgType, this.$buildType, r15);
        r12.L$0 = r14;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<e49.a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = true;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        Object r3 = this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r4 = r22;
    L25:
        e49.a r6 = (e49.a) r4;
        StringBuilder r7 = new StringBuilder("checkUpdate: normalSuccess=");
        r7.append(Result.isSuccess-impl(r3));
        r7.append(", hasPeripheralResponse=");
        if (r6 != null) goto L29;
        r5 = false;
    L29:
        r7.append(r5);
        g49.d.d("DoraOTACheckRepository", r7.toString());
        if (r6 == null) goto L32;
        g49.d.d("DoraOTACheckRepository", "checkUpdate: use peripheral response");
        r3 = Result.constructor-impl(r6);
    L34:
        return Result.box-impl(r3);
    L32:
        g49.d.d("DoraOTACheckRepository", "checkUpdate: use normal response");
        goto L34
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Deferred r8 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r9 = r22;
    L21:
        Object r10 = ((Result) r9).unbox-impl();
        this.L$0 = r10;
        this.label = 3;
        r4 = r8.await(this);
        if (r4 != r1) goto L24;
        return r1;
    L24:
        r3 = r10;
        goto L25
    L11:
        ResultKt.throwOnFailure(r22);
        return r22;
    L12:
        ResultKt.throwOnFailure(r22);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Deferred r12 = BuildersKt.async$default(r11, null, null, new DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1(this.$dataSource, this.$product, this.$model, this.$sn, this.$osVersion, this.$romVersion, this.$buildTime, this.$pkgType, this.$buildType, null), 3, null);
        if (this.$includePeripheralResponse == true) goto L18;
        this.label = 1;
        Object r13 = r12.await(this);
        if (r13 != r1) goto L35;
        return r1;
    L35:
        return r13;
    L18:
        r8 = BuildersKt.async$default(r11, null, null, new DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1(null), 3, null);
        this.L$0 = r8;
        this.label = 2;
        r9 = r12.await(this);
        if (r9 != r1) goto L21;
        return r1;
    }
}
