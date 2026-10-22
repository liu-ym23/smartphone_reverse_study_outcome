package com.larus.dora.api;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class IDoraService$b {
    public static final /* synthetic */ IDoraService$b a = null;
    public static final CoroutineScope b = null;

    public IDoraService$b() {
    }

    static {
        a = new IDoraService$b();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }
}
