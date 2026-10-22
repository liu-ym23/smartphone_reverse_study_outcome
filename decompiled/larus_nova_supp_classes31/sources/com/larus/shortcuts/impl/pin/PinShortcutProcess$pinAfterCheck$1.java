package com.larus.shortcuts.impl.pin;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.shortcuts.impl.pin.PinShortcutProcess", f = "PinShortcutProcess.kt", i = {1}, l = {130, 132}, m = "pinAfterCheck", n = {"hasAdd"}, s = {"Z$0"})
final class PinShortcutProcess$pinAfterCheck$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PinShortcutProcess this$0;

    public PinShortcutProcess$pinAfterCheck$1(PinShortcutProcess r1, Continuation<? super PinShortcutProcess$pinAfterCheck$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return PinShortcutProcess.b(this.this$0, this);
    }
}
