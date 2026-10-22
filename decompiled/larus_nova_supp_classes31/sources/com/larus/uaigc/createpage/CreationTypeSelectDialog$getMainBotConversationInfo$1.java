package com.larus.uaigc.createpage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationTypeSelectDialog", f = "CreationTypeSelectDialog.kt", i = {0}, l = {720, 723}, m = "getMainBotConversationInfo", n = {"callback"}, s = {"L$0"})
public final class CreationTypeSelectDialog$getMainBotConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationTypeSelectDialog this$0;

    public CreationTypeSelectDialog$getMainBotConversationInfo$1(CreationTypeSelectDialog r1, Continuation<? super CreationTypeSelectDialog$getMainBotConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationTypeSelectDialog r3 = this.this$0;
        int r0 = CreationTypeSelectDialog.n;
        return r3.W90(null, this);
    }
}
