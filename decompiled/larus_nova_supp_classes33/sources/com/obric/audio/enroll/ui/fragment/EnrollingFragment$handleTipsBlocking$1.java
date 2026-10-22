package com.obric.audio.enroll.ui.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment", f = "EnrollingFragment.kt", i = {0}, l = {618}, m = "handleTipsBlocking", n = {"ev"}, s = {"L$0"})
final class EnrollingFragment$handleTipsBlocking$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$handleTipsBlocking$1(EnrollingFragment r1, Continuation<? super EnrollingFragment$handleTipsBlocking$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return EnrollingFragment.T90(this.this$0, null, this);
    }
}
