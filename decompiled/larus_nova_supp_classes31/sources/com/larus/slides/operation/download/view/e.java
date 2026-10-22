package com.larus.slides.operation.download.view;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public e(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r3, Throwable r4) {
        FLogger.a.e("SlidesExportChooseDialog", "error from coroutine, " + r4);
    }
}
