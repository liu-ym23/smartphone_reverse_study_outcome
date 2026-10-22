package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.ReferenceMessage$Companion", f = "ReferenceMessage.kt", i = {0, 0, 0, 1, 1, 1}, l = {185, 200}, m = "build", n = {"info", "defaultContent", "msgId", "info", "refMessage", "exist"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "Z$0"})
public final class ReferenceMessage$Companion$build$8 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReferenceMessage.Companion this$0;

    public ReferenceMessage$Companion$build$8(ReferenceMessage.Companion r1, Continuation<? super ReferenceMessage$Companion$build$8> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
