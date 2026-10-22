package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.hybrid.prefetch.EcRegisterDynamicCP$reportPreloadDynamic$scope$1", f = "EcRegisterDynamicCP.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EcRegisterDynamicCP$reportPreloadDynamic$scope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $errorCode;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ EcRegisterDynamicCP this$0;

    public EcRegisterDynamicCP$reportPreloadDynamic$scope$1(EcRegisterDynamicCP r1, String r10, boolean r11, Integer r12, Continuation r13) {
        this.this$0 = r1;
        this.$url = r10;
        this.$isSuccess = r11;
        this.$errorCode = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new EcRegisterDynamicCP$reportPreloadDynamic$scope$1(this.this$0, this.$url, this.$isSuccess, this.$errorCode, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r10);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L16
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L16
        r12.putOpt("client_preload_dynamic_url", this.$url);     // Catch: Throwable -> L16
        if (this.$isSuccess == false) goto L8;
        int r1 = 1;
    L9:
        r12.putOpt("client_preload_dynamic_result", Boxing.boxInt(r1));     // Catch: Throwable -> L16
        r12.putOpt(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, this.$errorCode);     // Catch: Throwable -> L16
        r12.putOpt("client_load_dynamic_start", Boxing.boxLong(this.this$0.a));     // Catch: Throwable -> L16
        r12.putOpt("client_load_dynamic_end", Boxing.boxLong(this.this$0.b));     // Catch: Throwable -> L16
        r12.putOpt("client_decode_dynamic_start", Boxing.boxLong(this.this$0.b));     // Catch: Throwable -> L16
        r12.putOpt("client_decode_dynamic_end", Boxing.boxLong(this.this$0.c));     // Catch: Throwable -> L16
        this.this$0.getClass();     // Catch: Throwable -> L16
        r12.putOpt("client_register_dynamic_start", Boxing.boxLong(0));     // Catch: Throwable -> L16
        this.this$0.getClass();     // Catch: Throwable -> L16
        r12.putOpt("client_register_dynamic_end", Boxing.boxLong(0));     // Catch: Throwable -> L16
        int r0 = ECSdk.a;     // Catch: Throwable -> L16
        IECHostService r13 = (IECHostService) ECSdk.a(IECHostService.class);     // Catch: Throwable -> L16
        if (r13 == null) goto L14;
        xi.a r14 = r13.getIECHostLogService();     // Catch: Throwable -> L16
        if (r14 == null) goto L14;
        r14.logV3("gyl_perf_preload_dynamic", r12);     // Catch: Throwable -> L16
    L14:
        Result.constructor-impl(r12);     // Catch: Throwable -> L16
    L19:
        return Unit.INSTANCE;
    L8:
        r1 = 0;
    L16:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
