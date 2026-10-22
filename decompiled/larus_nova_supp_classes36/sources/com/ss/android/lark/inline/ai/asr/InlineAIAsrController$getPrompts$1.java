package com.ss.android.lark.inline.ai.asr;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.asr.InlineAIAsrController", f = "InlineAIAsrController.kt", i = {0, 0}, l = {532}, m = "getPrompts", n = {"$completion$iv", "startTimeMills"}, s = {"L$0", "J$0"})
public final class InlineAIAsrController$getPrompts$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InlineAIAsrController this$0;

    public InlineAIAsrController$getPrompts$1(InlineAIAsrController r1, Continuation<? super InlineAIAsrController$getPrompts$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return this.this$0.f(this);
    }
}
