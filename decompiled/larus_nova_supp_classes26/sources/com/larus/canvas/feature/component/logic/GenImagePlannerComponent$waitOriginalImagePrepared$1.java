package com.larus.canvas.feature.component.logic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent", f = "GenImagePlannerComponent.kt", i = {}, l = {950}, m = "waitOriginalImagePrepared", n = {}, s = {})
final class GenImagePlannerComponent$waitOriginalImagePrepared$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$waitOriginalImagePrepared$1(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$waitOriginalImagePrepared$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return GenImagePlannerComponent.D3(this.this$0, this);
    }
}
