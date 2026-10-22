package com.larus.xbridge.custom;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public z(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r3, Throwable r4) {
        FLogger.a.e("AppSaveFileMethod", "error from coroutine, " + r4);
    }
}
