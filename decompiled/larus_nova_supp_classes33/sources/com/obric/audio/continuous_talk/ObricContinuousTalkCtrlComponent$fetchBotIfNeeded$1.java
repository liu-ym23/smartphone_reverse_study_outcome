package com.obric.audio.continuous_talk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkCtrlComponent", f = "ObricContinuousTalkCtrlComponent.kt", i = {}, l = {1077}, m = "fetchBotIfNeeded", n = {}, s = {})
final class ObricContinuousTalkCtrlComponent$fetchBotIfNeeded$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricContinuousTalkCtrlComponent this$0;

    public ObricContinuousTalkCtrlComponent$fetchBotIfNeeded$1(ObricContinuousTalkCtrlComponent r1, Continuation<? super ObricContinuousTalkCtrlComponent$fetchBotIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ObricContinuousTalkCtrlComponent.Y2(this.this$0, this);
    }
}
