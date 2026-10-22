package com.obric.assistant.live.receiver;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements oga.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function0<Unit> b;

    @Override // oga.a
    public final void onDismissFailed() {
        FLogger.a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissFailed, action=" + this.a);
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissSucceeded, action=" + this.a);
        this.b.invoke();
    }

    public g(String r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
