package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SafeCollectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function3<kotlinx.coroutines.flow.d<Object>, Object, Continuation<? super Unit>, Object> f10481a = null;

    static {
        SafeCollectorKt$emitFun$1 r10 = SafeCollectorKt$emitFun$1.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f10481a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3);
    }

    public static final /* synthetic */ Function3 a() {
        return f10481a;
    }
}
