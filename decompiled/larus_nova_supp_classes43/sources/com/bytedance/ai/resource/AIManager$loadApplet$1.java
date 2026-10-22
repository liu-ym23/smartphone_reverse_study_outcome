package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0}, l = {224, 227, 229}, m = "loadApplet", n = {"appletId", "extraInfo"}, s = {"L$0", "L$1"})
public final class AIManager$loadApplet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$loadApplet$1(AIManager r1, Continuation<? super AIManager$loadApplet$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.C(null, null, this);
    }
}
