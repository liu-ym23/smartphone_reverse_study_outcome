package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
    L3:
        LifecycleCoroutineScopeImpl r11 = (LifecycleCoroutineScopeImpl) r10.getInternalScopeRef().get();
        if (r11 != null) goto L5;
        LifecycleCoroutineScopeImpl r12 = new LifecycleCoroutineScopeImpl(r10, q2.b(null, 1, null).plus(z0.c().c0()));
        if (r10.getInternalScopeRef().compareAndSet(null, r12) == false) goto L3;
        r12.register();
        return r12;
    L5:
        return r11;
    }
}
