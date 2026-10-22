package com.obric.assistant.live.receiver;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements oga.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // oga.a
    public final void onDismissFailed() {
        FLogger.a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissFailed, action=" + this.a + ",isDeviceLocked=" + this.b);
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.a.i("ObricLiveReceiver", "handleComplexTaskActionWithKeyguard: onDismissSucceeded, action=" + this.a + ",isDeviceLocked=" + this.b);
        this.c.invoke();
    }

    public f(String r1, boolean r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
