package com.larus.community.impl.home;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.home.CommunityCreateFragment", f = "CommunityCreateFragment.kt", i = {0, 0}, l = {368}, m = "openMixCreationPage", n = {"targetImageItem", "it"}, s = {"L$0", "L$1"})
final class CommunityCreateFragment$openMixCreationPage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommunityCreateFragment this$0;

    public CommunityCreateFragment$openMixCreationPage$1(CommunityCreateFragment r1, Continuation<? super CommunityCreateFragment$openMixCreationPage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CommunityCreateFragment.Y90(this.this$0, this);
    }
}
