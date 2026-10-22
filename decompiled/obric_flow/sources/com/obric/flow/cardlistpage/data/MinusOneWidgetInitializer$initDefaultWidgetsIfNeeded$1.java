package com.obric.flow.cardlistpage.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.data.MinusOneWidgetInitializer", f = "MinusOneWidgetInitializer.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {39, 59, 92}, m = "initDefaultWidgetsIfNeeded", n = {"this", "templates", "providers", "this", "templates", "providers", "existingOriginalIds", "this", "providers"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
final class MinusOneWidgetInitializer$initDefaultWidgetsIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ r this$0;

    public MinusOneWidgetInitializer$initDefaultWidgetsIfNeeded$1(r r5, Continuation<? super MinusOneWidgetInitializer$initDefaultWidgetsIfNeeded$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, this);
    }
}
