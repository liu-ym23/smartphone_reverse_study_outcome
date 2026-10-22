package com.larus.ugc.feed.impl.ability;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CommunityCreateAbilityImpl", f = "CommunityCreateAbilityImpl.kt", i = {0}, l = {210}, m = "fetchTabList", n = {"params"}, s = {"L$0"})
public final class CommunityCreateAbilityImpl$fetchTabList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommunityCreateAbilityImpl this$0;

    public CommunityCreateAbilityImpl$fetchTabList$1(CommunityCreateAbilityImpl r1, Continuation<? super CommunityCreateAbilityImpl$fetchTabList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
