package com.larus.profile.impl;

import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.CreationServiceImpl", f = "CreationServiceImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {268, 270, 271}, m = "reportAutoAddCreation", n = {"messageId", "botId", "creationType", "creationId", "messageId", "botId", "creationType", "creationId", "cvsId", "messageId", "botId", "creationType", "creationId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class CreationServiceImpl$reportAutoAddCreation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationServiceImpl this$0;

    public CreationServiceImpl$reportAutoAddCreation$1(CreationServiceImpl r1, Continuation<? super CreationServiceImpl$reportAutoAddCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, null, null, null, this);
    }
}
