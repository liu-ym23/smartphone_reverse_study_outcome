package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class BufferedChannel$onReceiveOrNull$1 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, kotlinx.coroutines.selects.k<?>, Object, Unit> {
    public static final BufferedChannel$onReceiveOrNull$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$onReceiveOrNull$1();
    }

    BufferedChannel$onReceiveOrNull$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BufferedChannel<?> r10, kotlinx.coroutines.selects.k<?> r11, Object r12) {
        invoke2(r10, r11, r12);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BufferedChannel<?> r10, kotlinx.coroutines.selects.k<?> r11, Object r12) {
        BufferedChannel.C(r10, r11, r12);
    }
}
