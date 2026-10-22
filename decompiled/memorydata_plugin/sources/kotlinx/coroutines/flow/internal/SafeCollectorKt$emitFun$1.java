package kotlinx.coroutines.flow.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements SuspendFunction, Function3<kotlinx.coroutines.flow.j<? super Object>, Object, Continuation<? super Unit>, Object> {
    public static final SafeCollectorKt$emitFun$1 INSTANCE = null;

    static {
        INSTANCE = new SafeCollectorKt$emitFun$1();
    }

    SafeCollectorKt$emitFun$1() {
        super(3, kotlinx.coroutines.flow.j.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super Object> r3, Object r4, Continuation<? super Unit> r5) {
        return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.j<Object> r2, Object r3, Continuation<? super Unit> r4) {
        return ((kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin")).emit(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
