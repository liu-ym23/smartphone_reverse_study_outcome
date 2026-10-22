package com.larus.profile.impl.creation.repository;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.repository.ProfileCreationFeedRepository", f = "ProfileCreationFeedRepository.kt", i = {}, l = {TraceLevel.ASSERT}, m = "fetchBatch", n = {}, s = {})
public final class ProfileCreationFeedRepository$fetchBatch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileCreationFeedRepository this$0;

    public ProfileCreationFeedRepository$fetchBatch$1(ProfileCreationFeedRepository r1, Continuation<? super ProfileCreationFeedRepository$fetchBatch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, null, null, null, this);
    }
}
