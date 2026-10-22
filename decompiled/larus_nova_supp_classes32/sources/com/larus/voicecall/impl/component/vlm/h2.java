package com.larus.voicecall.impl.component.vlm;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h2 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ String a;
    public final /* synthetic */ RealtimeVideoComponent b;

    public final void handleException(CoroutineContext r3, Throwable r4) {
        FLogger.a.e("RealtimeVideoComponent", "request camera permission error, caller: " + this.a, r4);
        this.b.b1 = false;
    }

    public h2(CoroutineExceptionHandler.Key r1, String r2, RealtimeVideoComponent r3) {
        this.a = r2;
        this.b = r3;
        super(r1);
    }
}
