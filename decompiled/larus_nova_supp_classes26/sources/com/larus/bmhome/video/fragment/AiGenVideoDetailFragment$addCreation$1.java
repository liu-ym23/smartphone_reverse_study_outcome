package com.larus.bmhome.video.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment", f = "AiGenVideoDetailFragment.kt", i = {1, 1, 2, 2, 3, 3}, l = {463, 476, 483, 489}, m = "addCreation", n = {"privateStatus", "buttonStatus", "privateStatus", "buttonStatus", "result", "privateStatus"}, s = {"I$0", "I$1", "I$0", "I$1", "L$0", "I$0"})
final class AiGenVideoDetailFragment$addCreation$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    public AiGenVideoDetailFragment$addCreation$1(AiGenVideoDetailFragment r1, Continuation<? super AiGenVideoDetailFragment$addCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AiGenVideoDetailFragment.ea0(this.this$0, this);
    }
}
