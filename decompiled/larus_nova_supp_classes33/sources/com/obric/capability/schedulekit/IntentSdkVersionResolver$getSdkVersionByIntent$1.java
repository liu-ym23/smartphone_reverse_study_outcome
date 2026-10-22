package com.obric.capability.schedulekit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.capability.schedulekit.IntentSdkVersionResolver", f = "IntentSdkVersionResolver.kt", i = {0}, l = {35}, m = "getSdkVersionByIntent", n = {"intentName"}, s = {"L$0"})
final class IntentSdkVersionResolver$getSdkVersionByIntent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public IntentSdkVersionResolver$getSdkVersionByIntent$1(c r1, Continuation<? super IntentSdkVersionResolver$getSdkVersionByIntent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
