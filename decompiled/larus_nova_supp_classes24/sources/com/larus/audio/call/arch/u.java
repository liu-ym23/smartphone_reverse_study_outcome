package com.larus.audio.call.arch;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u {
    public final Function0<CoroutineScope> a;
    public final Function0<CoroutineDispatcher> b;
    public final Function0<Boolean> c;
    public final MutexImpl d;

    public final CompletableDeferred a(LifecycleStage r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r12, "stage");
        Intrinsics.checkNotNullParameter(r13, "block");
        if (((Boolean) this.c.invoke()).booleanValue() == true) goto L5;
        CoroutineScope r1 = (CoroutineScope) this.a.invoke();
        if (r1 != null) goto L11;
        return CompletableDeferredKt.CompletableDeferred(new LLMCallController.b.a(r12, "MISSING_SCOPE", new IllegalStateException("lifecycleScope is null")));
    L11:
        if (CoroutineScopeKt.isActive(r1) == false) goto L13;
        final CompletableDeferred r0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt.launch$default(r1, (CoroutineContext) this.b.invoke(), null, new LLMCallLifecycleExecutor$enqueue$job$1(this, r0, r12, r13, null), 2, null).invokeOnCompletion(new t(r0));
        return r0;
    L13:
        return CompletableDeferredKt.CompletableDeferred(new LLMCallController.b.a(r12, "INACTIVE_SCOPE", new IllegalStateException("lifecycleScope is not active")));
    L5:
        return CompletableDeferredKt.CompletableDeferred(new LLMCallController.b.C0079b(r12, "TERMINATED"));
    }

    public u(q r2, g r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "scopeProvider");
        Intrinsics.checkNotNullParameter(r3, "dispatcherProvider");
        Intrinsics.checkNotNullParameter(r4, "isTerminatedProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = kotlinx.coroutines.sync.b.a();
    }
}
