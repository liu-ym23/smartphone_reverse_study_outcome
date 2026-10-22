package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.QuickReplyVMDependencyImpl", f = "QuickReplyVMDependencyImpl.kt", i = {0, 1}, l = {110, 113}, m = "buildReferenceInfo", n = {"referenceMessageId", "referenceMessageId"}, s = {"L$0", "L$0"})
public final class QuickReplyVMDependencyImpl$buildReferenceInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickReplyVMDependencyImpl this$0;

    public QuickReplyVMDependencyImpl$buildReferenceInfo$1(QuickReplyVMDependencyImpl r1, Continuation<? super QuickReplyVMDependencyImpl$buildReferenceInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        QuickReplyVMDependencyImpl r3 = this.this$0;
        LruCache<String, String> r0 = QuickReplyVMDependencyImpl.b;
        return r3.e(null, this);
    }
}
