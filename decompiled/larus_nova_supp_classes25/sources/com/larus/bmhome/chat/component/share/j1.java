package com.larus.bmhome.chat.component.share;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public j1(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r3, Throwable r4) {
        FLogger.a.e("FileExportTypeChooseDialog", "error from coroutine, " + r4);
    }
}
