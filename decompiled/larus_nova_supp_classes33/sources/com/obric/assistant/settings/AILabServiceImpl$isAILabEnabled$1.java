package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.AILabServiceImpl", f = "AILabServiceImpl.kt", i = {}, l = {101, 114}, m = "isAILabEnabled", n = {}, s = {})
public final class AILabServiceImpl$isAILabEnabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AILabServiceImpl this$0;

    public AILabServiceImpl$isAILabEnabled$1(AILabServiceImpl r1, Continuation<? super AILabServiceImpl$isAILabEnabled$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
