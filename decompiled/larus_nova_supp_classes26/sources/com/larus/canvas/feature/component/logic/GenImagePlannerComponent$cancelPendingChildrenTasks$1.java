package com.larus.canvas.feature.component.logic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent", f = "GenImagePlannerComponent.kt", i = {0, 0, 0}, l = {1970, 1306}, m = "cancelPendingChildrenTasks", n = {"parentId", "toCancel", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
public final class GenImagePlannerComponent$cancelPendingChildrenTasks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$cancelPendingChildrenTasks$1(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$cancelPendingChildrenTasks$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        GenImagePlannerComponent r3 = this.this$0;
        int r0 = GenImagePlannerComponent.W;
        return r3.G3(null, this);
    }
}
