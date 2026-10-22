package com.obric.assistant.interaction.impl.essentialtask.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.task.SecurityProvisionCheckTask", f = "SecurityProvisionCheckTask.kt", i = {}, l = {76, 85, 86}, m = "internalExecute", n = {}, s = {})
public final class SecurityProvisionCheckTask$internalExecute$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SecurityProvisionCheckTask this$0;

    public SecurityProvisionCheckTask$internalExecute$1(SecurityProvisionCheckTask r1, Continuation<? super SecurityProvisionCheckTask$internalExecute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.internalExecute(this);
    }
}
