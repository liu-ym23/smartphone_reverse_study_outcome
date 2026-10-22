package com.larus.bmhome.video.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment", f = "AiGenVideoDetailFragment.kt", i = {}, l = {620}, m = "getSubType", n = {}, s = {})
public final class AiGenVideoDetailFragment$getSubType$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    public AiGenVideoDetailFragment$getSubType$1(AiGenVideoDetailFragment r1, Continuation<? super AiGenVideoDetailFragment$getSubType$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AiGenVideoDetailFragment r3 = this.this$0;
        int r0 = AiGenVideoDetailFragment.U;
        return r3.na0(this);
    }
}
