package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository", f = "DoraGGestureSettingsRepository.kt", i = {}, l = {328}, m = "fetchConfigButtonLiveAI", n = {}, s = {})
public final class DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGGestureSettingsRepository this$0;

    public DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1(DoraGGestureSettingsRepository r1, Continuation<? super DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
