package com.obric.audio.continuous_talk.session.impl.plugin;

import com.larus.audio.call.plugins.RealtimeCallConnectTimeoutPlugin;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricContTalkConnectTimeoutPlugin extends RealtimeCallConnectTimeoutPlugin {
    public final com.larus.audio.call.mgr.f.a P2() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricContTalkConnectTimeoutPlugin$createCallStateObserver$1(this, null), 3, null);
        return null;
    }

    public ObricContTalkConnectTimeoutPlugin(com.larus.audio.call.arch.c r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
