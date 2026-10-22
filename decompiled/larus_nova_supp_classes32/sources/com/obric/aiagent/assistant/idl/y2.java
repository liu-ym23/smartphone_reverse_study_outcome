package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class y2 implements IBinder.DeathRecipient {
    public final /* synthetic */ IFlowOnAppStateChangedListenerIDL.Stub a;

    public /* synthetic */ y2(IFlowOnAppStateChangedListenerIDL.Stub r1) {
        this.a = r1;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IFlowOnAppStateChangedListenerIDL.Stub r0 = this.a;
        Map r1 = a3.a;
        monitor-enter(r1);
        r1.remove(r0.asBinder());     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
