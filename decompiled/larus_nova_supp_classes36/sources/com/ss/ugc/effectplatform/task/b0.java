package com.ss.ugc.effectplatform.task;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0 extends BaseTask {
    public final Function0<Unit> g;

    public final void b() {
    }

    public final void a() {
        this.g.invoke();
    }

    public b0(String r2, Function0<Unit> r3) {
        super(r2, null);
        this.g = r3;
    }
}
