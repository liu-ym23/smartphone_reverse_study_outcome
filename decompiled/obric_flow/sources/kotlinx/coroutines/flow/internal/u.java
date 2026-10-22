package kotlinx.coroutines.flow.internal;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3 f18884a = null;

    static {
        SafeCollectorKt$emitFun$1 r5 = SafeCollectorKt$emitFun$1.INSTANCE;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f18884a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 3);
    }
}
