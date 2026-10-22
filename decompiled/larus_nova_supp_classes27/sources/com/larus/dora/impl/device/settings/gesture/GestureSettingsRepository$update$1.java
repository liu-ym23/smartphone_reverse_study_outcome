package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository", f = "GestureSettingsRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3}, l = {246, 138, 141, 157}, m = "update", n = {"key", "$this$withLock_u24default$iv", "value", "previousValue", "key", "$this$withLock_u24default$iv", "value", "previousValue", "key", "$this$withLock_u24default$iv", "value", "previousValue", "result", "ret", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "B$0", "B$1", "L$0", "L$1", "B$0", "B$1", "L$0", "L$1", "B$0", "B$1", "I$0", "I$1", "L$0"})
public final class GestureSettingsRepository$update$1 extends ContinuationImpl {
    byte B$0;
    byte B$1;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureSettingsRepository this$0;

    public GestureSettingsRepository$update$1(GestureSettingsRepository r1, Continuation<? super GestureSettingsRepository$update$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.update(null, (byte) 0, (byte) 0, this);
    }
}
