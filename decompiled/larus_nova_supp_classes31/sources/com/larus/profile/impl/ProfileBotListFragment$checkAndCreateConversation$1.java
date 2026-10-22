package com.larus.profile.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileBotListFragment", f = "ProfileBotListFragment.kt", i = {}, l = {523, 525}, m = "checkAndCreateConversation", n = {}, s = {})
final class ProfileBotListFragment$checkAndCreateConversation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileBotListFragment this$0;

    public ProfileBotListFragment$checkAndCreateConversation$1(ProfileBotListFragment r1, Continuation<? super ProfileBotListFragment$checkAndCreateConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return ProfileBotListFragment.Z90(this.this$0, null, false, this);
    }
}
