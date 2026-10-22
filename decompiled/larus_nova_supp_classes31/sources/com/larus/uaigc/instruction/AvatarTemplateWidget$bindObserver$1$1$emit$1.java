package com.larus.uaigc.instruction;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.AvatarTemplateWidget$bindObserver$1$1", f = "AvatarTemplateWidget.kt", i = {}, l = {289, 315, 351, 377}, m = "emit", n = {}, s = {})
public final class AvatarTemplateWidget$bindObserver$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AvatarTemplateWidget$bindObserver$1.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarTemplateWidget$bindObserver$1$1$emit$1(AvatarTemplateWidget$bindObserver$1.AnonymousClass1<? super T> r1, Continuation<? super AvatarTemplateWidget$bindObserver$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(false, (Continuation<? super Unit>) this);
    }
}
