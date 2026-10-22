package com.larus.bmhome.chat.component.title;

import com.bytedance.services.apm.api.EnsureManager;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public s1(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r1, Throwable r2) {
        EnsureManager.ensureNotReachHere(r2);
    }
}
