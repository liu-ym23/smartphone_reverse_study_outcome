package com.larus.ugc.feed.impl.ability;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl", f = "CreationFeedAbilityImpl.kt", i = {0}, l = {165}, m = "checkCurrentData", n = {"requestIndex"}, s = {"I$0"})
public final class CreationFeedAbilityImpl$checkCurrentData$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationFeedAbilityImpl this$0;

    public CreationFeedAbilityImpl$checkCurrentData$1(CreationFeedAbilityImpl r1, Continuation<? super CreationFeedAbilityImpl$checkCurrentData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(false, this);
    }
}
