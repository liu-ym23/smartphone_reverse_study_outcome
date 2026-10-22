package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
/* synthetic */ class LazyActorCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<LazyActorCoroutine<?>, kotlinx.coroutines.selects.k<?>, Object, Unit> {
    public static final LazyActorCoroutine$onSend$1 INSTANCE = null;

    static {
        INSTANCE = new LazyActorCoroutine$onSend$1();
    }

    LazyActorCoroutine$onSend$1() {
        super(3, LazyActorCoroutine.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyActorCoroutine<?> r10, kotlinx.coroutines.selects.k<?> r11, Object r12) {
        invoke2(r10, r11, r12);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LazyActorCoroutine<?> r10, kotlinx.coroutines.selects.k<?> r11, Object r12) {
        LazyActorCoroutine.l1(r10, r11, r12);
    }
}
