package com.obric.assistant.state.impl.v2.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.utils.CoroutineExtKt", f = "CoroutineExt.kt", i = {0, 0}, l = {22}, m = "delayAwareOfSleep", n = {"delayMillis", "startTime"}, s = {"J$0", "J$1"})
public final class CoroutineExtKt$delayAwareOfSleep$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;

    public CoroutineExtKt$delayAwareOfSleep$1(Continuation<? super CoroutineExtKt$delayAwareOfSleep$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return CoroutineExtKt.a(0, this);
    }
}
