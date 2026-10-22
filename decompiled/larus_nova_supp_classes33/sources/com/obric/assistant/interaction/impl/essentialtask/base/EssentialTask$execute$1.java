package com.obric.assistant.interaction.impl.essentialtask.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask", f = "EssentialTask.kt", i = {0, 0, 0, 0, 1, 1}, l = {46, 64}, m = "execute", n = {"canRetry", "maxRetryCount", "index", "startTime", "canRetry", "maxRetryCount"}, s = {"Z$0", "I$0", "I$3", "J$0", "Z$0", "I$0"})
public final class EssentialTask$execute$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EssentialTask this$0;

    public EssentialTask$execute$1(EssentialTask r1, Continuation<? super EssentialTask$execute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(this);
    }
}
