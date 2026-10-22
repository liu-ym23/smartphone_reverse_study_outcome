package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.SetPrivateAction", f = "SetPrivateAction.kt", i = {0, 0}, l = {148}, m = "resolveCreationIdFromMessage", n = {"messageId", "taskId"}, s = {"L$0", "L$1"})
public final class SetPrivateAction$resolveCreationIdFromMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SetPrivateAction this$0;

    public SetPrivateAction$resolveCreationIdFromMessage$1(SetPrivateAction r1, Continuation<? super SetPrivateAction$resolveCreationIdFromMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        SetPrivateAction r3 = this.this$0;
        int r0 = SetPrivateAction.a;
        return r3.d(null, this);
    }
}
