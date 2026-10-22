package com.obric.aiagent.product.platform.api.pocketmode;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector", f = "PocketModeDetector.kt", i = {}, l = {69}, m = "awaitCheckPassed", n = {}, s = {})
public final class PocketModeDetector$awaitCheckPassed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PocketModeDetector this$0;

    public PocketModeDetector$awaitCheckPassed$1(PocketModeDetector r1, Continuation<? super PocketModeDetector$awaitCheckPassed$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
