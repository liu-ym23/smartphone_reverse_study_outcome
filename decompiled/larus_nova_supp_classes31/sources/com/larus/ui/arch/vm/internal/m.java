package com.larus.ui.arch.vm.internal;

import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m implements Lazy<CoroutineScope> {
    public a a;

    public m() {
    }

    public final Object getValue() {
        a r0 = this.a;
        if (r0 != null) goto L6;
        a r1 = new a(SupervisorKt.SupervisorJob$default(null, 1, null).plus(ExecutorsKt.from((Executor) j.a.getValue())));
        this.a = r1;
        return r1;
    L6:
        return r0;
    }

    public final boolean isInitialized() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }
}
