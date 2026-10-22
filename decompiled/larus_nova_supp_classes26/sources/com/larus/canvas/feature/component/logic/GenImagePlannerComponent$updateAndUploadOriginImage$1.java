package com.larus.canvas.feature.component.logic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent", f = "GenImagePlannerComponent.kt", i = {0, 0, 2}, l = {1524, 1535, 1540, 1542}, m = "updateAndUploadOriginImage", n = {"localPath", "pipelineEnabled", "localPath"}, s = {"L$0", "Z$0", "L$0"})
public final class GenImagePlannerComponent$updateAndUploadOriginImage$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$updateAndUploadOriginImage$1(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$updateAndUploadOriginImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        GenImagePlannerComponent r0 = this.this$0;
        int r8 = GenImagePlannerComponent.W;
        return r0.V4(null, null, null, false, this);
    }
}
