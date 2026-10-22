package com.larus.uaigc.chat.markdown.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper", f = "CreationChatItemClickHelper.kt", i = {}, l = {1182}, m = "bindCreationItemLongClickListener", n = {}, s = {})
public final class CreationChatItemClickHelper$bindCreationItemLongClickListener$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationChatItemClickHelper this$0;

    public CreationChatItemClickHelper$bindCreationItemLongClickListener$1(CreationChatItemClickHelper r1, Continuation<? super CreationChatItemClickHelper$bindCreationItemLongClickListener$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, null, null, false, null, null, this);
    }
}
