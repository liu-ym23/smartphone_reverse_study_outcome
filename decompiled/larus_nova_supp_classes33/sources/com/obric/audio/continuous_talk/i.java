package com.obric.audio.continuous_talk;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements hia.a.b {
    public Function1<? super Map<String, String>, Unit> a;
    public e b;
    public final AtomicBoolean c;
    public final HashMap<String, String> d;
    public final AtomicBoolean e;

    @Override // hia.a.b
    public final void b() {
        this.e.compareAndSet(false, true);
    }

    public i() {
        this.c = new AtomicBoolean(false);
        this.d = new HashMap();
        this.e = new AtomicBoolean(false);
    }

    @Override // hia.a.b
    public final CallbackFlowBuilder a(long r3) {
        return kotlinx.coroutines.flow.e.e(new ObricContinuousLLMContextProvider$collectContext$1(this, r3, null));
    }
}
