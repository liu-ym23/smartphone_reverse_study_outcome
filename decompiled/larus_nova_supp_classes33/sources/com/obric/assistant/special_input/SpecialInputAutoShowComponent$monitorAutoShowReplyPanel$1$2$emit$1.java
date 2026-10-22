package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2", f = "SpecialInputAutoShowComponent.kt", i = {0, 0}, l = {253}, m = "emit", n = {"autoShowClarifyTask", "clarifyMsgId"}, s = {"L$0", "L$1"})
public final class SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1.AnonymousClass2<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1(SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1.AnonymousClass2<? super T> r1, Continuation<? super SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
