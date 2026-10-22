package com.obric.assistant.block.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.base.CheckLastMessageBlockHolder", f = "CheckLastMessageBlockHolder.kt", i = {0}, l = {153}, m = "getLastMessage", n = {"cvsId"}, s = {"L$0"})
final class CheckLastMessageBlockHolder$getLastMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CheckLastMessageBlockHolder<jc8.a> this$0;

    public CheckLastMessageBlockHolder$getLastMessage$1(CheckLastMessageBlockHolder<jc8.a> r1, Continuation<? super CheckLastMessageBlockHolder$getLastMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CheckLastMessageBlockHolder.j(this.this$0, null, this);
    }
}
