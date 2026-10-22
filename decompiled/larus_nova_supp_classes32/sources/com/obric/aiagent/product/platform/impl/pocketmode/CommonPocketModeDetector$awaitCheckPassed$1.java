package com.obric.aiagent.product.platform.impl.pocketmode;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector", f = "CommonPocketModeDetector.kt", i = {}, l = {189}, m = "awaitCheckPassed$suspendImpl", n = {}, s = {})
public final class CommonPocketModeDetector$awaitCheckPassed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonPocketModeDetector this$0;

    public CommonPocketModeDetector$awaitCheckPassed$1(CommonPocketModeDetector r1, Continuation<? super CommonPocketModeDetector$awaitCheckPassed$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CommonPocketModeDetector.a(this.this$0, this);
    }
}
