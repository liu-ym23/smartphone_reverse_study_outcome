package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object a(f r3, h0 r4, List r5, ContinuationImpl r6) {
        return CoroutineScopeKt.coroutineScope(new CompletionDrivenDagResourceNodeOrchestrator$execute$2(r5, r3, r4, null), r6);
    }
}
