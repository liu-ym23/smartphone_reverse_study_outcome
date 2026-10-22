package com.larus.bot.impl.common.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.FlowExtKt$throttleFirst$1$1", f = "FlowExt.kt", i = {}, l = {34}, m = "emit", n = {}, s = {})
public final class FlowExtKt$throttleFirst$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowExtKt$throttleFirst$1.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$throttleFirst$1$1$emit$1(FlowExtKt$throttleFirst$1.AnonymousClass1<? super T> r1, Continuation<? super FlowExtKt$throttleFirst$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (Continuation<? super Unit>) this);
    }
}
