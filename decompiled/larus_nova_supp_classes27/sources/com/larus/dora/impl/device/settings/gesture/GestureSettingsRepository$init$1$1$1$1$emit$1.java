package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository$init$1$1$1$1", f = "GestureSettingsRepository.kt", i = {}, l = {77}, m = "emit", n = {}, s = {})
public final class GestureSettingsRepository$init$1$1$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureSettingsRepository.init.1.1.1.1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public GestureSettingsRepository$init$1$1$1$1$emit$1(GestureSettingsRepository.init.1.1.1.1<? super T> r1, Continuation<? super GestureSettingsRepository$init$1$1$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(false, this);
    }
}
