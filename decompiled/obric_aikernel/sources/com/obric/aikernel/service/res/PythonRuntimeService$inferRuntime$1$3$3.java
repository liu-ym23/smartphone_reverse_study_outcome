package com.obric.aikernel.service.res;

import com.bytedance.apm6.util.constant.NetConst;
import com.obric.aikernel.api.security.CertProvisionFeature;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.res.update.MetadataRequestException;
import com.obric.aikernel.res.update.MetadataRequestFailureKind;
import com.obric.aikernel.runtime.RuntimeConfigBuilder;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.y;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$inferRuntime$1$3$3", f = "PythonRuntimeService.kt", i = {0, 0}, l = {173}, m = "invokeSuspend", n = {"body", "certProvisionFeature"}, s = {"L$0", "L$1"})
final class PythonRuntimeService$inferRuntime$1$3$3 extends SuspendLambda implements Function2<y, Continuation<? super String>, Object> {
    final /* synthetic */ RuntimeConfigBuilder $this_apply;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$inferRuntime$1$3$3(RuntimeConfigBuilder r10, PythonRuntimeService r11, Continuation<? super PythonRuntimeService$inferRuntime$1$3$3> r12) {
        this.$this_apply = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        PythonRuntimeService$inferRuntime$1$3$3 r12 = new PythonRuntimeService$inferRuntime$1$3$3(this.$this_apply, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(y r10, Continuation<? super String> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(y r10, Continuation<? super String> r11) {
        return ((PythonRuntimeService$inferRuntime$1$3$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        CertProvisionFeature r12 = (CertProvisionFeature) this.L$1;
        y r14 = (y) this.L$0;
        ResultKt.throwOnFailure(r13);
    L12:
        boolean r15 = ((Boolean) r13).booleanValue();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L15
        Object r17 = Result.m32constructorimpl(Boxing.boxLong(r14.a()));     // Catch: Throwable -> L15
    L17:
        Long r18 = Boxing.boxLong(-1);
        if (Result.m38isFailureimpl(r17) == false) goto L20;
        r17 = r18;
    L20:
        long r19 = ((Number) r17).longValue();
        AIKLog r20 = AIKLog.INSTANCE;
        StringBuilder r21 = new StringBuilder();
        r21.append("networkRequestDelegate certReady=");
        r21.append(r15);
        r21.append(" feature=");
        r21.append(r12.getClass().getName());
        r21.append(" path=");
        AppContext r22 = AppContext.INSTANCE;
        r21.append(r22.getDistributePath());
        r21.append(" bodyLength=");
        r21.append(r19);
        r20.d("PythonRuntimeService", r21.toString());
        if (r15 == true) goto L38;
        r20.w("PythonRuntimeService", "networkRequestDelegate blocked by certProvision not ready feature=" + r12.getClass().getSimpleName());
        throw new MetadataRequestException(MetadataRequestFailureKind.TLS_BOOTSTRAP_PENDING, "metadata request cert provision not ready", null, 4, null);
    L38:
        Integer r23 = null;
        com.obric.aikernel.model.cloud.common.c r110 = PythonRuntimeService.i(this.this$0).c(r22.getDistributePath(), r14, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("x-use-ppe", NetConst.ENCRYPT_VERISON_CODE), TuplesKt.to("X-Distribute", "ai_kernel")}));     // Catch: Throwable -> L31
        StringBuilder r111 = new StringBuilder();
        r111.append("networkRequestDelegate: executePost ");
        r111.append(r110.h());
        r111.append(" code ");
        r111.append(r110.f());
        r111.append(' ');
        r111.append(r110.e());
        r111.append(" bodyLength:");
        String r24 = r110.b();
        if (r24 == null) goto L26;
        r23 = Boxing.boxInt(r24.length());
    L26:
        r111.append(r23);
        r20.i("PythonRuntimeService", r111.toString());
        MetadataRequestException r112 = k.a(r110);
        if (r112 == null) goto L29;
        throw r112;
    L29:
        return r110.b();
    L31:
        th = move-exception;
        throw k.b(th);
    L15:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        r14 = (y) this.L$0;
        CertProvisionFeature r113 = com.obric.aikernel.api.b.f4431a.b();
        this.L$0 = r14;
        this.L$1 = r113;
        this.label = 1;
        Object r26 = r113.c(this);
        if (r26 != r10) goto L11;
        return r10;
    L11:
        r12 = r113;
        r13 = r26;
        goto L12
    }
}
