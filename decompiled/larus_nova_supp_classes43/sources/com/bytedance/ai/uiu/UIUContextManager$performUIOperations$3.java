package com.bytedance.ai.uiu;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager", f = "UIUContextManager.kt", i = {}, l = {260}, m = "performUIOperations", n = {}, s = {})
final class UIUContextManager$performUIOperations$3 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public UIUContextManager$performUIOperations$3(a r1, Continuation<? super UIUContextManager$performUIOperations$3> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return a.d(this.this$0, null, null, this);
    }
}
