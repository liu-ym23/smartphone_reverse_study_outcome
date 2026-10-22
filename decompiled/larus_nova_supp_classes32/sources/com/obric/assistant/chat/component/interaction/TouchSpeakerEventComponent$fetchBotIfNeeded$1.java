package com.obric.assistant.chat.component.interaction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.component.interaction.TouchSpeakerEventComponent", f = "TouchSpeakerEventComponent.kt", i = {}, l = {129}, m = "fetchBotIfNeeded", n = {}, s = {})
final class TouchSpeakerEventComponent$fetchBotIfNeeded$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TouchSpeakerEventComponent this$0;

    public TouchSpeakerEventComponent$fetchBotIfNeeded$1(TouchSpeakerEventComponent r1, Continuation<? super TouchSpeakerEventComponent$fetchBotIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return TouchSpeakerEventComponent.F2(this.this$0, this);
    }
}
