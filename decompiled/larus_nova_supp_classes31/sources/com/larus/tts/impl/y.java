package com.larus.tts.impl;

import com.larus.platform.service.g;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public y(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r1, Throwable r2) {
        g.a.ensureNotReachHere(r2);
    }
}
