package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycle-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
    L3:
        LifecycleCoroutineScopeImpl r0 = (LifecycleCoroutineScopeImpl) ZeusTransformUtils.preCheckCast(r6.getInternalScopeRef().get(), LifecycleCoroutineScopeImpl.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = new LifecycleCoroutineScopeImpl(r6, cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        if (r6.getInternalScopeRef().compareAndSet(null, r0) == false) goto L3;
        r0.register();
    L6:
        return (LifecycleCoroutineScope) ZeusTransformUtils.preCheckCast(r0, LifecycleCoroutineScope.class, "com.obric.memorydata.plugin");
    }
}
