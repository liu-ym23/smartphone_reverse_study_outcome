package jha;

import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j$a {
    public static c a(j r2) {
        ExecutorCoroutineDispatcher r0 = f.a;
        String r3 = r2.getClass().getName();
        Intrinsics.checkNotNullParameter(r3, "orderingDomain");
        return new c(TaskFlowDispatchStrategy.SHARED_SERIALIZED, r3);
    }
}
