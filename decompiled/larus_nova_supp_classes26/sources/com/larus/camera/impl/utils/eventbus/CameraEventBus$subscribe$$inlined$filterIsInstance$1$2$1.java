package com.larus.camera.impl.utils.eventbus;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
@DebugMetadata(c = "com.larus.camera.impl.utils.eventbus.CameraEventBus$subscribe$$inlined$filterIsInstance$1$2", f = "CameraEventBus.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
public final class CameraEventBus$subscribe$$inlined$filterIsInstance$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public CameraEventBus$subscribe$$inlined$filterIsInstance$1$2$1(a r1, Continuation r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
