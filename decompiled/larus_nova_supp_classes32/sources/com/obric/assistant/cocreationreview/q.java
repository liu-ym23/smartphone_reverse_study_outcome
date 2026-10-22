package com.obric.assistant.cocreationreview;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q {
    public final CoroutineScope a;
    public final AtomicBoolean b;
    public final ConcurrentHashMap<String, AtomicBoolean> c;

    public q() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.b = new AtomicBoolean(false);
        this.c = new ConcurrentHashMap();
    }
}
