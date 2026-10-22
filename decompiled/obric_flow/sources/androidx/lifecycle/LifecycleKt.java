package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycle-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
    L3:
        LifecycleCoroutineScopeImpl r10 = (LifecycleCoroutineScopeImpl) r5.getInternalScopeRef().get();
        if (r10 != null) goto L5;
        LifecycleCoroutineScopeImpl r11 = new LifecycleCoroutineScopeImpl(r5, CoroutineContext.Element.DefaultImpls.plus(j0.b(), Dispatchers.getMain().getImmediate()));
        AtomicReference<Object> r12 = r5.getInternalScopeRef();
    L8:
        if (r12.compareAndSet(null, r11) == true) goto L9;
        if (r12.get() == null) goto L8;
    L9:
        r11.register();
        return r11;
    L5:
        return r10;
    }
}
