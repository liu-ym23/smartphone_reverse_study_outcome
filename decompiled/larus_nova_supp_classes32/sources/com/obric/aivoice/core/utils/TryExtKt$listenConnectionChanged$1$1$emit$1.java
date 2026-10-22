package com.obric.aivoice.core.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1$1", f = "TryExt.kt", i = {}, l = {17}, m = "emit", n = {}, s = {})
public final class TryExtKt$listenConnectionChanged$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TryExtKt.AnonymousClass1.C00711<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public TryExtKt$listenConnectionChanged$1$1$emit$1(TryExtKt.AnonymousClass1.C00711<? super T> r1, Continuation<? super TryExtKt$listenConnectionChanged$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(false, (Continuation<? super Unit>) this);
    }
}
