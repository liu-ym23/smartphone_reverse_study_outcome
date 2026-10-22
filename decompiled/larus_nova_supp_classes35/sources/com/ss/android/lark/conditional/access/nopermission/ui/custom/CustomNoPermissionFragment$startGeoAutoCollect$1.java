package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
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
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomNoPermissionFragment$startGeoAutoCollect$1", f = "CustomNoPermissionFragment.kt", i = {}, l = {559}, m = "invokeSuspend", n = {}, s = {})
final class CustomNoPermissionFragment$startGeoAutoCollect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ scb.b $factorService;
    final /* synthetic */ long $startMs;
    int label;
    final /* synthetic */ CustomNoPermissionFragment this$0;

    public CustomNoPermissionFragment$startGeoAutoCollect$1(scb.b r1, CustomNoPermissionFragment r2, Context r3, long r4, Continuation<? super CustomNoPermissionFragment$startGeoAutoCollect$1> r6) {
        this.$factorService = r1;
        this.this$0 = r2;
        this.$ctx = r3;
        this.$startMs = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CustomNoPermissionFragment$startGeoAutoCollect$1(this.$factorService, this.this$0, this.$ctx, this.$startMs, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
        Object r14 = ((Result) r13).unbox-impl();
    L12:
        if (this.this$0.isAdded() == false) goto L14;
        long r9 = System.currentTimeMillis() - this.$startMs;
        CustomNoPermissionFragment r2 = this.this$0;
        Throwable r3 = Result.exceptionOrNull-impl(r14);
        if (r3 != null) goto L18;
        ((scb.a) r14).getClass();
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "geoAutoCollect success");
        int r15 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.e("auto_geo", true, 0, "ok", r9, r2.i);
        r2.aa0("geoAutoCollect");
    L20:
        return Unit.INSTANCE;
    L18:
        int r16 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_CustomNoPermissionFragment", "geoAutoCollect failed: " + r3.getMessage() + ", render state2");
        int r17 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.e("auto_geo", false, -1, "system_error", r9, r2.i);
        r2.ba0();
        goto L20
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        scb.b r18 = this.$factorService;
        this.this$0.getActivity();
        this.label = 1;
        r14 = r18.a();
        if (r14 != r0) goto L12;
        return r0;
    }
}
