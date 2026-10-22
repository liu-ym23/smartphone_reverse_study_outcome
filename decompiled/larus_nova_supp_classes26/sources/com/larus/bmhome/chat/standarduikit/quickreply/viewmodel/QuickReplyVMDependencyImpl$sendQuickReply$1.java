package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.QuickReplyVMDependencyImpl", f = "QuickReplyVMDependencyImpl.kt", i = {0}, l = {92}, m = "sendQuickReply", n = {"vmData"}, s = {"L$0"})
final class QuickReplyVMDependencyImpl$sendQuickReply$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickReplyVMDependencyImpl this$0;

    public QuickReplyVMDependencyImpl$sendQuickReply$1(QuickReplyVMDependencyImpl r1, Continuation<? super QuickReplyVMDependencyImpl$sendQuickReply$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return QuickReplyVMDependencyImpl.d(this.this$0, null, null, this);
    }
}
