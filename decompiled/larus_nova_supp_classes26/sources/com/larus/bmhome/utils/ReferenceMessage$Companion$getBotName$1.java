package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.ReferenceMessage$Companion", f = "ReferenceMessage.kt", i = {0}, l = {133}, m = "getBotName", n = {"message"}, s = {"L$0"})
public final class ReferenceMessage$Companion$getBotName$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReferenceMessage.Companion this$0;

    public ReferenceMessage$Companion$getBotName$1(ReferenceMessage.Companion r1, Continuation<? super ReferenceMessage$Companion$getBotName$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, false, this);
    }
}
