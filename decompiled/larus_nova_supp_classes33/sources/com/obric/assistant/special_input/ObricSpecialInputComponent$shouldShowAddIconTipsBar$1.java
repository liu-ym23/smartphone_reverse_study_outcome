package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent", f = "ObricSpecialInputComponent.kt", i = {}, l = {2450}, m = "shouldShowAddIconTipsBar", n = {}, s = {})
final class ObricSpecialInputComponent$shouldShowAddIconTipsBar$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricSpecialInputComponent this$0;

    public ObricSpecialInputComponent$shouldShowAddIconTipsBar$1(ObricSpecialInputComponent r1, Continuation<? super ObricSpecialInputComponent$shouldShowAddIconTipsBar$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ObricSpecialInputComponent.h3(this.this$0, this);
    }
}
