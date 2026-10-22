package com.obric.assistant.obric_action.handler.prompt;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.prompt.PromptConfirmDialogActionHandler", f = "PromptDialogActionHandlers.kt", i = {}, l = {136}, m = "execute", n = {}, s = {})
final class PromptConfirmDialogActionHandler$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PromptConfirmDialogActionHandler this$0;

    public PromptConfirmDialogActionHandler$execute$1(PromptConfirmDialogActionHandler r1, Continuation<? super PromptConfirmDialogActionHandler$execute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
