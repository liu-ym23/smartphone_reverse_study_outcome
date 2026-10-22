package com.larus.camera.impl.ui.viewmodel;

import com.larus.camera.api.params.OutputParam;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/api/params/OutputParam;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2$deferredSavedOutputParams$1$1", f = "CameraResultViewModel.kt", i = {}, l = {1553}, m = "invokeSuspend", n = {}, s = {})
public final class CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2$deferredSavedOutputParams$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OutputParam>, Object> {
    final /* synthetic */ OutputParam $outputParam;
    int label;
    final /* synthetic */ CameraResultViewModel this$0;

    public CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2$deferredSavedOutputParams$1$1(CameraResultViewModel r1, OutputParam r2, Continuation<? super CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2$deferredSavedOutputParams$1$1> r3) {
        this.this$0 = r1;
        this.$outputParam = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2$deferredSavedOutputParams$1$1(this.this$0, this.$outputParam, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super OutputParam> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CameraResultViewModel r5 = this.this$0;
        OutputParam r2 = this.$outputParam;
        this.label = 1;
        r4 = CameraResultViewModel.access$saveResultInMultiCaptureMode(r5, r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
