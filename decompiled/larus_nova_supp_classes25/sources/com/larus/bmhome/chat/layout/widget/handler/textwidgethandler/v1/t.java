package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public t(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r3, Throwable r4) {
        FLogger.a.e("MarkdownTextViewWidgetHandlerV2", "handler exception：" + r4);
    }
}
