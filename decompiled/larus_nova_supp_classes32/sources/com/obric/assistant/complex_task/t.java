package com.obric.assistant.complex_task;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t {
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, Job> b;

    public t() {
        CoroutineScope r0 = CoroutineScopeKt.MainScope();
        Intrinsics.checkNotNullParameter(r0, "coroutineScope");
        this.a = r0;
        this.b = new ConcurrentHashMap();
    }
}
