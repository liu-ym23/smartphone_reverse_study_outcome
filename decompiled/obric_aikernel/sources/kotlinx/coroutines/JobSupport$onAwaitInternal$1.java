package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements Function3<c2, kotlinx.coroutines.selects.k<?>, Object, Unit> {
    public static final JobSupport$onAwaitInternal$1 INSTANCE = null;

    static {
        INSTANCE = new JobSupport$onAwaitInternal$1();
    }

    JobSupport$onAwaitInternal$1() {
        super(3, c2.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(c2 r10, kotlinx.coroutines.selects.k<?> r11, Object r12) {
        invoke2(r10, r11, r12);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c2 r10, kotlinx.coroutines.selects.k<?> r11, Object r12) {
        c2.T(r10, r11, r12);
    }
}
