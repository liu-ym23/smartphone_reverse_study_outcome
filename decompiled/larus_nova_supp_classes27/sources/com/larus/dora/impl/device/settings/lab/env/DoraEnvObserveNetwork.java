package com.larus.dora.impl.device.settings.lab.env;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraEnvObserveNetwork {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new o());
    }

    public static void a() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraEnvObserveNetwork$fetchDeviceInfo$1(null), 3, null);
    }
}
