package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository", f = "GestureSettingsRepository.kt", i = {}, l = {204, 205, 208, 209, 214, 215, 218, 219}, m = "updateQuickNote", n = {}, s = {})
public final class GestureSettingsRepository$updateQuickNote$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureSettingsRepository this$0;

    public GestureSettingsRepository$updateQuickNote$1(GestureSettingsRepository r1, Continuation<? super GestureSettingsRepository$updateQuickNote$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        GestureSettingsRepository r4 = this.this$0;
        GestureSettingsRepository r0 = GestureSettingsRepository.a;
        return r4.h(null, (byte) 0, this);
    }
}
