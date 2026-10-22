package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class v implements IBinder.DeathRecipient {
    public final /* synthetic */ IAssistantInteractionListenerIDL.Stub a;

    public /* synthetic */ v(IAssistantInteractionListenerIDL.Stub r1) {
        this.a = r1;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IAssistantInteractionListenerIDL.Stub r0 = this.a;
        Map r1 = x.a;
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
