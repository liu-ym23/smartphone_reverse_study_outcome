package com.larus.audio.call.record;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public b(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r3, Throwable r4) {
        com.larus.audio.call.util.e.a.e("AVInnerRecordAdapter", "[dispatchScope] exception: " + r4.getMessage(), r4);
    }
}
