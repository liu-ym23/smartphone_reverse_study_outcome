package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AbstractAccessibilityLibIsolation$currentCoroutineScope$2$a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public AbstractAccessibilityLibIsolation$currentCoroutineScope$2$a(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r10, Throwable r11) {
        if (("currentCoroutineScope exception " + r11.getMessage()) == null) goto L6;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    }
}
