package com.obric.aikernel.phx.sdk.api;

import com.bytedance.crash.constants.Constants;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$getPackage$2", f = "AIKernelApi.kt", i = {}, l = {Constants.UPLOAD_DISASTER_ESCAPE}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$getPackage$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends PackageResource>>, Object> {
    final /* synthetic */ String $business;
    final /* synthetic */ RequestParams $params;
    int label;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$getPackage$2(AIKernelApi r3, String r4, RequestParams r5, Continuation<? super AIKernelApi$getPackage$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$business = r4;
        this.$params = r5;
        super(1, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIKernelApi$getPackage$2(this.this$0, this.$business, this.$params, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Result<? extends PackageResource>> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<PackageResource>> r3) {
        return ((AIKernelApi$getPackage$2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AIKernelApi$getPackage$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r6 = ((Result) ZeusTransformUtils.preCheckCast(r7, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L12:
        return Result.m1420boximpl(r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        AIKernelApi r8 = this.this$0;
        String r2 = this.$business;
        RequestParams r4 = this.$params;
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r6 = AIKernelApi.m193access$getPackageResource0E7RQCE(r8, r2, r4, r3);
        if (r6 != r0) goto L12;
        return r0;
    }
}
