package com.larus.voicecall.impl.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallGateActivity", f = "RealtimeCallGateActivity.kt", i = {}, l = {335, 343}, m = "findOrCreateLocalConversationByBot", n = {}, s = {})
public final class RealtimeCallGateActivity$findOrCreateLocalConversationByBot$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallGateActivity this$0;

    public RealtimeCallGateActivity$findOrCreateLocalConversationByBot$1(RealtimeCallGateActivity r1, Continuation<? super RealtimeCallGateActivity$findOrCreateLocalConversationByBot$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        RealtimeCallGateActivity r3 = this.this$0;
        int r0 = RealtimeCallGateActivity.a;
        return r3.A1(null, this);
    }
}
