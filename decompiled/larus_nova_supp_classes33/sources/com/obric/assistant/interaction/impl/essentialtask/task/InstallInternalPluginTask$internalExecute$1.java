package com.obric.assistant.interaction.impl.essentialtask.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.task.InstallInternalPluginTask", f = "InstallInternalPluginTask.kt", i = {}, l = {32}, m = "internalExecute", n = {}, s = {})
public final class InstallInternalPluginTask$internalExecute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InstallInternalPluginTask this$0;

    public InstallInternalPluginTask$internalExecute$1(InstallInternalPluginTask r1, Continuation<? super InstallInternalPluginTask$internalExecute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.internalExecute(this);
    }
}
