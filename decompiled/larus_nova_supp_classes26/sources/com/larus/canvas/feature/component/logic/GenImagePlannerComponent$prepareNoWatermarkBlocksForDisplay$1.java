package com.larus.canvas.feature.component.logic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent", f = "GenImagePlannerComponent.kt", i = {0, 0, 0}, l = {1096}, m = "prepareNoWatermarkBlocksForDisplay", n = {"localId", "canvasBlocks", "images"}, s = {"L$0", "L$1", "L$2"})
final class GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$1(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return GenImagePlannerComponent.p3(this.this$0, null, null, this);
    }
}
