package com.larus.canvas.feature.component.logic;

import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.im.bean.message.ImageData;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$prefetchNoWatermarkBlocksForReview$1", f = "GenImagePlannerComponent.kt", i = {}, l = {991}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$prefetchNoWatermarkBlocksForReview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CanvasBlock> $canvasBlocks;
    final /* synthetic */ List<ImageData> $images;
    final /* synthetic */ String $localId;
    final /* synthetic */ String $requestKey;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$prefetchNoWatermarkBlocksForReview$1(List<ImageData> r1, GenImagePlannerComponent r2, String r3, List<CanvasBlock> r4, String r5, Continuation<? super GenImagePlannerComponent$prefetchNoWatermarkBlocksForReview$1> r6) {
        this.$images = r1;
        this.this$0 = r2;
        this.$localId = r3;
        this.$canvasBlocks = r4;
        this.$requestKey = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new GenImagePlannerComponent$prefetchNoWatermarkBlocksForReview$1(this.$images, this.this$0, this.$localId, this.$canvasBlocks, this.$requestKey, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((Boolean) r4).booleanValue() == false) goto L14;
        GenImagePlannerComponent r5 = this.this$0;
        String r2 = this.$localId;
        List<CanvasBlock> r3 = this.$canvasBlocks;
        int r6 = GenImagePlannerComponent.W;
        r5.F4(r2, r3);
    L16:
        return Unit.INSTANCE;
    L14:
        Unit r7 = (Unit) this.this$0.T.remove(this.$requestKey);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CreationNoWatermarkManager r8 = CreationNoWatermarkManager.a;
        List<ImageData> r9 = this.$images;
        this.label = 1;
        r4 = r8.q(r9, "canvas_review_prefetch", this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
