package com.larus.dora.impl.device.settings.gesture.wakeup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository", f = "GestureWakeupRepository.kt", i = {}, l = {270, 271, 274, 275, 280, 281, 284, 285, 289, 290}, m = "updateQuickNoteWake", n = {}, s = {})
public final class GestureWakeupRepository$updateQuickNoteWake$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureWakeupRepository this$0;

    public GestureWakeupRepository$updateQuickNoteWake$1(GestureWakeupRepository r1, Continuation<? super GestureWakeupRepository$updateQuickNoteWake$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        GestureWakeupRepository r4 = this.this$0;
        GestureWakeupRepository r0 = GestureWakeupRepository.a;
        return r4.l(0, null, this);
    }
}
