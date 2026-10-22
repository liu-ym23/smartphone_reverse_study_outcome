package com.bytedance.android.anniex.lite.flow.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel", f = "PreTaskSchemaModel.kt", i = {0, 0, 1, 1}, l = {28, 29, 30}, m = "initWithData", n = {"this", "input", "this", "input"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class PreTaskSchemaModel$initWithData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreTaskSchemaModel this$0;

    public PreTaskSchemaModel$initWithData$1(PreTaskSchemaModel r1, Continuation<? super PreTaskSchemaModel$initWithData$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
