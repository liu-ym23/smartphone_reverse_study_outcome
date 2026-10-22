package com.larus.camera.impl.edulibs.camera.internal.util;

import com.larus.camera.api.IFlowCamera;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ix8.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.internal.util.EduNetUtils$requestCloudDetectionByVlm$detectResult$1", f = "EduNetUtils.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
final class EduNetUtils$requestCloudDetectionByVlm$detectResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    final /* synthetic */ ix8.c $request;
    int label;

    public EduNetUtils$requestCloudDetectionByVlm$detectResult$1(ix8.c r1, Continuation<? super EduNetUtils$requestCloudDetectionByVlm$detectResult$1> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EduNetUtils$requestCloudDetectionByVlm$detectResult$1(this.$request, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super d> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L16:
        return (d) r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IFlowCamera r5 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r5 == null) goto L14;
        ix8.c r2 = this.$request;
        this.label = 1;
        r4 = r5.d(r2, this);
        if (r4 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
