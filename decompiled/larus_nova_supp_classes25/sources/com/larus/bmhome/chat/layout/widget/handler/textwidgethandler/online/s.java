package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public s(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r3, Throwable r4) {
        FLogger.a.e("MarkdownTextViewWidgetHandler", "handler exception：" + r4);
    }
}
